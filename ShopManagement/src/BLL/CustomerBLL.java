package BLL;

import java.util.Vector;

import Cores.Format;
import Cores.ReadWriteFile;
import DAL.CustomerDAL;
import DTO.CustomerDTO;

public class CustomerBLL {
	CustomerDAL customerDAL = new CustomerDAL();
	ReadWriteFile readWriteFile = new ReadWriteFile();
	
	public Vector<CustomerDTO> getCustomers() {
		Vector<CustomerDTO> listCustomer  = customerDAL.getCustomers();
		return listCustomer;
	}

	public Vector<CustomerDTO> getCustomersByFilter(String filter) {
		Vector<CustomerDTO> listCustomer  = customerDAL.getCustomersByFilter(filter);
		return listCustomer;
	}

	public CustomerDTO getCustomerById(String id_customer) {
		CustomerDTO customerDTO = customerDAL.getCustomerById(id_customer);
		return customerDTO;
	}
	
	
	//updating ...
	public Vector<CustomerDTO> getCustomerOfMonth(int MONTH) {
		return customerDAL.getCustomerOfMonth(MONTH);
	}


	public int insert(CustomerDTO customerDTO) {
		if(customerDTO.getFullname().isBlank() || 
				customerDTO.getEmail().isBlank() || 
				customerDTO.getAddress().isBlank() ||
				customerDTO.getPhone().isBlank() ||
				String.valueOf(customerDTO.getCreatedate()).isBlank() ||
				String.valueOf(customerDTO.getPoint()).isBlank()) {
			return 2;
		}
		if(Format.isNumber(customerDTO.getPhone()) == 0 && 
				Format.checkLength(customerDTO.getPhone(), 10) == 0 &&
				Format.checkLength(customerDTO.getPhone(), 10) == 0) {
			return 4;
		}
		
		
		int kq = customerDAL.insert(customerDTO);
		return kq;
	}
	
	public int update(CustomerDTO customerDTO) {
		if(customerDTO.getFullname().isBlank() || 
				customerDTO.getEmail().isBlank() || 
				customerDTO.getAddress().isBlank() ||
				customerDTO.getPhone().isBlank() ||
				String.valueOf(customerDTO.getCreatedate()).isBlank() ||
				String.valueOf(customerDTO.getPoint()).isBlank()) {
			return 2;
		}
		if(Format.isNumber(customerDTO.getPhone()) == 0 && 
				Format.checkLength(customerDTO.getPhone(), 10) == 0 &&
				Format.checkLength(customerDTO.getPhone(), 10) == 0) {
			return 4;
		}
		int kq = customerDAL.update(customerDTO);
		return kq;
	}
        
	// Phương thức tìm kiếm khách hàng theo tên
        public Vector<CustomerDTO> searchCustomersByName(String name) {
                Vector<CustomerDTO> listCustomer  = customerDAL.getCustomers(); 
                Vector<CustomerDTO> searchResult = new Vector<>();

                for (CustomerDTO customer : listCustomer) {
                    if (customer.getFullname().toLowerCase().contains(name.toLowerCase())) {
                        searchResult.add(customer);
                    }
                }

                return searchResult;
            }
	// public int delete(String id_customer) {
	// 	int kq = customerDAL.delete(id_customer);
	// 	return kq;
	// }
	
	public int  writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header) {
		return readWriteFile.writeExcel(listObjectData, header);
	}

	public int updatePoint(CustomerDTO customerDTO) {
		return customerDAL.updatePoint(customerDTO);
	}

	
}
