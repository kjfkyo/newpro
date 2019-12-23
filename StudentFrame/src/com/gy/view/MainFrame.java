package com.gy.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuItem menuItem_7;
	private JMenuItem menuItem_4;
	private JMenuItem menuItem_5;
	private JMenu menu_4;
	private JMenu menu_5;
	private JMenuItem menuItem_12;
	private JMenuItem menuItem_13;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		setTitle("\u4FE1\u606F\u7BA1\u7406\u7A97\u53E3");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 540);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showModifyPassword(arg0);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showExitMethod(arg0);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9000\u51FA.png")));
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u7BA1\u7406.png")));
		menu_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u73ED\u7EA7\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showClassMessage(arg0);
			}
		});
		
		menuItem_4 = new JMenuItem("\u6DFB\u52A0\u73ED\u7EA7");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddClassMethod(arg0);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6DFB\u52A0.png")));
		menu_2.add(menuItem_4);
		menuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u73ED\u7EA7\u5217\u8868.png")));
		menu_2.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5B66\u751F\u7BA1\u7406.png")));
		menu_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_3);
		
		menuItem_5 = new JMenuItem("\u6DFB\u52A0\u4FE1\u606F");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddStudentInfo(arg0);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6DFB\u52A0.png")));
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5B66\u751F\u4FE1\u606F\u5217\u8868");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showStudentMessage(arg0);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u4EBA\u6570.png")));
		menu_3.add(menuItem_6);
		
		menu_4 = new JMenu("\u6559\u5E08\u7BA1\u7406");
		menu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		menu_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_4);
		
		menuItem_7 = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddTeacher(arg0);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6DFB\u52A0.png")));
		menu_4.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u6559\u5E08\u5217\u8868");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTeacherInfo(arg0);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8001\u5E08.png")));
		menu_4.add(menuItem_8);
		
		menu_5 = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		menu_5.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B.png")));
		menu_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_5);
		
		JMenuItem menuItem_9 = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddCourse(arg0);
			}
		});
		menuItem_9.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u6DFB\u52A0.png")));
		menu_5.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showCourseMessageFrame(arg0);
			}
		});
		menuItem_10.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u8BFE\u7A0B\u5217\u8868.png")));
		menu_5.add(menuItem_10);
		
		JMenu menu_6 = new JMenu("\u9009\u8BFE\u7BA1\u7406");
		menu_6.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9009\u62E9.png")));
		menu_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_6);
		
		JMenuItem menuItem_11 = new JMenuItem("\u9009\u62E9\u8BFE\u7A0B");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSelectedCourseFrame(arg0);
			}
		});
		menuItem_11.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u9009\u62E9.png")));
		menu_6.add(menuItem_11);
		
		JMenu menu_7 = new JMenu("\u8003\u52E4\u7BA1\u7406");
		menu_7.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230.png")));
		menu_7.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_7);
		
		menuItem_12 = new JMenuItem("\u5B66\u751F\u7B7E\u5230");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentAttendance(arg0);
			}
		});
		menuItem_12.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230.png")));
		menu_7.add(menuItem_12);
		
		menuItem_13 = new JMenuItem("\u7B7E\u5230\u4FE1\u606F\u7BA1\u7406");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAttendanceInfo(arg0);
			}
		});
		menuItem_13.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u7B7E\u5230\u5217\u8868.png")));
		menu_7.add(menuItem_13);
		
		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5E2E\u52A9.png")));
		menu_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAbout(arg0);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/gy/image/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_1.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 102, 102));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		setAuthority();
	}

	protected void showAttendanceInfo(ActionEvent arg0) {
		AttendanceMessageFrame amf=new AttendanceMessageFrame();
		amf.setVisible(true);
		this.desktopPane.add(amf);
	}

	protected void studentAttendance(ActionEvent arg0) {
		AddAttendanceFrame aaf=new AddAttendanceFrame();
		aaf.setVisible(true);
		this.desktopPane.add(aaf);
	}

	protected void showSelectedCourseFrame(ActionEvent arg0) {
		SelectedCourseFrame scf=new SelectedCourseFrame();
		scf.setVisible(true);
		this.desktopPane.add(scf);
	}

	protected void showCourseMessageFrame(ActionEvent arg0) {
		CourseMessageFrame cmf=new CourseMessageFrame();
		cmf.setVisible(true);
		this.desktopPane.add(cmf);
	}

	protected void showAddCourse(ActionEvent arg0) {
		AddCourseFrame acf=new AddCourseFrame();
		acf.setVisible(true);
		this.desktopPane.add(acf);
	}

	protected void showTeacherInfo(ActionEvent arg0) {
		TeacherMessageFrame tmf=new TeacherMessageFrame();
		tmf.setVisible(true);
		this.desktopPane.add(tmf);
	}

	protected void showAddTeacher(ActionEvent arg0) {
		AddTeacherFrame atf=new AddTeacherFrame();
		atf.setVisible(true);
		this.desktopPane.add(atf);
	}

	protected void showStudentMessage(ActionEvent arg0) {
		StudentMessageFrame smf=new StudentMessageFrame();
		smf.setVisible(true);
		desktopPane.add(smf);
	}

	protected void showAddStudentInfo(ActionEvent arg0) {
		AddStudentFrame asf=new AddStudentFrame();
		asf.setVisible(true);
		desktopPane.add(asf);
	}

	protected void showAddClassMethod(ActionEvent arg0) {
		AddClassFrame acf=new AddClassFrame();
		acf.setVisible(true);
		desktopPane.add(acf);
	}

	protected void showClassMessage(ActionEvent arg0) {
		ClassMessageFrame cmf=new ClassMessageFrame();
		cmf.setVisible(true);
		desktopPane.add(cmf);
	}

	protected void showExitMethod(ActionEvent arg0) {
		if(JOptionPane.showConfirmDialog(this, "确定要退出吗？")==JOptionPane.OK_OPTION){
			System.exit(0);
		}
	}

	protected void showModifyPassword(ActionEvent arg0) {
		ModifyPassword mp=new ModifyPassword();
		mp.setVisible(true);
		desktopPane.add(mp);
	}

	protected void showAbout(ActionEvent arg0) {
		String info="重庆工业职业技术学院版权所有\n";
		info+="网址：http://www.cqipc.edu.cn\n";
		info+="技术支持：QQ179663078";
		String[] s={"迫不及待去看看","暂时不想去"};
		int res=JOptionPane.showOptionDialog(this, 
				info, "关于我们",JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.DEFAULT_OPTION, 
				new ImageIcon(LoginFrame.class.getResource
						("/com/gy/image/logo.png")), s, null);
		if(res==0){
			JOptionPane.showMessageDialog(this, "好吧，带你飞！");
			try {
				URI url=new URI("http://www.cqipc.edu.cn");
				Desktop.getDesktop().browse(url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(this, "滚蛋！");
		}
	}
	private void setAuthority(){
		String type=LoginFrame.userType.toString();
		if(type.equals("教师")){
			menuItem_7.setEnabled(false);
			menuItem_12.setEnabled(false);
		}else if(type.equals("学生")){
			menuItem_4.setEnabled(false);
			menuItem_5.setEnabled(false);
			menu_4.setEnabled(false);
			menu_5.setEnabled(false);
			menuItem_13.setEnabled(false);
		}
	}
	public void close(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame lf=new LoginFrame();
		lf.setVisible(true);
	}
}
