package BLL;

import java.util.Vector;

import DAL.CategoryChildDAL;
import DTO.CategoryChildDTO;

public class CategoryChildBLL {
	CategoryChildDAL categorychildDAL = new CategoryChildDAL();

	public Vector<CategoryChildDTO> getCategoryChilds() {
		Vector<CategoryChildDTO> listCategoryChild = categorychildDAL.getCategoryChilds();
		return listCategoryChild;
	}

	public Vector<CategoryChildDTO> getCategoryChildsByCategoryId(String id_category) {
		Vector<CategoryChildDTO> listCategoryChild = categorychildDAL.getCategoryChildsByCategoryId(id_category);
		return listCategoryChild;
	}

	public CategoryChildDTO getCategoryChildById(String id_categorychild) {
		return categorychildDAL.getCategoryChildById(id_categorychild);
	}
	
	
	public int insert(CategoryChildDTO categorychildDTO) {
		if(categorychildDTO.getName().isBlank()) {
			return 2;
		}
		int kq = categorychildDAL.insert(categorychildDTO);
		return kq;
	}
	
	public int delete(String categorychild_id) {
		int kq = categorychildDAL.delete(categorychild_id);
		return kq;
	}
	public int update(CategoryChildDTO categorychildDTO) {
		if(categorychildDTO.getName().isBlank()) {
			return 2;
		}
		int kq = categorychildDAL.update(categorychildDTO);
		return kq;
	}

}
