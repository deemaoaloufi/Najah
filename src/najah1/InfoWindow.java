 package najah1;

 // importing the needed packages
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.io.*;

 public class InfoWindow extends JFrame {

     // declaring all the compoments 
    
     private JTextField NameText;
     private JTextField PhoneText;
     private JTextField NumOfPeopleText;

     private JLabel EnterInfolabel;
     private JLabel EnterNameLabel;
     private JLabel EnterPhoneLabel;
     private JLabel EnterNoOfPeopleLabel;
    
     private JPanel EnterInfoPanel;
     private JPanel EnterNamePanel;
     private JPanel EnterPhonePanel;
     private JPanel EnterNoOfPeoplePanel;
     private JPanel NextButtonPanel;
 
     private JButton nextButton;

     public InfoWindow() {
        
         // Set the Title name
         setTitle("Information");
        
         // set A close operation
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         // is set to true so we can control the size of the window (min, max, close)
         setResizable(true);
        
         // set the appropriate Layout
         setLayout(new GridLayout(5, 1));
        
         // calling the method
         buildPanelInfo();
         
         // set the Window size
         setSize(990, 790); 
        
         // Center the frame on the screen
         setLocationRelativeTo(null); 
        
         // to make the Window show
         setVisible(true);
     }

     private void buildPanelInfo() {
        
         // Creating and choosing a layout for Panels
         EnterInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         EnterNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         EnterPhonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         EnterNoOfPeoplePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         NextButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

         // Creating Label 1
         EnterInfolabel = new JLabel("Enter the following information: ");
         // set the Font type and the Font Color
         EnterInfolabel.setFont(new Font("Serif", Font.BOLD, 20));
         EnterInfolabel.setForeground(Color.BLACK);
 
         // Creating Label 2
         EnterNameLabel = new JLabel("Name: ");
         // set the Font type and the Font Color
         EnterNameLabel.setFont(new Font("Serif", Font.BOLD, 15));
         EnterNameLabel.setForeground(Color.GRAY);

         // Creating Label 3
         EnterPhoneLabel = new JLabel("Phone Number: ");
         // set the Font type and the Font Color
         EnterPhoneLabel.setFont(new Font("Serif", Font.BOLD, 15));
         EnterPhoneLabel.setForeground(Color.GRAY);
 
         // Creating Label 4
         EnterNoOfPeopleLabel = new JLabel("Number of people who need help: ");
         // set the Font type and the Font Color
         EnterNoOfPeopleLabel.setFont(new Font("Serif", Font.BOLD, 15));
         EnterNoOfPeopleLabel.setForeground(Color.GRAY);

         // Cretint Text 3 text Feilds for user’s information
         NameText = new JTextField(10);
         PhoneText = new JTextField(10);
        NumOfPeopleText = new JTextField(10);
        
         // Creating the button and Connect the Action Listener with it
         nextButton = new JButton("Next");
         nextButton.addActionListener(new nextWindowAction());
        
         // Adding the Components to their Panels
         EnterInfoPanel.add(EnterInfolabel);
         EnterNamePanel.add(EnterNameLabel);
         EnterNamePanel.add(NameText);
         EnterPhonePanel.add(EnterPhoneLabel);
         EnterPhonePanel.add(PhoneText);
         EnterNoOfPeoplePanel.add(EnterNoOfPeopleLabel);
         EnterNoOfPeoplePanel.add(NumOfPeopleText);
         NextButtonPanel.add(nextButton);

         // Adding the Panels to the Pane
         add(EnterInfoPanel);
         add(EnterNamePanel);
         add(EnterPhonePanel);
         add(EnterNoOfPeoplePanel);
         add(NextButtonPanel);
     }
 
     /**
     * nextWindoAction 
     * this Action Listener is connected with the "Next" button it will ONLY move to the next window if the statmnets 
     * in Action Performed is correct
     */
     private class nextWindowAction implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent e) {
            
             // getting the user’s inforamtion from text feilds to store it in a file/check it
             String check1 = NameText.getText();
             String check2 = PhoneText.getText();
             String check3 = NumOfPeopleText.getText();

             try {
                 // to check the information validate 
                 checkInput(check1, check2, check3);

                 // writing user’s inforamtion into a Binary file
                 try(DataOutputStream outputFile = new DataOutputStream(new FileOutputStream("UsersInfo.dat"))) {
                     
                     outputFile.writeUTF(check1);
                     outputFile.writeUTF(check2);
                     outputFile.writeUTF(check3);
                 }

              
                 // Move to the Next window, by sending the values in a Constructor
                 ConfirmationWindow window = new ConfirmationWindow();
                 setVisible(false); // hide the InfoWindow 
                 dispose();
            
             } 
             
             // catch block that realted to our Custom Exception Class
             catch (InfoException ex) {
                 
                 JOptionPane.showMessageDialog(null, ex.getMessage());
                
                 // catch block that realted to our Input/Output Exception
             } 
             catch (IOException ex) {
                 
                 JOptionPane.showMessageDialog(null, "Error accessing the file");
             }
         }

         /**
         * a chekInput method, this method will take the user’s information and test all if clauses 
         * for input Validation, the user will not move to the next window until he provide a correct and logic information
         */
         private void checkInput(String check1, String check2, String check3) throws InfoException {
            
             String errorMessage = "";

             if (check1.isEmpty() || !check1.matches("[a-zA-Z]+(\\s[a-zA-Z]+)*")) {
                  errorMessage += "Please make sure to enter a valid name using letters and spaces only!\n";
             }


             if (check2.isEmpty() || !check2.matches("\\d+") || check2.length() != 10) {
                 errorMessage += "Please make sure to enter a valid phone number using '10' numbers only!\n";
             }

             if (check3.isEmpty() || !check3.matches("\\d+")) {
                 errorMessage += "Please make sure to enter a valid number of people using numbers only!\n";
             }

             if (!errorMessage.isEmpty()) { // if one or more errorMessage above is assigned to it’s message, an Exception will be 
                 throw new InfoException(errorMessage);
             }
         }
     }
 }