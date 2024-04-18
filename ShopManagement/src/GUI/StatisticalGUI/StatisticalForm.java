package GUI.StatisticalGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatisticalForm extends JPanel {
	private JPanel pnProduct;
	private JPanel pnOrder;
	private JPanel pnCustomer;
	
	
	public StatisticalForm() {
		initComponents();
		addEvents();
	}
	
	
	public void initComponents() {
		setBounds(0, 0, 830, 490);
		setLayout(null);
		
		pnProduct = new JPanel();
		pnProduct.setBackground(new Color(255, 255, 255));
		pnProduct.setBounds(82, 45, 300, 146);
		add(pnProduct);
		pnProduct.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(StatisticalForm.class.getResource("/images/statistical/clothes-hanger (1).png")));
		lblNewLabel.setBounds(101, 11, 98, 87);
		pnProduct.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("THỐNG KÊ SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(69, 102, 161, 39);
		pnProduct.add(lblNewLabel_1);
		
		pnOrder = new JPanel();
		pnOrder.setLayout(null);
		pnOrder.setBackground(Color.WHITE);
		pnOrder.setBounds(465, 45, 300, 146);
		add(pnOrder);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(StatisticalForm.class.getResource("/images/statistical/profits (1).png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(101, 11, 98, 87);
		pnOrder.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(53, 102, 193, 39);
		pnOrder.add(lblNewLabel_1_1);
		
		pnCustomer = new JPanel();
		pnCustomer.setLayout(null);
		pnCustomer.setBackground(Color.WHITE);
		pnCustomer.setBounds(82, 280, 300, 146);
		add(pnCustomer);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(StatisticalForm.class.getResource("/images/statistical/rating.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(101, 11, 98, 87);
		pnCustomer.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("THỐNG KÊ KHÁCH HÀNG");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 100, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(56, 102, 188, 39);
		pnCustomer.add(lblNewLabel_1_2);
	}
	
	public void addEvents() {
		pnProduct.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				ProductDialog productDiaolog = new ProductDialog();
				productDiaolog.setVisible(true);
			}
		});

		pnOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				OrderDialog orderDiaolog = new OrderDialog();
				orderDiaolog.setVisible(true);
			}
		});


		pnCustomer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				CustomerDialog customerDialog = new CustomerDialog();
				customerDialog.setVisible(true);
			}
		});
	}
}
