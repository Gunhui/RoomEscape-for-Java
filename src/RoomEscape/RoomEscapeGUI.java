package RoomEscape;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RoomEscapeGUI extends JFrame {

	RoomEscape RE = new RoomEscape();

	JFrame startFrame, gameFrame, exitFrame;
	JPanel startPanel, gamePanel;
	JLabel label, exitLabel;
	JLabel timeLabel[] = new JLabel[7];
	JButton door, ladder, firePlace, Chicken, fire, squirrel, gameExit, revenge, start, rank;
	JButton button[] = new JButton[6];
	JLabel countLabel[] = new JLabel[7];
	private JButton keyButton, open, exit;
	private JPanel card[] = new JPanel[8];
	final CardLayout cardLayout = new CardLayout();
	Thread mt;
	private boolean check;

	public RoomEscapeGUI(RoomEscape RE) {
		Thread mt = new MyThread();
		this.mt = mt;
		startFrame = new JFrame();
		startPanel = new JPanel();

		label = new JLabel();

		for (int i = 0; i < 7; i++) {
			card[i] = new JPanel();
		}

		gameFrame = new JFrame();
		gamePanel = new JPanel();

		startFrame.setTitle("RoomEscape !!");
		gameFrame.setTitle("RoomEscape !!");

		exitFrame = new JFrame();
		exitFrame.setSize(300, 150);
		exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exitFrame.setTitle("종료");
		exitFrame.setLayout(null);
		exitLabel = new JLabel("시간이 초과되었습니다. 재도전 하시겠습니까 ? ");
		exitLabel.setVisible(true);
		exitLabel.setBounds(10, 10, 300, 30);
		exitFrame.add(exitLabel);
		exitFrame.setLocationRelativeTo(null);
		gameFrame.setLocationRelativeTo(null);
		startFrame.setLocationRelativeTo(null);

		gameExit = new JButton("아니오");
		exitFrame.setResizable(false);
		gameExit.setVisible(true);
		exitFrame.add(gameExit);
		gameExit.setBounds(150, 60, 100, 50);
		gameExit.addActionListener(new MyListener());

		revenge = new JButton("예");
		exitFrame.add(revenge);
		revenge.setBounds(30, 60, 100, 50);
		revenge.setVisible(true);
		revenge.addActionListener(new MyListener());

		startPanel = new JPanel() {
			ImageIcon i = new ImageIcon("img/start.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 539, 960, null);
			}
		};

		gamePanel = new JPanel();
		gamePanel.setLayout(new CardLayout());

		card[0] = new JPanel() {
			ImageIcon i = new ImageIcon("img/room.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 862, null);
			}
		};

		card[1] = new JPanel() {
			ImageIcon i = new ImageIcon("img/door.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 844, null);
			}
		};

		card[2] = new JPanel() {
			ImageIcon i = new ImageIcon("img/ladder.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 840, null);
			}
		};
		card[3] = new JPanel() {
			ImageIcon i = new ImageIcon("img/firePlace.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 844, null);
			}
		};

		card[4] = new JPanel() {
			ImageIcon i = new ImageIcon("img/Chicken.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 838, null);
			}
		};
		card[5] = new JPanel() {
			ImageIcon i = new ImageIcon("img/fire.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 835, null);
			}
		};

		card[6] = new JPanel() {
			ImageIcon i = new ImageIcon("img/squirrel.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 857, null);
			}
		};

		card[7] = new JPanel() {
			ImageIcon i = new ImageIcon("img/openedDoor.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 750, 848, null);
			}
		};

		for (int i = 0; i < 8; i++) {
			gamePanel.add(card[i], "a" + (i + 1));
		}

		startFrame.add(startPanel);
		start = new JButton("시작");
		startPanel.add(start);
		start.addActionListener(new MyListener());
		startPanel.setLayout(null);
		start.setBounds(200, 770, 100, 30);

		rank = new JButton("랭킹");
		startPanel.add(rank);
		rank.addActionListener(new MyListener());
		rank.setBounds(200, 820, 100, 30);

		startFrame.setBounds(50, 50, 539, 960);
		startFrame.setResizable(false);

		gameFrame.add(gamePanel);
		gameFrame.setBounds(50, 50, 750, 862);
		gameFrame.setResizable(false);
		startFrame.setVisible(true);
		startPanel.setLayout(null);

		label.setOpaque(false);
		label.setFont(new Font("Dialog.plain", 0, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 230));
		label.setBounds(170, 700, 202, 238);

		startPanel.add(label);

		/*
		 * for (int i = 0; i < 4; i++) { label.setText("Loading..."); try {
		 * Thread.sleep(700); } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); } label.setText(""); try { Thread.sleep(700); } catch
		 * (InterruptedException e) {
		 * 
		 * e.printStackTrace(); } }
		 * 
		 * 
		 * startFrame.setVisible(false); gameFrame.setVisible(true);
		 */

		for (int i = 0; i < 8; i++) {
			card[i].setLayout(null);
		}

		for (int k = 0; k < 7; k++) {
			countLabel[k] = new JLabel("count");
			countLabel[k].setBounds(520, 630, 202, 238);
			countLabel[k].setFont(new Font("궁서체", Font.BOLD, 40));
			countLabel[k].setText("Key : " + RE.getKey());
			card[k].add(countLabel[k]);
		}

		for (int i = 0; i < 6; i++) {
			button[i] = new JButton(new ImageIcon("img/house.png"));
			button[i].setText("HOME");
			button[i].setVisible(true);
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].setFocusPainted(true);
			button[i].setBounds(340, 750, 68, 64);
			button[i].addActionListener(new MyListener());
			card[i + 1].add(button[i]);
		}

		door = new JButton("");
		card[0].add(door);
		door.setBounds(75, 375, 95, 200);
		door.setVisible(true);
		door.setBorderPainted(false);
		door.setContentAreaFilled(false);
		door.setFocusPainted(false);
		door.addActionListener(new MyListener());

		ladder = new JButton("");
		card[0].add(ladder);
		ladder.setBounds(340, 340, 95, 200);
		ladder.setVisible(true);
		ladder.setBorderPainted(false);
		ladder.setContentAreaFilled(false);
		ladder.setFocusPainted(false);
		ladder.addActionListener(new MyListener());

		firePlace = new JButton("");
		card[0].add(firePlace);
		firePlace.setBounds(530, 390, 210, 130);
		firePlace.setVisible(true);
		firePlace.setBorderPainted(false);
		firePlace.setContentAreaFilled(false);
		firePlace.setFocusPainted(false);
		firePlace.addActionListener(new MyListener());

		Chicken = new JButton("");
		card[0].add(Chicken);
		Chicken.setBounds(520, 530, 50, 30);
		Chicken.setVisible(true);
		Chicken.setBorderPainted(false);
		Chicken.setContentAreaFilled(false);
		Chicken.setFocusPainted(false);
		Chicken.addActionListener(new MyListener());

		fire = new JButton("");
		card[3].add(fire);
		fire.setBounds(250, 480, 250, 130);
		fire.setVisible(true);
		fire.setBorderPainted(false);
		fire.setContentAreaFilled(false);
		fire.setFocusPainted(false);
		fire.addActionListener(new MyListener());

		squirrel = new JButton("");
		card[2].add(squirrel);
		squirrel.setBounds(380, 80, 95, 100);
		squirrel.setVisible(true);
		squirrel.setBorderPainted(false);
		squirrel.setContentAreaFilled(false);
		squirrel.setFocusPainted(false);
		squirrel.addActionListener(new MyListener());

		keyButton = new JButton(new ImageIcon("img/key.png"));
		card[6].add(keyButton);
		keyButton.setText("Key");
		keyButton.setBounds(360, 420, 87, 81);
		keyButton.setVisible(true);
		keyButton.setBorderPainted(false);
		keyButton.setContentAreaFilled(false);
		keyButton.setFocusPainted(true);
		keyButton.addActionListener(new MyListener());

		open = new JButton("");
		card[1].add(open);
		open.setBounds(270, 200, 200, 470);
		open.setVisible(true);
		open.setBorderPainted(false);
		open.setContentAreaFilled(false);
		open.setFocusPainted(false);
		open.addActionListener(new MyListener());

		exit = new JButton("");
		card[7].add(exit);
		exit.setBounds(270, 200, 200, 470);
		exit.setVisible(true);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.addActionListener(new MyListener());

		for (int i = 0; i < 7; i++) {
			timeLabel[i] = new JLabel("Timer");
			timeLabel[i].setFont(new Font("Serif", Font.BOLD, 30));
			timeLabel[i].setBounds(50, 520, 200, 470);
			card[i].add(timeLabel[i]);
		}
		// (new MyThread()).start();
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout) (gamePanel.getLayout());
			if (e.getSource() == door) {
				cl.show(gamePanel, "a2");
				RE.checkCount += 1;
			} else if (e.getSource() == ladder) {
				cl.show(gamePanel, "a3");
				RE.checkCount += 1;
			} else if (e.getSource() == firePlace) {
				cl.show(gamePanel, "a4");
				RE.checkCount += 1;
			} else if (e.getSource() == Chicken) {
				cl.show(gamePanel, "a5");
				RE.checkCount += 1;
			} else if (e.getSource() == fire) {
				cl.show(gamePanel, "a6");
				RE.checkCount += 1;
			} else if (e.getSource() == squirrel) {
				cl.show(gamePanel, "a7");
				RE.checkCount += 1;
			} else if (e.getSource() == keyButton) {
				RoomEscapeGame REG = new RoomEscapeGame();
				for (int i = 0; i < 7; i++) {
					countLabel[i].setText("Key : " + RE.getKey());
				}
				keyButton.setVisible(false);
			} else if (e.getSource() == open) {
				if (RE.Key == 1)
					cl.show(gamePanel, "a8");
			} else if (e.getSource() == exit) {
				if (check == false) {
					mt.interrupt();
					if (mt.isInterrupted() == false) {
						mt.stop();// interrupt가 먹히지 않기 때문에 stop사용
					} else {
						System.out.println(mt.isInterrupted());
					}
					RoomEscapeRecord RER = null;
					try {
						RER = new RoomEscapeRecord();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					check = true;
				} else {
					System.exit(0);
				}
			} else if (e.getActionCommand() == "HOME") {
				cl.show(gamePanel, "a1");
			} else if (e.getSource() == gameExit) {
				System.exit(0);
			} else if (e.getSource() == start) {
				gameFrame.setVisible(true);
				startFrame.setVisible(false);
				mt.start();
			} else if (e.getSource() == rank) {
				RoomEscapeRecord RER = null;
				try {
					RER = new RoomEscapeRecord();
					RER.invisible();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} else if (e.getSource() == revenge) {
				gameFrame.setVisible(true);
				cl.show(gamePanel, "a1");
				RE.Key = 0;
				MyThread.interrupted();
				(new MyThread()).start();
				exitFrame.setVisible(false);
				keyButton.setVisible(true);
			}
		}
	}

	class MyThread extends Thread {
		public void run() {
			for (int i = 30; i >= 0; i--) {
				for (int k = 0; k < 7; k++) {
					countLabel[k].setText("Key : " + RE.getKey());
					timeLabel[k].setText("남은시간 : " + i);
				}
				if (i == 0) {
					exitFrame.setVisible(true);
					gameFrame.setVisible(false);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}