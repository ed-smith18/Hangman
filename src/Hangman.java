/*
 * Edward Smith
 * Unit 2 Activity 2
 * Traditional Hangman
 * game with 5 different
 * categories.
 */
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Hangman
{
	//Static variables used throughout class
	public static JFrame frame = new JFrame("Hangman");
	public static String randomWord = "";
	public static int tries = 7;
	public static JLabel guessed = new JLabel();
	public static JLabel category1 = new JLabel();
	public static JLabel hangmanLabel = new JLabel();
	public static JButton[] keyboard = new JButton[26];
	public static ImageIcon icon = new ImageIcon();
	public static void main(String[] args) 
	{
		// declarations, initializations and variables
		//Initialize components for frame
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel(new BorderLayout());
		JPanel hangman = new JPanel();
		JPanel guess = new JPanel(new BorderLayout());
		JButton categories = new JButton("Categories");
		Font font = new Font("Courier New", Font.BOLD, 20);
		category1.setHorizontalAlignment(SwingConstants.CENTER);
		guessed.setHorizontalAlignment(SwingConstants.CENTER);
		guessed.setFont(font);
		category1.setFont(font);
		//Set dimensions and properties for components
		frame.setSize(550, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		northPanel.setPreferredSize(new Dimension(550,350));
		southPanel.setPreferredSize(new Dimension(550,300));;
		category1.setPreferredSize(new Dimension(550,40));
		guessed.setPreferredSize(new Dimension(550,40));
		guess.setPreferredSize(new Dimension(550,140));
		categories.setPreferredSize(new Dimension(550,35));
		//Add components to frame
		//Add hangman image and category label to north panel
		icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_7.png");
		hangmanLabel.setIcon(icon);
		hangman.add(hangmanLabel);
		northPanel.add(hangman,BorderLayout.SOUTH);
		northPanel.add(category1,BorderLayout.NORTH);
		//Add category button, keyboard and guess label to south panel 
		southPanel.add(categories,BorderLayout.SOUTH);
		southPanel.add(guess,BorderLayout.CENTER);
		southPanel.add(guessed,BorderLayout.NORTH);
		//Add north and south panels to main panel
		mainPanel.add(northPanel,BorderLayout.NORTH);
		mainPanel.add(southPanel,BorderLayout.SOUTH);
		//Categories
		//TV Show Category
		ArrayList<String> tvShows = new ArrayList<String>();
		tvShows.add("FAMILY GUY");
		tvShows.add("BREAKING BAD");
		tvShows.add("SPONGEBOB SQUAREPANTS");
		tvShows.add("FAMILY GUY");
		tvShows.add("THE SIMPSONS");
		tvShows.add("SUITS");
		tvShows.add("KEY AND PEELE");
		tvShows.add("PRISON BREAK");
		//Movie Category
		ArrayList<String> Movies = new ArrayList<String>();
		Movies.add("TITANIC");
		Movies.add("STAR WARS");
		Movies.add("INDIANA JONES");
		Movies.add("THE DARK KNIGHT");
		Movies.add("PULP FICTION");
		//Food Category
		ArrayList<String> Food = new ArrayList<String>();
		Food.add("POUTINE");
		Food.add("RAVIOLI");
		Food.add("CHICKEN");
		Food.add("TURKEY");
		//Cars Category 
		ArrayList<String> Cars = new ArrayList<String>();
		Cars.add("MASERATI");
		Cars.add("AUDI");
		Cars.add("SUBARU");
		Cars.add("MERCEDES BENZ");
		Cars.add("TOYOTA");
		Cars.add("JAGUAR");
		Cars.add("PORSCHE");
		//Brands Category
		ArrayList<String> Brands = new ArrayList<String>();
		Brands.add("APPLE");
		Brands.add("NIKE");
		Brands.add("SUPREME");
		Brands.add("MICHAEL KORS");
		Brands.add("ADIDAS");
		//Category choices method
		categories.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(randomWord!="")
				{
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response = JOptionPane.showConfirmDialog(frame, 
							"Are you sure you want to stop playing this category","Categories",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(response == JOptionPane.YES_OPTION)
					{
						restart();
					}//end if
				}//end if for changing category
				String initialGuess = "";
				JDialog.setDefaultLookAndFeelDecorated(true);
				Object[] selectionValues = {"TV Shows","Movies","Food","Cars","Brands","Random"};
				String initialSelection = "TV Shows";
				Object selection = JOptionPane.showInputDialog(frame,"Select a Category",
						"Categories",JOptionPane.QUESTION_MESSAGE,null,selectionValues,initialSelection);
				String category ="";
				int randomNum;
				int randomNull = (int)(Math.random() * ((4 - 0) + 1) + 0);
				if(selection=="Random")
				{
					if(randomNull==0)
					{
						randomNum =  (int)(Math.random() * ((tvShows.size()-1 - 0) + 1) + 0);
						randomWord = tvShows.get(randomNum);
						category = "TV Shows";
					}
					else if(randomNull==1)
					{
						randomNum = (int)(Math.random() * ((Movies.size()-1 - 0) + 1) + 0);
						randomWord = Movies.get(randomNum);
						category = "Movies";
					}
					else if(randomNull==2)
					{
						randomNum = (int)(Math.random() * ((Food.size()-1 - 0) + 1) + 0);
						randomWord = Food.get(randomNum);
						category = "Food";
					}
					else if(randomNull==3)
					{
						randomNum = (int)(Math.random() * ((Cars.size()-1 - 0) + 1) + 0);
						randomWord = Cars.get(randomNum);
						category = "Cars";
					}
					else if(randomNull==4)
					{
						randomNum = (int)(Math.random() * ((Brands.size()-1 - 0) + 1) + 0);
						randomWord = Brands.get(randomNum);
						category = "Brands";
					}
				}//end random choice picker
				if(selection=="TV Shows")
				{
					randomNum =  (int)(Math.random() * ((tvShows.size()-1 - 0) + 1) + 0);
					randomWord = tvShows.get(randomNum);
					category = "TV Shows";
				}
				else if(selection=="Movies")
				{
					randomNum = (int)(Math.random() * ((Movies.size()-1 - 0) + 1) + 0);
					randomWord = Movies.get(randomNum);
					category = "Movies";
				}
				else if(selection=="Food")
				{
					randomNum = (int)(Math.random() * ((Food.size()-1 - 0) + 1) + 0);
					randomWord = Food.get(randomNum);
					category = "Food";
				}
				else if(selection=="Cars")
				{
					randomNum = (int)(Math.random() * ((Cars.size()-1 - 0) + 1) + 0);
					randomWord = Cars.get(randomNum);
					category = "Cars";
				}
				else if(selection=="Brands")
				{
					randomNum = (int)(Math.random() * ((Brands.size()-1 - 0) + 1) + 0);
					randomWord = Brands.get(randomNum);
					category = "Brands";
				}
				for(int j=0;j<randomWord.length();j++)
				{
					if(randomWord.charAt(j)==' ')
					{
						initialGuess+=" ";
					}
					else
					{
						initialGuess+= "-";
					}
				}//end for loop
				guessed.setText(initialGuess);
				category1.setText(category);
			}
		});//end category picker
		String keys = "QWERTYUIOPASDFGHJKLZXCVBNM";
		Box []keyboards = new Box[3];
		for (int b=0;b<3;b++)
		{
			keyboards[b] = Box.createHorizontalBox();
		}//end for  loop
		for(int i=0;i<keys.length();i++)
		{
			keyboard[i] = new JButton();
			keyboard[i].setText(keys.charAt(i)+"");
			if(i<=9)
			{
				keyboards[0].add(keyboard[i]);
				guess.add(keyboards[0],BorderLayout.NORTH);
			}
			else if(i>9 && i<19)
			{
				keyboards[1].add(keyboard[i]);
				guess.add(keyboards[1],BorderLayout.CENTER);
			}
			else if(i>=19)
			{
				keyboards[2].add(keyboard[i]);
				guess.add(keyboards[2],BorderLayout.SOUTH);
			}
			int b=i;
			keyboard[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(!randomWord.equals(""))
					{
						keyboard[b].setEnabled(false);
						String guess = keyboard[b].getText();
						checkGuess(guess);	
					}//end if
				}
			});//end keyboard action listener
		}//end for loop
		//Add components to frame
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}//end main
	public static void checkGuess(String guess)
	{
		boolean win = false;
		boolean correct = false;
		char guessLetter = guess.charAt(0);
		char catLetter,prevGuess;
		String gameGuess = "";
		for(int l=0;l<randomWord.length();l++)
		{
			catLetter = randomWord.charAt(l);
			prevGuess = guessed.getText().charAt(l);
			if(guessLetter == catLetter)
			{
				gameGuess+=guessLetter;
				correct = true;
			}
			else
			{
				gameGuess+=prevGuess;
			}
		}//end loop
		if(gameGuess.equals(randomWord))
		{
			win = true;
		}
		if(!correct)
		{
			tries--;
		}
		//Display Hangman images
		if(tries==7)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_7.png");
			hangmanLabel.setIcon(icon);
		}
		else if(tries==6)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_6.png");
			hangmanLabel.setIcon(icon);
		}
		else if(tries==5)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_5.png");
			hangmanLabel.setIcon(icon);

		}
		else if(tries==4)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_4.png");
			hangmanLabel.setIcon(icon);

		}
		else if(tries==3)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_3.png");
			hangmanLabel.setIcon(icon);

		}
		else if(tries==2)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_2.png");
			hangmanLabel.setIcon(icon);

		}
		else if(tries==1)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_1.png");
			hangmanLabel.setIcon(icon);

		}
		else if(tries==0)
		{
			icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_0.png");
			hangmanLabel.setIcon(icon);
		}
		guessed.setText(gameGuess);
		if(win)
		{
			JDialog.setDefaultLookAndFeelDecorated(true);
			int response = JOptionPane.showConfirmDialog(frame, 
					"Congratulations, you won!\nWould you like to play again","Congratulations",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.NO_OPTION) 
			{
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}//end if
			else if(response == JOptionPane.YES_OPTION)
			{
				restart();
			}//end else if
		}//end if
		else if(!win && tries==0)
		{
			JDialog.setDefaultLookAndFeelDecorated(true);
			int response = JOptionPane.showConfirmDialog(frame, 
					"Sorry, you lost\nThe answer was "+randomWord+"\nWould you like to play again?","",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.NO_OPTION) 
			{
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}//end if
			else if(response == JOptionPane.YES_OPTION)
			{
				restart();
			}//end else if
		}//end else if
	}//end checkGuess() method
	public static void restart()
	{
		icon = new ImageIcon("C:\\Users\\edams\\Coding Workspace\\Hangman\\hangmanimages\\Hangman_7.png");
		hangmanLabel.setIcon(icon);
		randomWord = "";
		tries = 7;
		guessed.setText("");
		category1.setText("");
		for(int i=0;i<26;i++)
		{
			keyboard[i].setEnabled(true);
		}//end for loop
	}//end restart() method
}//end class