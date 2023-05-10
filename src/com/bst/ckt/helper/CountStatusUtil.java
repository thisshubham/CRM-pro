package com.bst.ckt.helper;

import java.awt.Color;
import java.io.File;
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
import com.bst.ckt.vo.AccountVO;
import com.bst.ckt.vo.AssignmentVO;
import com.bst.ckt.vo.LeadVO;
import com.bst.ckt.vo.SupportCasesVO;
import com.bst.ckt.vo.TicketVO;

public class CountStatusUtil extends JdbcDAOSupport {

	/**
	 * Creating Logger object, logger object mapped with CountStatusutil class
	 * for writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(CountStatusUtil.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	DashBoardVo dashBoardVo = new DashBoardVo();

	/**
	 * <p>
	 * <code>leadStatusDetails()</code>this method is used for the fetching a
	 * lead status from a database
	 * </p>
	 * 
	 * @return countStatus
	 * @throws OMIApplicationException
	 */
	public List<DashBoardVo> leadStatusDetails() throws OMIApplicationException {
		List<DashBoardVo> countStatus = new ArrayList<DashBoardVo>();
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

		try {
			connection = getConnection();
			String query = QueryMaker.GET_LEAD_STATUS;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				leadVO.setLeadStatus(resultSet.getInt("LEAD_STATUS"));

				// System.out.println(resultSet.getInt("LEAD_STATUS"));
				if (leadVO.getLeadStatus() == 1) {
					count1 = count1 + 1;
				} else {
					if (leadVO.getLeadStatus() == 2) {
						count2 = count2 + 1;
					} else {
						if (leadVO.getLeadStatus() == 3) {
							count3 = count3 + 1;
						} else {
							if (leadVO.getLeadStatus() == 4) {
								count4 = count4 + 1;
							} else {
								if (leadVO.getLeadStatus() == 5) {

									count5 = count5 + 1;
								} else {
									if (leadVO.getLeadStatus() == 6) {

										count6 = count6 + 1;
									} else {
										if (leadVO.getLeadStatus() == 7) {

											count7 = count7 + 1;
										} else {
											if (leadVO.getLeadStatus() == 8) {

												count8 = count8 + 1;
											} else {
												if (leadVO.getLeadStatus() == 9) {

													count9 = count9 + 1;
												} else {
													if (leadVO.getLeadStatus() == 10) {

														count10 = count10 + 1;
													} else {
														count11 = count11 + 1;
													}

												}

											}

										}

									}

								}

							}

						}

					}

				}
			}
			dashBoardVo.setLeadattemptocantact(count1);
			dashBoardVo.setLeadcontacted(count2);
			dashBoardVo.setLeadcontactedinfuture(count3);
			dashBoardVo.setLeadnotconnceted(count4);
			dashBoardVo.setLeadqualified(count5);
			dashBoardVo.setLeadprequalified(count6);
			dashBoardVo.setLeadhotlead(count7);
			dashBoardVo.setLeadcoldlead(count8);
			dashBoardVo.setLeadwarmlead(count9);
			dashBoardVo.setLeadjunklead(count10);
			dashBoardVo.setLeadlost(count11);
			{

				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue(" Attempt to Contact",
						new Double(dashBoardVo.getLeadattemptocantact()));
				dataset.setValue("Contacted",
						new Double(dashBoardVo.getLeadcontacted()));
				dataset.setValue("Contacted In Future",
						new Double(dashBoardVo.getLeadcontactedinfuture()));
				dataset.setValue("Not Contacted ",
						new Double(dashBoardVo.getLeadnotconnceted()));
				dataset.setValue("Qualified ",
						new Double(dashBoardVo.getLeadqualified()));
				dataset.setValue("PreQualified",
						new Double(dashBoardVo.getLeadprequalified()));
				dataset.setValue("Hot Lead ",
						new Double(dashBoardVo.getLeadhotlead()));
				dataset.setValue("Cold Lead ",
						new Double(dashBoardVo.getLeadcoldlead()));
				dataset.setValue("Worm Lead ",
						new Double(dashBoardVo.getLeadwarmlead()));
				dataset.setValue("Junk Lead ",
						new Double(dashBoardVo.getLeadjunklead()));
				dataset.setValue("Lost Lead  ",
						new Double(dashBoardVo.getLeadlost()));

				JFreeChart chart = ChartFactory.createPieChart("Lead Status", // chart
																				// title
						dataset, // data
						true, // include legend
						true, false);

				final PiePlot plot = (PiePlot) chart.getPlot();
				plot.setBackgroundPaint(Color.white);
				plot.setCircular(true);
				int width = 550; /* Width of the image */
				int height = 500; /* Height of the image */
				File pieChart = new File(
						"/home/deepak/workspace/PROJ037-01/WebContent/img/leadstatuspie_Chart.jpeg");

				try {
					ChartUtilities.saveChartAsJPEG(pieChart, chart, width,
							height);
				} catch (Exception exception) {

				}

			}

			countStatus.add(dashBoardVo);

			// System.out.println("attempt to lead:"+dashBoardVo.getLeadattemptocantact());

		} catch (SQLException sqlExp) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Fetching the LEAD_STATUS Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Closing Connection After Fetching the LEAD_STATUS Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return countStatus;
	}

	/**
	 * <p>
	 * <code>accountStatusDetails()</code>this method is used for fetching
	 * account status detail from the database
	 * </p>
	 * 
	 * @return countAccountStatus
	 * @throws OMIApplicationException
	 */
	public List<DashBoardVo> accountStatusDetails()
			throws OMIApplicationException {
		List<DashBoardVo> countAccountStatus = new ArrayList<DashBoardVo>();
		AccountVO accountVO = new AccountVO();

		int accountcount1 = 0;
		int accountcount2 = 0;
		int accountcount3 = 0;
		int accountcount4 = 0;
		int accountcount5 = 0;

		try {
			connection = getConnection();
			String query = QueryMaker.GET_ACCOUNT_STATUS;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountVO.setAccountStatus(resultSet
						.getInt("ACCOUNT_STATUS"));

				// System.out.println(resultSet.getInt("LEAD_STATUS"));
				if ((accountVO.getAccountStatus()) == 1) {
					accountcount1 = accountcount1 + 1;
				} else {
					if ((accountVO.getAccountStatus()) == 2) {
						accountcount2 = accountcount2 + 1;

					} else {
						if ((accountVO.getAccountStatus()) == 3) {
							accountcount3 = accountcount3 + 1;

						} else {
							if ((accountVO.getAccountStatus()) == 4) {
								accountcount4 = accountcount4 + 1;

							} else {
								accountcount5 = accountcount5 + 1;

							}

						}

					}
				}
			}
			dashBoardVo.setAccountacquired(accountcount1);
			dashBoardVo.setAccountactive(accountcount2);
			dashBoardVo.setAccountmarketfailed(accountcount3);
			dashBoardVo.setAccountprojectcancelled(accountcount4);
			dashBoardVo.setAccountshoutdown(accountcount5);
			{

				DefaultPieDataset dataset1 = new DefaultPieDataset();
				dataset1.setValue(" Acquired",
						new Double(dashBoardVo.getAccountacquired()));
				dataset1.setValue("Active",
						new Double(dashBoardVo.getAccountactive()));
				dataset1.setValue("Market Failed",
						new Double(dashBoardVo.getAccountmarketfailed()));
				dataset1.setValue("Project Cancelled",
						new Double(dashBoardVo.getAccountprojectcancelled()));
				dataset1.setValue("Shout Down ",
						new Double(dashBoardVo.getAccountshoutdown()));

				JFreeChart accountchart = ChartFactory.createPieChart(
						"Account Status", // chart
											// title
						dataset1, // data
						true, // include legend
						true, false);

				final PiePlot accountplot = (PiePlot) accountchart
						.getPlot();
				accountplot.setBackgroundPaint(Color.white);
				accountplot.setCircular(true);
				int width = 550; /* Width of the image */
				int height = 500; /* Height of the image */
				File pieChart = new File(
						"/home/deepak/workspace/PROJ037-01/WebContent/img/accountpie_Chart.jpeg");
				
				try {
					ChartUtilities.saveChartAsJPEG(pieChart, accountchart,
							width, height);
				} catch (Exception exception) {

				}

			}

			countAccountStatus.add(dashBoardVo);

			// System.out.println("attempt to lead:"+dashBoardVo.getLeadattemptocantact());

		} catch (SQLException sqlExp) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Fetching the ACCOUNT_STATUS Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Closing Connection After Fetching the ACCOUNT_STATUS Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return countAccountStatus;
	}

	/**
	 * <p>
	 * <code>ticketSatusDetails()</code>this method is used for fetching a
	 * Ticket Status details from the database
	 * </p>
	 * 
	 * @return countTicketStatus
	 * @throws OMIApplicationException
	 */
	public List<DashBoardVo> ticketSatusDetails()
			throws OMIApplicationException {
		List<DashBoardVo> countTicketStatus = new ArrayList<DashBoardVo>();
		TicketVO ticketVO = new TicketVO();
		int ticketcount1 = 0;
		int ticketcount2 = 0;
		int ticketcount3 = 0;
		int ticketcount4 = 0;
		int ticketcount5 = 0;

		try {
			connection = getConnection();
			String query = QueryMaker.GET_TICKET_STATUS_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ticketVO.setStatus(resultSet.getString("STATUS"));

				// System.out.println(resultSet.getInt("LEAD_STATUS"));
				if (Integer.parseInt(ticketVO.getStatus()) == 1) {
					ticketcount1 = ticketcount1 + 1;

				} else {
					if (Integer.parseInt(ticketVO.getStatus()) == 2) {
						ticketcount2 = ticketcount2 + 1;

					} else {
						if (Integer.parseInt(ticketVO.getStatus()) == 3) {
							ticketcount3 = ticketcount3 + 1;

						} else {
							if (Integer.parseInt(ticketVO.getStatus()) == 4) {
								ticketcount4 = ticketcount4 + 1;
							} else {
								ticketcount5 = ticketcount5 + 1;
							}

						}

					}
				}
			}
			dashBoardVo.setAssigned(ticketcount1);
			// System.out.println("attempt to lead:"+dashBoardVo.getAccountacquired());
			dashBoardVo.setOpen(ticketcount2);
			// System.out.println("connected:"+dashBoardVo.getAccountactive());
			dashBoardVo.setOnhold(ticketcount3);
			// System.out.println("connected in future:"+dashBoardVo.getAccountmarketfailed());
			dashBoardVo.setResolved(ticketcount4);
			// System.out.println("not connected :"+dashBoardVo.getAccountprojectcancelled());
			dashBoardVo.setClosed(ticketcount5);
			{

				DefaultPieDataset ticketdataset = new DefaultPieDataset();
				ticketdataset.setValue(" Assigned",
						new Double(dashBoardVo.getAssigned()));
				ticketdataset.setValue("Open",
						new Double(dashBoardVo.getOpen()));
				ticketdataset.setValue("On Hold",
						new Double(dashBoardVo.getOnhold()));
				ticketdataset.setValue("Resolved ",
						new Double(dashBoardVo.getResolved()));
				ticketdataset.setValue("Closed ",
						new Double(dashBoardVo.getClosed()));

				JFreeChart ticketchart = ChartFactory.createPieChart(
						"Ticket Status", // chart
						// title
						ticketdataset, // data
						true, // include legend
						true, false);

				final PiePlot plot = (PiePlot) ticketchart.getPlot();
				plot.setBackgroundPaint(Color.white);
				plot.setCircular(true);
				int width = 550; /* Width of the image */
				int height = 500; /* Height of the image */
				File pieChart = new File(
						"/home/deepak/workspace/PROJ037-01/WebContent/img/ticketpie_Chart.jpeg");

				try {
					ChartUtilities.saveChartAsJPEG(pieChart, ticketchart,
							width, height);
				} catch (Exception exception) {

				}

			}
			countTicketStatus.add(dashBoardVo);

			// System.out.println("attempt to lead:"+dashBoardVo.getLeadattemptocantact());

		} catch (SQLException sqlExp) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Fetching the TICKET STATUS Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Closing Connection After Fetching the TICKET STATUS Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return countTicketStatus;

	}

	/**
	 * <p>
	 * <code>casesStatusDetails()</code>this method is used for fetching a Cases
	 * Status from table TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return countCasesStatus
	 * @throws OMIApplicationException
	 */
	public List<DashBoardVo> casesStatusDetails()
			throws OMIApplicationException {
		List<DashBoardVo> countCasesStatus = new ArrayList<DashBoardVo>();
		SupportCasesVO supportCasesVO = new SupportCasesVO();
		int casescount1 = 0;
		int casescount2 = 0;
		int casescount3 = 0;
		int casescount4 = 0;
		int casescount5 = 0;
		int casescount6 = 0;

		try {
			connection = getConnection();
			String query = QueryMaker.GET_CASES_STATUS_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				supportCasesVO.setStatus(resultSet.getString("CASES_STATUS"));

				// System.out.println(resultSet.getInt("LEAD_STATUS"));
				if (Integer.parseInt(supportCasesVO.getStatus()) == 1) {
					casescount1 = casescount1 + 1;

				} else {
					if (Integer.parseInt(supportCasesVO.getStatus()) == 2) {
						casescount2 = casescount2 + 1;

					} else {
						if (Integer.parseInt(supportCasesVO.getStatus()) == 3) {
							casescount3 = casescount3 + 1;

						} else {
							if (Integer.parseInt(supportCasesVO.getStatus()) == 4) {
								casescount4 = casescount4 + 1;
							} else {
								if (Integer
										.parseInt(supportCasesVO.getStatus()) == 5) {
									casescount5 = casescount5 + 1;

								} else {
									casescount6 = casescount6 + 1;
								}

							}

						}

					}
				}
			}
			dashBoardVo.setCasesassigned(casescount1);
			dashBoardVo.setCasesopen(casescount2);
			dashBoardVo.setWaitforcustomer(casescount3);
			dashBoardVo.setWaitfor3rdparty(casescount4);
			dashBoardVo.setCasesresolved(casescount5);
			dashBoardVo.setCasesclosed(casescount6);
			{

				DefaultPieDataset casesdataset = new DefaultPieDataset();
				casesdataset.setValue(" Assigned",
						new Double(dashBoardVo.getCasesassigned()));
				casesdataset.setValue("Open",
						new Double(dashBoardVo.getCasesopen()));
				casesdataset.setValue("Wait For Customer", new Double(
						dashBoardVo.getWaitforcustomer()));
				casesdataset.setValue("Wait for 3rd Party ", new Double(
						dashBoardVo.getWaitfor3rdparty()));
				casesdataset.setValue("Resolved ",
						new Double(dashBoardVo.getCasesresolved()));
				casesdataset.setValue("Closed",
						new Double(dashBoardVo.getCasesclosed()));

				JFreeChart Caseschart = ChartFactory.createPieChart(
						"Cases Status", // chart
						// title
						casesdataset, // data
						true, // include legend
						true, false);

				final PiePlot plot = (PiePlot) Caseschart.getPlot();
				plot.setBackgroundPaint(Color.white);
				plot.setCircular(true);
				int width = 550; /* Width of the image */
				int height = 500; /* Height of the image */
				File pieChart = new File(
						"/home/deepak/workspace/PROJ037-01/WebContent/img/casespie_Chart.jpeg");

				try {
					ChartUtilities.saveChartAsJPEG(pieChart, Caseschart,
							width, height);
				} catch (Exception exception) {

				}

			}
			countCasesStatus.add(dashBoardVo);

		} catch (SQLException sqlExp) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Fetching the SUPPORT_CASES STATUS Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Closing Connection After Fetching the SUPPORT_CASES STATUS Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return countCasesStatus;

	}

	/**
	 * <p>
	 * <code>assignmentStatusDetails()</code>this method is used for fetching a
	 * Assignment Status details from TAB_ASSIGNMNET
	 * </p>
	 * 
	 * @return countAssignmentStatus
	 * @throws OMIApplicationException
	 */
	public List<DashBoardVo> assignmentStatusDetails()
			throws OMIApplicationException {
		List<DashBoardVo> countAssignmentStatus = new ArrayList<DashBoardVo>();
		AssignmentVO assignmentVO = new AssignmentVO();
		int assignmentcount1 = 0;
		int assignmentcount2 = 0;
		int assignmentcount3 = 0;
		int assignmentcount4 = 0;
		int assignmentcount5 = 0;
		int assignmentcount6 = 0;
		int assignmentcount7 = 0;
		int assignmentcount8 = 0;
		int assignmentcount9 = 0;
		try {
			connection = getConnection();
			String query = QueryMaker.GET_ASSIGNMENT_STATUS_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				assignmentVO.setAssignmentStatus(resultSet
						.getString("ASSIGNMENT_STATUS"));

				// System.out.println(resultSet.getInt("LEAD_STATUS"));
				if (Integer.parseInt(assignmentVO.getAssignmentStatus()) == 1) {
					assignmentcount1 = assignmentcount1 + 1;

				} else {
					if (Integer.parseInt(assignmentVO.getAssignmentStatus()) == 2) {
						assignmentcount2 = assignmentcount2 + 1;
					} else {
						if (Integer
								.parseInt(assignmentVO.getAssignmentStatus()) == 3) {
							assignmentcount3 = assignmentcount3 + 1;
						} else {
							if (Integer.parseInt(assignmentVO
									.getAssignmentStatus()) == 4) {
								assignmentcount4 = assignmentcount4 + 1;
							} else {
								if (Integer.parseInt(assignmentVO
										.getAssignmentStatus()) == 5) {
									assignmentcount5 = assignmentcount5 + 1;
								} else {
									if (Integer.parseInt(assignmentVO
											.getAssignmentStatus()) == 6) {
										assignmentcount6 = assignmentcount6 + 1;
									} else {
										if (Integer.parseInt(assignmentVO
												.getAssignmentStatus()) == 7) {
											assignmentcount7 = assignmentcount7 + 1;
										} else {
											if (Integer.parseInt(assignmentVO
													.getAssignmentStatus()) == 8) {
												assignmentcount8 = assignmentcount8 + 1;
											} else {
												if (Integer
														.parseInt(assignmentVO
																.getAssignmentStatus()) == 9) {
													assignmentcount9 = assignmentcount9 + 1;

												}else {
													
												}

											}

										}

									}

								}

							}

						}

					}
				}
			}
			dashBoardVo.setQualification(assignmentcount1);
			dashBoardVo.setNeedananalysis(assignmentcount2);
			dashBoardVo.setValueproposition(assignmentcount3);
			dashBoardVo.setIddecisionmaker(assignmentcount4);
			dashBoardVo.setPricequote(assignmentcount5);
			dashBoardVo.setNegosiation(assignmentcount6);
			dashBoardVo.setClosedwon(assignmentcount7);
			dashBoardVo.setClosedlost(assignmentcount8);
			dashBoardVo.setClosedtocompitation(assignmentcount9);
			{

				DefaultPieDataset assignmentdataset = new DefaultPieDataset();
				assignmentdataset.setValue(" Qualification", new Double(
						dashBoardVo.getQualification()));
				assignmentdataset.setValue("Need an Analysis", new Double(
						dashBoardVo.getNeedananalysis()));
				assignmentdataset.setValue("value Praposition", new Double(
						dashBoardVo.getValueproposition()));
				assignmentdataset.setValue("Id Descision Maker ", new Double(
						dashBoardVo.getIddecisionmaker()));
				assignmentdataset.setValue("Price Quotes ", new Double(
						dashBoardVo.getPricequote()));
				assignmentdataset.setValue("Negosiation", new Double(
						dashBoardVo.getNegosiation()));
				assignmentdataset.setValue("Closed Won",
						new Double(dashBoardVo.getClosedwon()));
				assignmentdataset.setValue("Closed Lost", new Double(
						dashBoardVo.getClosedlost()));
				assignmentdataset.setValue("Closed To Compitation", new Double(
						dashBoardVo.getClosedtocompitation()));

				JFreeChart Assignmentchart = ChartFactory.createPieChart(
						"Assignment Status", // chart
						// title
						assignmentdataset, // data
						true, // include legend
						true, false);

				final PiePlot plot = (PiePlot) Assignmentchart.getPlot();
				plot.setBackgroundPaint(Color.white);
				plot.setCircular(true);
				int width = 550; /* Width of the image */
				int height = 500; /* Height of the image */
				File pieChart = new File(
						"/home/deepak/workspace/PROJ037-01/WebContent/img/assignmentpie_Chart.jpeg");

				try {
					ChartUtilities.saveChartAsJPEG(pieChart, Assignmentchart,
							width, height);
				} catch (Exception exception) {

				}

			}
			countAssignmentStatus.add(dashBoardVo);

		} catch (SQLException sqlExp) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Fetching the ASSIGNMENT STATUS Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					CountStatusUtil.class
							+ "Error: Occur in Query While Closing Connection After Fetching the ASSIGNMENT STATUS Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return countAssignmentStatus;
	}
}
