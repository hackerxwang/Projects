package com.yctu.uml.code;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test1 implements ActionListener {

	JDialog dialog;

	Test1(JFrame f) { // ���췽����������÷����л�öԻ���ĸ�����
		dialog = new JDialog(f, "��ѯ����", true); // ����һmodal�Ի���
		Container dialogPane = dialog.getContentPane(); // ������ע����Ӹ������
		dialogPane.setLayout(new GridLayout(1, 2));
		JButton b1 = new JButton("ȷ��");
		dialogPane.add(b1);
		JButton b2 = new JButton("ȡ��");
		dialogPane.add(b2);
		b1.addActionListener(this); // Ϊ����ť�����¼�������
		b2.addActionListener(this);
		dialog.setBounds(200, 150, 100, 90);
		dialog.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("ȷ��")) {
			try {
				
				
				dialog.dispose();
			} catch (Exception ex) {

			}
		} else if (cmd.equals("ȡ��")) {
			dialog.dispose(); // ֱ�ӷ���������
		}
	}
}

