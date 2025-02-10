   package najah1;

 // importing the needed packages
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class MainWindow extends JFrame {

     // declaring all the compoments 
     private JPanel WelcomePanel;
     private JPanel DescPanel;
     private JPanel ImagePanel;
     private JPanel ButtonPanel;

     private JLabel WelcomeLabel;
     private JLabel DecsLabel;
     private JLabel ImageLabel;
    
     private JButton buttonStart;
    
     private ImageIcon mainPic;
       

     public MainWindow() {
        
         // Set the Title name
         setTitle("Welcome to Najah");
        
         // set A close operation
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         // set the appropriate Layout
         setLayout(new GridLayout(4, 1));
        
         // calling the method
         buildPanel();
        
         // set the Window size
         setSize(990, 790);
        
         // Center the frame on the screen
         setLocationRelativeTo(null);
        
         // to make the Window show
         setVisible(true);
     }

     private void buildPanel() {
        
         // Creating the first Panel with its components
         WelcomePanel = new JPanel();
         WelcomeLabel = new JLabel("Welcome To Najah Application");
         WelcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
         WelcomeLabel.setForeground(Color.black);
         WelcomePanel.add(WelcomeLabel);
        
         // Creating the secound Panel with its components
         DescPanel = new JPanel();
         DecsLabel = new JLabel("Our purpose is to help those who need our help.");
         DecsLabel.setFont(new Font("Serif", Font.BOLD, 20));
         DecsLabel.setForeground(Color.GRAY);
         DescPanel.add(DecsLabel);

         // Creating the third Panel with its components
         ButtonPanel = new JPanel();
         buttonStart = new JButton("Start");
         buttonStart.addActionListener(new ButtonStartAction());
         ButtonPanel.add(buttonStart);
  
         // Creating the forth Panel with its components
         ImagePanel = new JPanel();
         mainPic = new ImageIcon(new ImageIcon("mainPic.jpg").getImage().getScaledInstance(350, 170, Image.SCALE_DEFAULT));
         ImageLabel = new JLabel(mainPic);
         ImagePanel.add(ImageLabel);

         // Adding the 4 Panels to the pane
         add(WelcomePanel);
         add(DescPanel);
         add(ImagePanel);
         add(ButtonPanel);

    }

     /**
     * ButtonStartAction is an Action Listener that will move us to the next window if
     * we clicked "Start" button
     */
     private class ButtonStartAction implements ActionListener {
         /**
         * 
         * @param e 
         */
         @Override
         public void actionPerformed(ActionEvent e) {
            InfoWindow window = new InfoWindow();
            setVisible(false); // hide the MainWindow 
            dispose();
         }
     }

     public static void main(String[] args) {
         
         MainWindow mainWindow = new MainWindow();
     }
 }