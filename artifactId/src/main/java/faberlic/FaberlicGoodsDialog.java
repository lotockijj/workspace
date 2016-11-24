package main.java.faberlic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FaberlicGoodsDialog extends JDialog{

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private JLabel id, name, article, amount, dateProduction, expirationDate, endDate;
	private JTextField iD, nameTextField, articleTextField, amountTextField,
	date_productionTextField, expiration_dateTextField, end_dateTextField;
	private JButton save, cancel;

	private FaberlicSearchApp faberlicSearchApp;
	private FaberlicDAO faberlicDAO;

	private Faberlic previousFaberlic = null;
	private boolean updateMode = false;

	//DateFormat formatter = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH);
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	
	public FaberlicGoodsDialog(FaberlicSearchApp theFaberlicSearchApp, FaberlicDAO theFaberlicDAO,
			Faberlic thePreviousFaberlic, boolean theUpdateMode) {
		this();
		faberlicDAO = theFaberlicDAO;
		faberlicSearchApp = theFaberlicSearchApp;

		previousFaberlic = thePreviousFaberlic;
		updateMode = theUpdateMode;
		if(updateMode){
			setTitle("Update Faberlic Goods");
			populateGui(previousFaberlic);
		}
	}

	private void populateGui(Faberlic theFaberlic) {
		iD.setText(Integer.toString(theFaberlic.getId()));
		nameTextField.setText(theFaberlic.getName());
		articleTextField.setText(Integer.toString(theFaberlic.getArticle()));
		amountTextField.setText(Integer.toString(theFaberlic.getAmount()));
		date_productionTextField.setText(formatter.format(theFaberlic.getDate_production()));
		expiration_dateTextField.setText(formatter.format(theFaberlic.getExpiration_date()));
		end_dateTextField.setText(formatter.format(theFaberlic.getEnd_date()));
	}
	
	public FaberlicGoodsDialog(FaberlicDAO theFaberlicDAO, FaberlicSearchApp theFaberlicSearchApp){
		this(theFaberlicSearchApp, theFaberlicDAO, null, false);
	}

	//Launch the application.
	public static void main(String[] args) {
		try {
			FaberlicGoodsDialog dialog = new FaberlicGoodsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	//Create the dialog.
	public FaberlicGoodsDialog(){
		this.setTitle("                        Add faberlic goods");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		id = new JLabel("ID");
		contentPanel.add(id);
		iD = new JTextField();
		iD.setPreferredSize( new Dimension( 380, 24 ) );
		contentPanel.add(iD);

		name = new JLabel("name");
		contentPanel.add(name);
		nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(360, 24));
		contentPanel.add(nameTextField);

		article = new JLabel("article");
		contentPanel.add(article);
		articleTextField = new JTextField();
		articleTextField.setPreferredSize(new Dimension(360, 24));
		contentPanel.add(articleTextField);

		amount = new JLabel("amount");
		contentPanel.add(amount);
		amountTextField = new JTextField();
		amountTextField.setPreferredSize(new Dimension(350, 24));
		contentPanel.add(amountTextField);

		dateProduction = new JLabel("date production");
		contentPanel.add(dateProduction);
		date_productionTextField = new JTextField();
		date_productionTextField.setPreferredSize(new Dimension(300, 24));
		contentPanel.add(date_productionTextField);

		expirationDate = new JLabel("expiration date");
		contentPanel.add(expirationDate);
		expiration_dateTextField = new JTextField();
		expiration_dateTextField.setPreferredSize(new Dimension(300, 24));
		contentPanel.add(expiration_dateTextField);

		endDate = new JLabel("end date");
		contentPanel.add(endDate);
		end_dateTextField = new JTextField();
		end_dateTextField.setPreferredSize(new Dimension(330, 24));
		contentPanel.add(end_dateTextField);

		save = new JButton("save");
		contentPanel.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveFaberlicGoods();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		cancel = new JButton("cancel");
		contentPanel.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

	}

	protected void saveFaberlicGoods() throws Exception{
		// get the faberlic_goods info  from gui
		int id = Integer.parseInt(iD.getText());
		String name = nameTextField.getText();
		int article = Integer.parseInt(articleTextField.getText());
		int amount = Integer.parseInt(amountTextField.getText());
		Date date_production = convertToDate(date_productionTextField.getText());
		Date expiration_date = convertToDate(expiration_dateTextField.getText());
		Date end_date = convertToDate(end_dateTextField.getText());

		Faberlic tempFaberlic_goods = null;

		if(updateMode){
			tempFaberlic_goods = previousFaberlic;
			tempFaberlic_goods.setId(id);
			tempFaberlic_goods.setName(name);
			tempFaberlic_goods.setAmount(amount);
			tempFaberlic_goods.setArticle(article);
			tempFaberlic_goods.setDate_production(date_production);
			tempFaberlic_goods.setExpiration_date(expiration_date);
			tempFaberlic_goods.setEnd_date(end_date);
		} else {
			tempFaberlic_goods = new Faberlic(id, name, article,
					amount, date_production, expiration_date, end_date);
		}

		try{
			//save to database
			if(updateMode){
				faberlicDAO.updateFaberlicGoods(tempFaberlic_goods);
			} else {
				faberlicDAO.addFaberlicGoods(tempFaberlic_goods);
			}

			//close dialog
			setVisible(false);
			dispose();

			//refresh gui list
			faberlicSearchApp.refreshFaberlicView();

			//show success message
			JOptionPane.showMessageDialog(faberlicSearchApp, "Faberlic goods added succesfully.",
					"Faberlic goods added", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception exc){
			JOptionPane.showMessageDialog(faberlicSearchApp, 
					"Error saving faberlic goods: "  
							+ exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private Date convertToDate(String text) throws ParseException {
		return new Date((formatter.parse(text)).getTime());
	}
}
