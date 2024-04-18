package BLL;

import java.util.Vector;

import Cores.Format;
import DAL.VoucherDAL;
import DTO.VoucherDTO;

public class VoucherBLL {
	VoucherDAL voucherDAL = new VoucherDAL();
	
	public Vector<VoucherDTO> getVouchers(){
		Vector<VoucherDTO> listVoucher = voucherDAL.getVouchers();
		return listVoucher;
	}
	
	public VoucherDTO getVoucherById(String id_voucher) {
		VoucherDTO voucherDTO = voucherDAL.getVoucherById(id_voucher);
		return voucherDTO;
	}
	
	public int insert(VoucherDTO voucherDTO) {
		if(voucherDTO.getCode().isBlank() ||
				String.valueOf(voucherDTO.getDiscountpercent()).isBlank() ||
				String.valueOf(voucherDTO.getStartdate()).isBlank() ||
				String.valueOf(voucherDTO.getEnddate()).isBlank()) {
			return 2;
		}
		
		int kq = voucherDAL.insert(voucherDTO);
		return kq;
	}
	
	public int update(VoucherDTO voucherDTO) {
		if(voucherDTO.getCode().isBlank() ||
				String.valueOf(voucherDTO.getDiscountpercent()).isBlank() ||
				String.valueOf(voucherDTO.getStartdate()).isBlank() ||
				String.valueOf(voucherDTO.getEnddate()).isBlank()) {
			return 2;
		}
		int kq = voucherDAL.update(voucherDTO);
		return kq;
	}
	
	public int delete(String id_voucher) {
		int kq = voucherDAL.delete(id_voucher);
		return kq;
	}
}
