package GUI.ProductGUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;

import java.awt.FileDialog;
import BLL.BrandBLL;
import BLL.CategoryBLL;
import BLL.CategoryChildBLL;
import BLL.ProductBLL;
import BLL.ProductSaleBLL;
import BLL.WarehouseReceiptDetailBLL;
import Cores.CopyImage;
import DTO.BrandDTO;
import DTO.CategoryChildDTO;
import DTO.ProductDTO;
import DTO.ProductSaleDTO;
import DTO.WarehouseReceiptDetailDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class UpdateProductDialog extends JDialog {
	private String currentImage;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JDatePickerImpl datePickerStart, datePickerEnd;

	private ProductBLL productBLL = new ProductBLL();
	private CategoryBLL categoryBLL = new CategoryBLL();
	private BrandBLL brandBLL = new BrandBLL();
	private ProductSaleBLL productSaleBLL = new ProductSaleBLL();
	private CategoryChildBLL categorychildBLL = new CategoryChildBLL();
	private WarehouseReceiptDetailBLL warehouseReceiptDetailBLL = new WarehouseReceiptDetailBLL();
	private ProductSaleBLL bookSaleBLL = new ProductSaleBLL();

	private Vector<ProductDTO> listProduct = productBLL.getProducts();
	private Vector<BrandDTO> listBrand = brandBLL.getBrands();
	private Vector<CategoryChildDTO> listCategorychild = categorychildBLL.getCategoryChilds();
	private CategoryChildDTO categoryChildDTO = new CategoryChildDTO();
	private BrandDTO brandDTO = new BrandDTO();

	private JTextField txtProductId;
	private JTextField txtProductQuantity;
	private JTextField txtProductName;
	private JTextField txtSellPrice;
	private JTextField txtBrandName;
	private JTextField txtDiscountPercent;
	private JTextField txtWarehousePrice;
	private JTextField txtCategoryName;
	private JTextField txtSalePrice;
	private JButton btnAccept;
	private ProductDTO productDTO;
	private JRadioButton radioWarehouseProduct;
	private JRadioButton radioActive;
	private JRadioButton radioBlock;
	private JButton btnFindBrand;
	private JButton btnFindCategoryChild;
	private JRadioButton radioSale;
	private JPanel pnFillterDate;
	private JPanel pnStart;
	private JPanel pnEnd;
	private JLabel nameImage;
	private JButton btnUpload;
	private JLabel image;

	public UpdateProductDialog(ProductDTO productDTO) {
		this.productDTO = productDTO;
		this.currentImage = productDTO.getImage();
		setSize(500, 550);
		setLocationRelativeTo(null);
		initComponents();
		loadProductDetail(productDTO);
		addEvents();
	}

	public void initComponents() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thông tin sản phẩm",

				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(39, 25, 128, 128);
		panel.add(image);

		txtProductId = new JTextField();
		txtProductId.setOpaque(false);
		txtProductId.setEditable(false);
		txtProductId.setColumns(10);
		txtProductId.setBorder(new TitledBorder(null, "Mã sản phẩm", TitledBorder.LEADING,

				TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductId.setBounds(217, 20, 234, 35);
		panel.add(txtProductId);

		txtProductQuantity = new JTextField();
		txtProductQuantity.setOpaque(false);
		txtProductQuantity.setColumns(10);
		txtProductQuantity.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
                        
				"Số lượng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductQuantity.setBounds(267, 230, 184, 35);
		panel.add(txtProductQuantity);

		txtProductName = new JTextField();
		txtProductName.setOpaque(false);
		txtProductName.setColumns(10);
		txtProductName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),

				"Tên sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtProductName.setBounds(218, 60, 233, 35);
		panel.add(txtProductName);

		txtSellPrice = new JTextField();
		txtSellPrice.setOpaque(false);
		txtSellPrice.setColumns(10);
		txtSellPrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Giá bán (đ)",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtSellPrice.setBounds(217, 183, 234, 35);
		panel.add(txtSellPrice);

		txtBrandName = new JTextField();
		txtBrandName.setOpaque(false);
		txtBrandName.setColumns(10);
		txtBrandName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Thương hiệu",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtBrandName.setBounds(51, 230, 128, 35);
		panel.add(txtBrandName);

		radioSale = new JRadioButton("Khuyến mãi");
		radioSale.setForeground(new Color(220, 20, 60));
		radioSale.setFont(new Font("Dialog", Font.BOLD, 13));
		radioSale.setBounds(25, 300, 107, 24);
		panel.add(radioSale);

		txtDiscountPercent = new JTextField();
		txtDiscountPercent.setOpaque(false);
		txtDiscountPercent.setForeground(new Color(220, 20, 60));
		txtDiscountPercent.setColumns(10);
		txtDiscountPercent.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "(%)",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		txtDiscountPercent.setBounds(140, 290, 66, 35);
                txtDiscountPercent.setEditable(false);
		panel.add(txtDiscountPercent);

		radioActive = new JRadioButton("Mở bán");
		radioActive.setForeground(new Color(0, 128, 0));
		radioActive.setFont(new Font("Dialog", Font.BOLD, 13));
		radioActive.setBounds(103, 403, 107, 24);
		panel.add(radioActive);

		radioBlock = new JRadioButton("Ngưng bán");
		radioBlock.setForeground(new Color(0, 128, 0));
		radioBlock.setFont(new Font("Dialog", Font.BOLD, 13));
		radioBlock.setBounds(216, 403, 95, 24);
		panel.add(radioBlock);

		JLabel lblNewLabel_2 = new JLabel("Trạng thái");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setBounds(23, 399, 66, 33);
		panel.add(lblNewLabel_2);

		txtWarehousePrice = new JTextField();
		txtWarehousePrice.setOpaque(false);
		txtWarehousePrice.setColumns(10);
		txtWarehousePrice.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),

				"Giá nhập (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtWarehousePrice.setBounds(218, 141, 233, 35);
		panel.add(txtWarehousePrice);

		txtCategoryName = new JTextField();
		txtCategoryName.setOpaque(false);
		txtCategoryName.setColumns(10);
		txtCategoryName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh mục",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txtCategoryName.setBounds(218, 100, 169, 35);
		panel.add(txtCategoryName);

		radioWarehouseProduct = new JRadioButton("Chưa đăng bán");
		radioWarehouseProduct.setForeground(new Color(0, 128, 0));
		radioWarehouseProduct.setFont(new Font("Dialog", Font.BOLD, 13));
		radioWarehouseProduct.setBounds(103, 432, 156, 24);
		panel.add(radioWarehouseProduct);

		txtSalePrice = new JTextField();
		txtSalePrice.setOpaque(false);
		txtSalePrice.setForeground(new Color(220, 20, 60));
		txtSalePrice.setColumns(10);
		txtSalePrice.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Giá khuyến mãi (đ)",

						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		txtSalePrice.setBounds(244, 301, 207, 35);
		txtSalePrice.setVisible(false);
		panel.add(txtSalePrice);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 139, 139));
		separator.setBounds(0, 400, 480, 1);
		panel.add(separator);

		btnFindCategoryChild = new JButton("...");
		btnFindCategoryChild.setForeground(Color.WHITE);
		btnFindCategoryChild.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFindCategoryChild.setBackground(new Color(0, 128, 128));
		btnFindCategoryChild.setBounds(399, 107, 52, 24);
		panel.add(btnFindCategoryChild);

		btnFindBrand = new JButton("...");
		btnFindBrand.setForeground(Color.WHITE);
		btnFindBrand.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFindBrand.setBackground(new Color(0, 128, 128));
		btnFindBrand.setBounds(203, 238, 52, 24);
		panel.add(btnFindBrand);

		btnAccept = new JButton("Áp dụng");
		btnAccept.setIcon(new ImageIcon(UpdateProductDialog.class.getResource("/images/checkmark.png")));
		btnAccept.setForeground(new Color(255, 255, 224));
		btnAccept.setBackground(new Color(0, 128, 128));
		btnAccept.setBounds(319, 450, 132, 33);
		panel.add(btnAccept);

		ButtonGroup bgRadio = new ButtonGroup();
		bgRadio.add(radioWarehouseProduct);
		bgRadio.add(radioActive);
		bgRadio.add(radioBlock);

		pnFillterDate = new JPanel();
		pnFillterDate.setBounds(23, 340, 430, 43);
		panel.add(pnFillterDate);
		pnFillterDate.setLayout(new BoxLayout(pnFillterDate, BoxLayout.X_AXIS));

		pnStart = new JPanel();
		pnFillterDate.add(pnStart);

		pnEnd = new JPanel();
		pnFillterDate.add(pnEnd);

		nameImage = new JLabel("");
		nameImage.setBounds(39, 160, 128, 16);
		panel.add(nameImage);

		btnUpload = new JButton("Tải hình");
		btnUpload.setIcon(new ImageIcon(UpdateProductDialog.class.getResource("/images/upload.png")));
		btnUpload.setOpaque(false);
		btnUpload.setForeground(new Color(0, 100, 0));
		btnUpload.setBorder(new LineBorder(new Color(0, 100, 0), 2));
		btnUpload.setBackground(Color.WHITE);
		btnUpload.setBounds(51, 194, 106, 26);
		panel.add(btnUpload);
		addFilterDateComponents();
	}

	public void addEvents() {
		radioActive.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtSellPrice.setText("");
			}
		});
		radioSale.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtDiscountPercent.setEditable(true);
			}
		});

		btnFindCategoryChild.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JComboBox<CategoryChildDTO> cboCategorychild = new JComboBox<CategoryChildDTO>(listCategorychild);
				int rs = JOptionPane.showConfirmDialog(null, cboCategorychild);
				if (rs == 0) {
					for (CategoryChildDTO categorychildItem : listCategorychild) {
						if (categorychildItem.getName().equals(String.valueOf(cboCategorychild.getSelectedItem()))) {
							categoryChildDTO = categorychildItem;
							break;
						}
					}
					txtCategoryName.setText(categoryChildDTO.getName());
				}
			}
		});

		btnFindBrand.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JComboBox<BrandDTO> cboBrand = new JComboBox<BrandDTO>(listBrand);
				int rs = JOptionPane.showConfirmDialog(null, cboBrand);
				if (rs == 0) {
					for (BrandDTO brandItem : listBrand) {
						if (brandItem.getName().equals(String.valueOf(cboBrand.getSelectedItem()))) {
							brandDTO = brandItem;
							break;
						}
					}
					txtBrandName.setText(brandDTO.getName());
				}
			}
		});

		btnAccept.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int status = 0;
				if (radioWarehouseProduct.isSelected()) {
					status = 0;
				} else {
					status = radioActive.isSelected() ? 1 : 2;
				}
				float sellprice = 0;
				if (status == 0) {
					sellprice = 0;
				} else if (status == 1) {
					if (txtSellPrice.getText().equals("Chưa đăng bán"))
						sellprice = 0;
					else {
						try {
							sellprice = Float.valueOf(txtSellPrice.getText());
						} catch (Exception e10) {
							sellprice = 0;
						}
					}
				}

				if (nameImage.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng upload ảnh!");
					return;
				}
				ProductDTO productDTO = new ProductDTO(
						txtProductId.getText(),
						brandDTO,
						categoryChildDTO,
						txtProductName.getText(),
						Integer.valueOf(txtProductQuantity.getText()),
						sellprice,
						nameImage.getText(),
						status);

				if (productBLL.update(productDTO) == 0) {
					JOptionPane.showMessageDialog(null, "Lỗi");
					return;
				}
				if (radioSale.isSelected()) {
					try {
						Date selectedDateStart = (Date) datePickerStart.getModel().getValue();
						Date selectedDateEnd = (Date) datePickerEnd.getModel().getValue();

						ProductSaleDTO productSaleDTO = new ProductSaleDTO(
								productDTO,
								Float.valueOf(txtDiscountPercent.getText()) / 100,
								selectedDateStart,
								selectedDateEnd);
						if (productSaleBLL.setSale(productSaleDTO) == 0) {
							JOptionPane.showMessageDialog(null, "Lỗi");
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "Thay đổi thành công!");
				closeDialog();
			}
		});

		btnUpload.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectFile();
			}
		});
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
		CopyImage.deleteFile(".\\src\\images\\product\\" + currentImage);
		this.currentImage = CopyImage.getNameImage(url);
	}

	public void loadProductDetail(ProductDTO productDTO) {
		int checksale = productSaleBLL.checkSale(productDTO.getId_product());
		WarehouseReceiptDetailDTO productWarehouseReciept = warehouseReceiptDetailBLL
				.getwarehouseReceiptDetailsByProductId(productDTO.getId_product());
		categoryChildDTO = categorychildBLL
				.getCategoryChildById(productDTO.getCategorychild().getId_categorychild());
		brandDTO = brandBLL.getBrandById(productDTO.getBrand().getId_brand());
		txtProductId.setText(productDTO.getId_product());
		txtProductName.setText(productDTO.getName());
		txtCategoryName.setText(categoryChildDTO.getName());
		txtBrandName.setText(brandDTO.getName());
		txtProductQuantity.setText(String.valueOf(productDTO.getQuantity()));
		txtWarehousePrice.setText(String.valueOf(productWarehouseReciept.getPrice()));
		image.setIcon(new ImageIcon(CopyImage.resizeImage(".\\src\\images\\product\\" + productDTO.getImage(), image)));
		nameImage.setText(productDTO.getImage());
		if (checksale == 0) {
			radioSale.setSelected(false);
			txtDiscountPercent.setEditable(false);
		} else {

		}
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
			txtDiscountPercent.setText(String.valueOf(productSaleDTO.getDiscountPercent() * 100));
			txtSalePrice.setText(String.valueOf(productDTO.getPrice() * (1 - productWarehouseReciept.getPrice())));
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
			radioActive.setEnabled(true);
			radioBlock.setEnabled(true);
		} else {
			txtProductId.setEditable(false);
			txtProductName.setEditable(false);
			txtProductQuantity.setEditable(false);
			txtBrandName.setEditable(false);
			txtCategoryName.setEditable(false);
			txtSalePrice.setEditable(false);
			txtWarehousePrice.setEditable(false);
			txtSellPrice.setEditable(false);
			radioActive.setEnabled(false);
			radioBlock.setEnabled(false);
			radioWarehouseProduct.setEnabled(false);
			radioSale.setEnabled(false);
		}
	}

	public void closeDialog() {
		this.dispose();
	}

	public void addFilterDateComponents() {
		UtilDateModel modeStart = new UtilDateModel();
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modeStart);

		UtilDateModel modelEnd = new UtilDateModel();
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd);
		pnStart.setLayout(null);

		datePickerStart = new JDatePickerImpl(datePanelStart);
		datePickerStart.setBounds(80, 9, 120, 25);
		pnStart.add(datePickerStart);

		JLabel lblNewLabel_2 = new JLabel("Từ ngày");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(12, 5, 59, 33);
		pnStart.add(lblNewLabel_2);
		pnEnd.setLayout(null);

		datePickerEnd = new JDatePickerImpl(datePanelEnd);
		datePickerEnd.setBounds(80, 8, 120, 26);
		pnEnd.add(datePickerEnd);

		JLabel lblNewLabel_2_1 = new JLabel("Đến ngày");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(12, 5, 59, 33);
		pnEnd.add(lblNewLabel_2_1);
	}
}
