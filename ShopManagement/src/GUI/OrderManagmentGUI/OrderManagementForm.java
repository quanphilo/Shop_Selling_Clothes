package GUI.OrderManagmentGUI;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import BLL.CustomerBLL;
import BLL.OrderBLL;
import BLL.OrderItemBLL;
import DTO.CustomerDTO;
import DTO.OrderDTO;
import DTO.OrderItemDTO;

public class OrderManagementForm extends JPanel {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private JDatePickerImpl datePickerStart, datePickerEnd;
	private JTable tblOrder;
	private JTextField txt_EmpId;
	private JTextField txt_Voucher;
	private JTextField txt_OrderId;
	private JTextField txt_NgayLap;
	private JTextField txt_CusId;
	private JTextField txt_Total;
	private JTable tblOrderItem;
	private JTextField txt_CusName;
	private OrderBLL orderBLL = new OrderBLL();
	private OrderItemBLL orderItemBLL = new OrderItemBLL();
	private CustomerBLL customerBLL = new CustomerBLL();
	private JButton btnExportExcel;
	private JButton btnFilter;

	public OrderManagementForm() {
		initComponents();
		addEvents();
		loadTableOrder();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 490);

		JPanel pnHeader = new JPanel();
		pnHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnHeader.setBounds(0, 0, 830, 32);
		add(pnHeader);

		JLabel lblQunLHa = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHa.setForeground(new Color(0, 128, 128));
		lblQunLHa.setFont(new Font("Dialog", Font.BOLD, 15));
		pnHeader.add(lblQunLHa);

		JPanel pnWarehouse = new JPanel();
		pnWarehouse.setLayout(null);
		pnWarehouse.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh sách hoá đơn",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 128)));
		pnWarehouse.setBounds(383, 44, 443, 446);
		add(pnWarehouse);

		JPanel pnWareTable = new JPanel();
		pnWareTable.setBounds(12, 27, 418, 320);
		pnWarehouse.add(pnWareTable);
		pnWareTable.setLayout(new BorderLayout(0, 0));

		tblOrder = new JTable();
                tblOrder.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(tblOrder, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnWareTable.add(scrollPane, BorderLayout.CENTER);

		UtilDateModel modeStart = new UtilDateModel();
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modeStart);

		UtilDateModel modelEnd = new UtilDateModel();
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd);

		JButton btnFilterWarehouse = new JButton("");
		btnFilterWarehouse.setOpaque(false);
		btnFilterWarehouse.setForeground(Color.WHITE);
		btnFilterWarehouse.setBorderPainted(false);
		btnFilterWarehouse.setBorder(null);
		btnFilterWarehouse.setBackground(Color.WHITE);
		btnFilterWarehouse.setBounds(199, 142, 28, 26);
		pnWarehouse.add(btnFilterWarehouse);

		// Filter Date
		JPanel pnFillterDate = new JPanel();
		pnFillterDate.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 0)));
		pnFillterDate.setBounds(0, 357, 445, 89);
		pnWarehouse.add(pnFillterDate);
		pnFillterDate.setLayout(null);

		// Từ ngày
		JPanel pnTuNgay = new JPanel();
		pnTuNgay.setBounds(90, 10, 155, 25);
		pnFillterDate.add(pnTuNgay);
		pnTuNgay.setLayout(new BorderLayout(0, 0));
		datePickerStart = new JDatePickerImpl(datePanelStart);
		pnTuNgay.add(datePickerStart);

		// Đến ngày
		JPanel pnDenNgay = new JPanel();
		pnDenNgay.setBounds(90, 45, 155, 25);
		pnFillterDate.add(pnDenNgay);
		pnDenNgay.setLayout(new BorderLayout(0, 0));
		datePickerEnd = new JDatePickerImpl(datePanelEnd);
		pnDenNgay.add(datePickerEnd);

		JLabel lblNewLabel = new JLabel("Từ ngày");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(12, 10, 55, 25);
		pnFillterDate.add(lblNewLabel);

		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setForeground(new Color(0, 128, 0));
		lblnNgy.setFont(new Font("Dialog", Font.BOLD, 13));
		lblnNgy.setBounds(11, 45, 73, 25);
		pnFillterDate.add(lblnNgy);

		btnFilter = new JButton("");
		btnFilter.setBackground(new Color(0, 128, 128));
		btnFilter.setIcon(new ImageIcon(OrderManagementForm.class.getResource("/images/search-icon.png")));
		btnFilter.setBounds(257, 10, 37, 59);
		pnFillterDate.add(btnFilter);

		btnExportExcel = new JButton("Xuất excel");
		btnExportExcel.setIcon(new ImageIcon(OrderManagementForm.class.getResource("/images/excel.png")));
		btnExportExcel.setForeground(new Color(255, 255, 255));
		btnExportExcel.setBackground(new Color(0, 128, 128));
		btnExportExcel.setBounds(306, 27, 127, 34);
		pnFillterDate.add(btnExportExcel);

		JPanel pnDetail = new JPanel();
		pnDetail.setBorder(new TitledBorder(null, "Chi tiết hoá đơn", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 128, 0)));
		pnDetail.setBounds(10, 44, 361, 446);
		add(pnDetail);
		pnDetail.setLayout(null);

		txt_EmpId = new JTextField();
		txt_EmpId.setOpaque(false);
		txt_EmpId.setColumns(10);
		txt_EmpId.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mã nhân viên",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_EmpId.setBounds(12, 71, 184, 35);
                txt_EmpId.setEditable(false);
		pnDetail.add(txt_EmpId);

		txt_Voucher = new JTextField();
		txt_Voucher.setOpaque(false);
		txt_Voucher.setColumns(10);
		txt_Voucher.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Voucher",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_Voucher.setBounds(211, 71, 139, 35);
                txt_Voucher.setEditable(false);
		pnDetail.add(txt_Voucher);

		txt_OrderId = new JTextField();
		txt_OrderId.setOpaque(false);
		txt_OrderId.setColumns(10);
		txt_OrderId
				.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mã hoá đơn",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_OrderId.setBounds(12, 26, 184, 35);
                txt_OrderId.setEditable(false);
		pnDetail.add(txt_OrderId);

		txt_NgayLap = new JTextField();
		txt_NgayLap.setOpaque(false);
		txt_NgayLap.setColumns(10);
		txt_NgayLap.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ngày lập",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_NgayLap.setBounds(211, 26, 139, 35);
                txt_NgayLap.setEditable(false);
		pnDetail.add(txt_NgayLap);

		txt_CusId = new JTextField();
		txt_CusId.setOpaque(false);
		txt_CusId.setColumns(10);
		txt_CusId.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mã khách hàng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_CusId.setBounds(12, 118, 184, 35);
                txt_CusId.setEditable(false);
		pnDetail.add(txt_CusId);

		txt_Total = new JTextField();
		txt_Total.setOpaque(false);
		txt_Total.setColumns(10);
		txt_Total.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tổng tiền (đ)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_Total.setBounds(211, 118, 139, 35);
                txt_Total.setEditable(false);
		pnDetail.add(txt_Total);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh sách sản phẩm", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setBounds(12, 222, 338, 212);
		pnDetail.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tblOrderItem = new JTable();
                tblOrderItem.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane_1 = new JScrollPane(tblOrderItem, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane_1);

		txt_CusName = new JTextField();
		txt_CusName.setOpaque(false);
		txt_CusName.setColumns(10);
		txt_CusName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Tên khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		txt_CusName.setBounds(12, 161, 184, 35);
                txt_CusName.setEditable(false);
		pnDetail.add(txt_CusName);

		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBackground(new Color(0, 128, 0));
		separator.setBounds(380, 30, 2, 460);
		add(separator);

	}

	public void addEvents() {
		btnFilter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (datePickerStart.getModel().getValue() == null || datePickerEnd.getModel().getValue() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ điều kiện lọc!");
					return;
				}
				Date startdate = (Date) datePickerStart.getModel().getValue();
				Date enddate = (Date) datePickerEnd.getModel().getValue();
				Vector<OrderDTO> listOrderFilter = orderBLL.getOrdersByFilterDate(startdate, enddate);
				loadTableOrder(listOrderFilter);
			}
		});


		tblOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblOrder.getSelectedRow();
				OrderDTO orderDTO = orderBLL.getOrderById(String.valueOf(tblOrder.getValueAt(row, 0)));
				CustomerDTO customerDTO = customerBLL.getCustomerById(orderDTO.getCustomer().getId());
				txt_OrderId.setText(orderDTO.getId_order());
				txt_EmpId.setText(orderDTO.getEmployee().getId());
				txt_CusId.setText(orderDTO.getCustomer().getId());
				txt_NgayLap.setText(String.valueOf(orderDTO.getDate()));
				txt_Voucher.setText(String.valueOf(orderDTO.getVoucher().getId_voucher()));
				txt_Total.setText(String.valueOf(orderDTO.getTotalprice()));
				txt_CusName.setText(customerDTO.getFullname());
                           
				loadTableOrderItem(orderDTO);
			}
		});

		btnExportExcel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Vector<String> header = new Vector<String>();
				header.add("Mã hóa đơn");
				header.add("Mã nhân viên");
				header.add("Mã khách hàng");
				header.add("Ngày lập");
				header.add("Voucher");
				header.add("Tổng tiền(đ)");

				Vector<Vector<String>> listObjectData = new Vector<Vector<String>>();
				for (OrderDTO orderDTO : orderBLL.getOrders()) {
					Vector<String> data = new Vector<String>();
					data.add(orderDTO.getId_order());
					data.add(orderDTO.getEmployee().getId());
					data.add(orderDTO.getCustomer().getId());
					data.add(sdf.format(orderDTO.getDate()));
					data.add(orderDTO.getVoucher().getId_voucher());
					data.add(String.valueOf(orderDTO.getTotalprice()));
					listObjectData.add(data);
				}
				File file = orderBLL.writeExcel(listObjectData, header, 0);
				if (file != null) {
					for (OrderDTO orderDTO : orderBLL.getOrders()) {
						Vector<OrderItemDTO> listOrderItem = orderItemBLL.getOrderItemByOrderId(orderDTO.getId_order());
						exportDetailOrder(listOrderItem, file);
					}
					JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
					return;
				} else {
					JOptionPane.showMessageDialog(null, "Thất bại!");
					return;
				}
			}
		});
	}

	// Export detail order
	public void exportDetailOrder(Vector<OrderItemDTO> listOrderItem, File file) {
		Vector<String> header = new Vector<String>();
		header.add("Mã hóa đơn");
		header.add("Mã sản phẩm");
		header.add("Số lượng");
		header.add("Giá tiền (đ)");
		
		Vector<Vector<String>> listObjectData = new Vector<Vector<String>>();
		for (OrderItemDTO orderItemDTO : listOrderItem) {
			Vector<String> data = new Vector<String>();
			data.add(orderItemDTO.getOrder().getId_order());
			data.add(orderItemDTO.getProduct().getId_product());
			data.add(String.valueOf(orderItemDTO.getQuantity()));
			data.add(String.valueOf(orderItemDTO.getPrice()));
			listObjectData.add(data);
		}

		if (orderBLL.writeExcelForDetail(listObjectData, header, file) == 0) {
			System.out.println("Lỗi");
		}
	}
	
// Load Table order
	public void loadTableOrder() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã HĐ", "Mã KH", "Tổng tiền" };
		dfm.setColumnIdentifiers(header);

		Vector<OrderDTO> listOrder = orderBLL.getOrders();
		for (OrderDTO orderDTO : listOrder) {
			String[] row = { orderDTO.getId_order(), orderDTO.getCustomer().getId(),
					String.valueOf(orderDTO.getTotalprice()) };
			dfm.addRow(row);
		}
		tblOrder.setModel(dfm);
	}

	public void loadTableOrder(Vector<OrderDTO> listOrderFilter) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã HĐ", "Mã KH", "Tổng tiền" };
		dfm.setColumnIdentifiers(header);
		for (OrderDTO orderDTO : listOrderFilter) {
			String[] row = { orderDTO.getId_order(), orderDTO.getCustomer().getId(),
					String.valueOf(orderDTO.getTotalprice()) };
			dfm.addRow(row);
		}
		tblOrder.setModel(dfm);
	}

	
	public void loadTableOrderItem(OrderDTO orderDTO) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Giá tiền (đ)" };
		dfm.setColumnIdentifiers(header);

		
		Vector<OrderItemDTO> listOrderItem = orderItemBLL.getOrderItemByOrderId(orderDTO.getId_order());
		for (OrderItemDTO orderitemDTO : listOrderItem) {
			String[] row = { orderitemDTO.getOrder().getId_order(), orderitemDTO.getProduct().getId_product(),
					String.valueOf(orderitemDTO.getQuantity()), String.valueOf(orderitemDTO.getPrice()) };
			dfm.addRow(row);
		}
		tblOrderItem.setModel(dfm);
	}
}
