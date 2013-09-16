package com.handicraft.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.handicraft.model.UserDO;

public class OrderUtil {
	public static String generateOrderNumber(UserDO user){
    	Date date = Calendar.getInstance().getTime();
    	//hour min second day month year
    	java.text.SimpleDateFormat sdf = new SimpleDateFormat("HHmmssddMMyy");
		Random random = new Random();
		//Long l = random.nextInt(10000)
		//return l.toString() + new Date().toString();
		return sdf.format(date);
	}

}
