package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.CategoryChildDTO;

public class CategoryChildDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public Vector<CategoryChildDTO> getCategoryChilds(){
		Vector<CategoryChildDTO> listCategoryChild = new Vector<CategoryChildDTO>();
		try {
			String sql = "SELECT * FROM tbl_categorychild";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CategoryChildDTO categorychildDTO = new CategoryChildDTO(rs.getString("id_categorychild"), rs.getString("name"));
				listCategoryChild.add(categorychildDTO);
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
		return listCategoryChild;
	}
	
	
	public Vector<CategoryChildDTO> getCategoryChildsByCategoryId(String id_category){
		Vector<CategoryChildDTO> listCategoryChild = new Vector<CategoryChildDTO>();
		try {
			String sql = "SELECT * FROM tbl_categorychild WHERE id_category = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_category);
			rs = pstm.executeQuery();
			while(rs.next()) {
				CategoryChildDTO categorychildDTO = new CategoryChildDTO(rs.getString("id_categorychild"), rs.getString("name"));
				listCategoryChild.add(categorychildDTO);
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
		return listCategoryChild;
	}
	
	public CategoryChildDTO getCategoryChildById(String id_categorychild) {
		CategoryChildDTO categorychildDTO = null;
		try {
			String sql = "SELECT * FROM tbl_categorychild WHERE `id_categorychild` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_categorychild);
			rs = pstm.executeQuery();
			if(rs.next()) {
				// Một là chỉ sử dụng id_categorychild và name
				categorychildDTO = new CategoryChildDTO();
				categorychildDTO.setId_categorychild(rs.getString("id_categorychild"));
				categorychildDTO.setName(rs.getString("name"));
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
		return categorychildDTO;
	}
	
	public int insert(CategoryChildDTO categorychildDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_categorychild(id_categorychild, id_category, name) VALUES(?, ?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, categorychildDTO.getId_categorychild());
			pstm.setString(2, categorychildDTO.getCategory().getId_category());
			pstm.setString(3, categorychildDTO.getName());
			
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
	
	public int delete(String categorychild_id) {
		int kq1 = 0;
		try {
			String sql = "DELETE FROM tbl_categorychild WHERE `id_categorychild` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, categorychild_id);
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
	public int update(CategoryChildDTO categorychildDTO) {
		int kq1 = 0;
		try {
			String sql = "UPDATE tbl_categorychild SET name = ? WHERE id_categorychild = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, categorychildDTO.getName());
			pstm.setString(2, categorychildDTO.getId_categorychild());
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
