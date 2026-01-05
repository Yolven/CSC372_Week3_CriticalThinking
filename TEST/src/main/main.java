package main;

import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.TextField;
import java.awt.event.ActionEvent;

class Frame extends JFrame {
	public Frame() {
		
	
	JFrame window = new JFrame("Layout Manager Example");
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set frame
    window.setSize(1000, 400);

    //panel
    JPanel panel_top_buttons = new JPanel();
    
    //add layout to panel
    panel_top_buttons.setLayout(new FlowLayout());



    //create buttons
    JButton button_time = new JButton("Time and Date");
    JButton button_save_time = new JButton("Save time and date");
    JButton button_change_background = new JButton("Change background color");
    JButton button_exit = new JButton("Exit"); 
    
    //create text spots
    TextField text_label = new TextField(100);
    
    //add actions to buttons
    button_time.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		text_label.setText(LocalDateTime.now().toString());
    		
    	}
    });
    
    //Save time to file button
    button_save_time.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		try {
				FileWriter write_to_file = new FileWriter("log.txt");
				write_to_file.write(LocalDateTime.now().toString());
				write_to_file.close();
				text_label.setText("Date and time sent to log.txt file.");
			} catch (IOException e1) {
				System.out.print("Error: Failed to print to file");
			}
    		
    	}
    });
    
    //random green background button
    button_change_background.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {

    		int random_number_green = (int)(Math.random() * 256);
    		
    		Color background_color = new Color(0, random_number_green, 0);
    		
    		panel_top_buttons.setBackground(background_color);
    	}
    });
    
    //exit button
    button_exit.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		System.exit(0);
    	}
    });
    //add buttons to panel
    panel_top_buttons.add(button_time);
    panel_top_buttons.add(button_save_time);
    panel_top_buttons.add(button_change_background);
    panel_top_buttons.add(button_exit);
    panel_top_buttons.add(text_label);
    
    //add everything to frame
    window.add(panel_top_buttons);

    
    //Button pressed actions
    
    //set frame as visable
    window.setVisible(true);
}
}

public class main {

    public static void main(String[] args) {
    	
    	Frame t = new Frame();

}
}