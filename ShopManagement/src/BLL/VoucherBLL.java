package BLL;

import java.util.*;

import Cores.Format;
import DAL.VoucherDAL;
import DTO.VoucherDTO;

public class VoucherBLL {
	VoucherDAL voucherDAL = new VoucherDAL();
	
        public Vector<VoucherDTO> getVouchers() {
            Vector<VoucherDTO> allVouchers = voucherDAL.getVouchers();
            Vector<VoucherDTO> validVouchers = new Vector<>();
            Date currentDate = new Date();
            for (VoucherDTO voucher : allVouchers) {
                if (voucher.getEnddate().after(currentDate) || voucher.getEnddate().equals(currentDate)) {
                    validVouchers.add(voucher);
                }
            }
            return validVouchers;
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
	public int delete(String voucherId, int status) {
                return voucherDAL.delete(voucherId, status);
        }
        
        public Vector<VoucherDTO> getValidVouchers() {
            Vector<VoucherDTO> allVouchers = voucherDAL.getVouchers();
            Vector<VoucherDTO> validVouchers = new Vector<>();

            Calendar currentCal = Calendar.getInstance();
            currentCal.set(Calendar.HOUR_OF_DAY, 0);
            currentCal.set(Calendar.MINUTE, 0);
            currentCal.set(Calendar.SECOND, 0);
            currentCal.set(Calendar.MILLISECOND, 0);
            Date currentDate = currentCal.getTime();

            for (VoucherDTO voucher : allVouchers) {
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(voucher.getEnddate());
                endCal.set(Calendar.HOUR_OF_DAY, 23);
                endCal.set(Calendar.MINUTE, 59);
                endCal.set(Calendar.SECOND, 59);
                Date endDate = endCal.getTime();

                if (!currentDate.after(endDate)) {
                    validVouchers.add(voucher);
                }
            }
            return validVouchers;
        }
}
