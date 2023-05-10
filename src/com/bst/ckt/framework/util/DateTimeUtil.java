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
 * Class Name     DateTimeUtil.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for Date and Time.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */
package com.bst.ckt.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <p>
 * This is utility class for Date and Time.
 * </p>
 * 
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class DateTimeUtil {

	/**
	 * <p>
	 * This method return current date in MYSQL database date format.
	 * </p>
	 * 
	 * @return date String
	 */
	public static String getCurrentDate() {

		String currentTime = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd");

			currentTime = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return currentTime;

	}

	/**
	 * <p>
	 * This method returns the Current Date and Time in MYSQL database date
	 * format.
	 * 
	 * @return Data time in String
	 */
	public static String getDateAndTime() {

		String currentDateAndTime = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			currentDateAndTime = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return currentDateAndTime;

	}

	/**
	 * <p>
	 * This method change the calendar date into MYSQL date format for database
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String convertToDate(String inputDate) {
		Calendar cal = null;
		SimpleDateFormat sdf = null;
		String databaseDateFmt = null;

		try {
			cal = Calendar.getInstance();
			// cal.setTime(new
			// SimpleDateFormat("dd-MMM-yyyy").parse(inputDate));
			cal.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(inputDate));
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			databaseDateFmt = sdf.format(cal.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return databaseDateFmt;
	}

	/**
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String convertDatetoFormDate(String inputDate) {
		Calendar cal = null;
		SimpleDateFormat sdf = null;
		String databaseDateFmt = null;

		try {
			cal = Calendar.getInstance();
			// cal.setTime(new
			// SimpleDateFormat("dd-MMM-yyyy").parse(inputDate));
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(inputDate));
			sdf = new SimpleDateFormat("MM/dd/yyyy");
			databaseDateFmt = sdf.format(cal.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return databaseDateFmt;
	}

	/**
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String convertDatetoFormDateForView(String inputDate) {
		Calendar cal = null;
		SimpleDateFormat sdf = null;
		String formDateFmt = null;

		try {
			cal = Calendar.getInstance();
			// cal.setTime(new
			// SimpleDateFormat("dd-MMM-yyyy").parse(inputDate));
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(inputDate));
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
			formDateFmt = sdf.format(cal.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return formDateFmt;
	}

	/**
	 * product table date formate
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */

	public static String getSalesStartDate() {
		String salesStartDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			salesStartDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return salesStartDate;
	}

	/**
	 * product table date formate
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String getSalesEndDate() {
		String salesEndDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			salesEndDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return salesEndDate;
	}

	/**
	 * product table date formate
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String getSupportStartDate() {
		String supportStartDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			supportStartDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportStartDate;

	}

	/**
	 * product table date formate
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */

	public static String getSupportExpiryDate() {
		String supportExpiryDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			supportExpiryDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportExpiryDate;

	}

	/**
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String getDueDate() {
		String dueDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			dueDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return dueDate;

	}

	/**
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String getDeferredDate() {
		String deferredDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			deferredDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return deferredDate;

	}

	/**
	 * <p>
	 * This method change the MySQL date into Calendar date format for form
	 * processing.
	 * </p>
	 * 
	 * @param inputDate
	 * @return Date String
	 */
	public static String getStartDate() {
		String startDate = null;
		java.util.Date dt = new java.util.Date();

		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			startDate = sdf.format(dt);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return startDate;

	}

}
