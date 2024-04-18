package DAL;

import java.sql.*;
import java.util.Vector;

import DTO.OrderDTO;
import DTO.OrderItemDTO;
import DTO.ProductDTO;

public class OrderItemDAL {
    public Connection con = null;
    public PreparedStatement pstm = null;
    public ResultSet rs = null;
    
    public Vector<OrderItemDTO> getOrderItems() {
        Vector<OrderItemDTO> listOrderItem = new Vector<OrderItemDTO>();
        try {
            String sql = "SELECT * FROM tbl_order_item";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OrderItemDTO orderitemDTO = new OrderItemDTO(
                        new OrderDTO(rs.getString("id_order")),
                        new ProductDTO(rs.getString("id_product")),
                        rs.getInt("quantity"),
                        rs.getFloat("price"));
                listOrderItem.add(orderitemDTO);
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
        return listOrderItem;
    }

    public Vector<OrderItemDTO> getOrderItemByOrderId(String id_order) {
        Vector<OrderItemDTO> listOrderItem = new Vector<OrderItemDTO>();
        try {
            String sql = "SELECT * FROM tbl_order_item WHERE id_order = ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_order);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OrderItemDTO orderitemDTO = new OrderItemDTO(
                        new OrderDTO(id_order),
                        new ProductDTO(rs.getString("id_product")),
                        rs.getInt("quantity"),
                        rs.getFloat("price"));
                listOrderItem.add(orderitemDTO);
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
        return listOrderItem;
    }


    public Vector<OrderItemDTO> getOrderItemByProductId(String id_product) {
        Vector<OrderItemDTO> listOrderItem = new Vector<OrderItemDTO>();
        try {
            String sql = "SELECT * FROM tbl_order_item WHERE id_product = ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_product);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OrderItemDTO orderitemDTO = new OrderItemDTO(
                        new OrderDTO(rs.getString("id_order")),
                        new ProductDTO(rs.getString("id_product")),
                        rs.getInt("quantity"),
                        rs.getFloat("price"));
                listOrderItem.add(orderitemDTO);
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
        return listOrderItem;
    }

    public int insert(OrderItemDTO orderItemDTO) {
        int kq = 0;
        try {
            String sql = "INSERT INTO tbl_order_item(`id_order`, `id_product`, `quantity`, `price`) VALUES(?,?,?,?)";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderItemDTO.getOrder().getId_order());
            pstm.setString(2, orderItemDTO.getProduct().getId_product());
            pstm.setInt(3, orderItemDTO.getQuantity());
            pstm.setFloat(4, orderItemDTO.getPrice());
            
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

    public int deleteOrderItemWithOrderId(String id_order) {
        int kq = 0;
        try {
            String sql = "DELETE FROM tbl_order_item WHERE id_order = ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_order);
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
