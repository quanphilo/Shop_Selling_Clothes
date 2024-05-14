package GUI.PositionAndPermissionGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import BLL.PermissionBLL;
import BLL.PosPermissionBLL;
import BLL.PositionBLL;
import DTO.PermissionDTO;
import DTO.PosPermissionDTO;
import DTO.PositionDTO;

public class PositionAndPermissionForm extends JPanel {

    private PositionBLL positionBLL = new PositionBLL();
    private PermissionBLL permissionBLL = new PermissionBLL();
    private PosPermissionBLL posPermissionBLL = new PosPermissionBLL();

    private Vector<PositionDTO> listPosition = positionBLL.getPositions();
    private Vector<PermissionDTO> listPermission = permissionBLL.getPermissions();

    private JPanel pnOptions;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private JPanel pnOrder;
    private JLabel lblMNv;
    private JTextField txtId;
    private JTextField txtName;
    private JLabel lblTnNv;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JPanel panel_2;
    private JLabel lblNewLabel;
    private JTable tblPosition;
    private JCheckBox[] checkboxPer;
    private JButton btnUpdatePermission;

    public PositionAndPermissionForm() {
        initComponents();
        loadPermissions();
        addEvents();
        loadPositionTable();
    }

    public void initComponents() {
        setLayout(null);
        setBounds(0, 0, 830, 490);

        pnOrder = new JPanel();
        pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
        pnOrder.setBounds(0, 40, 422, 450);
        add(pnOrder);
        pnOrder.setLayout(null);

        JPanel pnAction = new JPanel();
        pnAction.setBounds(0, 0, 420, 450);
        pnOrder.add(pnAction);
        pnAction.setLayout(null);

        lblMNv = new JLabel("Mã chức vụ");
        lblMNv.setForeground(new Color(46, 139, 87));
        lblMNv.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMNv.setBounds(25, 24, 91, 27);
        pnAction.add(lblMNv);

        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setColumns(10);
        txtId.setBounds(130, 25, 102, 27);
        pnAction.add(txtId);

        txtName = new JTextField();
        txtName.setEditable(false);
        txtName.setColumns(10);
        txtName.setBounds(130, 61, 195, 27);
        pnAction.add(txtName);

        lblTnNv = new JLabel("Tên chức vụ");
        lblTnNv.setForeground(new Color(46, 139, 87));
        lblTnNv.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTnNv.setBounds(25, 61, 91, 27);
        pnAction.add(lblTnNv);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Danh sách chức vụ",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panel.setBounds(25, 117, 383, 321);
        pnAction.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        tblPosition = new JTable();
        tblPosition.setDefaultEditor(Object.class, null);
        scrollPane = new JScrollPane(tblPosition, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        pnOptions = new JPanel();
        pnOptions.setForeground(new Color(0, 100, 0));
        pnOptions.setBounds(420, 40, 410, 450);
        add(pnOptions);

        DefaultTableModel dtmHD = new DefaultTableModel();
        String[] headerHD = {"Mã NV", "Tên NV", "SĐT", "Chức vụ"};
        dtmHD.setColumnIdentifiers(headerHD);
        pnOptions.setLayout(null);

        JPanel pnDetails_1 = new JPanel();
        pnDetails_1.setLayout(null);
        pnDetails_1.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
        pnDetails_1.setBounds(0, 364, 410, 86);
        pnOptions.add(pnDetails_1);

        btnUpdatePermission = new JButton("Áp dụng quyền");
        btnUpdatePermission
                .setIcon(new ImageIcon(PositionAndPermissionForm.class.getResource("/images/check-1-icon.png")));
        btnUpdatePermission.setForeground(new Color(255, 255, 224));
        btnUpdatePermission.setBackground(new Color(0, 128, 128));
        btnUpdatePermission.setBounds(120, 27, 184, 36);
        pnDetails_1.add(btnUpdatePermission);

        panel_2 = new JPanel();
        panel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 128, 128)));
        panel_2.setBounds(0, 0, 832, 40);
        add(panel_2);
        panel_2.setLayout(null);

        JButton btnSupplier = new JButton("Chức vụ");
        btnSupplier.setBackground(new Color(0, 139, 139));
        btnSupplier.setForeground(new Color(248, 248, 255));
        btnSupplier.setBounds(100, 7, 186, 26);
        panel_2.add(btnSupplier);

        JButton btnQunLThng = new JButton("Phân quyền");
        btnQunLThng.setForeground(new Color(248, 248, 255));
        btnQunLThng.setBackground(new Color(0, 139, 139));
        btnQunLThng.setBounds(548, 7, 170, 26);
        panel_2.add(btnQunLThng);

        lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(PositionAndPermissionForm.class.getResource("/images/right-arrow.png")));
        lblNewLabel.setBounds(388, 7, 61, 21);
        panel_2.add(lblNewLabel);

    }

    public void addEvents() {
        tblPosition.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tblPosition.getSelectedRow();
                if (row > -1) {
                    PositionDTO positionDTO = positionBLL
                            .getPositionById(String.valueOf(tblPosition.getValueAt(row, 0)));
                    txtId.setText(positionDTO.getId_positions());
                    txtName.setText(positionDTO.getName());
                    uncheckAllPermission();
                    loadPermissionOfPosition(positionDTO);
                }
            }
        });

        btnUpdatePermission.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = 0;
                PositionDTO positionDTO = positionBLL.getPositionById(txtId.getText());
                for (JCheckBox checkItem : checkboxPer) {
                    PosPermissionDTO posPerDTO = new PosPermissionDTO(
                            new PermissionDTO(
                                    String.valueOf(checkboxPer[index].getClientProperty("checkbox_id_permission"))),
                            positionDTO);
                    if (checkboxPer[index].isSelected()) {
                        if (posPermissionBLL.checkInit(posPerDTO) == 0) {
                            if (posPermissionBLL.insert(posPerDTO) == 0) {
                                JOptionPane.showMessageDialog(null, "Xảy ra lỗi!");
                                break;
                            }
                        }

                    } else {
                        if (posPermissionBLL.checkInit(posPerDTO) == 1) {
                            if (posPermissionBLL.delete(posPerDTO) == 0) {
                                JOptionPane.showMessageDialog(null, "Xảy ra lỗi!");
                                break;
                            }
                        }
                    }
                    index++;
                }
                JOptionPane.showMessageDialog(null, "Áp dụng quyền thành công!");
                loadPermissionOfPosition(positionDTO);
            }
        });
    }

    public void loadPositionTable() {
        DefaultTableModel dfm = new DefaultTableModel();
        String[] header = {"Mã chức vụ", "Tên chức vụ"};
        dfm.setColumnIdentifiers(header);
        for (PositionDTO position : listPosition) {
            if ("ad".equals(position.getId_positions())) {
                continue;
            }
            String[] row = {
                position.getId_positions(),
                position.getName()
            };
            dfm.addRow(row);
        }
        tblPosition.setModel(dfm);
    }

    public void uncheckAllPermission() {
        int index = 0;
        for (JCheckBox checkItem : checkboxPer) {
            checkboxPer[index].setSelected(false);
            index++;
        }
    }

    public void loadPermissions() {
        int count = listPermission.size();
        checkboxPer = new JCheckBox[count];
        int index = 0;
        int x = 27;
        int y = 42;
        int width = 150, height = 24;
        for (PermissionDTO permission : listPermission) {
            checkboxPer[index] = new JCheckBox(permission.getName());
            if (index < 6) {
                checkboxPer[index].setBounds(x, y + index * 50, width, height);
            } else {
                checkboxPer[index].setBounds(x + 205, y + (index - 6) * 50, width, height);
            }
            checkboxPer[index].putClientProperty("checkbox_id_permission", permission.getId_permission());
            pnOptions.add(checkboxPer[index]);
            index++;
        }
        reloadComponents();
    }

    public void loadPermissionOfPosition(PositionDTO positionDTO) {
        Vector<PosPermissionDTO> listPosPer = posPermissionBLL.getPermissionByPosId(positionDTO.getId_positions());
        int index = 0;
        for (JCheckBox checkItem : checkboxPer) {
            for (PosPermissionDTO posPermissionDTO : listPosPer) {
                String check_id_permission = String.valueOf(checkItem.getClientProperty("checkbox_id_permission"));
                if (check_id_permission.equals(posPermissionDTO.getPermissionDTO().getId_permission())) {
                    checkboxPer[index].setSelected(true);
                }
            }
            index++;
        }
    }

    public void reloadComponents() {
        this.repaint();
        this.revalidate();
    }
}
