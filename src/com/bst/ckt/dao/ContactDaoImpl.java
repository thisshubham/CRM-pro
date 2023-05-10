/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.vo.ContactVO;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class ContactDaoImpl extends JdbcDAOSupport implements ContactDaoInf {

	public static final Logger logger = Logger.getLogger(ContactDaoImpl.class);
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ContactVO contactVO = new ContactVO();

	/**
	 * <p>
	 * <code>AddContact</code>Method will Insert the comment into database
	 * </p>
	 */
	@Override
	public int addContact(ContactVO contactVO) throws OMIApplicationException {
		int target=0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_COMMENT);
			preparedStatement.setString(1, contactVO.getFullName());
			preparedStatement.setString(2, contactVO.getEmailId());
			preparedStatement.setString(3,contactVO.getMobileNo());
			preparedStatement.setString(4, contactVO.getComment());
			preparedStatement.setString(5, LoginUtil.getIPAddress());
			preparedStatement.setString(6, DateTimeUtil.getCurrentDate());
			preparedStatement.executeUpdate();
			target=1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactDaoImpl.class
							+ "Error: Occur in Query While Inserting the Contact Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					ContactDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Contact Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

}
