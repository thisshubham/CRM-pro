/**
 * 
 */
package com.bst.ckt.support;

import org.apache.log4j.Logger;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.exception.OMIApplicationException;

/**
 * @author Rosu
 *
 */
public class ContactSupportServiceImpl implements ContactSupportServiceInf{
	
	
	
	
	/**
	 * Creating Logger object, logger object mapped with ContactSupportServiceImpl class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ContactSupportServiceImpl.class);
	
	ContactSupportDaoInf ContactSupportDaoInf=new ContactSupportDaoImpl();
	/**
	 * <p><code>addContactSupportDetails</code>Method is used to get contact  details from contactUs form</p>
	 * @return contactSupportVO
	 * @throws OMIApplicationException
	 */
	/**
	 * TARGET_SUCCESS; TARGET_FAILURE
	 */
	@Override
	public String addContactSupportDetails(ContactSupportVO contactSupportVO) throws OMIApplicationException {
		
		int target=ContactSupportDaoInf.addContactSupportDetail(contactSupportVO);
		if (target == 1) {
			logger.info("Successfully Insert Contact Support !");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  Contact Support into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}
}
