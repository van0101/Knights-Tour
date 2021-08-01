import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;




public class Menu1 extends Thread
{
	/**
	 * @wbp.parser.entryPoint
	 */
	JFrame w1=new JFrame();
	
	JLabel label_1 = new JLabel("");
	JLabel label_2 = new JLabel("");
	JLabel label_3 = new JLabel("");
	
	JButton btnStartGame = new JButton("START GAME!");
	Menu1()
	{
		
		
		w1.setSize(553, 291);
		w1.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 554, 291);
		w1.getContentPane().add(panel);
		panel.setLayout(null);
		label_3.setBounds(191, 0, 441, 174);
		panel.add(label_3);
		
		
		label_3.setIcon(new ImageIcon("D:\\FINAL PROJECTS\\Final KT\\knights\\Titile12.png"));
		label_3.setVisible(true);
		btnStartGame.setBounds(302, 226, 152, 32);
		panel.add(btnStartGame);
		
		
		
		btnStartGame.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnStartGame.setBackground(new Color(255, 255, 255));
		JLabel label = new JLabel("");
		label.setBounds(0, -17, 200, 331);
		panel.add(label);
		label.setIcon(new ImageIcon("D:\\FINAL PROJECTS\\Final KT\\knights\\k14 - Copy.png"));
		label_1.setBounds(186, 0, 235, 291);
		panel.add(label_1);
		
		
		label_1.setIcon(new ImageIcon("D:\\FINAL PROJECTS\\Final KT\\knights\\b1.png"));
		label_2.setBounds(376, 0, 178, 291);
		panel.add(label_2);
		
		
		label_2.setIcon(new ImageIcon("D:\\FINAL PROJECTS\\Final KT\\knights\\b1.png"));
		label_2.setVisible(true);
		label_1.setVisible(true);
		btnStartGame.setVisible(false);
		
		w1.setUndecorated(true);
		//w1.pack();
		w1.setLocationRelativeTo(null);

		w1.setVisible(true);
		
		start_game();
	}
	
	void start_game()
	{
		Thread th=new Thread(new Theme());
		try
		{
			sleep(3000);
			th.start();
			btnStartGame.setVisible(true);
		}
		catch(Exception e) {}
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				w1.setVisible(false);
				new Chess_Knight().start();
			}
		});
	}
}