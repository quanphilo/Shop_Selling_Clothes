package BLL;

import java.io.File;
import java.util.Date;
import java.util.Vector;

import Cores.ReadWriteFile;
import DAL.OrderDAL;
import DTO.OrderDTO;

public class OrderBLL {
    OrderDAL orderDAL = new OrderDAL();
	ReadWriteFile readWriteFile = new ReadWriteFile();
    
    public Vector<OrderDTO> getOrders() {
        return orderDAL.getOrders();
    }

    public OrderDTO getOrderById(String id_order) {
        return orderDAL.getOrderById(id_order);
    }

    public int insert(OrderDTO orderDTO) {
        if (orderDTO.getCustomer() == null || orderDTO.getTotalprice() == 0) {
            return 2;
        }
        return orderDAL.insert(orderDTO);
    }

    public Vector<OrderDTO> getOrdersOfMonth(int MONTH) {
        return orderDAL.getOrdersOfMonth(MONTH);
    }

    public Vector<OrderDTO> getOrdersByFilterDate(Date startdate, Date enddate) {
        return orderDAL.getOrdersByFilterDate(startdate, enddate);
    }
    public int  writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header) {
		return readWriteFile.writeExcel(listObjectData, header);
	}
    
    public File writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header, int flag) {
		return readWriteFile.writeExcel(listObjectData, header, flag);
	}
    
    public int writeExcelForDetail(Vector<Vector<String>> listObjectData, Vector<String> header, File file) {
  		return readWriteFile.writeExcelForDetail(listObjectData, header, file);
  	}
    
    
}
