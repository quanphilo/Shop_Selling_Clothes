package DAL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import DTO.OrderDTO;
import DTO.VoucherDTO;

public class OrderDAL {
    private Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public Connection con = null;
    public PreparedStatement pstm = null;
    public ResultSet rs = null;

    public Vector<OrderDTO> getOrders() {
        Vector<OrderDTO> listOrder = new Vector<OrderDTO>();
        try {
            String sql = "SELECT * FROM tbl_order ";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OrderDTO orderDTO = new OrderDTO(rs.getString("id_order"), new CustomerDTO(rs.getString("id_customer")),
                        rs.getFloat("totalprice"), new VoucherDTO(rs.getString("id_voucher")),
                        new EmployeeDTO(rs.getString("id_employee")), rs.getDate("date"));
                listOrder.add(orderDTO);
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
        return listOrder;
    }

    public Vector<OrderDTO> getOrdersOfMonth(int MONTH) {
        Vector<OrderDTO> listOrder = new Vector<OrderDTO>();
        try {
            String startdate = "" + (date.getYear() + 1900) + "-" + MONTH + "-" + "1";
            String endate = "" + (date.getYear() + 1900) + "-" + MONTH + "-" + "31";
            String sql = "SELECT * FROM tbl_order WHERE  `date` BETWEEN ? AND ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, startdate);
            pstm.setString(2, endate);
            rs = pstm.executeQuery();
            while (rs.next()) {
                OrderDTO orderDTO = new OrderDTO(rs.getString("id_order"), new CustomerDTO(rs.getString("id_customer")),
                        rs.getFloat("totalprice"), new VoucherDTO(rs.getString("id_voucher")),
                        new EmployeeDTO(rs.getString("id_employee")), rs.getDate("date"));
                listOrder.add(orderDTO);
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
        return listOrder;
    }

    public Vector<OrderDTO> getOrdersByFilterDate(Date startdate, Date enddate) {
        Vector<OrderDTO> listOrder = new Vector<OrderDTO>();
        try {

            String sql = "SELECT * FROM tbl_order WHERE  `date` BETWEEN ? AND ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, sdf.format(startdate));
            pstm.setString(2, sdf.format(enddate));
            rs = pstm.executeQuery();
            while (rs.next()) {
                OrderDTO orderDTO = new OrderDTO(rs.getString("id_order"), new CustomerDTO(rs.getString("id_customer")),
                        rs.getFloat("totalprice"), new VoucherDTO(rs.getString("id_voucher")),
                        new EmployeeDTO(rs.getString("id_employee")), rs.getDate("date"));
                listOrder.add(orderDTO);
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
        return listOrder;
    }

    public OrderDTO getOrderById(String id_order) {
        OrderDTO orderDTO = null;
        try {
            String sql = "SELECT * FROM tbl_order WHERE id_order = ?";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id_order);
            rs = pstm.executeQuery();
            if (rs.next()) {
                orderDTO = new OrderDTO(rs.getString("id_order"), new CustomerDTO(rs.getString("id_customer")),
                        rs.getFloat("totalprice"), new VoucherDTO(rs.getString("id_voucher")),
                        new EmployeeDTO(rs.getString("id_employee")), rs.getDate("date"));
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
        return orderDTO;
    }

    public int insert(OrderDTO orderDTO) {
        int kq = 0;
        try {
            String sql = "INSERT INTO tbl_order(id_order, id_customer, totalprice, id_voucher, id_employee,	date) VALUES(?,?,?,?,?,?)";
            con = JDBCUtil.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderDTO.getId_order());
            pstm.setString(2, orderDTO.getCustomer().getId());
            pstm.setFloat(3, orderDTO.getTotalprice());
            pstm.setString(4, orderDTO.getVoucher().getId_voucher());
            pstm.setString(5, orderDTO.getEmployee().getId());
            pstm.setString(6, sdf.format(orderDTO.getDate()));
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