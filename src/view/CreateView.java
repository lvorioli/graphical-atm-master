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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JComboBox dayComboBox;
	private JComboBox monthComboBox;
	private JComboBox yearComboBox;
	private JTextField phoneNumberField;
	private JTextField streetAddressField;
	private JTextField cityField;
	private JComboBox stateComboBox;
	private JTextField postalCodeField;
	private JPasswordField pinField;
	private JButton createButton;
	private JButton cancelButton;
	
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
	
		
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		
		initFirstNameField();
		initLastNameField();
		initBirthDateComboBox();
		initPhoneNumberField();
		initAddressField();
		initCityField();
		initStateComboBox();
		initPostalCodeField();
		initPinField();
		initCreateButton();
		initCancelButton();
	}
	
	private void initFirstNameField(){
		JLabel label = new JLabel("First Name: ", SwingConstants.RIGHT);
		label.setBounds(60, 20, 135, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(205, 20, 200, 35);
		firstNameField.addActionListener(this);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initLastNameField(){
		JLabel label = new JLabel("Last Name: ", SwingConstants.RIGHT);
		label.setBounds(60, 60, 135, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(205, 60, 200, 35);
		lastNameField.addActionListener(this);
		
		this.add(label);
		this.add(lastNameField);
	}
	private void initBirthDateComboBox() {
		JLabel label = new JLabel("Birth Date: ", SwingConstants.RIGHT);
		label.setBounds(60, 100, 135, 35);
		label.setLabelFor(dayComboBox);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] years = {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909",
				"1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919",
				"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929",
				"1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939",
				"1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949",
				"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
				"1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
				"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
				"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
				"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", 
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};
		
		dayComboBox = new JComboBox(days);
		dayComboBox.setBounds(205, 100, 50, 35);
		dayComboBox.addActionListener(this);
		
		this.add(label);
		this.add(dayComboBox);
		
		monthComboBox = new JComboBox(months);
		monthComboBox.setBounds(255, 100, 100, 35);
		monthComboBox.addActionListener(this);
		
		this.add(monthComboBox);
		
		yearComboBox = new JComboBox(years);
		yearComboBox.setBounds(355, 100, 50, 35);
		yearComboBox.addActionListener(this);
		
		this.add(yearComboBox);
	}
	
	private void initPhoneNumberField() {
		JLabel label = new JLabel("Phone Number: ", SwingConstants.RIGHT);
		label.setBounds(60, 140, 135, 35);
		label.setLabelFor(phoneNumberField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneNumberField = new JTextField(20);
		phoneNumberField.setBounds(205, 140, 200, 35);
		phoneNumberField.addActionListener(this);
		
		this.add(label);
		this.add(phoneNumberField);
	}
	
	private void initAddressField() {
		JLabel label = new JLabel("Address: ", SwingConstants.RIGHT);
		label.setBounds(60, 180, 135, 35);
		label.setLabelFor(streetAddressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetAddressField = new JTextField(20);
		streetAddressField.setBounds(205, 180, 200, 35);
		streetAddressField.addActionListener(this);
		
		this.add(label);
		this.add(streetAddressField);
	}
	private void initCityField() {
		JLabel label = new JLabel("City: ", SwingConstants.RIGHT);
		label.setBounds(60, 220, 135, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(205, 220, 200, 35);
		cityField.addActionListener(this);
		
		this.add(label);
		this.add(cityField);
	}
	private void initStateComboBox(){
		JLabel label = new JLabel("State: ", SwingConstants.RIGHT);
		label.setBounds(60, 260, 135, 35);
		label.setLabelFor(stateComboBox);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
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
		stateComboBox.setBounds(205, 260, 200, 35);
		stateComboBox.addActionListener(this);
		
		this.add(label);
		this.add(stateComboBox);
	}
	
	private void initPostalCodeField() {
		JLabel label = new JLabel("Postal Code: ", SwingConstants.RIGHT);
		label.setBounds(60, 300, 135, 35);
		label.setLabelFor(postalCodeField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		postalCodeField = new JTextField(20);
		postalCodeField.setBounds(205, 300, 200, 35);
		postalCodeField.addActionListener(this);
		
		this.add(label);
		this.add(postalCodeField);
	}
	private void initPinField() {
		JLabel label = new JLabel("PIN: ", SwingConstants.RIGHT);
		label.setBounds(60, 340, 135, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(205, 340, 200, 35);
		pinField.addActionListener(this);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initCreateButton() {
		createButton = new JButton("Create Account");
		createButton.setBounds(205, 380, 100, 35);
		createButton.addActionListener(this);
		
		this.add(createButton);
	}
	
	private void initCancelButton() {
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(305, 380, 100, 35);
		cancelButton.addActionListener(this);
		
		this.add(cancelButton);
	}
	
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
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
		
		if (source.equals(createButton)) {
			try {
				parseAccount();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (source.equals(cancelButton)) {
			manager.switchTo(ATM.LOGIN_VIEW);
		} else if(source.equals(dayComboBox) || source.equals(monthComboBox) || source.equals(yearComboBox) || source.equals(stateComboBox)) {
			
		} else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
		}
	}
	
	public void parseAccount() throws SQLException {
		boolean valid = true;
		int pin = 0;
		int dob = 0;
		long phone = 0;
	
		String day = dayComboBox.getSelectedItem().toString();
		String month = "";
		switch (monthComboBox.getSelectedItem().toString()) {
		case "January":
			month = "01";
			break;
		case "February":
			month = "02";
			break;
		case "March":
			month = "03";
			break;
		case "April":
			month = "04";
			break;
		case "May":
			month = "05";
			break;
		case "June":
			month = "06";
			break;
		case "July":
			month = "07";
			break;
		case "August":
			month = "08";
			break;
		case "September":
			month = "09";
			break;
		case "October":
			month = "10";
			break;
		case "November":
			month = "11";
			break;
		case "December":
			month = "12";
			break;
		}
		
		String year = yearComboBox.getSelectedItem().toString();	
		
		try {
			pin = Integer.parseInt(pinField.getText());
			dob = Integer.parseInt(year + month + day);
			phone = Long.parseLong(phoneNumberField.getText());
		} catch (NumberFormatException e) {
			valid = false;
			System.out.println("Account Creation Failed: ");
		}
		
		String firstName = firstNameField.getText();
		
		String lastName = lastNameField.getText();
		
		String streetAddress = streetAddressField.getText();
		
		String city = cityField.getText();
		
		String state = (String) stateComboBox.getSelectedItem();
		
		String zip = postalCodeField.getText();
		
		//ADD
		for(int i = 0; i < zip.length(); i++) {
			if(Character.isDigit(zip.charAt(i)) == false) {
			valid = false;	
			}
		}
		
		if(zip.length() != 5 || String.valueOf(pin).length() != 4 || String.valueOf(phone).length() != 10) {
			valid = false;
		}
		if(valid == true) {
			manager.makeAccount(pin, dob, phone, firstName, lastName, streetAddress, city, state, zip);
			char[] pin1 = new char[] {String.valueOf(pin).charAt(0), String.valueOf(pin).charAt(1), String.valueOf(pin).charAt(2), String.valueOf(pin).charAt(3)};
			manager.login(String.valueOf(manager.getDatabase().numberOfAccounts() + 100000000), pin1);
		}
		else {
			System.out.println("Account Creation Failed: ");
		}
	}
}