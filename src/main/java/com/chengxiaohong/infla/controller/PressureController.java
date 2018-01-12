package com.chengxiaohong.infla.controller;

import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chengxiaohong.infla.dto.Transfer;
import com.chengxiaohong.infla.support.Runner;

/**
 *2018年1月9日 下午4:38:23
 *author coax only3bit@sina.cn
 *Description:压力测试Controller
 **/
@Controller
@RequestMapping("/pressure")
public class PressureController extends BaseController{
	
	/**
	 * @throws UnsupportedEncodingException 
	 * 有效参数 1.链接 
	* @Title: pressureUri 
	* @Description: TODO(链接压力测试) 
	* @param @param uri
	* @param @return     Transfer
	* @return Transfer<Object>    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/{reqssh}/{uri:.+}" , method = RequestMethod.GET)
	@ResponseBody
	public Transfer pressureUri(@PathVariable("reqssh") Integer reqssh,@PathVariable("uri") String uri ,Transfer transfer) {
		/*transfer.setBio(uri);
		long beforeTime = System.currentTimeMillis();
		Runner.runT(transfer);
		long alterTime = System.currentTimeMillis();
		transfer.setBic(alterTime - beforeTime);*/
		return transfer;
		
	}
	
	
	/**
	 * 有效参数 1.链接 2.并发数量
	* @Title: pressureUri 
	* @Description: TODO(链接指定访问次数压力测试) 
	* @param @param uri
	* @param @param pressureNum
	* @param @return    设定文件 
	* @return Transfer<Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/{reqssh}/{uri:.+}/{pressureNum}", method = RequestMethod.GET)
	public Transfer pressureUri(@PathVariable("reqssh") Integer reqssh,@PathVariable("uri") String uri, @PathVariable("pressureNum") Integer pressureNum) {
		Transfer<Object> transfer = new Transfer<Object>();
		transfer.setBio(uri);
		long beforeTime = System.currentTimeMillis();
		if(reqssh == 1) {
			uri = "https://" + uri;
		} else {
			uri = "http://" + uri;
		}
		Runner.runT(transfer);
		long alterTime = System.currentTimeMillis();
		transfer.setBic(alterTime - beforeTime);
		return transfer;
	}
}
