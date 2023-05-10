/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.

 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     LeadTitleVO.java     
 *                                                            
 * Creation Date   22 August, 2015 
 * 
 * Abstract       This class is a model class.
 *  
 * Amendment History (in chronological sequence):  22 August, 2015 
 * 
 **********************************************************************
 */
package com.bst.ckt.vo;

/**
 * <p>
 * <code>LeadTitleVO</code> is a Model class which holds the lead title bean
 * values for retrieving the lead credentials entered by user.
 * </p>
 * 
 * @author Kalu Ram Chakrawarti
 * @version V1.0
 */
public class LeadTitleVO {
	
   private	int leadId;
   private String leadTitle;
   
   
/**
 * @return the leadId
 */
public int getLeadId() {
	return leadId;
}
/**
 * @param leadId the leadId to set
 */
public void setLeadId(int leadId) {
	this.leadId = leadId;
}
/**
 * @return the leadTitle
 */
public String getLeadTitle() {
	return leadTitle;
}
/**
 * @param leadTitle the leadTitle to set
 */
public void setLeadTitle(String leadTitle) {
	this.leadTitle = leadTitle;
}
   
   
   

}
