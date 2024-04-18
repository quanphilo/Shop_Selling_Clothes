package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.ProductDTO;
import DTO.WarehouseReceiptDTO;
import DTO.WarehouseReceiptDetailDTO;

public class WarehouseReceiptDetailDAL {
    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public Vector<WarehouseReceiptDetailDTO> getwarehouseReceiptDetails() {
        Vector<WarehouseReceiptDetailDTO> warehouseReceiptDetailList = new Vector<WarehouseReceiptDetailDTO>();
        try {
            String sql = "SELECT * FROM `tbl_warehousereceipt_detail`";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = new WarehouseReceiptDetailDTO(
                    new WarehouseReceiptDTO(rs.getString("id_warehousereceipt")),
                    new ProductDTO(rs.getString("id_product")),
                    rs.getInt("amount"),
                    rs.getFloat("price")
                );
                warehouseReceiptDetailList.add(warehouseReceiptDetailDTO);
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
        return warehouseReceiptDetailList;
    }

    public WarehouseReceiptDetailDTO getwarehouseReceiptDetailsByProductId(String id_product) {
        WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = null;
        try {
            String sql = "SELECT * FROM `tbl_warehousereceipt_detail` WHERE id_product  = ? ORDER BY id_warehousereceipt DESC";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_product);
            rs = pstm.executeQuery();
            if (rs.next()) {
                warehouseReceiptDetailDTO = new WarehouseReceiptDetailDTO(
                    new WarehouseReceiptDTO(rs.getString("id_warehousereceipt")),
                    new ProductDTO(rs.getString("id_product")),
                    rs.getInt("amount"),
                    rs.getFloat("price")
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
        return warehouseReceiptDetailDTO;
    }

    public Vector<WarehouseReceiptDetailDTO> getWarehouseReceiptDetailByWarehouseReceiptId(String id_warehousereceipt) {
        Vector<WarehouseReceiptDetailDTO> listWarehouseReceiptDetail = new Vector<WarehouseReceiptDetailDTO>();
        try {
            String sql = "SELECT * FROM `tbl_warehousereceipt_detail` WHERE id_warehousereceipt = ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_warehousereceipt);
            rs = pstm.executeQuery();
            while (rs.next()) {
                WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = new WarehouseReceiptDetailDTO(
                    new WarehouseReceiptDTO(rs.getString("id_warehousereceipt")),
                    new ProductDTO(rs.getString("id_product")),
                    rs.getInt("amount"),
                    rs.getFloat("price")
                );
                listWarehouseReceiptDetail.add(warehouseReceiptDetailDTO);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                pstm.close();
                con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listWarehouseReceiptDetail;
    }

    public int insert(WarehouseReceiptDetailDTO warehouseReceiptDetailDTO) {
        int kq = 0;
        try {
            String sql = "INSERT INTO `tbl_warehousereceipt_detail`(`id_warehousereceipt`, `id_product`, `amount`, `price`) VALUES (?, ?, ?, ?)";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, warehouseReceiptDetailDTO.getWarehouseReceipt().getId_warehousereceipt());
            pstm.setString(2, warehouseReceiptDetailDTO.getProduct().getId_product());
            pstm.setInt(3, warehouseReceiptDetailDTO.getAmount());
            pstm.setFloat(4, warehouseReceiptDetailDTO.getPrice());
           
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

    public int update (WarehouseReceiptDetailDTO warehouseReceiptDetailDTO) {
        int kq = 0;
        try {
            String sql = "UPDATE `tbl_warehousereceipt_detail` SET `amount`= ?,`price`='?' WHERE `id_warehousereceipt`  = ? AND `id_product` = ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, warehouseReceiptDetailDTO.getAmount());
            pstm.setFloat(2, warehouseReceiptDetailDTO.getPrice());
            pstm.setString(3, warehouseReceiptDetailDTO.getWarehouseReceipt().getId_warehousereceipt());
            pstm.setString(4, warehouseReceiptDetailDTO.getProduct().getId_product());
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
