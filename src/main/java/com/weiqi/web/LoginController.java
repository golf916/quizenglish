package com.weiqi.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weiqi.model.User;

@Controller
public class LoginController {
//	@Autowired
//    UserService userService;
	
	@RequestMapping("/index")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/index";
    }
	
	@GetMapping("login")
	public String loginPage(ModelMap map) {
		map.addAttribute("user", new User());
		return "loginpage";
	}
	
	@PostMapping("deal-login")
	public String login(@ModelAttribute User user) {
		System.out.println("username is "+user.getUsername());//for test
		if (!isUserValid(user)) {
            return "redirect:/user";
        }
		getSession().setAttribute("userLogin", user.getUsername());
		
		return "index";
	}
	
	public boolean isUserValid(User user) {
        return "admin".equals(user.getUsername()) && "123456".equals(user.getPassword());
    }
	
	public static HttpSession getSession() { 
	    HttpSession session = null; 
	    try { 
	        session = getRequest().getSession(); 
	    } catch (Exception e) {} 
	        return session; 
	} 
	    
	public static HttpServletRequest getRequest() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getRequest(); 
	}
}
