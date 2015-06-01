package edu.swu.social.utils;


import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class HttpUtils {
    /**
     * 判断请求是否为AJAX请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        boolean ajax = "XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"));
        String ajaxFlag = null == request.getParameter("ajax") ? "false" : request.getParameter("ajax");

        return ajax || ajaxFlag.equalsIgnoreCase("true");
    }
}
