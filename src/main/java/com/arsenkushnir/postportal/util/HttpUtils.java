package com.arsenkushnir.postportal.util;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

    public static String getPreviousPageUrl(HttpServletRequest request) {
        return request.getHeader("Referer");
    }
}
