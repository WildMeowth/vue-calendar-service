package cn.wildMeowth.vueService.dao;


import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Repository;

import cn.wildMeowth.vueService.entity.User;

@Repository(value="userDao")
public class UserDao {
	public User findUserById(String id) throws IOException{
		Properties prop = new Properties();
        prop.load(UserDao.class.getResourceAsStream("/properties/user.properties"));
        String value = prop.getProperty(id);
        String[] str = value.split(",");
        System.out.println(str.length);
        User user = new User(id,str[0],str[1],str[2]);
		return user;
	};
}
