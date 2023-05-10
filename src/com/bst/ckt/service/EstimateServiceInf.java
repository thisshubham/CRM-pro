package com.bst.ckt.service;

import java.util.List;

import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.EstimateVO;

public interface EstimateServiceInf {

	public String service(EstimateVO estimateVO, int createdBy) throws CreateFailedException, UpdateFailedException;

	public List<EstimateVO> getEstimateDetails(EstimateVO estimateVO) throws RecordNotFoundException;

	public EstimateVO viewEstimate(int estimateId) throws RecordNotFoundException ;
	
	public List<EstimateVO> viewEstimateItems(int id) throws RecordNotFoundException;

	public void deleteEstimateDetails(int id) throws DeleteFailedException;

}
