package com.eojin.connect6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel
{
	static Ellipse2D[][] ellipse = new Ellipse2D[20][20];
	static int[][] exist = new int[19][19];
	String s = "";
	int x, y;
	static Point p;
	Color color;
	int cnt = 0;
	int pointCnt = 0;
	boolean bool = true;
	JFrame end;
	JLabel black, white;
	ArrayList<Element> ary1 = new ArrayList<Element>();
	
	public MainPanel()
	{
		setBounds(150, 5, 780 , 780);
		setBackground(new Color(229, 192, 95));
//		setBackground(new Color(240, 177, 80));
		addMouseListener(new MyMouseListener());
		for(int i=0; i<19; i++)
			for(int j=0; j<19; j++)
			{
				exist[i][j] = 0;
			}
	}
	
	class Element
	{
		Ellipse2D el;
		Color col;
		Element(Ellipse2D e, Color c)
		{
			el = e;
			col = c;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		//기본 판 그리기
		g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,0));
		
		for(int i=0; i<19; i++)
		{
			for(int j=0; j<19; j++)
			{
				ellipse[i][j] = new Ellipse2D.Double(i*40+15, j*40+15, 30 , 30);
//				g2.fill(ellipse[i][j]);
			}
			g2.drawLine(30, i*40+30, 750, i*40+30);
			g2.drawLine(i*40+30, 30, i*40+30, 750);
		}
		for(int x = 145; x<626; x+= 240)
		{
			for(int y=145; y<626; y+= 240)
			{
				g2.fillOval(x, y, 10, 10);
			}
		}
		
		if(cnt == 0)
			MainFrame.state.setText("Black Turn");
		else if( (cnt+2)/2%2 == 0)
			MainFrame.state.setText("Black Turn");
		else if((cnt+2)/2%2 ==1)
			MainFrame.state.setText("White Turn");
		
		//클릭했을 떄
		if(!ary1.isEmpty())// 원래 있던 돌 그려주기
		{
			System.out.println(ary1.size());
			for(int i=0; i<ary1.size(); i++)
			{
				
				g2.setColor(ary1.get(i).col);
				g2.fill(ary1.get(i).el);
			}
		}
		
		if(s == "s")// 판 클릭했을 때 
		{
			bool = true;
			for(int i=0; i<ary1.size(); i++)// 중복된 지점에 돌이 있는 지 확인
			{
				if(ary1.get(i).el.contains(p))
					bool = false;
			}
			if(bool)// 중복된 지점이 아니면
			{
				cnt++;
				for(int i=0; i<19; i++)
				{
					for(int j=0; j<19; j++)
					{
						if(ellipse[i][j].contains(p))// 클릭한 Point가 ellipse에 포함되면
						{
							x = i;
							y = j;
							if(MainFrame.forbid > pointCnt)// 착수금지점
							{
								cnt--;
//								exist[i][j] = 0;
								g2.setColor(color = Color.RED);
								pointCnt++;
							}
							else if(cnt ==1 || cnt/2%2 == 0)// 흑돌
							{
//								MainFrame.state.setText("흑");
								exist[i][j] = 1;
								g2.setColor(color = Color.BLACK);
							}
							else if(cnt/2%2 ==1)// 백돌
							{
								exist[i][j] = 2;
//								MainFrame.state.setText("백");
								g2.setColor(color = Color.WHITE);
							}
							g2.fill(ellipse[i][j]);
							Element e = new Element(ellipse[i][j], color);
							ary1.add(e);
						}
					}
				}
			}
			WinLose wl = new WinLose();
			int a = wl.checkFinishGo(x, y);// 승리 판별
			if(a == 1)
			{
				System.out.println("흑돌 승");
				end = new JFrame();
				end.setLayout(null);
				black = new JLabel("흑돌 승");
				black.setFont(new Font("고딕체", Font.BOLD, 20));
				black.setBounds(100, 50, 70, 30);
				end.add(black);
				end.setBounds(600, 200, 300, 200);
				end.setVisible(true);
				end.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ary1.clear();
//				repaint();
			}
			else if(a == 2)
			{
				System.out.println("백돌 승");
				end = new JFrame();
				end.setLayout(null);
				white = new JLabel("백돌 승");
				white.setFont(new Font("고딕체", Font.BOLD, 20));
				white.setBounds(100, 50, 70, 30);
				end.add(white);
				end.setBounds(600, 200, 300, 200);
				end.setVisible(true);
				end.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ary1.clear();
//				repaint();
			}
		}
	
	}
	public class MyMouseListener implements MouseListener, MouseMotionListener {
		public void mousePressed(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {
			
		}
		public void mouseClicked(MouseEvent e) {
			for(int i=0; i<19; i++)
			{
				for(int j=0; j<19; j++)
				{
					if(ellipse[i][j].contains(e.getPoint()))
					{
						p = e.getPoint();
						
						s = "s";
						repaint();
					}
				}
			}
		}
		public void mouseEntered(MouseEvent e) {
			
		}
		public void mouseExited(MouseEvent e) {
			
		}
		public void mouseDragged(MouseEvent e) { 
			
		}
		public void mouseMoved(MouseEvent e) {
		}
	}
}
