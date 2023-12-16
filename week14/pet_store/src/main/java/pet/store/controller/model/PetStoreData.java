package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.PetStore;
import pet.store.entity.Customer;
import pet.store.entity.Employee;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class PetStoreData {

    private Long petStoreId;
    private String petStoreName;
    private String petStoreAddress;
    private String petStoreCity;
    private String petStoreState;
    public Long getPetStoreId() {
		return petStoreId;
	}

	public void setPetStoreId(Long petStoreId) {
		this.petStoreId = petStoreId;
	}

	public String getPetStoreName() {
		return petStoreName;
	}

	public void setPetStoreName(String petStoreName) {
		this.petStoreName = petStoreName;
	}

	public String getPetStoreAddress() {
		return petStoreAddress;
	}

	public void setPetStoreAddress(String petStoreAddress) {
		this.petStoreAddress = petStoreAddress;
	}

	public String getPetStoreCity() {
		return petStoreCity;
	}

	public void setPetStoreCity(String petStoreCity) {
		this.petStoreCity = petStoreCity;
	}

	public String getPetStoreState() {
		return petStoreState;
	}

	public void setPetStoreState(String petStoreState) {
		this.petStoreState = petStoreState;
	}

	public String getPetStoreZip() {
		return petStoreZip;
	}

	public void setPetStoreZip(String petStoreZip) {
		this.petStoreZip = petStoreZip;
	}

	public String getPetStorePhone() {
		return petStorePhone;
	}

	public void setPetStorePhone(String petStorePhone) {
		this.petStorePhone = petStorePhone;
	}

	public Set<PetStoreCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<PetStoreCustomer> customers) {
		this.customers = customers;
	}

	public Set<PetStoreEmployee> getEmployees() {
		return employees;
	}
   public void setEmployees(Set<PetStoreEmployee>employees) {
	   this.employees=employees;
   }
	

	private String petStoreZip;
    private String petStorePhone;
    private Set<PetStoreCustomer> customers = new HashSet<>();
    private Set<PetStoreEmployee> employees = new HashSet<>();

    public PetStoreData(PetStore petStore) {
        petStoreId = petStore.getPetStoreId();
        petStoreName = petStore.getPetStoreName();
        petStoreAddress = petStore.getPetStoreAddress();
        petStoreCity = petStore.getPetStoreCity();
        petStoreState = petStore.getPetStoreState();
        petStoreZip = petStore.getPetStoreZip();
        petStorePhone = petStore.getPetStorePhone();

        for (Customer customer : petStore.getCustomers()) {
            PetStoreCustomer petStoreCustomer = new PetStoreCustomer(customer);
            customers.add(petStoreCustomer);
        }

        for (Employee employee : petStore.getEmployees()) {
            PetStoreEmployee petStoreEmployee = new PetStoreEmployee(employee);
            employees.add(petStoreEmployee);
        }
    }

    @Data
    @NoArgsConstructor
    public static class PetStoreEmployee {

        private long employeeId;
        private String employeeFirstName;
        private String employeeLastName;
        private String employeePhone;
        private String employeeJobTitle;

        public PetStoreEmployee(Employee employee) {
            employeeId = employee.getEmployeeId();
            employeeFirstName = employee.getEmployeeFirstName();
            employeeLastName = employee.getEmployeeLastName();
            employeePhone = employee.getEmployeePhone();
            employeeJobTitle = employee.getEmployeeJobTitle();
        }
    }

    @Data
    @NoArgsConstructor
    public static class PetStoreCustomer {

        private long customerId;
        private String customerFirstName;
        private String customerLastName;
        private String customerEmail;

        public PetStoreCustomer(Customer customer) {
            customerId = customer.getCustomerId();
            customerFirstName = customer.getCustomerFirstName();
            customerLastName = customer.getCustomerLastName();
            customerEmail = customer.getCustomerEmail();
        }
    }
}
