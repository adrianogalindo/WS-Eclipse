package simpleEditor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class mainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea textArea = new JTextArea();

	private JPanel contentPane;
	private JMenuItem mntmSave;
	/**
	 * Launch the application.
	 */
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mainFrame frame = new mainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
		
	private boolean isDataDisposable() {
		if (FileAccess.notSaved) {
			int result = JOptionPane.showConfirmDialog(null,
					"Voulez-vous enregistrer les modifications ?", 
					"Simple Editor",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				mySave();
				if (FileAccess.notSaved) {return false; }
				else { return true; }
			}
			else if (result == JOptionPane.CANCEL_OPTION) {
				// user chose to stop operation
				return false;
			}
			else if (result == JOptionPane.NO_OPTION)
			{
				// user want to dispose the changes
				return true;
			} else {
				//user has not chosen
				return false;
			}
		}
		else {
			// not saved is false
			return true;
		}
	}
	
	private void myClose() {
		if(isDataDisposable()) {
			System.exit(0);
		}
	}
	
	private void mySaveAs() {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setCurrentDirectory(new File("c:\\"));
		FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
		filechooser.addChoosableFileFilter(filter);
		filechooser.setFileFilter(filter);
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filechooser.setMultiSelectionEnabled(false);
		
		if(filechooser.showDialog(null,  "Save As") == JFileChooser.APPROVE_OPTION) {
			String selFile = filechooser.getSelectedFile().getAbsolutePath();
			String selFileName = filechooser.getSelectedFile().getName();
			if(selFileName.lastIndexOf(".") < 0) {
				selFile = selFile + ".txt";
			}
			try {
				FileAccess.myWriteFile(selFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void mySave() {
		if(FileAccess.currentframe != "") {
			try {
				FileAccess.myWriteFile(FileAccess.currentframe);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			mySaveAs();
		}
	}
	
	
	private void myOpen() {
		if (isDataDisposable()) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("c:\\"));
			FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				try {
					FileAccess.myReadFile(fileChooser.getSelectedFile().getAbsolutePath());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	
	public mainFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				myClose();
			}
		});
		setTitle("Simple Editor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Code ICI
				if(isDataDisposable()) {
					textArea.setText("");
					FileAccess.notSaved = false;
					FileAccess.currentframe="";
				}
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myOpen();
			}
		});
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Code ICI
				mySave();
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Code ICI
				mySaveAs();
			}
		});
		mnFile.add(mntmSaveAs);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myClose();
//				Code ICI
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "Simple Editor created by Adriano";
				JOptionPane.showMessageDialog(null, msg, "About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
//		JTextArea textArea = new JTextArea();		
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				FileAccess.notSaved = true;
			}
			
			public void insertUpdate(DocumentEvent e) {
				FileAccess.notSaved = true;
			}
			
			public void changedUpdate(DocumentEvent e) {
				FileAccess.notSaved = true;
			}
		});
		
		
		contentPane.add(textArea);
	}
}
