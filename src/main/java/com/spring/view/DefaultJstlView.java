package com.spring.view;

import org.springframework.web.servlet.view.JstlView;

import java.io.File;
import java.util.Locale;

/**
 * @description:判断JSP文件是否存在
 * @author: Cherry
 * @time: 2020/6/10 11:07
 */
public class DefaultJstlView extends JstlView {
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        File file = new File(this.getServletContext().getRealPath("/")+getUrl());
        return file.exists();
    }
}
