package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gy.bean.S_attendance;
import com.gy.bean.S_course;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;
import com.gy.dao.SattendanceDao;
import com.gy.dao.impl.SattendanceDaoImpl;
import com.gy.tools.Chooser;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAttendanceFrame extends JInternalFrame {
	private JTextField attendanceDateTextField;
	private JTable table;
	private JComboBox attendanceCourseComboBox;
	private JButton attendanceButton;
	private JComboBox courseComboBox;
	private S_student stu=(S_student)LoginFrame.userObject;
	public static SattendanceDao sd=new SattendanceDaoImpl();
	/**
	 * Create the frame.
	 */
	public AddAttendanceFrame() {
		setTitle("\u5B66\u751F\u7B7E\u5230\u7CFB\u7EDF");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 621, 440);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\uFF1A");
		label.setIcon(new ImageIcon(AddAttendanceFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		attendanceCourseComboBox = new JComboBox();
		
		attendanceButton = new JButton("\u786E\u8BA4\u7B7E\u5230");
		attendanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddAttendance(arg0);
			}
		});
		attendanceButton.setIcon(new ImageIcon(AddAttendanceFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		attendanceButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5DF2\u7B7E\u5230\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(label)
							.addGap(18)
							.addComponent(attendanceCourseComboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(attendanceButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(attendanceButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(attendanceCourseComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_1.setIcon(new ImageIcon(AddAttendanceFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		courseComboBox = new JComboBox();
		
		JLabel label_2 = new JLabel("\u65E5\u671F\uFF1A");
		label_2.setIcon(new ImageIcon(AddAttendanceFrame.class.getResource("/com/gy/image/\u65E5\u671F.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		attendanceDateTextField = new JTextField();
		attendanceDateTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchAttendance(arg0);
			}
		});
		searchButton.setIcon(new ImageIcon(AddAttendanceFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		searchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(attendanceDateTextField, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(attendanceDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B7E\u5230ID", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0", "\u7B7E\u5230\u65E5\u671F"
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
		initCombobox();
		Chooser.getInstance().register(attendanceDateTextField);
		initTable();
	}
	protected void searchAttendance(ActionEvent arg0) {
		S_course courseId=(S_course)courseComboBox.getSelectedItem();
		String date=attendanceDateTextField.getText().toString();
		date=Tools.isEmpty(date);
		if(courseId.getId()==-1 && date==""){
			initTable();
		}else{
			if(courseId.getId()==-1 && date!=""){
				List<S_attendance> list=sd.studentSearchAttendanceInfo(stu.getId(), 0, date);
				initTable2(list);
			}else if(date=="" && courseId.getId()!=-1){
				List<S_attendance> list=sd.studentSearchAttendanceInfo(stu.getId(), courseId.getId(), "");
				initTable2(list);
			}else if(date!="" && courseId.getId()!=-1){
				List<S_attendance> list=sd.studentSearchAttendanceInfo(stu.getId(), courseId.getId(), date);
				initTable2(list);
			}
		}
	}
	protected void AddAttendance(ActionEvent arg0) {
		S_course courseId=(S_course)attendanceCourseComboBox.getSelectedItem();
		if(courseId.getId()!=-1){
			S_attendance sa=new S_attendance(stu, courseId, Tools.dateToString(new Date()));
			if(LoginFrame.sda.addAttendanceInfo(sa)>0){
				JOptionPane.showMessageDialog(this, "Ç©µ½³É¹¦£¡");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "Î´Öª´íÎó£¡");
			}
		}else{
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÔñÇ©µ½¿Î³Ì£¡");
		}
	}
	private void initCombobox(){
		List<S_course> clist=LoginFrame.ssd.selectStudentCourseBySid(stu.getId());
		S_course sc=new S_course(-1, "==ÇëÑ¡Ôñ==", new S_teacher(), 0, "", 0);
		attendanceCourseComboBox.addItem(sc);
		courseComboBox.addItem(sc);
		for(S_course c:clist){
			attendanceCourseComboBox.addItem(c);
			courseComboBox.addItem(c);
		}
	}
	private void initTable(){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		List<S_attendance> list=sd.selectAttendanceBySid(stu.getId());
		for(S_attendance sa:list){
			Vector v=new Vector();
			v.add(sa.getId());
			v.add(sa.getStudentId());
			v.add(sa.getCourseId());
			v.add(sa.getAttendance_date());
			dtm.addRow(v);
		}
	}
	private void initTable2(List<S_attendance> list){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_attendance sa:list){
			Vector v=new Vector();
			v.add(sa.getId());
			v.add(sa.getStudentId());
			v.add(sa.getCourseId());
			v.add(sa.getAttendance_date());
			dtm.addRow(v);
		}
	}
}
