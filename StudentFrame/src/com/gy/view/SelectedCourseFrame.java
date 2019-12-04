package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gy.bean.Data;
import com.gy.bean.S_course;
import com.gy.bean.S_selected_course;
import com.gy.bean.S_student;
import com.gy.dao.SclassDao;
import com.gy.dao.ScourseDao;
import com.gy.dao.SselectedCourseDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.impl.SclassDaoImpl;
import com.gy.dao.impl.ScourseDaoImpl;
import com.gy.dao.impl.SselectedCourseDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectedCourseFrame extends JInternalFrame {
	private JTable table;
	private JComboBox selectedStudentComboBox;
	private JComboBox selectCourseComboBox;
	private JComboBox modifyStudentComboBox;
	private JComboBox courseComboBox;
	private SstudentDao sd=new SstudentDaoImpl();
	private ScourseDao ssd=new ScourseDaoImpl();
	private SselectedCourseDao sscd=new SselectedCourseDaoImpl();
	/**
	 * Create the frame.
	 */
	public SelectedCourseFrame() {
		setTitle("\u9009\u4FEE\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 656, 458);
		
		JLabel label = new JLabel("\u5B66\u751F\uFF1A");
		label.setIcon(new ImageIcon(SelectedCourseFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		selectedStudentComboBox = new JComboBox();
		selectedStudentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				studentChangeAct(arg0);
			}
		});
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_1.setIcon(new ImageIcon(SelectedCourseFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		selectCourseComboBox = new JComboBox();
		
		JButton submitButton = new JButton("\u786E\u8BA4\u9009\u4FEE");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStudentCourse(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(SelectedCourseFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u9009\u8BFE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectedStudentComboBox, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectCourseComboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(submitButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(selectedStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(selectCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9009\u8BFE\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\uFF1A");
		label_2.setIcon(new ImageIcon(SelectedCourseFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		
		modifyStudentComboBox = new JComboBox();
		modifyStudentComboBox.setEnabled(false);
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_3.setIcon(new ImageIcon(SelectedCourseFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		
		courseComboBox = new JComboBox();
		
		JButton removeButton = new JButton("\u9000\u9009\u8BFE\u7A0B");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeCourse(arg0);
			}
		});
		removeButton.setIcon(new ImageIcon(SelectedCourseFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		removeButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(modifyStudentComboBox, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(68)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(199)
							.addComponent(removeButton)))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(modifyStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(removeButton)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setCombobox();
	}
	protected void removeCourse(ActionEvent arg0) {
		S_student stu=(S_student)modifyStudentComboBox.getSelectedItem();
		S_course sc=(S_course)courseComboBox.getSelectedItem();
		if(JOptionPane.showConfirmDialog(this, "确定要删除吗？")==JOptionPane.OK_OPTION){
			System.out.println(stu.getId()+","+sc.getId());
			if(sscd.removeSelectedCourse(stu.getId(), sc.getId())>0){
				JOptionPane.showMessageDialog(this, "删除成功！");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "未知错误！");
			}
		}
	}
	protected void addStudentCourse(ActionEvent arg0) {
		S_student stu=(S_student)selectedStudentComboBox.getSelectedItem();
		S_course sc=(S_course)selectCourseComboBox.getSelectedItem();
		if(sc!=null){
			S_selected_course ssc=new S_selected_course(stu, sc);
			if(LoginFrame.sscd.addSelectedCourse(ssc)>0){
				JOptionPane.showMessageDialog(this, "选修成功！");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "未知错误！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "没有可选修的科目");
		}
	}
	private void setCombobox(){
		List<S_student> slist=this.sd.selectStudentAll();
		if(LoginFrame.userType.toString().equals("学生")){
			S_student stu=(S_student)LoginFrame.userObject;
			selectedStudentComboBox.addItem(stu);
			modifyStudentComboBox.addItem(stu);
			selectedStudentComboBox.setEnabled(false);
		}else{
			for(S_student stu:slist){
				selectedStudentComboBox.addItem(stu);
				modifyStudentComboBox.addItem(stu);
			}
		}
		S_student stu=(S_student)selectedStudentComboBox.getSelectedItem();
		List<S_course> list1=this.ssd.selectStudentNotCourse(stu.getId());
		selectCourseComboBox.removeAllItems();
		for(S_course sc:list1){
			selectCourseComboBox.addItem(sc);
		}
		List<S_course> list2=this.ssd.selectStudentCourseBySid(stu.getId());
		courseComboBox.removeAllItems();
		for(S_course sc:list2){
			courseComboBox.addItem(sc);
		}
	}
	protected void studentChangeAct(ItemEvent arg0) {
		if(arg0.getStateChange()==ItemEvent.SELECTED){
			initTable();
		}
	}

	private void initTable() {
		S_student stu=(S_student)selectedStudentComboBox.getSelectedItem();
		SselectedCourseDao sscd2=new SselectedCourseDaoImpl();
		List<S_selected_course> clist=sscd2.selectSelectedCourseYes(stu.getId());
		setTable(clist);
		setSelected(stu);
	}

	private void setSelected(S_student stu) {
		for(int i=0;i<modifyStudentComboBox.getItemCount();i++){
			S_student s=(S_student)modifyStudentComboBox.getItemAt(i);
			if(s.getId()==stu.getId()){
				modifyStudentComboBox.setSelectedItem(s);
				break;
			}
		}
		ScourseDao ssd2=new ScourseDaoImpl();
		selectCourseComboBox.removeAllItems();
		List<S_course> clist=ssd2.selectStudentNotCourse(stu.getId());
		for(S_course sc:clist){
			selectCourseComboBox.addItem(sc);
		}
		courseComboBox.removeAllItems();
		List<S_course> clist2=ssd2.selectStudentCourseBySid(stu.getId());
		for(S_course sc:clist2){
			courseComboBox.addItem(sc);
		}
	}

	private void setTable(List<S_selected_course> clist) {
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_selected_course sc:clist){
			Vector v=new Vector();
			v.add(sc.getId());
			v.add(sc.getStudentId());
			v.add(sc.getCourseId());
			dtm.addRow(v);
		}
	}
	
}
