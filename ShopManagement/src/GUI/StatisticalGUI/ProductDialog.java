package GUI.StatisticalGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import java.awt.event.*;

import javax.swing.border.LineBorder;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BLL.OrderItemBLL;
import BLL.ProductBLL;
import Cores.ReadWriteFile;
import DTO.CustomerDTO;
import DTO.OrderItemDTO;
import DTO.ProductDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;

public class ProductDialog extends JDialog {
	private ReadWriteFile readWriteFile = new ReadWriteFile();
	private JDatePickerImpl datePickerStart, datePickerEnd;
	private ProductBLL productBLL = new ProductBLL();
	private OrderItemBLL orderItemBLL = new OrderItemBLL();
	private String path = String.valueOf(FileSystems.getDefault().getPath(new String()).toAbsolutePath());

	private Vector<ProductDTO> listProduct = productBLL.getProducts();
	private Vector<Vector<String>> dataBarCharForInventoryOption = new Vector<Vector<String>>();
	private Vector<Vector<String>> dataBarChartForSoldOption = new Vector<Vector<String>>();

	private JFreeChart chart;

	private JTable tblProduct;
	private JPanel pnChart;
	private JButton btnSold;
	private JButton btnInventory;
	private JButton btnBestSeller;
	private JTextField txtTotalMain;
	private JLabel lblTotalMain;
	private JButton btnExportChart;
	private JPanel panel;
	private JButton btnExportExcel;

	public ProductDialog() {
		initComponents();
		addEvents();
		loadInventoryTable();
		loadBarChartInventory();
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

		btnInventory = new JButton("Thống kê tồn kho");
		btnInventory.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnInventory.setBackground(new Color(255, 255, 255));
		btnInventory.setForeground(new Color(46, 139, 87));
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInventory.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/statistical/analysis (2).png")));
		btnInventory.setBounds(10, 22, 193, 39);
		panel.add(btnInventory);

		btnSold = new JButton(" Thống kê đã bán");
		btnSold.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/statistical/analysis (2).png")));
		btnSold.setForeground(new Color(46, 139, 87));
		btnSold.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSold.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnSold.setBackground(Color.WHITE);
		btnSold.setBounds(10, 85, 193, 39);
		panel.add(btnSold);

		btnBestSeller = new JButton("Sản phẩm bán chạy");
		btnBestSeller.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/statistical/pie-chart.png")));
		btnBestSeller.setForeground(new Color(46, 139, 87));
		btnBestSeller.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBestSeller.setBorder(new LineBorder(new Color(46, 139, 87), 1, true));
		btnBestSeller.setBackground(Color.WHITE);
		btnBestSeller.setBounds(10, 146, 193, 39);
		panel.add(btnBestSeller);
		
		btnExportChart = new JButton("Xuất biểu đồ");
		btnExportChart.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/statistical/pie-chart (1).png")));
		btnExportChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExportChart.setForeground(new Color(255, 255, 224));
		btnExportChart.setBackground(new Color(0, 128, 128));
		btnExportChart.setBounds(40, 369, 132, 30);
		panel.add(btnExportChart);
		
		btnExportExcel = new JButton("Xuất excel");
		btnExportExcel.setIcon(new ImageIcon(ProductDialog.class.getResource("/images/excel.png")));
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExportExcel.setForeground(new Color(255, 255, 224));
		btnExportExcel.setBackground(new Color(0, 128, 128));
		btnExportExcel.setBounds(40, 327, 132, 30);
		panel.add(btnExportExcel);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(603, 0, 1, 410);
		getContentPane().add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(610, 0, 358, 368);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		tblProduct = new JTable();
                tblProduct.setDefaultEditor(Object.class, null);
		JScrollPane sc = new JScrollPane(tblProduct, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_1.add(sc, BorderLayout.CENTER);

		pnChart = new JPanel();
		pnChart.setBounds(0, 0, 604, 411);
		getContentPane().add(pnChart);
		pnChart.setLayout(new BorderLayout(0, 0));
		
		lblTotalMain = new JLabel("");
		lblTotalMain.setForeground(new Color(0, 100, 0));
		lblTotalMain.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalMain.setBounds(622, 380, 197, 16);
		getContentPane().add(lblTotalMain);
		
		txtTotalMain = new JTextField();
		txtTotalMain.setText("4");
		txtTotalMain.setColumns(10);
		txtTotalMain.setBounds(829, 379, 138, 20);
                txtTotalMain.setEditable(false);
		getContentPane().add(txtTotalMain);
	}

	public void addEvents() {
		btnInventory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadInventoryTable();
				loadBarChartInventory();
			}
		});

		btnSold.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadSoldTable();
				loadBarChartSold();
			}
		});

		btnBestSeller.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadBestSellerTable();
				loadPieChartBestSeller();
			}
		});
		
		btnExportExcel.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Vector<String> header = new Vector<String>();
				header.add("Mã sản phẩm");
				header.add("Tên sản phẩm");
				header.add("Số lượng tồn kho");
				header.add("Số lượng đã bán");
				
				Vector<Vector<String>> listObjectData = new Vector<Vector<String>>();
				for (ProductDTO productDTO : listProduct) {
					Vector<String> data = new Vector<String>();
					data.add(productDTO.getId_product());
					data.add(productDTO.getName());
					data.add(String.valueOf(productDTO.getQuantity()));
					data.add(String.valueOf(getQuantitySoldOfProduct(productDTO.getId_product())));
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

		btnExportChart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int kq = readWriteFile.writeChart(chart);
				if (kq ==1 ) {
					JOptionPane.showMessageDialog(null, "Xuất file biểu đồ thành công!");
				}else {
					JOptionPane.showMessageDialog(null, "Thất bại!");
					return;
				}
			}
		});
		
	}

	public void loadBarChartInventory() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

		for (ProductDTO product : listProduct) {
			dataset.addValue(product.getQuantity(), "Sản phẩm tồn kho", product.getName());
		}


		chart = ChartFactory.createBarChart("Thống kê tồn kho", "Sản phẩm", "Số lượng (cái)",
                                                           dataset, PlotOrientation.VERTICAL, true, true, false); 


														   
		pnChart.removeAll();
		ChartPanel chartPanel = new ChartPanel(chart);
		pnChart.add(chartPanel);
		reloadComponent();
    }
        public void loadPieChartBestSeller() {
            DefaultPieDataset dataset = new DefaultPieDataset();
            // Tính tổng số lượng đã bán để tính tỉ lệ phần trăm
            int totalSold = 0;
            for (ProductDTO product : listProduct) {
                totalSold += getQuantitySoldOfProduct(product.getId_product());
            }
            // Thiết lập giá trị cho dataset
            for (ProductDTO product : listProduct) {
                float value = (float) getQuantitySoldOfProduct(product.getId_product()) * 100 / totalSold;
                dataset.setValue(product.getName(), value);
            }
            // Tạo biểu đồ
            chart = ChartFactory.createPieChart("Thống kê sản phẩm bán chạy", dataset, true, true, false);
            // Tạo generator nhãn với phần trăm
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: ({2})", new DecimalFormat("0"), new DecimalFormat("0%")
            );
            // Áp dụng generator nhãn vào plot
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLabelGenerator(labelGenerator);

            // Cập nhật panel chứa biểu đồ
            pnChart.removeAll();
            ChartPanel chartPanel = new ChartPanel(chart);
            pnChart.add(chartPanel);
            reloadComponent();
        }
	public void loadBarChartSold() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

		for (ProductDTO product : listProduct) {
			dataset.addValue(getQuantitySoldOfProduct(product.getId_product()), "Sản phẩm đã bán", product.getName());
		}

		chart = ChartFactory.createBarChart("Thống kê số lượng sản phẩm đã bán", "Sản phẩm", "Số lượng (cái)",
                                                           dataset, PlotOrientation.VERTICAL, true, true, false); 

		pnChart.removeAll();
		ChartPanel chartPanel = new ChartPanel(chart);
		pnChart.add(chartPanel);
		reloadComponent();
	}


	public void loadInventoryTable() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã SP", "Tên SP", "Số lượng tồn kho" };
		dfm.setColumnIdentifiers(header);
		int total = 0;
		for (ProductDTO productDTO : listProduct) {
			Vector<String> rowData = new Vector<String>();
			rowData.add(productDTO.getId_product());
			rowData.add(productDTO.getName());
			rowData.add(String.valueOf(productDTO.getQuantity()));
			total = total + productDTO.getQuantity();
			dfm.addRow(rowData);
			dataBarCharForInventoryOption.add(rowData);
		}
		tblProduct.setModel(dfm);

		lblTotalMain.setText("Tổng sản phẩm tồn kho");
		txtTotalMain.setText(String.valueOf(total));
	}

	public void loadSoldTable() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã SP", "Tên SP", "Số lượng đã bán" };
		dfm.setColumnIdentifiers(header);
		int total = 0;
		for (ProductDTO productDTO : listProduct) {
			Vector<String> rowData = new Vector<String>();
			rowData.add(productDTO.getId_product());
			rowData.add(productDTO.getName());
			rowData.add(String.valueOf(getQuantitySoldOfProduct(productDTO.getId_product())));
			total = total + getQuantitySoldOfProduct(productDTO.getId_product());
			dfm.addRow(rowData);
			dataBarCharForInventoryOption.add(rowData);
		}
		tblProduct.setModel(dfm);

		lblTotalMain.setText("Tổng sản phẩm đã bán");
		txtTotalMain.setText(String.valueOf(total));
	}

	public void loadBestSellerTable() {
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã SP", "Tên SP", "Số lượng tồn kho","Số lượng đã bán"};
		dfm.setColumnIdentifiers(header);

		for (ProductDTO productDTO : listProduct) {
			Vector<String> rowData = new Vector<String>();
			rowData.add(productDTO.getId_product());
			rowData.add(productDTO.getName());
			rowData.add(String.valueOf(productDTO.getQuantity()));
			rowData.add(String.valueOf(getQuantitySoldOfProduct(productDTO.getId_product())));
			dfm.addRow(rowData);
			dataBarCharForInventoryOption.add(rowData);
		}
		tblProduct.setModel(dfm);
	}


	public int getQuantitySoldOfProduct(String id_product) {
		Vector<OrderItemDTO> listOrderItem = orderItemBLL.getOrderItemByProductId(id_product);
		int quantity = 0;
		for (OrderItemDTO orderItem : listOrderItem) {
			quantity = quantity + orderItem.getQuantity();
		}
		return quantity;
	}


	public void reloadComponent() {
		this.revalidate();
		this.repaint();
	}
}
