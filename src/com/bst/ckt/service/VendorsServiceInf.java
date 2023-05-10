/**
 * 
 */
package com.bst.ckt.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.VendorDTO;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.VendorsVO;

/**
 * @author gurjar
 * 
 */
public interface VendorsServiceInf {

	/**
	 * <p>
	 * <code>registerVendorsDetail(VendorsVO VendorsVO)</code>this method is use
	 * to insert Vendors detail into database
	 * </p>
	 * 
	 * @param VendorsVO
	 *            VendorsVO
	 * @throws Exception
	 */
	public String registerVendorsDetail(VendorsVO vendorsVO) throws Exception;

	/**
	 * <p>
	 * <code>List<VendorsVO> getVendorsDetailsList()</code>this method is use to
	 * view Vendors detail list in gird.
	 * </p>
	 * 
	 * @throws Exception
	 */
	public List<VendorsVO> getVendorsDetailsList() throws Exception;

	/**
	 * <p>
	 * <code>VendorsVO viewVendorsDetail(VendorsVO VendorsVO, int VendorsId</code>
	 * this method is use to view Vendors detail list in gird.
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int VendorsId)
	 * @throws Exception
	 */
	public VendorDTO viewVendorsDetail(int vendorsId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>removeVendorsDetail(int VendorsId)</code>this method is use to
	 * remove Vendors detail based on VendorsId into the database
	 * </p>
	 * 
	 * @param (int VendorsId)
	 * @throws Exception
	 */
	public void removeVendorsDetail(int vendorsId) throws Exception;

	/**
	 * <p>
	 * <code>VendorsVO selectVendorsInfo(VendorsVO VendorsVO, int VendorsId</code>
	 * this method is use to select Vendors detail list in gird.
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int VendorsId)
	 * @throws Exception
	 */
	public VendorsVO selectVendorsInfo(VendorsVO vendorsVO, int vendorsId)
			throws Exception;

	/**
	 * <p>
	 * <code>String updateVendorsInfo(VendorsVO VendorsVO, int VendorsId)</code>
	 * method is use to update Vendors information into database
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int VendorsId)
	 * @throws Exception
	 */
	public String updateVendorsInfo(VendorsVO vendorsVO, int vendorsId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * void VendorsPDF(HttpServletRequest request, HttpServletResponse response,
	 * int VendorsId)
	 * </p>
	 * method to generate the pdf report of Vendors details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void VendorsPDF(HttpServletRequest request,
			HttpServletResponse response, int vendorsId) throws Exception;
	
	/**
	 * <p>
	 * <code>VendorDTO viewNextvendorsDetails(int VendorsId)</code>
	 * method is use to view next Vendors information from database
	 * </p>
	 * 
	 * @param (int VendorsId)
	 * @throws Exception
	 */
	public VendorDTO viewNextvendorsDetails(int vendorsId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>VendorDTO viewPreviousVendorsDetails(int VendorsId)</code>
	 * method is use to view previous Vendors information from database
	 * </p>
	 * 
	 * @param (int VendorsId)
	 * @throws Exception
	 */
	public VendorDTO viewPreviousVendorsDetails(int vendorsId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>VendorDTO editVendorsDetails(int VendorsId)</code>
	 * method is use to Update Vendors information from database
	 * </p>
	 * 
	 * @param (int VendorsId)
	 * @throws Exception
	 */
	public VendorDTO editVendorsDetails(int vendorsId) throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>retriveVendorDetailsGrid(VendorsVO vendorsVO)</code> Method is design to retrieve Vendor information
	 * into database to maintain Vendor.
	 * </p>
	 * 
	 * @throws SQLException
	 * @throws OMIApplicationException
	 */

	public List<VendorsVO> retriveVendorDetailsGrid(VendorsVO vendorsVO) throws OMIApplicationException;


	/**
	 * <p>
	 * void vendorExcelReport(HttpServletRequest request, HttpServletResponse response)
	 * </p>
	 * method to generate the Excel report of Vendors details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void vendorExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws OMIApplicationException;

	

}
