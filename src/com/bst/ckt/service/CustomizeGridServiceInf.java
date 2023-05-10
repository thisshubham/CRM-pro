/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CustomizeGridVO;

/**
 * @author deepak
 *
 */
public interface CustomizeGridServiceInf  {

	/**
	 * <p><code>getLeadGridHeaderData</code> Method Is use to generate
	 * @param customizeGridVO
	 * @return
	 * @throws OMIApplicationException
	 */
	CustomizeGridVO getLeadGridHeaderData(CustomizeGridVO customizeGridVO)throws OMIApplicationException;

	List<CustomizeGridVO> headerdataList()throws OMIApplicationException;

	 

	

}
