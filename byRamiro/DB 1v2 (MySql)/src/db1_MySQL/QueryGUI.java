package db1_MySQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryGUI frame = new QueryGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QueryGUI() {	
		try {
			 // 
		     Class.forName("com.mysql.jdbc.Driver");
		     //
			 String url = "jdbc:mysql://localhost:3306/EMP";
			 Connection con = DriverManager.getConnection(
					          url,"root", "root");
			 //
			/* System.out.println("URL: " + url);
			 System.out.println("Connection: " + con);
			 System.out.println(); */
			 //
			 Statement stmt;
			 stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY" );
		     /* while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");
		         int age  = rs.getInt("age");
		         String  address = rs.getString("address");
		         float salary = rs.getFloat("salary");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         System.out.println( "AGE = " + age );
		         System.out.println( "ADDRESS = " + address );
		         System.out.println( "SALARY = " + salary );
		         System.out.println();
		      }*/
			 
			  table = new JTable(buildTableModel(rs));
			  //	table.setBounds(0, 0, 428, 258);	
			  //	contentPane.add(table);
			  //-------------------------------------
		      rs.close();
		      stmt.close();
		      con.close();
		}
		catch( Exception e ) {
			 table = new JTable();
			 e.printStackTrace();
		}
		//----------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
	//	contentPane.setLayout(new BorderLayout(0, 0)); //make resize work - it is BorderLayout in Swing Design
		
			
		JScrollPane scrollPane = new JScrollPane(table);
	//	Rectangle r = contentPane.getBounds();
	//	System.out.println(r.x +" "+ r.y+ "  "+ r.width+ " "+ r.height);	
		scrollPane.setBounds(0, 0, 428, 183);		
		contentPane.add(scrollPane);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
	
		JButton btnNewButton = new JButton("Copy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (table.getSelectedRows().length==1) { 
					String row = "";
					for (int i = 0; i <table.getColumnCount(); i++) {
						row += (table.getValueAt(table.getSelectedRows()[0], i) + " ");
					}
					textField.setText(row);
				}
			}
		});

		
		
		btnNewButton.setBounds(24, 239, 115, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(181, 240, 204, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		
		
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames){
	        @Override
	        public boolean isCellEditable(int row, int column) {
	           //all cells false
	           return false;
	        }
	    };

	}


	
}

