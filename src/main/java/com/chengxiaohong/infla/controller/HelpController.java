package com.chengxiaohong.infla.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.chengxiaohong.infla.dto.Transfer;
import com.chengxiaohong.infla.util.BizIdentifier;
import com.chengxiaohong.infla.util.InflaUtil;

/**
  * 帮助Controller API
 *2018年1月11日 上午11:27:53
 *author coax only3bit@sina.cn
 *Description
 **/
@ResponseBody
@Controller
@RequestMapping("/help")
public class HelpController extends BaseController{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping("/helpindex")
	public Transfer help(Transfer t,HttpServletRequest request) throws Exception {
		t.setBiz(BizIdentifier.SUCCESS.getBizCode());
		t.setBio(BizIdentifier.SUCCESS.getBizName());
		t.setBic(InflaUtil.getHelper());
		return t;
	}
	
	@RequestMapping("/{s}")
	public Transfer<String> t(@PathVariable("s") String s) {
		Transfer<String> t = new Transfer<String>();
		t.setBic(s);
		RequestMappingHandlerAdapter d;
		return t;
	}
	
}

