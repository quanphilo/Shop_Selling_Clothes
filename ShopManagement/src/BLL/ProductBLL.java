package BLL;

import java.util.HashMap;
import java.util.Vector;

import Cores.ReadWriteFile;
import DAL.ProductDAL;
import DTO.ProductDTO;

public class ProductBLL {
  private ProductDAL productDAL = new ProductDAL();
	ReadWriteFile readWriteFile = new ReadWriteFile();

  public Vector<ProductDTO> getProducts() {
    Vector<ProductDTO> listProduct = productDAL.getProducts();
    return listProduct;
  }

  public ProductDTO getProductById(String id_product) {
    ProductDTO productDTO = productDAL.getProductById(id_product);
    return productDTO;
  }

  public int insert(ProductDTO productDTO) {
    int kq = productDAL.insert(productDTO);
    return kq;
  }

  public int update(ProductDTO productDTO) {
    return productDAL.update(productDTO);
  }

  public Vector<String> filters(HashMap<String, String> filter) {
    return productDAL.filters(filter);
  }

  public int  writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header) {
	return readWriteFile.writeExcel(listObjectData, header);
  }


}
