package com.hm.entity.common;

import java.io.Serializable;

/**
 * mybatis公共基础类，配置typeAliasesSuperType后，所有继承该类的实体类都可以自动映射，无需再写resultMap
 * 
 * @author limiao
 *
 * @param <T>
 */
public abstract class BaseEntity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
