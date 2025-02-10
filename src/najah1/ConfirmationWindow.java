 package najah1;

 // importing the needed packages
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import javax.swing.*;

 public class ConfirmationWindow extends JFrame {

     // declaring all the compoments 
     
     private JLabel Title;
     private JLabel nameLabel;
     private JLabel phoneNumberLabel;
     private JLabel peopleLabel;

     private JButton confirmButton;
     private JButton makeChangesButton;

     public ConfirmationWindow() throws FileNotFoundException, IOException {

          // set the Title
         setTitle("Confirmation");
         
         // set A close operation
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         // set the appropriate Layout
         setLayout(new GridLayout(5, 1));
        
         // set the Window size
         setSize(990, 790);
        
         // Center the frame on the screen
         setLocationRelativeTo(null);

         // reading user’s inforamtion from a Binary file
         String readName, readPhone,readNumOfPeople;
         DataInputStream inputFile = new DataInputStream(new FileInputStream("UsersInfo.dat"));
                      readName = inputFile.readUTF();
                      readPhone = inputFile.readUTF();
                      readNumOfPeople = inputFile.readUTF();
                  
   
         // Display all the user’s information on the window (after reading it from the binary file)
         nameLabel = new JLabel("Name: " + readName);
         phoneNumberLabel = new JLabel("Phone Number: " + readPhone);
         peopleLabel = new JLabel("Number of people who need help: " + readNumOfPeople);
         
         //Creating the title label
         Title = new JLabel("Please confirm your information:");
         // set the Font type and the Font Color
         Title.setFont(new Font("Serif", Font.BOLD, 20));
         Title.setForeground(Color.orange);
         
         // Creating the Confirm button and Connect the Action Listener with it
         confirmButton = new JButton("Confirm");
         confirmButton.addActionListener(new ConfirmAction());

         // Creating the "Make Changes" button and Connect the Action Listener to it
         makeChangesButton = new JButton("Make Changes");
         makeChangesButton.addActionListener(new MakeChangesAction());
        
         // Creating the Panels and adding the components on it
         JPanel ConfirmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         
         ConfirmPanel.add(Title);
         
         JPanel NamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         NamePanel.add(nameLabel);

         JPanel PhonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         PhonePanel.add(phoneNumberLabel);

         JPanel NoOfPeoplePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         NoOfPeoplePanel.add(peopleLabel);

         JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         ButtonPanel.add(confirmButton);
         ButtonPanel.add(makeChangesButton);

         // Adding the 5 Panels to the pane
         add(ConfirmPanel);
         add(NamePanel);
         add(PhonePanel);
         add(NoOfPeoplePanel);
         add(ButtonPanel);

         // to make the Window show
         setVisible(true);
     }
    
 
     /**
     * ConfirmAction is an Action that will move us to the next window if
     * we clicked "Confirm" button
     */
     private class ConfirmAction implements ActionListener {
     @Override
         public void actionPerformed(ActionEvent e) {
        
             // We will get the user’s information then display it on JOption Pane
             String name = nameLabel.getText();
             String phoneNumber = phoneNumberLabel.getText();
             String numberOfPeople = peopleLabel.getText();

             String message = "The Confirmed Information:\n\n";
             message += name + "\n";
             message += phoneNumber + "\n";
             message += numberOfPeople + "\n";

             JOptionPane.showMessageDialog(null, message);

             // After confirming the user’s informaton, we will move to the next window
              DamageWindow damageWindow = new DamageWindow();
             damageWindow.setVisible(true);

             setVisible(false);
             dispose();
             }
     }

     /**
     * MakeChangesAction is an Action that will move us to the next window if
     * we clicked "Make changes" button
     */
     private class MakeChangesAction implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
            
             InfoWindow infoWindow = new InfoWindow();
             infoWindow.setVisible(true);
             setVisible(false); // hide the ConfirmationWindow 
             dispose();
        
         }
    
     }

 }