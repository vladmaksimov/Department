package com.department.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDataUtil {
    public static Integer getInteger(HttpServletRequest req, String s) {
        try {
            return Integer.parseInt(req.getParameter(s));
        } catch (Exception ignored) {
        }

        return null;
    }

    public static Date getDate(HttpServletRequest req, String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
        try {
            return formatter.parse(req.getParameter(date));
        } catch (Exception ignored) {
        }
        return null;
    }

    public static java.sql.Date getSqlDate(HttpServletRequest req, String extDate) {
        Date date = getDate(req, extDate);
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }
        return null;
    }

    public static Float getFloat(HttpServletRequest req, String s) {
        if (!req.getParameter(s).isEmpty()) {
            return Float.parseFloat(req.getParameter(s));
        } else {
            return null;
        }
    }

}
