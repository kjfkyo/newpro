package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.gy.bean.S_teacher;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class AddTeacherFrame extends JInternalFrame {
	private JTextField nameTextField;
	private JPasswordField passwordField;
	private JTextField titleTextField;
	private JTextField ageTextField;
	private ButtonGroup bg;

	/**
	 * Create the frame.
	 */
	public AddTeacherFrame() {
		setTitle("\u6DFB\u52A0\u6559\u5E08\u4FE1\u606F");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 339, 423);
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_1.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u6027\u522B.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_3.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u804C\u79F0\u8BC4\u5B9A.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label_4.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u5E74\u9F84.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		
		JRadioButton radioButton_2 = new JRadioButton("\u4FDD\u5BC6");
		
		passwordField = new JPasswordField();
		
		titleTextField = new JTextField();
		titleTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u63D0   \u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addTeacherInfo(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD    \u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValues(arg0);
			}
		});
		resetButton.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ageTextField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radioButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioButton_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioButton_2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(titleTextField))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(passwordField))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetButton)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(radioButton)
						.addComponent(radioButton_1)
						.addComponent(radioButton_2))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(ageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);
		bg=new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
	}

	protected void addTeacherInfo(ActionEvent arg0) {
		String name=nameTextField.getText().toString();
		name=Tools.isEmpty(name);
		String password=new String(passwordField.getPassword());
		password=Tools.isEmpty(password);
		String title=titleTextField.getText().toString();
		title=Tools.isEmpty(title);
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
		if(Tools.isNotNull(name) && Tools.isNotNull(password) && Tools.isNotNull(title) && Tools.isNotNull(txt)){
			if(Tools.isNumber(txt)){
				S_teacher t=new S_teacher(name, sex, title, Integer.parseInt(txt), password);
				if(LoginFrame.td.addTeacherInfo(t)>0){
					JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦£¡");
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this, "Î´Öª´íÎó£¡");
				}
			}else{
				JOptionPane.showMessageDialog(this, "ÄêÁä±ØÐëÊÇÊýÖµ£¡");
			}
		}else{
			JOptionPane.showMessageDialog(this, "²»ÄÜÓÐ¿ÕÖµ£¡");
		}
	}

	protected void resetValues(ActionEvent arg0) {
		nameTextField.setText("");
		passwordField.setText("");
		titleTextField.setText("");
		ageTextField.setText("");
		Enumeration<AbstractButton> e=bg.getElements();
		AbstractButton btn=e.nextElement();
		btn.setSelected(true);
	}
}
