package DTO;

import java.util.Date;

public class ProductSaleDTO {
	private ProductDTO product;
	private float discountPercent;
	private Date startdate;
	private Date enddate;

	public ProductSaleDTO() {
		super();
	}

	public ProductSaleDTO(ProductDTO product, float discountPercent, Date startdate, Date enddate) {
		super();
		this.product = product;
		this.discountPercent = discountPercent;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public ProductDTO getProduct() {
		return product;
	}
	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

}
