package com.handicraft.model.type;

public enum InquiryTypeEnum {
	Enquiry("سوال","Question"), //general inquiry
	Suggestion("پیشنهاد","Suggestion"), //user wants to send a suggestion
	Cooperation("همکاری","Cooperation"), //give us a hand
	Error_Report("گزارش خطا در سیستم","System Error"), //to report an error about the system
	Other("متفرقه","Other");
	
	private String farsiValue;
	private String engValue;
    
	InquiryTypeEnum(String farsiValue,String engValue) {
        this.farsiValue = farsiValue;
        this.engValue = engValue;
    }
    
    public String getFarsiValue() {
    	return farsiValue;
    }

    public String getEngValue() {
    	return engValue;
    }

}
