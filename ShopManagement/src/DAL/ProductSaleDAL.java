package DAL;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

import DTO.ProductDTO;
import DTO.ProductSaleDTO;

public class ProductSaleDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Vector<ProductSaleDTO> getProductSales() {
		Vector<ProductSaleDTO> listProductSales = new Vector<ProductSaleDTO>();
		try {
			String sql = "SELECT * FROM tbl_product_sale";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ProductSaleDTO productsaleDTO = new ProductSaleDTO(
                    new ProductDTO(rs.getString("id_product")),
                    rs.getFloat("salepercent"),
                    rs.getDate("startdate"),
                    rs.getDate("enddate")
                );
                listProductSales.add(productsaleDTO);
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
		return listProductSales;
	}

	public ProductSaleDTO getProductSaleByProductId(String id_product) {
		ProductSaleDTO productsaleDTO = null;
		try {
			String sql = "SELECT * FROM tbl_product_sale WHERE id_product = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_product);
			rs = pstm.executeQuery();
			if (rs.next()) {
				productsaleDTO = new ProductSaleDTO(
                    new ProductDTO(rs.getString("id_product")),
                    rs.getFloat("salepercent"),
                    rs.getDate("startdate"),
                    rs.getDate("enddate")
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
		return productsaleDTO;
	}

    public int checkSale(String id_product) {
        int kq = 0;
        try { 
			String sql = "SELECT * FROM tbl_product_sale WHERE id_product = ? AND CURRENT_TIMESTAMP BETWEEN `startdate` AND `enddate`";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
            pstm.setString(1, id_product);
			rs = pstm.executeQuery();
			if (rs.next()) {
                kq = 1;
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
		return kq;
    }

    public int update(ProductSaleDTO productSaleDTO) {
        int kq = 0;
        try { 
			String sql = "UPDATE tbl_product_sale SET `salepercent` = ?, `startdate` = ? , `enddate` = ? WHERE `id_product` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
            pstm.setFloat(1, productSaleDTO.getDiscountPercent());
            pstm.setString(2, sdf.format(productSaleDTO.getStartdate()));
            pstm.setString(3, sdf.format(productSaleDTO.getEnddate()));
            pstm.setString(4, productSaleDTO.getProduct().getId_product());
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

    public int insert(ProductSaleDTO productSaleDTO) {
        int kq = 0;
        try { 
			String sql = "INSERT INTO `tbl_product_sale`(`id_product`, `salepercent`, `startdate`, `enddate`) VALUES (?, ?, ?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, productSaleDTO.getProduct().getId_product());
            pstm.setFloat(2, productSaleDTO.getDiscountPercent());
            pstm.setString(3, sdf.format(productSaleDTO.getStartdate()));
            pstm.setString(4, sdf.format(productSaleDTO.getEnddate()));
			kq  = pstm.executeUpdate();
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
