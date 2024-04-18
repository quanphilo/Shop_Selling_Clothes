package BLL;

import java.util.Vector;

import DAL.CategoryDAL;
import DTO.CategoryDTO;

public class CategoryBLL {
	CategoryDAL categoryDAL = new CategoryDAL();
	public Vector<CategoryDTO> getCategories(){ 
		Vector<CategoryDTO> listCategory = categoryDAL.getCategories();
		return listCategory;
	}
	
	
	public CategoryDTO getCategoryById(String id_category) {
		CategoryDTO categoryDTO = categoryDAL.getCategoryById(id_category);
		return categoryDTO;
	}
	
	public int insert(CategoryDTO categoryDTO) {
		if(categoryDTO.getName().isBlank()) {
			return 2;
		}
		int kq = categoryDAL.insert(categoryDTO);
		return kq;
	}
	
	public int delete(CategoryDTO categoryDTO) {
		int kq = categoryDAL.delete(categoryDTO);
		return kq;
	}
	
	public int update(CategoryDTO categoryDTO) {
		if(categoryDTO.getName().isBlank()) {
			return 2;
		}
		int kq = categoryDAL.update(categoryDTO);
		return kq;
	}
}
