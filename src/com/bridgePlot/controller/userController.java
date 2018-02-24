package com.bridgePlot.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bridgePlot.entity.User;
import com.bridgePlot.service.CommentService;
import com.bridgePlot.service.UserService;

@Controller
public class userController {
	
	@Autowired public UserService userService;
	@Autowired public CommentService commentService;
	//主页
	@RequestMapping(value={"/","/index"},method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) {	
		request.getSession().setAttribute("downloadNum",-1);
        return "index";
	}
	//登录
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginGet(HttpServletRequest request) {	
        return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginPost(User user,HttpServletRequest request) {
		
		User u = null;
		if(user.getEmail()!=null && user.getPassword()!=null){
			u = userService.loginByMailAndPassword(user.getEmail(), user.getPassword());
		}
		if(u==null){return "login";}
		
		request.getSession().setAttribute("user",u);
		return "redirect:index";
	}
    //注册
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerGet() {		
        return "register";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerPost(User user,HttpServletRequest request) {
		if(user.getEmail()!=null && user.getPassword()!=null && user.getUsername()!=null){
			userService.save(user);
			request.getSession().setAttribute("user",user);
	        return "redirect:index";
		}
		else{
			return "redirect:login";
		}
	}
	//个人信息
	@RequestMapping(value="myInformation",method=RequestMethod.GET)
	public String myInformation(HttpServletRequest request,Model model){
		if(request.getSession().getAttribute("user")==null){
			return "redirect:login";
		}
		model.addAttribute("user",(User)request.getSession().getAttribute("user"));
		return "userInformation";
	}
	//修改个人信息
	@RequestMapping(value="modifyInformation",method=RequestMethod.GET)
	public String modifyInformationGet(HttpServletRequest request){
		if(request.getSession().getAttribute("user")==null){
			return "redirect:login";
		}
		return "modifyInformation";
	}
	@RequestMapping(value="modifyInformation",method=RequestMethod.POST)
	public String modifyInformationPost(HttpServletRequest request){
		String oldPassword = (String)request.getParameter("oldPassword");
		System.out.println(oldPassword);
		System.out.println(((User)request.getSession().getAttribute("user")).getPassword());
		if(!oldPassword.equals(((User)request.getSession().getAttribute("user")).getPassword())){
			return "redirect:modifyInformation";
		}
		String newPassword = request.getParameter("newPassword");
		String userName = request.getParameter("userName");
		User u = (User)request.getSession().getAttribute("user");
		u.setPassword(newPassword);
		u.setUsername(userName);
		userService.updatePassword(newPassword, u.getId());
		userService.updateUserName(userName, u.getId());
		return "userInformation";
	}
    //退出
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logoutGet(HttpServletRequest request) {		
		request.getSession().removeAttribute("user");
        return "redirect:index";
	}

	
}