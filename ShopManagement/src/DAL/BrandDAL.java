package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.BrandDTO;
public class BrandDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public Vector<BrandDTO> getBrands() {
		Vector<BrandDTO> listBrand = new Vector<BrandDTO>();
		try {
			String sql = "SELECT * FROM tbl_brand";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				BrandDTO brandDTO = new BrandDTO(rs.getString("id_brand"), rs.getString("name"));
				listBrand.add(brandDTO);
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
		return listBrand;
	}
	
	
	public BrandDTO getBrandById(String id_brand) {
		BrandDTO brandDTO = null;
		try {
			String sql = "SELECT * FROM tbl_brand WHERE `id_brand` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_brand);
			rs = pstm.executeQuery();
			if (rs.next()) {
				brandDTO = new BrandDTO(
						rs.getString("id_brand"), rs.getString("name")
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
		
		return brandDTO;
	}
	
	
	public int insert(BrandDTO brandDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_brand(id_brand, name) VALUES(?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, brandDTO.getId_brand());
			pstm.setString(2, brandDTO.getName());
			
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
	
	public int update(BrandDTO brandDTO) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_brand SET name = ? WHERE id_brand = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, brandDTO.getName());
			pstm.setString(2, brandDTO.getId_brand());
			
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
	
	public int delete(String id_brand) {
		int kq = 0;
		try {
			String sql = "DELETE FROM tbl_brand WHERE `id_brand` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_brand);
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
	

}
