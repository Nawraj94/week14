package pet.store.controller.error;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
@Slf4j
public class GlobalControllerErrorHandler {

    private enum LogStatus {
        STACK_TRACK, MESSAGE_ONLY
    }

    @Data
    private static class ExceptionMessage {
        public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getStatusReason() {
			return statusReason;
		}
		public void setStatusReason(String statusReason) {
			this.statusReason = statusReason;
		}
		public int getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		private String message;
        private String statusReason;
        private int statusCode;
        private String timestamp;
        private String uri;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ExceptionMessage handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {
        return buildExceptionMessage(ex, HttpStatus.NOT_FOUND, webRequest, LogStatus.MESSAGE_ONLY);

    }

    private ExceptionMessage buildExceptionMessage(Exception ex, HttpStatus status, WebRequest webRequest, LogStatus logStatus) {
        String message = ex.toString();
        String statusReason = status.getReasonPhrase();
        String uri = null;
        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);

        if (webRequest instanceof ServletWebRequest) {
            ServletWebRequest swr = (ServletWebRequest) webRequest;
       
            uri=swr.getRequest().getRequestURI();
        }
       
       final Logger log = LoggerFactory.getLogger(GlobalControllerErrorHandler.class);
        if (logStatus == LogStatus.MESSAGE_ONLY) {
            log.error("Exception: {}", ex.toString());
        } else {
           
            log.error("Exception",ex);
        }
        
        
        ExceptionMessage excMag = new ExceptionMessage();
       
        excMag.setMessage(message);
        excMag.setStatusCode(status.value());
        excMag.setStatusReason(statusReason);
        excMag.setTimestamp(timestamp);
        excMag.setUri(uri);

        return excMag;


    }
}
