package GUI.SellProductGUI;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.table.DefaultTableModel;

import BLL.CustomerBLL;
import DTO.CustomerDTO;

public class CustomerDialog extends JDialog {
	private CustomerBLL customerBLL = new CustomerBLL();
	private Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Vector<CustomerDTO> listCustomer = customerBLL.getCustomers();
	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable tblCustomer;
	private JButton btnCancel;
	private JButton btnOk;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtPhone;
        private JTextField txtSearch;
	private JButton btnAddNewCus;
	private JButton btnAccept;
        private JButton btnSearch;
	private JTextField txtCreateDate;
	private JTextField txtPoint;


	public CustomerDialog() {
		initComponents();
		addEvents();
		loadCustomTable();
	}

	public void initComponents() {
		setSize(700, 450);
		setLocationRelativeTo(null);
		Container conn = this.getContentPane();
		getContentPane().setLayout(null);
		JPanel pnTable = new JPanel();
		pnTable.setBounds(0, 0, 411, 313);
		conn.add(pnTable);
		pnTable.setLayout(new BorderLayout());

		tblCustomer = new JTable();
		JScrollPane scrollPane = new JScrollPane(tblCustomer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblCustomer.setDefaultEditor(Object.class, null);
                pnTable.add(scrollPane, BorderLayout.CENTER);

		JPanel pnAction = new JPanel();
		pnAction.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 128, 0)));
		pnAction.setBounds(0, 313, 684, 98);
		getContentPane().add(pnAction);
		pnAction.setLayout(null);

		btnOk = new JButton("OK");
		btnOk.setIcon(null);
		btnOk.setBounds(446, 60, 97, 27);
		btnOk.setForeground(new Color(255, 255, 224));
		btnOk.setBackground(new Color(0, 128, 128));
		pnAction.add(btnOk);

		btnCancel = new JButton("CANCEL");
		btnCancel.setIcon(null);
		btnCancel.setForeground(new Color(255, 255, 224));
		btnCancel.setBackground(new Color(0, 128, 128));
		btnCancel.setBounds(555, 60, 97, 27);
		pnAction.add(btnCancel);

		btnAddNewCus = new JButton("Thêm khách hàng mới");
		btnAddNewCus.setIcon(new ImageIcon(CustomerDialog.class.getResource("/images/follow.png")));
		btnAddNewCus.setForeground(new Color(255, 255, 224));
		btnAddNewCus.setBackground(new Color(0, 128, 128));
		btnAddNewCus.setBounds(12, 60, 189, 27);
		pnAction.add(btnAddNewCus);

		btnAccept = new JButton("Xác nhận");
		btnAccept.setIcon(new ImageIcon(CustomerDialog.class.getResource("/images/checkmark.png")));
		btnAccept.setForeground(new Color(255, 255, 224));
		btnAccept.setBackground(new Color(0, 128, 128));
		btnAccept.setBounds(220, 60, 129, 27);
		pnAction.add(btnAccept);
		btnAccept.setVisible(false);
                
                txtSearch = new JTextField();
                txtSearch.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tìm kiếm theo tên khách hàng",
                        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
                txtSearch.setBounds(12, 8, 217, 35);
                pnAction.add(txtSearch); 

                btnSearch = new JButton("LỌC");
                btnSearch.setIcon(new ImageIcon(CustomerDialog.class.getResource("/images/search-icon.png")));
                btnSearch.setForeground(new Color(255, 255, 224));
                btnSearch.setBackground(new Color(0, 128, 128));
                btnSearch.setBounds(250, 8, 120, 35);
                pnAction.add(btnSearch);
            
                
		JPanel pnInfos = new JPanel();
		pnInfos.setBounds(419, 0, 265, 313);
		getContentPane().add(pnInfos);
		pnInfos.setLayout(null);

		txtId = new JTextField();
		txtId.setBorder(new TitledBorder(null, "Mã khách hàng", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 128, 0)));
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(12, 20, 217, 35);
		pnInfos.add(txtId);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tên khách hàng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		txtName.setBounds(12, 60, 217, 35);
		pnInfos.add(txtName);

		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setColumns(10);
		txtAddress.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Địa chỉ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		txtAddress.setBounds(12, 100, 217, 35);
		pnInfos.add(txtAddress);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Email", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 128, 0)));
		txtEmail.setBounds(12, 140, 217, 35);
		pnInfos.add(txtEmail);

		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setColumns(10);
		txtPhone.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Số điện thoại",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		txtPhone.setBounds(12, 180, 217, 35);
		pnInfos.add(txtPhone);
		
		txtCreateDate = new JTextField();
		txtCreateDate.setEditable(false);
		txtCreateDate.setColumns(10);
		txtCreateDate.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ngày tạo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		txtCreateDate.setBounds(12, 220, 217, 35);
		pnInfos.add(txtCreateDate);
		
		txtPoint = new JTextField();
		txtPoint.setEditable(false);
		txtPoint.setColumns(10);
		txtPoint.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Điểm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		txtPoint.setBounds(12, 260, 217, 35);
		pnInfos.add(txtPoint);
                
        }
	public void addEvents() {
		btnSearch.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String searchTerm = txtSearch.getText().trim();
                        if (!searchTerm.isEmpty()) {
                            searchCustomerByName(searchTerm);
                        } else {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập nội dung vào ô tìm kiếm");
                        }
                    }
                });
            
                btnOk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblCustomer.getSelectedRow();
				if (row > -1) {
					String id_customer = String.valueOf(tblCustomer.getValueAt(row, 0));
					SellProductForm.setCustomerDTO(customerBLL.getCustomerById(id_customer));
					SellProductForm.refreshComponents();
					closeDialog();
				}
			}
		});

		btnCancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				closeDialog();
			}
		});

		tblCustomer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblCustomer.getSelectedRow();
				if (row > -1) {
					String id_customer = String.valueOf(tblCustomer.getValueAt(row, 0));
					for (CustomerDTO customer : listCustomer) {
						if (customer.getId().equals(id_customer)) {
							loadCustomerDetail(customer);
							return;
						}
					}

				}
			}
		});

		btnAddNewCus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin khách hàng mới!");
				txtId.setText("CU" + date.getTime());
				blankTextField();
				setEditTextField(true);
                                txtCreateDate.setEditable(false);
				btnAccept.setVisible(true);
				btnAddNewCus.setEnabled(false);
				txtCreateDate.setText(sdf.format(date));
				btnOk.setEnabled(false);
			}
		});

                btnAccept.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (txtName.getText().trim().isEmpty() ||
                            txtEmail.getText().trim().isEmpty() ||
                            txtAddress.getText().trim().isEmpty() ||
                            txtPhone.getText().trim().isEmpty() ) {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                            return;
                        }
                        // Kiểm tra định dạng email hợp lệ
                        if (!txtEmail.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                            JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                            return;
                        }           
                        // Kiểm tra định dạng số điện thoại hợp lệ
                        if (!txtPhone.getText().matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
                            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                          
                        try {
                            CustomerDTO customerDTO = new CustomerDTO(
                                    txtId.getText(),
                                    txtName.getText(),
                                    txtEmail.getText(),
                                    txtAddress.getText(),
                                    txtPhone.getText(),
                                    sdf.parse(txtCreateDate.getText()), 
                                    Integer.valueOf(txtPoint.getText())
                            );
                            int kq = customerBLL.insert(customerDTO);
                            if (kq == 1) {
                                JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công!");
                                setEditTextField(false);
                                loadCustomTable();
                                btnAddNewCus.setEnabled(true);
                                btnAccept.setVisible(false);
                                btnOk.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Lỗi !");
                            }
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null,"Clicked");
                        }
                    }
                });
        }

	public void blankTextField() {
		txtName.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		txtCreateDate.setText("");
		txtPoint.setText("0");
	}

	public void setEditTextField(boolean flag) {
		txtName.setEditable(flag);
		txtPhone.setEditable(flag);
		txtAddress.setEditable(flag);
		txtEmail.setEditable(flag);
		txtCreateDate.setEditable(flag);
		txtPoint.setEditable(flag);
	}
        
        public void searchCustomerByName(String name) {
                Vector<CustomerDTO> searchResult = customerBLL.searchCustomersByName(name);
                DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
                model.setRowCount(0); 

                for (CustomerDTO customer : searchResult) {
                    model.addRow(new Object[] {
                        customer.getId(),
                        customer.getFullname(),
                        customer.getAddress(),
                        customer.getPhone(),
                        customer.getPoint()
                    });
                }
            }
	public void loadCustomTable() {
		listCustomer = customerBLL.getCustomers();
		DefaultTableModel dfm = new DefaultTableModel();
		String[] header = { "Mã KH", "Tên KH", "Địa chỉ", "SĐT","Điểm" };
		dfm.setColumnIdentifiers(header);

		for (CustomerDTO customerDTO : listCustomer) {
			String[] row = { 
					customerDTO.getId(), 
					customerDTO.getFullname(),
					customerDTO.getAddress(), 
					customerDTO.getPhone(),
					String.valueOf(customerDTO.getPoint())
			};
			dfm.addRow(row);
		}
		tblCustomer.setModel(dfm);
	}

	public void loadCustomerDetail(CustomerDTO customerDTO) {
		txtId.setText(customerDTO.getId());
		txtName.setText(customerDTO.getFullname());
		txtAddress.setText(customerDTO.getAddress());
		txtEmail.setText(customerDTO.getEmail());
		txtPhone.setText(customerDTO.getPhone());
		txtCreateDate.setText(String.valueOf(customerDTO.getCreatedate()));
		txtPoint.setText(String.valueOf(customerDTO.getPoint()));
	}

	public void closeDialog() {
		this.dispose();
	}
}
