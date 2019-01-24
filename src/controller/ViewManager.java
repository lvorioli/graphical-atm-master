package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.Database;
import model.BankAccount;
import model.User;
import view.ATM;
import view.HomeView;
import view.InformationView;
import view.LoginView;

public class ViewManager {
	
	private Container views;				// the collection of all views in the application
	private Database db;					// a reference to the database
	private BankAccount account;			// the user's bank account
	private BankAccount destination;		// an account to which the user can transfer funds
	private boolean previousLogin = false;
	
	/**
	 * Constructs an instance (or object) of the ViewManager class.
	 * 
	 * @param layout
	 * @param container
	 */
	public ViewManager(Container views) {
		this.views = views;
		this.db = new Database();
	}
	
	public Database getDatabase() {
		return db;
	}
	
	///////////////////// INSTANCE METHODS ////////////////////////////////////////////
	
	/**
	 * Routes a login request from the LoginView to the Database.
	 * 
	 * @param accountNumber
	 * @param pin
	 * @throws SQLException 
	 */
	
	public void login(String accountNumber, char[] pin) throws SQLException {
		try {
			account = db.getAccount(Long.valueOf(accountNumber), Integer.valueOf(new String(pin)));
			
			if (account == null) {
				LoginView lv = ((LoginView) views.getComponents()[ATM.LOGIN_VIEW_INDEX]);
				lv.updateErrorMessage("Invalid account number and/or PIN.");
			} 
			else if(account.getStatus() == 'N'){
				LoginView lv = ((LoginView) views.getComponents()[ATM.LOGIN_VIEW_INDEX]);
				lv.updateErrorMessage("Invalid account number and/or PIN.");
			}
			else {
				HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
				InformationView iv = ((InformationView) views.getComponents()[ATM.INFORMATION_VIEW_INDEX]);
				
				if(previousLogin == false) {
					previousLogin = true;
				}
				else {
					hv.removeAll();
					hv.updateUI();
					hv.initialize();
					iv.removeAll();
					iv.updateUI();
					iv.initialize();
				}
				
				hv.initInformation();
				iv.initialize2();
				
				switchTo(ATM.HOME_VIEW);
				
				LoginView lv = ((LoginView) views.getComponents()[ATM.LOGIN_VIEW_INDEX]);
				lv.updateErrorMessage("");
			}
		} catch (NumberFormatException e) {
			// ignore
		}
	}
	
	/**
	 * Switches the active (or visible) view upon request.
	 * 
	 * @param view
	 */
	
	public void switchTo(String view) {
		((CardLayout) views.getLayout()).show(views, view);
	}
	
	/**
	 * Routes a shutdown request to the database before exiting the application. This
	 * allows the database to clean up any open resources it used.
	 */
	
	public void shutdown() {
		try {			
			int choice = JOptionPane.showConfirmDialog(
				views,
				"Are you sure?",
				"Shutdown ATM",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				db.shutdown();
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		try {			
			int choice = JOptionPane.showConfirmDialog(
				views,
				"Are you sure?",
				"Logout",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				switchTo(ATM.LOGIN_VIEW);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void closeAccount() {
		try {			
			int choice = JOptionPane.showConfirmDialog(
				views,
				"Are you sure?",
				"Close Account",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				db.closeAccount(account);
				switchTo(ATM.LOGIN_VIEW);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeAccount(int pin, int dob, long phone, String firstName, String lastName, String streetAddress, String city, String state, String zip) throws SQLException {
		BankAccount newAccount = new BankAccount('Y', 100000001 + db.numberOfAccounts(), 0.0, new User(pin, dob, phone, firstName, lastName, streetAddress, city, state, zip));
		db.insertAccount(newAccount);
		System.out.println(100000000 + db.numberOfAccounts());
	}
	
	public BankAccount getAccount() {
		return account;
	}
	
	public boolean deposit(double depositAmount) {
		if(account.deposit(depositAmount) == ATM.SUCCESS) {
			db.updateAccount(account);
			HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
			hv.updateBudget();
			System.out.println(account.getBalance());
			return true;
		}
		else {
			return false;
		}
	}
	public boolean withdraw(double withdrawAmount) {
		if(account.withdraw(withdrawAmount) == ATM.SUCCESS) {
			db.updateAccount(account);
			HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
			hv.updateBudget();
			System.out.println(account.getBalance());
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean transfer(long accountNumber, double transferAmount) {
		destination = db.getAccount(accountNumber);
		if(account.transfer(destination, transferAmount) == ATM.SUCCESS) {
			db.updateAccount(account);
			db.updateAccount(destination);
			HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
			hv.updateBudget();
			System.out.println(account.getBalance());
			System.out.println(db.getAccount(accountNumber).getBalance());
			return true;
		}
		else {
			return false;
		}
	}
	public void updateAccount(String newAddress, String newCity, String newState, String newZip, int newPIN, long newPhoneNumber) {
		account.getUser().setStreetAddress(newAddress);
		account.getUser().setCity(newCity);
		account.getUser().setState(newState);
		account.getUser().setZip(newZip);
		account.getUser().setPin(account.getUser().getPin(), newPIN);
		account.getUser().setPhone(newPhoneNumber);
		
		db.updateAccount(account);
	}
	
}
