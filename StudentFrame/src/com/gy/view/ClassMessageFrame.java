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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gy.bean.S_class;
import com.gy.tools.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassMessageFrame extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassMessageFrame frame = new ClassMessageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClassMessageFrame() {
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 495, 329);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label.setIcon(new ImageIcon(ClassMessageFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5  \u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchMethod(arg0);
			}
		});
		searchButton.setIcon(new ImageIcon(ClassMessageFrame.class.getResource("/com/gy/image/\u641C\u7D22.png")));
		searchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(searchButton)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u5907\u6CE8"
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
		getContentPane().setLayout(groupLayout);
		initTable();
	}
	protected void searchMethod(ActionEvent arg0) {
		String txt=textField.getText().toString();
		if(Tools.isNumber(txt)){
			int id=Integer.parseInt(txt);
			S_class sc=LoginFrame.scd.selectSclassById(id);
			List<S_class> list=new ArrayList<S_class>();
			list.add(sc);
			initTable2(list);
		}else{
			List<S_class> list=LoginFrame.scd.selectSclassByName(txt);
			initTable2(list);
		}
	}

	private void initTable(){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		List<S_class> list=LoginFrame.scd.selectSclassAll();
		for(S_class c:list){
			Vector v=new Vector();
			v.add(c.getId());
			v.add(c.getName());
			v.add(c.getInfo());
			dtm.addRow(v);
		}
	}
	private void initTable2(List<S_class> list){
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for(S_class c:list){
			Vector v=new Vector();
			v.add(c.getId());
			v.add(c.getName());
			v.add(c.getInfo());
			dtm.addRow(v);
		}
	}
}
