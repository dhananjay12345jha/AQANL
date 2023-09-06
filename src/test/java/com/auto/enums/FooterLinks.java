package com.auto.enums;

public enum FooterLinks {


	CONTACTUS("Help","Contact Us", "contact-us"),
	FAQ("Help","FAQ", "faq"),
	CMSTESTCOMPONENTSPAGE("Help","CMS Test Components Page", "cmsComponentsTestPage"),

	TRACKYOURORDER("Delivery & Returns","Track Your Order", "trackMyOrder"),
	DELIVERY("Delivery & Returns","Delivery", "help-delivery-and-collection"),

	GIFTCARDS("More ways to pay","Gift Cards", "/gift-cards/"),
	STORECARDS("More ways to pay","Store Cards", "/store-cards/"),
	STUDENTDISCOUNT("More ways to pay","Student Discount1", "/student-discount/"),
	STAFFDISCOUNT("More ways to pay","Staff Discount", "/staff-discount/"),

	ABOUTNEWLOOK("Company Information","About New Look", "/about-newlook/"),
	CAREERS("Company Information","Careers", "/careers/"),
	OURCHARITYFOUNDATION("Company Information","Our Charity Foundation", "/charity/");

	private String columnName;
	private String linkName;
	private String url;

	FooterLinks(String columnName,String linkName, String url){

		this.linkName = linkName;
		this.url = url;
		this.columnName = columnName;
	}

	public static String getColumnName(FooterLinks footerLinks) {
		return footerLinks.columnName;
	}
	public static String getLinkName(FooterLinks footerLinks) {
		return footerLinks.linkName;
	}
	public static String getUrl(FooterLinks footerLinks) {
		return footerLinks.url;
	}
}