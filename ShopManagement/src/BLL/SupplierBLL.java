package BLL;

import java.util.Vector;

import DAL.SupplierDAL;
import DTO.SupplierDTO;

public class SupplierBLL {
	SupplierDAL supplierDAL = new SupplierDAL();
	
	public Vector<SupplierDTO> getSuppliers() {
		Vector<SupplierDTO> listSupplier = supplierDAL.getSuppliers();
		return listSupplier;
	}
	
	public SupplierDTO getSupplierById(String id_supplier) {
		SupplierDTO supplierDTO = supplierDAL.getSupplierById(id_supplier);
		return supplierDTO;
	}
	
	public int insert(SupplierDTO supplierDTO) {
		if(supplierDTO.getAddress().isBlank() || supplierDTO.getName().isBlank()) {
			return 2;
		}
		int kq = supplierDAL.insert(supplierDTO);
		return kq;
	}
	
	public int update(SupplierDTO supplierDTO) {
		if(supplierDTO.getAddress().isBlank() || supplierDTO.getName().isBlank()) {
			return 2;
		}
		int kq = supplierDAL.update(supplierDTO);
		return kq;
	}
	
        public int delete(String supplierId, int status) {
                return supplierDAL.delete(supplierId, status);
        }

        public Vector<SupplierDTO> searchSuppliers(String searchText) {
            if (searchText == null || searchText.isBlank()) {
                return new Vector<SupplierDTO>(); 
            }
            return supplierDAL.searchSuppliers(searchText.trim()); 
        }
    }
