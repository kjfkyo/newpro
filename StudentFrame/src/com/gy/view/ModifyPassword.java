package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.gy.bean.S_admin;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyPassword extends JInternalFrame {
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField againPasswordField;
	private JLabel userName;

	/**
	 * Create the frame.
	 */
	public ModifyPassword() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 359, 390);
		
		JLabel label = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label.setIcon(new ImageIcon(ModifyPassword.class.getResource("/com/gy/image/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u539F  \u5BC6  \u7801\uFF1A");
		label_1.setIcon(new ImageIcon(ModifyPassword.class.getResource("/com/gy/image/\u5BC6\u7801.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u65B0  \u5BC6  \u7801\uFF1A");
		label_2.setIcon(new ImageIcon(ModifyPassword.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(ModifyPassword.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userName = new JLabel("");
		
		oldPasswordField = new JPasswordField();
		
		newPasswordField = new JPasswordField();
		
		againPasswordField = new JPasswordField();
		
		JButton submitButton = new JButton("\u63D0    \u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifyPWD(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(ModifyPassword.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD    \u7F6E");
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		resetButton.setIcon(new ImageIcon(ModifyPassword.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(againPasswordField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(newPasswordField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(6)
							.addComponent(userName)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userName))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(againPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addGap(33))
		);
		getContentPane().setLayout(groupLayout);
		initLable();
	}
	protected void modifyPWD(ActionEvent arg0) {
		String oldpwd=new String(oldPasswordField.getPassword());
		oldpwd=Tools.isEmpty(oldpwd);
		String newPwd=new String(newPasswordField.getPassword());
		newPwd=Tools.isEmpty(newPwd);
		String againPwd=new String(againPasswordField.getPassword());
		againPwd=Tools.isEmpty(againPwd);
		if(Tools.isNotNull(oldpwd) && Tools.isNotNull(newPwd) && Tools.isNotNull(againPwd)){
			if(LoginFrame.userType.getName().equals("系统管理员")){
				S_admin sa=(S_admin)LoginFrame.userObject;
				if(sa.getPassword().equals(oldpwd)){
					if(newPwd.equals(againPwd)){
						if(LoginFrame.ad.modifyPassword(sa.getId(), newPwd)>0){
							JOptionPane.showMessageDialog(this, "修改成功！");
							this.dispose();
						}else{
							JOptionPane.showMessageDialog(this, "未知错误！");
						}
					}else{
						JOptionPane.showMessageDialog(this, "两次密码不一致！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "原密码错误！");
				}
			}else if(LoginFrame.userType.getName().equals("教师")){
				S_teacher st=(S_teacher)LoginFrame.userObject;
				if(st.getPassword().equals(oldpwd)){
					if(newPwd.equals(againPwd)){
						if(LoginFrame.sd.modifyPassword(st.getId(), newPwd)>0){
							JOptionPane.showMessageDialog(this, "修改成功！");
							this.dispose();
						}else{
							JOptionPane.showMessageDialog(this, "未知错误！");
						}
					}else{
						JOptionPane.showMessageDialog(this, "两次密码不一致！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "原密码错误！");
				}
			}else{
				S_student ss=(S_student)LoginFrame.userObject;
				if(ss.getPassword().equals(oldpwd)){
					if(newPwd.equals(againPwd)){
						if(LoginFrame.sd.modifyPassword(ss.getId(), newPwd)>0){
							JOptionPane.showMessageDialog(this, "修改成功！");
							this.dispose();
						}else{
							JOptionPane.showMessageDialog(this, "未知错误！");
						}
					}else{
						JOptionPane.showMessageDialog(this, "两次密码不一致！");
					}
				}else{
					JOptionPane.showMessageDialog(this, "原密码错误！");
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, "不能为空值！");
		}
	}
	private void initLable(){
		String info=LoginFrame.userType.getName();
		if(LoginFrame.userType.getName().equals("系统管理员")){
			S_admin sa=(S_admin)LoginFrame.userObject;
			userName.setText(info+":"+sa.getName());
		}else if(LoginFrame.userType.getName().equals("教师")){
			S_teacher st=(S_teacher)LoginFrame.userObject;
			userName.setText(info+":"+st.getName());
		}else{
			S_student ss=(S_student)LoginFrame.userObject;
			userName.setText(info+":"+ss.getName());
		}
	}
}
