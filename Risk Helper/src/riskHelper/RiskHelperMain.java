package riskHelper;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class RiskHelperMain {
	public int attkUnits;
	public int dfndUnits;
	public String attkRollStr;
	public String dfndRollStr;
	
	private JFrame frame;
	private JTextField textFieldAttk;
	private JTextField textFieldDfnd;
	private JTextField attkRoll;
	private JTextField dfndRoll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiskHelperMain window = new RiskHelperMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int[] BubbleSort( int [ ] num )
	{
	     int i;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( i=0;  i < num.length -1;  i++ )
	            {
	                   if ( num[ i ] < num[i+1] )   // change to > for ascending sort
	                   {
	                           temp = num[ i ];                //swap elements
	                           num[ i ] = num[ i+1 ];
	                           num[ i+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      }
	     return num;
	} 
	
	/**
	 * Create the application.
	 */
	public RiskHelperMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 476, 181);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{117, 113, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		frame.setIconImage(createImage("/resource/Icon.png").getImage());
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 0;
		panel.add(separator_1, gbc_separator_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel.add(separator, gbc_separator);
		
		JLabel lblAttackingUnits = new JLabel("Attacking Units");
		GridBagConstraints gbc_lblAttackingUnits = new GridBagConstraints();
		gbc_lblAttackingUnits.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttackingUnits.gridx = 1;
		gbc_lblAttackingUnits.gridy = 1;
		panel.add(lblAttackingUnits, gbc_lblAttackingUnits);
		
		JLabel lblDefendingUnits = new JLabel("Defending Units");
		GridBagConstraints gbc_lblDefendingUnits = new GridBagConstraints();
		gbc_lblDefendingUnits.insets = new Insets(0, 0, 5, 0);
		gbc_lblDefendingUnits.gridx = 2;
		gbc_lblDefendingUnits.gridy = 1;
		panel.add(lblDefendingUnits, gbc_lblDefendingUnits);
		
		textFieldAttk = new JTextField();
		textFieldAttk.setText("2");
		GridBagConstraints gbc_textFieldAttk = new GridBagConstraints();
		gbc_textFieldAttk.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAttk.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAttk.gridx = 1;
		gbc_textFieldAttk.gridy = 2;
		panel.add(textFieldAttk, gbc_textFieldAttk);
		textFieldAttk.setColumns(10);
		
		textFieldDfnd = new JTextField();
		textFieldDfnd.setText("1");
		GridBagConstraints gbc_textFieldDfnd = new GridBagConstraints();
		gbc_textFieldDfnd.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDfnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDfnd.gridx = 2;
		gbc_textFieldDfnd.gridy = 2;
		panel.add(textFieldDfnd, gbc_textFieldDfnd);
		textFieldDfnd.setColumns(10);
		
		JLabel lblAttackerRoll = new JLabel("Attacker Roll");
		GridBagConstraints gbc_lblAttackerRoll = new GridBagConstraints();
		gbc_lblAttackerRoll.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttackerRoll.gridx = 1;
		gbc_lblAttackerRoll.gridy = 3;
		panel.add(lblAttackerRoll, gbc_lblAttackerRoll);
		
		JLabel lblDefenderRoll = new JLabel("Defender Roll");
		GridBagConstraints gbc_lblDefenderRoll = new GridBagConstraints();
		gbc_lblDefenderRoll.insets = new Insets(0, 0, 5, 0);
		gbc_lblDefenderRoll.gridx = 2;
		gbc_lblDefenderRoll.gridy = 3;
		panel.add(lblDefenderRoll, gbc_lblDefenderRoll);
		
		attkRoll = new JTextField();
		attkRoll.setEditable(false);
		GridBagConstraints gbc_attkRoll = new GridBagConstraints();
		gbc_attkRoll.insets = new Insets(0, 0, 0, 5);
		gbc_attkRoll.fill = GridBagConstraints.HORIZONTAL;
		gbc_attkRoll.gridx = 1;
		gbc_attkRoll.gridy = 4;
		panel.add(attkRoll, gbc_attkRoll);
		attkRoll.setColumns(10);
		
		dfndRoll = new JTextField();
		dfndRoll.setEditable(false);
		GridBagConstraints gbc_dfndRoll = new GridBagConstraints();
		gbc_dfndRoll.fill = GridBagConstraints.HORIZONTAL;
		gbc_dfndRoll.gridx = 2;
		gbc_dfndRoll.gridy = 4;
		panel.add(dfndRoll, gbc_dfndRoll);
		dfndRoll.setColumns(10);
		
		JButton btnRollOnce = new JButton("Roll Once");
		btnRollOnce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attkUnits = Integer.parseInt(textFieldAttk.getText());
				dfndUnits = Integer.parseInt(textFieldDfnd.getText());
				
				System.out.println(attkUnits);
				System.out.println(dfndUnits);
				
				rollOnce(attkUnits, dfndUnits);
				
				System.out.println("Event started");
				
				textFieldAttk.setText(String.valueOf(attkUnits));
				textFieldDfnd.setText(String.valueOf(dfndUnits));
				
				System.out.println("roll is being set");
				attkRoll.setText(attkRollStr);
				dfndRoll.setText(dfndRollStr);
				System.out.println("| - - - - End of roll - - - - |");
			}
		});
		GridBagConstraints gbc_btnRollOnce = new GridBagConstraints();
		gbc_btnRollOnce.gridx = 0;
		gbc_btnRollOnce.gridy = 1;
		frame.getContentPane().add(btnRollOnce, gbc_btnRollOnce);
	}
	
	private ImageIcon createImage(String path) {
		// TODO Auto-generated method stub
		return new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getClass().getResource(path));
	}

	public void rollOnce(int A, int D){
		//Random rn = new Random();
		
		//3 A dice
		if(A > 3 && D > 0){
			System.out.println("3A dice");
			int[] attkArray = new int[3]; //A
			for(int i =0; i < 3; i ++){
				attkArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
				
			}
			
			//2 D dice
			if(D > 1){
				System.out.println("2D dice");
				int[] dfndArray = new int[2];
				for(int i =0; i < 2; i ++){
					dfndArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
					
				}
				BubbleSort(attkArray);
				BubbleSort(dfndArray);
				
				//Check rolls 3A 2D
				if(attkArray[0] > dfndArray[0]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				if(attkArray[1] > dfndArray[1]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				attkRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) + ", " + (String.valueOf(attkArray[2])) );
				dfndRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) );
				return;
			}
			//1 D die
			else{
				System.out.println("1D dice");
				int[] dfndArray = new int[1];
				for(int i =0; i < 1; i ++){
					dfndArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
					
				}
				BubbleSort(attkArray);
				BubbleSort(dfndArray);
				
				//Check rolls 3A 1D
				if(attkArray[0] > dfndArray[0]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				attkRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) + ", " + (String.valueOf(attkArray[2])) );
				dfndRollStr = ((String.valueOf(attkArray[0])) );
				return;
			}
		}
		//2 A dice
		else if(A > 2 && D > 0){
			System.out.println("2A dice");
			int[] attkArray = new int[2]; //A
			for(int i =0; i < 2; i ++){
				attkArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
				
			}
			
			//2 D dice
			if(D > 1){
				System.out.println("2D dice");
				int[] dfndArray = new int[2];
				for(int i =0; i < 2; i ++){
					dfndArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
					
				}
				BubbleSort(attkArray);
				BubbleSort(dfndArray);
				
				//Check rolls 2A 2D
				if(attkArray[0] > dfndArray[0]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				if(attkArray[1] > dfndArray[1]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				attkRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) );
				dfndRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) );
				return;
			}
			//1 D die
			else{
				System.out.println("1D dice");
				int[] dfndArray = new int[1];
				for(int i =0; i < 1; i ++){
					dfndArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
					
				}
				BubbleSort(attkArray);
				BubbleSort(dfndArray);
				
				//Check rolls 2A 1D
				if(attkArray[0] > dfndArray[0]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				attkRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) );
				dfndRollStr = ((String.valueOf(attkArray[0])) );
				return;
			}
		}
		//1 A die
		else if(A > 1 && D > 0){
			System.out.println("1A dice");
			int[] attkArray = new int[1]; //A
			for(int i =0; i < 1; i ++){
				attkArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
				
			}
			
			//2 D dice
			if(D > 1){
				System.out.println("2D dice");
				int[] dfndArray = new int[2];
				for(int i =0; i < 2; i ++){
					dfndArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
					
				}
				BubbleSort(attkArray);
				BubbleSort(dfndArray);
				
				//Check rolls 1A 2D
				if(attkArray[0] > dfndArray[0]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				attkRollStr = ((String.valueOf(attkArray[0])) );
				dfndRollStr = ((String.valueOf(attkArray[0])) + ", " + (String.valueOf(attkArray[1])) );
				return;
			}
			//1 D die
			else{
				System.out.println("1D dice");
				int[] dfndArray = new int[1];
				for(int i =0; i < 1; i ++){
					dfndArray[i] = (int) (1 + (Math.random() * (6 - 1))); 
					
				}
				BubbleSort(attkArray);
				BubbleSort(dfndArray);
				
				//Check rolls 1A 1D
				if(attkArray[0] > dfndArray[0]){
					dfndUnits --;
				}
				else{
					attkUnits --;
				}
				
				attkRollStr = ((String.valueOf(attkArray[0])) );
				dfndRollStr = ((String.valueOf(attkArray[0])) );
				return;
			}
		}
		else if( A <=1){
			System.out.println("Default 1");
			attkRollStr = ("Not enough units to attack.");
			dfndRollStr = ("");
		}
		else if(D <= 0){
			System.out.println("Default 2");
			attkRollStr = ("Attacker wins.");
			dfndRollStr = ("No units left, attacker wins.");
		}
	}

}
