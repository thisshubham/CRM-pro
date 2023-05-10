package com.bst.ckt.test;

import com.bst.ckt.common.QueryBuilder;

public class Demo {

	
	public static void  main(String args[]) {
		
		QueryBuilder builder=new QueryBuilder();
		
		System.out.println("query for lead search ="+QueryBuilder.advanceSerach(2, "Vanrasoft Technology"));
		
	}
}
