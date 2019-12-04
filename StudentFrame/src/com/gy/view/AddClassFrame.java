package com.gy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.gy.bean.S_class;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClassFrame extends JInternalFrame {
	private JTextField textField;
	private JTextArea textArea;
	/**
	 * Create the frame.
	 */
	public AddClassFrame() {
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 374, 280);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton submitButton = new JButton("\u63D0  \u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addClassMethod(arg0);
			}
		});
		submitButton.setIcon(new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD  \u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetVlues(arg0);
			}
		});
		resetButton.setIcon(new ImageIcon(AddClassFrame.class.getResource("/com/gy/image/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetButton)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);

	}
	
	protected void addClassMethod(ActionEvent arg0) {
		String name=textField.getText().toString();
		name=Tools.isEmpty(name);
		String info=textArea.getText().toString();
		info=Tools.isEmpty(info);
		if(Tools.isNotNull(name) && Tools.isNotNull(info)){
			S_class sc=new S_class(name, info);
			if(LoginFrame.scd.addClassInfo(sc)>0){
				JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦£¡");
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "Î´Öª´íÎó£¡");
			}
		}else{
			JOptionPane.showMessageDialog(this, "²»ÄÜÓÐ¿ÕÖµ£¡");
		}
	}

	protected void resetVlues(ActionEvent arg0) {
		textField.setText("");
		textArea.setText("");
	}
}
