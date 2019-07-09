package com.capgemini.test.paymentwalletservice;

import com.capgemini.test.paymentwalletdao.BankDetailsDao;
import com.capgemini.test.paymentwalletbean.BankDetailsBean;
public interface BankDetailsServiceInterface
{
	public void bankAccountCreate(BankDetailsBean bankBeanObjCreateAccountObj);
	public void showBalanceSer(BankDetailsBean bankBeanShowBalObj);
	public void depositSer(BankDetailsBean bankBeanDepObj);
	public void withdrawSer(BankDetailsBean bankBeanWithdrawObj);
	public void transferSer(BankDetailsBean bankBeanFundTransObj);
}