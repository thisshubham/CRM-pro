package com.bst.ckt.helper;

import java.io.Serializable;

public class AppendHelper implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;

	/**
	 * Compare object with LeadStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public static StringBuffer sb = null;

	public static String appendSalutaion(int salutaion, String contacPerson) {
		sb = new StringBuffer();

		if (salutaion == 1) {
			return contacPerson;
		} else {
			sb.append(Salutation.getSalutation(salutaion)).append(" ")
					.append(contacPerson);

			return sb.toString();
		}
	}

	public static String appendNumber(String phoneIsd, String phoneStd,
			String phoneNo) {
		sb = new StringBuffer();
		sb.append(phoneIsd).append(" ").append(phoneStd).append(" ")
				.append(phoneNo);

		return sb.toString();
	}

	public static String appendNumber(String mobileIsd, String mobileNo) {
		sb = new StringBuffer();
		sb.append(mobileIsd).append(" ").append(mobileNo);

		return sb.toString();
	}

}
