package com.bst.ckt.helper;

import java.awt.Color;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dashboard.DashBoardVo;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.vo.LeadVO;

public class AnalyticsLeadModule extends JdbcDAOSupport {

	/**
	 * Creating Logger object, logger object mapped with CountStatusutil class
	 * for writing Loggers.
	 */
	public static final Logger logger = Logger
			.getLogger(AnalyticsLeadModule.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	DashBoardVo dashBoardVo = new DashBoardVo();
	NameHelper nameHelper = new NameHelper();

	/**
	 * <p>
	 * <code>leadSourceDetail()</code>this method is used for the fetching a
	 * lead Source from a TAB_LEAD_DETAIL
	 * </p>
	 * 
	 * @return countStatus
	 * @throws OMIApplicationException
	 */
	public List<DashBoardVo> getleadSourceDetail()
			throws OMIApplicationException {
		List<DashBoardVo> countLeadSource = new ArrayList<DashBoardVo>();
		LeadVO leadVO = new LeadVO();

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		int count10 = 0;
		int count11 = 0;
		int count12 = 0;
		int count13 = 0;
		int count14 = 0;
		int count15 = 0;
		int count16 = 0;
		int count17 = 0;
		int count18 = 0;
		int count19 = 0;
		int count20 = 0;

		try {
			connection = getConnection();
			String query = QueryMaker.GET_LEAD_SOURCE_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				leadVO.setLeadSource(resultSet.getInt("LEAD_SOURCE_REF"));

				// System.out.println(resultSet.getInt("LEAD_STATUS"));

				if (nameHelper.getLeadSourceName(leadVO.getLeadSource())
						.equals("Advertisement")) {
					count1 = count1 + 1;

				} else {
					if (nameHelper.getLeadSourceName(leadVO.getLeadSource())
							.equals("Campaign")) {
						count2 = count2 + 1;

					} else {
						if (nameHelper
								.getLeadSourceName(leadVO.getLeadSource())
								.equals("Client User")) {

							count3 = count3 + 1;
						} else {
							if (nameHelper.getLeadSourceName(
									leadVO.getLeadSource()).equals("Cold Call")) {

								count4 = count4 + 1;

							} else {
								if (nameHelper.getLeadSourceName(
										leadVO.getLeadSource()).equals(
										"Contact")) {

									count5 = count5 + 1;
								} else {
									if (nameHelper.getLeadSourceName(
											leadVO.getLeadSource()).equals(
											"Employee Reference")) {

										count6 = count6 + 1;
									} else {
										if (nameHelper.getLeadSourceName(
												leadVO.getLeadSource()).equals(
												"External Reference")) {

											count7 = count7 + 1;
										} else {
											if (nameHelper.getLeadSourceName(
													leadVO.getLeadSource())
													.equals("Notification")) {

												count8 = count8 + 1;
											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Online Store")) {
												count9 = count9 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Partner")) {
												count10 = count10 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Public Relations")) {
												count11 = count11 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Sales Mail Alias")) {
												count12 = count12 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Seminar Internal")) {
												count13 = count13 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Seminar Partner")) {
												count14 = count14 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Social Media Marketing")) {
												count15 = count15 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Social Site Chat")) {
												count16 = count16 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Trade Show")) {
												count17 = count17 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Vender")) {
												count18 = count18 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Website")) {
												count19 = count19 + 1;

											} else if (nameHelper
													.getLeadSourceName(
															leadVO.getLeadSource())
													.equals("Other")) {
												count20 = count20 + 1;

											}

										}

									}

								}

							}

						}

					}

				}

			}

			dashBoardVo.setAdvertisement(count1);
			dashBoardVo.setCampaign(count2);
			dashBoardVo.setClientUser(count3);
			dashBoardVo.setColdCall(count4);
			dashBoardVo.setContact(count5);
			dashBoardVo.setEmployeeReference(count6);
			dashBoardVo.setExternalReference(count7);
			dashBoardVo.setNotification(count8);
			dashBoardVo.setOnlineStore(count9);
			dashBoardVo.setPartnerleadsource(count10);
			dashBoardVo.setPublicrelations(count11);
			dashBoardVo.setSalesMailAlias(count12);
			dashBoardVo.setSeminarInternal(count13);
			dashBoardVo.setSeminarPartner(count14);
			dashBoardVo.setSocialMediaMarketing(count15);
			dashBoardVo.setSocialSiteChat(count16);
			dashBoardVo.setTradeShow(count17);
			dashBoardVo.setVender(count18);
			dashBoardVo.setWebsite(count19);
			dashBoardVo.setOther(count20);

			{

				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue("Advertisement",
						dashBoardVo.getAdvertisement());
				dataset.setValue("Campaign", dashBoardVo.getCampaign());
				dataset.setValue("Client User", dashBoardVo.getClientUser());
				dataset.setValue("Cold Call", dashBoardVo.getColdCall());
				dataset.setValue("Contact ", dashBoardVo.getContact());
				dataset.setValue("Employee Reference",
						dashBoardVo.getEmployeeReference());
				dataset.setValue("External Reference",
						dashBoardVo.getExternalReference());
				dataset.setValue("Notification", dashBoardVo.getNotification());
				dataset.setValue("Online Store", dashBoardVo.getOnlineStore());
				dataset.setValue("Partner", dashBoardVo.getPartnerleadsource());
				dataset.setValue("Public Relations",
						dashBoardVo.getPublicrelations());
				dataset.setValue("Sales Mail Alias",
						dashBoardVo.getSalesMailAlias());
				dataset.setValue("Seminar Internal",
						dashBoardVo.getSeminarInternal());
				dataset.setValue("Seminar Partner",
						dashBoardVo.getSeminarPartner());
				dataset.setValue("Social Media Marketing",
						dashBoardVo.getSocialMediaMarketing());
				dataset.setValue("Social Site Chat",
						dashBoardVo.getSocialSiteChat());
				dataset.setValue("Trade Show", dashBoardVo.getTradeShow());
				dataset.setValue("Vender", dashBoardVo.getVender());
				dataset.setValue("Website", dashBoardVo.getWebsite());
				dataset.setValue("Other", dashBoardVo.getOther());

				JFreeChart chart = ChartFactory.createPieChart("Lead Source", // chart
						// title
						dataset, // data
						true, // include legend
						true, false);

				final PiePlot plot = (PiePlot) chart.getPlot();

				int width = 550; /* Width of the image */
				int height = 500; /* Height of the image */
				plot.setBackgroundPaint(Color.white);
				plot.setCircular(true);

				File Pieplot = new File(
						"/home/abhilash/crm/backup/vcrmri-latest/PROJ037-01/WebContent/img/leadSourcepie_Chart.jpeg");

				try {
					ChartUtilities.saveChartAsJPEG(Pieplot, chart, width,
							height);
				} catch (Exception exception) {

				}

			}

			countLeadSource.add(dashBoardVo);

			// System.out.println("attempt to lead:"+dashBoardVo.getLeadattemptocantact());

		} catch (SQLException sqlExp) {
			logger.error(
					AnalyticsLeadModule.class
							+ "Error: Occur in Query While Fetching the LEAD_SOURCE Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					AnalyticsLeadModule.class
							+ "Error: Occur in Query While Closing Connection After Fetching the LEAD_SOURCE Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return countLeadSource;
	}

	/**
	 * <p>
	 * <code>getLeadCreatedBy()</code>this method is used for counting lead a
	 * CREATED_BY and fetching a that data from TAB_LEAD_DETAILS AND
	 * TAB_CUSTOMER_USER
	 * </p>
	 * 
	 * @return leadCreatedBy
	 * @throws OMIApplicationException
	 */

	public List<LeadVO> getLeadCreatedBy() throws OMIApplicationException {
		ArrayList<LeadVO> leadCreatedBy = new ArrayList<LeadVO>();

		// AnalyticsdyanamicCount analyticsdyanamicCount=new
		// AnalyticsdyanamicCount();

		try {
			connection = getConnection();
			String query = QueryMaker.GET_LEAD_CREATED_BY;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LeadVO leadVO = new LeadVO();
				leadVO.setCustomerName(resultSet.getString("FULL_NAME"));
				leadVO.setDesignation(resultSet.getString("DESIGNATION"));
				leadVO.setCreatedBy(resultSet.getInt("CREATED_BY"));
				// leadCreatedBy.add(leadVO);
				CallableStatement call = connection
						.prepareCall("{call GET_ANALYTICS_LEAD_CREATED_BY(?,?)}");
				call.setInt(1, leadVO.getCreatedBy());
				call.registerOutParameter(2, java.sql.Types.INTEGER);
				call.executeUpdate();
				leadVO.setCountdata(call.getInt(2));
				leadCreatedBy.add(leadVO);

			}

		} catch (SQLException sqlExp) {
			logger.error(
					AnalyticsLeadModule.class
							+ "Error: Occur in Query While Fetching the CREATED_BY Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					AnalyticsLeadModule.class
							+ "Error: Occur in Query While Closing Connection After Fetching the CREATED_BY Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return leadCreatedBy;
	}

	/**
	 * <p>
	 * <code>getLeadByIndustry()</code>this method is used for counting lead
	 * created by certain company and fetching a Company category name from
	 * tables TAB_LEAD_DETAILS AND TAB_COMPANY_CATEGORY
	 * </p>
	 * 
	 * @return leadByIndustry
	 * @throws OMIApplicationException
	 */
	public List<LeadVO> getLeadByIndustry() throws OMIApplicationException {
		ArrayList<LeadVO> leadByIndustry = new ArrayList<LeadVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_BY_INDUSTRY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LeadVO leadVO = new LeadVO();
				leadVO.setCompanyCategory(resultSet.getString("COMPANY_CATEGORY_NAME"));
				leadVO.setCompanycategoryid(resultSet.getInt("COMPANY_CATEGORY_REF"));
				// leadCreatedBy.add(leadVO);
				CallableStatement call = connection
						.prepareCall("{call GET_ANALYTICS_LEAD_BY_INDUSTRY(?,?)}");
				call.setInt(1, leadVO.getCompanycategoryid());
				call.registerOutParameter(2, java.sql.Types.INTEGER);
				call.executeUpdate();
				leadVO.setCountdata(call.getInt(2));
				leadByIndustry.add(leadVO);

			}
			
			
			
			

		} catch (SQLException sqlExp) {
			logger.error(
					AnalyticsLeadModule.class
							+ "Error: Occur in Query While Fetching the LEAD_BY_INDUSTRY Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					AnalyticsLeadModule.class
							+ "Error: Occur in Query While Closing Connection After Fetching the LEAD_BY_INDUSTRY Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return leadByIndustry;
	}

}