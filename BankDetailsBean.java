package com.capgemini.test.paymentwalletbean;

public class BankDetailsBean {


private int i=0;
	private long sourceAccNo, destAccNo;
	private float balance, depAmount, withdrawAmount, transferAmount;
	private String name;
	private long mobNo,  accNo;
	public static String transactions[] = new String[5];
	
	//CONSTRUCTORS STARTS
	public BankDetailsBean() {
		super();
	}
	
	public BankDetailsBean(long accNo, String name, long mobNo, float balance) {
		this.accNo = accNo;
		this.name = name;
		this.mobNo = mobNo;
		this.balance = balance;
	}
	public BankDetailsBean(long accNo, String name, long mobile) {
		this.accNo = accNo;
		this.name = name;
		this.mobNo = mobile;
		
	}
	
	public BankDetailsBean(long accNo) {
		this.accNo = accNo;
	}
	
	public BankDetailsBean(long accNo, float depAmount) {
		this.accNo = accNo;
		this.depAmount = depAmount;
	}
	
	public BankDetailsBean(float withdrawAmount, long accNo) {
		this.withdrawAmount = withdrawAmount;
		this.accNo = accNo;
	}
	
	public BankDetailsBean(long sourceAccNo, long destAccNo, float transferAmount) {
		this.sourceAccNo = sourceAccNo;
		this.destAccNo = destAccNo;
		this.transferAmount = transferAmount;
	}
	
	public BankDetailsBean(String transactions) {
		BankDetailsBean.transactions[i] = transactions;
		i++;
	}
	//CONSTRUCTORS ENDS
	
	//GETTER & SETTER STARTS
	public float getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	public float getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(float withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public float getDepAmount() {
		return depAmount;
	}

	public void setDepAmount(float depAmount) {
		this.depAmount = depAmount;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public long getSourceAccNo() {
		return sourceAccNo;
	}

	public void setSourceAccNo(long sourceAccNo) {
		this.sourceAccNo = sourceAccNo;
	}

	public long getDestAccNo() {
		return destAccNo;
	}

	public void setDestAccNo(long destAccNo) {
		this.destAccNo = destAccNo;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	//GETTER & SETTER ENDS
}