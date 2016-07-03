//package org.konghao.basic.dao;
package org.hy.commons.dao.core;

import java.util.List;
import java.util.Map;

import org.hy.commons.dao.core.exception.PersistentException;
import org.hy.commons.dao.core.util.Page;




/**
 * 公共的DAO处理对象，这个对象中包含了Hibernate的所有基本操作和对SQL的操作
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDao<PersistentEntity> extends IPlainDao<PersistentEntity, Long, String>{
	
public List<PersistentEntity> findPBySql(String sql,Class clazz,Boolean isEntity, Object... parameters);

public Boolean isExists(PersistentEntity persistentEntity,
		String propertyName, Object propertyValue);

public Page<PersistentEntity> findPage(String hql)
		throws PersistentException;

public Page<PersistentEntity> findPage(String hql, Map<String, ?> parameters);

public Page<PersistentEntity> findPage(String hql, Object... parameters);

public Page<PersistentEntity> findPage(String hql, int offset, int max,
		Object... parameters);

public Page<PersistentEntity> findPageByPageNo(String hql, int pageNo);

public Page<PersistentEntity> findPageByPageNo(String hql, int pageNo,
		Object... parameters);

public Page<PersistentEntity> findPageByPageNo(String hql, int pageNo,
		int pageSize, Object... parameters);
}

