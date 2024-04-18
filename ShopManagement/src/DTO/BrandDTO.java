package DTO;

import java.util.Vector;

public class BrandDTO {
	private String id_brand;
	private String name;
	private Vector<ProductDTO> products;

	public BrandDTO() {
		super();
	}
	
	public BrandDTO(String id_brand) {
		this.id_brand = id_brand;
	}
	public BrandDTO(String id_brand, String name) {
		super();
		this.id_brand = id_brand;
		this.name = name;
	}


	public BrandDTO(String id_brand, String name, Vector<ProductDTO> products) {
		this.id_brand = id_brand;
		this.name = name;
		this.products = products;
	}

	

	public Vector<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(Vector<ProductDTO> products) {
		this.products = products;
	}

	public String getId_brand() {
		return id_brand;
	}
	public void setId_brand(String id_brand) {
		this.id_brand = id_brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
