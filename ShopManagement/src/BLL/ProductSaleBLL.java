package BLL;

import java.util.Vector;

import DAL.ProductSaleDAL;
import DTO.ProductSaleDTO;

public class ProductSaleBLL {

    ProductSaleDAL produdctSaleDAL = new ProductSaleDAL();
    
    public Vector<ProductSaleDTO> getProductSales() {
        return produdctSaleDAL.getProductSales();
    }

    public int checkSale(String id_product) {
        return produdctSaleDAL.checkSale(id_product);
    }

    public ProductSaleDTO getProductSaleByProductId(String id_product) {
        return produdctSaleDAL.getProductSaleByProductId(id_product);
    }

    public int setSale(ProductSaleDTO productSaleDTO) {
        ProductSaleDTO productSale = produdctSaleDAL.getProductSaleByProductId(productSaleDTO.getProduct().getId_product());
        if (productSale == null) {
            return produdctSaleDAL.insert(productSaleDTO);
        }
        else {
            return produdctSaleDAL.update(productSaleDTO);
        }
    }

}
