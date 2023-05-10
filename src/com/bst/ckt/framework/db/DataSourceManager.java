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
 * Class Name     DataSourceManager.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       DataSourceManager class designed to return DataSource.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.db;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * <p><code>DataSourceManager</code> class will help to set the default </p>
 * <p>JNDI Name and set the DataSource returns from <code>JNDIHelper.lookup</code></p>
 * @author gracious
 * @version V1.0
 */
public class DataSourceManager {

	public static final String JNDIName="jdbc/proj037";
	private static DataSource dataSource=null;
	public static DataSourceManager dataSourceManager;
	
	public DataSourceManager(String jndiName) throws NamingException
	{
		try{
			if(jndiName==null)
			{
				jndiName=DataSourceManager.JNDIName;
			}
			
			DataSourceManager.setDataSource((DataSource)JNDIHelper.lookup(jndiName));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static synchronized DataSourceManager getInstance(String jndiName) 
	{
		if(dataSourceManager == null)
		{
			try {
				dataSourceManager = new DataSourceManager(jndiName);
			} catch (NamingException ex){
				ex.printStackTrace();
			}
		}
		return dataSourceManager;
	
	}
	
	public static DataSource getDataSource()
	{
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		DataSourceManager.dataSource = dataSource;
	}
	
	
}
