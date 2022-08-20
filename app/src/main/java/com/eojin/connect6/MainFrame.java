package com.eojin.connect6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MainFrame extends JFrame 
{
	MainPanel mp;
	JLabel label;
	static JLabel state;
	JTextField tf;
	JButton check, reset;
	static int forbid = 0;
	static String re = "";
	
	public MainFrame()
	{
		setLayout(null);
		setBounds(180, 0, 1200, 820);
		setBackground(Color.WHITE);
		mp = new MainPanel();
		add(mp);
		
		//착수금지점 입력받는 부분
		label = new JLabel("<html><body><center>착수금지점의 개수를<br> <br>입력하세요.(1~5개)</center></body></html>");
		label.setFont(new Font("고딕체", Font.BOLD, 15));
		label.setBounds(1000, 100, 150, 100);
		label.setBackground(Color.WHITE);
		add(label);
		
		tf = new JTextField();
		tf.setBounds(1010, 200, 60, 30);
		add(tf);
		
		check = new JButton("V");
		check.setBackground(Color.WHITE);
		check.setBounds(1080, 200, 50, 30);
		check.addActionListener(new BtnActionListener());
		add(check);
		
		state = new JLabel("");
		state.setBounds(1025, 250, 100, 40);
		state.setFont(new Font("고딕체", Font.BOLD, 15));
		add(state);
		
		//초기화 버튼
		reset = new JButton("Reset");
		reset.setBounds(1020, 320, 100, 50);
		reset.addActionListener(new BtnActionListener());
//		add(reset);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class BtnActionListener implements ActionListener
	   {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	            JButton btn = (JButton)e.getSource();
	            if(btn == check)
	            {
	            	forbid = Integer.parseInt(tf.getText());
	            }
	            if(btn == reset)
	            {
//	            	re = "re";
	            	for(int i=0; i<19; i++)
	        			for(int j=0; j<19; j++)
	        			{
	        				mp.exist[i][j] = 0;
	        				mp.ary1.clear();
	        			}
	            	mp.cnt = 0;
	            	
	            	System.out.println(mp.ary1.isEmpty());
	            	repaint();
//	            	MainFrame.re = "";
	            }
	        }
	    }

	public static void main(String[] args)
	{
		new MainFrame();
	}

}
