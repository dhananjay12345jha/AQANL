package com.auto.enums;



public enum CountryCode {


    gb("United Kingdom", "£","English"),
    fr("France", "€","Français"),
    de("Germany", "€","Deutsch"),
    at("Austria", "€","English");



    CountryCode(String country, String currency, String language) {
        this.country = country;
        this.currency = currency;
        this.language = language;
    }

    private String country;
    private String currency;
    private String language;


    public static String getCountry(CountryCode countryCode) {
        return countryCode.country;
    }
    public static String getLanguage(CountryCode countryCode) {
        return countryCode.language;
    }
    public static String getCurrency(CountryCode countryCode) {
        return countryCode.currency;
    }

}

