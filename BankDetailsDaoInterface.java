package com.capgemini.test.paymentwalletdao;
import java.util.HashMap;

import com.capgemini.test.paymentwalletbean.BankDetailsBean;

public interface BankDetailsDaoInterface {
	
	
	public void addCustomer(BankDetailsBean beankBeanObj) ;
	public HashMap<Long, BankDetailsBean> hm();
}
