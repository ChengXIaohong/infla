package com.chengxiaohong.infla.dto;

import java.io.Serializable;

/**
 *2018年1月9日 下午4:38:23
 *author coax only3bit@sina.cn
 *Description:前后台数据传输对象
 **/
public class Transfer<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Transfer() {
		
	}
	
	/**
	 * 返回消息判定符
	 */
	private int biz;
	
	/**
	 * 返回消息解释符
	 */
	private String bio;
	
	/**
	 * 返回数据DTO
	 */
	private T bic;

	public int getBiz() {
		return biz;
	}

	public void setBiz(int biz) {
		this.biz = biz;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public T getBic() {
		return bic;
	}

	public void setBic(T bic) {
		this.bic = bic;
	}
	
}

