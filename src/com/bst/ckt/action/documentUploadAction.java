package com.bst.ckt.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class documentUploadAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File[] fileUpload;
	private String[] fileUploadFileName;
	private String[] uploadedFileType;
	private File upload = null;
	private String UploadFileName = null;
	HttpServletRequest servletRequest = null;
	HttpServletResponse servletResponse = null;
	SessionMap<String, Object> session = null;
	File fileToCreate;

	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		UploadFileName = uploadFileName;
	}

	public File[] getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File[] fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String[] getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String[] fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String[] getUploadedFileType() {
		return uploadedFileType;
	}

	public void setUploadedFileType(String[] uploadedFileType) {
		this.uploadedFileType = uploadedFileType;
	}

	public String doUpload() throws Exception {
		System.out.println("ssssss");
		// copy the uploaded files into pre-configured location
		servletResponse.setContentType("text/html");
		servletResponse.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = servletResponse.getWriter();
		for (int i = 0; i < fileUpload.length; i++) {

			upload = fileUpload[i];
			UploadFileName = fileUploadFileName[i];

			String filePath = servletRequest.getSession().getServletContext()
					.getRealPath("/").concat("uploadFile");
			System.out.println("filePath" + filePath);

			fileToCreate = new File(filePath, this.UploadFileName);
			System.out.println("file Name" + UploadFileName);
			
		}
		if (fileToCreate.exists()) {
			System.out.println("exists");
			printWriter
			.print("<img alt='Email Id is blank' title='Email Id is blank' src='outer/img/exist.png'></img>");
			return INPUT;			
		}
		else{
		FileUtils.copyFile(this.upload, fileToCreate);
		return "success";
		}
	}

	/*public String checkFileName() throws Exception {
		System.out.println("aaaaaaaaaa");
		try {
			servletResponse.setContentType("text/html");
			servletResponse.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = servletResponse.getWriter();
			System.out.println("saaaaaaaaaaaaaaa11");
			if (fileToCreate.equals(request.getParameter("fileUpload"))) {
				printWriter
						.print("<img alt='Mobile Number Alreay Exist' title='This File is Alreay Exist' src='outer/img/exist.png'></img>");

			}
		} catch (Exception exception) {

		}
		return null;
	}*/

	

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;

	}

}
