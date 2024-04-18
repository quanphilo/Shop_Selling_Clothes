package GUI.HomeGUI;

import java.awt.event.*;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import BLL.PermissionBLL;
import BLL.PosPermissionBLL;
import BLL.PositionBLL;
import DTO.EmployeeDTO;
import DTO.PosPermissionDTO;
import DTO.PositionDTO;
import GUI.CategoryGUI.CategoryForm;
import GUI.CustomerGUI.CustomerForm;
import GUI.EmployeeGUI.EmployeeForm;
import GUI.AccountGUI.AccountForm;
import GUI.LoginGUI.LoginForm;
import GUI.StatisticalGUI.StatisticalForm;
import GUI.OrderManagmentGUI.OrderManagementForm;
import GUI.PositionAndPermissionGUI.PositionAndPermissionForm;
import GUI.PostProductGUI.PostProductForm;
import GUI.ProductGUI.ProductForm;
import GUI.SellProductGUI.SellProductForm;
import GUI.SupplierAndBrandGUI.SupplierAndBrandForm;
import GUI.VoucherGUI.VoucherForm;
import GUI.WarehouseReceiptGUI.WarehouseReceiptForm;

public class HomeForm extends JFrame {
	private EmployeeDTO employeeDTO;
	private JPanel pnUserOptions;
	private JPanel pnOptions;
	int posX, posY, widthLeft;
	private JPanel contentPane;
	private JPanel pnHeader;
	private JPanel pnMain_home;
	private JLabel lblMinimize;
	private JLabel lblClose;

	private PosPermissionBLL posPermissionBLL = new PosPermissionBLL();
	private PermissionBLL permissionBLL = new PermissionBLL();
	private PositionBLL positionBLL = new PositionBLL();
	private InitForm initUserForm = new InitForm();
	private PositionDTO positionDTO;
	private JPanel pnContent;
	private JPanel pnChange;
	private JLabel lblEmployeeId;
	private JButton btnLogout;
	private JLabel lblEmployeePosition;
	private JLabel lblEmployeeName;

	public HomeForm() {
		initComponents();
		addEvents();
	}

	public HomeForm(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
		initComponents();
		authorization(employeeDTO);
		loadInfoHeader();
		addEvents();
	}

	public void initComponents() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 530);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(null);
		pnLeft.setMaximumSize(new Dimension(8200, 32767));
		pnLeft.setBackground(new Color(0, 139, 139));
		pnLeft.setBounds(0, 0, 170, 530);
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
		pnMenu.setBounds(0, 40, 170, 490);
		pnLeft.add(pnMenu);

		pnOptions = new JPanel();
		pnOptions.setOpaque(false);
		pnOptions.setBounds(0, 0, 170, 490);
		pnMenu.add(pnOptions);
		pnOptions.setLayout(new GridLayout(12, 1, 0, 0));

		JPanel pnRight = new JPanel();
		pnRight.setLayout(null);
		pnRight.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnRight.setBackground(new Color(240,240,240));
		pnRight.setBounds(169, 0, 830, 530);
		contentPane.add(pnRight);

		pnHeader = new JPanel();
		pnHeader.setLayout(null);
		pnHeader.setBorder(null);
		pnHeader.setBackground(Color.WHITE);
		pnHeader.setBounds(0, 0, 830, 37);
		pnRight.add(pnHeader);

		lblMinimize = new JLabel("-");
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(new Color(0, 128, 128));
		lblMinimize.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMinimize.setBounds(744, 0, 43, 37);
		pnHeader.add(lblMinimize);

		lblClose = new JLabel("x");
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(new Color(0, 128, 128));
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClose.setBackground(Color.WHITE);
		lblClose.setBounds(787, 0, 43, 37);
		pnHeader.add(lblClose);
		
		JLabel lblefef = new JLabel("ID:");
		lblefef.setForeground(new Color(34, 139, 34));
		lblefef.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblefef.setBounds(24, 11, 25, 14);
		pnHeader.add(lblefef);
		
		lblEmployeeId = new JLabel("New label");
		lblEmployeeId.setForeground(new Color(139, 0, 0));
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmployeeId.setBounds(50, 11, 144, 14);
		pnHeader.add(lblEmployeeId);
		
		lblEmployeeName = new JLabel("New label");
		lblEmployeeName.setForeground(new Color(139, 0, 0));
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmployeeName.setBounds(263, 11, 144, 14);
		pnHeader.add(lblEmployeeName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(34, 139, 34));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(219, 11, 43, 14);
		pnHeader.add(lblName);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(new Color(34, 139, 34));
		lblChcV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChcV.setBounds(430, 11, 61, 14);
		pnHeader.add(lblChcV);
		
		lblEmployeePosition = new JLabel("New label");
		lblEmployeePosition.setForeground(new Color(139, 0, 0));
		lblEmployeePosition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmployeePosition.setBounds(494, 11, 144, 14);
		pnHeader.add(lblEmployeePosition);
		
		btnLogout = new JButton("");
		btnLogout.setFocusable(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setOpaque(false);
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setIcon(new ImageIcon(HomeForm.class.getResource("/images/homeicon/logout (1).png")));
		btnLogout.setBounds(693, 0, 36, 37);
		pnHeader.add(btnLogout);

		pnMain_home = new JPanel();
		pnMain_home.setLayout(null);
		pnMain_home.setOpaque(false);
		pnMain_home.setBounds(0, 37, 830, 490);
		pnRight.add(pnMain_home);

		pnContent = new JPanel();
		pnContent.setBounds(0, 0, 830, 491);
		pnMain_home.add(pnContent);
		pnContent.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeForm.class.getResource("/images/logo shop 500px.png")));
		lblNewLabel.setBounds(0, 0, 830, 463);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnContent.add(lblNewLabel);

		pnChange = pnContent;
	}
	
	
	public void loadInfoHeader() {
		positionDTO = positionBLL.getPositionById(employeeDTO.getPositionDTO().getId_positions());
		lblEmployeeId.setText(employeeDTO.getId());
		lblEmployeeName.setText(employeeDTO.getFullname());
		lblEmployeePosition.setText(positionDTO.getName());
		
	}

	public void addEvents() {
		// Sell
		initUserForm.getPnSell().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SellProductForm sellProductForm = new SellProductForm(employeeDTO);
				pnMain_home.remove(pnChange);
				pnChange = sellProductForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Product
		initUserForm.getPnProduct().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProductForm productForm = new ProductForm();
				pnMain_home.remove(pnChange);
				pnChange = productForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Supplier
		initUserForm.getPnSupplier().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SupplierAndBrandForm supplierAndBrandForm = new SupplierAndBrandForm();
				pnMain_home.remove(pnChange);
				pnChange = supplierAndBrandForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Warehouse
		initUserForm.getPnWarehouse().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				WarehouseReceiptForm warehouseReceiptForm = new WarehouseReceiptForm(employeeDTO);
				pnMain_home.remove(pnChange);
				pnChange = warehouseReceiptForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Post Product
		initUserForm.getPnPostProduct().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PostProductForm postProductForm = new PostProductForm();
				pnMain_home.remove(pnChange);
				pnChange = postProductForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Voucher
		initUserForm.getPnVoucher().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				VoucherForm voucherForm = new VoucherForm();
				pnMain_home.remove(pnChange);
				pnChange = voucherForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Order
		initUserForm.getPnOrder().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				OrderManagementForm orderManagementForm = new OrderManagementForm();
				pnMain_home.remove(pnChange);
				pnChange = orderManagementForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		
		// Employee
		initUserForm.getPnEmployee().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				EmployeeForm employeeForm = new EmployeeForm();
				pnMain_home.remove(pnChange);
				pnChange = employeeForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});
                
                initUserForm.getPnEmployeeAdmin().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AccountForm employeeForm = new AccountForm();
				pnMain_home.remove(pnChange);
				pnChange = employeeForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});
                
		// Customer
		initUserForm.getPnCustomer().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CustomerForm customerForm = new CustomerForm();
				pnMain_home.remove(pnChange);
				pnChange = customerForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Permission
		initUserForm.getPnPermission().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PositionAndPermissionForm posPermissionForm = new PositionAndPermissionForm();
				pnMain_home.remove(pnChange);
				pnChange = posPermissionForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		initUserForm.getPnCategory().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			CategoryForm categoryForm = new CategoryForm();
				pnMain_home.remove(pnChange);
				pnChange = categoryForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});

		// Statistics
		initUserForm.getPnStatistic().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StatisticalForm statisticalForm = new StatisticalForm();
				pnMain_home.remove(pnChange);
				pnChange = statisticalForm;
				pnMain_home.add(pnChange);
				refreshFrame();
			}
		});
		
		//Logout
		btnLogout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rs = JOptionPane.showConfirmDialog(null, "Xác nhận đăng xuất!");
				if (rs == 0) {
					//say yes
					logout();
				}
			}
		});

		// Mini, max
		lblClose.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setBackground(new Color(0, 128, 128));
				lblClose.setOpaque(true);
				lblClose.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setOpaque(false);
				lblClose.setBackground(new Color(255, 255, 255));
				lblClose.setForeground(new Color(0, 128, 128));
			}
		});

		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimize.setBackground(new Color(0, 128, 128));
				lblMinimize.setOpaque(true);
				lblMinimize.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimize.setOpaque(false);
				lblMinimize.setBackground(new Color(255, 255, 255));
				lblMinimize.setForeground(new Color(0, 128, 128));
			}
		});

		// Move frame | drag and drop title bar
		pnHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX = e.getX();
				posY = e.getY();
			}
		});

		
		pnHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int positionX = e.getXOnScreen();
				int positionY = e.getYOnScreen();
				moveWindow(positionX - posX - 180, positionY - posY);
			}
		});
	}

	public void moveWindow(int positionX, int positionY) {
		this.setLocation(positionX, positionY);
	}

	public void logout() {
		LoginForm loginUI = new LoginForm();
		loginUI.setVisible(true);
		this.dispose();
	}

	public void authorization(EmployeeDTO employeeDTO) {
		Vector<PosPermissionDTO> listPosition = posPermissionBLL
				.getPermissionByPosId(employeeDTO.getPositionDTO().getId_positions());
		for (PosPermissionDTO posPermissionDTO : listPosition) {
			switch (posPermissionDTO.getPermissionDTO().getId_permission()) {
				case "PE01":
					pnOptions.add(initUserForm.getPnSell());
					break;
				case "PE02":
					pnOptions.add(initUserForm.getPnProduct());
					break;
				case "PE03":
					pnOptions.add(initUserForm.getPnCategory());
					break;
				case "PE04":
					pnOptions.add(initUserForm.getPnSupplier());
					break;
				case "PE05":
					pnOptions.add(initUserForm.getPnWarehouse());
					break;
				case "PE06":
					pnOptions.add(initUserForm.getPnVoucher());
					break;
				case "PE07":
					pnOptions.add(initUserForm.getPnOrder());
					break;
				case "PE08":
                                        if (employeeDTO.getPositionDTO().getId_positions().equals("ad")){
                                            pnOptions.add(initUserForm.getPnEmployeeAdmin());
                                        }
                                        else{
                                            pnOptions.add(initUserForm.getPnEmployee());
                                        }
					break;
				case "PE09":
					pnOptions.add(initUserForm.getPnCustomer());
					break;
				case "PE10":
					pnOptions.add(initUserForm.getPnPermission());
					break;
				case "PE11":
					pnOptions.add(initUserForm.getPnStatistic());
					break;
				default:
					break;
			}
		}
		refreshFrame();
	}

	public void refreshFrame() {
		this.revalidate();
		this.repaint();
	}
}
