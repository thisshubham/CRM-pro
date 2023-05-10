package com.bst.ckt.test;

import com.bst.ckt.helper.NameHelper;

public class TestNameHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NameHelper nameHelper = new NameHelper();
		int companyId = 1;
		try{
		System.out.println("Comapny Name is : " + nameHelper.getCompanyName(companyId));

		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

}
