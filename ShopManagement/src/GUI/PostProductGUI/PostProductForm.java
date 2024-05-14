package GUI.PostProductGUI;

import javax.swing.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import BLL.WarehouseReceiptBLL;
import BLL.WarehouseReceiptDetailBLL;
import DTO.WarehouseReceiptDTO;
import DTO.WarehouseReceiptDetailDTO;

public class PostProductForm extends JPanel{
	private WarehouseReceiptBLL warehousereceiptBLL = new WarehouseReceiptBLL();
	private WarehouseReceiptDetailBLL warehousereceiptdetailBLL = new WarehouseReceiptDetailBLL();
	
	private Vector<WarehouseReceiptDTO> warehousereceiptList = warehousereceiptBLL.getWarehouseReceipts();
	private Vector<WarehouseReceiptDetailDTO> warehousereceipdetailtList;


	private JTextField txtProductId;
	private JTextField txt;
	private JTextField txtProductName;
	private JTextField txtWarehousePrice;
	private JTextField txtProductBrand;
	private JTable tblProduct;
	private JTextField txtSalePrice;
	private JTextField txtWarehouseId;
	private JTextField txtDate;
	private JTextField txtEmployeeId;
	private JTextField txtSupplier;
	private JTextField txtDiscountPercent;
	private JButton btnFindWarehouse;
	
	public PostProductForm() {
		initComponents();
		addEvents();
	}


	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 490);
		
		JPanel pnWarehouse = new JPanel();
		pnWarehouse.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Phiếu nhập", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		pnWarehouse.setBounds(387, 40, 443, 450);
		add(pnWarehouse);
		pnWarehouse.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chọn phiếu nhập");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(18, 27, 108, 22);
		pnWarehouse.add(lblNewLabel_1);
		
		btnFindWarehouse = new JButton("....");
		btnFindWarehouse.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFindWarehouse.setBackground(new Color(0, 128, 128));
		btnFindWarehouse.setForeground(new Color(255, 255, 255));
		btnFindWarehouse.setBounds(132, 28, 56, 20);
		pnWarehouse.add(btnFindWarehouse);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(279, 70, 28, 26);
		pnWarehouse.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Chi tiết phiếu nhập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_1.setBounds(12, 207, 419, 229);
		pnWarehouse.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		tblProduct = new JTable();
                tblProduct.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane_1_1 = new JScrollPane( tblProduct, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(scrollPane_1_1);
		
		txtWarehouseId = new JTextField();
		txtWarehouseId.setOpaque(false);
		txtWarehouseId.setColumns(10);
		txtWarehouseId.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mã phiếu nhập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtWarehouseId.setBounds(12, 61, 211, 35);
		pnWarehouse.add(txtWarehouseId);
		
		txtDate = new JTextField();
		txtDate.setOpaque(false);
		txtDate.setColumns(10);
		txtDate.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ngày nhập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtDate.setBounds(232, 61, 199, 35);
		pnWarehouse.add(txtDate);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setOpaque(false);
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mã nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtEmployeeId.setBounds(12, 108, 211, 35);
		pnWarehouse.add(txtEmployeeId);
		
		txtSupplier = new JTextField();
		txtSupplier.setOpaque(false);
		txtSupplier.setColumns(10);
		txtSupplier.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtSupplier.setBounds(232, 108, 199, 35);
		pnWarehouse.add(txtSupplier);
				
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
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thông tin sản phẩm tồn kho", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setBounds(2, 8, 380, 240);
		pnDetails.add(panel);
		panel.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setIcon(new ImageIcon(PostProductForm.class.getResource("/images/Nike-Shirt-17-icon.png")));
		image.setBounds(12, 36, 128, 145);
		panel.add(image);
		
		txtProductId = new JTextField();
		txtProductId.setOpaque(false);
		txtProductId.setBorder(new TitledBorder(null, "Mã sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductId.setBounds(157, 20, 211, 35);
		panel.add(txtProductId);
		txtProductId.setColumns(10);
		
		txt = new JTextField();
		txt.setOpaque(false);
		txt.setColumns(10);
		txt.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Số lượng nhập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt.setBounds(157, 193, 210, 35);
		panel.add(txt);
		
		txtProductName = new JTextField();
		txtProductName.setOpaque(false);
		txtProductName.setColumns(10);
		txtProductName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tên sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductName.setBounds(158, 67, 210, 35);
		panel.add(txtProductName);
		
		txtWarehousePrice = new JTextField();
		txtWarehousePrice.setOpaque(false);
		txtWarehousePrice.setColumns(10);
		txtWarehousePrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Giá nhập (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtWarehousePrice.setBounds(158, 147, 210, 35);
		panel.add(txtWarehousePrice);
		
		txtProductBrand = new JTextField();
		txtProductBrand.setOpaque(false);
		txtProductBrand.setColumns(10);
		txtProductBrand.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thương hiệu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductBrand.setBounds(158, 107, 210, 35);
		panel.add(txtProductBrand);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thông tin đăng bán sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel_2.setBounds(2, 300, 380, 160);
		pnDetails.add(panel_2);
		
		txtSalePrice = new JTextField();
		txtSalePrice.setOpaque(false);
		txtSalePrice.setColumns(10);
		txtSalePrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Giá đăng bán (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtSalePrice.setBounds(16, 36, 272, 40);
		panel_2.add(txtSalePrice);
		
		JRadioButton radioSale = new JRadioButton("Khuyến mãi");
		radioSale.setFont(new Font("Dialog", Font.BOLD, 13));
		radioSale.setForeground(new Color(0, 128, 0));
		radioSale.setBounds(16, 105, 101, 24);
		panel_2.add(radioSale);
		
		txtDiscountPercent = new JTextField();
		txtDiscountPercent.setOpaque(false);
		txtDiscountPercent.setColumns(10);
		txtDiscountPercent.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Phần trăm khuyến mãi (%)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtDiscountPercent.setBounds(125, 96, 163, 40);
		panel_2.add(txtDiscountPercent);
		
		JButton btnAccept = new JButton("");
		btnAccept.setBounds(295, 43, 73, 93);
		panel_2.add(btnAccept);
		btnAccept.setIcon(new ImageIcon(PostProductForm.class.getResource("/images/check-1-icon.png")));
		btnAccept.setForeground(new Color(255, 255, 224));
		btnAccept.setBackground(new Color(0, 128, 128));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PostProductForm.class.getResource("/images/Downloads-icon.png")));
		lblNewLabel_2.setBounds(163, 250, 48, 46);
		pnDetails.add(lblNewLabel_2);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnHeader.setBounds(0, 0, 830, 32);
		add(pnHeader);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG BÁN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		pnHeader.add(lblNewLabel);
	}

	public void addEvents() {
		btnFindWarehouse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JComboBox<WarehouseReceiptDTO> cboWarehouse = new JComboBox<WarehouseReceiptDTO>(warehousereceiptList);
				int rs = JOptionPane.showConfirmDialog(null, cboWarehouse);
				if (rs == 0) {
					for (WarehouseReceiptDTO warehouse : warehousereceiptList) {
                                            
					}
				}
			} 
		});
	}

	public void loadDetailTable(Vector<WarehouseReceiptDetailDTO> listWarehouseReceiptDetail) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = {"Mã sản phẩm", "Số lượng", "Giá nhập(đ)" };
		dfm.setColumnIdentifiers(header);
		for (WarehouseReceiptDetailDTO warehouseReceiptDetailDTO : listWarehouseReceiptDetail) {
			String[] row = {
				warehouseReceiptDetailDTO.getProduct().getId_product(),
				String.valueOf(warehouseReceiptDetailDTO.getAmount()),
				String.valueOf(warehouseReceiptDetailDTO.getPrice())
			};
			dfm.addRow(row);
		}
		tblProduct.setModel(dfm);
	}
}
