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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

import com.gy.bean.S_class;
import com.gy.bean.S_student;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentMessageFrame extends JInternalFrame {
	private JTextField searchTextField;
	private JTable table;
	private JTextField nameTextField;
	private JPasswordField passwordField;
	private JComboBox searchComboBox;
	private JComboBox classComboBox;
	private ButtonGroup bg;
	private int id=0;
	private JButton searchButton;
	private JButton removeButton;
	/**
	 * Create the frame.
	 */
	public StudentMessageFrame() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u5217\u8868");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 629, 454);
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\uFF1A");
		label.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		
		searchComboBox = new JComboBox();
		
		searchButton = new JButton("\u67E5  \u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchStudent(arg0);
			}
		});
		searchButton.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FE1\u606F\u7F16\u8F91", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchButton)
						.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		
		JLabel label_2 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_2.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		classComboBox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		
		JLabel label_4 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_4.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		
		JRadioButton radioButton_2 = new JRadioButton("\u4FDD\u5BC6");
		
		passwordField = new JPasswordField();
		
		JButton modifyButton = new JButton("\u4FEE\u6539");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifyStudentInfo(arg0);
			}
		});
		modifyButton.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		
		removeButton = new JButton("\u5220\u9664");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeStudentById(arg0);
			}
		});
		removeButton.setIcon(new ImageIcon(StudentMessageFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(classComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radioButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radioButton_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(modifyButton)
						.addComponent(removeButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(radioButton)
						.addComponent(radioButton_1)
						.addComponent(radioButton_2)
						.addComponent(modifyButton))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(classComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(removeButton))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modifyOrRemove(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u6027\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
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
		initCombobox(searchComboBox);
		initCombobox(classComboBox);
		initTable();
		setAuthority();
	}
	private void setAuthority(){
		if(LoginFrame.userType.toString().equals("学生")){
			searchComboBox.setEnabled(false);
			searchButton.setEnabled(false);
			classComboBox.setEnabled(false);
			removeButton.setEnabled(false);
		}
	}
	protected void removeStudentById(ActionEvent arg0) {
		if(this.id!=0){
			if(JOptionPane.showConfirmDialog(this, "确定要删除吗？")==JOptionPane.OK_OPTION){
				if(LoginFrame.sd.removeStudentById(id)>0){
					JOptionPane.showMessageDialog(this, "删除成功！");
					initTable();
				}else{
					JOptionPane.showMessageDialog(this, "未知错误!");
				}
			}
			clearInfo();
		}else{
			JOptionPane.showMessageDialog(this, "没有选择要删除的数据");
		}
	}
	protected void modifyStudentInfo(ActionEvent arg0) {
		if(this.id!=0){
			String name=nameTextField.getText().toString();
			name=Tools.isEmpty(name);
			String password=new String(passwordField.getPassword());
			password=Tools.isEmpty(password);
			String sex="";
			Enumeration<AbstractButton> e=bg.getElements();
			while(e.hasMoreElements()){
				AbstractButton btn=e.nextElement();
				if(btn.isSelected()){
					sex=btn.getText().toString();
					break;
				}
			}
			S_class classId=(S_class)classComboBox.getSelectedItem();
			if(name!="" && password!=""){
				if(classId.getId()!=0){
					S_student stu=new S_student(id, name, classId, password, sex);
					if(LoginFrame.sd.modifyStudentInfo(stu)>0){
						JOptionPane.showMessageDialog(this, "修改成功！");
						initTable();
						clearInfo();
					}else{
						JOptionPane.showMessageDialog(this, "未知错误！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "没有选择班级！");
				}
			}else{
				JOptionPane.showMessageDialog(this, "姓名和密码不能为空！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "没有选择要修改的数据");
		}
	}
	protected void modifyOrRemove(MouseEvent arg0) {
		if(arg0.getClickCount()==1){
			int row=((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
			id=(Integer)table.getValueAt(row, 0);
			S_student stu=LoginFrame.sd.selectStudentById(id);
			nameTextField.setText(stu.getName());
			passwordField.setText(stu.getPassword());
			Enumeration<AbstractButton> e=bg.getElements();
			while(e.hasMoreElements()){
				AbstractButton btn=e.nextElement();
				if(btn.getText().equals(stu.getSex())){
					btn.setSelected(true);
					break;
				}
			}
			for(int i=0;i<classComboBox.getItemCount();i++){
				S_class c=(S_class)classComboBox.getItemAt(i);
				if(c.getId()==stu.getClassId().getId()){
					classComboBox.setSelectedItem(c);
					break;
				}
			}
		}
	}
	protected void searchStudent(ActionEvent arg0) {
		String txt=searchTextField.getText().toString();
		txt=Tools.isEmpty(txt);
		S_class c=(S_class)searchComboBox.getSelectedItem();
		if(txt=="" && c.getId()==0){
			initTable();
		}else if(txt=="" && c.getId()!=0){
			List<S_student> list=LoginFrame.sd.selectStudentByParam(c.getId(), 0, "");
			initTable2(list);
		}else if(Tools.isNumber(txt) && c.getId()==0){
			List<S_student> list=LoginFrame.sd.selectStudentByParam(0, Integer.parseInt(txt), "");
			initTable2(list);
		}else if(Tools.isNumber(txt) && c.getId()!=0){
			List<S_student> list=LoginFrame.sd.selectStudentByParam(c.getId(), Integer.parseInt(txt), "");
			initTable2(list);
		}else if(txt!="" && c.getId()==0){
			List<S_student> list=LoginFrame.sd.selectStudentByParam(0, 0, txt);
			initTable2(list);
		}else if(txt!="" && c.getId()!=0){
			List<S_student> list=LoginFrame.sd.selectStudentByParam(c.getId(), 0, txt);
			initTable2(list);
		}
	}
	private void initCombobox(JComboBox comboBox){
		S_class c=new S_class(0, "==请选择==", "");
		comboBox.addItem(c);
		List<S_class> list=LoginFrame.scd.selectSclassAll();
		for(S_class sc :list){
			comboBox.addItem(sc);
		}
	}
	private void initTable(){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		List<S_student> list=new ArrayList<S_student>();
		if(LoginFrame.userType.toString().equals("学生")){
			S_student s=(S_student)LoginFrame.userObject;
			list.add(s);
		}else{
			list=LoginFrame.sd.selectStudentAll();
		}
		for(S_student stu:list){
			Vector v=new Vector();
			v.add(stu.getId());
			v.add(stu.getName());
			v.add(stu.getClassId());
			v.add(stu.getSex());
			dtm.addRow(v);
		}
	}
	private void initTable2(List<S_student> list){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_student stu:list){
			Vector v=new Vector();
			v.add(stu.getId());
			v.add(stu.getName());
			v.add(stu.getClassId());
			v.add(stu.getSex());
			dtm.addRow(v);
		}
	}
	private void clearInfo(){
		nameTextField.setText("");
		passwordField.setText("");
		Enumeration<AbstractButton> e=bg.getElements();
		while(e.hasMoreElements()){
			AbstractButton btn=e.nextElement();
			btn.setSelected(true);
			break;
		}
		classComboBox.setSelectedIndex(0);
		this.id=0;
		table.clearSelection();
	}
}
