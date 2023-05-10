package com.bst.ckt.service;

import java.sql.Connection;
import java.util.List;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.EstimateDaoImpl;
import com.bst.ckt.dao.EstimateDaoInf;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.EstimateVO;

public class EstimateServiceImpl implements EstimateServiceInf{

	Connection connection;
	private String result = OMIConstants.RESULT_FAIL;
	private EstimateDaoInf estimateDaoInf = null;
	
	@Override
	public String service(EstimateVO estimateVO, int createdBy) throws CreateFailedException, UpdateFailedException{
		if (estimateVO.getId() == 0) {
			System.out.println("hey now u r in sevice");
			estimateDaoInf = new EstimateDaoImpl();
			result = estimateDaoInf.addEstimateDetails(estimateVO, createdBy);
			if (result.equals(OMIConstants.TARGET_ESTIMATE_SUCCESS)) {
				System.out.println("hey now u r in sevice");
				return OMIConstants.RESULT_SUCCESS;
			} else {
				return OMIConstants.RESULT_FAIL;
			}
		} else {
			estimateDaoInf = new EstimateDaoImpl();
			result = estimateDaoInf
					.updateEstimateDetails(estimateVO, createdBy);
			if (result.equals(OMIConstants.TARGET_ESTIMATE_SUCCESS)) {
				return OMIConstants.RESULT_SUCCESS;
			} else {
				return OMIConstants.RESULT_FAIL;
			}
		}
	}

	@Override
	public List<EstimateVO> getEstimateDetails(EstimateVO estimateVO) throws RecordNotFoundException {
		estimateDaoInf = new EstimateDaoImpl();
		return estimateDaoInf.getEstimateDetails(estimateVO);
	}

	@Override
	public EstimateVO viewEstimate(int estimateId)
			throws RecordNotFoundException {
		estimateDaoInf = new EstimateDaoImpl();
		return estimateDaoInf.viewEstimate( estimateId);
	}

	@Override
	public List<EstimateVO> viewEstimateItems(int id)
			throws RecordNotFoundException {
		
		estimateDaoInf = new EstimateDaoImpl();
		return estimateDaoInf.viewEstimateItems( id);
	}

	@Override
	public void deleteEstimateDetails(int id) throws DeleteFailedException {
		estimateDaoInf = new EstimateDaoImpl();		
		estimateDaoInf.deleteEstimateDetails( id);
	
	}

}
