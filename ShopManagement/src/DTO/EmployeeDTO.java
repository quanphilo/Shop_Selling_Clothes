package DTO;

import java.util.Date;

public class EmployeeDTO extends PersonDTO{
	private AccountDTO account;
	private String image;
	private String cmnd;
	private Date birthday;
	private PositionDTO positionDTO;
	private String gender;

	public EmployeeDTO() {
		super();
	}


	public EmployeeDTO(String id_employee) {
		super(id_employee);
	}

	public EmployeeDTO(String id_employee, AccountDTO account, String fullname, Date birthday,String address, String phone,
			String email, String image, String cmnd, PositionDTO positionDTO) {
		super(id_employee, fullname, email, address, phone);
		this.account = account;
		this.birthday = birthday;
		this.image = image;
		this.cmnd = cmnd;
		this.positionDTO = positionDTO;
	}

	public EmployeeDTO(String id_employee, PositionDTO positionDTO, String fullname, 
		String gender,
		Date birthday,String address, String phone,
		String email, String image, String cmnd ) 
	{
		super(id_employee, fullname, email, address, phone);
		this.positionDTO = positionDTO;
		this.gender = gender;
		this.cmnd = cmnd;
		this.image = image;
		this.birthday = birthday;
		this.email = email;
	}

	public PositionDTO getPositionDTO() {
		return positionDTO;
	}

	

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setPositionDTO(PositionDTO positionDTO) {
		this.positionDTO = positionDTO;
	}
	

	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

}
