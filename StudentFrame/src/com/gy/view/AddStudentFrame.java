package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.gy.bean.S_class;
import com.gy.bean.S_student;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentFrame extends JInternalFrame {
	private JTextField nameTextField;
	private JPasswordField passwordField;
	private JComboBox classComboBox;
	private ButtonGroup bg;

	/**
	 * Create the frame.
	 */
	public AddStudentFrame() {
		setTitle("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 410, 344);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/password.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		classComboBox = new JComboBox();
		
		passwordField = new JPasswordField();
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		
		JRadioButton radioButton_2 = new JRadioButton("\u4FDD\u5BC6");
		
		JButton submitButton = new JButton("\u786E  \u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStudentInfo(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD  \u7F6E");
		resetButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(classComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioButton)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(resetButton)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(radioButton_1)
											.addGap(18)
											.addComponent(radioButton_2))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(submitButton)))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(classComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(radioButton)
						.addComponent(radioButton_1)
						.addComponent(radioButton_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		bg=new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_2);
		bg.add(radioButton_1);
		initCombobox();
	}
	protected void addStudentInfo(ActionEvent arg0) {
		String name=nameTextField.getText().toString();
		name=Tools.isEmpty(name);
		String password=new String(passwordField.getPassword());
		password=Tools.isEmpty(password);
		S_class classId=(S_class)classComboBox.getSelectedItem();
		String sex="";
		Enumeration<AbstractButton> e=bg.getElements();
		while(e.hasMoreElements()){
			AbstractButton btn=e.nextElement();
			if(btn.isSelected()){
				sex=btn.getText().toString();
				break;
			}
		}
		if(Tools.isNotNull(name) && Tools.isNotNull(password)){
			if(classId.getId()!=0){
				S_student stu=new S_student(name, classId, password, sex);
				if(LoginFrame.sd.addStudentInfo(stu)>0){
					JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦£¡");
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this, "Î´Öª´íÎó£¡");
				}
			}else{
				JOptionPane.showMessageDialog(this, "ÇëÑ¡ÔñÒª¼ÓÈëµÄ°à¼¶£¡");
			}
		}else{
			JOptionPane.showMessageDialog(this, "ÓÃ»§Ãû»òÕßÃÜÂë²»ÄÜÎª¿Õ£¡");
		}
	}
	private void initCombobox(){
		List<S_class> list=LoginFrame.scd.selectSclassAll();
		S_class cs=new S_class(0, "==ÇëÑ¡Ôñ°à¼¶==", "");
		classComboBox.addItem(cs);
		for(S_class c:list){
			classComboBox.addItem(c);
		}
	}
}
