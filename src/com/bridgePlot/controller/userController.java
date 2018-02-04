package com.bridgePlot.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bridgePlot.entity.MoviePlot;
import com.bridgePlot.entity.MovieRole;
import com.bridgePlot.entity.Plot;
import com.bridgePlot.entity.PlotIndex;
import com.bridgePlot.entity.User;
import com.bridgePlot.service.PlotMovieRoleService;
import com.bridgePlot.service.UserService;

@Controller
public class userController {
	
	@Autowired public UserService userService;
	@Autowired public PlotMovieRoleService plotMovieRoleService;
	//主页
	@RequestMapping(value={"/","/index"},method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model) {	
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
    //退出
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logoutGet(HttpServletRequest request) {		
		request.getSession().removeAttribute("user");
        return "redirect:index";
	}
	
	//请求桥段
	@RequestMapping(value="getMore",method=RequestMethod.GET)
	@ResponseBody
	public List<PlotIndex> getMorePlot(HttpServletRequest request) {	
		List<PlotIndex> p= plotMovieRoleService.getPlotIndex();
        return p;
	}
	
	//具体的桥段页面
	@RequestMapping(value="plot/{plotId}",method=RequestMethod.GET)
	public String getPlot(@PathVariable int plotId,Model model) {		
		Plot p = plotMovieRoleService.getPlotById(plotId);
		List<MoviePlot> moviePlot = plotMovieRoleService.getMoviePlotByPlot(p.getPlot_name());
		model.addAttribute("moviePlot", moviePlot);
		model.addAttribute("plot",p);
        return "tropes";
	}
	
	//具体的电影+桥段页面
	@RequestMapping(value="movieplot/{moviePlotId}",method=RequestMethod.GET)
	public String getMoviePlot(@PathVariable int moviePlotId,Model model) {		
		MoviePlot p = plotMovieRoleService.getMoviePlotById(moviePlotId);
		List<MoviePlot> moviePlot = plotMovieRoleService.getMoviePlotByOtherPlotAndMovie(p.getPlot_name(), p.getPlot_at_movie());
		model.addAttribute("otherPlot", moviePlot);
		model.addAttribute("moviePlot",p);
        return "tropes_specific";
	}
	
	//具体的角色+桥段页面
	@RequestMapping(value="movierole/{roleId}",method=RequestMethod.GET)
	public String getRole(@PathVariable int roleId,Model model) {		
		MovieRole r = plotMovieRoleService.getMovieRoleById(roleId);
		model.addAttribute("role",r);
        return "role";
	}
	
	//新增
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String saveGet(){
		return "editPlot";
	}
	@RequestMapping(value="/addMovie",method=RequestMethod.GET)
	public String saveMovieGet(){
		return "editPlotMovie";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveEdit(HttpServletRequest request, HttpServletResponse response,MultipartFile image)
	{
		String name = (String)request.getParameter("plotname");
		String label = (String)request.getParameter("label");
		String time = (String)request.getParameter("pasttime");
		String content = (String)request.getParameter("content");
		String cutImage = (String)request.getParameter("cutImage");
		String isNew = request.getParameter("isNew");
	
		User author = (User)(request.getSession().getAttribute("user"));
	 	try{
	 		String servletRoot =  request.getSession().getServletContext().getRealPath("");
	 		String tempFileName ="/facgnImg/";
	 		servletRoot = plotMovieRoleService.uploadTrueUrl(servletRoot);
            if(time.equals("")){
            	tempFileName+="plot/";
            }
            else{
            	tempFileName+="movie/";
            }
            
	 		if(isNew.equals("1")){
	            String dataPrix = "";  
	            String data = "";            
	            if(cutImage == null || "".equals(cutImage)){  
	                throw new Exception("上传失败，上传图片数据为空");  
	            }else{  
	                String [] d = cutImage.split("base64,");  
	                if(d != null && d.length == 2){  
	                    dataPrix = d[0];  
	                    data = d[1];  
	                }else{  
	                    throw new Exception("上传失败，数据不合法");  
	                }  
	            }       
	           
	            String suffix = "";  
	            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据  
	                suffix = ".jpg";  
	            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据  
	                suffix = ".ico";  
	            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据  
	                suffix = ".gif";  
	            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据  
	                suffix = ".png";  
	            }else{  
	                throw new Exception("上传图片格式不合法");  
	            }  
	            tempFileName = tempFileName+UUID.randomUUID().toString() + suffix;    
	            
	            byte[] bs = Base64Utils.decodeFromString(data); 
	            try{  
	            	FileUtils.writeByteArrayToFile(new File(servletRoot, tempFileName), bs);    
	            }catch(Exception ee){  
	                throw new Exception("上传失败，写入文件失败，"+ee.getMessage());  
	            }
	         }else{
	        	 if(request.getParameter("plotpic")!=null){
	        		 tempFileName = request.getParameter("plotpic");
	        	 }else {tempFileName += "0.png";}
	         }
	 		
	 		System.out.println(request.getParameter("edittick"));
	 		 if(request.getParameter("edittick")!=null){
			  	 int edittick = Integer.parseInt(request.getParameter("edittick"));
				 int absoluteid = Integer.parseInt(request.getParameter("absoluteid"));
				 System.out.println(edittick);
				 plotMovieRoleService.save(name,content,label,time,tempFileName,author.getUsername(),author.getId(),edittick+1,absoluteid);
			 }else{
				 plotMovieRoleService.save(name,content,label,time,tempFileName,author.getUsername(),author.getId(),1,-1);
			 }
	 		 return "redirect:index";                
        }catch (Exception e) {                  
            return "redirect:index";  
        }          
	} 
	@RequestMapping(value="/revise/{type}/{id}",method=RequestMethod.GET)
	public String reviseGet(@PathVariable String type,@PathVariable int id,Model model){
		if(type.equals("plot")){
			Plot plot = plotMovieRoleService.getPlotByIdNewest(id);
			model.addAttribute("plot", plot);
			return "editPlot";
		}else if(type.equals("movieplot")){
			MoviePlot moviePlot = plotMovieRoleService.getMoviePlotByIdNewest(id);
			model.addAttribute("plot", moviePlot);
			return "editMoviePlot";
		}
		return "我不管";
	}
	
}

