package main.java.faberlic;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FaberlicSearchApp extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;

	private FaberlicDAO faberlicDAO;

	private JPanel panelCenter, panelSouth;

	private JButton btnAddFaberlicGoods, btnUpdateFaberlicGoods, deleteButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					FaberlicSearchApp frame = new FaberlicSearchApp();
					frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	public FaberlicSearchApp(){
		try{
			faberlicDAO = new FaberlicDAO();
		} catch (Exception exc){
			JOptionPane.showMessageDialog(this, "Error" + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		setTitle("Faberlic Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelCenter = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCenter.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelCenter, BorderLayout.NORTH);

		JLabel lblEnterLastName = new JLabel("Enter name");
		panelCenter.add(lblEnterLastName);

		lastNameTextField = new JTextField();
		panelCenter.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String lastName = lastNameTextField.getText();
					List<Faberlic> faberlicGoods = null;
					if(lastName != null && lastName.trim().length() > 0){
						faberlicGoods = faberlicDAO.searchFaberlicGoods(lastName);
					} else {
						faberlicGoods = faberlicDAO.getAllFaberlicGoods();
					}
					FaberlicTableModel model = new FaberlicTableModel(faberlicGoods);
					table.setModel(model);
					setSize(table);
				} catch (Exception exc){
					JOptionPane.showMessageDialog(FaberlicSearchApp.this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelCenter.add(btnSearch);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		panelSouth = new JPanel();

		contentPane.add(panelSouth, BorderLayout.SOUTH);
		btnAddFaberlicGoods = new JButton("Add faberlic goods");
		panelSouth.add(btnAddFaberlicGoods);
		
		btnAddFaberlicGoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FaberlicGoodsDialog dialog = new FaberlicGoodsDialog(faberlicDAO, FaberlicSearchApp.this);
				dialog.setVisible(true);
			}
		});

		btnUpdateFaberlicGoods = new JButton("Update goods");
		panelSouth.add(btnUpdateFaberlicGoods);
		btnUpdateFaberlicGoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get selected row
				int row = table.getSelectedRow();
				// make sure that row is selected
				if(row < 0){
					JOptionPane.showMessageDialog(FaberlicSearchApp.this, "You must select an faberlic goods", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				//get the current faberlic goods
				Faberlic tempFaberlic = (Faberlic)table.getValueAt(row, FaberlicTableModel.OBJECT_COL);
				//create dialog
				FaberlicGoodsDialog dialog = new FaberlicGoodsDialog(FaberlicSearchApp.this, faberlicDAO, 
						tempFaberlic, true);
				dialog.setVisible(true);
			}
		});
		
		deleteButton = new JButton("Delete goods");
		panelSouth.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int row = table.getSelectedRow();
					if(row < 0){
						JOptionPane.showMessageDialog(FaberlicSearchApp.this, 
								"You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					int response = JOptionPane.showConfirmDialog(FaberlicSearchApp.this, "Delete this faberlic goods?", "Confirm", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(response != JOptionPane.YES_OPTION){
						return;
					}
					Faberlic tempFaberlic = (Faberlic) table.getValueAt(row, FaberlicTableModel.OBJECT_COL);
					faberlicDAO.deleteFaberlicGoods(tempFaberlic.getId());
					refreshFaberlicView();
					JOptionPane.showMessageDialog(FaberlicSearchApp.this,
							"Goods deleted succesfully.", "Goods deleted", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception exc){
					JOptionPane.showMessageDialog(FaberlicSearchApp.this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void refreshFaberlicView() {
		try{
			List<Faberlic> faberlicGoods = faberlicDAO.getAllFaberlicGoods();
			FaberlicTableModel model = new FaberlicTableModel(faberlicGoods);
			table.setModel(model);
			setSize(table);
		} catch (Exception exc){
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", 
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	private void setSize(JTable table) {
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(215);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(75);
		table.getColumnModel().getColumn(6).setPreferredWidth(75);
	}
}
