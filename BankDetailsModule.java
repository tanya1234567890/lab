package com.capgemini.test.paymentwalletui;
import com.capgemini.test.paymentwalletbean.BankDetailsBean;
import com.capgemini.test.paymentwalletdao.BankDetailsDao;
import com.capgemini.test.paymentwalletservice.BankDetailsService;
import java.util.Arrays;
import java.util.Scanner;
public class BankDetailsModule {
		
		BankDetailsService bankServiceObj = new BankDetailsService();
		Scanner sc = new Scanner(System.in);
		
		//************************************************************************************************
		//*************BANK MAIN MODULES METHODS**********************************************************
		//************************************************************************************************
		public void createAccount() {
			System.out.print("Enter Name: ");
			String name = bankServiceObj.nameCheck(sc.next());
			System.out.print("Enter Mobile No.: ");
			long mobNo =  bankServiceObj.mobCheck(sc.nextLong());
			long accNo = mobNo - 1234;
			System.out.print("Enter Balance: "); 
			float balance =  bankServiceObj.amountCheck(sc.nextFloat());
			BankDetailsBean bankBeanObjCreateAccountObj = new BankDetailsBean(accNo, name, mobNo, balance);
			System.out.println("Account created with Account Number: " +accNo);
			bankServiceObj.bankAccountCreate(bankBeanObjCreateAccountObj);
		}
		
		public void showBalance() {
			System.out.print("Enter Account Number: ");
			long accNo = sc.nextLong();
			BankDetailsBean bankBeanShowBalObj = new BankDetailsBean(accNo);
			bankServiceObj.showBalanceSer(bankBeanShowBalObj);
		}
		
		public void deposit() {
			System.out.print("Enter Account Number: ");
			long accNo = sc.nextLong();
			System.out.print("Enter Deposit Amount: ");
			float depAmount =  bankServiceObj.amountCheck(sc.nextFloat());
			BankDetailsBean bankBeanDeptObj = new BankDetailsBean(accNo, depAmount);
			bankServiceObj.depositSer(bankBeanDeptObj);
		}
		
		public void withdraw() {
			System.out.print("Enter Account Number: ");
			long accNo = sc.nextLong();
			System.out.print("Enter Withdraw Amount: ");
			float withdrawAmount =  bankServiceObj.amountCheck(sc.nextFloat());
			BankDetailsBean bankBeanWithdrawObj = new BankDetailsBean(withdrawAmount, accNo);
			bankServiceObj.withdrawSer(bankBeanWithdrawObj);
		}
		
		public void fundTransfer() {
			System.out.println("Enter Source Account Number: ");
			long sourceAccNo = sc.nextLong();
			System.out.println("Enter the receiver details");
			System.out.println("Enter the name");
		    String name1=bankServiceObj.nameCheck(sc.next());
		    System.out.println("Enter mobile number");
		    long mobile=bankServiceObj.mobCheck(sc.nextLong());
			long accNo1 = mobile - 1234;
			BankDetailsBean  bankBeanObjCreateAccountObj = new BankDetailsBean(accNo1, name1, mobile);
			System.out.println("Account created successfully with Account Number:" +accNo1);
			bankServiceObj.bankAccountCreate(bankBeanObjCreateAccountObj);
			System.out.println("Enter Destination Account Number: ");
			long destAccNo = sc.nextLong();
			System.out.println("Enter Amount to transfer: ");
			float transferAmount =  bankServiceObj.amountCheck(sc.nextFloat());
			BankDetailsBean bankBeanFundTransObj = new BankDetailsBean(sourceAccNo, destAccNo, transferAmount);
			bankServiceObj.transferSer(bankBeanFundTransObj);
			String transactions = transferAmount+ " transferred from Account number " +sourceAccNo+ " to " +destAccNo;
			bankBeanFundTransObj = new BankDetailsBean(transactions);
		}
		
		public void printTransactions() {
			System.out.println(Arrays.toString(BankDetailsBean.transactions));
		}
		//********************************************************************************************************
		
		
		

}
