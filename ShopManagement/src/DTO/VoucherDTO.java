package DTO;

import java.util.Date;

public class VoucherDTO {
	private String id_voucher;
	private String code;
	private float discountpercent;
	private Date startdate;
	private Date enddate;

	public VoucherDTO() {
		super();
	}

	public VoucherDTO(String id_voucher) {
		this.id_voucher = id_voucher;
	}

	public VoucherDTO(String id_voucher, String code, float discountpercent, Date startdate, Date enddate) {
		super();
		this.id_voucher = id_voucher;
		this.code = code;
		this.discountpercent = discountpercent;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public String getId_voucher() {
		return id_voucher;
	}

	public void setId_voucher(String id_voucher) {
		this.id_voucher = id_voucher;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getDiscountpercent() {
		return discountpercent;
	}

	public void setDiscountpercent(float discountpercent) {
		this.discountpercent = discountpercent;
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

	@Override
	public String toString() {
		return code;
	}

}

