package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import com.gy.bean.S_teacher;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherMessageFrame extends JInternalFrame {
	private JTextField searchTextField;
	private JTable table;
	private JTextField nameTextField;
	private JTextField titleTextField;
	private JPasswordField passwordField;
	private JTextField ageTextField;
	private ButtonGroup bg;
	private int ids=0;
	private JButton searchButton;

	/**
	 * Create the frame.
	 */
	public TeacherMessageFrame() {
		setTitle("\u6559\u5E08\u4FE1\u606F\u5217\u8868");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 608, 443);
		
		JLabel label = new JLabel("\u6559\u5E08\u4FE1\u606F\uFF1A");
		label.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		
		searchButton = new JButton("\u67E5    \u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchMethod(arg0);
			}
		});
		searchButton.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6559\u5E08\u4FE1\u606F\u7F16\u8F91", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))))
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_2.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u804C\u79F0\u8BC4\u5B9A.png")));
		
		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		titleTextField = new JTextField();
		titleTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		
		JLabel label_5 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label_5.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u5E74\u9F84.png")));
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		
		JRadioButton radioButton_2 = new JRadioButton("\u4FDD\u5BC6");
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		
		JButton modifyButton = new JButton("\u4FEE    \u6539");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifyMethod(arg0);
			}
		});
		modifyButton.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		
		JButton resetButton = new JButton("\u91CD    \u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValues();
			}
		});
		resetButton.setIcon(new ImageIcon(TeacherMessageFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(titleTextField))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radioButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radioButton_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(radioButton_2))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_5)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ageTextField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(modifyButton)
							.addGap(18)
							.addComponent(resetButton)))
					.addGap(27))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(radioButton)
						.addComponent(radioButton_1)
						.addComponent(radioButton_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(ageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(modifyButton)
						.addComponent(resetButton))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickeTable(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u804C\u79F0", "\u5E74\u9F84"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		bg=new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		initTable();
		setAuthority();
	}
	private void setAuthority(){
		if(LoginFrame.userType.toString().equals("教师")){
			searchButton.setEnabled(false);
		}
	}
	protected void modifyMethod(ActionEvent arg0) {
		if(ids!=0){
			String name=nameTextField.getText().toString();
			name=Tools.isEmpty(name);
			String title=titleTextField.getText().toString();
			title=Tools.isEmpty(title);
			String password=new String(passwordField.getPassword());
			password=Tools.isEmpty(password);
			String txt=ageTextField.getText().toString();
			txt=Tools.isEmpty(txt);
			String sex="";
			Enumeration<AbstractButton> e=bg.getElements();
			while(e.hasMoreElements()){
				AbstractButton btn=e.nextElement();
				if(btn.isSelected()){
					sex=btn.getText().toString();
					break;
				}
			}
			if(name!="" && title!="" && password!="" && txt!=""){
				if(Tools.isNumber(txt)){
					S_teacher t=new S_teacher(ids, name, sex, title, 
							Integer.parseInt(txt), password);
					if(LoginFrame.td.modifyTeacherInfo(t)>0){
						JOptionPane.showMessageDialog(this, "修改成功！");
						initTable();
						resetValues();
					}else{
						JOptionPane.showMessageDialog(this, "未知错误！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "年龄必须是数值！");
				}
			}else{
				JOptionPane.showMessageDialog(this, "不能有空值！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "没有选中要修改的数据！");
		}
	}
	protected void clickeTable(MouseEvent arg0) {
		if(arg0.getClickCount()==1){
			int row=((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
			ids=(Integer)table.getValueAt(row, 0);
			S_teacher t=LoginFrame.td.selectTeacherById(ids);
			nameTextField.setText(t.getName());
			titleTextField.setText(t.getTitle());
			passwordField.setText(t.getPassword());
			ageTextField.setText(t.getAge()+"");
			Enumeration<AbstractButton> e=bg.getElements();
			while(e.hasMoreElements()){
				AbstractButton btn=e.nextElement();
				if(btn.getText().equals(t.getSex())){
					btn.setSelected(true);
					break;
				}
			}
		}
	}
	protected void resetValues() {
		nameTextField.setText("");
		titleTextField.setText("");
		passwordField.setText("");
		ageTextField.setText("");
		Enumeration<AbstractButton> e=bg.getElements();
		AbstractButton btn=e.nextElement();
		btn.setSelected(true);
		table.clearSelection();
		this.ids=0;
	}
	protected void searchMethod(ActionEvent arg0) {
		String txt=searchTextField.getText().toString();
		txt=Tools.isEmpty(txt);
		if(txt==""){
			initTable();
		}else{
			if(Tools.isNumber(txt)){
				List<S_teacher> list=LoginFrame.td.selectTeacherSearch(Integer.parseInt(txt),"");
				initTable2(list);
			}else{
				List<S_teacher> list=LoginFrame.td.selectTeacherSearch(0,txt);
				initTable2(list);
			}
		}
	}
	private void initTable(){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		List<S_teacher> list=new ArrayList<S_teacher>();
		if(LoginFrame.userType.toString().equals("教师")){
			S_teacher st=(S_teacher)LoginFrame.userObject;
			list.add(st);
		}else{
			list=LoginFrame.td.selectTeacherAll();
		}
		for(S_teacher t:list){
			Vector v=new Vector();
			v.add(t.getId());
			v.add(t.getName());
			v.add(t.getSex());
			v.add(t.getTitle());
			v.add(t.getAge());
			dtm.addRow(v);
		}
	}
	private void initTable2(List<S_teacher> list){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_teacher t:list){
			Vector v=new Vector();
			v.add(t.getId());
			v.add(t.getName());
			v.add(t.getSex());
			v.add(t.getTitle());
			v.add(t.getAge());
			dtm.addRow(v);
		}
	}
}
