package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import Connect.*;
import Class.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Table extends JFrame {

	private JPanel contentPane;
	private JTable tabelAccount;
	private JTextField IdAccount;
	private JTextField nameAccount;
	private JTextField passAccount;
	private JTextField PhoneAccount;
	private JTextField dateAccount;
	private Vector DataVector;
	private Vector HeaderTable;
	private Connect connect = new Connect();
	private final JLabel lblMtKhu_1 = new JLabel("Mật Khẩu");
	private DefaultTableModel modelAccount;
	private JTextField EmailAccount;
	private JTextField addressAccount;
	private JTextField CMNDAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DataVector = new Vector();
		DataVector = connect.getUser();
		HeaderTable= new Vector();
		HeaderTable.add("Id");
		HeaderTable.add("Tên");
		HeaderTable.add("Email");
		HeaderTable.add("Mật khẩu");
		HeaderTable.add("Vai trò");
		HeaderTable.add("Số điện");
		HeaderTable.add("Địa chỉ");
		HeaderTable.add("CMND");
		HeaderTable.add("Ngày sinh");
		
		modelAccount = new DefaultTableModel(DataVector, HeaderTable);
		setBounds(100, 100, 1017, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 30, 953, 615);
		contentPane.add(tabbedPane);
		
		JPanel Panel1 = new JPanel();
		tabbedPane.addTab("Tài khoản", null, Panel1, null);
		Panel1.setLayout(null);
		
		JScrollPane PanelAccont = new JScrollPane();
		PanelAccont.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		PanelAccont.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelAccont.setBounds(10, 11, 914, 260);
		Panel1.add(PanelAccont);
		
		tabelAccount = new JTable();
		
		tabelAccount.setModel(modelAccount);
		PanelAccont.setViewportView(tabelAccount);
		
		IdAccount = new JTextField();
		IdAccount.setBounds(50, 300, 245, 46);
		Panel1.add(IdAccount);
		IdAccount.setColumns(10);
		
		nameAccount = new JTextField();
		nameAccount.setColumns(10);
		nameAccount.setBounds(345, 300, 245, 46);
		Panel1.add(nameAccount);
		
		passAccount = new JTextField();
		passAccount.setColumns(10);
		passAccount.setBounds(640, 300, 245, 46);
		Panel1.add(passAccount);
		
		PhoneAccount = new JTextField();
		PhoneAccount.setColumns(10);
		PhoneAccount.setBounds(640, 380, 245, 46);
		Panel1.add(PhoneAccount);
		
		dateAccount = new JTextField();
		dateAccount.setColumns(10);
		dateAccount.setBounds(345, 380, 245, 46);
		Panel1.add(dateAccount);
		
		JButton addAccountButton = new JButton("Thêm Tài khoản");
		addAccountButton.setBounds(50, 513, 245, 46);
		Panel1.add(addAccountButton);
		
		JButton editAccountButton = new JButton("Sửa Tài Khoản");
		editAccountButton.setBounds(345, 513, 245, 46);
		Panel1.add(editAccountButton);
		
		JButton deleteAccountButton = new JButton("Xóa Tài Khoản");
		deleteAccountButton.setBounds(640, 513, 245, 46);
		Panel1.add(deleteAccountButton);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(50, 282, 46, 14);
		Panel1.add(lblNewLabel);
		
		JLabel lblTn = new JLabel("Tên");
		lblTn.setBounds(345, 282, 46, 14);
		Panel1.add(lblTn);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu");
		lblMtKhu.setBounds(639, 282, 46, 14);
		Panel1.add(lblMtKhu);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(50, 357, 46, 14);
		Panel1.add(lblNewLabel_1);
		String ruleAccount[] = { "admin", "guest" };
		JComboBox RoleAccount = new JComboBox(ruleAccount);
		RoleAccount.setBounds(50, 380, 245, 46);
		Panel1.add(RoleAccount);
		
		EmailAccount = new JTextField();
		EmailAccount.setColumns(10);
		EmailAccount.setBounds(50, 456, 245, 46);
		Panel1.add(EmailAccount);
		
		addressAccount = new JTextField();
		addressAccount.setColumns(10);
		addressAccount.setBounds(345, 456, 245, 46);
		Panel1.add(addressAccount);
		
		CMNDAccount = new JTextField();
		CMNDAccount.setColumns(10);
		CMNDAccount.setBounds(640, 456, 245, 46);
		Panel1.add(CMNDAccount);
		tabelAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel tm = tabelAccount.getModel();
				IdAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 0));
				passAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 3));
				EmailAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 2));
				PhoneAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 5));
				nameAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 1));
				RoleAccount.setSelectedItem((String)tm.getValueAt(tabelAccount.getSelectedRow(), 4));
				dateAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 8));
				addressAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 6));
				CMNDAccount.setText((String)tm.getValueAt(tabelAccount.getSelectedRow(), 7));
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
