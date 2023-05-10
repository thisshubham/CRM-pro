package com.bst.ckt.dashboard;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.AnalyticsLeadModule;
import com.bst.ckt.vo.LeadVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PieChartAction extends ActionSupport implements
ModelDriven<LeadVO>, SessionAware, ServletRequestAware,
ServletResponseAware {

	/**
     *
     */
	private static final long serialVersionUID = 1L;
	AnalyticsLeadModule analyticsLeadModule = new AnalyticsLeadModule();
	private String pieChartData;
	private List<LeadVO> pieDataList;

	public PieChartAction() throws OMIApplicationException {
		this.pieDataList = analyticsLeadModule.getLeadCreatedBy();
	}

	public String getPieChartData() throws OMIApplicationException {
		if (pieChartData == null || pieChartData.trim().length() <= 0) {
			populateData();
		}
		return pieChartData;
	}

	private void populateData() throws OMIApplicationException {
		StringBuilder stringBuilder = new StringBuilder();
		for (LeadVO pieData : pieDataList) {
			stringBuilder.append("[");
			stringBuilder.append("'");
			stringBuilder.append(pieData.getCustomerName());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(pieData.getCountdata());
			stringBuilder.append("]");
			stringBuilder.append(",");
		}
		pieChartData = stringBuilder.toString().substring(0,
				stringBuilder.toString().length() - 1);
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LeadVO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}