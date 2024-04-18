package DTO;

public class ProductDTO {
	private String id_product;
	private BrandDTO brand;
	private CategoryChildDTO categorychild;
	private String name;
	private int quantity;
	private float price;
	private String image;
	private int status;

	public ProductDTO() {
		super();
	}

	public ProductDTO(String id_product) {
		this.id_product = id_product;
	}

	

	public ProductDTO(String id_product, BrandDTO brand, CategoryChildDTO categorychild, String name, int quantity,
			float price, String image, int status) {
		this.id_product = id_product;
		this.brand = brand;
		this.categorychild = categorychild;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.status = status;
	}

	


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public CategoryChildDTO getCategorychild() {
		return categorychild;
	}

	public void setCategorychild(CategoryChildDTO categorychild) {
		this.categorychild = categorychild;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductDTO [brand=" + brand + ", categorychild=" + categorychild + ", id_product=" + id_product
				+ ", image=" + image + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", status="
				+ status + "]";
	}

	
}
	
