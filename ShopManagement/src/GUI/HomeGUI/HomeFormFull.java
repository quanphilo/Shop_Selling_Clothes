package GUI.HomeGUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class HomeFormFull extends JFrame{
	int posX, posY, widthLeft;
	private JPanel contentPane;
	
	public HomeFormFull() {
		initComponents();
		addEvents();
	}
	
	public void initComponents() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(null);
		pnLeft.setMaximumSize(new Dimension(8200, 32767));
		pnLeft.setBackground(new Color(0, 139, 139));
		pnLeft.setBounds(0, 0, 170, 550);
		contentPane.add(pnLeft);
		
		JLabel lblFashionShop = new JLabel("FASHION SHOP");
		lblFashionShop.setIcon(new ImageIcon(HomeForm.class.getResource("/images/logo shop 86px.png")));
		lblFashionShop.setOpaque(true);
		lblFashionShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblFashionShop.setForeground(Color.WHITE);
		lblFashionShop.setFont(new Font("Segoe UI", Font.BOLD, 8));
		lblFashionShop.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		lblFashionShop.setBackground(new Color(37, 128, 128));
		lblFashionShop.setBounds(0, 0, 170, 37);
		pnLeft.add(lblFashionShop);
		
		JPanel pnMenu = new JPanel();
		pnMenu.setLayout(null);
		pnMenu.setOpaque(false);
		pnMenu.setBounds(0, 40, 170, 510);
		pnLeft.add(pnMenu);
		
		JPanel pnOptions = new JPanel();
		pnOptions.setOpaque(false);
		pnOptions.setBounds(0, 0, 170, 510);
		pnMenu.add(pnOptions);
		pnOptions.setLayout(new GridLayout(12, 1, 0, 0));
		
		JPanel pnProduct = new JPanel();
		pnProduct.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnProduct.setOpaque(false);
		pnOptions.add(pnProduct);
		GridBagLayout gbl_pnProduct = new GridBagLayout();
		gbl_pnProduct.columnWidths = new int[] {30, 100};
		gbl_pnProduct.rowHeights = new int[] {50, 0};
		gbl_pnProduct.columnWeights = new double[]{0.0, 0.0};
		gbl_pnProduct.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnProduct.setLayout(gbl_pnProduct);
		
		JLabel lblIcon_1 = new JLabel("");
		lblIcon_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/clothes-hanger.png")));
		lblIcon_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_1 = new GridBagConstraints();
		gbc_lblIcon_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_1.gridx = 0;
		gbc_lblIcon_1.gridy = 0;
		pnProduct.add(lblIcon_1, gbc_lblIcon_1);
		
		JLabel lblSnPhm = new JLabel("Sản phẩm");
		lblSnPhm.setForeground(Color.WHITE);
		lblSnPhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblSnPhm = new GridBagConstraints();
		gbc_lblSnPhm.fill = GridBagConstraints.BOTH;
		gbc_lblSnPhm.insets = new Insets(0, 0, 0, 5);
		gbc_lblSnPhm.gridx = 1;
		gbc_lblSnPhm.gridy = 0;
		pnProduct.add(lblSnPhm, gbc_lblSnPhm);
		
		JPanel pnSell = new JPanel();
		pnSell.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnProduct.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnSell.setOpaque(false);
		pnOptions.add(pnSell);
		GridBagLayout gbl_pnSell = new GridBagLayout();
		gbl_pnSell.columnWidths = new int[] {30, 100};
		gbl_pnSell.rowHeights = new int[] {50, 0};
		gbl_pnSell.columnWeights = new double[]{0.0, 0.0};
		gbl_pnSell.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnSell.setLayout(gbl_pnSell);
		
		JLabel lblIcon_1_1 = new JLabel("");
		lblIcon_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/shopping-bag.png")));
		lblIcon_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_1_1 = new GridBagConstraints();
		gbc_lblIcon_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_1_1.gridx = 0;
		gbc_lblIcon_1_1.gridy = 0;
		pnSell.add(lblIcon_1_1, gbc_lblIcon_1_1);
		
		JLabel lblPhiuNhp = new JLabel("Bán hàng");
		lblPhiuNhp.setForeground(Color.WHITE);
		lblPhiuNhp.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp = new GridBagConstraints();
		gbc_lblPhiuNhp.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhiuNhp.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp.gridx = 1;
		gbc_lblPhiuNhp.gridy = 0;
		pnSell.add(lblPhiuNhp, gbc_lblPhiuNhp);

		JPanel pnCategory = new JPanel();
		pnCategory.setOpaque(false);
		pnCategory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		GridBagLayout gbl_pnStatistic = new GridBagLayout();
		gbl_pnStatistic.columnWidths = new int[] {30, 100};
		gbl_pnStatistic.rowHeights = new int[] {50, 0};
		gbl_pnStatistic.columnWeights = new double[]{0.0, 0.0};
		gbl_pnStatistic.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnCategory.setLayout(gbl_pnStatistic);
		
		JLabel lblIcon_2_1_1_1_1_2_1 = new JLabel("");
		lblIcon_2_1_1_1_1_2_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/analysis.png")));
		lblIcon_2_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1_1_2_1 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1_1_2_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1_1_2_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1_1_2_1.gridx = 0;
		gbc_lblIcon_2_1_1_1_1_2_1.gridy = 0;
		pnCategory.add(lblIcon_2_1_1_1_1_2_1, gbc_lblIcon_2_1_1_1_1_2_1);
		
		JLabel lblPhiuNhp_1_1_1_1_2_1 = new JLabel("Danh mục SP");
		lblPhiuNhp_1_1_1_1_2_1.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_2_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1_1_2_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1_1_2_1.gridx = 1;
		gbc_lblPhiuNhp_1_1_1_1_2_1.gridy = 0;
		pnCategory.add(lblPhiuNhp_1_1_1_1_2_1, gbc_lblPhiuNhp_1_1_1_1_2_1);
		
		JPanel pnSupplier = new JPanel();
		pnSupplier.setOpaque(false);
		pnSupplier.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnSupplier);
		GridBagLayout gbl_pnSupplier = new GridBagLayout();
		gbl_pnSupplier.columnWidths = new int[] {30, 100};
		gbl_pnSupplier.rowHeights = new int[] {50, 0};
		gbl_pnSupplier.columnWeights = new double[]{0.0, 0.0};
		gbl_pnSupplier.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnSupplier.setLayout(gbl_pnSupplier);
		
		JLabel lblIcon_2 = new JLabel("");
		lblIcon_2.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/warehouse (1).png")));
		lblIcon_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2 = new GridBagConstraints();
		gbc_lblIcon_2.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2.gridx = 0;
		gbc_lblIcon_2.gridy = 0;
		pnSupplier.add(lblIcon_2, gbc_lblIcon_2);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp");
		lblNhCungCp.setForeground(Color.WHITE);
		lblNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNhCungCp = new GridBagConstraints();
		gbc_lblNhCungCp.fill = GridBagConstraints.BOTH;
		gbc_lblNhCungCp.gridx = 1;
		gbc_lblNhCungCp.gridy = 0;
		pnSupplier.add(lblNhCungCp, gbc_lblNhCungCp);
		
		JPanel pnWarehouse = new JPanel();
		pnWarehouse.setOpaque(false);
		pnWarehouse.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnWarehouse);
		GridBagLayout gbl_pnWarehouse = new GridBagLayout();
		gbl_pnWarehouse.columnWidths = new int[] {30, 100};
		gbl_pnWarehouse.rowHeights = new int[] {50, 0};
		gbl_pnWarehouse.columnWeights = new double[]{0.0, 0.0};
		gbl_pnWarehouse.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnWarehouse.setLayout(gbl_pnWarehouse);
		
		JLabel lblIcon_2_1 = new JLabel("");
		lblIcon_2_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/invoice.png")));
		lblIcon_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1 = new GridBagConstraints();
		gbc_lblIcon_2_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1.gridx = 0;
		gbc_lblIcon_2_1.gridy = 0;
		pnWarehouse.add(lblIcon_2_1, gbc_lblIcon_2_1);
		
		JLabel lblPhiuNhp_1 = new JLabel("Phiếu nhập");
		lblPhiuNhp_1.setForeground(Color.WHITE);
		lblPhiuNhp_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1.gridx = 1;
		gbc_lblPhiuNhp_1.gridy = 0;
		pnWarehouse.add(lblPhiuNhp_1, gbc_lblPhiuNhp_1);
		
		
		JPanel pnPostProduct = new JPanel();
		pnPostProduct.setOpaque(false);
		pnPostProduct.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnPostProduct);
		GridBagLayout gbl_pnPostProduct = new GridBagLayout();
		gbl_pnPostProduct.columnWidths = new int[] {30, 100};
		gbl_pnPostProduct.rowHeights = new int[]{50, 0};
		gbl_pnPostProduct.columnWeights = new double[]{0.0, 0.0};
		gbl_pnPostProduct.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnPostProduct.setLayout(gbl_pnPostProduct);
		
		JLabel lblIcon_2_1_1_1_1_2_1_1 = new JLabel("");
		lblIcon_2_1_1_1_1_2_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/nhap hang.png")));
		lblIcon_2_1_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1_1_2_1_1 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1_1_2_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1_1_2_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1_1_2_1_1.gridx = 0;
		gbc_lblIcon_2_1_1_1_1_2_1_1.gridy = 0;
		pnPostProduct.add(lblIcon_2_1_1_1_1_2_1_1, gbc_lblIcon_2_1_1_1_1_2_1_1);
		
		JLabel lblPhiuNhp_1_1_1_1_2_1_1 = new JLabel("Nhập hàng");
		lblPhiuNhp_1_1_1_1_2_1_1.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_2_1_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1_1_2_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1_1_2_1_1.gridx = 1;
		gbc_lblPhiuNhp_1_1_1_1_2_1_1.gridy = 0;
		pnPostProduct.add(lblPhiuNhp_1_1_1_1_2_1_1, gbc_lblPhiuNhp_1_1_1_1_2_1_1);
		
		
		
		JPanel pnVoucher = new JPanel();
		pnVoucher.setOpaque(false);
		pnVoucher.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnVoucher);
		GridBagLayout gbl_pnVoucher = new GridBagLayout();
		gbl_pnVoucher.columnWidths = new int[] {30, 100};
		gbl_pnVoucher.rowHeights = new int[] {50, 0};
		gbl_pnVoucher.columnWeights = new double[]{0.0, 0.0};
		gbl_pnVoucher.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnVoucher.setLayout(gbl_pnVoucher);
		
		JLabel lblIcon_2_1_1 = new JLabel("");
		lblIcon_2_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/gift-voucher.png")));
		lblIcon_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1 = new GridBagConstraints();
		gbc_lblIcon_2_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1.gridx = 0;
		gbc_lblIcon_2_1_1.gridy = 0;
		pnVoucher.add(lblIcon_2_1_1, gbc_lblIcon_2_1_1);
		
		JLabel lblPhiuNhp_1_1 = new JLabel("Khuyến mãi");
		lblPhiuNhp_1_1.setForeground(Color.WHITE);
		lblPhiuNhp_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1.gridx = 1;
		gbc_lblPhiuNhp_1_1.gridy = 0;
		pnVoucher.add(lblPhiuNhp_1_1, gbc_lblPhiuNhp_1_1);
		
		JPanel pnOrder = new JPanel();
		pnOrder.setOpaque(false);
		pnOrder.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnOrder);
		GridBagLayout gbl_pnOrder = new GridBagLayout();
		gbl_pnOrder.columnWidths = new int[] {30, 100};
		gbl_pnOrder.rowHeights = new int[] {50, 0};
		gbl_pnOrder.columnWeights = new double[]{0.0, 0.0};
		gbl_pnOrder.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnOrder.setLayout(gbl_pnOrder);
		
		JLabel lblIcon_2_1_1_1 = new JLabel("");
		lblIcon_2_1_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/documents.png")));
		lblIcon_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1.gridx = 0;
		gbc_lblIcon_2_1_1_1.gridy = 0;
		pnOrder.add(lblIcon_2_1_1_1, gbc_lblIcon_2_1_1_1);
		
		JLabel lblPhiuNhp_1_1_1 = new JLabel("Hoá đơn");
		lblPhiuNhp_1_1_1.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1.gridx = 1;
		gbc_lblPhiuNhp_1_1_1.gridy = 0;
		pnOrder.add(lblPhiuNhp_1_1_1, gbc_lblPhiuNhp_1_1_1);
		
		JPanel pnEmployee = new JPanel();
		pnEmployee.setOpaque(false);
		pnEmployee.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnEmployee);
		GridBagLayout gbl_pnEmployee = new GridBagLayout();
		gbl_pnEmployee.columnWidths = new int[] {30, 100};
		gbl_pnEmployee.rowHeights = new int[] {50, 0};
		gbl_pnEmployee.columnWeights = new double[]{0.0, 0.0};
		gbl_pnEmployee.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnEmployee.setLayout(gbl_pnEmployee);
		
		JLabel lblIcon_2_1_1_1_1 = new JLabel("");
		lblIcon_2_1_1_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/employee (1).png")));
		lblIcon_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1_1.gridx = 0;
		gbc_lblIcon_2_1_1_1_1.gridy = 0;
		pnEmployee.add(lblIcon_2_1_1_1_1, gbc_lblIcon_2_1_1_1_1);
		
		JLabel lblPhiuNhp_1_1_1_1 = new JLabel("Nhân viên");
		lblPhiuNhp_1_1_1_1.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1_1.gridx = 1;
		gbc_lblPhiuNhp_1_1_1_1.gridy = 0;
		pnEmployee.add(lblPhiuNhp_1_1_1_1, gbc_lblPhiuNhp_1_1_1_1);
		
		JPanel pnCustomer = new JPanel();
		pnCustomer.setOpaque(false);
		pnCustomer.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnCustomer);
		GridBagLayout gbl_pnCustomer = new GridBagLayout();
		gbl_pnCustomer.columnWidths = new int[] {30, 100};
		gbl_pnCustomer.rowHeights = new int[] {50, 0};
		gbl_pnCustomer.columnWeights = new double[]{0.0, 0.0};
		gbl_pnCustomer.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnCustomer.setLayout(gbl_pnCustomer);
		
		JLabel lblIcon_2_1_1_1_1_1 = new JLabel("");
		lblIcon_2_1_1_1_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/rating.png")));
		lblIcon_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1_1_1.gridx = 0;
		gbc_lblIcon_2_1_1_1_1_1.gridy = 0;
		pnCustomer.add(lblIcon_2_1_1_1_1_1, gbc_lblIcon_2_1_1_1_1_1);
		
		JLabel lblPhiuNhp_1_1_1_1_1 = new JLabel("Khách hàng");
		lblPhiuNhp_1_1_1_1_1.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1_1_1.gridx = 1;
		gbc_lblPhiuNhp_1_1_1_1_1.gridy = 0;
		pnCustomer.add(lblPhiuNhp_1_1_1_1_1, gbc_lblPhiuNhp_1_1_1_1_1);
		
		JPanel pnPermission = new JPanel();
		pnPermission.setOpaque(false);
		pnPermission.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnPermission);
		GridBagLayout gbl_pnPermission = new GridBagLayout();
		gbl_pnPermission.columnWidths = new int[] {30, 100};
		gbl_pnPermission.rowHeights = new int[] {50, 0};
		gbl_pnPermission.columnWeights = new double[]{0.0, 0.0};
		gbl_pnPermission.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnPermission.setLayout(gbl_pnPermission);
		
		JLabel lblIcon_2_1_1_1_1_2 = new JLabel("");
		lblIcon_2_1_1_1_1_2.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/shield.png")));
		lblIcon_2_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1_1_2.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1_1_2.gridx = 0;
		gbc_lblIcon_2_1_1_1_1_2.gridy = 0;
		pnPermission.add(lblIcon_2_1_1_1_1_2, gbc_lblIcon_2_1_1_1_1_2);
		
		JLabel lblPhiuNhp_1_1_1_1_2 = new JLabel("Quyền");
		lblPhiuNhp_1_1_1_1_2.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1_1_2.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1_1_2.gridx = 1;
		gbc_lblPhiuNhp_1_1_1_1_2.gridy = 0;
		pnPermission.add(lblPhiuNhp_1_1_1_1_2, gbc_lblPhiuNhp_1_1_1_1_2);
		
		JPanel pnStatistic = new JPanel();
		pnStatistic.setOpaque(false);
		pnStatistic.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		pnOptions.add(pnStatistic);
		GridBagLayout gbl_pnStatistic1 = new GridBagLayout();
		gbl_pnStatistic1.columnWidths = new int[] {30, 100};
		gbl_pnStatistic1.rowHeights = new int[] {50, 0};
		gbl_pnStatistic1.columnWeights = new double[]{0.0, 0.0};
		gbl_pnStatistic1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnStatistic.setLayout(gbl_pnStatistic1);
		
		JLabel lblIcon_2_1_1_1_1_2_11 = new JLabel("");
		lblIcon_2_1_1_1_1_2_11.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/analysis.png")));
		lblIcon_2_1_1_1_1_2_11.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIcon_2_1_1_1_1_2_11 = new GridBagConstraints();
		gbc_lblIcon_2_1_1_1_1_2_11.fill = GridBagConstraints.BOTH;
		gbc_lblIcon_2_1_1_1_1_2_11.insets = new Insets(0, 0, 0, 5);
		gbc_lblIcon_2_1_1_1_1_2_11.gridx = 0;
		gbc_lblIcon_2_1_1_1_1_2_11.gridy = 0;
		pnStatistic.add(lblIcon_2_1_1_1_1_2_11, gbc_lblIcon_2_1_1_1_1_2_11);
		
		JLabel lblPhiuNhp_1_1_1_1_2_11 = new JLabel("Thống kê");
		lblPhiuNhp_1_1_1_1_2_11.setForeground(Color.WHITE);
		lblPhiuNhp_1_1_1_1_2_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_2_11 = new GridBagConstraints();
		gbc_lblPhiuNhp_1_1_1_1_2_11.fill = GridBagConstraints.BOTH;
		gbc_lblPhiuNhp_1_1_1_1_2_11.gridx = 1;
		gbc_lblPhiuNhp_1_1_1_1_2_11.gridy = 0;
		pnStatistic.add(lblPhiuNhp_1_1_1_1_2_11, gbc_lblPhiuNhp_1_1_1_1_2_11);
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(null);
		pnRight.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnRight.setBackground(new Color(211, 211, 211));
		pnRight.setBounds(169, 0, 830, 500);
		contentPane.add(pnRight);
		
		JPanel pnHeader = new JPanel();
		pnHeader.setLayout(null);
		pnHeader.setBorder(null);
		pnHeader.setBackground(Color.WHITE);
		pnHeader.setBounds(0, 0, 830, 37);
		pnRight.add(pnHeader);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(new Color(0, 128, 128));
		lblMinimize.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMinimize.setBounds(744, 0, 43, 37);
		pnHeader.add(lblMinimize);
		
		JLabel lblClose = new JLabel("x");
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(new Color(0, 128, 128));
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClose.setBackground(Color.WHITE);
		lblClose.setBounds(787, 0, 43, 37);
		pnHeader.add(lblClose);
		
		JPanel pnMain_home = new JPanel();
		pnMain_home.setLayout(null);
		pnMain_home.setOpaque(false);
		pnMain_home.setBounds(0, 37, 830, 513);
		pnRight.add(pnMain_home);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(HomeForm.class.getResource("/images/logo shop 500px.png")));
		lblNewLabel.setBounds(0, 0, 830, 490);
		pnMain_home.add(lblNewLabel);
	}
	
	public void addEvents() {
		//Move frame | drag and drop title bar
//		pnHeader.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				posX = e.getX();
//				posY = e.getY();
//			}
//		});
//		pnHeader.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				int positionX = e.getXOnScreen();
//				int positionY = e.getYOnScreen();
//				moveWindow(positionX - posX - 210, positionY - posY);
//			}
//		});
	}
}
