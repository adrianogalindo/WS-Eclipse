package pack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUITextFile {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITextFile window = new GUITextFile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUITextFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(68, 59, 308, 102);
		frame.getContentPane().add(textArea);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintWriter w;
				try {
					w = new PrintWriter (new FileWriter("mytext.txt"));
					w.write(textArea.getText());
					w.close();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(287, 185, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					BufferedReader w = new BufferedReader (new FileReader("mytext.txt"));
					String v = w.readLine();
					while(v!=null) {
						textArea.append(v+'\n');
						v = w.readLine();
					}
					w.close();
					
				}catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnOpen.setBounds(59, 185, 89, 23);
		frame.getContentPane().add(btnOpen);
		
	}
}
