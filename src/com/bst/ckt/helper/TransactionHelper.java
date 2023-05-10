package com.bst.ckt.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dao.DealerDaoImpl;
import com.bst.ckt.dto.Dealer;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;

public class TransactionHelper extends JdbcDAOSupport{

	
	private static final Logger logger = Logger.getLogger(TransactionHelper.class);
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	public Dealer retriveSpecificDealerTransaction(int dealerId)
			throws RecordNotFoundException {
Dealer dealer=new Dealer();
		
		try {
			connection = getConnection();
		PreparedStatement	preparedStatements = connection
					.prepareStatement(QueryMaker.SHOW_SPECIFIC_DEALER_TRANSACTION);
		preparedStatements.setInt(1, dealerId);
			resultSet = preparedStatements.executeQuery();
			System.out.println("----------hye ----------------");
if(resultSet != null){
			while (resultSet.next()) {
				
				System.out.println("----------hye ----------------");

				dealer.setTransactionId(resultSet.getInt("DEALER_TRANS_ID"));
				System.out.println("________________"+resultSet.getInt("DEALER_TRANS_ID"));
				dealer.setDescription(resultSet
						.getString("DEALER_TRANS_DISCRIPTION"));
				
				dealer.setTotal(resultSet
						.getFloat("DEALER_TRANS_TOTAL"));
				
				dealer.setPaid(resultSet
						.getFloat("DEALER_TRANS_PAID"));
				
				dealer.setDue(resultSet
						.getFloat("DEALER_TRANS_DUE"));

				dealer.setTotalPaid(resultSet
						.getFloat("DEALER_TRANS_TOTAL_PAID"));

				dealer.setTotalDue(resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));

				//dealer.setT(resultSet.getString("DEALER_TRANS_BILL_NO"));

				dealer.setPaymentMode(resultSet.getString("DEALER_TANS_PAYMENT_MODE"));
System.out.println(resultSet.getString("DEALER_TANS_PAYMENT_MODE")+resultSet.getString("DEALER_TANS_PAYMENT_MODE")+"hhhhhhhhh");

				
				// System.out.println(resultSet.getFloat("REG_CREATED_BY")+resultSet.getInt("REG_MOBILE_NO")+resultSet.getString("REG_PHONE_NO")+"%%%%%%%%%%%%%%%");
			
			
			}}
			
			
		 
			
		
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					TransactionHelper.class
							+ "Error: Occur in Query While Fetching the specific dealer transaction Details from Database For Update.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					TransactionHelper.class
							+ "Error: Occur in Query While Closing Connection After Fetching the specific dealer transaction Details from Database For Update.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		
		
		return dealer;
	}
}
