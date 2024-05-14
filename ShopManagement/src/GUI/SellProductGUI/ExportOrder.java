package GUI.SellProductGUI;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import BLL.OrderBLL;
import BLL.OrderItemBLL;
import BLL.ProductBLL;
import DAL.JDBCUtil;
import DTO.CustomerDTO;
import DTO.OrderDTO;
import DTO.OrderItemDTO;
import DTO.ProductDTO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.IOException;
import java.util.*;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.view.JasperViewer;

public class ExportOrder extends JDialog {

    private CustomerDTO customerDTO;
    private OrderDTO orderDTO;
    private Vector<OrderItemDTO> listOrderItemDTO;
    private JPanel pnHeader;
    private JTextField txtSalePercent;
    private JTextField txtSalePrice;
    private JTextField txtTotalPrice;
    private JTextField txtCustomerPoint;
    private JButton btnExportPDF;
    private JLabel lblShopName;
    private JPanel pnOrder;
    private JPanel panel_2;
    private JLabel lblEmplo;
    private JLabel lblCus;
    private JLabel lblOrderDate;
    private JScrollPane scrollPane;
    private JTable tblOrderItem;
    private JRadioButton radioSale;
    private JTextField txtOrderPoint;
    private JPanel panel;

    private OrderItemBLL orderItemBLL = new OrderItemBLL();
    private ProductBLL productBLL = new ProductBLL();
    private OrderBLL orderBLL = new OrderBLL();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Date date = new Date();
    private JPanel panel_1;
    private JLabel lblOrderId;
    private JLabel lblMHan;
    private JLabel lblEmployee;
    private JLabel lblCustomer;
    private JLabel lblDate;

    private String orderId;
    private double totalPrice = 0;
    private double discountAmount = 0;

    public ExportOrder() {
        initComponents();
    }

    public ExportOrder(OrderDTO order, CustomerDTO customer, Vector<OrderItemDTO> listOrderItemDTO, double discountAmount) {
        initComponents();
        loadInfos(order, customer, listOrderItemDTO);
        this.listOrderItemDTO = listOrderItemDTO;
        this.discountAmount = discountAmount;
        reloadComponents();
        addEvents();
    }

    public void initComponents() {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pnHeader = new JPanel();
        pnHeader.setBackground(Color.WHITE);
        pnHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
        pnHeader.setBounds(0, 0, 384, 32);
        getContentPane().add(pnHeader);

        lblShopName = new JLabel("FASHION SHOP");
        lblShopName.setHorizontalAlignment(SwingConstants.CENTER);
        lblShopName.setForeground(new Color(0, 128, 128));
        lblShopName.setFont(new Font("Dialog", Font.BOLD, 15));
        pnHeader.add(lblShopName);

        pnOrder = new JPanel();
        pnOrder.setBackground(Color.WHITE);
        pnOrder.setLayout(null);
        pnOrder.setBounds(0, 31, 384, 530);
        getContentPane().add(pnOrder);

        panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setLayout(null);
        panel_2.setBounds(12, 12, 362, 160);
        pnOrder.add(panel_2);

        lblOrderDate = new JLabel("Ngày");
        lblOrderDate.setForeground(new Color(0, 128, 0));
        lblOrderDate.setBounds(12, 104, 36, 16);
        panel_2.add(lblOrderDate);

        lblCus = new JLabel("Khách hàng");
        lblCus.setForeground(new Color(0, 128, 0));
        lblCus.setBounds(12, 76, 70, 16);
        panel_2.add(lblCus);

        lblEmplo = new JLabel("Nhân viên");
        lblEmplo.setForeground(new Color(0, 128, 0));
        lblEmplo.setBounds(12, 40, 61, 16);
        panel_2.add(lblEmplo);

        lblOrderId = new JLabel("");
        lblOrderId.setBounds(98, 12, 139, 16);
        panel_2.add(lblOrderId);

        lblMHan = new JLabel("Mã hóa đơn");
        lblMHan.setForeground(new Color(0, 128, 0));
        lblMHan.setBounds(12, 12, 70, 16);
        panel_2.add(lblMHan);

        lblEmployee = new JLabel("");
        lblEmployee.setBounds(98, 40, 105, 16);
        panel_2.add(lblEmployee);

        lblCustomer = new JLabel("");
        lblCustomer.setBounds(98, 76, 105, 16);
        panel_2.add(lblCustomer);

        lblDate = new JLabel("");
        lblDate.setBounds(87, 104, 116, 16);
        panel_2.add(lblDate);

        btnExportPDF = new JButton("Xuất PDF");
        btnExportPDF.setIcon(new ImageIcon(ExportOrder.class.getResource("/images/pdf.png")));
        btnExportPDF.setForeground(Color.WHITE);
        btnExportPDF.setFont(new Font("Dialog", Font.BOLD, 13));
        btnExportPDF.setBackground(new Color(0, 128, 128));
        btnExportPDF.setBounds(230, 488, 131, 35);
        pnOrder.add(btnExportPDF);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(12, 345, 362, 135);
        pnOrder.add(panel);
        panel.setLayout(null);

        txtSalePercent = new JTextField();
        txtSalePercent.setOpaque(false);
        txtSalePercent.setForeground(new Color(220, 20, 60));
        txtSalePercent.setColumns(10);
        txtSalePercent.setBorder(new TitledBorder(null, "%", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
        txtSalePercent.setBounds(116, 43, 66, 35);
        panel.add(txtSalePercent);

        radioSale = new JRadioButton("Khuyến mãi");
        radioSale.setBackground(Color.WHITE);
        radioSale.setForeground(new Color(220, 20, 60));
        radioSale.setFont(new Font("Dialog", Font.BOLD, 13));
        radioSale.setBounds(8, 50, 107, 24);
        panel.add(radioSale);

        txtSalePrice = new JTextField();
        txtSalePrice.setOpaque(false);
        txtSalePrice.setForeground(new Color(220, 20, 60));
        txtSalePrice.setEditable(false);
        txtSalePrice.setColumns(10);
        txtSalePrice.setBorder(new TitledBorder(null, "Giảm giá (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
        txtSalePrice.setBounds(191, 43, 159, 35);
        panel.add(txtSalePrice);

        txtTotalPrice = new JTextField();
        txtTotalPrice.setOpaque(false);
        txtTotalPrice.setColumns(10);
        txtTotalPrice.setBorder(new TitledBorder(null, "Thanh toán (đ)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
        txtTotalPrice.setBounds(8, 5, 174, 35);
        panel.add(txtTotalPrice);

        txtOrderPoint = new JTextField();
        txtOrderPoint.setOpaque(false);
        txtOrderPoint.setColumns(10);
        txtOrderPoint.setBorder(new TitledBorder(null, "Điểm hoá đơn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
        txtOrderPoint.setBounds(8, 82, 174, 35);
        panel.add(txtOrderPoint);

        txtCustomerPoint = new JTextField();
        txtCustomerPoint.setOpaque(false);
        txtCustomerPoint.setColumns(10);
        txtCustomerPoint.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Điểm tích luỹ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
        txtCustomerPoint.setBounds(189, 82, 161, 35);
        panel.add(txtCustomerPoint);

        panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh sách sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
        panel_1.setBounds(12, 171, 362, 169);
        pnOrder.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_1.add(scrollPane, BorderLayout.CENTER);

        tblOrderItem = new JTable();
        tblOrderItem.setDefaultEditor(Object.class, null);
        tblOrderItem.setFont(new Font("Calibri", Font.PLAIN, 12));
        tblOrderItem.setBackground(Color.WHITE);
        scrollPane.setViewportView(tblOrderItem);

    }

    public void loadInfos(OrderDTO order, CustomerDTO customer, Vector<OrderItemDTO> listOrderItemDTO) {
        orderId = order.getId_order();
        lblOrderId.setText(order.getId_order());
        lblEmployee.setText(order.getEmployee().getFullname());
        lblCustomer.setText(customer.getFullname());
        lblDate.setText(sdf.format(order.getDate()));

        DecimalFormat df = new DecimalFormat("#,##0");
        totalPrice = 0;
        for (OrderItemDTO item : listOrderItemDTO) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        double discountPercent = 0;
        if (order.getVoucher() != null && !order.getVoucher().getCode().equals("Null")) {
            discountPercent = order.getVoucher().getDiscountpercent() / 100.0;
            discountAmount = totalPrice * discountPercent;
            radioSale.setSelected(true);
            txtSalePercent.setText(String.format("%.1f", discountPercent * 100));
        } else {
            radioSale.setSelected(false);
            txtSalePercent.setText("0");
        }

        double finalPrice = totalPrice - discountAmount;
        txtSalePrice.setText(df.format(discountAmount)); 
        txtTotalPrice.setText(df.format(finalPrice));
        txtOrderPoint.setText(String.format("%.1f", finalPrice / 1000));
        txtCustomerPoint.setText(String.format("%.1f", customer.getPoint() + finalPrice / 1000));

        DefaultTableModel dfm = new DefaultTableModel();
        String[] header = {"Tên sản phẩm", "Số lượng", "Giá tiền (đ)"};
        dfm.setColumnIdentifiers(header);
        for (OrderItemDTO item : listOrderItemDTO) {
            ProductDTO product = productBLL.getProductById(item.getProduct().getId_product());
            String[] row = {product.getName(), String.valueOf(item.getQuantity()), df.format(item.getPrice())};
            dfm.addRow(row);
        }
        tblOrderItem.setModel(dfm);
    }

    public void addEvents() {
        btnExportPDF.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (orderId != null) {
                    XuatHoaDon(orderId);
                }
            }
        });
    }

    public void XuatHoaDon(String id_order) {
        try {
            Hashtable<String, Object> map = new Hashtable<>();
            JasperReport report = JasperCompileManager.compileReport("src/GUI/JasperReport/newReport.jrxml");
            map.put("id_order", id_order);
            map.put("OriginalTotal", totalPrice);
            map.put("DiscountAmount", discountAmount);
            JasperPrint p = JasperFillManager.fillReport(report, map, JDBCUtil.getConnection());
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void reloadComponents() {
        this.repaint();
        this.revalidate();
    }

    public void closeDialog() {
        this.dispose();
    }
}
