package com.auto.enums;

public enum BottomFooterLinks {
	ABOUTNEWLOOK("Terms & Conditions","termsAndConditions"),
	CAREERS("Privacy & Cookies Policy","/privacy/");

	private String linkName;
	private String url;

	BottomFooterLinks(String linkName, String url){	this.linkName = linkName;	this.url = url;	}

	public static String getLinkName(BottomFooterLinks bottomFooterLinks) {return bottomFooterLinks.linkName;}
	public static String getUrl(BottomFooterLinks bottomFooterLinks) {return bottomFooterLinks.url;}
}