package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.SupplierDTO;

public class SupplierDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public Vector<SupplierDTO> getSuppliers(){
		Vector<SupplierDTO> listSupplier = new Vector<SupplierDTO>();
		try {
			String sql = "SELECT * FROM tbl_supplier where status = 1";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				SupplierDTO supplierDTO = new SupplierDTO(rs.getString("id_supplier"), rs.getString("name"), rs.getString("address"));
				listSupplier.add(supplierDTO);
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
		return listSupplier;
	}
	
	public SupplierDTO getSupplierById(String id_supplier) {
		SupplierDTO supplierDTO = null;
		try {
			String sql = "SELECT * FROM tbl_supplier WHERE status = 1 AND `id_supplier` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_supplier);
			rs = pstm.executeQuery();
			if(rs.next()) {
				supplierDTO = new SupplierDTO(
							rs.getString("id_supplier"), rs.getString("name"), rs.getString("address")
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
		return supplierDTO;
	}
	
	public int insert(SupplierDTO supplierDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO tbl_supplier(id_supplier, name, address) VALUES(?, ?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, supplierDTO.getId_supplier());
			pstm.setString(2, supplierDTO.getName());
			pstm.setString(3, supplierDTO.getAddress());
			
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
	
	public int update(SupplierDTO supllierDTO) {
		int kq = 0;
		try {
			String sql = "UPDATE tbl_supplier SET name = ?, address = ? WHERE id_supplier = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, supllierDTO.getName());
			pstm.setString(2, supllierDTO.getAddress());
			pstm.setString(3, supllierDTO.getId_supplier());
			
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
	
        public int delete(String id_supplier, int status) {
            int kq = 0;
            try {
                String sql = "UPDATE tbl_supplier SET status = ? WHERE id_supplier = ?";
                con = JDBCUtil.getConnection();
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, status);
                pstm.setString(2, id_supplier);
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

        public Vector<SupplierDTO> searchSuppliers(String searchText) {
            Vector<SupplierDTO> filteredSuppliers = new Vector<>();
            try {
                String sql = "SELECT * FROM tbl_supplier WHERE status = 1 AND (id_supplier LIKE ? or name LIKE ?)";
                con = JDBCUtil.getConnection();
                pstm = con.prepareStatement(sql);
                pstm.setString(1, "%" + searchText + "%");
                pstm.setString(2, "%" + searchText + "%");
                rs = pstm.executeQuery();
                while (rs.next()) {
                    SupplierDTO supplierDTO = new SupplierDTO(rs.getString("id_supplier"), rs.getString("name"), rs.getString("address"));
                    filteredSuppliers.add(supplierDTO);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeResources();
            }
            return filteredSuppliers;
        }

        private void closeResources() {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
