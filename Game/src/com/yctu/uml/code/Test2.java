package com.yctu.uml.code;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test2 implements ActionListener {
	JDialog dialog;

	Test2(JFrame f) { // ���췽����������÷����л�öԻ���ĸ�����
		dialog = new JDialog(f, "0 or 1", true); // ����һmodal�Ի���
		Container dialogPane = dialog.getContentPane(); // ������ע����Ӹ������
		dialogPane.setLayout(new GridLayout(1, 1));
		JButton b1 = new JButton("OK");
		dialogPane.add(b1);
		JButton b2 = new JButton("Cancel");
		dialogPane.add(b2);
		b1.addActionListener(this); // Ϊ����ť�����¼�������
		b2.addActionListener(this);
		dialog.setBounds(700, 280, 180, 66);
		dialog.setVisible(true);
		;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("OK")) {
			try {
				int[] sum = new int[5]; 
				CopyCat copycat = new CopyCat();
				TheHonest honest = new TheHonest();
				AllCheat allcheat = new AllCheat();
				AllCorporate allcorporate = new AllCorporate();
				Detective detective = new Detective();
				Person person[] = new Person[5];
				person[0] = copycat;
				person[1] = honest;
				person[2] = allcheat;
				person[3] = allcorporate;
				person[4] = detective;
				
				//��ʼ��
				for(int i = 0;i<=4;i++)
					sum[i] = 0;
				
				for(int i=0;i<5;i++)
				{
					for(int j=0;j<5;j++)
					{
						if (j!=i) {
							System.out.println(person[i].getName()+" vs "+person[j].getName());
							System.out.println();
							for(int k=1;k<=5;k++)
							{
								System.out.println("Round "+k);
								compete(person[i],person[j]);
								System.out.println();
							}
							sum[i] = person[i].getCoin() + sum[i];
							sum[j] = person[j].getCoin() + sum[j];
							person[i].setCoin(10);
							person[j].setCoin(10);
							person[i].setLast(-1);
							person[j].setLast(-1);
							person[i].setCount(0);
							person[j].setCount(0);
							person[i].setStat(1);
							person[j].setStat(1);
							person[i].setMark(0);
							person[j].setMark(0);
							System.out.println("-----------------------------------");
					}
					}
				}
				
				for (int i = 0; i < 5; i++) {
						System.out.println(sum[i]);
				}
				
				
//				for(int i=1;i<=5;i++)
//				{
//					System.out.println("Round: "+i);
//					compete(honest,allcorporate);
//					System.out.println();
//				}
				
				int max = 0;
				int index = -1;//���ֵ�����
				for (int i = 0; i < 4; i++) {
					if (sum[i] > max) {
						max = sum[i];
						index = i;
					}
				}
				System.out.println("---------------Result---------------- ");
				System.out.println("Winner is "+ person[index].getName()+","+" the coin is "+ max);

				
		
				
				
				dialog.dispose();
			} catch (Exception ex) {
			}
		} else if (cmd.equals("Cancel")) {
			dialog.dispose(); // ֱ�ӷ���������
		}
	}

public static void compete(Person p1,Person p2){
	
	int temp1,temp2;
	temp1 = p1.getLast();
	temp2 = p2.getLast();
	p1.play(p2,temp1,1);
	p2.play(p1,temp2,1);
	System.out.println("p1: "+p1.getCoin()+"  p2: "+p2.getCoin());	

	
}

}
