/*

package com.ias.admin.common.resolver;

import com.ias.admin.common.util.MyLogger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorURLController implements ErrorController{

    private MyLogger logger = MyLogger.getLogger(getClass());
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String handleError() {
        return "common/error/404";
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}

*/
