package com.bst.ckt.dao;

import java.util.List;

import org.json.simple.JSONObject;

import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.EstimateVO;

public interface EstimateDaoInf {

public	String addEstimateDetails(EstimateVO estimateVO, int createdBy) throws CreateFailedException;

public String updateEstimateDetails(EstimateVO estimateVO, int createdBy) throws UpdateFailedException;


public JSONObject productListJSON() ;

public JSONObject taxListJSON();

public List<EstimateVO> getEstimateDetails(EstimateVO estimateVO) throws RecordNotFoundException;

public EstimateVO viewEstimate(int estimateId) throws RecordNotFoundException;

public List<EstimateVO> viewEstimateItems(int id )throws RecordNotFoundException;

public void deleteEstimateDetails(int id) throws DeleteFailedException;



}
