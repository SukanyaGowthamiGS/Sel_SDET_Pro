package com.crm.GenericLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 *This class contains java specific generic libraries   
 * @author Sukanya
 *
 */
public class JavaUtility {
	
	/**
	 * This will generate the random number with in the boundary of 0 to 10000
	 * @return
	 */
	public int getRandom() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	/**
	 * this method will return the current date
	 * @return
	 */
	public String getCurrentDate() {
		Date date = new Date();
		String currDate = date.toString();
		return currDate;
	}
	
	/**
	 * This will the date in final format
	 * @return
	 */
	 
	public String getFinalDateFormat() {
		Date date = new Date();
		String currDate = date.toString();
		String[] date1 = currDate.split(" ");
		String YYYY=date1[5];
		String DD = date1[2];
		String MM=date1[1];
		String today= YYYY+"-"+MM+"-"+DD;
		return today;
	}
	
	/**
	 * This method is used to pass Virtual Key to OS
	 * @throws Throwable
	 */
	public void pressVurtualEnterKey() throws Throwable {
		
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	    }

	}


