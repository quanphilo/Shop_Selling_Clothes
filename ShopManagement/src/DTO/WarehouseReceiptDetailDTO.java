package DTO;

public class WarehouseReceiptDetailDTO {
	private WarehouseReceiptDTO warehouseReceipt;
	private ProductDTO product;
	private int amount;
	private float price;

	public WarehouseReceiptDetailDTO(WarehouseReceiptDTO warehouseReceipt, ProductDTO product, int amount,
			float price) {
		super();
		this.warehouseReceipt = warehouseReceipt;
		this.product = product;
		this.amount = amount;
		this.price = price;
	}

	public WarehouseReceiptDetailDTO(WarehouseReceiptDTO warehouseReceipt, ProductDTO product) {
		super();
		this.warehouseReceipt = warehouseReceipt;
		this.product = product;
	}

	public WarehouseReceiptDetailDTO() {
		super();
	}

	public WarehouseReceiptDTO getWarehouseReceipt() {
		return warehouseReceipt;
	}

	public void setWarehouseReceipt(WarehouseReceiptDTO warehouseReceipt) {
		this.warehouseReceipt = warehouseReceipt;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	

}
