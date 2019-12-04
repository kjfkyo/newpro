package com.gy.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gy.bean.S_course;
import com.gy.bean.S_teacher;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourseFrame extends JInternalFrame {
	private JTextField nameTextField;
	private JTextField numTextField;
	private JComboBox comboBox;
	private JTextArea infoTextArea;
	/**
	 * Create the frame.
	 */
	public AddCourseFrame() {
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B\u4FE1\u606F");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 349, 421);
		
		JLabel label = new JLabel("\u6388\u8BFE\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_2.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u4EBA\u6570.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label_3.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u4ECB\u7ECD.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		comboBox = new JComboBox();
		
		numTextField = new JTextField();
		numTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton submitButton = new JButton("\u63D0    \u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCourseInfo(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD    \u7F6E");
		resetButton.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(resetButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numTextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(numTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(27))
		);
		
		infoTextArea = new JTextArea();
		infoTextArea.setLineWrap(true);
		scrollPane.setViewportView(infoTextArea);
		getContentPane().setLayout(groupLayout);
		initCombobox();
	} 
	protected void addCourseInfo(ActionEvent arg0) {
		String name=nameTextField.getText().toString();
		name=Tools.isEmpty(name);
		String max_student_num=numTextField.getText().toString();
		max_student_num=Tools.isEmpty(max_student_num);
		S_teacher teacherId=(S_teacher)comboBox.getSelectedItem();
		String info=infoTextArea.getText().toString();
		info=Tools.isEmpty(info);
		if(name!="" && max_student_num!="" && info!=""){
			if(Tools.isNumber(max_student_num)){
				if(teacherId.getId()!=0){
					S_course sc=new S_course(name, teacherId, 
							Integer.parseInt(max_student_num), info, 0);
					if(LoginFrame.ssd.addCourseInfo(sc)>0){
						JOptionPane.showMessageDialog(this, "添加成功！");
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(this, "未知错误！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "请选择授课教师！");
				}
			}else{
				JOptionPane.showMessageDialog(this, "人数必须是数值！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "不能有空值！");
		}
	}
	private void initCombobox(){
		List<S_teacher> list=LoginFrame.td.selectTeacherAll();
		S_teacher st=new S_teacher(0, "==请选择==", "", "", 0, "");
		comboBox.addItem(st);
		for(S_teacher t:list){
			comboBox.addItem(t);
		}
	}
}
