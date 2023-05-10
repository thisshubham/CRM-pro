/**
 * 
 */
package com.bst.ckt.service;

import com.bst.ckt.dao.ContactDaoImpl;
import com.bst.ckt.dao.ContactDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ContactVO;

/**
 * @author deepak
 *
 */
public class ContactServiceImpl implements ContactServiceInf{

	/**
	 * <p><code>addContactDetails</code>Method is used to get contact  details from contactUs form</p>
	 * @return
	 * @throws OMIApplicationException
	 */
	@Override
	public String addContactDetails(ContactVO contactVO) throws OMIApplicationException {
		ContactDaoInf ContactDaoInf=new ContactDaoImpl();
		ContactDaoInf.addContact(contactVO);
		return null;
	}
	

}
