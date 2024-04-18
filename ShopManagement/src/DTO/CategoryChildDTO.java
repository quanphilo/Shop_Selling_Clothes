package DTO;

public class CategoryChildDTO {
	private String id_categorychild;
	private CategoryDTO category;
	private String name;

	public CategoryChildDTO() {
		super();
	}

	public CategoryChildDTO(String id_categorychild) {
		super();
		this.id_categorychild = id_categorychild;
	}

	public CategoryChildDTO(String id_categorychild, String name) {
		super();
		this.id_categorychild = id_categorychild;
		this.name = name;
	}

	public CategoryChildDTO(String id_categorychild, CategoryDTO category, String name) {
		super();
		this.id_categorychild = id_categorychild;
		this.category = category;
		this.name = name;
	}

	public String getId_categorychild() {
		return id_categorychild;
	}

	public void setId_categorychild(String id_categorychild) {
		this.id_categorychild = id_categorychild;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
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
