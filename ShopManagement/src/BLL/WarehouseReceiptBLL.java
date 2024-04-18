package BLL;

import java.io.File;
import java.util.Vector;

import Cores.ReadWriteFile;
import DAL.WarehouseReceiptDAL;
import DTO.WarehouseReceiptDTO;

public class WarehouseReceiptBLL {
    WarehouseReceiptDAL warehouseReceiptDAL = new WarehouseReceiptDAL();
	ReadWriteFile readWriteFile = new ReadWriteFile();


    public Vector<WarehouseReceiptDTO> getWarehouseReceipts() {
        Vector<WarehouseReceiptDTO> warehouseRecriptList = warehouseReceiptDAL.getWarehouseReceipts();
        return warehouseRecriptList;
    }

    public WarehouseReceiptDTO getWarehouseReceiptById(String  id_warehousereceipt) {
        return warehouseReceiptDAL.getWarehouseReceiptById(id_warehousereceipt);
    }

    public int insert(WarehouseReceiptDTO warehouseReceiptDTO) {
        return warehouseReceiptDAL.insert(warehouseReceiptDTO);
    }

    public int update (WarehouseReceiptDTO warehouseReceiptDTO) {
        return warehouseReceiptDAL.update(warehouseReceiptDTO);
    }

    public int delete (String id_warehousereceipt) {
        return warehouseReceiptDAL.delete(id_warehousereceipt);

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
