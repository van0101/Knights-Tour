import java.awt.*;


import javax.swing.*;
import java.awt.event.*;
//import Chess.Knight;

//import asd.Knight;

public class Chess_Knight extends Thread //implements ActionListener
{
	JFrame w=new JFrame();
	JButton b[][]=new JButton[10][10];
	JLabel number[]=new JLabel[8];
	JButton move=new JButton("MOVES");
	JPanel p =new JPanel();
	JPanel p2=new JPanel();
	JButton exit=new JButton("EXIT\r\n");
	JButton reset=new JButton("RESET");
	ImageIcon kt=new ImageIcon("V:\\Programs\\JAVA\\Knight Tour\\Knight Tour 2\\src\\Knight.png");
	JLabel k=new JLabel();
	
	Theme s=new Theme();
	
	int move_count[][]=new int [10][10];//records 1 for valid moves to end the game
	/**
	 * @wbp.parser.entryPoint
	 */
	Chess_Knight() 
	{
		
		
		int panel_b=800,panel_h=700;
		w.getContentPane().setLayout(new GridLayout(1,2));
		p.setBackground(Color.LIGHT_GRAY);
		w.getContentPane().add(p);
		p.setPreferredSize(new Dimension(panel_h, panel_b));
		p.setLayout(new GridLayout(10,10));
		move.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		move.setBounds(10, 11, 112, 98);
		w.getContentPane().add(p2);
		p2.add(move);
		move.setVisible(true);
		move.setBackground(Color.WHITE);
		move.setForeground(Color.BLACK);
		move.setOpaque(true);
		exit.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		exit.setBounds(146, 231, 112, 98);
		p2.add(exit);
		exit.setVisible(true);
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setOpaque(true);
		reset.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		reset.setForeground(Color.WHITE);
		reset.setBounds(10, 120, 112, 98);
		p2.add(reset);
		reset.setVisible(true);
		reset.setBackground(Color.BLACK);
		reset.setOpaque(true);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(725,514);
		w.setBackground(Color.GRAY);
		
		
		
		
		board();
		
	}
	public void board() 
	{
		
		
		
		for(int m=0;m<10;m++)
		{
			for(int n=0;n<10;n++)
			{
				move_count[m][n]=0;//setting the move count =0 which means that no valid moves have been recorded
			}
		}
		move_count[1][1]=1;
		
		for(int i=0;i<b.length;i++)//initializing the button array 
		{
			for(int j=0;j<b.length;j++)
			{	
				b[i][j]=new JButton();
			}
		}
					
		//adding buttons 10 X 10
		int xb=50,yb=50;//initial position for adding buttons is 50,50
		for(int i=0;i<b.length;i++)
		{
			
			for(int j=0;j<b.length;j++)
			{			
				b[i][j].setBounds(xb,yb,50,50);
				b[i][j].setVisible(true);
				p.add(b[i][j]);
				
				xb+=50;
			}
			yb+=50;
			
			xb=50;
		}
		//adding notations on borders
		int n=1,n2=1;
		for(int i=1;i<=8;i++)//adding numbers
		{
			for(int j=0;j<b.length;j++)
			{
				b[i][j].setForeground(Color.BLACK);
				if(j==0)
				{
					
					if((j==0&&i==0))
					{
						b[i][j].setText("");
					}
					else 
					{
						b[i][j].setText(String.valueOf(n));
						n++;
					}
				}
				if(j==9)
				{
					if(j==9&&i==0)
					{
						b[i][j].setText("");
					}
					else
					{
						b[i][j].setText(String.valueOf(n2));
						n2++;
					}
				}
				
			}
			
		}
		int c=65;
		for(int i=0;i<b.length;i++)//setting alphabets on horizontal border
		{
			
			for(int j=1;j<=8;j++)
			{	
				b[i][j].setForeground(Color.BLACK);
				if(i==0||i==9)
				{	char alpha=(char)c;
					b[i][j].setText(""+alpha);
					c++;
				}
			}
			c=65;
		}
		
		
		//colouring them 8 X 8 chess squares and the the borders
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				if(i==0||i==9||j==0||j==9)//border colors
				{
					
					b[i][j].setBackground(Color.LIGHT_GRAY);
				
				}
				else
				{
					if(i%2==0)//if the row is even
					{
						if(j%2==0)//if the block is even then black else white
						{
							b[i][j].setBackground(Color.WHITE);
						}
						if(j%2!=0)
						{
							
							b[i][j].setBackground(Color.DARK_GRAY);
						}
					}
					if(i%2!=0)//if the row is odd
					{
						if(j%2==0)//if the block is even then white else black
						{
							b[i][j].setBackground(Color.DARK_GRAY);
						}
						if(j%2!=0)
						{
							b[i][j].setBackground(Color.WHITE);
						}
					}
				 }
				
			}
		}
		//adding image
		//final ImageIcon knight=new ImageIcon("D:\\FINAL PROJECTS\\Final KT\\knightg1.png");
		
		//k.setIcon(knight);
		b[1][1].add(k);		
		//setting the final window
		w.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		w.setUndecorated(true);
		k.setVisible(true);
		p2.setLayout(null);
		p2.setBackground(Color.LIGHT_GRAY);
		
		btnUndo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnUndo.setForeground(Color.BLACK);
		btnUndo.setBackground(Color.WHITE);
		btnUndo.setBounds(146, 122, 112, 98);
		
		p2.add(btnUndo);
		
		btnSound.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnSound.setForeground(Color.BLACK);
		btnSound.setBackground(Color.WHITE);
		btnSound.setBounds(10, 229, 112, 98);
		
		p2.add(btnSound);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"This game has been inspired from the classical problem of the Knights Tour\nDesigned Developed and Music by Vandit Sharma\nVersion 1.3","About",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(146, 11, 112, 98);
		
		p2.add(btnNewButton);
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "The Objective of the game is to move the Knight\nfollowing the rules of chess and cover\nall 64 squares of the board keeping in mind that it can move to a square \nONLY ONCE","Rules",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRules.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnRules.setBackground(Color.BLACK);
		btnRules.setForeground(Color.WHITE);
		btnRules.setBounds(10, 338, 112, 98);
		
		p2.add(btnRules);
		btnTest.setForeground(new Color(0, 0, 0));
		
		btnTest.setBackground(new Color(255, 255, 255));
		btnTest.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		btnTest.setBounds(146, 340, 112, 98);
		
		p2.add(btnTest);
		w.setVisible(true);
		k.setIcon(new ImageIcon("V:\\Programs\\JAVA\\Knight Tour\\Knight Tour 2\\src\\Knight.png"));
	}
	
	
	int moves=0;
	int pos_x=1,pos_y=1;
	int pre_x=pos_x,pre_y=pos_y;
	int valid_position[][]=new int [10][10];//if the the int stored is one then its loc will be returned
	int color_x=pos_x,color_y=pos_y;
	int color;
	int mt,nt;
	boolean flag=false;
	private final JButton btnUndo = new JButton("UNDO");
	private final JButton btnSound = new JButton("SOUND");
	private final JButton btnNewButton = new JButton("ABOUT\r\n");
	private final JButton btnRules = new JButton("RULES");
	boolean sound_switch=true,sound_toggle=true;
	boolean flag_exit=true;
	
	int sound_flag=1;//initial state of the flag is on
	private final JButton btnTest = new JButton("TEST");
void movement()
{
	int a=1;
	int c=1;
	

	for( a=1;a<9;a++)
	{
		final Integer workaround1=new Integer(a);
		for( c=1;c<9;c++)
		{
			final Integer workaround2=new Integer(c);
			
			b[workaround1][workaround2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource()==b[workaround1][workaround2])
				{
					boolean move=false;
					move=valid(workaround1,workaround2);
					if(move==true)
					{	
						b[pos_x][pos_y].remove(k);
						b[pos_x][pos_y].repaint();
						
						pre_x=pos_x;//records the previous move
						pre_y=pos_y;
						
						flag_exit=true;
						
						if(color>2)
						{	
							b[color_x][color_y].setBorder( BorderFactory.createEmptyBorder());
							color_x=pos_x;
							color_y=pos_y;
							color=2;
							
						}
						move_count[workaround1][workaround2]=1;//recording a valid move
						
						b[workaround1][workaround2].add(k);
						if(sound_switch==true&&sound_toggle==true)//piece move sound
						{
							Thread sound_th=new Thread(new Sound());
							
							sound_th.start();
							sound_switch=false;
						}
						
						
						pos_x=workaround1;
						pos_y=workaround2;
						
						if(game_win())
						{
							JOptionPane.showMessageDialog(null, " YOU WIN!!! ","WIN!!WIN!!",JOptionPane.INFORMATION_MESSAGE);
							System.exit(2);
						}
					
						set_zero();
						chk_position();
					}
				}
			}
			});
			
			
		}
	}
	exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if(flag_exit==true)
			{
				int ch=JOptionPane.showConfirmDialog(null, "Did you give up so easily?!", "Chickend Out?!",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
				if(ch==JOptionPane.YES_OPTION)
					System.exit(3);
				if(ch==JOptionPane.NO_OPTION)
				{
					flag_exit=false;
					reset();
				}
			}
		}
	});
	reset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			reset();
		}
	});
	
	move.addActionListener(new ActionListener() {//shows the square moved to for 5 seconds
		public void actionPerformed(ActionEvent ae) {
			flag=true;
			for(int m=1;m<9;m++)
			{
				for(int n=1;n<9;n++)
				{
					if(m==pos_x&&n==pos_y)
					{
						b[m][n].setBorder((BorderFactory.createLineBorder(Color.YELLOW, 5)));
						continue;
					}
					if(move_count[m][n]==1)
					{
						b[m][n].setBorder((BorderFactory.createLineBorder(Color.BLUE, 5)));
					}
				}
			}
			
		}
	});
	if(flag==true)
	{
		try {sleep(5000);}catch(Exception e) {}//shows moves for five seconds
		for(int m=1;m<9;m++)
		{
			for(int n=1;n<9;n++)
			{
				if(move_count[m][n]==1)
				{
					b[m][n].setBorder( BorderFactory.createEmptyBorder());
				}
			}
		}
	}
	
	btnUndo.addActionListener(new ActionListener() {//undo one move
		public void actionPerformed(ActionEvent arg0)
		{
			
			b[pos_x][pos_y].remove(k);//current
			b[pos_x][pos_y].repaint();
			
			move_count[pos_x][pos_y]=0;
			move_count[pre_x][pre_y]=0;
			
			pos_x=pre_x;//previous ->changed
			pos_y=pre_y;
			
			b[pos_x][pos_y].add(k);
			
			set_zero();
			chk_position();
		}
	});
	btnSound.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			if(sound_flag==1)//initially-> on state goes to off state
			{
				sound_toggle=false;
				sound_flag=0;
				//s.type=LineEvent.Type.CLOSE;
				
				
			}
			else 
				{
					if(sound_flag==0)//initially -> off state goes to on state
					{
						sound_toggle=true;
						sound_flag=1;
					
					}
				}
				
			
			
		}
	});
	btnTest.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(mt=1;mt<9;mt++)
			{
				for(nt=1;nt<9;nt++)
				{
					if(mt==4&nt==4)
					{
						move_count[mt][nt]=1;
						b[pos_x][pos_y].remove(k);//current
						b[pos_x][pos_y].repaint();
						b[mt][nt].add(k);
						continue;
					}
					if(mt==5&&nt==6)
					{
						move_count[mt][nt]=0;
						continue;
					}
					move_count[mt][nt]=1;
				}
			}
			pos_x=4;pos_y=4;
			set_zero();
			chk_position();
		}
	});
}	
void reset()
{
	set_zero();
	for(int m=1;m<9;m++)
	{
		for(int n=1;n<9;n++)
		{
			move_count[m][n]=0;
		}
	}
	
	move_count[1][1]=1;

	b[pos_x][pos_y].remove(k);
	b[pos_x][pos_y].repaint();
	b[pos_x][pos_y].setBorder( BorderFactory.createEmptyBorder());
	b[color_x][color_y].setBorder( BorderFactory.createEmptyBorder());
	
	pos_x=1;pos_y=1;
	b[pos_x][pos_y].add(k);
	chk_position();
}
boolean game_win()
{
	int count=0;
	for(int m=1;m<9;m++)
	{
		for(int n=1;n<9;n++)
		{
			if(move_count[m][n]==1)
			{
				count++;
			}
		}
	}
	if(count==64)
		return true;
	return false;
}

boolean valid(int x,int y)
{
	for(int c1=1;c1<9;c1++)
	{
		for(int c2=1;c2<9;c2++)
		{
			if(valid_position[c1][c2]==1)
			{
				if(c1==x&&c2==y)
				{
					return true;
				}
			}
		}
	}
	return false;
}
	

public void run()
{	
	
		
	set_zero();
	//There are max eight ways in which a knight at max can move during the game....4 big L  and 4 small L 
		
	chk_position();//will give the positions of valid positions
	
	
	while(true)
	{
		
		
		
		movement();//wait for response from user
	}
	
}
					
void set_zero()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(valid_position[i][j]==1)
				b[i][j].setBorder( BorderFactory.createEmptyBorder());
				valid_position[i][j]=0;//setting all equal to zero
			}
		}
	}
void chk_position()
	{
	 
		int x=pos_x,y=pos_y;
		//JOptionPane.showMessageDialog(null, String.valueOf(x)+"!,!"+String.valueOf(y));
		//first :two big L in the back
		sound_switch=true;
		
		
		
		if((x-2)>0&&(y-1)>0)//back left big L
		{
			valid_position[x-2][y-1]=1;
		}
		if((x-2)>0&&(y+1)<9)//back right big L
		{
			valid_position[x-2][y+1]=1;
		}
		//second :two small L in the back
		if((x-1)>0&&(y-2)>0)//back left small L 
		{
			valid_position[x-1][y-2]=1;
		}
		if((x-1)>0&&(y+2)<9)//back right small L
		{
			valid_position[x-1][y+2]=1;
		}
		//third :two big L in the front
		if((x+2)<9&&(y-1)>0)//front left big L
		{
			valid_position[x+2][y-1]=1;
		}
		if((x+2)<9&&(y+1)<9)//front right big L
		{
			valid_position[x+2][y+1]=1;
		}
		//fourth :two small L in the front
		if((x+1)<9&&(y-2)>0)//front left small L
		{
			valid_position[x+1][y-2]=1;
		}
		if((x+1)<9&&(y+2)<9)//front right small L
		{
			valid_position[x+1][y+2]=1;
		}
		for(int m=1;m<9;m++)//checking the already visited squares
		{
			for(int n=1;n<9;n++)
			{
				if(move_count[m][n]==1&&valid_position[m][n]==1)
				{
					valid_position[m][n]=0;
				}
			}
		}
		
		int count=0;
		for(int m=1;m<9;m++)//checking if there are any valid moves left
		{
			for(int n=1;n<9;n++)
			{
				if(valid_position[m][n]==0)
				{
					count++;
				}
			}
		}
		if(count==64)//if at all 64 places the value is zero this means that the knight does not have any place to move
		{
			JOptionPane.showMessageDialog(null, "YOU ARE OUT OF MOVES","YOU LOST!!",JOptionPane.INFORMATION_MESSAGE);
			int res=JOptionPane.showConfirmDialog(null, "You Lost ! Want to try again?","Brave Enough?",JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION)
			{
				reset();
			}
			if(res==JOptionPane.NO_OPTION)
			{
				System.exit(1);
			}
			
		}
		for(int m=1;m<9;m++)
		{
			for(int n=1;n<9;n++)
			{
				if(valid_position[m][n]==1)
					b[m][n].setBorder(BorderFactory.createLineBorder(Color.green, 5));
			}
		}
	 }	

	
	public static void main(String args[])
	{
		new Menu();
		
	}
}
