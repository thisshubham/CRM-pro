/**
 * 
 */
package com.bst.ckt.support;

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

/**
 * @author Rosu 
 *
 */
public class ContactSupportDaoImpl extends JdbcDAOSupport implements ContactSupportDaoInf{
	public static final Logger logger = Logger.getLogger(ContactSupportDaoImpl.class);
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ContactSupportVO contactSupportVO = new ContactSupportVO();

	/**
	 * <p>
	 * <code>addContactSupportDetail</code>Method will Insert the comment into database
	 * </p>
	 */
	@Override
	public int addContactSupportDetail(ContactSupportVO contactSupportVO) throws OMIApplicationException {
		int target=0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_COMMENT);
			preparedStatement.setString(1, contactSupportVO.getFullName());
			preparedStatement.setString(2, contactSupportVO.getEmailId());
			preparedStatement.setString(3, contactSupportVO.getMobileNo());
			preparedStatement.setString(4, contactSupportVO.getComment());
			preparedStatement.setString(5, LoginUtil.getIPAddress());
			preparedStatement.setString(6, DateTimeUtil.getCurrentDate());
			preparedStatement.executeUpdate();
			target=1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactSupportDaoImpl.class
							+ "Error: Occur in Query While Inserting the Contact Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					ContactSupportDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Contact Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

}
