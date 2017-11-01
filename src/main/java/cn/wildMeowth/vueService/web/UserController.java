package cn.wildMeowth.vueService.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wildMeowth.vueService.entity.User;
import cn.wildMeowth.vueService.service.PasswordException;
import cn.wildMeowth.vueService.service.UserIdException;
import cn.wildMeowth.vueService.service.UserService;
import cn.wildMeowth.vueService.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/login.do")
	@ResponseBody

	public JsonResult<Map<String,String>> login(String id, String password, HttpServletResponse res) throws UserIdException, PasswordException, IOException {
		User user = userService.login(id, password);
		Map<String,String> userMap = new HashMap<String, String>();
		userMap.put("id", user.getId());
		userMap.put("name", user.getName());
		Cookie cookie = new Cookie("token", user.getToken());
		cookie.setPath("/");
		res.addCookie(cookie);
		return new JsonResult<Map<String,String>>(userMap);
	}

}
