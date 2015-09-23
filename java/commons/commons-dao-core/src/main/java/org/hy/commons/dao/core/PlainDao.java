package org.hy.commons.dao.core;

import java.util.List;
import java.util.Map;

import org.hy.commons.dao.core.exception.PersistentException;


public class PlainDao<PersistentEntity, X, Y> implements IPlainDao<PersistentEntity, X, Y>{

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
	public boolean contains(PersistentEntity persistentEneities)
			throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsById(X id) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsByIdentifier(Y identifier)
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
	public List<PersistentEntity> find() throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(int first, int max, String queryString,
			Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(String queryString)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(String queryString, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(String queryString,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(String queryString,
			Map<String, ?> parameters, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> find(String queryString, Object... parameters)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByExample(Object exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByExample(
			PersistentEntity exampleInstance, String[] excludeProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findByIdentifier(Y identifier)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findById(X id) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByIdentifier(String... identifiers)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findById(X... id) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedParams(String queryString,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedParams(String queryString,
			Map<String, ?> parameters, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedQuery(int first, int max,
			String queryName, Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedQuery(String queryName)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedQuery(String queryName, int first,
			int max) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedQuery(String queryName,
			Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedQueryAndNamedParams(
			String queryName, Map<String, ?> parameters)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersistentEntity> findByNamedQueryAndNamedParams(
			String queryName, Map<String, ?> parameters, int first, int max)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResult(String queryString)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResult(String queryString,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResult(String queryString,
			Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResultByNamedParams(String queryName,
			Map<String, ?> parameters) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResultByNamedQuery(String queryName)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResultByNamedQuery(String queryName,
			Object... values) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity findUniqueResultByNamedQueryAndNamedParams(
			String queryName, Map<String, ?> parameters)
			throws PersistentException {
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
	public Class<PersistentEntity> getPersistentEneityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentEntity getReference(String identifier)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExists(PersistentEntity persistentEntity,
			String propertyName, Object propertyValue) {
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
	public PersistentEntity merge(PersistentEntity persistentEntity)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean persist(PersistentEntity persistentEntity)
			throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] persist(PersistentEntity... persistentEntities)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh(PersistentEntity persistentEntity)
			throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cascadeRemove(PersistentEntity persistentEntity)
			throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(PersistentEntity persistentEntity)
			throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] remove(PersistentEntity... persistentEntities)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String identifier) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(X id) throws PersistentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer remove(String... identifiers) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] merge(PersistentEntity... persistentEntitys)
			throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

}
