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
 * Class Name     DataSourceTransactionManager.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is helper class database transactions.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */
package com.bst.ckt.framework.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * <p><code>DataSourceTransactionManager</code> class is helper class to 
 * verify the current Transaction Status and state as rollback and commit.
 * @author gracious
 *
 */
public class DataSourceTransactionManager {

	private DataSource dataSource;
	private Connection currentConnection;
	private boolean withinTransaction=false;
	
	/**
	 * <p>This is default constructor of <code>DataSourceTransactionManager </code></p>
	 */
	public DataSourceTransactionManager()
	{
		DataSourceManager.getInstance(DataSourceManager.JNDIName);
		setDataSource(DataSourceManager.getDataSource());
		doGetConnection();
	}
	
	/**
	 * <p><code>doGetConnection()</code> method set the current 
	 * connection object to DataSourceTransactionManager object.</p>
	 */
	public void doGetConnection()
	{
		try{
		this.currentConnection=getDataSource().getConnection();
		}
		catch(SQLException sqlEx){

			sqlEx.printStackTrace();
		}
	}
	
	/**
	 * <p>This method returns the current transaction status</p>
	 * @return status TransactionStatus
	 */
	public TransactionStatus getTransactionStatus()
	{
		TransactionStatus status=new TransactionStatus();
		status.setWithinTransaction(this.withinTransaction);
		return status;
	}
	
	/**
	 * <p>This method start the Transaction state with set auto commit false.</p>
	 * @throws SQLException
	 */
	public void beginTransaction()throws SQLException
	{
		try{
			currentConnection.setAutoCommit(false);
			this.withinTransaction=true;
			
		}
		catch(Exception exception){
			
			JdbcHelper.closeConnection(currentConnection);
		}
	}
	
	
	/**
	 * <p>This method rollback the statement execution if some 
	 * thing goes wrong in between the current transaction.</p>
	 * @throws SQLException
	 */
	public void rollback() throws SQLException
	{
		try{
			currentConnection.rollback();
		}
		catch(Exception exception){
			JdbcHelper.closeConnection(currentConnection);
		}
		finally
		{
			JdbcHelper.closeConnection(currentConnection);
		}
	}
	
	/**
	 * <p>This method commit the statement if everything 
	 * is OK during the current transaction.</p>
	 * @throws SQLException
	 */
	public void commit() throws SQLException
	{
		try{
			currentConnection.commit();
			currentConnection.setAutoCommit(true);
		}
		catch(Exception exception){

			JdbcHelper.closeConnection(currentConnection);
		}
		finally
		{
			JdbcHelper.closeConnection(currentConnection);
		}
	}
	
	// Getter and Setter for properties.
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getCurrentConnection() {
		return currentConnection;
	}
	
	public void setCurrentConnection(Connection currentConnection) {
		this.currentConnection = currentConnection;
	}
}
