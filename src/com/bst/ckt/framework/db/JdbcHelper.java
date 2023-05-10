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
 * Class Name     JdbcHelper.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This is helper class for closing the ResultSet, Connection, 
 *                Statement and Prepared Statement.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */
package com.bst.ckt.framework.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


/**
 * <p><code>JdbcHelper</code> class help to closing the ResultSet, 
 * Connection, Statement and Prepared Statement object in database operation.
 * @author gracious
 *
 */
public class JdbcHelper {
	
	/*
	 * Creating Logger object,
	 * logger object mapped with JdbcHelper class for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(JdbcHelper.class);
	
	/**
	 * <p>This method close the connection object if it is not null.</p>
	 * @param connection Connection
	 */
	public static void closeConnection(Connection connection){
		
		if(connection!=null){
			try{
				connection.close();
			}
			catch(SQLException sqlEx)
			{
				logger.error("Problem in closing JDBC Connection!", sqlEx);
			}
			catch(Throwable exception)
			{
				logger.error("Unexpected exception to close the JDBC Connection!",exception);
			}
		}
	}
	
	
	/**
	 * <p>This method close the Statement object if it is not null.</p>
	 * @param statement Statement
	 */
	public static void closeStatement(Statement statement){
		
		if(statement!=null){
			try{
				statement.close();
			}
			catch(SQLException sqlEx)
			{
				logger.error("Problem in closing Statement!",sqlEx);

			}
			catch(Throwable exception)
			{
				logger.error("Unexpected exception to close the Statement!", exception);
			}
		}
	}
	
	
	/**
	 * <p>This method close the PreparedStatement object if it is not null.</p>
	 * @param preparedStatement PreparedStatement
	 */
	public static void closePreparedStatement(PreparedStatement preparedStatement){
		
		if(preparedStatement!=null){
			try{
				preparedStatement.close();
			}
			catch(SQLException sqlEx)
			{
				logger.error("Problem in closing Prepared Statement!",sqlEx);
			}
			catch(Throwable exception)
			{
				logger.error("Unexpected exception to close the Prepared Statement!",exception);
			}
		}
	}
	
	
	/**
	 * <p>This method close the ResultSet object if it is not null.</p>
	 * @param resultSet ResultSet
	 */
	public static void closeResultSet(ResultSet resultSet){
		
		if(resultSet!=null){
			try{
				resultSet.close();
			}
			catch(SQLException sqlEx)
			{
				logger.error("Problem in closing ResultSet!",sqlEx);
				sqlEx.printStackTrace();
			}
			catch(Throwable exception)
			{
				logger.error("Unexpected exception to close the ResultSet!",exception);
			}
		}
	}
}
