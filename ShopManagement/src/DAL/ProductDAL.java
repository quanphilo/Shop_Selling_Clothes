package DAL;

import java.sql.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import DTO.BrandDTO;
import DTO.CategoryChildDTO;
import DTO.ProductDTO;

public class ProductDAL {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public Vector<ProductDTO> getProducts() {
		Vector<ProductDTO> listProduct = new Vector<ProductDTO>();
		try {
			String sql = "SELECT * FROM tbl_product INNER JOIN  tbl_categorychild  ON tbl_product.id_categorychild = tbl_categorychild.id_categorychild INNER JOIN tbl_brand ON tbl_brand.id_brand = tbl_product.id_brand";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId_product(rs.getString("id_product"));
				productDTO.setBrand(new BrandDTO(rs.getString("id_brand"), rs.getString("tbl_brand.name")));
				productDTO.setCategorychild(new CategoryChildDTO(rs.getString("id_categorychild"), rs.getString("tbl_categorychild.name")));
				productDTO.setName(rs.getString("tbl_product.name"));
				productDTO.setPrice(rs.getFloat("price"));
				productDTO.setQuantity(rs.getInt("quantity"));
				productDTO.setStatus(rs.getInt("status"));
				listProduct.add(productDTO);
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
		return listProduct;
	}
	
	public ProductDTO getProductById(String id_product) {
		ProductDTO productDTO = null;
		try {
			String sql = "SELECT * FROM tbl_product WHERE id_product = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_product);
			rs = pstm.executeQuery();
			if (rs.next()) {
				productDTO = new ProductDTO(
						rs.getString("id_product"), 
						new BrandDTO(rs.getString("id_brand")),
						new CategoryChildDTO(rs.getString("id_categorychild")),
						 rs.getString("name"),
						rs.getInt("quantity"), 
						rs.getFloat("price"), 
						rs.getString("image"), 
						rs.getInt("status")
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
		return productDTO;
	}
	
	public int insert(ProductDTO productDTO) {
		int kq = 0;
		try {
			String sql = "INSERT INTO `tbl_product`(`id_product`, `id_brand`, `id_categorychild`, `name`, `quantity`, `price`, `image`, `status`) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, productDTO.getId_product());
			pstm.setString(2, productDTO.getBrand().getId_brand());
			pstm.setString(3, productDTO.getCategorychild().getId_categorychild());
			pstm.setString(4, productDTO.getName());
			pstm.setInt(5, productDTO.getQuantity());
			pstm.setFloat(6,productDTO.getPrice());
			pstm.setString(7, productDTO.getImage());
			pstm.setInt(8, productDTO.getStatus());
		
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
	
	public int update(ProductDTO productDTO) {
		int kq = 0;
		try {
			String sql = "UPDATE `tbl_product` SET `id_brand`= ?,`id_categorychild`= ?,`name`= ?,"
					+ "`quantity`= ?,  `price` = ?,`image`= ?,`status`= ? WHERE `id_product` = ?";
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, productDTO.getBrand().getId_brand());
			pstm.setString(2, productDTO.getCategorychild().getId_categorychild());
			pstm.setString(3, productDTO.getName());
			pstm.setInt(4, productDTO.getQuantity());
			pstm.setFloat(5, productDTO.getPrice());
			pstm.setString(6, productDTO.getImage());
			pstm.setInt(7, productDTO.getStatus());
			pstm.setString(8, productDTO.getId_product());
			
			kq = pstm.executeUpdate();
			
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


	public Vector<String> filters(HashMap<String, String> filter) {
		Vector<String> list_id = new Vector<String>();
		try {
			String sql = "SELECT * FROM tbl_product INNER JOIN  tbl_categorychild  ON tbl_product.id_categorychild = tbl_categorychild.id_categorychild INNER JOIN tbl_brand ON tbl_brand.id_brand = tbl_product.id_brand ";
			int size = filter.size();
			if (size > 0) {
				sql = sql + " WHERE ";
				int index = 1;
				Set<String> keySet = filter.keySet();
				for (String key : keySet) {
					if (index < size) {
						sql = sql + key + filter.get(key) + " AND "; 
					}
					else {
						sql = sql + key + filter.get(key); 
					}
					index++;
				}

			}
			con = JDBCUtil.getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				list_id.add(rs.getString("id_product"));
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
		return list_id;
	}
}
