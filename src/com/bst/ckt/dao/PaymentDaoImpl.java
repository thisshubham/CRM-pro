package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Payment;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.vo.PaymentVO;
import com.bst.ckt.vo.TransportVO;

public class PaymentDaoImpl extends JdbcDAOSupport implements PaymentDaoInf{

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	private static final Logger logger = Logger
			.getLogger(PaymentDaoImpl.class);
	
	public void PaymentRequest(PaymentVO paymentVO)
			throws Exception {
		
			
			try {
	            System.out.println("...........DAO IMPL Class............."); 
				
				connection = getConnection();
				preparedStatement = connection.prepareStatement(QueryMaker.INSERT_PAYMENT_DETAILS);
				
				preparedStatement.setInt(1, paymentVO.getPyamentID());
				
				preparedStatement.setString(2, paymentVO.getPayment());
	
				preparedStatement.executeUpdate();
				
				System.out.println("......execute");
				}
				catch(SQLException sqlExcepttion){
				  	System.out.println("SQL Exception"+sqlExcepttion);
				  	sqlExcepttion.printStackTrace();
					
					
				}
				
					
				 catch(Exception exception) {
					  exception.printStackTrace();
					  System.out.println("Exception is :: "+exception);
			
				
				
				
			}
			
			
		}
			

		public List<PaymentVO> getPaymentDetails(PaymentVO paymentVO) throws Exception {
			System.out.println("Payment Details DAOIMPL ****************");
			
			List<PaymentVO> paymentDetailsList = new ArrayList<PaymentVO>();
			
			try {
				

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PAYMENT_DETAIL);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					paymentVO = new PaymentVO();
					
					paymentVO.setPyamentID(resultSet.getInt("PAYMENT_ID"));
					
					paymentVO.setPayment(resultSet.getString("PAYMENT_NAME"));

		
					System.out.println("**********************   ::  "+resultSet.getString("PAYMENT_NAME"));
					


			     	
					
					paymentDetailsList.add(paymentVO);
				}

					
					
			} catch (SQLException sqlExp) {
				sqlExp.printStackTrace();
				logger.error(
						PaymentDaoImpl.class
								+ "Error: Occur in Query While Fetching the Payment Details into Grid from Database.",
						sqlExp);
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(
						PaymentDaoImpl.class
								+ "Error: Occur in Query While Closing Connection After Fetching the Payment Details into Grid from Database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return paymentDetailsList;	
		

		

			
		}

		
public Payment editPaymentDetail(Payment payment, int pyamentID) throws Exception {
			

			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PAYMENT_DETAIL_EDIT);
				preparedStatement.setInt(1, pyamentID);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					while (resultSet.next()) {

						payment.setPyamentID(resultSet.getInt("PAYMENT_ID"));
						System.out.println("________________"+resultSet.getInt("PAYMENT_ID"));
						
						payment.setPayment(resultSet.getString("PAYMENT_NAME"));

					}
				}
						
			}	 catch (SQLException sqlException) {
						sqlException.printStackTrace();
						logger.error(
								PaymentDaoImpl.class
										+ ": Error:- Error: Occur in Query While fetching the payment details from Database",
								sqlException);

					} catch (Exception exception) {
						exception.printStackTrace();
						logger.error(
								PaymentDaoImpl.class
										+ ": Error:- While closing the Connection after fetching the payment details from Database",
								exception);
					} finally {
						JdbcHelper.closeResultSet(resultSet);
						JdbcHelper.closePreparedStatement(preparedStatement);
						JdbcHelper.closeConnection(connection);
					}

					return payment;
				}


				
				public int updatePaymentDetail(PaymentVO paymentVO, int pyamentID)
						throws Exception {
					int target = 0;

					try {
						connection = getConnection();
						preparedStatement = connection
								.prepareStatement(QueryMaker.UPDATE_PAYMENT_DETAIL);

		System.out.println(paymentVO.getPyamentID()+"UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");

						preparedStatement.setString(1, paymentVO.getPayment());
		
						preparedStatement.setInt(2,pyamentID);
						
						preparedStatement.executeUpdate();
						target = 1;

					} catch (SQLException sqlException) {
						sqlException.printStackTrace();
						logger.error(
								PaymentDaoImpl.class
										+ ": Error:- Error: Occur in Query While updating the Transport details into Database",
								sqlException);

					} catch (Exception exception) {
						exception.printStackTrace();
						logger.error(
								PaymentDaoImpl.class
										+ ": Error:- While closing the Connection after updating the Transport social details into Database",
								exception);
					} finally {
						JdbcHelper.closePreparedStatement(preparedStatement);
						JdbcHelper.closeConnection(connection);
					}
					return target;
				}

		
		
		public int deletePaymentDetails(int pyamentID)
				throws Exception {
			int target = 0;
			
			try {
			
				connection = getConnection();
				preparedStatement = connection.
						prepareStatement(QueryMaker.DELETE_PAYMENT_DETAILS);

				preparedStatement.setInt(1, pyamentID);
				preparedStatement.executeUpdate();
				target = 1;

			} catch (Exception exception) {
				logger.error(PaymentDaoImpl.class
						+ ": Error:- While deleting pyament details from Database.");
			} finally {
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);

			}
			return target;
		}


		
		
		
		
		
		
		
		
		
		
		
}
