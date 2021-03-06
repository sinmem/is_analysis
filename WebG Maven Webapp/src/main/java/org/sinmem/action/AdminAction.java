package org.sinmem.action;

import java.util.HashMap;

import org.sinmem.bean.Admin;
import org.sinmem.bean.Student;
import org.sinmem.service.UserService;
import org.sinmem.service.impl.InstituteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import utils.GsonUtils;

@Controller
public class AdminAction extends UserInterfImpl<Admin>{
	@Autowired
	UserService<Admin> userService;
	@Autowired
	InstituteServiceImpl instituteServiceImpl;
	
//	@Override
//	public String update_user(String data) {
//		// 暂无操作
//		return null;
//	}

	@Override
	public String get_MUserInfo(Admin user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Admin tempAdmin = userService.getUserInfo(user);
		map.put("user", tempAdmin);
		map.put("institute", instituteServiceImpl.get_modle(tempAdmin.getInstituteno()));
		return GsonUtils.toJson(map);
	}

	// setter/getter
}
