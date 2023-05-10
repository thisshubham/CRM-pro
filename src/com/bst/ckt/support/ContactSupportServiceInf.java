/**
 * 
 */
package com.bst.ckt.support;

import com.bst.ckt.exception.OMIApplicationException;

/**
 * @author Rosu
 *
 */
public interface ContactSupportServiceInf {
	/**
	 * <p><code>addContactDetails</code>Method is used to get contact  details from contactUs form</p>
	 * @return
	 *  @param contactSupportVO
	 * @throws OMIApplicationException
	 */
	

	public String addContactSupportDetails(ContactSupportVO contactSupportVO)throws OMIApplicationException;

}
