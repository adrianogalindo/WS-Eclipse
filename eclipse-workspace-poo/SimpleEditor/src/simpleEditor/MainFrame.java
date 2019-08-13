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

public class MainFrame extends JFrame {

	JTextArea textArea = new JTextArea();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	private boolean isDataDisposible() {
		// vrai - les données en mémoire ne sont pas nécessaire.
		// faux - les données en mémoire sont nécessaire.

		if (FileAccess.notSaved) {
			int result = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer les modifications?",
					"Simple Editor", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				mySave();
				if (FileAccess.notSaved) {
					return false;
				} else {
					return true;
				}
			} else if (result == JOptionPane.CANCEL_OPTION) {
				// user choose to stop operation
				return false;
			} else if (result == JOptionPane.NO_OPTION) {
				return true;
			} else {
				// user want to dispose the changes
				return false;
			}
		} else {
			// notSaved is false
			return true;
		}

	}

	private void myClose() {
		if (isDataDisposible()) {
			try {
				FileAccess.mySetCurrentFile("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

	private void mySaveAs() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("c:\\"));
		FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(false);

		// if (fileChooser,showSaveDialog(null) == JFileChoose.APPROVE_OPTION)
		if (fileChooser.showDialog(null, "Save As") == JFileChooser.APPROVE_OPTION) {
			String selFile = fileChooser.getSelectedFile().getAbsolutePath();
			String selFileName = fileChooser.getSelectedFile().getName();
			if (selFileName.lastIndexOf(".") < 0) {
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
		if (FileAccess.currentfname != "") {
			try {
				FileAccess.myWriteFile(FileAccess.currentfname);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			mySaveAs();
		}
	}

	private void myOpen() {
		if (isDataDisposible()) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("c:\\"));
			FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setFileFilter(filter);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
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
	public MainFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				myClose();
			}
		});
		setTitle("EditeurCS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isDataDisposible()) {
					textArea.setText("");
					FileAccess.notSaved = false;
					// FileAccess.currentfname = "";
					try {
						FileAccess.mySetCurrentFile("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
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

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySave();
			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySaveAs();
			}
		});
		mnFile.add(mntmSaveAs);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// codez ici
				myClose();
			}
		});
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Help");
		menuBar.add(mnEdit);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "Text editor created by Mirela Holanda";
				JOptionPane.showMessageDialog(null, msg, "About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnEdit.add(mntmAbout);
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
