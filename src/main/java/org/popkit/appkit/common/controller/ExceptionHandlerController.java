package org.popkit.appkit.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 对全站的非法url进行处理
 * 404 not fonud, 注意：这里要配置web.xml初始化DispatcherServlet的
 * throwExceptionIfNoHandlerFound 参数为true
 * Author: Aborn Jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 10-15-2015
 * Time  : 10:22 AM
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public String doNoHandlerFoundException(HttpServletRequest request, Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return "redirect:/index.html";
        } else {
            return "/common/index";
        }
    }
}
