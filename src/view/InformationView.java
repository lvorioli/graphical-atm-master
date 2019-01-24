package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

import controller.ViewManager;

@SuppressWarnings("serial")
public class InformationView extends JPanel implements ActionListener {
	
	private ViewManager manager;
	private JTextField accountNumberField;
	private JLabel accountNumberLabel;
	private JTextField firstNameField;
	private JLabel firstNameLabel;
	private JTextField lastNameField;
	private JLabel lastNameLabel;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField stateField;
	private JComboBox stateComboBox;
	private JTextField postalCodeField;
	private JTextField birthDateField;
	private JLabel birthDateLabel;
	private JTextField phoneNumberField;
	private JTextField pinField;
	private JLabel pinLabel;
	private JButton editButton;
	private JButton exitButton;
	private JButton saveButton;
	private JButton cancelButton;

	
	
	
	public InformationView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	public void initialize() {
		this.setLayout(null);
	
		this.add(new javax.swing.JLabel("InformationView", javax.swing.SwingConstants.CENTER));
		initExitButton();
		initEditButton();
		initSaveButton();
		initCancelButton();
	}
	
	public void initialize2() {
		initAccountNumberField();
		initFirstNameField();
		initLastNameField();
		initAddressField();
		initCityField();
		initStateField();
		initStateComboBox();
		initPostalCodeField();
		initBirthDateField();
		initPhoneNumberField();
		initPINField();
	}
	
	private void initAccountNumberField() {
		accountNumberLabel = new JLabel("Account Number: ", SwingConstants.RIGHT);
		accountNumberLabel.setBounds(10, 20, 140, 35);
		accountNumberLabel.setLabelFor(accountNumberField);
		accountNumberLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		accountNumberField = new JTextField(20);
		accountNumberField.setBounds(150, 20, 200, 35);
		accountNumberField.setText(String.valueOf(manager.getAccount().getAccountNumber()));
		accountNumberField.addActionListener(this);
		accountNumberField.setEditable(false);
		
		this.add(accountNumberLabel);
		this.add(accountNumberField);
	}
	
	private void initFirstNameField() {
		firstNameLabel = new JLabel("First Name: ", SwingConstants.RIGHT);
		firstNameLabel.setBounds(10, 60, 140, 35);
		firstNameLabel.setLabelFor(firstNameField);
		firstNameLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(150, 60, 200, 35);
		firstNameField.setText(String.valueOf(manager.getAccount().getUser().getFirstName()));
		firstNameField.addActionListener(this);
		firstNameField.setEditable(false);
		
		this.add(firstNameLabel);
		this.add(firstNameField);
	}
	
	private void initLastNameField() {
		lastNameLabel = new JLabel("Last Name: ", SwingConstants.RIGHT);
		lastNameLabel.setBounds(10, 100, 140, 35);
		lastNameLabel.setLabelFor(lastNameField);
		lastNameLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(150, 100, 200, 35);
		lastNameField.setText(String.valueOf(manager.getAccount().getUser().getLastName()));
		lastNameField.addActionListener(this);
		lastNameField.setEditable(false);
		
		this.add(lastNameLabel);
		this.add(lastNameField);
	}
	
	private void initAddressField() {
		JLabel label = new JLabel("Address: ", SwingConstants.RIGHT);
		label.setBounds(10, 140, 140, 35);
		label.setLabelFor(addressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		addressField = new JTextField(20);
		addressField.setBounds(150, 140, 200, 35);
		addressField.setText(String.valueOf(manager.getAccount().getUser().getStreetAddress()));
		addressField.addActionListener(this);
		addressField.setEditable(false);
		
		this.add(label);
		this.add(addressField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City: ", SwingConstants.RIGHT);
		label.setBounds(10, 180, 140, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(150, 180, 200, 35);
		cityField.setText(String.valueOf(manager.getAccount().getUser().getCity()));
		cityField.addActionListener(this);
		cityField.setEditable(false);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State: ", SwingConstants.RIGHT);
		label.setBounds(10, 220, 140, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		stateField = new JTextField(20);
		stateField.setBounds(150, 220, 200, 35);
		stateField.setText(String.valueOf(manager.getAccount().getUser().getState()));
		stateField.addActionListener(this);
		stateField.setEditable(false);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initStateComboBox(){
		String[] states = {"AL", "AK", "AZ", "AR", "CA",
		        "CO", "CT", "DE", "FL", "GA",
		        "HI", "ID", "IL", "IN", "IA", "KS",
		        "KY", "LA", "ME", "MD", "MA",
		        "MI", "MN", "MS", "MO", "MT",
		        "NE", "NV", "NH", "NJ", "NM",
		        "NY", "NC", "ND", "OH", "OK",
		        "OR", "PA", "RI", "SC", "SD",
		        "TN", "TX", "UT", "VT", "VA", "WA", "WV",
		        "WI", "WY"};
		stateComboBox = new JComboBox(states);
		stateComboBox.setBounds(150, 220, 200, 35);
		stateComboBox.setSelectedItem(manager.getAccount().getUser().getState());
		stateComboBox.addActionListener(this);
		stateComboBox.setVisible(false);
		this.add(stateComboBox);
	}
	
	private void initPostalCodeField() {
		JLabel label = new JLabel("Postal Code: ", SwingConstants.RIGHT);
		label.setBounds(10, 260, 140, 35);
		label.setLabelFor(postalCodeField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		postalCodeField = new JTextField(20);
		postalCodeField.setBounds(150, 260, 200, 35);
		postalCodeField.setText(String.valueOf(manager.getAccount().getUser().getZip()));
		postalCodeField.addActionListener(this);
		postalCodeField.setEditable(false);
		
		this.add(label);
		this.add(postalCodeField);
	}
	
	private void initBirthDateField() {
		birthDateLabel = new JLabel("Birth Date: ", SwingConstants.RIGHT);
		birthDateLabel.setBounds(10, 300, 140, 35);
		birthDateLabel.setLabelFor(birthDateField);
		birthDateLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		birthDateField = new JTextField(20);
		birthDateField.setBounds(150, 300, 200, 35);
		birthDateField.setText(String.valueOf(manager.getAccount().getUser().getFormattedDob()));
		birthDateField.addActionListener(this);
		birthDateField.setEditable(false);
		
		this.add(birthDateLabel);
		this.add(birthDateField);
	}
	
	private void initPhoneNumberField() {
		JLabel label = new JLabel("Phone Number: ", SwingConstants.RIGHT);
		label.setBounds(10, 340, 140, 35);
		label.setLabelFor(phoneNumberField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneNumberField = new JTextField(20);
		phoneNumberField.setBounds(150, 340, 200, 35);
		phoneNumberField.setText(String.valueOf(manager.getAccount().getUser().getFormattedPhone()));
		phoneNumberField.addActionListener(this);
		phoneNumberField.setEditable(false);
		
		this.add(label);
		this.add(phoneNumberField);
	}
	
	private void initPINField() {
		pinLabel = new JLabel("PIN: ", SwingConstants.RIGHT);
		pinLabel.setBounds(10, 300, 140, 35);
		pinLabel.setLabelFor(pinField);
		pinLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		pinLabel.setVisible(false);
		
		pinField = new JTextField(20);
		pinField.setBounds(150, 300, 200, 35);
		pinField.setText(String.valueOf(manager.getAccount().getUser().getPin()));
		pinField.addActionListener(this);
		pinField.setVisible(false);
		
		this.add(pinLabel);
		this.add(pinField);
	}
	
	private void initEditButton() {
		editButton = new JButton("Edit");
		editButton.setBounds(50, 380, 200, 35);
		editButton.addActionListener(this);
		
		this.add(editButton);
	}
	
	private void initExitButton() {
		exitButton = new JButton("Back");
		exitButton.setBounds(250, 380, 200, 35);
		exitButton.addActionListener(this);
		
		this.add(exitButton);
	}
	
	private void initSaveButton() {
		saveButton = new JButton("Save");
		saveButton.setBounds(50, 380, 200, 35);
		saveButton.addActionListener(this);
		saveButton.setVisible(false);
		
		this.add(saveButton);
	}
	
	private void initCancelButton() {
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(250, 380, 200, 35);
		cancelButton.addActionListener(this);
		cancelButton.setVisible(false);
		
		this.add(cancelButton);
	}
	private void edit() {
		accountNumberField.setVisible(false);
		accountNumberLabel.setVisible(false);
		firstNameField.setVisible(false);
		firstNameLabel.setVisible(false);
		lastNameField.setVisible(false);
		lastNameLabel.setVisible(false);
		birthDateField.setVisible(false);
		birthDateLabel.setVisible(false);
		addressField.setEditable(true);
		cityField.setEditable(true);
		stateField.setVisible(false);
		stateComboBox.setVisible(true);
		postalCodeField.setEditable(true);
		phoneNumberField.setEditable(true);
		pinLabel.setVisible(true);
		pinField.setVisible(true);
		exitButton.setVisible(false);
		editButton.setVisible(false);
		saveButton.setVisible(true);
		cancelButton.setVisible(true);
	}
	
	private void showInfo() {
		accountNumberField.setVisible(true);
		accountNumberLabel.setVisible(true);
		firstNameField.setVisible(true);
		firstNameLabel.setVisible(true);
		lastNameField.setVisible(true);
		lastNameLabel.setVisible(true);
		birthDateField.setVisible(true);
		birthDateLabel.setVisible(true);
		addressField.setEditable(false);
		cityField.setEditable(false);
		stateField.setVisible(true);
		stateComboBox.setVisible(false);
		postalCodeField.setEditable(false);
		phoneNumberField.setEditable(false);
		pinLabel.setVisible(false);
		pinField.setVisible(false);
		exitButton.setVisible(true);
		editButton.setVisible(true);
		saveButton.setVisible(false);
		cancelButton.setVisible(false);
	}
	
	private void saveEdit() throws BadLocationException{
		boolean valid = true;
		
		String newAddress = addressField.getText();
		String newCity = cityField.getText();
		String newState = (String) stateComboBox.getSelectedItem();
		String newZip = postalCodeField.getText();
		int newPIN = 0;
		long newPhoneNumber = 0;
		
		
		try {
			newPIN = Integer.parseInt(pinField.getText());
			newPhoneNumber = Long.parseLong(phoneNumberField.getText(1, 3) + phoneNumberField.getText(6, 3) + phoneNumberField.getText(10, 4));
		} catch (NumberFormatException e) {
			valid = false;
			System.out.println("Account Update Failed: ");
		}
		
		for(int i = 0; i < newZip.length(); i++) {
			if(Character.isDigit(newZip.charAt(i)) == false) {
			valid = false;	
			}
		}
		
		if(newZip.length() != 5 || String.valueOf(newPIN).length() != 4 || phoneNumberField.getText().length() != 14) {
			valid = false;
		}
	
		if(valid == true) {
			manager.updateAccount(newAddress, newCity, newState, newZip, newPIN, newPhoneNumber);
			addressField.setText(manager.getAccount().getUser().getStreetAddress());
			cityField.setText(manager.getAccount().getUser().getCity());
			stateField.setText(manager.getAccount().getUser().getState());
			postalCodeField.setText(manager.getAccount().getUser().getZip());
			pinField.setText(String.valueOf(manager.getAccount().getUser().getPin()));
			phoneNumberField.setText(manager.getAccount().getUser().getFormattedPhone());
			showInfo();
		}
		
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The InformationView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source.equals(editButton)) {
			edit();
		}
		else if(source.equals(saveButton)) {
			try {
				saveEdit();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(source.equals(cancelButton)) {
			showInfo();
		}
		else if(source.equals(exitButton)) {
				manager.switchTo(ATM.HOME_VIEW);
		}
		else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
		
		
	}
}