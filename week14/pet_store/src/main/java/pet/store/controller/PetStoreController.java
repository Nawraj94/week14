package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pet.store.controller.error.GlobalControllerErrorHandler;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
    final Logger log = LoggerFactory.getLogger(PetStoreController.class);
    @Autowired
    private PetStoreService petStoreService;

    @PostMapping("/pet_store")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<PetStoreData> findOrCreatePetStore(@RequestBody PetStoreData petStoreData) {
        log.info("Creating pet store {}", petStoreData);
        PetStoreData savedPetStore = petStoreService.savePetStore(petStoreData);
        return new ResponseEntity<>(savedPetStore, HttpStatus.CREATED);
    }

    @PutMapping("/pet_store/{petStoreId}")
    public ResponseEntity<PetStoreData> updatePetStore(@PathVariable Long petStoreId,
                                                       @RequestBody PetStoreData petStoreData) {
        petStoreData.setPetStoreId(petStoreId);
        log.info("Updating pet store {}", petStoreData);
        PetStoreData updatedPetStore = petStoreService.savePetStore(petStoreData);
        return new ResponseEntity<>(updatedPetStore, HttpStatus.OK);
    }
}
