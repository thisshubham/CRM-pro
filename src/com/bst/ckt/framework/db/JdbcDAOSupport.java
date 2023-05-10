/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     JdbcDAOSupport.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is abstract implementation to get the 
 *                connection object from DataSourceTransactionManager 
 *                or DataSourceManager
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */
 
package com.bst.ckt.framework.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.bst.ckt.action.PurchaseCementAction;


/**
 * This class is abstract implementation to get the 
 * connection object from DataSourceTransactionManager 
 * or DataSourceManager
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public abstract class JdbcDAOSupport {

	/*private DataSource dataSource;*/
	/*private Connection connection;*/
	private static final Logger logger = Logger.getLogger(JdbcDAOSupport.class);
	private DataSourceTransactionManager dataSourceTransactionManager;
	/*
	@SuppressWarnings("static-access")
	public Connection getConnection() throws Exception
	{		
		if(dataSourceTransactionManager != null){
			this.connection=dataSourceTransactionManager.getCurrentConnection();
		}
		else
		{
			if(this.dataSource==null)
			{
				this.dataSource= DataSourceManager.getInstance(DataSourceManager.JNDIName).getDataSource();
				this.connection=this.dataSource.getConnection();
			}
			else
			{
				this.connection=this.dataSource.getConnection();
			}
		}0dCA121DKjhnjk
		return this.connection;
	}*/

	public static Connection getConnection() throws Exception
	{	
		 Connection connection=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj201811", "root", "root");
				 /*rohittrad.rohittradersvidisha,,....|Q?mf23r#,D*/
			} catch (Exception e) {
				System.out.println(e);
				logger.error(JdbcDAOSupport.class+"ERROR: while establishing Connection with database", e);
			}
			
		return connection;
	}
	public DataSourceTransactionManager getDataSourceTransactionManager() {
		return dataSourceTransactionManager;
	}

	public void setDataSourceTransactionManager(
			DataSourceTransactionManager dataSourceTransactionManager) {
		this.dataSourceTransactionManager = dataSourceTransactionManager;
	}
}
