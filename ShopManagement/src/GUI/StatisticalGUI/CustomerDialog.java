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
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import BLL.CustomerBLL;
import BLL.OrderBLL;
import BLL.OrderItemBLL;
import BLL.ProductBLL;
import Cores.ReadWriteFile;
import DTO.CustomerDTO;
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


public class CustomerDialog extends JDialog {
	private ReadWriteFile readWriteFile = new ReadWriteFile();
	private Date date = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private CustomerBLL customerBLL = new CustomerBLL();
	private Vector<CustomerDTO> listCustomer = customerBLL.getCustomers();
	private JFreeChart chart;
	private JTable tblCustomer;
	private JPanel pnChart;
	private JButton btnStatistic;
	private JTextField txtTotalMain;
	private JLabel lblTotalMain;
	private JButton btnPoint;
	private JPanel panel;
	private JButton btnExportExcel;
	private JButton btnExportChart;

	public CustomerDialog() {
		initComponents();
		addEvents();
		loadCustomerTable(listCustomer);
		loadLineChart();
		loadTotalMain(listCustomer);
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

		btnStatistic = new JButton("Lưu lượng khách hàng");
		btnStatistic.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnStatistic.setBackground(new Color(255, 255, 255));
		btnStatistic.setForeground(new Color(46, 139, 87));
		btnStatistic.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStatistic.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/statistical/analysis (2).png")));
		btnStatistic.setBounds(10, 22, 193, 39);
		panel.add(btnStatistic);

		btnPoint = new JButton("Bậc điểm tích lũy");
		btnPoint.setIcon(new ImageIcon(CustomerDialog.class.getResource("/images/statistical/analysis (2).png")));
		btnPoint.setForeground(new Color(46, 139, 87));
		btnPoint.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPoint.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnPoint.setBackground(Color.WHITE);
		btnPoint.setBounds(10, 91, 193, 39);
		panel.add(btnPoint);

		btnExportExcel = new JButton("Xuất excel");
		btnExportExcel.setIcon(new ImageIcon(CustomerDialog.class.getResource("/images/excel.png")));
		btnExportExcel.setForeground(new Color(255, 255, 224));
		btnExportExcel.setBackground(new Color(0, 128, 128));
		btnExportExcel.setBounds(40, 327, 132, 30);
		panel.add(btnExportExcel);

		btnExportChart = new JButton("Xuất biểu đồ");
		btnExportChart.setIcon(new ImageIcon(CustomerDialog.class.getResource("/images/statistical/pie-chart (1).png")));
		btnExportChart.setForeground(new Color(255, 255, 224));
		btnExportChart.setBackground(new Color(0, 128, 128));
		btnExportChart.setBounds(40, 369, 132, 30);
		panel.add(btnExportChart);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(603, 0, 1, 410);
		getContentPane().add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(610, 0, 358, 355);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tblCustomer = new JTable();
                tblCustomer.setDefaultEditor(Object.class, null);
		JScrollPane sc = new JScrollPane(tblCustomer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(sc, BorderLayout.CENTER);

		pnChart = new JPanel();
		pnChart.setBounds(0, 0, 604, 411);
		getContentPane().add(pnChart);
		pnChart.setLayout(new BorderLayout(0, 0));

		lblTotalMain = new JLabel("Tổng số khách hàng");
		lblTotalMain.setForeground(new Color(0, 100, 0));
		lblTotalMain.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalMain.setBounds(676, 371, 137, 16);
		getContentPane().add(lblTotalMain);

		txtTotalMain = new JTextField();
		txtTotalMain.setBounds(823, 370, 138, 20);
                txtTotalMain.setEditable(false);
		getContentPane().add(txtTotalMain);
		txtTotalMain.setColumns(10);

	}

	public void addEvents() {
		btnStatistic.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadCustomerTable(listCustomer);
				loadLineChart();
				loadTotalMain(listCustomer);
			}
		});

		btnPoint.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadCustomerTable(listCustomer);
				loadBarChart();
				loadTotalMain(listCustomer);
			}
		});

		btnExportExcel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Vector<String> header = new Vector<String>();
				header.add("Mã khách hàng");
				header.add("Tên khách hàng");
				header.add("Ngày lập");
				header.add("Điểm");

				Vector<Vector<String>> listObjectData = new Vector<Vector<String>>();
				for (CustomerDTO customer : listCustomer) {
					Vector<String> data = new Vector<String>();
					data.add(customer.getId());
					data.add(customer.getFullname());
					data.add(sdf.format(customer.getCreatedate()));
					data.add(String.valueOf(customer.getPoint()));
					listObjectData.add(data);
				}

				if (customerBLL.writeExcel(listObjectData, header) == 1) {
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

	public void loadCustomerTable(Vector<CustomerDTO> listCustomer) {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã KH", "Tên KH", "Ngày lập", "Điểm" };
		dfm.setColumnIdentifiers(header);

		for (CustomerDTO customer : listCustomer) {
			String[] row = {
					customer.getId(),
					customer.getFullname(),
					sdf.format(customer.getCreatedate()),
					String.valueOf(customer.getPoint())
			};
			dfm.addRow(row);
		}
		tblCustomer.setModel(dfm);
	}

	public void loadBarChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		int qCus0to500 = 0;
		int qCus500to1500 = 0;
		int qCus1500to3000 = 0;
		int qCus3000to4500 = 0;
		int qCus4500toMore = 0;

		for (CustomerDTO customer : listCustomer) {
			if (customer.getPoint() < 500)
				qCus0to500++;
			else if (customer.getPoint() >= 500 && customer.getPoint() < 1500)
				qCus500to1500++;
			else if (customer.getPoint() >= 1500 && customer.getPoint() < 3000)
				qCus1500to3000++;
			else if (customer.getPoint() >= 3000 && customer.getPoint() < 4500)
				qCus3000to4500++;
			else
				qCus4500toMore++;
		}
		dataset.addValue(qCus0to500, "Số lượng", "Chưa có danh hiệu");
		dataset.addValue(qCus500to1500, "Số lượng", "Bạc");
		dataset.addValue(qCus1500to3000, "Số lượng", "Vàng");
		dataset.addValue(qCus3000to4500, "Số lượng", "Bạch kim");
		dataset.addValue(qCus4500toMore, "Số lượng", "Kim cương");

		chart = ChartFactory.createBarChart("Thống kê điểm tích lũy", "Danh hiệu", "Số lượng",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		pnChart.removeAll();
		ChartPanel chartPanel = new ChartPanel(chart);
		pnChart.add(chartPanel);
		reloadComponent();
	}

	public void loadLineChart() {
		XYDataset dataset = createDataset();

		chart = ChartFactory.createXYLineChart(
				"Thống kê lượng khách hàng năm " + (date.getYear() + 1900),
				"Tháng",
				"Số lượng (người)",
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
		range.setTickUnit(new NumberTickUnit(1));

		pnChart.removeAll();
		ChartPanel chartPanel = new ChartPanel(chart);
		pnChart.add(chartPanel, BorderLayout.CENTER);
		reloadComponent();
	}

	public XYDataset createDataset() {
		var series = new XYSeries(date.getYear() + 1900);
		for (int i = 1; i <= 12; i++) {
			series.add(i, getQuantityCustomerOfMonth(i));
		}

		var dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		return dataset;
	}

	public float getQuantityCustomerOfMonth(int MONTH) {
		int quantity = customerBLL.getCustomerOfMonth(MONTH).size();
		return quantity;
	}

	public void loadTotalMain(Vector<CustomerDTO> listCustomer) {
		int total = listCustomer.size();
		txtTotalMain.setText(String.valueOf(total));
	}

	public void reloadComponent() {
		this.revalidate();
		this.repaint();
	}
}
