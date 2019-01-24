package view;

import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.RoundingMode;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JButton personalInformationButton;
	private JButton closeAccountButton;
	private JButton logoutButton;
	private JButton powerButton;
	private JLabel errorMessageLabel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */
	
	public void initialize() {
		this.setLayout(null);
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the HomeView.
		
		this.add(new javax.swing.JLabel("HomeView", javax.swing.SwingConstants.CENTER));
		
		initDepositButton();
		initWithdrawButton();
		initTransferButton();
		initPersonalInformationButton();
		initCloseAccountButton();
		initLogoutButton();
		//initErrorMessageLabel();
		initPowerButton();
	}
	
	public void initInformation() {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
	
		
		String information1 = "Name: " + manager.getAccount().getUser().getFirstName() + " " + manager.getAccount().getUser().getLastName();
		String information2 = "Account Number: " + manager.getAccount().getAccountNumber();
		String information3 = "Balance: $" + df.format(manager.getAccount().getBalance());
		label1 = new JLabel(information1, SwingConstants.CENTER);
		label2 = new JLabel(information2, SwingConstants.CENTER);
		label3 = new JLabel(information3, SwingConstants.CENTER);
		label1.setBounds(150, 10, 200, 35);
		label1.setFont(new Font("DialogInput", Font.BOLD, 12));
		label2.setBounds(150, 25, 200, 35);
		label2.setFont(new Font("DialogInput", Font.BOLD, 12));
		label3.setBounds(150, 40, 200, 35);
		label3.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
	}
	private void initDepositButton() {
		depositButton = new JButton("Deposit");
		depositButton.setBounds(150, 90, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	private void initWithdrawButton() {
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(150, 130, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	private void initTransferButton() {
		transferButton = new JButton("Transfer");
		transferButton.setBounds(150, 170, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	private void initPersonalInformationButton() {
		personalInformationButton = new JButton("Personal Information");
		personalInformationButton.setBounds(150, 210, 200, 35);
		personalInformationButton.addActionListener(this);
		
		this.add(personalInformationButton);
	}
	private void initCloseAccountButton() {
		closeAccountButton = new JButton("Close Account");
		closeAccountButton.setBounds(150, 250, 200, 35);
		closeAccountButton.addActionListener(this);
		
		this.add(closeAccountButton);
	}
	private void initLogoutButton() {
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(150, 290, 200, 35);
		logoutButton.addActionListener(this);
		
		this.add(logoutButton);
	}
	
	private void initPowerButton() {
		powerButton = new JButton();
		powerButton.setBounds(5, 5, 50, 50);
		powerButton.addActionListener(this);
		
		try {
			Image image = ImageIO.read(new File("images/power-off.png"));
			powerButton.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			powerButton.setText("OFF");
		}
		
		this.add(powerButton);
	}
	public void updateBudget() {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		
		String information3 = "Balance: $" + df.format(manager.getAccount().getBalance());
		label3.setText(information3);
	}
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source.equals(depositButton)) {
			manager.switchTo(ATM.DEPOSIT_VIEW);
		}
		else if(source.equals(withdrawButton)) {
			manager.switchTo(ATM.WITHDRAW_VIEW);
		}
		else if(source.equals(transferButton)) {
			manager.switchTo(ATM.TRANSFER_VIEW);
		}
		else if(source.equals(personalInformationButton)) {
			manager.switchTo(ATM.INFORMATION_VIEW);
		}
		else if(source.equals(closeAccountButton)) {
			manager.closeAccount();
		}
		else if(source.equals(logoutButton)) {
			manager.logout();
		}
		else if(source.equals(powerButton)) {
			manager.shutdown();
		}
		
	}
}