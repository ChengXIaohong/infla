package com.chengxiaohong.infla.util;

 /**
  * 操作标识符类
 *2018年1月11日 下午3:26:10
 *author coax only3bit@sina.cn
 *Description
 **/
public enum BizIdentifier {
	
	SUCCESS(200,"操作成功");

	private int bizCode;
	private String bizName;
	
	BizIdentifier(int bizCode, String bizName){
		this.bizCode = bizCode;
		this.bizName = bizName;
	}

	public int getBizCode() {
		return bizCode;
	}
	
	public String getBizName() {
		return bizName;
	}

}

