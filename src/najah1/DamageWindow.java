package najah1;

// importing the needed packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DamageWindow extends JFrame {
 
     // declaring all the compoments 
     private JLabel message;
     
     private final int LABEL_WIDTH = 400;
     private final int LABEL_HEIGHT = 200;


     private JMenuBar menuBar;
     private JMenu ProblemMenu;
     private JMenu FileMenu;
     private JMenuItem Exit;

     private JRadioButtonMenuItem carA;
     private JRadioButtonMenuItem Drown;
     private JRadioButtonMenuItem Power;
     private JRadioButtonMenuItem Dissp;
     private JRadioButtonMenuItem Health;

     private ButtonGroup Rgruop;

     private JButton rate;
     private JButton tips;


     public DamageWindow() {
         
         // set the Title
         setTitle("Damage Menu");
    
         // set A close operation
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
         // set the Window size
         setSize(990, 790);
        
         // Center the frame on the screen
         setLocationRelativeTo(null);
      
         // Create a label to be in the Center of the Menu Window
         message = new JLabel("Please choose one of the problem from the damage menu",SwingConstants.CENTER);
         // set the Font type and the Font Color
         message.setPreferredSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
         message.setFont(new Font("Serif",Font.BOLD,20));
         message.setForeground(Color.black);
          
         // Calling the method
         bulidMenu();

         // Adding the Label to the Pane
         add(message);
   
         // to make the Window show
         setVisible(true);
     }

     

     private void bulidMenu() {
         
         // Creating Menu Bar
         menuBar = new JMenuBar();

         // Calling bulidFileMenu method
         bulidFileMenu();

         // Calling bulidProblemMenu method
         bulidProblemMenu();

         // Adding the 2 Menus to the Menu Bar
         menuBar.add(FileMenu);
         menuBar.add(ProblemMenu);

         // Setting the Menu Bar
         setJMenuBar(menuBar);

         // Creating the Show Tips button and Connect the Action Listener with it
         tips = new JButton("Show Tips");
         tips.addActionListener(new tipsAction());

         // Creating the Rate Page button and Connect the Action Listener with it
         rate = new JButton("Rate Page");
         rate.addActionListener(new rateAction());

         // Creating A Panel that contain the 2 buttons
         JPanel buttonPanel = new JPanel();

         // Adding the 2 buttons to their Panel
         buttonPanel.add(tips);
         buttonPanel.add(rate);

         // Adding the Panel in a Border Layout then Adding them all to the Pane
         add(buttonPanel, BorderLayout.SOUTH);

     }


     
     private void bulidFileMenu() {
    
         // Creating Exit Menu Item and connect it with an Action Listener
         Exit = new JMenuItem("Exit");
         Exit.setMnemonic(KeyEvent.VK_X);
         Exit.addActionListener(new ExitAction());
    
         // Creating Exit Menu Item to the File Menu 
         FileMenu = new JMenu("Exit");
         FileMenu.setMnemonic(KeyEvent.VK_F);
         FileMenu.add(Exit);
    
    

     }

     private void bulidProblemMenu() {
    
         // Creating a radio button for the proplem NO.1 and connect it with an Action Listener
         carA = new JRadioButtonMenuItem("Car Accident");
         carA.setMnemonic(KeyEvent.VK_C);
         carA.addActionListener(new problemsListener());
    
         // Creating a radio button for the proplem NO.2 and connect it with an Action Listener
         Power = new JRadioButtonMenuItem("Power Outage");
         Power.setMnemonic(KeyEvent.VK_P);
         Power.addActionListener(new problemsListener());
    
   
         // Creating a radio button for the proplem NO.3 and connect it with an Action Listener
         Drown = new JRadioButtonMenuItem("Drowning");
         Drown.setMnemonic(KeyEvent.VK_D);
         Drown.addActionListener(new problemsListener());
    
         // Creating a radio button for the proplem NO.4 and connect it with an Action Listener
         Dissp = new JRadioButtonMenuItem("Disappear");
         Dissp.setMnemonic(KeyEvent.VK_S);
         Dissp.addActionListener(new problemsListener());
    
         // Creating a radio button for the proplem NO.5 and connect it with an Action Listener
         Health = new JRadioButtonMenuItem("Health Problems");
         Health.setMnemonic(KeyEvent.VK_H);
         Health.addActionListener(new problemsListener());
    
         // Creating Button Group and Adding all the 5 radio buttons to it
         Rgruop = new ButtonGroup();
         Rgruop.add(carA);
         Rgruop.add(Power);
         Rgruop.add(Drown);
         Rgruop.add(Dissp);
         Rgruop.add(Health);
     
         // Creating a Menu Called Problem Menu
         ProblemMenu = new JMenu("Problem Menu");
         ProblemMenu.setMnemonic(KeyEvent.VK_R);
    
         // Adding the 5 radio buttons to the Problem Menu
         ProblemMenu.add(carA);
         ProblemMenu.add(Power);
         ProblemMenu.add(Drown);
         ProblemMenu.add(Dissp);
         ProblemMenu.add(Health);
    
         // Adding a Separator to separte between the Problem Menu elements
         ProblemMenu.addSeparator();

     }


     /**
     * problemsListener is an Action that will show an action after
     * we click to any one of the 5 radio buttons 
     */
     private class problemsListener implements ActionListener {
     
         @Override
         public void actionPerformed(ActionEvent e) {
         
             if(carA.isSelected()) {
             
                 JOptionPane.showMessageDialog(null, "You selected Car Accident Option: You need to call 993");
        
             }
        
             else if(Drown.isSelected()) {
             
                 JOptionPane.showMessageDialog(null, "You selected Drowning Option: You need to call 998");
         
             }
        
             else if(Power.isSelected()) {
           
                 JOptionPane.showMessageDialog(null, "You selected Power Outage Option: You need to call 92301100");
         
             }
         
             else if(Dissp.isSelected()) {
            
                 JOptionPane.showMessageDialog(null, "You selected Disappear Option: You need to call 911");
       
             }
         
             else if(Health.isSelected()) {
          
                 JOptionPane.showMessageDialog(null, "You selected Health Problems Option: You need to call 997");
       
             }
         
   
         }

     }
     

     /**
     * ExitAction is an Action that will Exit the Program if its clicked
     */
     private class ExitAction implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
             System.exit(0);
         }        
     }

     /**
     * tipsAction is an Action that will display helpful Tips that can help the users in their situations
     */
     private class tipsAction implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, 
        "* Stay calm and take a deep breath\n" +
        "* Call the number we have recommended to you\n" +
        "* Please follow the administrator's instructions\n" +
        "* Help will be there for you as soon as possible");
}
     }
     
     /**
     * rateAction is an Action that will move to the next window if its clicked
     */
     private class rateAction implements ActionListener {
          @Override
          public void actionPerformed(ActionEvent e) {
       
              rateWindow rating = new rateWindow();
             rating.setVisible(true); // Show the rateWindow
             dispose(); // Dispose the current window if necessary
    
    

          }

     }

    
 }