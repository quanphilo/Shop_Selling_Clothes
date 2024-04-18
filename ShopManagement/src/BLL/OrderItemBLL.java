package BLL;

import java.util.Vector;

import DAL.OrderItemDAL;
import DTO.OrderItemDTO;

public class OrderItemBLL {
    OrderItemDAL orderItemDAL = new OrderItemDAL();
    
    public Vector<OrderItemDTO> getOrderItems() {
    	return orderItemDAL.getOrderItems();
    }
    
    public Vector<OrderItemDTO> getOrderItemByOrderId(String id_order) {
        return orderItemDAL.getOrderItemByOrderId(id_order);
    }

    public int insert(OrderItemDTO orderItemDTO) {
        return orderItemDAL.insert(orderItemDTO);
    }

    public int deleteOrderItemWithOrderId(String id_order) {
        return orderItemDAL.deleteOrderItemWithOrderId(id_order);
    }

    public Vector<OrderItemDTO> getOrderItemByProductId(String id_product) {
        return orderItemDAL.getOrderItemByProductId(id_product);
    }
    
 
}
