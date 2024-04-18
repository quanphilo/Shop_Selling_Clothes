package DAL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

import DTO.AccountDTO;
import DTO.EmployeeDTO;
import DTO.PositionDTO;

public class EmployeeDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Vector<EmployeeDTO> getEmployees() {
		Vector<EmployeeDTO> listEmployee = new Vector<EmployeeDTO>();
		try {
			String sql = "SELECT * FROM tbl_employee";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs= pstm.executeQuery();
			while (rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO(
						rs.getString("id_employee"),
						new PositionDTO(rs.getString("id_position")),
						 rs.getString("fullname"),
						 rs.getString("gender"),
						 rs.getDate("birthday"),
						 rs.getString("address"), 
						 rs.getString("phone"), rs.getString("email"),
						rs.getString("image"), rs.getString("cmnd")			
						);				
				listEmployee.add(employeeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listEmployee;
	}

	public Vector<EmployeeDTO> getEmployeesByFilter(String filter) {
		Vector<EmployeeDTO> listEmployee = new Vector<EmployeeDTO>();
		try {
			String sql = "SELECT * FROM tbl_employee WHERE `id_employee` LIKE '%" + filter + "%' OR `fullname` LIKE '%" + filter + "%' OR `gender` LIKE '%" + filter + "%' OR `address` LIKE '%" + filter + "%' OR `phone` LIKE '%" + filter + "%' OR `cmnd` LIKE '%" + filter + "%' OR `email` LIKE '%" + filter + "%'";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs= pstm.executeQuery();
			while (rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO(
						rs.getString("id_employee"),
						new PositionDTO(rs.getString("id_position")),
						 rs.getString("fullname"),
						 rs.getString("gender"),
						 rs.getDate("birthday"),
						 rs.getString("address"), 
						 rs.getString("phone"), rs.getString("email"),
						rs.getString("image"), rs.getString("cmnd")			
						);				
				listEmployee.add(employeeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listEmployee;
	}
	
	public EmployeeDTO getEmployeeById(String id_employee) {
		EmployeeDTO employeeDTO = null;
		try {
			String sql = "SELECT * FROM tbl_employee WHERE id_employee = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_employee);
			rs = pstm.executeQuery();
			if (rs.next()) {
				employeeDTO = new EmployeeDTO(
						rs.getString("id_employee"),
						new PositionDTO(rs.getString("id_position")),
						 rs.getString("fullname"),rs.getString("gender"),
						 rs.getDate("birthday") ,rs.getString("address"), rs.getString("phone"), rs.getString("email"),
						rs.getString("image"), rs.getString("cmnd")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return employeeDTO;
	}
	
	public int insert(EmployeeDTO employeeDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_employee(`id_employee`, `id_position`,`fullname`,`gender`,`birthday`,`address`,`phone`,`email`,`image`, `cmnd`)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, employeeDTO.getId());
			pstm.setString(2, employeeDTO.getPositionDTO().getId_positions());
			pstm.setString(3, employeeDTO.getFullname());
			pstm.setString(4, employeeDTO.getGender());
			pstm.setString(5, sdf.format(employeeDTO.getBirthday()));
			pstm.setString(6, employeeDTO.getAddress());
			pstm.setString(7, employeeDTO.getPhone());
			pstm.setString(8, employeeDTO.getEmail());
			pstm.setString(9, employeeDTO.getImage());
			pstm.setString(10, employeeDTO.getCmnd());
			
			kq = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return  kq;
	}
	
	
	public int update(EmployeeDTO employeeDTO) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_employee SET id_position = ?, fullname = ?, gender = ?,birthday = ? ,address = ?, phone = ?, email = ?, image = ?, cmnd = ? WHERE id_employee = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, employeeDTO.getPositionDTO().getId_positions());
			pstm.setString(2, employeeDTO.getFullname());
			pstm.setString(3, employeeDTO.getGender());
			pstm.setString(4, sdf.format(employeeDTO.getBirthday()));
			pstm.setString(5, employeeDTO.getAddress());
			pstm.setString(6, employeeDTO.getPhone());
			pstm.setString(7, employeeDTO.getEmail());
			pstm.setString(8, employeeDTO.getImage());
			pstm.setString(9, employeeDTO.getCmnd());
			pstm.setString(10, employeeDTO.getId());
			
			kq = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kq;
	}
	
	// public int delete(String id_employee) {
	// 	int kq = 0;
	// 	try {
	// 		String sql = "DELETE FROM tbl_employee WHERE `id_employee` = ?";
	// 		conn = JDBCUtil.getConnection();
	// 		pstm = conn.prepareStatement(sql);
	// 		pstm.setString(1, id_employee);
	// 		kq = pstm.executeUpdate();
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}finally {
	// 		try {
	// 			pstm.close();
	// 			conn.close();
	// 		} catch (Exception e2) {
	// 			e2.printStackTrace();
	// 		}
	// 	}
	// 	return kq;
	// }
	
}
