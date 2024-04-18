package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.AccountDTO;

public class AccountDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	
	public Vector<AccountDTO> getAccounts() {
		Vector<AccountDTO> listAccount = new Vector<AccountDTO>();
		try {
			String sql = "SELECT * FROM tbl_account";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				AccountDTO accountDTO = new AccountDTO(
						rs.getString("id_account"), rs.getString("username"), rs.getString("password")
						);
				listAccount.add(accountDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return listAccount;
	}
	
	
	public AccountDTO getAccountById(String id_account) {
		AccountDTO accountDTO = null;
		try {
			String sql = "SELECT * FROM tbl_account WHERE id_account = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_account);
			rs = pstm.executeQuery();
			if (rs.next()) {
				accountDTO = new AccountDTO(
					rs.getString("id_account"), rs.getString("username"), rs.getString("password"), rs.getInt("status")
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
		return accountDTO;
	}
//	
	// Return id_account (String) if login=true else return null Login = false;
	public AccountDTO login(AccountDTO account, String position) {
		AccountDTO accountDTO = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM tbl_account WHERE `username` = ? AND `password` = md5(?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, account.getUsename());
			pstm.setString(2, account.getPassword());
			rs = pstm.executeQuery();
                        if (rs.next()) {
				accountDTO = new AccountDTO(
					rs.getString("id_account"), rs.getString("username"), rs.getString("password"), rs.getInt("status")
				);
			}
                        
                        //
                        String idEmployee = rs.getString("id_account");
                        String sql2 = "select * from tbl_employee where `id_employee` = ? and `id_position` = ?";
			pstm = con.prepareStatement(sql2);
			pstm.setString(1, idEmployee);
                        pstm.setString(2, position);
			rs = pstm.executeQuery();
                        Object scalar = null;
                        if (rs.next()) {
                            scalar = rs.getObject(1);
                        }
                        if (scalar != null){
                            return accountDTO;
                        }
                        //
                        
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return null;
	}
	
	public int insert(AccountDTO account) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_account(`id_account`, `username`, `password`, `status`) VALUES(?, ?, md5(?), ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, account.getId_user());
			pstm.setString(2, account.getUsename());
			pstm.setString(3, account.getPassword());
			pstm.setInt(4, account.getStatus());
			kq = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return kq;
	}
        
        public int update(AccountDTO account) {
		int kq = 0;
		try {
                        String sql = "UPDATE tbl_account SET username=?, password=md5(?) WHERE id_account=?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, account.getUsename());
			pstm.setString(2, account.getPassword());
			pstm.setString(3, account.getId_user());
			kq = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return kq;
	}
	
	public int suspend(AccountDTO account) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_account SET status = 0 WHERE id_account = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, account.getId_user());
			kq = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return kq;
	}
	
	public int active(AccountDTO account) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_account SET status = 1 WHERE id_account = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, account.getId_user());
			kq = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kq;
	}
	
	
}
