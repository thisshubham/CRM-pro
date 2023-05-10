/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CustomizeGridVO;

/**
 * @author deepak
 * 
 */
public interface CustomizeGridDaoInf {

	/**
	 * <p>
	 * <code>CustomizeGridDaoInf</code>Method is use to insert lead grid header
	 * data into Data base.
	 * </p>
	 * 
	 * @param customizeGridVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int getLeadGridHeaderData(CustomizeGridVO customizeGridVO)
			throws OMIApplicationException;

	List<CustomizeGridVO> headerList()throws OMIApplicationException;

}
