package DTO;

import java.util.Date;

public class CustomerDTO extends PersonDTO {

	private Date createdate;
	private int point;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String id_customer) {
		super(id_customer);
	}

	public CustomerDTO(String id_customer,  String fullname, String email, String address, String phone, Date createdate,int point) {
		super(id_customer, fullname, email, address, phone);
		this.createdate = createdate;
		this.point = point;
	}


	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	

}
