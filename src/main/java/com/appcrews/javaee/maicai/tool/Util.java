package com.appcrews.javaee.maicai.tool;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by micheal on 2017/7/21.
 */
public  class Util {
    public static<T> void renderData(HttpServletResponse response, T data) {
        PrintWriter printWriter = null;
        response.setContentType("text/html;charset=utf-8");
        try {
            printWriter = response.getWriter();
            printWriter.print(data);
        } catch (IOException ex) {
            Logger.getLogger("ajax").log(Level.SEVERE, null, ex);
        } finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}
