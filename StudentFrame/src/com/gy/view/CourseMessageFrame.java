package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

import com.gy.bean.S_course;
import com.gy.bean.S_teacher;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseMessageFrame extends JInternalFrame {
	private JTextField searchTextField;
	private JTable table;
	private JTextField nameTextField;
	private JTextField maxNumTextField;
	private JComboBox searchComboBox;
	private JComboBox teacherComboBox;
	private JTextArea infoTextArea;
	private int ids=0;
	private int maxStudentNum=0;
	private JButton searchButton;
	
	/**
	 * Create the frame.
	 */
	public CourseMessageFrame() {
		setTitle("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 676, 474);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u4FE1\u606F\uFF1A");
		label.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchComboBox = new JComboBox();
		
		searchButton = new JButton("\u67E5  \u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchMethod(arg0);
			}
		});
		searchButton.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8BFE\u7A0B\u7F16\u8F91", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton)))
					.addGap(59))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label_2.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6700\u5927\u4EBA\u6570\uFF1A");
		label_3.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u4EBA\u6570.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		maxNumTextField = new JTextField();
		maxNumTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		label_4.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label_5.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u4ECB\u7ECD.png")));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherComboBox = new JComboBox();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton modifyButton = new JButton("\u4FEE  \u6539");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifyMethod(arg0);
			}
		});
		modifyButton.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		
		JButton removeButton = new JButton("\u5220  \u9664");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeCourse(arg0);
			}
		});
		removeButton.setIcon(new ImageIcon(CourseMessageFrame.class.getResource("/com/gy/image/\u5220\u9664.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maxNumTextField))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(modifyButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(removeButton)))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teacherComboBox, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(teacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(maxNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(modifyButton)
								.addComponent(removeButton)))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		infoTextArea = new JTextArea();
		infoTextArea.setLineWrap(true);
		scrollPane_1.setViewportView(infoTextArea);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modifyRoRemove(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u6559\u5E08", "\u6700\u5927\u4EBA\u6570", "\u8BFE\u7A0B\u4ECB\u7ECD"
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
		initCombobox(searchComboBox);
		initCombobox(teacherComboBox);
		initTable();
		setAuthority();
	}
	private void setAuthority(){
		if(LoginFrame.userType.equals("教师")){
			searchButton.setEnabled(false);
			searchComboBox.setEnabled(false);
			teacherComboBox.setEnabled(false);
		}
	}
	protected void removeCourse(ActionEvent arg0) {
		if(this.ids!=0){
			if(JOptionPane.showConfirmDialog(this, "确定要删除吗？")==JOptionPane.OK_OPTION){
				if(LoginFrame.ssd.removeCourseById(ids)>0){
					JOptionPane.showMessageDialog(this, "删除成功！");
					initTable();
				}else{
					JOptionPane.showMessageDialog(this, "未知错误！");
				}
			}
			clareSelected();
		}else{
			JOptionPane.showMessageDialog(this, "没有选择要删除的数据！");
		}
	}
	protected void modifyMethod(ActionEvent arg0) {
		if(ids!=0){
			String name=nameTextField.getText().toString();
			name=Tools.isEmpty(name);
			String max=maxNumTextField.getText().toString();
			max=Tools.isEmpty(max);
			S_teacher teacherId=(S_teacher)teacherComboBox.getSelectedItem();
			String info=infoTextArea.getText().toString();
			info=Tools.isEmpty(info);
			if(name!="" && max!="" && info!=""){
				if(Tools.isNumber(max)){
					int max_student_num=Integer.parseInt(max);
					if(max_student_num>=maxStudentNum){
						if(teacherId.getId()!=0){
							S_course c=new S_course(ids, name, teacherId, max_student_num, info, 0);
							if(LoginFrame.ssd.modifyCourseInfo(c)>0){
								JOptionPane.showMessageDialog(this, "修改成功！");
								clareSelected();
								initTable();
							}else{
								JOptionPane.showMessageDialog(this, "未知错误！");
							}
						}else{
							JOptionPane.showMessageDialog(this, "请选择授课教师！");
						}
					}else{
						JOptionPane.showMessageDialog(this, "修改的人数必须大于或等于原有人数！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "人数必须是数值！");
				}
			}else{
				JOptionPane.showMessageDialog(this, "数据不能为空！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "没有选择要修改的数据！");
		}
	}
	protected void modifyRoRemove(MouseEvent arg0) {
		if(arg0.getClickCount()==1){
			int row=((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
			ids=(Integer)table.getValueAt(row, 0);
			S_course sc=LoginFrame.ssd.selectCourseById(ids);
			nameTextField.setText(sc.getName());
			maxStudentNum=sc.getMax_student_num();
			maxNumTextField.setText(sc.getMax_student_num()+"");
			for(int i=0;i<teacherComboBox.getItemCount();i++){
				S_teacher st=(S_teacher)teacherComboBox.getItemAt(i);
				if(st.getId()==sc.getTeacherId().getId()){
					teacherComboBox.setSelectedItem(st);
					break;
				}
			}
			infoTextArea.setText(sc.getInfo());
		}
	}
	protected void searchMethod(ActionEvent arg0) {
		String txt=searchTextField.getText().toString();
		txt=Tools.isEmpty(txt);
		S_teacher sc=(S_teacher)searchComboBox.getSelectedItem();
		if(txt=="" && sc.getId()==0){
			initTable();
		}else if(txt=="" && sc.getId()!=0){
			List<S_course> list=LoginFrame.ssd.searchCourseInfo(0, "", sc.getId());
			initTable2(list);
		}else if(Tools.isNumber(txt) && sc.getId()==0){
			List<S_course> list=LoginFrame.ssd.searchCourseInfo(Integer.parseInt(txt), "", 0);
			initTable2(list);
		}else if(Tools.isNumber(txt) && sc.getId()!=0){
			List<S_course> list=LoginFrame.ssd.searchCourseInfo(Integer.parseInt(txt), "", sc.getId());
			initTable2(list);
		}else if(txt!="" && sc.getId()==0){
			List<S_course> list=LoginFrame.ssd.searchCourseInfo(0, txt, 0);
			initTable2(list);
		}else if(txt!="" && sc.getId()!=0){
			List<S_course> list=LoginFrame.ssd.searchCourseInfo(0, txt, sc.getId());
			initTable2(list);
		}
	}
	private void initCombobox(JComboBox comboBox){
		S_teacher sc=new S_teacher(0, "==请选择==", "", "", 0, "");
		comboBox.addItem(sc);
		List<S_teacher> list=new ArrayList<S_teacher>();
		if(LoginFrame.userType.toString().equals("教师")){
			S_teacher st=(S_teacher)LoginFrame.userObject;
			list.add(st);
		}else{
			list=LoginFrame.td.selectTeacherAll();
		}
		for(S_teacher c:list){
			comboBox.addItem(c);
		}
	}
	private void initTable(){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		List<S_course> list=new ArrayList<S_course>();
		if(LoginFrame.userType.toString().equals("教师")){
			S_teacher st=(S_teacher)LoginFrame.userObject;
			list=LoginFrame.ssd.searchCourseInfo(0, "", st.getId());
		}else{
			list=LoginFrame.ssd.selectCourseAll();
		}
		for(S_course sc:list){
			Vector v=new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getTeacherId());
			v.add(sc.getMax_student_num());
			v.add(sc.getInfo());
			dtm.addRow(v);
		}
	}
	private void initTable2(List<S_course> list){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_course sc:list){
			Vector v=new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getTeacherId());
			v.add(sc.getMax_student_num());
			v.add(sc.getInfo());
			dtm.addRow(v);
		}
	}
	private void clareSelected(){
		nameTextField.setText("");
		maxNumTextField.setText("");
		teacherComboBox.setSelectedIndex(0);
		infoTextArea.setText("");
		this.ids=0;
		this.maxStudentNum=0;
		table.clearSelection();
	}
}
