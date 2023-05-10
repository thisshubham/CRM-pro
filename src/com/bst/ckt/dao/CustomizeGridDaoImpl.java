/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.helper.ModuleConstantId;
import com.bst.ckt.helper.ModuleConstants;
import com.bst.ckt.helper.Modules;
import com.bst.ckt.vo.CustomizeGridVO;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class CustomizeGridDaoImpl extends JdbcDAOSupport implements
		CustomizeGridDaoInf {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	CustomizeGridVO customizeGridVO;

	@Override
	public int getLeadGridHeaderData(CustomizeGridVO customizeGridVO)
			throws OMIApplicationException {
		int target = 0;

		String query = QueryMaker.INSERT_LEAD_GRID_HEADER;
		try {

			// String
			// Company[]={customizeGridVO.getLeadId(),customizeGridVO.getLeadTitle()};
			// gridData.add(customizeGridVO);

			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ModuleConstantId.Lead_ID);
			preparedStatement.setString(2, Modules.LEAD);
			if ((customizeGridVO.getLeadId().equals(true))
					&& (customizeGridVO.getLeadTitle().equals(true))
					&& (customizeGridVO.getAdd1().equals(true))
					&& (customizeGridVO.getAnnualRevenue().equals(true))
					&& (customizeGridVO.getCity().equals(true))
					&& (customizeGridVO.getCompanyCategory().equals(true))
					&& (customizeGridVO.getCompanySector().equals(true))
					&& (customizeGridVO.getCompanyType().equals(true))
					&& (customizeGridVO.getCreatedBy().equals(true))
					&& (customizeGridVO.getCreatedDate().equals(true)
							&& (customizeGridVO.getEmailID().equals(true))
							&& (customizeGridVO.getExpectedDate().equals(true)) && (customizeGridVO
								.getLeadDate()).equals(true))
					&& (customizeGridVO.getLeadOwner().equals(true))
					&& (customizeGridVO.getLeadSourceName().equals(true))
					&& (customizeGridVO.getMobileNo().equals(true))
					&& (customizeGridVO.getNoOfAssociates().equals(true))
					&& (customizeGridVO.getPhoneNo().equals(true))
					&& (customizeGridVO.getRating().equals(true))
					&& (customizeGridVO.getState().equals(true))
					&& (customizeGridVO.getStatus().equals(true))
					&& (customizeGridVO.getWebsite().equals(true))) {
				String Company[] = { ModuleConstants.LEAD_ID,
						ModuleConstants.LEAD_NAME,
						ModuleConstants.ANNUAL_REVENUE, ModuleConstants.CITY,
						ModuleConstants.COMPANY_CATEGORY_REF,
						ModuleConstants.COMPANY_NAME,
						ModuleConstants.COMPANY_SECTOR_REF,
						ModuleConstants.CONTACT_PERSON,
						ModuleConstants.CREATED_BY,
						ModuleConstants.CREATED_DATE,
						ModuleConstants.EXPECTED_CLOSING_DATE,
						ModuleConstants.LEAD_DATE, ModuleConstants.LEAD_NAME,
						ModuleConstants.LEAD_OWNER,
						ModuleConstants.LEAD_SOURCE,
						ModuleConstants.LEAD_SOURCE_NAME,
						ModuleConstants.LEAD_STATUS, ModuleConstants.RATING,
						ModuleConstants.STATE, ModuleConstants.WEBSITE };
				String comma = "";
				StringBuilder getdata = new StringBuilder();
				for (String data : Company) {
					getdata.append(comma);
					getdata.append(data);
					comma = ",";
				}
				preparedStatement.setString(3, getdata.toString());
				System.out.println("***********************"+getdata.toString());
			}

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();

		} catch (Exception exception) {
			exception.printStackTrace();

		} finally {
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closePreparedStatement(preparedStatement);

		}
		return target;
	}

	@Override
	public List<CustomizeGridVO> headerList() throws OMIApplicationException {

		List<CustomizeGridVO> headerListLead = new ArrayList<CustomizeGridVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_MODULE_LIST);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customizeGridVO = new CustomizeGridVO();
				customizeGridVO.setModuleId(resultSet.getInt("MODULE_ID"));
				customizeGridVO.setFeildlist(resultSet.getString("FIELD_LIST"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return headerListLead;
	}
}
