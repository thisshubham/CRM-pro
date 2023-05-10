/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.VendorDTO;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.VendorsVO;

/**
 * @author gurjar
 *
 */
public interface VendorsDaoInf {
	
	/**
	 * <P>
	 * <CODE>insertVendorsDetail(VendorsVO VendorsVO)</CODE> this method is
	 * use to insert Vendors detail into database
	 * </P>
	 * 
	 * @param VendorsVO
	 *            VendorsVO
	 * @return
	 * @throws Exception
	 */
	public int insertVendorsDetail(VendorsVO vendorsVO) throws Exception;

	/**
	 * <p>
	 * <code>List<VendorsVO> getVendorsDetailsList()</code>this method is use
	 * to view Vendors detail list in gird.
	 * </p>
	 * 
	 * @throws Exception
	 */
	public List<VendorsVO> getVendorsDetailsList() throws Exception;

	/**
	 * <p>
	 * <code>VendorsVO retriveVendorsInfo(VendorsVO VendorsVO, int vendorsId</code>
	 * this method is use to view Vendors detail list in gird.
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int vendorsId)
	 * @throws Exception
	 */
	public VendorsVO retriveVendorsInfo(VendorsVO vendorsVO, int vendorsId)
			throws Exception;

	/**
	 * <p>
	 * <code>deleteVendorsDetails(int vendorsId)</code> method will help to
	 * delete Vendors details base on vendorsId.
	 * </p>
	 * * @param (int newsId)
	 * 
	 * @throws Exception
	 */
	public void deleteVendorsDetails(int vendorsId) throws Exception;

	/**
	 * <p>
	 * <code>VendorsVO retriveVendorsDetails(int vendorsId</code>
	 * this method is use to select Vendors detail list from database.
	 * </p>
	 * 
	 * @param (int vendorsId)
	 * @throws Exception
	 */
	public VendorDTO retriveVendorsDetails(int vendorsId)throws OMIApplicationException;

	/**
	 * <p>
	 * <code>String updateVendorsInfo(VendorsVO VendorsVO, int vendorsId)</code>
	 * method is use to update Vendors information into database
	 * </p>
	 * 
	 * @param (VendorsVO VendorsVO, int vendorsId)
	 * @throws Exception
	 */
	public int updateVendorsDetails(VendorsVO vendorsVO, int vendorsId)throws OMIApplicationException;

	/**
	 * <p>
	 * void VendorsPDF(HttpServletRequest request,
			HttpServletResponse response, int vendorsId)
	 * </p>
	 * method to generate the pdf report of Vendors details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void VendorsPDF(HttpServletRequest request,
			HttpServletResponse response, int vendorsId)throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>VendorsVO getVendorsLastRecord()</code>
	 * this method is use to get lase Vendors Record from database.
	 * </p>
	 * 
	 * @param (int vendorsId)
	 * @throws Exception
	 */
	

	public int getVendorsLastRecord()throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>VendorDTO getVendorsDetails(int vendorsId)</code>
	 * this method is use to get Vendors details list from database.
	 * </p>
	 * 
	 * @param (int vendorsId)
	 * @throws Exception
	 */
	
	public VendorDTO getVendorsDetails(int vendorsId) throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>VendorDTO getVendorsDetailsForUpdate(int vendorsId)</code>
	 * this method is use to updates Vendors details list from database.
	 * </p>
	 * 
	 * @param (int vendorsId)
	 * @throws Exception
	 */

	public VendorDTO getVendorsDetailsForUpdate(int vendorsId) throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>List<VendorsVO> getVendorDetails(int searchId, String searchValue)</code>
	 * this method is use to get  Vendors details list from database.
	 * </p>
	 * 
	 * @param (int searchId, String searchValue)
	 * @throws OMIApplicationException
	 */

	public List<VendorsVO> getVendorDetails(int searchId, String searchValue) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>Map<String, String> getVendorsNameList()</code>
	 * this method is use to get  Vendors Name list from database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	public Map<String, String> getVendorsNameList() throws OMIApplicationException;
	/**
	 * <p>
	 * <code>Map<String, String> getVendorPhoneList()</code>
	 * this method is use to get  Vendor Phone No list from database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */

	public Map<String, String> getVendorPhoneList() throws OMIApplicationException;
	/**
	 * <p>
	 * <code>Map<String, String> getPrimaryEmailList()</code>
	 * this method is use to get  Primary Email list from database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */

	public Map<String, String> getPrimaryEmailList() throws OMIApplicationException;

	

}
