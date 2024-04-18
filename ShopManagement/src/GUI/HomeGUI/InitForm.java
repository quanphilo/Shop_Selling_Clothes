package GUI.HomeGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class InitForm {

    private JPanel pnProduct;
    private JPanel pnSell;
    private JPanel pnSupplier;
    private JPanel pnWarehouse;
    private JPanel pnPostProduct;
    private JPanel pnVoucher;
    private JPanel pnOrder;
    private JPanel pnEmployee;
    private JPanel pnCustomer;
    private JPanel pnPermission;
    private JPanel pnStatistic;
    private JPanel pnCategory;
    
    private JPanel pnEmployeeAdmin;

    public InitForm() {
        createJPanel();
    }

    public void createJPanel() {
        this.setPnCustomer(createPnCustomer());
        this.setPnEmployee(createPnEmployee());
        this.setPnOrder(createPnOrder());
        this.setPnPermission(createPnPermission());
        this.setPnPostProduct(createPnPostProduct());
        this.setPnProduct(createPnProduct());
        this.setPnWarehouse(createPnWarehouse());
        this.setPnSell(createPnSell());
        this.setPnStatistic(createPnStatistic());
        this.setPnSupplier(createPnSupplier());
        this.setPnVoucher(createPnVoucher());
        this.setPnCategory(createPnCategory());
        
        this.setPnEmployeeAdmin();
    }

    public JPanel createPnProduct() {
        JPanel pnProduct = new JPanel();
        pnProduct.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        pnProduct.setOpaque(false);
        GridBagLayout gbl_pnProduct = new GridBagLayout();
        gbl_pnProduct.columnWidths = new int[]{30, 100};
        gbl_pnProduct.rowHeights = new int[]{50, 0};
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

        return pnProduct;
    }

    public JPanel createPnSell() {
        JPanel pnSell = new JPanel();
        pnSell.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        pnSell.setOpaque(false);
        GridBagLayout gbl_pnSell = new GridBagLayout();
        gbl_pnSell.columnWidths = new int[]{30, 100};
        gbl_pnSell.rowHeights = new int[]{50, 0};
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

        return pnSell;
    }

    public JPanel createPnSupplier() {
        JPanel pnSupplier = new JPanel();
        pnSupplier.setOpaque(false);
        pnSupplier.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnSupplier = new GridBagLayout();
        gbl_pnSupplier.columnWidths = new int[]{30, 100};
        gbl_pnSupplier.rowHeights = new int[]{50, 0};
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

        return pnSupplier;
    }

    public JPanel createPnWarehouse() {
        JPanel pnWarehouse = new JPanel();
        pnWarehouse.setOpaque(false);
        pnWarehouse.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnWarehouse = new GridBagLayout();
        gbl_pnWarehouse.columnWidths = new int[]{30, 100};
        gbl_pnWarehouse.rowHeights = new int[]{50, 0};
        gbl_pnWarehouse.columnWeights = new double[]{0.0, 0.0};
        gbl_pnWarehouse.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pnWarehouse.setLayout(gbl_pnWarehouse);

        JLabel lblIcon_2_1 = new JLabel("");
        lblIcon_2_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/nhap hang.png")));
        lblIcon_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblIcon_2_1 = new GridBagConstraints();
        gbc_lblIcon_2_1.fill = GridBagConstraints.BOTH;
        gbc_lblIcon_2_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblIcon_2_1.gridx = 0;
        gbc_lblIcon_2_1.gridy = 0;
        pnWarehouse.add(lblIcon_2_1, gbc_lblIcon_2_1);

        JLabel lblPhiuNhp_1 = new JLabel("Nhập hàng");
        lblPhiuNhp_1.setForeground(Color.WHITE);
        lblPhiuNhp_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblPhiuNhp_1 = new GridBagConstraints();
        gbc_lblPhiuNhp_1.fill = GridBagConstraints.BOTH;
        gbc_lblPhiuNhp_1.gridx = 1;
        gbc_lblPhiuNhp_1.gridy = 0;
        pnWarehouse.add(lblPhiuNhp_1, gbc_lblPhiuNhp_1);

        return pnWarehouse;
    }

    public JPanel createPnPostProduct() {
        JPanel pnPostProduct = new JPanel();
        pnPostProduct.setOpaque(false);
        pnPostProduct.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnPostProduct = new GridBagLayout();
        gbl_pnPostProduct.columnWidths = new int[]{30, 100};
        gbl_pnPostProduct.rowHeights = new int[]{50, 0};
        gbl_pnPostProduct.columnWeights = new double[]{0.0, 0.0};
        gbl_pnPostProduct.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pnPostProduct.setLayout(gbl_pnPostProduct);

        JLabel lblIcon_2_1_1_1_1_2_1_1 = new JLabel("");
        lblIcon_2_1_1_1_1_2_1_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/clothing.png")));
        lblIcon_2_1_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblIcon_2_1_1_1_1_2_1_1 = new GridBagConstraints();
        gbc_lblIcon_2_1_1_1_1_2_1_1.fill = GridBagConstraints.BOTH;
        gbc_lblIcon_2_1_1_1_1_2_1_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblIcon_2_1_1_1_1_2_1_1.gridx = 0;
        gbc_lblIcon_2_1_1_1_1_2_1_1.gridy = 0;
        pnPostProduct.add(lblIcon_2_1_1_1_1_2_1_1, gbc_lblIcon_2_1_1_1_1_2_1_1);

        JLabel lblPhiuNhp_1_1_1_1_2_1_1 = new JLabel("Đăng bán");
        lblPhiuNhp_1_1_1_1_2_1_1.setForeground(Color.WHITE);
        lblPhiuNhp_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_2_1_1 = new GridBagConstraints();
        gbc_lblPhiuNhp_1_1_1_1_2_1_1.fill = GridBagConstraints.BOTH;
        gbc_lblPhiuNhp_1_1_1_1_2_1_1.gridx = 1;
        gbc_lblPhiuNhp_1_1_1_1_2_1_1.gridy = 0;
        pnPostProduct.add(lblPhiuNhp_1_1_1_1_2_1_1, gbc_lblPhiuNhp_1_1_1_1_2_1_1);

        return pnPostProduct;
    }

    public JPanel createPnVoucher() {
        JPanel pnVoucher = new JPanel();
        pnVoucher.setOpaque(false);
        pnVoucher.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnVoucher = new GridBagLayout();
        gbl_pnVoucher.columnWidths = new int[]{30, 100};
        gbl_pnVoucher.rowHeights = new int[]{50, 0};
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

        return pnVoucher;
    }

    public JPanel createPnOrder() {
        JPanel pnOrder = new JPanel();
        pnOrder.setOpaque(false);
        pnOrder.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnOrder = new GridBagLayout();
        gbl_pnOrder.columnWidths = new int[]{30, 100};
        gbl_pnOrder.rowHeights = new int[]{50, 0};
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

        return pnOrder;
    }

    public JPanel createPnEmployee() {
        JPanel pnEmployee = new JPanel();
        pnEmployee.setOpaque(false);
        pnEmployee.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnEmployee = new GridBagLayout();
        gbl_pnEmployee.columnWidths = new int[]{30, 100};
        gbl_pnEmployee.rowHeights = new int[]{50, 0};
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

        return pnEmployee;
    }

    public JPanel createPnEmployeeAdmin() {
        JPanel pnEmployee = new JPanel();
        pnEmployee.setOpaque(false);
        pnEmployee.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnEmployee = new GridBagLayout();
        gbl_pnEmployee.columnWidths = new int[]{30, 100};
        gbl_pnEmployee.rowHeights = new int[]{50, 0};
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

        JLabel lblPhiuNhp_1_1_1_1 = new JLabel("Tài khoản");
        lblPhiuNhp_1_1_1_1.setForeground(Color.WHITE);
        lblPhiuNhp_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblPhiuNhp_1_1_1_1 = new GridBagConstraints();
        gbc_lblPhiuNhp_1_1_1_1.fill = GridBagConstraints.BOTH;
        gbc_lblPhiuNhp_1_1_1_1.gridx = 1;
        gbc_lblPhiuNhp_1_1_1_1.gridy = 0;
        pnEmployee.add(lblPhiuNhp_1_1_1_1, gbc_lblPhiuNhp_1_1_1_1);

        return pnEmployee;
    }

    public JPanel createPnCustomer() {
        JPanel pnCustomer = new JPanel();
        pnCustomer.setOpaque(false);
        pnCustomer.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnCustomer = new GridBagLayout();
        gbl_pnCustomer.columnWidths = new int[]{30, 100};
        gbl_pnCustomer.rowHeights = new int[]{50, 0};
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

        return pnCustomer;
    }

    public JPanel createPnPermission() {
        JPanel pnPermission = new JPanel();
        pnPermission.setOpaque(false);
        pnPermission.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnPermission = new GridBagLayout();
        gbl_pnPermission.columnWidths = new int[]{30, 100};
        gbl_pnPermission.rowHeights = new int[]{50, 0};
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

        return pnPermission;
    }

    public JPanel createPnStatistic() {
        JPanel pnStatistic = new JPanel();
        pnStatistic.setOpaque(false);
        pnStatistic.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnStatistic = new GridBagLayout();
        gbl_pnStatistic.columnWidths = new int[]{30, 100};
        gbl_pnStatistic.rowHeights = new int[]{50, 0};
        gbl_pnStatistic.columnWeights = new double[]{0.0, 0.0};
        gbl_pnStatistic.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        pnStatistic.setLayout(gbl_pnStatistic);

        JLabel lblIcon_2_1_1_1_1_2_1 = new JLabel("");
        lblIcon_2_1_1_1_1_2_1.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/analysis.png")));
        lblIcon_2_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblIcon_2_1_1_1_1_2_1 = new GridBagConstraints();
        gbc_lblIcon_2_1_1_1_1_2_1.fill = GridBagConstraints.BOTH;
        gbc_lblIcon_2_1_1_1_1_2_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblIcon_2_1_1_1_1_2_1.gridx = 0;
        gbc_lblIcon_2_1_1_1_1_2_1.gridy = 0;
        pnStatistic.add(lblIcon_2_1_1_1_1_2_1, gbc_lblIcon_2_1_1_1_1_2_1);

        JLabel lblPhiuNhp_1_1_1_1_2_1 = new JLabel("Thống kê");
        lblPhiuNhp_1_1_1_1_2_1.setForeground(Color.WHITE);
        lblPhiuNhp_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblPhiuNhp_1_1_1_1_2_1 = new GridBagConstraints();
        gbc_lblPhiuNhp_1_1_1_1_2_1.fill = GridBagConstraints.BOTH;
        gbc_lblPhiuNhp_1_1_1_1_2_1.gridx = 1;
        gbc_lblPhiuNhp_1_1_1_1_2_1.gridy = 0;
        pnStatistic.add(lblPhiuNhp_1_1_1_1_2_1, gbc_lblPhiuNhp_1_1_1_1_2_1);

        return pnStatistic;
    }

    public JPanel createPnCategory() {
        JPanel pnCategory = new JPanel();
        pnCategory.setOpaque(false);
        pnCategory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
        GridBagLayout gbl_pnStatistic = new GridBagLayout();
        gbl_pnStatistic.columnWidths = new int[]{30, 100};
        gbl_pnStatistic.rowHeights = new int[]{50, 0};
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

        return pnCategory;
    }

    public JPanel getPnCategory() {
        return pnCategory;
    }

    public void setPnCategory(JPanel pnCategory) {
        this.pnCategory = pnCategory;
    }

    public JPanel getPnProduct() {
        return pnProduct;
    }

    public void setPnProduct(JPanel pnProduct) {
        this.pnProduct = pnProduct;
    }

    public JPanel getPnSell() {
        return pnSell;
    }

    public void setPnSell(JPanel pnSell) {
        this.pnSell = pnSell;
    }

    public JPanel getPnSupplier() {
        return pnSupplier;
    }

    public void setPnSupplier(JPanel pnSupplier) {
        this.pnSupplier = pnSupplier;
    }

    public JPanel getPnWarehouse() {
        return pnWarehouse;
    }

    public void setPnWarehouse(JPanel pnWarehouse) {
        this.pnWarehouse = pnWarehouse;
    }

    public JPanel getPnPostProduct() {
        return pnPostProduct;
    }

    public void setPnPostProduct(JPanel pnPostProduct) {
        this.pnPostProduct = pnPostProduct;
    }

    public JPanel getPnVoucher() {
        return pnVoucher;
    }

    public void setPnVoucher(JPanel pnVoucher) {
        this.pnVoucher = pnVoucher;
    }

    public JPanel getPnOrder() {
        return pnOrder;
    }

    public void setPnOrder(JPanel pnOrder) {
        this.pnOrder = pnOrder;
    }

    public JPanel getPnEmployee() {
        return pnEmployee;
    }

    public void setPnEmployee(JPanel pnEmployee) {
        this.pnEmployee = pnEmployee;
    }

    public JPanel getPnCustomer() {
        return pnCustomer;
    }

    public void setPnCustomer(JPanel pnCustomer) {
        this.pnCustomer = pnCustomer;
    }

    public JPanel getPnPermission() {
        return pnPermission;
    }

    public void setPnPermission(JPanel pnPermission) {
        this.pnPermission = pnPermission;
    }

    public JPanel getPnStatistic() {
        return pnStatistic;
    }

    public void setPnStatistic(JPanel pnStatistic) {
        this.pnStatistic = pnStatistic;
    }
    
    public JPanel getPnEmployeeAdmin() {
        return pnEmployeeAdmin;
    }

    public void setPnEmployeeAdmin() {
        this.pnEmployeeAdmin = createPnEmployeeAdmin();
    }

}
