package RoomEscape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RoomEscapeGame extends JFrame implements ActionListener {
	static final int ROCK = 0;
	static final int PAPER = 1;
	static final int SCISSOR = 2;
	
	private JFrame frame;
	private JPanel panel, fullPanel;
	private JTextField output, information;
	private JButton rock, paper, scissor;
	
	RoomEscape RE = new RoomEscape();
	
	public RoomEscapeGame() {
		
		frame = new JFrame();
		fullPanel = new JPanel();
		panel = new JPanel();
		frame.setLayout(null);
		frame.setSize(720, 330);
		frame.setTitle("다람쥐를 이겨라 ! ");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		information = new JTextField("다람쥐한테 가위바위보를 이겨야만 넘어가실 수 있어요 !");
		output = new JTextField(20);
		
		rock = new JButton(new ImageIcon("img/rock.png"));
		rock.setContentAreaFilled(false);
		rock.setBorderPainted(false);
		rock.addActionListener(this);
		
		paper = new JButton(new ImageIcon("img/paper.png"));
		paper.setContentAreaFilled(false);
		paper.setBorderPainted(false);
		paper.addActionListener(this);
		
		scissor = new JButton(new ImageIcon("img/scissor.png"));
		scissor.setContentAreaFilled(false);
		scissor.setBorderPainted(false);
		scissor.addActionListener(this);
	
		
		panel.add(rock);
		panel.add(paper);
		panel.add(scissor);
		
		fullPanel.add(information, BorderLayout.NORTH);
		fullPanel.add(panel, BorderLayout.CENTER);
		fullPanel.add(output, BorderLayout.SOUTH);

		fullPanel.setBounds(0, 0, 720, 330);
		
		frame.add(fullPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		int num = (int)(Math.random()*3);
		
		String[] arg = {"rock", "paper", "scissor"};
		String computer = arg[num];
		String user;
		
		if(e.getSource() == rock)
			user = arg[0];
		else if(e.getSource() == paper)
			user = arg[1];
		else
			user = arg[2];
		
		if(computer == user) {
			output.setText("비겼어요 !");
			RE.rspCount += 1;
		}
		else if(computer == "rock" && user =="paper" || computer == "scissor" && user =="rock" || computer == "paper" && user == "scissor")
			{ 
				output.setText("이겼네요 !");
				RE.setPoint();
				RE.setKey();
				frame.setVisible(false); 
			}
		else {
			output.setText("지셨네요 !");
			RE.rspCount += 1;
		}
	}
}
