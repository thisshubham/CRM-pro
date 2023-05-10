/**
 * 
 */
package com.bst.ckt.dao;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ContactVO;

/**
 * @author deepak
 *
 */
public interface ContactDaoInf {

	public int addContact(ContactVO contactVO)throws OMIApplicationException;

}
