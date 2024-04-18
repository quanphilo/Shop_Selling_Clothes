package DTO;

import java.util.Date;

public class OrderDTO {
	private String id_order;
	private CustomerDTO customer;
	private float totalprice;
	private VoucherDTO voucher;
	private EmployeeDTO employee;
	private Date date;


	public OrderDTO() {
		super();
	}
	
	public OrderDTO(String id_order) {
		super();
		this.id_order = id_order;
	}

	public OrderDTO(String id_order, CustomerDTO customer, float totalprice, VoucherDTO voucher, EmployeeDTO employee, Date date) {
		super();
		this.id_order = id_order;
		this.customer = customer;
		this.totalprice = totalprice;
		this.voucher = voucher;
		this.employee = employee;
		this.date = date;
	}

	public String getId_order() {
		return id_order;
	}

	public void setId_order(String id_order) {
		this.id_order = id_order;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	

	public VoucherDTO getVoucher() {
		return voucher;
	}

	public void setVoucher(VoucherDTO voucher) {
		this.voucher = voucher;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
