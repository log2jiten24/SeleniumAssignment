package com.devskiller.selenium;

public class QueryStringBuilder {

    public static String buildQueryString(String... queryParams) {
        if (queryParams.length == 0 || queryParams.length % 2 != 0) {
            return "";
        }

        String[] separators = {"=", "&"};
        StringBuilder sb = new StringBuilder("?");
        for (int i = 0; i < queryParams.length; i++) {
            sb.append(queryParams[i]);
            if (i < queryParams.length - 1) {
                sb.append(separators[i % 2]);
            }
        }
        return sb.toString();
    }

}
