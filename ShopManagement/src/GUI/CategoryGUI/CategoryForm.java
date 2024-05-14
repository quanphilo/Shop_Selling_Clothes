package GUI.CategoryGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.table.*;

import BLL.CategoryBLL;
import BLL.CategoryChildBLL;
import DTO.CategoryChildDTO;
import DTO.CategoryDTO;

public class CategoryForm extends JPanel {
	private JPanel pnOptions;
	private int ma_nvthungan;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel pnOrder;
	private JLabel lblMNv;
	private JButton btnAddCategory;
	private JButton btnUpdateCategory;
	private JButton btnRemoveCategory;
	private JTextField txtCategoryId;
	private JTextField txtCategoryName;
	private JLabel lblTnNv;
	private JPanel pnDetails;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTextField txtCategoryChildName;
	private JLabel lblTnDanhMc;
	private JLabel lblMDanhMc;
	private JTextField txtCategoryChildId;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblDanhMcCon;
	private JLabel lblNewLabel_1;
	private JTable tblCategory;
	private JTable tblCategoryChild;

	private CategoryBLL categoryBLL = new CategoryBLL();
	private CategoryChildBLL categoryChildBLL = new CategoryChildBLL();
	private JButton btnConfirm = new JButton();
	private Date date = new Date();
	private JButton btnAddCategoryChild;
	private JButton btnUpdateCategoryChild;
	private JButton btnRemoveCategoryChild;
	private JButton btnConfirmCategoryChild;
	private JPanel pnDetails_1;
	
	public CategoryForm() {
		initComponents();
		addEvents();
		loadCategoryTable();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 490);
		pnOrder = new JPanel();
		pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
		pnOrder.setBounds(0, 40, 422, 450);
		add(pnOrder);
		pnOrder.setLayout(null);

		pnDetails = new JPanel();
		pnDetails.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnDetails.setBounds(0, 352, 420, 94);
		pnOrder.add(pnDetails);
		pnDetails.setLayout(null);

		btnAddCategory = new JButton("Thêm danh mục");
		btnAddCategory.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/check.png")));
		btnAddCategory.setForeground(new Color(255, 255, 224));
		btnAddCategory.setBackground(new Color(0, 128, 128));
		btnAddCategory.setBounds(25, 11, 153, 30);
		pnDetails.add(btnAddCategory);

		btnUpdateCategory = new JButton("Sửa danh mục");
		btnUpdateCategory.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/edit-icon.png")));

		btnUpdateCategory.setForeground(new Color(255, 255, 224));
		btnUpdateCategory.setBackground(new Color(0, 128, 128));
		btnUpdateCategory.setBounds(233, 11, 165, 30);
		pnDetails.add(btnUpdateCategory);

		btnRemoveCategory = new JButton("Xóa danh mục");
		btnRemoveCategory.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/remove.png")));
		btnRemoveCategory.setForeground(new Color(255, 255, 224));
		btnRemoveCategory.setBackground(new Color(0, 128, 128));
		btnRemoveCategory.setBounds(25, 53, 153, 30);
		pnDetails.add(btnRemoveCategory);

		JPanel pnAction = new JPanel();
		pnAction.setBounds(0, 12, 410, 327);
		pnOrder.add(pnAction);
		pnAction.setLayout(null);

		lblMNv = new JLabel("Mã danh mục");
		lblMNv.setForeground(new Color(51, 102, 102));
		lblMNv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMNv.setBounds(25, 23, 91, 27);
		pnAction.add(lblMNv);

		txtCategoryId = new JTextField();
		txtCategoryId.setEditable(false);
		txtCategoryId.setColumns(10);
		txtCategoryId.setBounds(130, 24, 195, 27);
		pnAction.add(txtCategoryId);

		txtCategoryName = new JTextField();
		txtCategoryName.setEditable(false);
		txtCategoryName.setColumns(10);
		txtCategoryName.setBounds(130, 63, 195, 27);
		pnAction.add(txtCategoryName);

		lblTnNv = new JLabel("Tên danh mục");
		lblTnNv.setForeground(new Color(51, 102, 102));
		lblTnNv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTnNv.setBounds(25, 62, 91, 27);
		pnAction.add(lblTnNv);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh sách danh mục cha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(46, 139, 87)));
		panel.setBounds(19, 118, 371, 197);
		pnAction.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tblCategory = new JTable();
                tblCategory.setDefaultEditor(Object.class, null);

		scrollPane = new JScrollPane(tblCategory, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane);

		pnOptions = new JPanel();
		pnOptions.setBounds(410, 40, 422, 450);
		add(pnOptions);

		DefaultTableModel dtmHD = new DefaultTableModel();
		String[] headerHD = { "Mã NV", "Tên NV", "SĐT", "Chức vụ" };
		dtmHD.setColumnIdentifiers(headerHD);
		pnOptions.setLayout(null);

		pnDetails_1 = new JPanel();
		pnDetails_1.setLayout(null);
		pnDetails_1.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnDetails_1.setBounds(0, 352, 410, 96);
		pnOptions.add(pnDetails_1);

		btnAddCategoryChild = new JButton("Thêm danh mục con");
		btnAddCategoryChild.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/check.png")));
		btnAddCategoryChild.setForeground(new Color(255, 255, 224));
		btnAddCategoryChild.setBackground(new Color(0, 128, 128));
		btnAddCategoryChild.setBounds(25, 11, 196, 30);
		pnDetails_1.add(btnAddCategoryChild);

		btnUpdateCategoryChild = new JButton("Sửa danh mục con");
		btnUpdateCategoryChild.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/edit-icon.png")));
		btnUpdateCategoryChild.setForeground(new Color(255, 255, 224));
		btnUpdateCategoryChild.setBackground(new Color(0, 128, 128));
		btnUpdateCategoryChild.setBounds(233, 11, 177, 30);
		pnDetails_1.add(btnUpdateCategoryChild);

		btnRemoveCategoryChild = new JButton("Xóa danh mục con");
		btnRemoveCategoryChild.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/remove.png")));
		btnRemoveCategoryChild.setForeground(new Color(255, 255, 224));
		btnRemoveCategoryChild.setBackground(new Color(0, 128, 128));
		btnRemoveCategoryChild.setBounds(25, 53, 196, 30);
		pnDetails_1.add(btnRemoveCategoryChild);
		

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh sách danh mục con", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(46, 139, 87)));
		panel_1.setBounds(32, 130, 358, 210);
		pnOptions.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tblCategoryChild = new JTable();
                tblCategoryChild.setDefaultEditor(Object.class, null);
		scrollPane_1 = new JScrollPane(tblCategoryChild, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(scrollPane_1);

		txtCategoryChildName = new JTextField();
		txtCategoryChildName.setEditable(false);
		txtCategoryChildName.setColumns(10);
		txtCategoryChildName.setBounds(154, 63, 195, 27);
		pnOptions.add(txtCategoryChildName);

		lblTnDanhMc = new JLabel("Tên danh mục con");
		lblTnDanhMc.setForeground(new Color(51, 102, 102));
		lblTnDanhMc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTnDanhMc.setBounds(23, 63, 124, 27);
		pnOptions.add(lblTnDanhMc);

		lblMDanhMc = new JLabel("Mã danh mục con");
		lblMDanhMc.setForeground(new Color(51, 102, 102));
		lblMDanhMc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMDanhMc.setBounds(23, 24, 113, 27);
		pnOptions.add(lblMDanhMc);

		txtCategoryChildId = new JTextField();
		txtCategoryChildId.setEditable(false);
		txtCategoryChildId.setColumns(10);
		txtCategoryChildId.setBounds(154, 24, 195, 27);
		pnOptions.add(txtCategoryChildId);

		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 128, 128)));
		panel_2.setBounds(0, 0, 832, 40);
		add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("DANH MỤC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(99, 9, 200, 26);
		panel_2.add(lblNewLabel);

		lblDanhMcCon = new JLabel("DANH MỤC CON");
		lblDanhMcCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhMcCon.setForeground(new Color(0, 128, 0));
		lblDanhMcCon.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDanhMcCon.setBounds(532, 9, 200, 26);
		panel_2.add(lblDanhMcCon);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/right-arrow.png")));
		lblNewLabel_1.setBounds(388, 9, 66, 22);
		panel_2.add(lblNewLabel_1);
		


	}

	// Load category table
	public void loadCategoryTable() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = {"Mã danh mục", "Tên danh mục" };
		dfm.setColumnIdentifiers(header);

		// Get list category form CategoryBLL
		Vector<CategoryDTO> listCategory = categoryBLL.getCategories();
		for (CategoryDTO categoryDTO : listCategory) {
			String[] row = { categoryDTO.getId_category(), categoryDTO.getName() };
			dfm.addRow(row);
		}
		tblCategory.setModel(dfm);
	}

	// Load category child table
	public void loadCategoryChildTable(String category) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã danh mục con", "Mã danh mục", "Tên danh mục con" };
		dfm.setColumnIdentifiers(header);

		// Get list category form CategoryBLL
		Vector<CategoryChildDTO> listCategoryChild = categoryChildBLL.getCategoryChildsByCategoryId(category);
		for (CategoryChildDTO categorychildDTO : listCategoryChild) {
			String[] row = { categorychildDTO.getId_categorychild(), category, categorychildDTO.getName() };
			dfm.addRow(row);
		}
		tblCategoryChild.setModel(dfm);
	}

	public void addEvents() {
		tblCategory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblCategory.getSelectedRow();
				
				CategoryDTO categoryDTO = categoryBLL.getCategoryById(String.valueOf(tblCategory.getValueAt(row, 0)));
				txtCategoryId.setText(categoryDTO.getId_category());
				txtCategoryName.setText(categoryDTO.getName());

				// Load table CategoryChild
				loadCategoryChildTable(String.valueOf(tblCategory.getValueAt(row, 0)));
			}
		});

		tblCategoryChild.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblCategoryChild.getSelectedRow();
				
				CategoryChildDTO categoryChildDTO = categoryChildBLL.getCategoryChildById(String.valueOf(tblCategoryChild.getValueAt(row, 0)));
				txtCategoryChildId.setText(categoryChildDTO.getId_categorychild());
				txtCategoryChildName.setText(categoryChildDTO.getName());
				
			}
		});
                // Xử lý Thêm danh mục
		btnAddCategory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				date = new Date();
				// Kich hoat textfield
				txtCategoryName.setEditable(true);
				txtCategoryId.setText("CA" + date.getTime());
				txtCategoryName.setText("");
				disabledButtonInCategory();
			
				btnConfirm = new JButton("Xác nhận");
				btnConfirm.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirm.setForeground(new Color(255, 255, 224));
				btnConfirm.setBackground(new Color(0, 128, 128));
				btnConfirm.setBounds(233, 55, 165, 30);
				pnDetails.add(btnConfirm);
				refreshComponents();

				btnConfirm.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						CategoryDTO categoryDTO = new CategoryDTO(txtCategoryId.getText(), txtCategoryName.getText());
						int kq = categoryBLL.insert(categoryDTO);
						if (kq == 1) {
							JOptionPane.showMessageDialog(null, "Thêm danh mục thành công!");
							txtCategoryName.setEditable(false);
							pnDetails.remove(btnConfirm);
							loadCategoryTable();
							refreshComponents();
							enabledButtonInCategory();
						} else if(kq == 2){
							JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại!");
						}
					}
				});
			}
		});
		
		
		btnUpdateCategory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Kich hoat textfield
				int row = tblCategory.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn danh mục cần sửa!");
					return;
				}
				String id_category =  String.valueOf(tblCategory.getValueAt(row, 0));
				txtCategoryName.setEditable(true);
				txtCategoryName.setText("");
				disabledButtonInCategory();
			
				btnConfirm = new JButton("Xác nhận");
				btnConfirm.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirm.setForeground(new Color(255, 255, 224));
				btnConfirm.setBackground(new Color(0, 128, 128));
				btnConfirm.setBounds(233, 55, 165, 30);
				pnDetails.add(btnConfirm);
				refreshComponents();
				btnConfirm.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						CategoryDTO categoryDTO = new CategoryDTO(txtCategoryId.getText(), txtCategoryName.getText());
						int kq = categoryBLL.update(categoryDTO);
						if (kq == 1) {
							JOptionPane.showMessageDialog(null, "Sửa thành công!");
							txtCategoryName.setEditable(false);
							pnDetails.remove(btnConfirm);
							loadCategoryTable();
							refreshComponents();
							enabledButtonInCategory();
						} else if(kq == 2){
							JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại!");
						}
					}
				});
			}
		});		
		
                btnRemoveCategory.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = tblCategory.getSelectedRow();
                        if(row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn danh mục cần xóa!");
                            return; 
                        }
                        int rs = JOptionPane.showConfirmDialog(null, "Xác nhận xóa danh mục!");
                        if (rs == 0) {
                            String id_category =  String.valueOf(tblCategory.getValueAt(row, 0)); 
                            CategoryDTO categoryDTO = new CategoryDTO();
                            categoryDTO.setId_category(id_category);
                            int kq = categoryBLL.delete(categoryDTO);
                            if (kq == 1) {
                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                                loadCategoryTable(); 
                            } else {
                                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                            }
                        }
                    }
                });
		
                // Xử lý thêm danh mục con		
		btnAddCategoryChild.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Kich hoat textfield
				date = new Date();
				txtCategoryChildName.setEditable(true);
				txtCategoryChildId.setText("CC" + date.getTime());
				txtCategoryChildName.setText("");
				disabledButtonInCategoryChild();
			
				btnConfirmCategoryChild = new JButton("Xác nhận");
				btnConfirmCategoryChild.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirmCategoryChild.setForeground(new Color(255, 255, 224));
				btnConfirmCategoryChild.setBackground(new Color(0, 128, 128));
				btnConfirmCategoryChild.setBounds(233, 54, 177, 30);
				pnDetails_1.add(btnConfirmCategoryChild);
				refreshComponents();

				btnConfirmCategoryChild.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						CategoryChildDTO categorychildDTO = new CategoryChildDTO(txtCategoryChildId.getText(),new CategoryDTO(txtCategoryId.getText()),txtCategoryChildName.getText());
						int kq = categoryChildBLL.insert(categorychildDTO);
						if (kq == 1) {
							JOptionPane.showMessageDialog(null, "Thêm danh mục con thành công!");
							txtCategoryChildName.setEditable(false);
							pnDetails_1.remove(btnConfirmCategoryChild);
							int row = tblCategory.getSelectedRow();
							loadCategoryChildTable(String.valueOf(tblCategory.getValueAt(row, 0)));
							refreshComponents();
							enabledButtonInCategoryChild();
						} else if(kq == 2){
							JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại!");
						}
					}
				});
			}
		});
		btnUpdateCategoryChild.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Kich hoat textfield
				int row = tblCategoryChild.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn danh mục con cần sửa!");
					return;
				}
				String id_category =  String.valueOf(tblCategoryChild.getValueAt(row, 0));
				txtCategoryChildName.setEditable(true);
				txtCategoryChildName.setText("");
				disabledButtonInCategoryChild();
			
				btnConfirmCategoryChild = new JButton("Xác nhận");
				btnConfirmCategoryChild.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirmCategoryChild.setForeground(new Color(255, 255, 224));
				btnConfirmCategoryChild.setBackground(new Color(0, 128, 128));
				btnConfirmCategoryChild.setBounds(233, 54, 177, 30);
				pnDetails_1.add(btnConfirmCategoryChild);
				refreshComponents();
				btnConfirmCategoryChild.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						CategoryChildDTO categorychildDTO = new CategoryChildDTO(txtCategoryChildId.getText(), txtCategoryChildName.getText());
						int kq = categoryChildBLL.update(categorychildDTO);
						if (kq == 1) {
							JOptionPane.showMessageDialog(null, "Sửa thành công!");
							txtCategoryChildName.setEditable(false);
							pnDetails_1.remove(btnConfirm);
							int row = tblCategory.getSelectedRow();
							loadCategoryChildTable(String.valueOf(tblCategory.getValueAt(row, 0)));
							refreshComponents();
							enabledButtonInCategoryChild();
						} else if(kq == 2){
							JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại!");
						}
					}
				});
			}
		});
                btnRemoveCategoryChild.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = tblCategoryChild.getSelectedRow(); 
                        if(row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn danh mục con cần xóa!");
                            return; 
                        }
                        int rs = JOptionPane.showConfirmDialog(null, "Xác nhận xóa danh mục!");
                        if (rs == 0) {
                            String id_categorychild =  String.valueOf(tblCategoryChild.getValueAt(row, 0)); 
                            int kq = categoryChildBLL.delete(id_categorychild);
                            if (kq == 1) {
                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                                int row2 = tblCategory.getSelectedRow();
                                loadCategoryChildTable(String.valueOf(tblCategory.getValueAt(row2, 0))); 
                            } else {
                                JOptionPane.showMessageDialog(null, "Thất bại!");
                            }
                        }
                    }
                });

		
	}

	public void refreshComponents() {
		this.repaint();
		this.revalidate();
	}
	
	public void disabledButtonInCategory() {
		btnAddCategory.setEnabled(false);
		btnRemoveCategory.setEnabled(false);
		btnUpdateCategory.setEnabled(false);
	}
	
	public void enabledButtonInCategory() {
		btnAddCategory.setEnabled(true);
		btnRemoveCategory.setEnabled(true);
		btnUpdateCategory.setEnabled(true);
	}
	public void disabledButtonInCategoryChild() {
		btnAddCategoryChild.setEnabled(false);
		btnRemoveCategoryChild.setEnabled(false);
		btnUpdateCategoryChild.setEnabled(false);
	}
	
	public void enabledButtonInCategoryChild() {
		btnAddCategoryChild.setEnabled(true);
		btnRemoveCategoryChild.setEnabled(true);
		btnUpdateCategoryChild.setEnabled(true);
	}

}