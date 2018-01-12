package com.chengxiaohong.infla.support;

import com.chengxiaohong.infla.dto.Transfer;
import com.chengxiaohong.infla.util.ChengUtil;
import com.chengxiaohong.infla.util.Constant;

/**
 * 测试启动类 2018年1月11日 下午4:26:33 author coax only3bit@sina.cn Description
 **/
public class Runner {
	@SuppressWarnings("unused")
	private static boolean isRunGrabThread = true; // 抓取线程执行状态
	static int dync = 1; // 动态参数

	public static void runT(Transfer<Object> params) {
		Thread[] grabThreads = new Thread[ 0 <= params.getBiz() ? Constant.THREAD_COUNT : params.getBiz()];
		try {
			// 开启数据抓取子线程
			for (int i = 0; i < grabThreads.length; i++) {
				int numL = dync * 100;
				
				String url = (params.getBio().startsWith("http://") ? params.getBio() : "http://" +  params.getBio()) + "/s?wd=" + numL;
				
				System.out.println(url);
				
				Thread uriPressure = new UriPressure(url);
				grabThreads[i] = uriPressure;
				grabThreads[i].setDaemon(true);
				grabThreads[i].start();
				numL++;
			}
			isRunGrabThread = true;
			// 监控子线程 全部完成退出程序
			WhileLoop: while (true) {
				for (int i = 0; i < grabThreads.length; i++) {
					// 判断子线程是否运行完成
					if (grabThreads[i].isAlive()) {
						Thread.sleep(10);
						continue WhileLoop;
					}
				}
				// 所用子线程执行完毕
				isRunGrabThread = false;
				// 子线程执行完毕则退出
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
