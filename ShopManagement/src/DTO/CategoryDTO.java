package DTO;

import java.util.Vector;

public class CategoryDTO {
	private String id_category;
	private String name;
	private Vector<CategoryChildDTO> categorychild;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(String id_category) {
		super();
		this.id_category = id_category;
	}


	public CategoryDTO(String id_category, String name) {
		super();
		this.id_category = id_category;
		this.name = name;
	}

	public CategoryDTO(String id_category, String name, Vector<CategoryChildDTO> categorychild) {
		super();
		this.id_category = id_category;
		this.name = name;
		this.categorychild = categorychild;
	}

	public String getId_category() {
		return id_category;
	}

	public void setId_category(String id_category) {
		this.id_category = id_category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<CategoryChildDTO> getCategorychild() {
		return categorychild;
	}

	public void setCategorychild(Vector<CategoryChildDTO> categorychild) {
		this.categorychild = categorychild;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
