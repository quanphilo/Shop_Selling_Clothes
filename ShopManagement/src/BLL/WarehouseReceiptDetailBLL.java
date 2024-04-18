package BLL;

import java.util.Vector;

import DAL.WarehouseReceiptDetailDAL;
import DTO.WarehouseReceiptDetailDTO;

public class WarehouseReceiptDetailBLL {
    WarehouseReceiptDetailDAL warehouseReceiptDetailDAL = new WarehouseReceiptDetailDAL();

    public Vector<WarehouseReceiptDetailDTO> warehouseReceiptDetailDTO() {
        return warehouseReceiptDetailDAL.getwarehouseReceiptDetails();
    }

    public Vector<WarehouseReceiptDetailDTO> getWarehouseReceiptDetailByWarehouseReceiptId(String id_warehousereceipt) {
        return warehouseReceiptDetailDAL.getWarehouseReceiptDetailByWarehouseReceiptId(id_warehousereceipt);
    }

    public int insert(WarehouseReceiptDetailDTO warehouseReceiptDetailDTO) {
        return warehouseReceiptDetailDAL.insert(warehouseReceiptDetailDTO);
    }

    public int update(WarehouseReceiptDetailDTO warehouseReceiptDetailDTO) {
        return warehouseReceiptDetailDAL.update(warehouseReceiptDetailDTO);
    }

    public WarehouseReceiptDetailDTO getwarehouseReceiptDetailsByProductId(String id_product)  {
        return warehouseReceiptDetailDAL.getwarehouseReceiptDetailsByProductId(id_product);
    }
}
