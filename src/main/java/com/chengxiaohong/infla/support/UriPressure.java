package com.chengxiaohong.infla.support;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
  * 压力并发支持
 *2018年1月11日 下午3:53:40
 *author coax only3bit@sina.cn
 *Description
 **/
public class UriPressure extends Thread{
	private String httpUrl;
	
	public UriPressure(String httpUrl) {
		super();
		this.httpUrl = httpUrl;
	}
	
	@Override
	public void run() {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		URL url = null;
		try {
			url = new URL(httpUrl);
			connection = (HttpURLConnection)url.openConnection();
			connection.connect();
			inputStream  = connection.getInputStream();
			Thread.sleep(10L);
		} catch ( MalformedURLException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

