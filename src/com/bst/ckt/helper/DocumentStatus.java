/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     UserStatus.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for User Status in project.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class DocumentStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of DocumentStatus id Constants.
	 * </p>
	 */


	public static final int IN_PROGRESS_ID = 1;
	public static final int COMPLETED_ID = 2;
	public static final int PENDING_REVIEW_ID = 3;
	public static final int APPROVED_ID = 4;
	public static final int REJECTED_ID = 5;
	public static final int REVIEWED_ID = 6;
	public static final int DEPRICATED_ID = 7;
	public static final int DELETED_ID = 8;
	public static final int NOT_DOCUMENTSTATUS_ID = 9;


	/**
	 * <p>
	 * List of DocumentStatus Constants.
	 * </p>
	 */
	public static final String IN_PROGRESS= "In Progress";
	public static final String COMPLETED = "Completed";
	public static final String PENDING_REVIEW = "Pending Review";
	public static final String APPROVED = "Approved";
	public static final String REJECTED = "Rejected";
	public static final String REVIEWED = "Reviewed";
	public static final String DEPRICATED = "Depricated";
	public static final String DELETED = "Deleted";
	public static final String NOT_DOCUMENTSTATUS = "Not Document Status";

	public DocumentStatus() {
		// nothing will do
	}

	public DocumentStatus(int id) {
		this.id = id;
	}

	public DocumentStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with DocumentStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setDocumentStatus(int id) {
		this.id = id;
	}

	public int getDocumentStatus() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return DocumentStatus Name based on documentStatussId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getDocumentStatus(int statusId) {
		String DOCUMENT_STATUS = null;

		switch (statusId) {
		case IN_PROGRESS_ID: {
			DOCUMENT_STATUS = IN_PROGRESS;
			break;
		}
		case COMPLETED_ID: {
			DOCUMENT_STATUS = COMPLETED;
			break;
		}
		case PENDING_REVIEW_ID: {
			DOCUMENT_STATUS = PENDING_REVIEW;
			break;
		}
		case APPROVED_ID: {
			DOCUMENT_STATUS = APPROVED;
			break;
		}
		case REJECTED_ID: {
			DOCUMENT_STATUS = REJECTED;
			break;
		}
		case REVIEWED_ID: {
			DOCUMENT_STATUS = REVIEWED;
			break;
		}
		case DEPRICATED_ID: {
			DOCUMENT_STATUS = DEPRICATED;
			break;
		}
		case DELETED_ID: {
			DOCUMENT_STATUS = DELETED;
			break;
		}
		

		default: {
			DOCUMENT_STATUS = NOT_DOCUMENTSTATUS;
		}
		}

		return DOCUMENT_STATUS;
	}

	/**
	 * <p>
	 * <code>getDocumentStatusList</code>This method returns list of Document
	 * Status
	 * </p>
	 * 
	 * @return list of Document Status in hashMap object
	 */

	public static HashMap<Integer, String> getDocumentStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(IN_PROGRESS_ID), IN_PROGRESS);
		hashMap.put(new Integer(COMPLETED_ID), COMPLETED);
		hashMap.put(new Integer(PENDING_REVIEW_ID), PENDING_REVIEW);
		hashMap.put(new Integer(APPROVED_ID), APPROVED);
		hashMap.put(new Integer(REJECTED_ID), REJECTED);
		hashMap.put(new Integer(REVIEWED_ID), REVIEWED);
		hashMap.put(new Integer(DEPRICATED_ID), DEPRICATED);
		hashMap.put(new Integer(DELETED_ID), DELETED);
		hashMap.put(new Integer(NOT_DOCUMENTSTATUS_ID), NOT_DOCUMENTSTATUS);


		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedDocumentStatusList</code>This method returns list of
	 * Document Status for changing the Document Status.
	 * </p>
	 * 
	 * @return list of User Role in hashMap object
	 */
	/*
	 * public static HashMap<Integer, String> getModifiedDocumentStatusList() {
	 * HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
	 * 
	 * hashMap.put(new Integer(IN_PROGRESS_ID), IN_PROGRESS);
		hashMap.put(new Integer(COMPLETED_ID), COMPLETED);
		hashMap.put(new Integer(PENDING_REVIEW_ID), PENDING_REVIEW);
		hashMap.put(new Integer(APPROVED_ID), APPROVED);
		hashMap.put(new Integer(REJECTED_ID), REJECTED);
		hashMap.put(new Integer(REVIEWED_ID), REVIEWED);
		hashMap.put(new Integer(DEPRICATED_ID), DEPRICATED);
		hashMap.put(new Integer(DELETED_ID), DELETED);
		hashMap.put(new Integer(NOT_DOCUMENTSTATUS_ID), NOT_DOCUMENTSTATUS);
	 * 
	 * return hashMap; }
	 */
}
