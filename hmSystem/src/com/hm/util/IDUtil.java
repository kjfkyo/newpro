package com.hm.util;

import java.util.UUID;

/**
 * ID生成器
 * @author Steve
 *
 */
public class IDUtil {
	/**
	 * 获取一个32位长的唯一id
	 * @return 唯一id
	 */
	public static String getNewId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
