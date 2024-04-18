package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.CategoryDTO;

public class CategoryDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public Vector<CategoryDTO> getCategories(){
		Vector<CategoryDTO> listCategory = new Vector<CategoryDTO>();
		try {
			String sql = "SELECT * FROM tbl_category";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CategoryDTO categoryDTO = new CategoryDTO(rs.getString("id_category"), rs.getString("name"));
				listCategory.add(categoryDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listCategory;
	}
	
	public CategoryDTO getCategoryById(String id_category) {
		CategoryDTO categoryDTO = null;
		try {
			String sql = "SELECT * FROM tbl_category WHERE `id_category` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_category);
			rs = pstm.executeQuery();
			if(rs.next()) {
				categoryDTO = new CategoryDTO(
							rs.getString("id_category"), rs.getString("name")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return categoryDTO;
	}
	
	public int insert(CategoryDTO categoryDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_category(id_category, name) VALUES(?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, categoryDTO.getId_category());
			pstm.setString(2, categoryDTO.getName());
			
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
	
	public int delete(CategoryDTO categoryDTO) {
		int kq1 = 0;
		try {
			String sql = "DELETE FROM tbl_category WHERE `id_category` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, categoryDTO.getId_category());
			kq1 = pstm.executeUpdate();
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
		return kq1;
	}
	
	public int update(CategoryDTO categoryDTO) {
		int kq1 = 0;
		try {
			String sql = "UPDATE tbl_category SET name = ? WHERE id_category = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, categoryDTO.getName());
			pstm.setString(2, categoryDTO.getId_category());
			kq1 = pstm.executeUpdate();
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
		return kq1;
	}
		
	
}
