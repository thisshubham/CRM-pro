package com.bst.ckt.vo;

public class UserLoggerVO {
	
	private int  loggerId;
	private String ipAddress;
	private String loginTime;
	private String logOutTime;
	private String status;
	public int getLoggerId() {
		return loggerId;
	}
	public void setLoggerId(int loggerId) {
		this.loggerId = loggerId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogOutTime() {
		return logOutTime;
	}
	public void setLogOutTime(String logOutTime) {
		this.logOutTime = logOutTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
