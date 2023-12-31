package pet.store.entity;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petStoreId;
    private String petStoreName;
    private String petStoreAddress;
    private String petStoreCity;
    private String petStoreState;
    private String petStoreZip;
    private String petStorePhone;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

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

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

  
}
