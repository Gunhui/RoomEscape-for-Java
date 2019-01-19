package RoomEscape;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class RoomEscapeRecord extends JFrame {

	private JPanel contentPane;
	RoomEscapeDAO dao = new RoomEscapeDAO();
	RoomEscape RE = new RoomEscape();
	private JTextField insertField;
	private JTextField deleteField;
	Vector v, cols;
	DefaultTableModel model;
	JTable table;
	JScrollPane pane;
	JButton insertButton, deleteButton;
	
	/**
	 * Create the frame.
	 */
	
	public RoomEscapeRecord() throws Exception {
		setTitle("ranking record");

		RoomEscapeDAO dao = new RoomEscapeDAO();

		v = dao.listGuests();
		cols = getColumn();

		model = new DefaultTableModel(v, cols);

		table = new JTable(model);
		pane = new JScrollPane(table);
		add(pane);

		setSize(600, 200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 916, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(24).addComponent(panel,
						GroupLayout.PREFERRED_SIZE, 380, Short.MAX_VALUE)));

		JLabel recordLabel = new JLabel("RECORD");
		recordLabel.setFont(new Font("굴림", Font.BOLD, 30));
		recordLabel.setHorizontalAlignment(SwingConstants.CENTER);

		insertButton = new JButton("\uB4F1\uB85D");
		insertButton.setFont(new Font("굴림", Font.BOLD, 23));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == insertButton) {
					RE.setName(insertField.getText());
					try {
						dao.insertGuest(RE);
						System.out.println("등록 성공!!");
						tableRefresh();
						insertField.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		insertButton.setFont(new Font("굴림", Font.BOLD, 23));

		deleteButton = new JButton("\uC0AD\uC81C");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteButton) {
					try {
						dao.deleteGuest(deleteField.getText());
						System.out.println("삭제성공!!");
						tableRefresh();
						deleteField.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		deleteButton.setFont(new Font("굴림", Font.BOLD, 23));

		insertField = new JTextField();
		insertField.setColumns(10);

		deleteField = new JTextField();
		deleteField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGap(73)
						.addComponent(pane, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addGap(349)
						.addComponent(recordLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(357, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(189, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false).addComponent(deleteField)
								.addComponent(insertField, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
						.addGap(62)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE))
						.addGap(157)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(recordLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(pane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(insertField).addComponent(
						insertButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(18).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(deleteField)
						.addComponent(deleteButton))
				.addGap(18)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public Vector getColumn() {
		Vector col = new Vector();

		col.add("이름");
		col.add("등록 날짜");
		col.add("점수");

		return col;
	}

	public void tableRefresh() {
		try {
			RoomEscapeDAO dao = new RoomEscapeDAO();
			DefaultTableModel model = new DefaultTableModel(dao.listGuests(), getColumn());

			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void invisible() {
		insertField.setVisible(false);
		deleteField.setVisible(false);
		insertButton.setVisible(false);
		deleteButton.setVisible(false);
	}
}
