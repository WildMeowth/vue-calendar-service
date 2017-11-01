package cn.wildMeowth.vueService.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wildMeowth.vueService.dao.UserDao;
import cn.wildMeowth.vueService.service.PasswordException;
import cn.wildMeowth.vueService.service.UserIdException;
import cn.wildMeowth.vueService.util.Utils;
import cn.wildMeowth.vueService.entity.User;
@Service("userService")
public class UserService {
	@Resource(name = "userDao")
	private UserDao userDao;



	public User login(String id, String password) throws UserIdException, PasswordException, IOException {

		if(id == null || id.trim().isEmpty()){
			throw new UserIdException("�˺Ų���Ϊ��");
		}
		String reg1 = "^\\w{1,12}$";
		String reg2 = "^\\w{3,10}$";
		if(!id.matches(reg1)){
			throw new UserIdException("�˺Ų��Ϲ�");
		}
		if(password == null || password.trim().isEmpty()){
			throw new PasswordException("���벻��Ϊ��");
		}
		if(!password.matches(reg2)){
			throw new PasswordException("���벻�Ϲ�");
		}
		//��ѯ�û�����
		User user = userDao.findUserById(id);
		
		//�ж��û�ƥ�����
		if(user==null){
			throw new UserIdException("û�и��û�");
		}
//		String md5 = Utils.crypt(password);
		if(user.getPassword().equals(password)){
			//��½�ɹ�
			return user;
		}
		throw new PasswordException("�������");
	}
}
