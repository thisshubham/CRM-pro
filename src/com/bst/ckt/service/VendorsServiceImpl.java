/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.LeadDaoImpl;
import com.bst.ckt.dao.VendorsDaoImpl;
import com.bst.ckt.dao.VendorsDaoInf;
import com.bst.ckt.dto.VendorDTO;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.VendorsVO;

/**
 * @author gurjar
 * 
 */
public class VendorsServiceImpl implements VendorsServiceInf {

	VendorsDaoInf vendorsDaoInf = new VendorsDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(VendorsServiceImpl.class);

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * <p>
	 * <code>registerVendorsDetail(VendorsVO VendorsVO)</code>this method is use
	 * to insert Vendors detail into database
	 * </p>
	 * 
	 * @param VendorsVO
	 * @return
	 * 
	 *         TARGET_SUCCESS; TARGET_FAILURE
	 */
	public String registerVendorsDetail(VendorsVO vendorsVO) throws Exception {
		vendorsDaoInf = new VendorsDaoImpl();
		int target = vendorsDaoInf.insertVendorsDetail(vendorsVO);

		if (target == 1) {
			logger.info("Successfully Insert Vendors Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Vendors Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	/**
	 * <p>
	 * <code>List<VendorsVO> getVendorsDetailsList()</code>this method is use to
	 * view Vendors detail list in gird.
	 * </p>
	 * 
	 * @throws Exception
	 */
	public List<VendorsVO> getVendorsDetailsList() throws Exception {
		// Creating the VendorsDaoImpl for DAO Layer Access
		vendorsDaoInf = new VendorsDaoImpl();
		return vendorsDaoInf.getVendorsDetailsList();
	}

	/**
	 * <p>
	 * <code>VendorsVO viewVendorsDetail(int vendorsId</code> this method is use
	 * to view Vendors detail list from database.
	 * </p>
	 * 
	 * @param (int vendorsId)
	 * @throws Exception
	 */
	@Override
	public VendorDTO viewVendorsDetail(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = null;
		try {
			vendorDTO = vendorsDaoInf.retriveVendorsDetails(vendorsId);
		} catch (Exception exception) {
			logger.error("Error:while  Viewing Vendors Information!", exception);
		}
		return vendorDTO;

	}

	/**
	 * <p>
	 * <code>removeVendorsDetail(int vendorsId)</code> method will help to
	 * delete Vendors details base on vendorsId.
	 * </p>
	 * * @param (int newsId)
	 * 
	 * @throws Exception
	 */
	public void removeVendorsDetail(int vendorsId) throws Exception {
		// Creating the VendorsDaoImpl for DAO Layer Access
		vendorsDaoInf = new VendorsDaoImpl();
		vendorsDaoInf.deleteVendorsDetails(vendorsId);
	}

	/**
	 * <p>
	 * <code>VendorsVO selectVendorsInfo(VendorsVO VendorsVO, int vendorsId</code>
	 * this method is use to select Vendors detail list in gird.
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int vendorsId)
	 * @throws Exception
	 */
	public VendorsVO selectVendorsInfo(VendorsVO vendorsVO, int vendorsId)
			throws Exception {
		// Creating the VendorsDaoImpl for DAO Layer Access
		/*
		 * vendorsVO = vendorsDaoInf.retriveVendorsDetails(vendorsVO,
		 * vendorsId);
		 */
		return vendorsVO;
	}

	/**
	 * <p>
	 * <code>String updateVendorsInfo(VendorsVO VendorsVO, int vendorsId)</code>
	 * method is use to update Vendors information into database
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int vendorsId)
	 * @throws Exception
	 */
	public String updateVendorsInfo(VendorsVO vendorsVO, int vendorsId)
			throws OMIApplicationException {

		int target = vendorsDaoInf.updateVendorsDetails(vendorsVO, vendorsId);

		if (target == 1) {
			logger.info("Successfully Update Vendors Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Vendors Information!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * void VendorsPDF(HttpServletRequest request, HttpServletResponse response,
	 * int vendorsId)
	 * </p>
	 * method to generate the pdf report of Vendors details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void VendorsPDF(HttpServletRequest request,
			HttpServletResponse response, int vendorsId) throws Exception {
		// Creating the VendorsDaoImpl for DAO Layer Access
		vendorsDaoInf.VendorsPDF(request, response, vendorsId);

	}

	@Override
	public VendorDTO viewNextvendorsDetails(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = null;
		try {
			vendorsId++;
			if (vendorsDaoInf.getVendorsLastRecord() < vendorsId) {
				vendorsId = 0;
				LoginUtil.setProcessUserId(vendorsId);
				vendorDTO = new VendorDTO();
				vendorDTO.setVendorsId(0);
				return vendorDTO;
			} else {
				LoginUtil.setProcessUserId(vendorsId);
				vendorDTO = vendorsDaoInf.getVendorsDetails(vendorsId);
				if (vendorDTO.getVendorsId() == 0) {
					vendorsId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(vendorsId);
					return vendorDTO;
				}
				vendorDTO = vendorsDaoInf.getVendorsDetails(vendorsId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return vendorDTO;
	}

	@Override
	public VendorDTO viewPreviousVendorsDetails(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = null;
		try {
			vendorsId--;
			LoginUtil.setProcessUserId(vendorsId);
			vendorDTO = vendorsDaoInf.getVendorsDetails(vendorsId);
			if (vendorDTO.getVendorsId() == 0) {
				vendorsId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(vendorsId);
				return vendorDTO;
			}
			vendorDTO = vendorsDaoInf.getVendorsDetails(vendorsId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return vendorDTO;
	}

	@Override
	public VendorDTO editVendorsDetails(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = null;
		try {
			vendorDTO = vendorsDaoInf.getVendorsDetailsForUpdate(vendorsId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return vendorDTO;
	}

	@Override
	public List<VendorsVO> retriveVendorDetailsGrid(VendorsVO vendorsVO)
			throws OMIApplicationException {
		vendorsDaoInf = new VendorsDaoImpl();
		int searchId = vendorsVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(vendorsVO.getVendorsId());

		} else if (searchId == 2) {
			searchValue = vendorsVO.getFullName();
		} else if (searchId == 3) {
			searchValue = String.valueOf(vendorsVO.getPhoneNo());
		} else if (searchId == 4) {
			searchValue = String.valueOf(vendorsVO.getPrimaryEmailId());
		} else if (searchId == 5) {
			searchValue = String.valueOf(vendorsVO.getVendorsCategory());
		} else if (searchId == 6) {
			searchValue = vendorsVO.getAssignedTo();
		} else if (searchId == 7) {
			searchValue = vendorsVO.getVendorsStatus();
		}
		return vendorsDaoInf.getVendorDetails(searchId, searchValue);

	}

	/**
	 * <p>
	 * void vendorExcelReport(HttpServletRequest request, HttpServletResponse
	 * response)
	 * </p>
	 * method to generate the pdf report of Vendors details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public void vendorExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws OMIApplicationException {

		excelReportDaoInf.retriveVendorExcelReport(request, response);
	}

}


