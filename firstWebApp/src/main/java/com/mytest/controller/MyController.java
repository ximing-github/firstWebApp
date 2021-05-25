package com.mytest.controller;

import com.mytest.beans.User;
import com.mytest.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName:MyController
 * Package: com.mytest.controller
 * Description:
 *
 * @Date: 2021/5/24 12:20
 * @Author: 惜名
 */
@Controller
public class MyController {
    @Autowired
    private TransferService transferService;
    @RequestMapping(value = "/login")
    public ModelAndView doSome(HttpServletRequest request,User user){
        ModelAndView mv=new ModelAndView();
        List<User> list = transferService.selectAllUser();
        if(list.contains(user)) {
            request.getSession().setAttribute("username", user.getUsername());
            mv.setViewName("transfer");

            return mv;
        }
        mv.addObject("msg","登录失败");
        mv.setViewName("eorr");
        return mv;
    }
    @RequestMapping(value = "/ajax",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String check(String username,String balance){
        User user = transferService.selectOne(username);
        if(user!=null&&user.getBalance()<Double.parseDouble(balance)){

            return "余额不足";
        }
        return "";

    }
    @RequestMapping(value = "/transfer.do")
    public String transfer(String outusername,String inusername,double balance){
        boolean b = transferService.transfer(outusername, inusername, balance);
        if(b) {
            return "success" ;
        }
        return "error";

    }
}
