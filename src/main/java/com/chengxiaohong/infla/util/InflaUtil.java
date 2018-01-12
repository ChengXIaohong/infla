package com.chengxiaohong.infla.util;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.alibaba.fastjson.JSONObject;

/**
  * 专属工具类
 *2018年1月11日 下午3:38:13
 *author coax only3bit@sina.cn
 *Description
 **/
public class InflaUtil {
	/**
	 * 帮助文档内存化
	 */
	public static JSONObject helpJson;
	
	/**
	 * 
	* @Title: getHelper 
	* @Description: TODO(获取帮助) 
	* @param @return
	* @param @throws DocumentException    
	* @return JSONObject    fastJson文件 
	* @throws
	 */
	public static JSONObject getHelper() throws DocumentException {
		if(ChengUtil.isEmpty(helpJson)) {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("help/help.xml");
			String xmlStr= ChengUtil.stream2String(in, "UTF-8");
			Document doc = DocumentHelper.parseText(xmlStr);
			helpJson = new JSONObject();
			Xml2Json.dom4j2Json(doc.getRootElement(), helpJson);
		}
		return helpJson;
	}
	
}

