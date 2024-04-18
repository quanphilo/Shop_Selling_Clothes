package GUI.SellProductGUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.table.*;

import BLL.BrandBLL;
import BLL.CategoryChildBLL;
import BLL.CustomerBLL;
import BLL.OrderBLL;
import BLL.OrderItemBLL;
import BLL.ProductBLL;
import BLL.ProductSaleBLL;
import BLL.VoucherBLL;
import Cores.CopyImage;
import DTO.BrandDTO;
import DTO.CategoryChildDTO;
import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import DTO.OrderDTO;
import DTO.OrderItemDTO;
import DTO.ProductDTO;
import DTO.VoucherDTO;

public class SellProductForm extends JPanel {
	private OrderItemBLL orderItemBLL = new OrderItemBLL();
	private VoucherBLL voucherBLL = new VoucherBLL();
	private OrderBLL orderBLL = new OrderBLL();
	private ProductBLL productBLL = new ProductBLL();
	private CustomerBLL customerBLL = new CustomerBLL();
	private ProductSaleBLL productSaleBLL = new ProductSaleBLL();
	private CategoryChildBLL categorychildBLL = new CategoryChildBLL();
	private BrandBLL brandBLL = new BrandBLL();
	private Vector<CategoryChildDTO> listCategoryChild = categorychildBLL.getCategoryChilds();
	private Vector<BrandDTO> listBrand = brandBLL.getBrands();
	private Vector<VoucherDTO> listVoucher = voucherBLL.getVouchers();

	private static CustomerDTO customerDTO;
	private static VoucherDTO voucherDTO;
	private EmployeeDTO employeeDTO;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static Date date = new Date();
	private static Vector<OrderItemDTO> listOrderItem = new Vector<OrderItemDTO>();
	private static String id_order;
	private JTextField txtOrderId;
	private static JTextField txtOrderPrice;
	private JTextField txtEmployeeId;
	private JTextField txtDate;
	private static JTable tblOrderItem;
	private JTextField txtProductId;
	private JTextField txtProductQuantity;
	private JTextField txtProductName;
	private JTextField txtProductPrice;
	private JTextField txtBrandName;

	private JButton btnFindCustomer;
	private static JTextField txtCustomer;
	private JButton btnGetAllProduct;
	private JTextField txtFilterName;
	private JTextField txtCategoryName;
	private JButton btnFilter;
	private JComboBox<CategoryChildDTO> cboCategory;
	private JRadioButton radioSale;
	private JComboBox<BrandDTO> cboBrand;
	private JButton btnCheckout;
	private JComboBox<VoucherDTO> cboVoucher;
	private static JTextField txtTotalPrice;
	private JLabel lblTngTin_2;
	private static JTextField txtVoucherPrice;
	private JButton btnCheckVoucher;
	private JLabel image;

	public SellProductForm(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
		initComponents();
		addEvents();
	}

	public void initComponents() {
		date = new Date();
		id_order = "OR" + date.getTime();
		setLayout(null);
		setBounds(0, 0, 830, 490);

		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnHeader.setBounds(0, 0, 830, 32);
		add(pnHeader);

		JLabel lblNewLabel = new JLabel("BÁN HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		pnHeader.add(lblNewLabel);

		JPanel pnOrder = new JPanel();
		pnOrder.setLayout(null);
		pnOrder.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "H\u00F3a \u0111\u01A1n",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		pnOrder.setBounds(390, 40, 440, 450);
		add(pnOrder);

		JPanel pnOrderInfos = new JPanel();
		pnOrderInfos.setLayout(null);
		pnOrderInfos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 139, 139)));
		pnOrderInfos.setBounds(8, 20, 428, 117);
		pnOrder.add(pnOrderInfos);

		txtOrderId = new JTextField(id_order);
		txtOrderId.setEditable(false);
		txtOrderId.setColumns(10);
		txtOrderId.setBounds(99, 8, 125, 20);
		pnOrderInfos.add(txtOrderId);

		JLabel OrderID = new JLabel("Mã hóa đơn");
		OrderID.setForeground(new Color(0, 100, 0));
		OrderID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		OrderID.setBounds(12, 10, 88, 17);
		pnOrderInfos.add(OrderID);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setForeground(new Color(0, 100, 0));
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNhnVin.setBounds(12, 86, 81, 17);
		pnOrderInfos.add(lblMNhnVin);

		txtEmployeeId = new JTextField(employeeDTO.getId());
		txtEmployeeId.setEditable(false);
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(99, 84, 125, 20);
		pnOrderInfos.add(txtEmployeeId);

		JLabel lblNgyNhp = new JLabel("Ngày lập");
		lblNgyNhp.setForeground(new Color(0, 100, 0));
		lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgyNhp.setBounds(232, 10, 57, 17);
		pnOrderInfos.add(lblNgyNhp);

		txtDate = new JTextField(sdf.format(date));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(291, 8, 125, 20);
		pnOrderInfos.add(txtDate);

		btnFindCustomer = new JButton("Tìm khách hàng");
		btnFindCustomer.setIcon(null);
		btnFindCustomer.setForeground(new Color(255, 255, 224));
		btnFindCustomer.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFindCustomer.setBackground(new Color(0, 128, 128));
		btnFindCustomer.setBounds(243, 48, 140, 20);
		pnOrderInfos.add(btnFindCustomer);

		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setForeground(new Color(0, 100, 0));
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKhchHng.setBounds(12, 50, 88, 17);
		pnOrderInfos.add(lblKhchHng);

		txtCustomer = new JTextField();
		txtCustomer.setEditable(false);
		txtCustomer.setColumns(10);
		txtCustomer.setBounds(99, 48, 125, 20);
		pnOrderInfos.add(txtCustomer);

		cboVoucher = new JComboBox<VoucherDTO>(listVoucher);
		cboVoucher.setBorder(new TitledBorder(null, " Voucher", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		cboVoucher.setBounds(235, 70, 130, 43);
		pnOrderInfos.add(cboVoucher);
		
		btnCheckVoucher = new JButton("");
		btnCheckVoucher.setIcon(new ImageIcon(SellProductForm.class.getResource("/images/check (1).png")));
		btnCheckVoucher.setForeground(Color.WHITE);
		btnCheckVoucher.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCheckVoucher.setBackground(new Color(0, 128, 128));
		btnCheckVoucher.setBounds(367, 88, 30, 20);
		pnOrderInfos.add(btnCheckVoucher);

		JPanel pnOrderTable = new JPanel();
		pnOrderTable.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
		pnOrderTable.setBounds(6, 145, 430, 156);
		pnOrder.add(pnOrderTable);
		pnOrderTable.setLayout(new BorderLayout(0, 0));

		tblOrderItem = new JTable();
                tblOrderItem.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tblOrderItem, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnOrderTable.add(scrollPane, BorderLayout.CENTER);

		JPanel pnOrderAction = new JPanel();
		pnOrderAction.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 0)));
		pnOrderAction.setLayout(null);
		pnOrderAction.setBounds(0, 393, 440, 53);
		pnOrder.add(pnOrderAction);

		btnCheckout = new JButton("Thanh toán");
		btnCheckout.setIcon(new ImageIcon(SellProductForm.class.getResource("/images/check-1-icon.png")));
		btnCheckout.setForeground(new Color(255, 255, 224));
		btnCheckout.setBackground(new Color(0, 128, 128));
		btnCheckout.setBounds(152, 9, 142, 35);
		pnOrderAction.add(btnCheckout);

		JButton btnFilterWarehouse = new JButton("");
		btnFilterWarehouse.setOpaque(false);
		btnFilterWarehouse.setForeground(Color.WHITE);
		btnFilterWarehouse.setBorderPainted(false);
		btnFilterWarehouse.setBorder(null);
		btnFilterWarehouse.setBackground(Color.WHITE);
		btnFilterWarehouse.setBounds(199, 142, 28, 26);
		pnOrder.add(btnFilterWarehouse);

		JLabel lblTngTin = new JLabel("Thanh toán (đ)");
		lblTngTin.setBounds(8, 361, 97, 17);
		pnOrder.add(lblTngTin);
		lblTngTin.setForeground(new Color(0, 100, 0));
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtOrderPrice = new JTextField();
		txtOrderPrice.setBounds(108, 361, 103, 20);
		pnOrder.add(txtOrderPrice);
		txtOrderPrice.setEditable(false);
		txtOrderPrice.setColumns(10);

		JLabel lblTngTin_1 = new JLabel("Tổng tiền (đ)");
		lblTngTin_1.setForeground(new Color(0, 100, 0));
		lblTngTin_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngTin_1.setBounds(8, 308, 79, 17);
		pnOrder.add(lblTngTin_1);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setBounds(108, 306, 103, 20);
		pnOrder.add(txtTotalPrice);

		lblTngTin_2 = new JLabel("Khuyến mãi (đ)");
		lblTngTin_2.setForeground(Color.RED);
		lblTngTin_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTngTin_2.setBounds(8, 335, 87, 17);
		pnOrder.add(lblTngTin_2);

		txtVoucherPrice = new JTextField();
		txtVoucherPrice.setEditable(false);
		txtVoucherPrice.setColumns(10);
		txtVoucherPrice.setBounds(108, 333, 103, 20);
		pnOrder.add(txtVoucherPrice);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Th\u00F4ng tin s\u1EA3n ph\u1EA9m",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setBounds(1, 231, 380, 259);
		add(panel);

		image = new JLabel("");
		image.setIcon(null);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(12, 23, 128, 154);
		panel.add(image);

		txtProductId = new JTextField();
		txtProductId.setOpaque(false);
		txtProductId.setColumns(10);
		txtProductId.setBorder(new TitledBorder(null, "M\u00E3 s\u1EA3n ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductId.setBounds(145, 23, 223, 35);
                txtProductId.setEditable(false);
		panel.add(txtProductId);

		txtProductQuantity = new JTextField();
		txtProductQuantity.setOpaque(false);
		txtProductQuantity.setColumns(10);
		txtProductQuantity
				.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "S\u1ED1 l\u01B0\u1EE3ng",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductQuantity.setBounds(293, 208, 75, 35);
                txtProductQuantity.setEditable(false);
		panel.add(txtProductQuantity);

		txtProductName = new JTextField();
		txtProductName.setOpaque(false);
		txtProductName.setColumns(10);
		txtProductName
				.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "T\u00EAn s\u1EA3n ph\u1EA9m",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductName.setBounds(145, 71, 223, 35);
                txtProductName.setEditable(false);
		panel.add(txtProductName);

		txtProductPrice = new JTextField();
		txtProductPrice.setOpaque(false);
		txtProductPrice.setColumns(10);
		txtProductPrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Gi\u00E1 (\u0111)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductPrice.setBounds(145, 208, 144, 35);
                txtProductPrice.setEditable(false);
		panel.add(txtProductPrice);

		txtBrandName = new JTextField();
		txtBrandName.setOpaque(false);
		txtBrandName.setColumns(10);
		txtBrandName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Th\u01B0\u01A1ng hi\u1EC7u",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtBrandName.setBounds(145, 118, 223, 35);
                txtBrandName.setEditable(false);
		panel.add(txtBrandName);

		txtCategoryName = new JTextField();
		txtCategoryName.setOpaque(false);
		txtCategoryName.setColumns(10);
		txtCategoryName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh m\u1EE5c",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtCategoryName.setBounds(145, 165, 223, 35);
                txtCategoryName.setEditable(false);
		panel.add(txtCategoryName);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(
				new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel_3.setBounds(10, 40, 371, 136);
		add(panel_3);

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
		btnFilter.setIcon(new ImageIcon(SellProductForm.class.getResource("/images/search-icon.png")));
		btnFilter.setForeground(Color.WHITE);
		btnFilter.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFilter.setBackground(new Color(0, 128, 128));
		btnFilter.setBounds(235, 97, 46, 25);
		panel_3.add(btnFilter);

		radioSale = new JRadioButton("Khuyến mãi");
		radioSale.setForeground(new Color(0, 128, 0));
		radioSale.setFont(new Font("Dialog", Font.BOLD, 13));
		radioSale.setBounds(233, 60, 107, 24);
		panel_3.add(radioSale);

		txtFilterName = new JTextField();
		txtFilterName.setColumns(10);
		txtFilterName.setBounds(95, 97, 130, 25);
		panel_3.add(txtFilterName);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_2_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_2_1.setBounds(12, 102, 80, 16);
		panel_3.add(lblNewLabel_1_2_1);

		btnGetAllProduct = new JButton("Tất cả sản phẩm");
		btnGetAllProduct.setIcon(new ImageIcon(SellProductForm.class.getResource("/images/clothes-hanger 24.png")));
		btnGetAllProduct.setBounds(15, 185, 201, 34);
		add(btnGetAllProduct);
		btnGetAllProduct.setForeground(Color.WHITE);
		btnGetAllProduct.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGetAllProduct.setBackground(new Color(0, 128, 128));

		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(new Color(0, 128, 0));
		separator.setBackground(new Color(0, 128, 0));
		separator.setBounds(385, 32, 2, 455);
		add(separator);

		for (VoucherDTO voucher : listVoucher) {
			if (voucher.getCode().equals(String.valueOf(cboVoucher.getSelectedItem()))) {
				voucherDTO = voucher;
			}
		}

	}

	public void addEvents() {

		btnCheckVoucher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (VoucherDTO voucher : listVoucher) {
					if (voucher.getCode().equals(String.valueOf(cboVoucher.getSelectedItem()))) {
						voucherDTO = voucher;
					}
				}
				loadFormPrice();
			}
		});

		btnFindCustomer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CustomerDialog customerDialog = new CustomerDialog();
				customerDialog.setVisible(true);
			}
		});

		btnGetAllProduct.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProductDialog productDialog = new ProductDialog();
				productDialog.setVisible(true);
			}
		});

		tblOrderItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblOrderItem.getSelectedRow();
				int col = tblOrderItem.getSelectedColumn();
				String id_product = String.valueOf(tblOrderItem.getValueAt(row, 0));
				if (row > -1 && col == 4) {
					deleteItemOrder(row);
					return;
				}
				for (OrderItemDTO orderItem : listOrderItem) {
					if (orderItem.getProduct().getId_product().equals(id_product)) {
						loadProductDetail(orderItem);
						return;
					}
				}

			}
		});

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

				if (radioSale.isSelected()) {
					Vector<String> temp = new Vector<String>();
					for (String id : list_id) {
						if (productSaleBLL.checkSale(id) == 1) {
							temp.add(id);
						}
					}
					list_id = temp;
				}
				ProductDialog productDialog = new ProductDialog(list_id);
				productDialog.setVisible(true);
			}
		});

		btnCheckout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// get voucher
				for (VoucherDTO voucher : listVoucher) {
					if (voucher.getCode().equals(String.valueOf(cboVoucher.getSelectedItem()))) {
						voucherDTO = voucher;
					}
				}
				// Insert Order
				if (txtOrderPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn mua sản phẩm");
					return;
				}
				float orderPrice = Float.valueOf(txtOrderPrice.getText());

				OrderDTO orderDTO = new OrderDTO(
						txtOrderId.getText(),
						customerDTO,
						orderPrice,
						voucherDTO,
						employeeDTO,
						date);
				int kq1 = orderBLL.insert(orderDTO);
				if (kq1 == 2) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
					return;
				} else if (kq1 == 0) {
					JOptionPane.showMessageDialog(null, "Lỗi !");
					return;
				}

				// Insert OrderItem
				for (OrderItemDTO orderItemDTO : listOrderItem) {
					if (orderItemBLL.insert(orderItemDTO) == 0) {
						JOptionPane.showMessageDialog(null, "Lỗi!");
						return;
					} else {
						ProductDTO product = productBLL.getProductById(orderItemDTO.getProduct().getId_product());
						int updateQuantity = product.getQuantity() - orderItemDTO.getQuantity();
						product.setQuantity(updateQuantity);
						int updateProduct = productBLL.update(product);
					}
				}

				JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
				int point =  Math.round(Float.valueOf(txtTotalPrice.getText())/1000);
				customerDTO.setPoint(customerDTO.getPoint() + point);
				int updatepoint = customerBLL.updatePoint(customerDTO);
				ExportOrder exportOrder = new ExportOrder(orderDTO, customerDTO, listOrderItem);
				exportOrder.setVisible(true);
				listOrderItem.removeAllElements();
                                
                                
                                tblOrderItem.removeAll();
                                DefaultTableModel model = (DefaultTableModel) tblOrderItem.getModel();
                                model.setRowCount(0);
                                date = new Date();
                                id_order = "OR" + date.getTime();
                                txtOrderId.setText(id_order);
                                customerDTO = null;
                                txtCustomer.setText("");
			}
		});
	}

	public void loadProductDetail(OrderItemDTO orderItemDTO) {
		ProductDTO productDTO = productBLL.getProductById(orderItemDTO.getProduct().getId_product());
		CategoryChildDTO categorychildDTO = categorychildBLL
				.getCategoryChildById(productDTO.getCategorychild().getId_categorychild());
		BrandDTO brandDTO = brandBLL.getBrandById(productDTO.getBrand().getId_brand());
		txtProductId.setText(orderItemDTO.getProduct().getId_product());
		txtProductName.setText(orderItemDTO.getProduct().getName());
		txtCategoryName.setText(categorychildDTO.getName());
		txtBrandName.setText(brandDTO.getName());
		txtProductPrice.setText(String.valueOf(orderItemDTO.getPrice()));
		txtProductQuantity.setText(String.valueOf(orderItemDTO.getProduct().getQuantity()));
		image.setIcon(new ImageIcon(CopyImage.resizeImage(".\\src\\images\\product\\" + productDTO.getImage(), image)));
	}

	public static void loadItemOrderTable() {
		float totalprice = 0;
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Tên SP", "Số lượng", "Giá bán(đ)", "Tổng (đ)", "Xóa" };
		dfm.setColumnIdentifiers(header);
                for (OrderItemDTO orderItem : listOrderItem) {
                    String[] row = {
                        orderItem.getProduct().getId_product(),
                        String.valueOf(orderItem.getQuantity()),
                        String.valueOf(orderItem.getPrice()),
                        String.valueOf(orderItem.getQuantity() * orderItem.getPrice()),
                        "x"
                    };
                    totalprice += orderItem.getPrice() * orderItem.getQuantity();
                    dfm.addRow(row);
                }

		tblOrderItem.setModel(dfm);
		DefaultTableCellRenderer cellRendererColor = new DefaultTableCellRenderer();
		cellRendererColor.setBackground(Color.RED);
		cellRendererColor.setHorizontalAlignment(JLabel.CENTER);
		tblOrderItem.getColumnModel().getColumn(4).setCellRenderer(cellRendererColor);
		loadFormPrice();
	}

	public static void loadFormPrice() {
		float totalprice = 0;
		for (OrderItemDTO orderItem : listOrderItem) {
			totalprice = totalprice + orderItem.getPrice() * orderItem.getQuantity();
		}
		txtTotalPrice.setText(String.valueOf(totalprice));
		txtVoucherPrice.setText(" - " + String.valueOf(totalprice * voucherDTO.getDiscountpercent()));
		txtOrderPrice.setText(String.valueOf(totalprice * (1 - voucherDTO.getDiscountpercent())));
	}

	public void deleteItemOrder(int row) {
		listOrderItem.remove(row);
		loadItemOrderTable();
	}

	public static CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public static void setCustomerDTO(CustomerDTO customerDTO) {
		SellProductForm.customerDTO = customerDTO;
	}

	public static void refreshComponents() {
		txtCustomer.setText(customerDTO.getFullname());
	}

	public static Vector<OrderItemDTO> getListOrderItem() {
		return listOrderItem;
	}

	public static void setListOrderItem(Vector<OrderItemDTO> listOrderItem) {
		SellProductForm.listOrderItem = listOrderItem;
	}

	public static String getId_order() {
		return id_order;
	}

	public static void setId_order(String id_order) {
		SellProductForm.id_order = id_order;
	}
}
