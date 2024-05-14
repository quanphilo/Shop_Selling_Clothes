package GUI.SupplierAndBrandGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import BLL.BrandBLL;
import BLL.SupplierBLL;
import DTO.BrandDTO;
import DTO.SupplierDTO;
import GUI.CategoryGUI.CategoryForm;


public class SupplierAndBrandForm extends JPanel {

	private JPanel pnOrder;
	private JLabel lblMNcc;
	private JButton btnAddSupplier;
	private JButton btnUpdateSupplier;
	private JButton btnDeleteSupplier;
	private JButton btnConfirmSupplier;
	private JButton btnConfirmBrand;
        private JButton btnSearchSupplier;
	private JTextField txtIdSupplier;
	private JTextField txtSupplierName;
        private JTextField txtSearchSupplier;
	private JLabel lblTnNcc;
	private JPanel pnDetails;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JTextField txtAddress;
	private JTable tblSupplier;
	
	private SupplierBLL supplierBLL = new SupplierBLL();
	private BrandBLL brandBLL = new BrandBLL();
	private Date date = new Date();
	

	public SupplierAndBrandForm() {
		initComponents();
		addEvents();
		loadTableSupplier();
		loadTableBrand();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 490);

		pnOrder = new JPanel();
		pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
		pnOrder.setBounds(0, 40, 832, 450);
		add(pnOrder);
		pnOrder.setLayout(null);

		pnDetails = new JPanel();
		pnDetails.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnDetails.setBounds(0, 399, 832, 51);
		pnOrder.add(pnDetails);
		pnDetails.setLayout(null);

		btnAddSupplier = new JButton("Thêm NCC");
		btnAddSupplier.setIcon(new ImageIcon(SupplierAndBrandForm.class.getResource("/images/manufacture.png")));
		btnAddSupplier.setForeground(new Color(255, 255, 224));
		btnAddSupplier.setBackground(new Color(0, 128, 128));
		btnAddSupplier.setBounds(114, 11, 153, 30);
		pnDetails.add(btnAddSupplier);

		btnUpdateSupplier = new JButton("Sửa NCC");
		btnUpdateSupplier.setIcon(new ImageIcon(SupplierAndBrandForm.class.getResource("/images/edit-icon.png")));

		btnUpdateSupplier.setForeground(new Color(255, 255, 224));
		btnUpdateSupplier.setBackground(new Color(0, 128, 128));
		btnUpdateSupplier.setBounds(322, 11, 165, 30);
		pnDetails.add(btnUpdateSupplier);

		btnDeleteSupplier = new JButton("Xóa NCC");
		btnDeleteSupplier.setIcon(new ImageIcon(SupplierAndBrandForm.class.getResource("/images/delete-icon.png")));
		btnDeleteSupplier.setForeground(new Color(255, 255, 224));
		btnDeleteSupplier.setBackground(new Color(0, 128, 128));
		btnDeleteSupplier.setBounds(540, 11, 153, 30);
		pnDetails.add(btnDeleteSupplier);
		

		JPanel pnAction = new JPanel();
		pnAction.setBounds(0, 0, 832, 387);
		pnOrder.add(pnAction);
		pnAction.setLayout(null);

		lblMNcc = new JLabel("Mã NCC");
		lblMNcc.setForeground(new Color(0, 100, 0));
		lblMNcc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMNcc.setBounds(47, 13, 78, 27);
		pnAction.add(lblMNcc);

		txtIdSupplier = new JTextField();
		txtIdSupplier.setEditable(false);
		txtIdSupplier.setColumns(10);
		txtIdSupplier.setBounds(156, 13, 238, 27);
		pnAction.add(txtIdSupplier);

		txtSupplierName = new JTextField();
		txtSupplierName.setEditable(false);
		txtSupplierName.setColumns(10);
		txtSupplierName.setBounds(156, 49, 238, 27);
		pnAction.add(txtSupplierName);

		lblTnNcc = new JLabel("Tên NCC");
		lblTnNcc.setForeground(new Color(0, 100, 0));
		lblTnNcc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnNcc.setBounds(47, 50, 78, 27);
		pnAction.add(lblTnNcc);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh sách NCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(32, 135, 767, 252);
		pnAction.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tblSupplier = new JTable();
		tblSupplier.setDefaultEditor(Object.class, null);
		scrollPane = new JScrollPane(tblSupplier, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(new Color(0, 100, 0));
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiaChi.setBounds(47, 86, 78, 27);
		pnAction.add(lblDiaChi);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(156, 86, 238, 27);
		pnAction.add(txtAddress);
                                 
                txtSearchSupplier = new JTextField();
                txtSearchSupplier.setColumns(10);
                txtSearchSupplier.setBounds(424, 49, 220, 27);
                pnAction.add(txtSearchSupplier);
                
                btnSearchSupplier = new JButton("Tìm kiếm");
                btnSearchSupplier.setIcon(new ImageIcon(SupplierAndBrandForm.class.getResource("/images/search-icon.png")));
                btnSearchSupplier.setForeground(new Color(255, 255, 224));
                btnSearchSupplier.setBackground(new Color(0, 128, 128));
                btnSearchSupplier.setBounds(654, 49, 120, 27); 
                pnAction.add(btnSearchSupplier);

		DefaultTableModel dtmHD = new DefaultTableModel();
		String[] headerHD = { "Mã NV", "Tên NV", "SĐT", "Chức vụ" };
		dtmHD.setColumnIdentifiers(headerHD);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 128, 128)));
		panel_2.setBounds(0, 0, 832, 40);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel.setBounds(313, 10, 206, 20);
		panel_2.add(lblNewLabel);

	}
	
	public void addEvents() {
		tblSupplier.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblSupplier.getSelectedRow();
				
				SupplierDTO supplierDTO = supplierBLL.getSupplierById(String.valueOf(tblSupplier.getValueAt(row, 0)));
				txtIdSupplier.setText(supplierDTO.getId_supplier());
				txtSupplierName.setText(supplierDTO.getName());
				txtAddress.setText(supplierDTO.getAddress());
			}
		});
		btnSearchSupplier.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            String searchText = txtSearchSupplier.getText().trim();
                            if (searchText.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập nội dung tìm kiếm.");
                            } else {
                                DefaultTableModel dfm = new DefaultTableModel();
                                String[] header = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ"};
                                dfm.setColumnIdentifiers(header);

                                Vector<SupplierDTO> filteredList = supplierBLL.searchSuppliers(searchText);
                                for (SupplierDTO supplier : filteredList) {
                                    String[] row = {
                                        supplier.getId_supplier(), supplier.getName(), supplier.getAddress()
                                    };
                                    dfm.addRow(row);
                                }
                                tblSupplier.setModel(dfm);
                            }
                        }
                    });                    
                
		// Xử lý tbl Supplier
		btnAddSupplier.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				date = new Date();
				txtSupplierName.setEditable(true);
				txtAddress.setEditable(true);
				
				txtIdSupplier.setText("SU" + date.getTime());
				txtSupplierName.setText("");
				txtAddress.setText("");
				
				disableButtoninSupplier();
				
				btnConfirmSupplier = new JButton("Xác nhận");
				btnConfirmSupplier.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirmSupplier.setForeground(new Color(255, 255, 224));
				btnConfirmSupplier.setBackground(new Color(0, 128, 128));
				btnConfirmSupplier.setBounds(630, 11, 165, 30);
				pnDetails.add(btnConfirmSupplier);
				refreshComponents();
				btnConfirmSupplier.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						try {
							SupplierDTO supplierDTO = new SupplierDTO(
									txtIdSupplier.getText(), txtSupplierName.getText(), txtAddress.getText()
									);
							int kq = supplierBLL.insert(supplierDTO);
							if(kq == 1) {
								JOptionPane.showMessageDialog(null, "Thêm thành công!");
								txtSupplierName.setEditable(false);
                                                                txtAddress.setEditable(false);
								pnDetails.remove(btnConfirmSupplier);
								loadTableSupplier();
								refreshComponents();
								enableButtoninSupplier();
							}else if(kq == 2){
								JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null,"Thất bại");
						}
					}
				});
				
			}
		});
		
		btnUpdateSupplier.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int row = tblSupplier.getSelectedRow();
				if(row < 0) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần sửa!");
                                    return;
				}
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần sửa!");
                                String id_supplier = String.valueOf(tblSupplier.getValueAt(row, 0));
				txtSupplierName.setEditable(true);
				txtAddress.setEditable(true);
				
				txtSupplierName.setText("");
				txtAddress.setText("");
	
				disableButtoninSupplier();
				
                                
				btnConfirmSupplier = new JButton("Xác nhận");
				btnConfirmSupplier.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirmSupplier.setForeground(new Color(255, 255, 224));
				btnConfirmSupplier.setBackground(new Color(0, 128, 128));
				btnConfirmSupplier.setBounds(630, 11, 165, 30);
				pnDetails.add(btnConfirmSupplier);
				refreshComponents();
				
				btnConfirmSupplier.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						try {
							SupplierDTO supplierDTO = new SupplierDTO(
									txtIdSupplier.getText(), txtSupplierName.getText(), txtAddress.getText()
									);
							int kq = supplierBLL.update(supplierDTO);
							if(kq == 1) {
								JOptionPane.showMessageDialog(null, "Sửa thành công!");
								txtSupplierName.setEditable(false);
                                                                txtAddress.setEditable(false);
								pnDetails.remove(btnConfirmSupplier);
								loadTableSupplier();
								refreshComponents();
								enableButtoninSupplier();
							}else if(kq == 2){
								JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
							} else {
								JOptionPane.showMessageDialog(null, "Sửa thất bại!");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		
                btnDeleteSupplier.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = tblSupplier.getSelectedRow(); 
                        if(row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần xóa!");
                            return;
                        }
                        int rs = JOptionPane.showConfirmDialog(null, "Xác nhận xóa nhà cung cấp!");
                        if (rs == 0) {
                            String supplierId = String.valueOf(tblSupplier.getValueAt(row, 0));
                            int kq = supplierBLL.delete(supplierId, 0);
                            if(kq == 1) {
                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                                removeSupplierFromTable(supplierId);
                            } else {
                                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                            }
                        }
                    }
                });
            }
        // Phương thức để loại bỏ NCC ra khỏi bảng tblSupplier
        private void removeSupplierFromTable(String supplierId) {
                DefaultTableModel model = (DefaultTableModel) tblSupplier.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(supplierId)) {
                        model.removeRow(i);
                        return;
                    }
                }                
            }
	public void refreshComponents() {
		this.repaint();
		this.revalidate();
	}
	public void disableButtoninSupplier() {
		btnAddSupplier.setEnabled(false);
		btnUpdateSupplier.setEnabled(false);
		btnDeleteSupplier.setEnabled(false);
	}
	public void enableButtoninSupplier() {
		btnAddSupplier.setEnabled(true);
		btnUpdateSupplier.setEnabled(true);
		btnDeleteSupplier.setEnabled(true);
	}

	
        // Load Table Supplier
	public void loadTableSupplier() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ"};
		dfm.setColumnIdentifiers(header);
			
		Vector<SupplierDTO> listSupplier = supplierBLL.getSuppliers();
		for(SupplierDTO supplierDTO : listSupplier) {
			String[] row = {
					supplierDTO.getId_supplier(), supplierDTO.getName(), supplierDTO.getAddress()
			};
			dfm.addRow(row);

		}
		tblSupplier.setModel(dfm);
	}
	public void loadTableBrand() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = {"Mã thương hiệu", "Tên thương hiệu"};
		dfm.setColumnIdentifiers(header);
					
		Vector<BrandDTO> listBrand = brandBLL.getBrands();
		for(BrandDTO brandDTO : listBrand) {
			String[] row = {
					brandDTO.getId_brand(), brandDTO.getName()
			};
			dfm.addRow(row);
			}
		}
}