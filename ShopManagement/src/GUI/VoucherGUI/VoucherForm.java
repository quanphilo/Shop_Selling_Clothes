package GUI.VoucherGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;

import BLL.VoucherBLL;
import DTO.VoucherDTO;
import GUI.CategoryGUI.CategoryForm;

public class VoucherForm extends JPanel {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel pnOrder;
	private JLabel lblIdVoucher;
	private JButton btnAddVoucher;
	private JButton btnUpdateVoucher;
	private JButton btnDeleteVoucher;
	private JTextField txtIdVoucher;
	private JTextField txtCode;
	private JLabel lblCode;
	private JPanel pnDetails;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JTextField txtDiscountPercent;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JTextField txtEndDate;
	private JTextField txtStartDate;
	private JLabel lblNewLabel;
	private JTable tblVoucher;

	private VoucherBLL voucherBLL = new VoucherBLL();
	private JButton btnConfirm = new JButton();
	private Date date = new Date();
	private	Vector<VoucherDTO> listVoucher = voucherBLL.getVouchers();

	public VoucherForm() {
		initComponents();
		addEvents();
		loadTable();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 463);

		pnOrder = new JPanel();
		pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
		pnOrder.setBounds(0, 40, 832, 423);
		add(pnOrder);
		pnOrder.setLayout(null);

		pnDetails = new JPanel();
		pnDetails.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnDetails.setBounds(0, 347, 832, 76);
		pnOrder.add(pnDetails);
		pnDetails.setLayout(null);

		btnAddVoucher = new JButton("Thêm Voucher");
		btnAddVoucher.setIcon(new ImageIcon(VoucherForm.class.getResource("/images/homeicon/gift-voucher.png")));
		btnAddVoucher.setForeground(new Color(255, 255, 224));
		btnAddVoucher.setBackground(new Color(0, 128, 128));
		btnAddVoucher.setBounds(94, 20, 153, 35);
		pnDetails.add(btnAddVoucher);

		btnUpdateVoucher = new JButton("Sửa Voucher");
		btnUpdateVoucher.setIcon(new ImageIcon(VoucherForm.class.getResource("/images/edit-icon.png")));

		btnUpdateVoucher.setForeground(new Color(255, 255, 224));
		btnUpdateVoucher.setBackground(new Color(0, 128, 128));
		btnUpdateVoucher.setBounds(302, 20, 165, 35);
		pnDetails.add(btnUpdateVoucher);

		btnDeleteVoucher = new JButton("Xóa Voucher");
		btnDeleteVoucher.setIcon(new ImageIcon(VoucherForm.class.getResource("/images/remove.png")));
		btnDeleteVoucher.setForeground(new Color(255, 255, 224));
		btnDeleteVoucher.setBackground(new Color(0, 128, 128));
		btnDeleteVoucher.setBounds(520, 20, 153, 35);
		pnDetails.add(btnDeleteVoucher);
		
		JPanel pnAction = new JPanel();
		pnAction.setBounds(0, 0, 832, 346);
		pnOrder.add(pnAction);
		pnAction.setLayout(null);

		lblIdVoucher = new JLabel("ID Voucher");
		lblIdVoucher.setForeground(new Color(0, 102, 51));
		lblIdVoucher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdVoucher.setBounds(58, 12, 91, 25);
		pnAction.add(lblIdVoucher);

		txtIdVoucher = new JTextField();
		txtIdVoucher.setEditable(false);
		txtIdVoucher.setColumns(10);
		txtIdVoucher.setBounds(185, 12, 149, 25);
		pnAction.add(txtIdVoucher);

		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setColumns(10);
		txtCode.setBounds(185, 49, 149, 25);
		pnAction.add(txtCode);

		lblCode = new JLabel("Mã Code");
		lblCode.setForeground(new Color(0, 102, 51));
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCode.setBounds(58, 49, 91, 25);
		pnAction.add(lblCode);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh s\u00E1ch Voucher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(58, 135, 651, 199);
		pnAction.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tblVoucher = new JTable();
		tblVoucher.setDefaultEditor(Object.class, null);
		scrollPane = new JScrollPane(tblVoucher, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane);
			
		JLabel lblDiscountPercent = new JLabel("(%) chiết khấu");
		lblDiscountPercent.setForeground(new Color(0, 102, 51));
		lblDiscountPercent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscountPercent.setBounds(58, 89, 120, 25);
		pnAction.add(lblDiscountPercent);
		
		txtDiscountPercent = new JTextField();
		txtDiscountPercent.setEditable(false);
		txtDiscountPercent.setColumns(10);
		txtDiscountPercent.setBounds(185, 89, 147, 25);
		pnAction.add(txtDiscountPercent);
		
		lblStartDate = new JLabel("Ngày bắt đầu");
		lblStartDate.setForeground(new Color(0, 102, 51));
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartDate.setBounds(389, 47, 91, 27);
		pnAction.add(lblStartDate);
		
		lblEndDate = new JLabel("Ngày kết thúc");
		lblEndDate.setForeground(new Color(0, 102, 51));
		lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndDate.setBounds(389, 83, 102, 27);
		pnAction.add(lblEndDate);
		
		txtEndDate = new JTextField();
		txtEndDate.setEditable(false);
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(515, 86, 186, 27);
		pnAction.add(txtEndDate);
		
		txtStartDate = new JTextField();
		txtStartDate.setEditable(false);
		txtStartDate.setColumns(10);
		txtStartDate.setBounds(515, 50, 188, 27);
		pnAction.add(txtStartDate);

		
		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 128, 128)));
		panel_2.setBounds(0, 0, 832, 40);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("QUẢN LÝ KHUYẾN MÃI (VOUCHER)");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(300, 0, 300, 30);
		panel_2.add(lblNewLabel);
		

	}
	// Load Table
	public void loadTable() {
		listVoucher = voucherBLL.getVouchers();
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = {"ID Voucher", "Mã Code", "(%) chiết khấu", "Ngày bắt đầu", "Ngày kết thúc"};
		dfm.setColumnIdentifiers(header);
		
		for(VoucherDTO voucherDTO : listVoucher) {
			String[] row = {
					voucherDTO.getId_voucher(), 
					voucherDTO.getCode(), 
					String.valueOf(voucherDTO.getDiscountpercent()), 
					sdf.format(voucherDTO.getStartdate()), 
					sdf.format(voucherDTO.getEnddate())
			};
			dfm.addRow(row);
		}
		tblVoucher.setModel(dfm);
	}
	
	public void addEvents() {
		tblVoucher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblVoucher.getSelectedRow();
								
				VoucherDTO voucherDTO = voucherBLL.getVoucherById(String.valueOf(tblVoucher.getValueAt(row, 0)));
				txtIdVoucher.setText(voucherDTO.getId_voucher());
				txtCode.setText(voucherDTO.getCode());
				txtDiscountPercent.setText(String.valueOf(voucherDTO.getDiscountpercent()));
				txtStartDate.setText(String.valueOf(voucherDTO.getStartdate()));
				txtEndDate.setText(String.valueOf(voucherDTO.getEnddate()));
			}
		});
		
		btnAddVoucher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				date = new Date();
				txtCode.setEditable(true);
				txtDiscountPercent.setEditable(true);
				txtStartDate.setEditable(true);
				txtEndDate.setEditable(true);
				
				txtIdVoucher.setText("VC" + date.getTime());
				txtCode.setText("");
				txtDiscountPercent.setText("");
				txtStartDate.setText("");
				txtEndDate.setText("");
				
				disableButtoninVoucher();
				
				btnConfirm = new JButton("Xác nhận");
				btnConfirm.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
				btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnConfirm.setForeground(new Color(255, 255, 224));
				btnConfirm.setBackground(new Color(0, 128, 128));
				btnConfirm.setBounds(640, 20, 153, 35);
				pnDetails.add(btnConfirm);
				refreshComponents();
				btnConfirm.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						try {
							VoucherDTO voucherDTO = new VoucherDTO(
									txtIdVoucher.getText(), txtCode.getText(), Float.valueOf(txtDiscountPercent.getText()), sdf.parse(txtStartDate.getText()), sdf.parse(txtEndDate.getText())
									);
							int kq = voucherBLL.insert(voucherDTO);
							if(kq == 1) {
								JOptionPane.showMessageDialog(null, "Thêm thành công!");
								txtCode.setEditable(false);
								pnDetails.remove(btnConfirm);
								loadTable();
								refreshComponents();
								enableButtoninVoucher();
							}else if(kq == 2){
								JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null,"Vui lòng nhập thông tin hợp lệ");
						}
					}
				});
			}
		});
		
                btnUpdateVoucher.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = tblVoucher.getSelectedRow();
                        if(row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn voucher cần sửa!");
                            return;
                        }
                        txtCode.setEditable(true);
                        txtDiscountPercent.setEditable(true);
                        txtStartDate.setEditable(true);
                        txtEndDate.setEditable(true);

                        // Ẩn các nút Thêm, Sửa, Xóa
                        disableButtoninVoucher();

                        btnConfirm = new JButton("Xác nhận");
                        btnConfirm.setIcon(new ImageIcon(CategoryForm.class.getResource("/images/checkmark.png")));
                        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
                        btnConfirm.setForeground(new Color(255, 255, 224));
                        btnConfirm.setBackground(new Color(0, 128, 128));
                        btnConfirm.setBounds(640, 20, 153, 35);
                        pnDetails.add(btnConfirm);

                        // Xử lý sự kiện cho nút Xác nhận
                        btnConfirm.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                try {
                                    VoucherDTO voucherDTO = new VoucherDTO(
                                            txtIdVoucher.getText(), txtCode.getText(), Float.valueOf(txtDiscountPercent.getText()), sdf.parse(txtStartDate.getText()), sdf.parse(txtEndDate.getText())
                                    );
                                    int kq = voucherBLL.update(voucherDTO);
                                    if(kq == 1) {
                                        JOptionPane.showMessageDialog(null, "Sửa thành công!");
                                        txtCode.setEditable(false);
                                        txtDiscountPercent.setEditable(false);
                                        txtStartDate.setEditable(false);
                                        txtEndDate.setEditable(false);
                                        pnDetails.remove(btnConfirm);
                                        loadTable();
                                        refreshComponents();
                                        enableButtoninVoucher(); // Hiển thị lại các nút Thêm, Sửa, Xóa
                                    } else if(kq == 2) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sửa thất bại!");
                                    }
                                } catch (Exception e1) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin hợp lệ");
                                }
                            }
                        });
                        refreshComponents();
                    }
                });

		
                btnDeleteVoucher.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = tblVoucher.getSelectedRow(); 
                        if(row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn voucher cần xóa!");
                            return; 
                        }
                        int rs = JOptionPane.showConfirmDialog(null, "Xác nhận xóa voucher!");
                        if (rs == 0) {
                            String id_voucher = String.valueOf(tblVoucher.getValueAt(row, 0)); 
                            int kq = voucherBLL.delete(id_voucher);
                            if(kq == 1) {
                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                                loadTable(); 
                            }else {
                                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                            }
                        }
                    }
                });
	}
	public void refreshComponents() {
		this.repaint();
		this.revalidate();
	}
	public void disableButtoninVoucher() {
		btnAddVoucher.setEnabled(false);
		btnUpdateVoucher.setEnabled(false);
		btnDeleteVoucher.setEnabled(false);
	}
	public void enableButtoninVoucher() {
		btnAddVoucher.setEnabled(true);
		btnUpdateVoucher.setEnabled(true);
		btnDeleteVoucher.setEnabled(true);
	}
}