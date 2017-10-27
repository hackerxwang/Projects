package com.yctu.uml.code;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class GameInterface  implements ActionListener {
	JFrame f = null; // ������

	public GameInterface() // ���췽��
	{
		f = new JFrame("Game System"); // ����һ����������
		f.setLocation(380, 220);
		Container contentPane = f.getContentPane(); // ������������
		JPanel buttonPanel = new JPanel(); // ����һ�м�����JPanel
		JButton b = new JButton("One Tournament"); // ����һԭ�����������ť
		b.addActionListener(this); // Ϊ��ť����¼�����������
		buttonPanel.add(b); // ���˰�ť��ӵ��м�����
		b = new JButton("Survial Mode");
		b.addActionListener(this);
		buttonPanel.add(b);
		b = new JButton("CopyCat  VS  Allcheat");
		b.addActionListener(this);
		buttonPanel.add(b);
		b = new JButton("CopyCat  VS  Detective");
		b.addActionListener(this);
		buttonPanel.add(b);
		b = new JButton("Exit"); // �ٴ���һ��ť
		b.addActionListener(this); // Ϊ��ť�����¼�������
		buttonPanel.add(b); // ����ť��ӵ��м�����
		buttonPanel.setBorder(BorderFactory.createTitledBorder( // �����м������߿�
				BorderFactory.createLineBorder(Color.blue, 2), "who is the winner", TitledBorder.CENTER, TitledBorder.TOP));
		contentPane.add(buttonPanel, BorderLayout.CENTER); // ���м�������ӵ��������
		JMenuBar mBar = new JMenuBar(); // �����˵���
		
		
		f.setJMenuBar(mBar); // Ϊ�������Ӳ˵�
		f.setSize(280, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() { // Ϊ���ڲ�����Ӽ�����
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) { // ʵ��ActionListener�ӿ�Ψһ�ķ���
		String cmd = e.getActionCommand(); // ���¼������������������
		if (cmd.equals("Survial Mode")) { // ��������ѡ����Ӧ�¼�
			new TestForBest(f); // ��ʾ�����Ϣ�Ի���
		} else if (cmd.equals("Exit")) {
			System.exit(0);
		} 
		else if (cmd.equals("CopyCat  VS  Allcheat")) {
			new TestVsAllcheat(f); // ��ѯϵͳ
		} else if (cmd.equals("One Tournament")) {
			new Test2(f); // ɾ��ϵͳ
		} else if (cmd.equals("CopyCat  VS  Detective")) {
			new TestVsDetective(f); // �޸�ϵͳ
		} else if (cmd.equals("�鿴������Ϣ")) {
			new Test1(f); // ��ӡϵͳ
		}
	}

	public static void main(String[] args) // �����������ڴ���PersonManager���һ������
	{
		new GameInterface();
	}
}