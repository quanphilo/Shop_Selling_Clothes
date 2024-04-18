package DTO;

import java.util.Vector;

public class SupplierDTO {
	private String id_supplier;
	private String name;
	private String address;

	public SupplierDTO() {
		super();
	}
	
	
	public SupplierDTO(String id_supplier) {
		super();
		this.id_supplier = id_supplier;
	}


	public SupplierDTO(String id_supplier, String name, String address) {
		super();
		this.id_supplier = id_supplier;
		this.name = name;
		this.address = address;
	}


	public String getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(String id_supplier) {
		this.id_supplier = id_supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name;
	}

}
