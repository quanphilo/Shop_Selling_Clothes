package DAL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

import DTO.VoucherDTO;

public class VoucherDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Vector<VoucherDTO> getVouchers(){
		Vector<VoucherDTO> listVoucher = new Vector<VoucherDTO>();
		try {
			String sql = "SELECT * FROM `tbl_voucher` where status = 1";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				VoucherDTO voucherDTO = new VoucherDTO(rs.getString("id_voucher"), 
				rs.getString("code"), 
				rs.getInt("discountpercent"),
				 rs.getDate("startdate"), 
				 rs.getDate("enddate"));
				listVoucher.add(voucherDTO);
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
		return listVoucher;
	}
	
	public VoucherDTO getVoucherById(String id_voucher) {
		VoucherDTO voucherDTO = null;
		try {
			String sql = "SELECT * FROM tbl_voucher WHERE status = 1 AND `id_voucher` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_voucher);
			rs = pstm.executeQuery();
			if(rs.next()) {
				voucherDTO = new VoucherDTO(
							rs.getString("id_voucher"), rs.getString("code"), rs.getInt("discountpercent"), rs.getDate("startdate"), rs.getDate("enddate")
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
		return voucherDTO;
	}
	
	public int insert(VoucherDTO voucherDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_voucher(id_voucher, code, discountpercent, startdate, enddate) VALUES(?, ?, ?, ?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, voucherDTO.getId_voucher());
			pstm.setString(2, voucherDTO.getCode());
			pstm.setFloat(3, voucherDTO.getDiscountpercent());
			pstm.setString(4, sdf.format(voucherDTO.getStartdate()));
			pstm.setString(5,sdf.format(voucherDTO.getEnddate()));
			
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
	
	public int update(VoucherDTO voucherDTO) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_voucher SET code = ?, discountpercent = ?, startdate = ?, enddate = ? WHERE id_voucher = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, voucherDTO.getCode());
			pstm.setFloat(2, voucherDTO.getDiscountpercent());
			pstm.setString(3, sdf.format(voucherDTO.getStartdate()));
			pstm.setString(4,sdf.format(voucherDTO.getEnddate()));
			pstm.setString(5, voucherDTO.getId_voucher());
			
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
	
        public int delete(String id_voucher, int status) {
            int kq = 0;
            try {
                String sql = "UPDATE tbl_voucher SET status = ? WHERE id_voucher = ?";
                con = JDBCUtil.getConnection();
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, status);
                pstm.setString(2, id_voucher);
                kq = pstm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
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
