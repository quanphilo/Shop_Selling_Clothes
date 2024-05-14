package GUI.ProductGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import BLL.BrandBLL;
import BLL.CategoryBLL;
import BLL.CategoryChildBLL;
import BLL.OrderItemBLL;
import BLL.ProductBLL;
import BLL.ProductSaleBLL;
import BLL.WarehouseReceiptDetailBLL;
import Cores.CopyImage;
import DTO.BrandDTO;
import DTO.CategoryChildDTO;
import DTO.CustomerDTO;
import DTO.OrderItemDTO;
import DTO.ProductDTO;
import DTO.ProductSaleDTO;
import DTO.WarehouseReceiptDetailDTO;

public class ProductForm extends JPanel {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private ProductBLL productBLL = new ProductBLL();
	private CategoryBLL categoryBLL = new CategoryBLL();
	private BrandBLL brandBLL = new BrandBLL();
	private ProductSaleBLL productSaleBLL = new ProductSaleBLL();
	private CategoryChildBLL categorychildBLL = new CategoryChildBLL();
	private WarehouseReceiptDetailBLL warehouseReceiptDetailBLL = new WarehouseReceiptDetailBLL();
	private ProductSaleBLL bookSaleBLL = new ProductSaleBLL();
	private OrderItemBLL orderitemBLL = new OrderItemBLL();

	private Vector<ProductDTO> listProduct = productBLL.getProducts();
	private Vector<CategoryChildDTO> listCategoryChild = categorychildBLL.getCategoryChilds();
	private Vector<BrandDTO> listBrand = brandBLL.getBrands();
	private CategoryChildDTO categoryChildDTO = new CategoryChildDTO();
	private BrandDTO brandDTO = new BrandDTO();

	private JTextField txtProductId;
	private JTextField txtProductQuantity;
	private JTextField txtProductName;
	private JTextField txtSellPrice;
	private JTextField txtBrandName;
	private JTable tblProduct;
	private JTextField txtDiscountPercent;
	private JTextField txtWarehousePrice;
	private JTextField txtCategoryName;
	private JRadioButton radioSale;
	private JRadioButton radioActive;
	private JRadioButton radioBlock;
	private JTextField txtSalePrice;
	private JRadioButton radioWarehouseProduct;
	private JButton btnUpdate;
	private JButton btnFindBrand;
	private JButton btnFindCategoryChild;
	private JButton btnExportExcel;
	private JButton btnReload;
	private JTextField txtFilterName;
	private JButton btnFilter;
	private JRadioButton radioFilterSale;
	private JComboBox<BrandDTO> cboBrand;
	private JComboBox<CategoryChildDTO> cboCategory;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JLabel image;

	public ProductForm() {
		initComponents();
		addEvents();
		loadProductTable();
		setEditableAllTextfield(false);
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 490);

		JPanel pnProduct = new JPanel();
		pnProduct.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sản phẩm",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		pnProduct.setBounds(387, 40, 443, 450);
		add(pnProduct);
		pnProduct.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh sách sản phẩm",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_1.setBounds(12, 185, 419, 220);
		pnProduct.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tblProduct = new JTable();
                tblProduct.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane_1_1 = new JScrollPane(tblProduct, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(scrollPane_1_1);

		btnReload = new JButton("Làm mới");
		btnReload.setIcon(new ImageIcon(ProductForm.class.getResource("/images/reloading.png")));
		btnReload.setForeground(Color.WHITE);
		btnReload.setFont(new Font("Dialog", Font.BOLD, 13));
		btnReload.setBackground(new Color(0, 128, 128));
		btnReload.setBounds(240, 410, 120, 27);
		pnProduct.add(btnReload);

		btnExportExcel = new JButton("Xuất Excel");
		btnExportExcel.setIcon(new ImageIcon(ProductForm.class.getResource("/images/excel.png")));
		btnExportExcel.setForeground(Color.WHITE);
		btnExportExcel.setFont(new Font("Dialog", Font.BOLD, 13));
		btnExportExcel.setBackground(new Color(0, 128, 128));
		btnExportExcel.setBounds(80, 410, 131, 27);
		pnProduct.add(btnExportExcel);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(
				new TitledBorder(null, "Lọc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel_3.setBounds(12, 29, 408, 136);
		pnProduct.add(panel_3);

		Vector<BrandDTO> listCboBrand = new Vector<BrandDTO>();
		listCboBrand.add(null);
		listCboBrand.addAll(listBrand);
		cboBrand = new JComboBox<BrandDTO>(listCboBrand);
		cboBrand.setBounds(95, 23, 130, 25);
		panel_3.add(cboBrand);

		JLabel lblNewLabel_1 = new JLabel("Thương hiệu");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setBounds(12, 27, 73, 16);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Danh mục");
		lblNewLabel_1_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_2.setBounds(12, 64, 73, 16);
		panel_3.add(lblNewLabel_1_2);

		Vector<CategoryChildDTO> listCboCategory = new Vector<CategoryChildDTO>();
		listCboCategory.add(null);
		listCboCategory.addAll(listCategoryChild);
		cboCategory = new JComboBox<CategoryChildDTO>(listCboCategory);
		cboCategory.setBounds(95, 60, 130, 25);
		panel_3.add(cboCategory);

		btnFilter = new JButton("");
		btnFilter.setIcon(new ImageIcon(ProductForm.class.getResource("/images/search-icon.png")));
		btnFilter.setForeground(Color.WHITE);
		btnFilter.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFilter.setBackground(new Color(0, 128, 128));
		btnFilter.setBounds(235, 97, 46, 25);
		panel_3.add(btnFilter);

		radioFilterSale = new JRadioButton("Khuyến mãi");
		radioFilterSale.setForeground(new Color(0, 128, 0));
		radioFilterSale.setFont(new Font("Dialog", Font.BOLD, 13));
		radioFilterSale.setBounds(233, 60, 107, 24);
		panel_3.add(radioFilterSale);

		txtFilterName = new JTextField();
		txtFilterName.setColumns(10);
		txtFilterName.setBounds(95, 97, 130, 25);
		panel_3.add(txtFilterName);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_2_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_2_1.setBounds(12, 102, 80, 16);
		panel_3.add(lblNewLabel_1_2_1);

		JPanel pnDetails = new JPanel();
		pnDetails.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 128, 0)));
		pnDetails.setInheritsPopupMenu(true);
		pnDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnDetails.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnDetails.setDoubleBuffered(false);
		pnDetails.setForeground(new Color(255, 255, 255));
		pnDetails.setBounds(0, 32, 386, 458);
		add(pnDetails);
		pnDetails.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thông tin sản phẩm",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setBounds(2, 8, 380, 407);
		pnDetails.add(panel);
		panel.setLayout(null);

		image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setIcon(new ImageIcon(ProductForm.class.getResource("/images/Nike-Shirt-17-icon.png")));
		image.setBounds(12, 36, 128, 145);
		panel.add(image);

		txtProductId = new JTextField();
		txtProductId.setEditable(false);
		txtProductId.setOpaque(false);
		txtProductId.setBorder(new TitledBorder(null, "Mã sản phẩm", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductId.setBounds(157, 20, 211, 35);
		panel.add(txtProductId);
		txtProductId.setColumns(10);

		txtProductQuantity = new JTextField();
		txtProductQuantity.setOpaque(false);
		txtProductQuantity.setColumns(10);
		txtProductQuantity.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Số lượng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductQuantity.setBounds(207, 230, 161, 35);
		panel.add(txtProductQuantity);

		txtProductName = new JTextField();
		txtProductName.setOpaque(false);
		txtProductName.setColumns(10);
		txtProductName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Tên sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductName.setBounds(158, 60, 210, 35);
		panel.add(txtProductName);

		txtSellPrice = new JTextField();
		txtSellPrice.setOpaque(false);
		txtSellPrice.setColumns(10);
		txtSellPrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Giá bán (đ)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtSellPrice.setBounds(157, 183, 211, 35);
		panel.add(txtSellPrice);

		txtBrandName = new JTextField();
		txtBrandName.setOpaque(false);
		txtBrandName.setColumns(10);
		txtBrandName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thương hiệu",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtBrandName.setBounds(12, 230, 128, 35);
		panel.add(txtBrandName);

		radioSale = new JRadioButton("Khuyến mãi");
		radioSale.setBounds(12, 280, 107, 24);
		panel.add(radioSale);
		radioSale.setFont(new Font("Dialog", Font.BOLD, 13));
		radioSale.setForeground(new Color(220, 20, 60));

		txtDiscountPercent = new JTextField();
		txtDiscountPercent.setForeground(new Color(220, 20, 60));
                txtDiscountPercent.setBounds(120, 273, 66, 35);
                txtDiscountPercent.setEditable(false);
		panel.add(txtDiscountPercent);
		txtDiscountPercent.setOpaque(false);
		txtDiscountPercent.setColumns(10);
		txtDiscountPercent.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "(%)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));

		radioActive = new JRadioButton("Mở bán");
		radioActive.setForeground(new Color(0, 128, 0));
		radioActive.setFont(new Font("Dialog", Font.BOLD, 13));
		radioActive.setBounds(92, 354, 107, 24);
		panel.add(radioActive);

		radioBlock = new JRadioButton("Ngưng bán");
		radioBlock.setForeground(new Color(0, 128, 0));
		radioBlock.setFont(new Font("Dialog", Font.BOLD, 13));
		radioBlock.setBounds(205, 354, 95, 24);
		panel.add(radioBlock);

		JLabel lblNewLabel_2 = new JLabel("Trạng thái");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setBounds(12, 350, 66, 33);
		panel.add(lblNewLabel_2);

		txtWarehousePrice = new JTextField();
		txtWarehousePrice.setOpaque(false);
		txtWarehousePrice.setColumns(10);
		txtWarehousePrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Giá nhập (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtWarehousePrice.setBounds(158, 141, 210, 35);
		panel.add(txtWarehousePrice);

		txtCategoryName = new JTextField();
		txtCategoryName.setOpaque(false);
		txtCategoryName.setColumns(10);
		txtCategoryName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh mục",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtCategoryName.setBounds(158, 100, 145, 35);
		panel.add(txtCategoryName);

		radioWarehouseProduct = new JRadioButton("Chưa đăng bán");
		radioWarehouseProduct.setForeground(new Color(0, 128, 0));
		radioWarehouseProduct.setFont(new Font("Dialog", Font.BOLD, 13));
		radioWarehouseProduct.setBounds(92, 383, 156, 24);
		panel.add(radioWarehouseProduct);

		txtSalePrice = new JTextField();
		txtSalePrice.setForeground(new Color(220, 20, 60));
		txtSalePrice.setOpaque(false);
		txtSalePrice.setColumns(10);
		txtSalePrice.setEditable(false);
		txtSalePrice.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Giá khuyến mãi (đ)",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		txtSalePrice.setBounds(195, 273, 173, 35);
		panel.add(txtSalePrice);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 139, 139));
		separator.setBounds(0, 350, 380, 1);
		panel.add(separator);

		btnFindCategoryChild = new JButton("...");
		btnFindCategoryChild.setForeground(Color.WHITE);
		btnFindCategoryChild.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFindCategoryChild.setBackground(new Color(0, 128, 128));
		btnFindCategoryChild.setBounds(315, 107, 52, 24);
		panel.add(btnFindCategoryChild);

		btnFindBrand = new JButton("...");
		btnFindBrand.setForeground(Color.WHITE);
		btnFindBrand.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFindBrand.setBackground(new Color(0, 128, 128));
		btnFindBrand.setBounds(143, 238, 52, 24);
		panel.add(btnFindBrand);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(0, 128, 0)));
		panel_2.setBounds(0, 416, 383, 42);
		pnDetails.add(panel_2);
		panel_2.setLayout(null);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setIcon(new ImageIcon(ProductForm.class.getResource("/images/edit-icon.png")));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 13));
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.setBounds(140, 8, 116, 25);
		panel_2.add(btnUpdate);

		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnHeader.setBounds(0, 0, 830, 32);
		add(pnHeader);

		JLabel lblNewLabel = new JLabel("SẢN PHẨM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		pnHeader.add(lblNewLabel);

		ButtonGroup bgRadio = new ButtonGroup();
		bgRadio.add(radioWarehouseProduct);
		bgRadio.add(radioActive);
		bgRadio.add(radioBlock);
		
		lblNewLabel_3 = new JLabel("Từ");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(34, 320, 16, 16);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("đến");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(150, 320, 21, 16);
		panel.add(lblNewLabel_4);
		
		lblStartDate = new JLabel("");
		lblStartDate.setBounds(62, 320, 78, 16);
		panel.add(lblStartDate);
		
		lblEndDate = new JLabel("");
		lblEndDate.setBounds(183, 320, 65, 16);
		panel.add(lblEndDate);
	}

	public void addEvents() {
		btnFilter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				HashMap<String, String> filter = new HashMap<String, String>();
				if (cboCategory.getSelectedItem() != null) {
					filter.put(" tbl_categorychild.name ",
							" = '" + String.valueOf(cboCategory.getSelectedItem()) + "' ");
				}

				if (cboBrand.getSelectedItem() != null) {
					filter.put(" tbl_brand.name ", " = '" + String.valueOf(cboBrand.getSelectedItem()) + "' ");
				}

				if (txtFilterName.getText().isBlank() == false) {
					filter.put(" tbl_product.name ", " LIKE '%" + String.valueOf(txtFilterName.getText()) + "%'");
				}

				Vector<String> list_id = productBLL.filters(filter);

				if (radioFilterSale.isSelected()) {
					Vector<String> temp = new Vector<String>();
					for (String id : list_id) {
						if (productSaleBLL.checkSale(id) == 1) {
							temp.add(id);
						}
					}
					list_id = temp;
				}

				Vector<ProductDTO> listFilter = new Vector<ProductDTO>();
				for (ProductDTO productDTO : listProduct) {
					for (String id_filer : list_id) {
						if (productDTO.getId_product().equals(id_filer)) {
							listFilter.add(productDTO);
						}
					}
				}
				loadProductTableByFilter(listFilter);
	
			}
		});

		tblProduct.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblProduct.getSelectedRow();
				if (row > -1) {
					String id_product = String.valueOf(tblProduct.getValueAt(row, 0));
					ProductDTO productDTO = productBLL.getProductById(id_product);
					loadProductDetail(productDTO);
				}
			}
		});
		btnReload.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listProduct = productBLL.getProducts();
				loadProductTable();
			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblProduct.getSelectedRow();
				if (row > -1) {
					String id_product = String.valueOf(tblProduct.getValueAt(row, 0));
					ProductDTO productDTO = productBLL.getProductById(id_product);
					UpdateProductDialog updateProductDialog = new UpdateProductDialog(productDTO);
					updateProductDialog.setVisible(true);
				} else {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa !");
                                }
			}
		});

		btnExportExcel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Vector<String> header = new Vector<String>();
				header.add("Mã sản phẩm");
				header.add("Tên sản phẩm");
				header.add("Danh mục");
				header.add("Giá bán");
				header.add("Thương hiệu");
				header.add("Số lượng");
				header.add("Tình trạng khuyến mãi");

				Vector<Vector<String>> listObjectData = new Vector<Vector<String>>();
				for (ProductDTO productDTO : productBLL.getProducts()) {
					Vector<String> data = new Vector<String>();
					data.add(productDTO.getId_product());
					data.add(productDTO.getName());
					data.add(productDTO.getCategorychild().getName());
					data.add(String.valueOf(productDTO.getPrice()));
					data.add(productDTO.getBrand().getId_brand());
					data.add(String.valueOf(productDTO.getQuantity()));
					data.add(String.valueOf(productDTO.getStatus()));
					listObjectData.add(data);
				}

				if (productBLL.writeExcel(listObjectData, header) == 1) {
					JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
					return;
				} else {
					JOptionPane.showMessageDialog(null, "Thất bại!");
					return;
				}
			}
		});

	}

	public void loadProductTableByFilter(Vector<ProductDTO> listFilter) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã SP", "Tên SP", "Số lượng", "Giá nhập", "Giá bán" };
		dfm.setColumnIdentifiers(header);
		for (ProductDTO product : listFilter) {
			WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = warehouseReceiptDetailBLL
					.getwarehouseReceiptDetailsByProductId(product.getId_product());
			String[] row = {
					product.getId_product(),
					product.getName(),
					String.valueOf(product.getQuantity()),
					String.valueOf(warehouseReceiptDetailDTO.getPrice()),
					(product.getStatus() == 0 ? "Chưa đăng bán" : String.valueOf(product.getPrice()))
			};
			dfm.addRow(row);
		}
		tblProduct.setModel(dfm);
		tblProduct.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblProduct.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblProduct.getColumnModel().getColumn(4).setPreferredWidth(80);
		tblProduct.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}


	public void loadProductTable() {
		listProduct = productBLL.getProducts();
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã SP", "Tên SP", "Số lượng", "Giá nhập", "Giá bán" };
		dfm.setColumnIdentifiers(header);
		for (ProductDTO product : listProduct) {
			WarehouseReceiptDetailDTO warehouseReceiptDetailDTO = warehouseReceiptDetailBLL
					.getwarehouseReceiptDetailsByProductId(product.getId_product());
			String[] row = {
					product.getId_product(),
					product.getName(),
					String.valueOf(product.getQuantity()),
					String.valueOf(warehouseReceiptDetailDTO.getPrice()),
					(product.getStatus() == 0 ? "Chưa đăng bán" : String.valueOf(product.getPrice()))
			};
			dfm.addRow(row);
		}
		tblProduct.setModel(dfm);
		tblProduct.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblProduct.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblProduct.getColumnModel().getColumn(4).setPreferredWidth(80);
		tblProduct.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}

	public void loadProductDetail(ProductDTO productDTO) {
		int checksale = productSaleBLL.checkSale(productDTO.getId_product());
		WarehouseReceiptDetailDTO productWarehouseReciept = warehouseReceiptDetailBLL
				.getwarehouseReceiptDetailsByProductId(productDTO.getId_product());
		CategoryChildDTO categorychildDTO = categorychildBLL
				.getCategoryChildById(productDTO.getCategorychild().getId_categorychild());
		BrandDTO brandDTO = brandBLL.getBrandById(productDTO.getBrand().getId_brand());
		txtProductId.setText(productDTO.getId_product());
		txtProductName.setText(productDTO.getName());
		txtCategoryName.setText(categorychildDTO.getName());
		txtBrandName.setText(brandDTO.getName());
		txtProductQuantity.setText(String.valueOf(productDTO.getQuantity()));
		txtWarehousePrice.setText(String.valueOf(productWarehouseReciept.getPrice()));
		image.setIcon(new ImageIcon(CopyImage.resizeImage(".\\src\\images\\product\\" + productDTO.getImage(), image)));
		if (productDTO.getStatus() == 0) {
			txtSellPrice.setText("Chưa đăng bán");
			radioWarehouseProduct.setSelected(true);
		} else if (productDTO.getStatus() == 1) {
			txtSellPrice.setText(String.valueOf(productDTO.getPrice()));
			radioActive.setSelected(true);
		} else {
			txtSellPrice.setText(String.valueOf(productDTO.getPrice()));
			radioBlock.setSelected(true);
		}

		if (checksale == 1) {
			ProductSaleDTO productSaleDTO = bookSaleBLL.getProductSaleByProductId(productDTO.getId_product());
			radioSale.setSelected(true);
                        double discountPercent = productSaleDTO.getDiscountPercent() * 100;
                        txtDiscountPercent.setText(String.format("%.1f", discountPercent));
			txtSalePrice.setText(String.valueOf(productDTO.getPrice() * (1 - productSaleDTO.getDiscountPercent())));
			lblStartDate.setText(sdf.format(productSaleDTO.getStartdate()));
			lblEndDate.setText(sdf.format(productSaleDTO.getEnddate()));

		} else {
			radioSale.setSelected(false);
			txtDiscountPercent.setText("");
			txtSalePrice.setText("");
			lblStartDate.setText("");
			lblEndDate.setText("");
		}

	}

	public void setEditableAllTextfield(boolean flag) {
		if (flag) {
			txtProductId.setEditable(true);
			txtProductName.setEditable(true);
			txtProductQuantity.setEditable(true);
			txtSalePrice.setEditable(true);
			txtWarehousePrice.setEditable(true);
			txtSellPrice.setEditable(true);
			radioSale.setEnabled(true);
		} else {
			txtProductId.setEditable(false);
			txtProductName.setEditable(false);
			txtProductQuantity.setEditable(false);
			txtBrandName.setEditable(false);
			txtCategoryName.setEditable(false);
			txtSalePrice.setEditable(false);
			txtWarehousePrice.setEditable(false);
			txtSellPrice.setEditable(false);

		}
	}
}
