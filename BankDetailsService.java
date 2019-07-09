package com.capgemini.test.paymentwalletservice;

import com.capgemini.test.paymentwalletdao.BankDetailsDao;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.test.paymentwalletbean.BankDetailsBean;
public class BankDetailsService {
BankDetailsDao bankDaoObj = new BankDetailsDao();


//********************************************************************************************************
//*************CHECKER METHODS****************************************************************************
//********************************************************************************************************

// METHOD TO CHECK IF THE AMOUNT IS SMALLER THAN 0 OR NOT
public float amountCheck(float amount) {
	while(true) {
		if(amount<=0) {
			System.out.println("Amount should be greater than 0.");
			System.out.println("Enter again: ");
			Scanner sc=new Scanner(System.in);
			amount = sc.nextInt();
		}
		else {
			return amount;
		}
	}
}
//METHOD TO CHECK THE NAME
		public String nameCheck(String name) {
			while(true) {
				if(Pattern.matches("([A-Z])*([a-z])*", name)){
					return name;
				}
				else {
					System.out.println("Name should only have alphabets.");
					System.out.println("Enter again: ");
					Scanner sc=new Scanner(System.in);
					name = sc.next();
				}
			}
		}
		
		//	METHOD TO CHECK THE LENGTH OF MOBILE NUMBER
		public long mobCheck(long mob) { 
			while(true) {
				if(String.valueOf(mob).length() < 10) {
					System.out.println("Enter valid mobile number.");
					Scanner sc=new Scanner(System.in);
					mob = sc.nextLong();
				}
				else {
					return mob;
				}
			}
		}
	public void bankAccountCreate(BankDetailsBean bankBeanObjCreateAccountObj) {
		bankDaoObj.addCustomer(bankBeanObjCreateAccountObj);
	}
	
	public void showBalanceSer(BankDetailsBean bankBeanShowBalObj) {
		
		if(bankDaoObj.hm().isEmpty()) {									// CHECKING IF HASH MAP IS EMPTY OR NOT
			System.out.println("Please create an account first.");
		}
		else {
			if(bankDaoObj.hm().containsKey(bankBeanShowBalObj.getAccNo())) {
				System.out.println("Your Account Balance is: " +bankDaoObj.hm().get(bankBeanShowBalObj.getAccNo()).getBalance());			// FETCHING THE BALANCE FROM HASHMAP & PRINTING 
			}
			else {
				System.out.println("No such Account Exist.");
			}
		}
	}
	
	public void depositSer(BankDetailsBean bankBeanDepObj) {
		
		if(bankDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankDaoObj.hm().containsKey(bankBeanDepObj.getAccNo())) {
				float dep = bankBeanDepObj.getDepAmount() + bankDaoObj.hm().get(bankBeanDepObj.getAccNo()).getBalance();						// ADDING DEPOSIT AMOUNT TO BANK ACCOUNT
				bankDaoObj.hm().get(bankBeanDepObj.getAccNo()).setBalance(dep);
				System.out.println("Deposited successfully.");
				System.out.println("Your account balance is: " +bankDaoObj.hm().get(bankBeanDepObj.getAccNo()).getBalance());					// PRINTING THE BANK BALANCE
			}
			else {
				System.out.println("No such Account Exist.");
			}
		}
	}
	
	public void withdrawSer(BankDetailsBean bankBeanWithdrawObj) {
		if(bankDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankBeanWithdrawObj.getWithdrawAmount() > bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance()) {		// CHECKING IF WITHDRAW AMOUNT IS GREATER THAN BALANCE OR NOT
				System.out.println("Can't withdraw money. Account Balance is low.");
			}
			else {
				if(bankDaoObj.hm().containsKey(bankBeanWithdrawObj.getAccNo())) {
					float dep = bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance() - bankBeanWithdrawObj.getWithdrawAmount();			// DECREMENTING WITHDRAW AMOUNT FROM BANK ACCOUNT
					bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).setBalance(dep);
					System.out.println("Withdraw successful.");
					System.out.println("Your account balance is: " +bankDaoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance());				// PRINTING REMAINING BALANCE
				}
				else {
					System.out.println("No such Account Exist.");
				}
			}
		}
	}
	
	public void transferSer(BankDetailsBean bankBeanFundTransObj) {
		if(bankDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankDaoObj.hm().containsKey(bankBeanFundTransObj.getSourceAccNo())) {				// CHECKING IF SOURCE ACCOUNT EXIST
				if(bankDaoObj.hm().containsKey(bankBeanFundTransObj.getDestAccNo())){				// CHECKING IF DESTINATION ACCOUNT EXIST
					if(bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance() > bankBeanFundTransObj.getTransferAmount()) {		// CHECKING IF TRANSFER AMOUNT IS GREATER THAN BALANCE OR NOT
						float transfer = bankBeanFundTransObj.getTransferAmount();
						bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).setBalance(bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance() - transfer);		// DECREMENTING THE TRANSFER AMOUNT
						bankDaoObj.hm().get(bankBeanFundTransObj.getDestAccNo()).setBalance(bankDaoObj.hm().get(bankBeanFundTransObj.getDestAccNo()).getBalance() + transfer);			// ADDING THE TRANSFER AMOUNT
						System.out.println("Funds Transferred Successfully.");
						System.out.println("Remaining balance in account number "+bankBeanFundTransObj.getSourceAccNo()+" is: " +bankDaoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance());
					}
					else {
						System.out.println("Can't transfer money. Source Account Balance is low.");
					}
				}
				else {
					System.out.println("Destination Account Not Exist.");
				}
			}
			else {
				System.out.println("Source Account Not Exist.");
			}
		}
	}

	
}
