package org.hy.commons.service.core;

import java.util.List;
import java.util.Map;

import org.hy.commons.dao.core.exception.PersistentException;
import org.hy.commons.dao.core.util.Page;


public class BaseService<T>  implements IBaseService<T> {

	
	
	@Override
	public List<T> findPBySql(String sql, Class clazz, Boolean isEntity,
			Object... parameters) {
		return null;
	}

	@Override
	public Integer batchExecute(boolean isNamedQuery, String query,
			Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer batchExecute(boolean isNamedQuery, String query,
			Map<String, ?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T persistentEneities) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsById(Long id) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsByIdentifier(String identifier)
			throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count(String query, boolean isNamedQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByNamedQuery(String queryName, Map<String, ?> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByNamedQuery(String queryName, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByQuery(String query, Map<String, ?> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByQuery(String query, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find() throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(int first, int max) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(int first, int max, String queryString,
			Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String queryString) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String queryString, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String queryString, Map<String, ?> parameters)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String queryString, Map<String, ?> parameters,
			int first, int max) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String queryString, Object... parameters)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByExample(Object exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findByIdentifier(String identifier) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(Long id) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByIdentifier(String... identifiers)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findById(Long... id) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedParams(String queryString,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedParams(String queryString,
			Map<String, ?> parameters, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQuery(int first, int max, String queryName,
			Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQuery(String queryName)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQuery(String queryName, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... values)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQueryAndNamedParams(String queryName,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQueryAndNamedParams(String queryName,
			Map<String, ?> parameters, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResult(String queryString) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResult(String queryString, Map<String, ?> parameters)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResult(String queryString, Object... values)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResultByNamedParams(String queryName,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResultByNamedQuery(String queryName)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResultByNamedQuery(String queryName, Object... values)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findUniqueResultByNamedQueryAndNamedParams(String queryName,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flushAndClear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<T> getPersistentEneityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getReference(String identifier) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPropertyUnique(String propertyName, Object newValue,
			Object oldValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T merge(T persistentEntity) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean persist(T persistentEntity) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] persist(T... persistentEntities) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh(T persistentEntity) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeRemove(T persistentEntity) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(T persistentEntity) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] remove(T... persistentEntities) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String identifier) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(Long id) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer remove(String... identifiers) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] merge(T... persistentEntitys) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExists(T persistentEntity, String propertyName,
			Object propertyValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPage(String hql) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPage(String hql, Map<String, ?> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPage(String hql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPage(String hql, int offset, int max,
			Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPageByPageNo(String hql, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPageByPageNo(String hql, int pageNo,
			Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findPageByPageNo(String hql, int pageNo, int pageSize,
			Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
