/**
 * 
 */
package com.bst.ckt.support;

import com.bst.ckt.exception.OMIApplicationException;

/**
 * @author Rosu
 *
 */
public interface ContactSupportDaoInf {
	/**
	 * <p><code>addContactSupportDetail</code>Method is used to get contact  details from contactUs form</p>
	 * @return
	 * @throws OMIApplicationException
	 */
	public int addContactSupportDetail(ContactSupportVO contactSupportVO)throws OMIApplicationException;

}
