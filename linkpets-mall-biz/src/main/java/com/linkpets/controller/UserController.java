//package com.linkpets.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSONObject;
//import com.linkpets.service.ITestService;
//import CommonUtil;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//	@Autowired
//	ITestService testService;
//
//	@GetMapping("/info")
//	public JSONObject getTestInfo() {
//		String port = CommonUtil.SERVER_PORT;
//		String petId = CommonUtil.getSerialNumberByPrefix("pet");
//		System.out.println("----------------" + port + "    " + petId + "------------------");
//		JSONObject data = testService.getTestInfo(1);
//		data.put("SERVER_PORT", port);
//		data.put("petId", petId);
//		return data;
//	}
//
//	@GetMapping("info2")
//	public JSONObject getInfo(){
//		JSONObject data = new JSONObject();
//		return data;
//	}
//
//}
