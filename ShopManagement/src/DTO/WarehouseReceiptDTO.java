package DTO;

import java.util.Date;

public class WarehouseReceiptDTO {
	private String id_warehousereceipt;
	private SupplierDTO supplier;
	private EmployeeDTO employee;
	private Date date;
	private float totalprice;

	public WarehouseReceiptDTO() {
		super();
	}

	public WarehouseReceiptDTO(String id_warehousereceipt) {
		super();
		this.id_warehousereceipt = id_warehousereceipt;
	}

	public WarehouseReceiptDTO(String id_warehousereceipt, SupplierDTO supplier, EmployeeDTO employee, Date date,
			float totalprice) {
		super();
		this.id_warehousereceipt = id_warehousereceipt;
		this.supplier = supplier;
		this.employee = employee;
		this.date = date;
		this.totalprice = totalprice;
	}

	public String getId_warehousereceipt() {
		return id_warehousereceipt;
	}

	public void setId_warehousereceipt(String id_warehousereceipt) {
		this.id_warehousereceipt = id_warehousereceipt;
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
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

	public float getTotalPrice() {
		return totalprice;
	}

	public void setTotalPrice(float totalprice) {
		this.totalprice = totalprice;
	}

}
