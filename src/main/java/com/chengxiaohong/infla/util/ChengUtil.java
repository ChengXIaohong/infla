package com.chengxiaohong.infla.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 工具类 
 * 
 * 2018年1月11日 下午12:00:38 
 * author coax only3bit@sina.cn 
 * Description
 **/
public class ChengUtil {

	/**
	 * param isEmpty ? true :fasle @Title: isEmpty @Description: TODO(param isEmpty
	 * ? true :fasle) @param @param param @param @return boolean : true
	 * false @return boolean @throws
	 */
	public static boolean isEmpty(Object param) {
		if (null == param) {
			return true;
		}
		if ("".equals(param)) {
			return true;
		}
		if (param instanceof String) {
			if (((String) param).length() == 0) {
				return true;
			}
		}
		if (param instanceof Collection) {
			if (((Collection<?>) param).size() == 0) {
				return true;
			}
		}
		if (param instanceof Map) {
			if (((Map<?, ?>) param).size() == 0) {
				return true;
			}
		}
		return false;

	}

	/**
	 * param isNotEmpty ? true :fasle @Title: isEmpty @Description: TODO(param
	 * isNotEmpty ? true :fasle) @param @param param @param @return boolean : true
	 * false @return boolean @throws
	 */
	public static boolean isNotEmpty(Object param) {
		if (null == param) {
			return false;
		}
		if ("".equals(param)) {
			return false;
		}
		if (param instanceof String) {
			if (((String) param).length() == 0) {
				return false;
			}
		}
		if (param instanceof Collection) {
			if (((Collection<?>) param).size() == 0) {
				return false;
			}
		}
		if (param instanceof Map) {
			if (((Map<?, ?>) param).size() == 0) {
				return false;
			}
		}
		return true;

	}

	/**
	 * regex Test @Title: regex @Description: TODO(Test) @param @param sourcesStr
	 * regexing @param @param regexStr regexingpattern @param @return
	 * boolean @return boolean @throws
	 */
	public static boolean regex(String sourcesStr, String regexStr) {
		Pattern pattern = Pattern.compile(regexStr);
		return pattern.matcher(sourcesStr).matches();
	}

	/**
	 * 文件转换为字符串
	 * 
	 * @param in
	 *            字节流
	 * @param charset
	 *            文件的字符集
	 * @return 文件内容
	 */
	public static String stream2String(InputStream in, String charset) {
		StringBuffer sb = new StringBuffer();
		try {
			Reader r = new InputStreamReader(in, charset);
			int length = 0;
			for (char[] c = new char[1024]; (length = r.read(c)) != -1;) {
				sb.append(c, 0, length);
			}
			r.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 文件转换为字符串
	 * 
	 * @param f
	 *            文件
	 * @param charset
	 *            文件的字符集
	 * @return 文件内容
	 */
	public static String file2String(File f, String charset) {
		String result = null;
		try {
			result = stream2String(new FileInputStream(f), charset);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}
