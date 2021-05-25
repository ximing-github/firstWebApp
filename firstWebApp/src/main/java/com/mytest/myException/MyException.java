package com.mytest.myException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:MyException
 * Package: com.mytest.myException
 * Description:
 *
 * @Date: 2021/5/21 13:28
 * @Author: 惜名
 */
@ControllerAdvice
public class MyException {
    @ExceptionHandler(value = Exception.class)
    public void  dosome(Exception e){
        System.out.println(e.getMessage());

    }
}
