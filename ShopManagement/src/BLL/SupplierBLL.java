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
	
	public int delete(String id_supplier) {
		int kq = supplierDAL.delete(id_supplier);
		return kq;
	}

        public Vector<SupplierDTO> searchSuppliersByName(String searchText) {
            if (searchText == null || searchText.isBlank()) {
                return new Vector<SupplierDTO>(); // Return empty list if search text is null or blank
            }
            return supplierDAL.searchSuppliersByName(searchText.trim()); // Trim the search text to avoid leading/trailing spaces
        }
    }
