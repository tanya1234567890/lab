package com.capgemini.test.paymentwalletdao;
import com.capgemini.test.paymentwalletbean.BankDetailsBean;
import java.util.HashMap;

public class BankDetailsDao {
		
		BankDetailsBean beankBeanObj;
		
		HashMap<Long, BankDetailsBean> hm = new HashMap<Long, BankDetailsBean>();
		
		public void addCustomer(BankDetailsBean beankBeanObj) {			// METHOD TO ADD A CUSTOMER 
			this.beankBeanObj = beankBeanObj;						// BY SAVING THE BANK BEAN OBJECT
			hm.put(beankBeanObj.getAccNo(), beankBeanObj);			// IN HASH MAP
		}
		
		public HashMap<Long, BankDetailsBean> hm(){						// METHOD TO RETURN HASH MAP OBJECT
			return hm;
		}
	}

