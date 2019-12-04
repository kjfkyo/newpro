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
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.gy.bean.S_attendance;
import com.gy.bean.S_class;
import com.gy.bean.S_course;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttendanceMessageFrame extends JInternalFrame {
	private JTable table;
	private JComboBox studentComboBox;
	private JComboBox courseComboBox;
	private S_teacher st=(S_teacher)LoginFrame.userObject;
	private int aid=0;
	/**
	 * Create the frame.
	 */
	public AttendanceMessageFrame() {
		setTitle("\u7B7E\u5230\u5217\u8868\u4FE1\u606F\u7BA1\u7406");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 664, 404);
		
		JLabel label = new JLabel("\u5B66\u751F\uFF1A");
		label.setIcon(new ImageIcon(AttendanceMessageFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		studentComboBox = new JComboBox();
		studentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				selectedStudentCourse(arg0);
			}
		});
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_1.setIcon(new ImageIcon(AttendanceMessageFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		courseComboBox = new JComboBox();
		JButton saerchButton = new JButton("\u7B7E\u5230\u67E5\u8BE2");
		saerchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchAttendance(arg0);
			}
		});
		saerchButton.setIcon(new ImageIcon(AttendanceMessageFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		saerchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5DF2\u7B7E\u5230\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentComboBox, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(saerchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(studentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(saerchButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton deleteAttendanceButton = new JButton("\u6DFB\u52A0\u7F3A\u52E4");
		deleteAttendanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAttendance(arg0);
			}
		});
		deleteAttendanceButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteAttendanceButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(deleteAttendanceButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickTable(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B7E\u5230ID", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0", "\u7B7E\u5230\u65F6\u95F4"
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
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		initStudentCombobox();
		initTable();
	}
	protected void searchAttendance(ActionEvent arg0) {
		S_student stu=(S_student)studentComboBox.getSelectedItem();
		S_course sc=(S_course)courseComboBox.getSelectedItem();
		if(stu.getId()==-1 && sc.getId()==-1){
			initTable();
		}else{
			if(stu.getId()!=-1 && sc.getId()==-1){
				List<S_attendance> list=LoginFrame.sda.searchAttendanceByTidSidCid(st.getId(), stu.getId(), 0);
				initTable2(list);
			}else if(stu.getId()==-1 && sc.getId()!=-1){
				List<S_attendance> list=LoginFrame.sda.searchAttendanceByTidSidCid(st.getId(), 0, sc.getId());
				initTable2(list);
			}else if(stu.getId()!=-1 && sc.getId()!=-1){
				List<S_attendance> list=LoginFrame.sda.searchAttendanceByTidSidCid(st.getId(), stu.getId(), sc.getId());
				initTable2(list);
			}
		}
	}
	protected void removeAttendance(ActionEvent arg0) {
		if(aid!=0){
			if(JOptionPane.showConfirmDialog(this, "È·¶¨ÒªÉ¾³ýÂð£¿")==JOptionPane.OK_OPTION){
				if(LoginFrame.sda.removeAttendanceById(aid)>0){
					JOptionPane.showMessageDialog(this, "È±ÇÚ³É¹¦£¡");
					initTable();
					aid=0;
				}else{
					JOptionPane.showMessageDialog(this, "Î´Öª´íÎó£¡");
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, "Ã»ÓÐÑ¡ÔñÒªÈ±ÇÚµÄÊý¾Ý£¡");
		}
	}
	protected void clickTable(MouseEvent arg0) {
		if(arg0.getClickCount()==1){
			int row=((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
			aid=(Integer)table.getValueAt(row, 0);
		}
	}
	protected void selectedStudentCourse(ItemEvent arg0) {
		if(arg0.getStateChange()==ItemEvent.SELECTED){
			S_student stu=(S_student)studentComboBox.getSelectedItem();
			if(stu.getId()!=-1){
				List<S_course> list=LoginFrame.ssd.selectStudentCourseBySid(stu.getId());
				courseComboBox.removeAllItems();
				S_course ssc=new S_course(-1, "==ÇëÑ¡Ôñ==", new S_teacher(), 0, "", 0);
				courseComboBox.addItem(ssc);
				for(S_course sc:list){
					courseComboBox.addItem(sc);
				}
			}else{
				courseComboBox.removeAllItems();
				S_course ssc=new S_course(-1, "==ÇëÑ¡Ôñ==", new S_teacher(), 0, "", 0);
				courseComboBox.addItem(ssc);
			}
		}
	}
	private void initStudentCombobox(){
		List<S_student> list=LoginFrame.sd.selectStudentByTid(st.getId());
		S_student ss=new S_student(-1, "==ÇëÑ¡Ôñ==", new S_class(), "", "");
		studentComboBox.addItem(ss);
		for(S_student stu:list){
			studentComboBox.addItem(stu);
		}
	}
	private void initTable(){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		List<S_attendance> list=LoginFrame.sda.searchAttendanceByTid(st.getId());
		for(S_attendance as:list){
			Vector v=new Vector();
			v.add(as.getId());
			v.add(as.getStudentId());
			v.add(as.getCourseId());
			v.add(as.getAttendance_date());
			dtm.addRow(v);
		}
	}
	private void initTable2(List<S_attendance> list){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_attendance as:list){
			Vector v=new Vector();
			v.add(as.getId());
			v.add(as.getStudentId());
			v.add(as.getCourseId());
			v.add(as.getAttendance_date());
			dtm.addRow(v);
		}
	}
}
