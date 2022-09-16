import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Count_down extends JFrame {
	
	int min,min1;
	int second,second1;
	Timer timer;
	boolean flag = true;
	boolean ifStop = false;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Count_down frame = new Count_down();
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
	public Count_down() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 55, 426, -17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COUNT DOWN CLOCK");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 25, 426, 54);
		contentPane.add(lblNewLabel_1);
		
		JLabel Minute = new JLabel("00");
		Minute.setHorizontalAlignment(SwingConstants.CENTER);
		Minute.setFont(new Font("Tahoma", Font.BOLD, 28));
		Minute.setBounds(146, 89, 45, 54);
		contentPane.add(Minute);
		
		JLabel Seconds = new JLabel("00");
		Seconds.setHorizontalAlignment(SwingConstants.CENTER);
		Seconds.setFont(new Font("Tahoma", Font.BOLD, 28));
		Seconds.setBounds(222, 89, 45, 54);
		contentPane.add(Seconds);
		
		JLabel lblNewLabel_2_2 = new JLabel(":");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_2.setBounds(186, 89, 45, 54);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel(":");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_2_1.setBounds(186, 137, 45, 54);
		contentPane.add(lblNewLabel_2_2_1);
		
		JButton Start = new JButton("Start");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						Minute.setForeground(Color.BLACK);
						Seconds.setForeground(Color.BLACK);
						
						if(ifStop) {
							min = min1;
							second = second1;
							ifStop = false;
						}
						
						if(second == 0) {
							second = 60;
							min--;
						}
						
						if(min == 0) {
							Minute.setForeground(Color.red);
							Seconds.setForeground(Color.red);
						}
						
						if(min < 0) {
							JOptionPane.showMessageDialog(rootPane, "Time Up", "Stop", 0);
							min = 0; 
							second = 0;
							timer.stop();
						}else {
						second--;
						
						if(second < 10) {
							Seconds.setText("0" + second);
							flag = false;
						}
						
						if(min < 10) {
							Minute.setText("0" + min);
							if(second < 10)
								Seconds.setText("0" + second);
							else
								Seconds.setText("" + second);
							flag = false;
						}
						
						if(flag)
						{
							Minute.setText("0" + min);
							Seconds.setText("0" + second);
						}
						
					}
					
					}});
				timer.start();
			}
		});
		Start.setFont(new Font("Tahoma", Font.BOLD, 18));
		Start.setBounds(106, 215, 85, 35);
		contentPane.add(Start);
		
		JButton Stop = new JButton("Stop");
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				min1 = min;
				second1 = second;
				ifStop = true;
				timer.stop();
			}
		});
		Stop.setFont(new Font("Tahoma", Font.BOLD, 18));
		Stop.setBounds(222, 215, 85, 35);
		contentPane.add(Stop);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minute.setText(""+comboBox.getSelectedItem());
				min = Integer.parseInt(Minute.getText());
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 28));
		comboBox.setBounds(119, 153, 66, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seconds.setText("" + comboBox_1.getSelectedItem());
				second = Integer.parseInt(Seconds.getText());
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		comboBox_1.setBounds(222, 153, 66, 38);
		contentPane.add(comboBox_1);
		
		for(int i = 0; i < 24; i++) {
			if(i < 10)
			comboBox.addItem("0" + i);
			else 
			comboBox.addItem(i);
		}
		
		for(int i = 0; i < 60; i++) {
			if(i < 10)
			comboBox_1.addItem("0" + i);
			else 
			comboBox_1.addItem(i);
		}
	}
}
