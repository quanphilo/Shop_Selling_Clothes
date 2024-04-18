package DTO;

public  class PersonDTO {
    protected String id;
	protected String fullname;
	protected String email;
	protected String address;
	protected String phone;
	
	
	public PersonDTO() {
		super();
	}
	
	
	public PersonDTO(String id) {
		super();
		this.id = id;
	}

	public PersonDTO(String id, String fullname, String email, String address, String phone) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
