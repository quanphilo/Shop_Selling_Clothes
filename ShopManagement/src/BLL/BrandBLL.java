package BLL;

import java.util.Vector;

import DAL.BrandDAL;
import DTO.BrandDTO;

public class BrandBLL {
	BrandDAL brandDAL = new BrandDAL();
	
	public Vector<BrandDTO> getBrands() {
		Vector<BrandDTO> listBrand = brandDAL.getBrands();
		return listBrand;
	}
	
	public BrandDTO getBrandById(String id_brand) {
		BrandDTO brandDTO = brandDAL.getBrandById(id_brand);
		return brandDTO;
	}
	
	public int insert(BrandDTO brandDTO) { 
		int kq = brandDAL.insert(brandDTO);
		return kq;
	}
	
	public int update(BrandDTO brandDTO) {
		int kq = brandDAL.update(brandDTO);
		return kq;
	}
	
	public int delete(String id_brand) {
		int kq = brandDAL.delete(id_brand);
		return kq;
	}
}
