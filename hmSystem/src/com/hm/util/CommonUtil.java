package com.hm.util;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CommonUtil {

	private static final Pattern NumericPattern = Pattern.compile("[0-9]*");

	private static final Pattern MobilePattern = Pattern
			.compile("^((13[0-9])|(15[^4,\\D])|(17[0,5-9])|(18[0,5-9]))\\d{8}$");

	private static final Pattern EmailPattern = Pattern
			.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

	
	/**
	 * 输入对象为json 数据到 网页。
	 * @param obj
	 * @param response
	 */
	public static void WriteJson(Object obj, HttpServletResponse response) {
		if (null != obj) {
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
					.setDateFormat("yyyy-MM-dd HH:mm:ss").create();

			response.setContentType("text/html; charset=utf-8");
			try {

				System.out.println(gson.toJson(obj));

				response.getWriter().write(gson.toJson(obj));
				response.getWriter().flush();
			} catch (IOException e) {
			}

		}
	}
	
	
	/**
	 * 根据用户的访问, 得到当前请求的URL
	 * 
	 * @param request
	 * @return 末尾带 / http://localhost:8080/hmSystem/
	 * 
	 */
	public static String getHostNameURL(HttpServletRequest request) {

		String sret = "";
		sret += request.getScheme() + "://" + request.getServerName();
		if (request.getServerPort() != 80)
			sret += ":" + request.getServerPort();
		if (!"/".equals(request.getContextPath()))
			sret += request.getContextPath() + "/";
		else
			sret += request.getContextPath();
		return sret;
	}

	// 判断是否主tomcat , 方便判断只能在单tomcat 中执行任务
	public static boolean isMainTomcatServer() {
		String tomcatid = System.getProperty("tomcatid", "0");
		if ("1".equals(tomcatid))
			return true;
		else
			return false;

	}

	/**
	 * 打印request中的所有的参数, 数值 调试使用
	 * 
	 * @param request
	 */
	public static void PrintParametersRequest(HttpServletRequest request) {
		Enumeration<String> enname = request.getParameterNames();
		while (enname.hasMoreElements()) {
			String name = enname.nextElement();
			String val = request.getParameter(name);
			System.err.println(name + ":" + val);
		}

	}

	/**
	 * 
	 * 打印request 内所有的header 字段。 
	 * 	
	 * @param request
	 */
	public static void PrintHeaderRequest(HttpServletRequest request) {
		Enumeration<String> enname = request.getHeaderNames();
		while (enname.hasMoreElements()) {
			String name = enname.nextElement();
			String val = request.getHeader(name);
			System.err.println(name + ":" + val);
		}

	}
	
	
	public static String getHostNameURLNoPath(HttpServletRequest request) {

		String sret = "";
		sret += request.getScheme() + "://" + request.getServerName();
		if (request.getServerPort() != 80)
			sret += ":" + request.getServerPort();
		return sret;
	}
	/**
	 * 打印调试信息， object[]
	 * @param os
	 * @return
	 */
	public static String ArrayToString(Object os[]) {

		StringBuffer sb = new StringBuffer(2048);
		for (Object o : os)
			sb.append(o.toString() + ",");

		return sb.toString();
	}

	/**
	 * 随机一个数，
	 * 
	 * @param maxval
	 *            ： 最大数据
	 * @return 0到maxval
	 */
	public static int getRandomInt(int maxval) {

		int nval = (int) (Math.random() * 10000000);
		return nval % maxval;
	}

	/**
	 * 将字符中含有html 特殊字符转义
	 * 
	 * @param strXml
	 * @return
	 */
	public static String toHTML(String strXml) {

		if (strXml == null || strXml.length() == 0)
			return strXml;
		StringBuffer sb = new StringBuffer(strXml.length() + 30);

		for (int i = 0; i < strXml.length(); i++) {
			char c = strXml.charAt(i);
			switch (c) {
			case '<':
				sb.append("&lt;");
				continue;
			case '>':
				sb.append("&gt;");
				continue;
			case '&':
				sb.append("&amp;");
				continue;
			case '\'':
				sb.append("&apos;");
				continue;
			case '"':
				sb.append("&quot;");
				continue;
			case '\r':
				sb.append("&#xd;");
				continue;
			case '\n':
				sb.append("&#xa;");
				continue;
			default:
				sb.append(c);
				continue;
			}
		}

		return sb.toString();

	}

	/**
	 * 判断字符串是否全为数字组成
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {

		return NumericPattern.matcher(str).matches();
	}

	/**
	 * 判断是否为手机号码
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobile(String mobile) {

		return MobilePattern.matcher(mobile).matches();
	}

	/**
	 * 判断字符串是否为邮箱格式
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isEmail(String email) {

		return EmailPattern.matcher(email).matches();
	}

	/**
	 * 方便调试， 打印一个mp 到控制窗口。
	 * 
	 * @param mp
	 * @return
	 */
	public static void MapToStr(StringBuffer sb, Map mp) {

		if (mp == null)
			return;

		Iterator<String> itkey = mp.keySet().iterator();
		while (itkey.hasNext()) {
			String key = itkey.next();
			sb.append(key + "::\r\n\t");
			Object o = mp.get(key);
			if (o instanceof Map) {
				sb.append("\r\n\t");
				MapToStr(sb, (Map) o);
			} else if (o instanceof List) {
				sb.append("\r\n\t");
				ALtoStr(sb, (List) o);
			} else {
				sb.append(ObjectToString(o) + "\r\n");
			}

		}

	}

	public static void ALtoStr(StringBuffer sb, List ol) {

		if (ol == null)
			return;

		for (Object o : ol) {
			if (o instanceof Map) {
				sb.append("\r\n\t");
				MapToStr(sb, (Map) o);
			} else if (o instanceof List) {
				sb.append("\r\n\t");
				ALtoStr(sb, (List) o);
			} else {
				sb.append(ObjectToString(o) + "\r\n");

			}
		}

	}

	/**
	 * 将某一个对象转换成string ， 方便打印调试信息。
	 * 
	 * @param oo
	 * @return
	 */
	public static String ObjectToString(Object oo) {

		try {
			return ToStringBuilder.reflectionToString(oo);
			// return BeanUtils.describe(oo).toString();

		} catch (Exception se) {
		}
		return "";

	}

	/**
	 * 检测与创建文件夹、文件名 通过此种办法我们可以做到根据用户的选择保存到相应的文件夹下
	 */
	private static File creatFolder(String mulu, String fileName) {

		File file = null;
		mulu = mulu.replaceAll(" ", ""); // 替换半角空格
		mulu = mulu.replaceAll(" ", ""); // 替换全角空格

		File firstFolder = new File(mulu);
		if (!firstFolder.exists()) {
			boolean aa = firstFolder.mkdirs();

		}

		file = new File(mulu + fileName);
		return file;
	}

	/**
	 * 根据key获取用户在session中的object
	 * 
	 * @param request
	 * @param userId
	 * @return
	 */
	public static Object getObjectFromSession(HttpServletRequest request, String key) {

		return request.getSession().getAttribute(key);
	}

	/**
	 * 根据key设置将信息存入session中
	 * 
	 * @param request
	 * @param us
	 * @param ru
	 * @return
	 */
	public static void setObjectSession(HttpServletRequest request, String key,
			Object value) {

		try {
			request.getSession().setAttribute(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 验证邮箱格式是否正确
	 * 
	 * @param email
	 * @return
	 */
	public static boolean emailFormat(String email) {

		boolean tag = true;
		final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
			tag = false;
		}
		return tag;
	}

	

	/**
	 * 将数字转换为中文
	 * 
	 * @param input
	 * @return
	 */
	public static String getCHNumber(int input) {

		String a = String.valueOf(input);
		String output = "";
		for (int i = 0; i < a.length(); i++) {
			char aa = a.charAt(i); // 取字符串下标索引是i的数 i循环的次数根据字符串的长度.
			if (aa == '1')
				output += "一";
			if (aa == '2')
				output += "二";
			if (aa == '3')
				output += "三";
			if (aa == '4')
				output += "四";
			if (aa == '5')
				output += "五";
			if (aa == '6')
				output += "六";
			if (aa == '7')
				output += "七";
			if (aa == '8')
				output += "八";
			if (aa == '9')
				output += "九";
			if (aa == '0')
				output += "零";
		}
		return output;
	}

	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/**
	 * 计算字符长度, 按中文字符计算. 2个英文字符算1个长度单位
	 * 
	 * @param strName
	 * @return
	 */
	public static int getChineseLength(String strName) {
		float flen = 0f;
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			System.out.println((int) ch[i]);
			char c = ch[i];
			if (isChinese(c)) {
				flen += 1.0f;
			} else
				flen += 0.5f;
		}

		return (int) Math.ceil(flen);

	}

	/**
	 * 剪切字符串,
	 * 
	 * @param s
	 *            原始字符
	 * @param ncutlen
	 *            截取的长度, 按中文算, 英文字符算半个字符
	 * @return
	 */
	public static String CutStringLength(String s, int ncutlen) {
		String sret = "";
		float flen = 0.0f;
		if (s == null)
			return sret;
		StringBuffer sb = new StringBuffer(s.length());

		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				flen += 1.0f;
			} else
				flen += 0.5f;
			int nowlen = (int) Math.ceil(flen);
			sb.append(c);
			if (nowlen >= ncutlen) {
				break;
			}

		}

		return sb.toString();

	}

	public static void main(String args[]) {
		String sdest = CutStringLength("123我无语了,", 4);
		System.out.println(sdest);
	}

}
