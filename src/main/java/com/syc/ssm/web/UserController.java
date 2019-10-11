package com.syc.ssm.web;

import com.syc.ssm.bean.User;
import com.syc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

  // 测试返回一个jsp
//  @RequestMapping("test2")
//  public String test2(){
//    System.out.println("test2....");
//    return "test2";
//  }
//  @RequestMapping(value = "login",method = RequestMethod.POST)
//    public String login(){
//      return "login";
//    }

  //登录
  @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpSession session){

      User user1 = userService.login(user);
   //   System.out.println(user1);
      if(user1 !=null){
        //保存到了session中.
        session.setAttribute("user",user1);
        //当用户存在的时候,跳转到展示用户信息的界面
        return "showUser";
      }

      // 请求转发--->/WEB-INF/jsp/login.jsp
      return "login";
    }
    //退出登录
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String login(HttpSession session){
      //销毁session
      session.invalidate();
      // 请求转发--->/WEB-INF/jsp/login.jsp
      return "login";
    }


    //注册
    //跳转到注册界面
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegister(){
      // 请求转发--->/WEB-INF/jsp/register.jsp
      return "register";
    }
  @RequestMapping(value = "/register",method = RequestMethod.POST)
  public String register(User user, Model model){
    int result = userService.register(user);
    if(result>0){
      model.addAttribute("user",user);
      return "success";
    }
    return "register";
  }


}
