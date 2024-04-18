package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.PermissionDTO;
import DTO.PosPermissionDTO;
import DTO.PositionDTO;

public class PosPermissionDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public Vector<PosPermissionDTO> getPosPermissions(){
		Vector<PosPermissionDTO> listPosPermission = new Vector<PosPermissionDTO>();
		try {
			String sql = "SELECT * FROM tbl_pos_permission ORDER BY id_permission  ASC";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				PosPermissionDTO pospermissionDTO = new PosPermissionDTO(
						new PermissionDTO(rs.getString("id_permission")), 
						new PositionDTO(rs.getString("id_position")));
				listPosPermission.add(pospermissionDTO);
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
		return listPosPermission;
	}
	
	
	public Vector<PosPermissionDTO> getPermissionByPosId(String id_position) {
		Vector<PosPermissionDTO> listPosPermission = new Vector<PosPermissionDTO>();
		try {
			String sql = "SELECT * FROM tbl_pos_permission WHERE id_position = ? ";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_position);
			rs = pstm.executeQuery();
			while(rs.next()) {
				PosPermissionDTO pospermissionDTO = new PosPermissionDTO(
						new PermissionDTO(rs.getString("id_permission")), 
						new PositionDTO(rs.getString("id_position")));
				listPosPermission.add(pospermissionDTO);
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
		return listPosPermission;
	}
	
	public int insert(PosPermissionDTO pospermissionDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_pos_permission(`id_position`,`id_permission`) VALUES(?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pospermissionDTO.getPositionDTO().getId_positions());
			pstm.setString(2, pospermissionDTO.getPermissionDTO().getId_permission());
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
	
	public int delete(PosPermissionDTO pospermissionDTO) {
		int kq1 = 0;
		try {
			String sql = "DELETE FROM tbl_pos_permission WHERE `id_permission` = ? AND `id_position` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pospermissionDTO.getPermissionDTO().getId_permission());
			pstm.setString(2, pospermissionDTO.getPositionDTO().getId_positions());
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
	

	public int update(PosPermissionDTO pospermissionDTO) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_pos_permission SET id_permission = ? WHERE id_position = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pospermissionDTO.getPermissionDTO().getId_permission());
			pstm.setString(2, pospermissionDTO.getPositionDTO().getId_positions());
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

	public int checkInit(PosPermissionDTO pospermissionDTO) {
		int kq = 0;
		try {
			String sql = "SELECT * FROM tbl_pos_permission WHERE id_position = ? AND id_permission = ? ";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pospermissionDTO.getPositionDTO().getId_positions());
			pstm.setString(2, pospermissionDTO.getPermissionDTO().getId_permission());
			rs = pstm.executeQuery();
			if (rs.next()) {
				kq = 1;
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
		return kq;
	}
}
