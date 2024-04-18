package BLL;

import java.util.Vector;

import Cores.Format;
import Cores.ReadWriteFile;
import DAL.EmployeeDAL;
import DTO.EmployeeDTO;

public class EmployeeBLL {
	EmployeeDAL employeeDAL = new EmployeeDAL();
	ReadWriteFile readWriteFile = new ReadWriteFile();
	
	public Vector<EmployeeDTO> getEmployees() {
		Vector<EmployeeDTO> listEmployee = employeeDAL.getEmployees();
		return listEmployee;
	}

	public Vector<EmployeeDTO> getEmployeesByFilter(String filter) {
		Vector<EmployeeDTO> listEmployee = employeeDAL.getEmployeesByFilter(filter);
		return listEmployee;
	}
	
	public EmployeeDTO getEmployeeById(String id_employee) {
		EmployeeDTO employeeDTO = employeeDAL.getEmployeeById(id_employee);
		return employeeDTO;
	}
	
	public int insert(EmployeeDTO employeeDTO) {
		// Duyệt trường thông tin có rỗng hay không
		if (employeeDTO.getFullname().isBlank() ||
				employeeDTO.getEmail().isBlank() ||
				employeeDTO.getAddress().isBlank() ||
				employeeDTO.getPositionDTO().getId_positions().isBlank() ||
				employeeDTO.getGender().isBlank() ||
				String.valueOf(employeeDTO.getBirthday()).isBlank() ||
				employeeDTO.getPhone().isBlank() ||
				employeeDTO.getCmnd().isBlank()
				
				) 
		{
			return 2;
		}
		// 
		int kq = employeeDAL.insert(employeeDTO);
		return kq;
	}
//	
	public int update(EmployeeDTO employeeDTO) {
		// Duyệt trường thông tin có rỗng hay không
				if (employeeDTO.getFullname().isBlank() ||
						employeeDTO.getEmail().isBlank() ||
						employeeDTO.getAddress().isBlank() ||
						employeeDTO.getPositionDTO().getId_positions().isBlank() ||
						employeeDTO.getGender().isBlank() ||
						String.valueOf(employeeDTO.getBirthday()).isBlank() ||
						employeeDTO.getPhone().isBlank() ||
						employeeDTO.getCmnd().isBlank()
						
						) 
				{
					return 2;
				}
				// Duyệt trường thông tin có đúng định dạng hay không
				if (Format.isNumber(employeeDTO.getCmnd()) == 0  && Format.checkLength(employeeDTO.getCmnd(), 9) == 0) {
					return 3;
				}
				if(Format.isNumber(employeeDTO.getPhone()) == 0 &&
					Format.checkLength(employeeDTO.getPhone(), 10) == 0 &&
					Format.checkLength(employeeDTO.getPhone(), 10) == 0) {
					return 4;
				}
		int kq = employeeDAL.update(employeeDTO);
		return kq;
	}
	
	// public int delete(String id_employee) {
	// 	int kq = employeeDAL.delete(id_employee);
	// 	return kq;
	// }
	public int  writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header) {
		return readWriteFile.writeExcel(listObjectData, header);
	}
}
