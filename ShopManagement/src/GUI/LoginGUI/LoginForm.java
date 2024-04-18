package GUI.LoginGUI;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import BLL.AccountBLL;
import BLL.EmployeeBLL;
import DTO.AccountDTO;
import DTO.EmployeeDTO;
import GUI.HomeGUI.HomeForm;

public final class LoginForm extends JFrame {

    int posX, posY;
    int widthLeft;
    private JPanel contentPane;
    private JPanel pnBtnBar;
    private JLabel lblClose, lblMinimize;
    JPanel pnHome;
    private JPanel pnInput;
    private JLabel lblNewLabel;
    private JPasswordField txt_pass;
    private JPanel pnBtn;
    private JLabel lbl_IconDeliveryman;
    private JButton btnLogin;
    private JTextField txt_username;
    private AccountBLL accountBLL = new AccountBLL();
    private EmployeeBLL employeeBLL = new EmployeeBLL();

    private JComboBox cbxUser;
    private String loginUser = "p1";

    public LoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 100, 633, 350);
        setUndecorated(true);
        setLocationRelativeTo(null);
        initComponents(); // initComponents
        addEvents();
    }

    public void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        pnBtnBar = new JPanel();
        pnBtnBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        pnBtnBar.setBackground(new Color(0, 128, 128));
        pnBtnBar.setBounds(308, 0, 326, 30);
        contentPane.add(pnBtnBar);
        pnBtnBar.setLayout(null);

        lblMinimize = new JLabel("-");

        lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMinimize.setForeground(Color.WHITE);
        lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
        lblMinimize.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblMinimize.setBounds(256, 0, 30, 30);
        pnBtnBar.add(lblMinimize);

        lblClose = new JLabel("x");
        lblClose.setBackground(new Color(0, 128, 128));
        lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblClose.setForeground(Color.WHITE);
        lblClose.setBounds(296, 0, 30, 30);
        pnBtnBar.add(lblClose);
        lblClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblClose.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel pnContent = new JPanel();
        pnContent.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnContent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnContent.setBackground(new Color(0, 139, 139));
        pnContent.setBounds(308, 29, 326, 321);
        contentPane.add(pnContent);
        pnContent.setLayout(null);

        pnInput = new JPanel();
        pnInput.setOpaque(false);
        pnInput.setBounds(0, 0, 326, 224);
        pnContent.add(pnInput);
        pnInput.setLayout(null);

        //
        lblNewLabel = new JLabel("Bạn là");
        lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblNewLabel.setBounds(42, 20, 100, 25);
        pnInput.add(lblNewLabel);

        cbxUser = new JComboBox();
        JComboBox<String> cbxUser = new JComboBox<>();
        cbxUser.setModel(new DefaultComboBoxModel<>(new String[]{"Quản lý", "Nhân viên kho", "Nhân viên kinh doanh", "Admin"}));
        cbxUser.addActionListener((ActionEvent evt) -> {
            loginUser = switch (cbxUser.getSelectedIndex()) {
                case 0 -> "p1";
                case 1 -> "p2";
                case 2 -> "p3";
                case 3 -> "ad";
                default -> "p1";
            };
        });
        cbxUser.setBounds(130, 20, 160, 30);
        pnInput.add(cbxUser);
        //

        lblNewLabel = new JLabel("Tài khoản");
        lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblNewLabel.setBounds(42, 78, 100, 25);
        pnInput.add(lblNewLabel);

        txt_username = new JTextField();
        txt_username.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txt_username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        txt_username.setHorizontalAlignment(SwingConstants.LEFT);
        txt_username.setCaretColor(new Color(255, 255, 255));
        txt_username.setBackground(new Color(0, 139, 139));
        txt_username.setDisabledTextColor(new Color(0, 139, 139));
        txt_username.setForeground(new Color(255, 255, 255));
        txt_username.setSelectedTextColor(new Color(0, 139, 139));
        txt_username.setBounds(42, 103, 250, 25);
        pnInput.add(txt_username);
        txt_username.setColumns(10);

        JLabel lblMtKhu = new JLabel("Mật khẩu");
        lblMtKhu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        lblMtKhu.setForeground(Color.WHITE);
        lblMtKhu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMtKhu.setBounds(42, 137, 100, 25);
        pnInput.add(lblMtKhu);

        txt_pass = new JPasswordField();
        txt_pass.setForeground(new Color(255, 255, 255));
        txt_pass.setDisabledTextColor(new Color(255, 255, 255));
        txt_pass.setOpaque(false);
        txt_pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        txt_pass.setCaretColor(new Color(255, 255, 255));
        txt_pass.setBounds(42, 162, 250, 25);
        pnInput.add(txt_pass);

        pnBtn = new JPanel();
        pnBtn.setOpaque(false);
        pnBtn.setBounds(39, 245, 234, 30);
        pnContent.add(pnBtn);
        pnBtn.setLayout(null);

        btnLogin = new JButton("\u0110\u0103ng nh\u1EADp");
        btnLogin.setForeground(new Color(0, 128, 0));

        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setBackground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBounds(0, 0, 234, 30);
        pnBtn.add(btnLogin);

        JPanel pnLogo = new JPanel();
        pnLogo.setForeground(new Color(255, 255, 255));
        pnLogo.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(255, 255, 255)));
        pnLogo.setBackground(new Color(70, 139, 139));
        pnLogo.setBounds(0, 0, 308, 350);
        contentPane.add(pnLogo);
        pnLogo.setLayout(null);

        lbl_IconDeliveryman = new JLabel("");
        lbl_IconDeliveryman.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_IconDeliveryman.setIcon(new ImageIcon(LoginForm.class.getResource("/images/logo shop 400px.png")));
        lbl_IconDeliveryman.setBounds(-52, 11, 346, 328);
        pnLogo.add(lbl_IconDeliveryman);
        widthLeft = (int) pnLogo.getPreferredSize().getWidth();

    }

    //Event 
    public void addEvents() {
        lblClose.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblClose.setBackground(new Color(47, 79, 79));
                lblClose.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
//				lblClose.setOpaque(false);
                lblClose.setBackground(new Color(0, 128, 128));
            }
        });

        lblMinimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setState(Frame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblMinimize.setBackground(new Color(47, 79, 79));
                lblMinimize.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
//				lblMini.setOpaque(false);
                lblMinimize.setBackground(new Color(0, 128, 128));
            }
        });

        pnBtnBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int positionX = e.getXOnScreen();
                int positionY = e.getYOnScreen();
                moveWindow(positionX - posX - widthLeft - 100, positionY - posY);
            }
        });

        // Login
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = txt_username.getText();
                String password = String.valueOf(txt_pass.getPassword());
                if (username.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền tài khoản !");
                } else if (password.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền mật khẩu !");
                } else {
                    AccountDTO accountDTO = new AccountDTO(
                            username, password
                    );
                    
                    
                    AccountDTO accountLogin = accountBLL.login(accountDTO, loginUser);
                    if (accountLogin == null) {
                        JOptionPane.showMessageDialog(null, "Thông tin tài khoản không chính xác !");
                    } else if (accountLogin.getStatus() == 0) {
                        JOptionPane.showMessageDialog(null, "Tài khoản đã bị khóa !");
                    } else {
                        /**
                         * Authorization
                         *
                         */
                        // Get EmployeeDTO
                        EmployeeDTO employeeDTO = employeeBLL.getEmployeeById(accountLogin.getId_user());
                        // Get position
                        loadHomeForm(employeeDTO);
                    }
                    
                    
                }
            }
        });

    }

    public void moveWindow(int positionX, int positionY) {
        this.setLocation(positionX, positionY);
    }

    public void closeThisWindow() {
        this.dispose();
    }

    public void loadHomeForm(EmployeeDTO employeeDTO) {
        HomeForm homeForm = new HomeForm(employeeDTO);
        homeForm.setVisible(true);
        closeThisWindow();
    }

    // public 
    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }
}
