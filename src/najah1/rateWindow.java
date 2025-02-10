 package najah1;

 // importing the needed packages
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.event.*;
 import javax.swing.*;

 public class rateWindow extends JFrame {

     // declaring all the compoments
     private JSlider ratingSlider;
     
     private JButton finishButton;
    
     private JTextArea feedbackTextArea;
    
     private JLabel starsLabel;
     private JLabel textLabel;
    
     private JPanel TextPanel;
     private JPanel SliderPanel;
     private JPanel starsPanel;
     private JPanel textAreaPanel;
     private JPanel buttonPanel;

     public rateWindow() {
        
         // Set the Title name
         setTitle("Rating Window");
        
         // set A close operation
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         // set the appropriate Layout
         setLayout(new GridLayout(5, 1));
        
         // set the Window size
         setSize(990, 790);
        
         // Center the frame on the screen
         setLocationRelativeTo(null);
        
         // calling the method
         buildPanel();
                
       
     }
       
     private void buildPanel() {
                
         // Creating text Panel and Adding its components to it
         TextPanel = new JPanel();
         textLabel = new JLabel("Please rate our service");
         TextPanel.add(textLabel);
         textLabel.setFont(new Font("Serif", Font.BOLD, 20));
         textLabel.setForeground(Color.GRAY);
        
         // Creating the Slider and its Panel, Adding to the Slider Change Listener
         SliderPanel = new JPanel();
         ratingSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
         ratingSlider.setMajorTickSpacing(1);
         ratingSlider.setMinorTickSpacing(1);
         ratingSlider.setPaintTicks(true);
         ratingSlider.setPaintLabels(true);
         ratingSlider.setPreferredSize(new Dimension(300, 100));
         ratingSlider.addChangeListener(new SliderChangeListener());
         SliderPanel.add(ratingSlider);

        
         // Creating the stars Label
         starsLabel = new JLabel();
         starsLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 50));
         starsLabel.setHorizontalAlignment(SwingConstants.CENTER);
         starsLabel.setForeground(Color.ORANGE);
         // Creating the stars Panel and Adding stars Label to it
         starsPanel = new JPanel();
         starsPanel.add(starsLabel);

        
         // Create text Area and Adding it to its Panel
         textAreaPanel = new JPanel();
         feedbackTextArea = new JTextArea(5, 30);
         feedbackTextArea.setLineWrap(true);
         feedbackTextArea.setWrapStyleWord(true);
         feedbackTextArea.setBorder(BorderFactory.createTitledBorder("Feedback"));
         JScrollPane feedbackScrollPane = new JScrollPane(feedbackTextArea);
         textAreaPanel.add(feedbackScrollPane);

         // Creating finish button and connect it with an Action Listener, then Add it to the PAnel
         finishButton = new JButton("Finish");
         finishButton.addActionListener(new FinishButtonAction());
         buttonPanel = new JPanel();
         buttonPanel.add(finishButton);

         // Adding the 5 Panels to the Pane
         add(TextPanel);
         add(starsPanel);
         add(SliderPanel);
         add(textAreaPanel);
         add(buttonPanel);
    
     }

     /**
     * SliderChangeListener is an Change Listener that will make us to choose and change the Slider values
     */
     private class SliderChangeListener implements ChangeListener {
         @Override
         public void stateChanged(ChangeEvent e) {
            
             int rating = ratingSlider.getValue();
             starsLabel.setText(getStars(rating));
         }
     }

     /**
     * getStars is an method that give us a Unicode escape sequences 
     * representing the filled star ★ and empty star ☆ characters
     */
    
     private String getStars(int rating) {
         String stars = "\u2605".repeat(Math.max(0, rating)) +
                   "\u2606".repeat(Math.max(0, 5 - rating));
    
         return stars;
 
     }


     private class FinishButtonAction implements ActionListener {
        
         @Override
         public void actionPerformed(ActionEvent e) {
        
      
             String UserFeedback = feedbackTextArea.getText();
       
             if (!UserFeedback.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
       
             }
        
             dispose();
             
             // Terminate the entire application
             System.exit(0); // Terminate the entire application
    
         }

     }


 }