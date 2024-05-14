package GUI.WarehouseReceiptGUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import BLL.BrandBLL;
import BLL.CategoryChildBLL;
import BLL.ProductBLL;
import BLL.SupplierBLL;
import BLL.WarehouseReceiptBLL;
import BLL.WarehouseReceiptDetailBLL;
import Cores.CopyImage;
import Cores.Format;
import DTO.BrandDTO;
import DTO.CategoryChildDTO;
import DTO.EmployeeDTO;
import DTO.ProductDTO;
import DTO.SupplierDTO;
import DTO.WarehouseReceiptDTO;
import DTO.WarehouseReceiptDetailDTO;

public class AddWarehouseReceipDialog extends JDialog {
	private Date date = new Date();
	private CategoryChildBLL categoryBLL = new CategoryChildBLL();
	private WarehouseReceiptBLL warehouseReceiptBLL = new WarehouseReceiptBLL();
	private SupplierBLL supplierBLL = new SupplierBLL();
	private BrandBLL brandBLL = new BrandBLL();
	private WarehouseReceiptDetailBLL warehouseReceiptDetailBLL = new WarehouseReceiptDetailBLL();
	private ProductBLL productBLL = new ProductBLL();

	private Vector<CategoryChildDTO> listCategoryChild = categoryBLL.getCategoryChilds();
	Vector<SupplierDTO> listSupplier = supplierBLL.getSuppliers();
	Vector<BrandDTO> listBrand = brandBLL.getBrands();

	private static String id_product_exists = null;
	private boolean newBrand = true;

	private BrandDTO brandDTO = new BrandDTO();

	private JTextField txtWareId;
	private JTextField txtTotalPrice;
	private JTextField txtEmployeeId;
	private JTextField txtDate;
	private static JComboBox<SupplierDTO> cboNCC;
	private JTextField txtProductQuantity;
	private static JTextField txtProductName;
	private JTextField txtPriceProduct;
	private static JTextField txtProductBrand;
	private JButton btnAddToList;
	private JTable tblDetail;

	private Vector<ProductDTO> listProductDetail = new Vector<ProductDTO>();
	private static JComboBox<CategoryChildDTO> cboCategory;

	private JButton btnCancel;
	private JButton btnAccept;
	private EmployeeDTO employeeDTO;
	private float totalPrice = 0;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JButton btnBrand;
	private JLabel nameImage;
	private static JLabel image;
	private JButton btnUpload;
	private JButton btnProductExists;

	public AddWarehouseReceipDialog(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
		initComponents();
		addEvents();
		loadDetailTable();
	}

	public void initComponents() {
		setSize(830, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel pnWarehouse = new JPanel();
		pnWarehouse.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Phiếu nhập",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		pnWarehouse.setBounds(387, 40, 427, 371);
		getContentPane().add(pnWarehouse);
		pnWarehouse.setLayout(null);

		JPanel pnWareInfos = new JPanel();
		pnWareInfos.setBounds(8, 20, 428, 114);
		pnWareInfos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 139, 139)));
		pnWarehouse.add(pnWareInfos);
		pnWareInfos.setLayout(null);

		txtWareId = new JTextField("WA" + date.getTime());
		txtWareId.setEditable(false);
		txtWareId.setColumns(10);
		txtWareId.setBounds(99, 8, 125, 20);
		pnWareInfos.add(txtWareId);

		JLabel lblMPhiuNhp = new JLabel("Mã phiếu nhập");
		lblMPhiuNhp.setForeground(new Color(0, 100, 0));
		lblMPhiuNhp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMPhiuNhp.setBounds(12, 10, 88, 17);
		pnWareInfos.add(lblMPhiuNhp);

		JLabel lblTngTin = new JLabel("Tổng tiền (triệu đ)");
		lblTngTin.setForeground(new Color(0, 100, 0));
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngTin.setBounds(233, 10, 110, 17);
		pnWareInfos.add(lblTngTin);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setBounds(344, 10, 72, 20);
		pnWareInfos.add(txtTotalPrice);

		JLabel lblNhCc = new JLabel("Nhà CC");
		lblNhCc.setForeground(new Color(0, 100, 0));
		lblNhCc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhCc.setBounds(12, 47, 72, 17);
		pnWareInfos.add(lblNhCc);

		cboNCC = new JComboBox<SupplierDTO>(listSupplier);
		cboNCC.setBounds(75, 44, 125, 25);
		pnWareInfos.add(cboNCC);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setForeground(new Color(0, 100, 0));
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNhnVin.setBounds(219, 47, 81, 17);
		pnWareInfos.add(lblMNhnVin);

		txtEmployeeId = new JTextField(employeeDTO.getId());
		txtEmployeeId.setEditable(false);
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(306, 46, 110, 20);
		pnWareInfos.add(txtEmployeeId);

		JLabel lblNgyNhp = new JLabel("Ngày nhập");
		lblNgyNhp.setForeground(new Color(0, 100, 0));
		lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgyNhp.setBounds(12, 82, 66, 17);
		pnWareInfos.add(lblNgyNhp);

		txtDate = new JTextField(sdf.format(date));
		txtDate.setOpaque(false);
		txtDate.setColumns(10);
                txtDate.setEditable(false);
		txtDate.setBounds(85, 81, 125, 20);
		pnWareInfos.add(txtDate);

		JPanel pnWareTable = new JPanel();
		pnWareTable.setBorder(new TitledBorder(null, "Chi tiết phiếu nhập", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 100, 0)));
		pnWareTable.setBounds(4, 146, 430, 169);
		pnWarehouse.add(pnWareTable);
		pnWareTable.setLayout(new BorderLayout(0, 0));

		tblDetail = new JTable();
		JScrollPane scrollPane_1 = new JScrollPane(tblDetail, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnWareTable.add(scrollPane_1, BorderLayout.CENTER);
                tblDetail.setDefaultEditor(Object.class, null);

		JPanel pnWareAction = new JPanel();
		pnWareAction.setBounds(4, 316, 415, 54);
		pnWarehouse.add(pnWareAction);
		pnWareAction.setLayout(null);

		btnAccept = new JButton("Xác nhận");
		btnAccept.setIcon(new ImageIcon(AddWarehouseReceipDialog.class.getResource("/images/checkmark.png")));
		btnAccept.setBounds(42, 12, 156, 26);
		btnAccept.setForeground(new Color(255, 255, 224));
		btnAccept.setBackground(new Color(0, 128, 128));
		pnWareAction.add(btnAccept);

		btnCancel = new JButton("HỦY");
		btnCancel.setIcon(new ImageIcon(AddWarehouseReceipDialog.class.getResource("/images/remove.png")));
		btnCancel.setBounds(231, 12, 139, 26);
		btnCancel.setForeground(new Color(255, 255, 224));
		btnCancel.setBackground(new Color(0, 128, 128));
		pnWareAction.add(btnCancel);

		JPanel pnDetails = new JPanel();
		pnDetails.setBorder(null);
		pnDetails.setInheritsPopupMenu(true);
		pnDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnDetails.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnDetails.setDoubleBuffered(false);
		pnDetails.setForeground(new Color(255, 255, 255));
		pnDetails.setBounds(0, 40, 375, 371);
		getContentPane().add(pnDetails);
		pnDetails.setLayout(null);

		btnAddToList = new JButton("Thêm vào chi tiết phiếu");
		btnAddToList.setIcon(new ImageIcon(AddWarehouseReceipDialog.class.getResource("/images/homeicon/invoice.png")));
		btnAddToList.setForeground(new Color(255, 255, 224));
		btnAddToList.setBackground(new Color(0, 128, 128));
		btnAddToList.setBounds(92, 330, 211, 26);
		pnDetails.add(btnAddToList);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setBounds(-6, 0, 380, 311);
		pnDetails.add(panel);

		image = new JLabel("");
		image.setBorder(new LineBorder(new Color(0, 0, 0)));
		image.setIcon(null);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(12, 36, 128, 145);
		panel.add(image);

		txtProductQuantity = new JTextField();
		txtProductQuantity.setOpaque(false);
		txtProductQuantity.setColumns(10);
		txtProductQuantity.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Số lượng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductQuantity.setBounds(296, 244, 72, 44);
		panel.add(txtProductQuantity);

		txtProductName = new JTextField();
		txtProductName.setOpaque(false);
		txtProductName.setColumns(10);
		txtProductName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Tên sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductName.setBounds(158, 59, 210, 44);
		panel.add(txtProductName);

		txtPriceProduct = new JTextField();
		txtPriceProduct.setOpaque(false);
		txtPriceProduct.setColumns(10);
		txtPriceProduct.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Giá nhập (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtPriceProduct.setBounds(158, 244, 136, 44);
		panel.add(txtPriceProduct);

		txtProductBrand = new JTextField();
		txtProductBrand.setOpaque(false);
		txtProductBrand.setColumns(10);
		txtProductBrand.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Thương hiệu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductBrand.setBounds(158, 125, 103, 44);
		panel.add(txtProductBrand);

		JLabel lblNewLabel_2 = new JLabel("Danh mục");
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setBounds(158, 193, 72, 25);
		panel.add(lblNewLabel_2);

		cboCategory = new JComboBox<CategoryChildDTO>(listCategoryChild);
		cboCategory.setBounds(240, 193, 128, 25);
		panel.add(cboCategory);

		btnBrand = new JButton("TH đã có ...");
		btnBrand.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 0)));
		btnBrand.setForeground(new Color(0, 128, 0));
		btnBrand.setBackground(new Color(255, 255, 255));
		btnBrand.setBounds(273, 135, 95, 30);
		panel.add(btnBrand);

		nameImage = new JLabel("");
		nameImage.setBounds(12, 193, 128, 16);
		panel.add(nameImage);

		btnUpload = new JButton("Tải hình");
		btnUpload.setBorder(new LineBorder(new Color(0, 100, 0), 2));
		btnUpload.setOpaque(false);
		btnUpload.setIcon(new ImageIcon(AddWarehouseReceipDialog.class.getResource("/images/upload.png")));
		btnUpload.setForeground(new Color(0, 100, 0));
		btnUpload.setBackground(Color.WHITE);
		btnUpload.setBounds(12, 226, 106, 26);
		panel.add(btnUpload);

		btnProductExists = new JButton("Sản phẩm đã có");
		btnProductExists
				.setIcon(new ImageIcon(AddWarehouseReceipDialog.class.getResource("/images/clothes-hanger 24.png")));
		btnProductExists.setForeground(new Color(255, 255, 224));
		btnProductExists.setBackground(new Color(0, 128, 128));
		btnProductExists.setBounds(158, 21, 156, 26);
		panel.add(btnProductExists);

		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnHeader.setBounds(0, 0, 814, 28);
		getContentPane().add(pnHeader);

		JLabel lblNewLabel = new JLabel("THÊM PHIẾU NHẬP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		pnHeader.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBackground(new Color(0, 128, 0));
		separator.setBounds(381, 30, 2, 433);
		getContentPane().add(separator);
	}

	public void addEvents() {
		btnBrand.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JComboBox<BrandDTO> cboBrand = new JComboBox<BrandDTO>(listBrand);
				int rs = JOptionPane.showConfirmDialog(null, cboBrand);
				if (rs == 0) { // say "Yes"
					for (BrandDTO item : listBrand) {
						if (item.getName().equals(String.valueOf(cboBrand.getSelectedItem()))) {
							brandDTO = item;
							txtProductBrand.setText(String.valueOf(cboBrand.getSelectedItem()));
							txtProductBrand.setEditable(false);
							break;
						}
					}
					newBrand = false;
				}
			};
		});

		btnAddToList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProductDTO productDTO;
                                
                                if (txtProductName.getText().isEmpty() || txtProductBrand.getText().isEmpty() ||
                                    txtPriceProduct.getText().isEmpty() || txtProductQuantity.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                                    return;
                                }
                                if (!isNumeric(txtPriceProduct.getText()) || !isNumeric(txtProductQuantity.getText())) {
                                    JOptionPane.showMessageDialog(null, "Giá nhập và số lượng phải là số > 0!");
                                    return;
                                }
                                
				if (id_product_exists != null) {
					productDTO = productBLL.getProductById(id_product_exists);
					productDTO.setQuantity(Integer.valueOf(txtProductQuantity.getText()));
					productDTO.setPrice(Float.valueOf(txtPriceProduct.getText()));
				} else {
					date = new Date();
					if (newBrand) {
						brandDTO.setId_brand("BR" + date.getTime());
						brandDTO.setName(txtProductBrand.getText());
						if (brandBLL.insert(brandDTO) == 0) {
							JOptionPane.showMessageDialog(null, "Lỗi thương hiệu!");
							return;
						}
					}

					if (brandDTO.getId_brand().equals(null)) {
						brandDTO.setId_brand("BR" + date.getTime());
						brandDTO.setName(txtProductBrand.getText());
					}
					CategoryChildDTO categoryChildDTO = new CategoryChildDTO();
					for (CategoryChildDTO categorychild : listCategoryChild) {
						if (categorychild.getName().equals(String.valueOf(cboCategory.getSelectedItem()))) {
							categoryChildDTO.setId_categorychild(categorychild.getId_categorychild());
							categoryChildDTO.setName(categorychild.getName());
						}
					}
					String id_product = "PR" + date.getTime();
					// check validation
					if (txtProductName.getText().isBlank() || txtProductName.getText().isBlank()
							|| txtProductQuantity.getText().isBlank() || txtPriceProduct.getText().isBlank()
							|| txtProductBrand.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
						return;
					}
					if (Format.isNumber(txtPriceProduct.getText()) == 0
							|| Format.isNumber(txtProductQuantity.getText()) == 0) {
						JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ!");
						return;
					}

					if (nameImage.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng upload ảnh!");
						return;
					}
					productDTO = new ProductDTO(
							id_product,
							brandDTO,
							categoryChildDTO,
							txtProductName.getText(),
							Integer.parseInt(txtProductQuantity.getText()),
							Float.parseFloat(txtPriceProduct.getText()),
							nameImage.getText(),
							0);
				}

				totalPrice = ((totalPrice + productDTO.getPrice() * productDTO.getQuantity()));
				txtTotalPrice.setText(String.valueOf(totalPrice / 1000000));
				listProductDetail.add(productDTO);
				loadDetailTable();
				blankTextField();
				id_product_exists = null;
			}
		});

		btnProductExists.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProductDialog productDialog = new ProductDialog();
				productDialog.setVisible(true);
			}
		});

		btnCancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				closeDialog();
			}
		});

		btnUpload.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectFile();
			}
		});

		btnAccept.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					if (txtTotalPrice.getText().equals("") || txtDate.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ!");
						return;
					}
					SupplierDTO supplierDTO = new SupplierDTO();
					for (SupplierDTO item : listSupplier) {
						if (item.getName().equals(String.valueOf(cboNCC.getSelectedItem()))) {
							supplierDTO.setId_supplier(item.getId_supplier());
							supplierDTO.setName(item.getName());
							supplierDTO.setAddress(item.getAddress());
							break;
						}
					}
					WarehouseReceiptDTO warehouseReceiptDTO = new WarehouseReceiptDTO(
							txtWareId.getText(),
							supplierDTO,
							employeeDTO,
							sdf.parse(txtDate.getText()),
							Float.valueOf(txtTotalPrice.getText()) * 1000000);

					// get warehousereceipt
					int kq1 = warehouseReceiptBLL.insert(warehouseReceiptDTO);
					if (kq1 == 1) {
						// get warehousereceiptdetail
						for (ProductDTO productDTO : listProductDetail) {
							ProductDTO productInsert = new ProductDTO(
									productDTO.getId_product(),
									productDTO.getBrand(),
									productDTO.getCategorychild(),
									productDTO.getName(),
									productDTO.getQuantity(),
									productDTO.getPrice(),
									productDTO.getImage(),
									productDTO.getStatus());
							if (checkExistProduct(productDTO.getId_product()) == 0) {
								productInsert.setPrice(0);
								int kq3 = productBLL.insert(productInsert);
								if (kq3 == 0) {
									JOptionPane.showMessageDialog(null, "Lỗi sản phẩm!");
									return;
								}
							} else {
								productInsert
										.setPrice(productBLL.getProductById(productInsert.getId_product()).getPrice());
								productInsert.setQuantity(productInsert.getQuantity()
										+ productBLL.getProductById(productInsert.getId_product()).getQuantity());
								productBLL.update(productInsert);
							}
						}

						for (ProductDTO productDTO : listProductDetail) {

							WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = new WarehouseReceiptDetailDTO(
									warehouseReceiptDTO,
									productDTO,
									productDTO.getQuantity(),
									productDTO.getPrice());
							int kq2 = warehouseReceiptDetailBLL.insert(warehouseReceiptDetailDTO);

							closeDialog();
						}
						JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thành công!");
						closeDialog();
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi phiếu nhập!");
						return;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}

	public static void loadProductExists(ProductDTO product_exists, CategoryChildDTO category, BrandDTO brand) {
		txtProductName.setText(product_exists.getName());
		txtProductBrand.setText(brand.getName());
		image.setIcon(
				new ImageIcon(CopyImage.resizeImage(".\\src\\images\\product\\" + product_exists.getImage(), image)));
		cboCategory.getModel().setSelectedItem(category);
	}

	public void selectFile() {
		FileDialog chooser = new FileDialog(new Frame(), "Chọn hình ảnh", FileDialog.LOAD);
		chooser.setVisible(true);
		if (chooser.getFile() != null && chooser.getFile().contains(".png") == false
				&& chooser.getFile().contains(".jpg") == false && chooser.getFile().contains(".jpeg") == false) {
			JOptionPane.showMessageDialog(null, "Định dạng không hợp lệ");
			return;
		}
		String url = chooser.getDirectory() + chooser.getFile();
		if (url.equals("nullnull")) {
			return;
		}
		Image img = CopyImage.resizeImage(url, image);
		ImageIcon imgIcon = new ImageIcon(img);
		image.setIcon(imgIcon);
		nameImage.setText(CopyImage.getNameImage(url));
		CopyImage.copyImage(url);
	}

	public void loadDetailTable() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã SP", "Tên SP", "Số lượng", "Giá nhập" };
		dfm.setColumnIdentifiers(header);
		for (ProductDTO productDTO : listProductDetail) {
			String[] row = {
					productDTO.getId_product(),
					productDTO.getName(),
					String.valueOf(productDTO.getQuantity()),
					String.valueOf(productDTO.getPrice())
			};
			dfm.addRow(row);
		}
		tblDetail.setModel(dfm);
	}

	public int checkExistProduct(String id_product) {
		int flag = 0;
		for (ProductDTO productDTO : productBLL.getProducts()) {
			if (productDTO.getId_product().equals(id_product)) {
				flag = 1;
				return flag;
			}
		}
		return flag;
	}

	public void blankTextField() {
		txtProductName.setText("");
		txtProductBrand.setText("");
		txtPriceProduct.setText("");
		txtProductQuantity.setText("");
		txtProductBrand.setEditable(true);
                nameImage.setText("");
                image.setIcon(null);         
	}

	public static String getId_product_exists() {
		return id_product_exists;
	}

	public static void setId_product_exists(String id_product_exists) {
		AddWarehouseReceipDialog.id_product_exists = id_product_exists;
	}
        
        private boolean isNumeric(String strNum) {
            if (strNum == null) {
                return false;
            }
            try {
                double d = Double.parseDouble(strNum);
                return d > 0;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

	public void closeDialog() {
		this.dispose();
	}
}
