/**
 * 
 */
package com.bst.ckt.service;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ContactVO;

/**
 * @author Deepak Vishwakarma
 *
 */
public interface ContactServiceInf {

	/**
	 * <p><code>addContactDetails</code>Method is used to get contact  details from contactUs form</p>
	 * @return
	 * @throws OMIApplicationException
	 */
	public String addContactDetails(ContactVO contactVO)throws OMIApplicationException;
	
	

}
