/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import com.bst.ckt.dao.CustomizeGridDaoImpl;
import com.bst.ckt.dao.CustomizeGridDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CustomizeGridVO;

/**
 * @author Deepak Vishwakarma
 *
 */
public class CustomizeGridServiceImpl implements CustomizeGridServiceInf {
	
	CustomizeGridDaoInf customizeGridDaoInf=new CustomizeGridDaoImpl();

	/**
	 * <p>Method is use to create customized lead grid header</p>
	 * @param customizeGridVO
	 * @return 
	 */
	@Override
	public CustomizeGridVO getLeadGridHeaderData(CustomizeGridVO customizeGridVO)
			throws OMIApplicationException {
		int target=customizeGridDaoInf.getLeadGridHeaderData(customizeGridVO);
		
		return null;
	}

	@Override
	public List<CustomizeGridVO> headerdataList()
			throws OMIApplicationException {
		
		return customizeGridDaoInf.headerList();
	}

	

}
