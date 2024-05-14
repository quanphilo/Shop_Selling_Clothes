package GUI.StatisticalGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import BLL.OrderBLL;
import BLL.OrderItemBLL;
import BLL.ProductBLL;
import Cores.ReadWriteFile;
import DTO.OrderDTO;
import DTO.OrderItemDTO;
import DTO.ProductDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class OrderDialog extends JDialog {
	private ReadWriteFile readWriteFile = new ReadWriteFile();
	private Date date = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JDatePickerImpl datePickerStart, datePickerEnd;
	private OrderBLL orderBLL = new OrderBLL();
	private Vector<OrderDTO> listOrder = orderBLL.getOrders();
	private JFreeChart chart;
	private JTable tblOrder;
	private JPanel pnChart;
	private JButton btnStatistic;
	private JButton btnFilter;
	private JPanel pnFilterDate;
	private JPanel pnEnd;
	private JPanel pnStart;
	private JTextField txtTotalMain;
	private JLabel lblTotalMain;
	private JButton btnExportChart;
	private JButton btnExportExcel;
	private JPanel panel;

	public OrderDialog() {
		initComponents();
		addEvents();
		loadOrderTable(listOrder);
		loadLineChart();
		loadTotalMain(listOrder);
	}

	public void initComponents() {
		setSize(1200, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(971, 0, 213, 411);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnStatistic = new JButton("Thống kê doanh thu");
		btnStatistic.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnStatistic.setBackground(new Color(255, 255, 255));
		btnStatistic.setForeground(new Color(46, 139, 87));
		btnStatistic.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStatistic.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/statistical/analysis (2).png")));
		btnStatistic.setBounds(10, 22, 193, 39);
		panel.add(btnStatistic);

		btnFilter = new JButton("Lọc");
		btnFilter.setIcon(new ImageIcon(OrderDialog.class.getResource("/images/search-icon.png")));
		btnFilter.setForeground(new Color(46, 139, 87));
		btnFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFilter.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnFilter.setBackground(Color.WHITE);
		btnFilter.setBounds(42, 258, 140, 39);
		panel.add(btnFilter);

		pnFilterDate = new JPanel();
		pnFilterDate.setBounds(10, 88, 193, 159);
		panel.add(pnFilterDate);
		pnFilterDate.setLayout(null);

		JLabel lbltu = new JLabel("Từ ngày");
		lbltu.setBounds(10, 11, 46, 14);
		pnFilterDate.add(lbltu);

		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setBounds(10, 87, 63, 14);
		pnFilterDate.add(lblnNgy);

		pnStart = new JPanel();
		pnStart.setBounds(10, 36, 163, 27);
		pnFilterDate.add(pnStart);

		pnEnd = new JPanel();
		pnEnd.setBounds(10, 112, 163, 27);
		pnFilterDate.add(pnEnd);

		btnExportChart = new JButton("Xuất biểu đồ");
		btnExportChart.setIcon(new ImageIcon(OrderDialog.class.getResource("/images/statistical/pie-chart (1).png")));
		btnExportChart.setForeground(new Color(255, 255, 224));
		btnExportChart.setBackground(new Color(0, 128, 128));
		btnExportChart.setBounds(35, 370, 142, 30);
		panel.add(btnExportChart);

		btnExportExcel = new JButton("Xuất excel");
		btnExportExcel.setIcon(new ImageIcon(OrderDialog.class.getResource("/images/excel.png")));
		btnExportExcel.setForeground(new Color(255, 255, 224));
		btnExportExcel.setBackground(new Color(0, 128, 128));
		btnExportExcel.setBounds(36, 327, 140, 30);
		panel.add(btnExportExcel);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(603, 0, 1, 410);
		getContentPane().add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(610, 0, 358, 355);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tblOrder = new JTable();
                tblOrder.setDefaultEditor(Object.class, null);
		JScrollPane sc = new JScrollPane(tblOrder, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(sc, BorderLayout.CENTER);

		pnChart = new JPanel();
		pnChart.setBounds(0, 0, 604, 411);
		getContentPane().add(pnChart);
		pnChart.setLayout(new BorderLayout(0, 0));

		lblTotalMain = new JLabel("Tổng doanh thu (đ)");
		lblTotalMain.setForeground(new Color(0, 100, 0));
		lblTotalMain.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalMain.setBounds(676, 371, 137, 16);
		getContentPane().add(lblTotalMain);

		txtTotalMain = new JTextField();
		txtTotalMain.setBounds(823, 370, 138, 20);
                txtTotalMain.setEditable(false);
		getContentPane().add(txtTotalMain);
		txtTotalMain.setColumns(10);

		addFilterDateComponents();
	}

	public void addEvents() {
		btnFilter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (datePickerStart.getModel().getValue() == null || datePickerEnd.getModel().getValue() == null) {
					JOptionPane.showMessageDialog(null, "Nhập đầy đủ điều kiện lọc!");
					return;
				}
				Date startdate = (Date) datePickerStart.getModel().getValue();
				Date enddate = (Date) datePickerEnd.getModel().getValue();
				Vector<OrderDTO> listOrderFilter = orderBLL.getOrdersByFilterDate(startdate, enddate);
				loadOrderTable(listOrderFilter);
				loadTotalMain(listOrderFilter);
				loadLineChart(startdate, enddate);
			}
		});

		btnStatistic.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadOrderTable(listOrder);
				loadLineChart();
				loadTotalMain(listOrder);
			}
		});
		btnExportExcel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Vector<String> header = new Vector<String>();
				header.add("Mã hóa đơn");
				header.add("Mã khách hàng");
				header.add("Ngày lập");
				header.add("Tổng tiền(đ)");

				Vector<Vector<String>> listObjectData = new Vector<Vector<String>>();
				for (OrderDTO orderDTO : orderBLL.getOrders()) {
					Vector<String> data = new Vector<String>();
					data.add(orderDTO.getId_order());
					data.add(orderDTO.getCustomer().getId());
					data.add(sdf.format(orderDTO.getDate()));
					data.add(String.valueOf(orderDTO.getTotalprice()));
					listObjectData.add(data);
				}

				if (orderBLL.writeExcel(listObjectData, header) == 1) {
					JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
					return;
				} else {
					JOptionPane.showMessageDialog(null, "Thất bại!");
					return;
				}
			}
		});
		btnExportChart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int kq = readWriteFile.writeChart(chart);
				if (kq == 1) {
					JOptionPane.showMessageDialog(null, "Xuất file biểu đồ thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Thất bại!");
					return;
				}
			}
		});
	}

	public void loadOrderTable(Vector<OrderDTO> listOrder) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã HĐ", "Mã KH", "Ngày lập", "Tổng tiền (đ)" };
		dfm.setColumnIdentifiers(header);

		for (OrderDTO order : listOrder) {
			String[] row = {
					order.getId_order(),
					order.getCustomer().getId(),
					sdf.format(order.getDate()),
					String.valueOf(order.getTotalprice())
			};
			dfm.addRow(row);
		}
		tblOrder.setModel(dfm);
	}

	public void loadLineChart() {
		XYDataset dataset = createDataset();

		chart = ChartFactory.createXYLineChart(
				"Thống kê doanh thu trong năm " + (date.getYear() + 1900),
				"Tháng",
				"Doanh thu (đ)",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);

		XYPlot xyPlot = (XYPlot) chart.getPlot();
		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		XYItemRenderer renderer = xyPlot.getRenderer();
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		// domain.setRange(0.00, 1.00);
		domain.setTickUnit(new NumberTickUnit(1));
		// domain.setVerticalTickLabels(true);
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
		// range.setRange(0.0, 1.0);
		// range.setTickUnit(new NumberTickUnit(1));

		pnChart.removeAll();
		ChartPanel chartPanel = new ChartPanel(chart);
		pnChart.add(chartPanel);
		reloadComponent();
	}

	public void loadLineChart(Date startdate, Date enddate) {
		XYDataset dataset = createDataset(startdate, enddate);

		chart = ChartFactory.createXYLineChart(
				"Thống kê doanh thu từ " + (sdf.format(startdate)) + " đến " + (sdf.format(enddate)),
				"Tháng",
				"Doanh thu (đ)",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);

		XYPlot xyPlot = (XYPlot) chart.getPlot();
		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		XYItemRenderer renderer = xyPlot.getRenderer();
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		// domain.setRange(0.00, 1.00);
		domain.setTickUnit(new NumberTickUnit(1));
		// domain.setVerticalTickLabels(true);
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
		// range.setRange(0.0, 1.0);
		// range.setTickUnit(new NumberTickUnit(1));

		pnChart.removeAll();
		ChartPanel chartPanel = new ChartPanel(chart);
		pnChart.add(chartPanel);
		reloadComponent();
	}

	public XYDataset createDataset() {

		var series = new XYSeries(date.getYear() + 1900);
                
		for (int i = 1; i <= 12; i++) {
			series.add(i, getTotalPriceOrderOfMonth(i));
		}

		var dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		return dataset;
	}

	public XYDataset createDataset(Date startdate, Date enddate) {

		var series = new XYSeries(date.getYear() + 1900);

		for (int i = startdate.getMonth(); i <= enddate.getMonth(); i++) {
			series.add(i, getTotalPriceOrderOfMonth(i));
		}

		var dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		return dataset;
	}

	public float getTotalPriceOrderOfMonth(int MONTH) {
		float totalprice = 0;
		for (OrderDTO order : orderBLL.getOrdersOfMonth(MONTH)) {
			totalprice = totalprice + order.getTotalprice();
		}
		return totalprice;
	}

	public void addFilterDateComponents() {
		UtilDateModel modeStart = new UtilDateModel();
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modeStart);

		UtilDateModel modelEnd = new UtilDateModel();
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd);

		datePickerStart = new JDatePickerImpl(datePanelStart);
		datePickerEnd = new JDatePickerImpl(datePanelEnd);
		pnStart.setLayout(new BorderLayout(0, 0));

		pnStart.add(datePickerStart);
		pnEnd.setLayout(new BorderLayout(0, 0));
		pnEnd.add(datePickerEnd);
	}
        public void loadTotalMain(Vector<OrderDTO> listOrder) {
            float total = 0;
            for (OrderDTO order : listOrder) {
                total += order.getTotalprice();
            }

            DecimalFormat formatter = new DecimalFormat("#,###");
            txtTotalMain.setText(formatter.format(total));
        }

            public void reloadComponent() {
                    this.revalidate();
                    this.repaint();
            }
}
