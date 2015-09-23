
package org.hy.commons.service.core ;

import java.util.List;
import java.util.Map;

import org.hy.commons.dao.core.exception.PersistentException;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;

//import com.hy.enterprise.framework.jpa.core.entity.Persistable;
//import com.hy.enterprise.framework.persistence.PersistentException;


/**
 * <ul>
 * <li>设计作者：</li>
 * <li>设计日期：2009-8-7</li>
 * <li>设计时间：下午10:52:19</li>
 * <li>设计目的：表现数据访问对象的接口<br>
 * < PersistentEntity extends Persistable >可以选择继承不同的Identifierable接口实现类<br>
 * 并实现Persistable借口
 * </li>
 * </ul>
 * <ul>
 * <b></b>
 * <li>1、</li>
 * </ul>
 * @param <X>
 * @param <Y>
 */
//public interface IDao < PersistentEntity extends Persistable >
//public interface IDao < PersistentEntity extends Persistable >
public interface IPlainService < PersistentEntity , X, Y >
{
	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:32:48</li>
	 * <li>设计目的：执行批量处理查询语句</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param isNamedQuery
	 * @param query
	 * @param values
	 * @return
	 */
	public Integer batchExecute (
	                              boolean isNamedQuery ,
	                              final String query ,
	                              final Object ... values ) throws PersistentException;

	//public EntityManagerFactory getEntityManagerFactory();
	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:08:36</li>
	 * <li>设计目的：获取持久化数据模型管理器</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	//public EntityManager getEntityManager ( ) ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:34:10</li>
	 * <li>设计目的：执行批量处理查询语句</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param isNamedQuery
	 * @param query
	 * @param values
	 * @return
	 */
	Integer batchExecute (
	                       boolean isNamedQuery ,
	                       final String query ,
	                       final Map < String , ? > values ) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:13:25</li>
	 * <li>设计目的：清楚持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 */
	void clear ( ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午10:58:28</li>
	 * <li>设计目的：根据指定持久化数据模型实例判断数据持久中是否包含该指定持久化数据模型实体</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEneities
	 * @return
	 * @throws PersistentException
	 */
	boolean contains (
	                   PersistentEntity persistentEneities )
	                                                        throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:07:53</li>
	 * <li>设计目的：判断数据持久中是否包含指定标识符的持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param identifier
	 * @return
	 * @throws PersistentException
	 */
	boolean containsById (
	                   X id )
	                                      throws PersistentException ;

	boolean containsByIdentifier(Y identifier) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:16:06</li>
	 * <li>设计目的：统计持久化数据模型的数量</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	Integer count ( ) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:11:15</li>
	 * <li>设计目的：通过查询语句或命名查询进行计数查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param query
	 * @param isNamedQuery
	 * @return
	 */
	Integer count (
	                String query ,
	                boolean isNamedQuery ) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:07:38</li>
	 * <li>设计目的：通过命名查询和命名参数Map进行计数查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param queryName
	 * @param parameters
	 * @return
	 */
	Integer countByNamedQuery (
	                            String queryName ,
	                            Map < String , ? > parameters ) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:06:27</li>
	 * <li>设计目的：通过命名查询和值参数数组进行计数查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param queryName
	 * @param parameters
	 * @return
	 */
	Integer countByNamedQuery (
	                            String queryName ,
	                            Object ... parameters ) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:07:38</li>
	 * <li>设计目的：通过查询语句和命名参数Map进行计数查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	Integer countByQuery (
	                       String query ,
	                       Map < String , ? > parameters ) throws PersistentException;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:06:27</li>
	 * <li>设计目的：通过查询语句和值参数数组进行计数查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	Integer countByQuery (
	                       String query ,
	                       Object ... parameters ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:10:33</li>
	 * <li>设计目的：获取所有持久化数据模型列表</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find ( )
	                                              throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:12:06</li>
	 * <li>设计目的：</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param first
	 * @param max
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             int first ,
	                                             int max )
	                                                      throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:28:14</li>
	 * <li>设计目的：使用指定查询语句和值参数数组进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param first
	 * @param max
	 * @param queryString
	 * @param values
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             int first ,
	                                             int max ,
	                                             String queryString ,
	                                             Object ... values )
	                                                                throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午10:59:39</li>
	 * <li>设计目的：使用指定查询语句进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             String queryString )
	                                                                 throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:26:10</li>
	 * <li>设计目的：使用指定查询语句进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param first
	 * @param max
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             String queryString ,
	                                             int first ,
	                                             int max )
	                                                      throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:19:21</li>
	 * <li>设计目的：使用指定语句和命名参数Map进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             String queryString ,
	                                             Map < String , ? > parameters )
	                                                                            throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:26:22</li>
	 * <li>设计目的：使用指定语句和命名参数Map进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param parameters
	 * @param first
	 * @param max
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             String queryString ,
	                                             Map < String , ? > parameters ,
	                                             int first ,
	                                             int max )
	                                                      throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:00:18</li>
	 * <li>设计目的：使用指定查询语句和值参数数组进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> find (
	                                             String queryString ,
	                                             Object ... parameters )
	                                                                    throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:56:09</li>
	 * <li>设计目的：通过范例的非空属性进行查询（忽略标识符属性）</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param exampleInstance
	 * @return
	 */
	List<PersistentEntity> findByExample (
	                                                      Object exampleInstance ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午11:16:13</li>
	 * <li>设计目的：通过范例的非空属性进行查询（忽略标识符属性）</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param exampleInstance
	 * @param excludeProperty
	 * @return
	 */
	List<PersistentEntity> findByExample (
			PersistentEntity exampleInstance ,
	                                                      String [ ] excludeProperty ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:10:05</li>
	 * <li>设计目的：根据指定持久化数据模型标识符判断数据持久中是否包含该指定持久化数据模型实体</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param identifier
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findByIdentifier (Y identifier )         throws PersistentException ;
	PersistentEntity  findById ( X id )throws PersistentException ;
	/*PersistentEntity findById (
            int id )
                               throws PersistentException ;*/

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:50:51</li>
	 * <li>设计目的：查询标识符存在于指定标识符数组中的实体</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param identifiers
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByIdentifier (
	                                                 String ... identifiers )
	                                                                         throws PersistentException ;
	
	 List < PersistentEntity > findById (
            X ... id )
                                    throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:00:38</li>
	 * <li>设计目的：使用指定查询语句和命名参数Map进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedParams (
	                                                          String queryString ,
	                                                          Map < String , ? > parameters )
	                                                                                         throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:26:43</li>
	 * <li>设计目的：使用指定查询语句和命名参数Map进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param parameters
	 * @param first
	 * @param max
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedParams (
	                                                          String queryString ,
	                                                          Map < String , ? > parameters ,
	                                                          int first ,
	                                                          int max )
	                                                                   throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:27:51</li>
	 * <li>设计目的：使用指定命名查询和值参数数组进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param first
	 * @param max
	 * @param queryName
	 * @param values
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedQuery (
	                                                         int first ,
	                                                         int max ,
	                                                         String queryName ,
	                                                         Object ... values )
	                                                                            throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:01:08</li>
	 * <li>设计目的：执行指定命名查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedQuery (
	                                                         String queryName )
	                                                                           throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:26:54</li>
	 * <li>设计目的：执行指定命名查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param first
	 * @param max
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedQuery (
	                                                         String queryName ,
	                                                         int first ,
	                                                         int max )
	                                                                  throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:01:24</li>
	 * <li>设计目的：使用指定命名查询和值参数数组进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param values
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedQuery (
	                                                         String queryName ,
	                                                         Object ... values )
	                                                                            throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:01:53</li>
	 * <li>设计目的：使用指定命名查询和命名参数Map进行查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedQueryAndNamedParams (
	                                                                       String queryName ,
	                                                                       Map < String , ? > parameters )
	                                                                                                      throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-18</li>
	 * <li>设计时间：下午01:51:25</li>
	 * <li>设计目的：使用指定命名查询和命名参数Map进行分页查询</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param parameters
	 * @param first
	 * @param max
	 * @return
	 * @throws PersistentException
	 */
	List<PersistentEntity> findByNamedQueryAndNamedParams (
	                                                                       String queryName ,
	                                                                       Map < String , ? > parameters ,
	                                                                       int first ,
	                                                                       int max )
	                                                                                throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午10:59:39</li>
	 * <li>设计目的：使用指定查询语句查询唯一结果</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResult (
	                                                String queryString )
	                                                                    throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:19:21</li>
	 * <li>设计目的：使用指定语句和命名参数Map查询唯一结果只</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResult (
	                                                String queryString ,
	                                                Map < String , ? > parameters )
	                                                                               throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:18:24</li>
	 * <li>设计目的：使用指定查询语句和值参数数组查询唯一结果</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryString
	 * @param values
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResult (
	                                                String queryString ,
	                                                Object ... values )
	                                                                   throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:00:38</li>
	 * <li>设计目的：使用指定查询语句和命名参数Map查询唯一结果</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResultByNamedParams (
	                                                             String queryName ,
	                                                             Map < String , ? > parameters )
	                                                                                            throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:01:08</li>
	 * <li>设计目的：执行指定命名查询得到唯一结果</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResultByNamedQuery (
	                                                            String queryName )
	                                                                              throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:01:24</li>
	 * <li>设计目的：使用指定命名查询和值参数数组查询唯一结果</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param values
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResultByNamedQuery (
	                                                            String queryName ,
	                                                            Object ... values )
	                                                                               throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:01:53</li>
	 * <li>设计目的：使用指定命名查询和命名参数Map查询唯一结果</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param queryName
	 * @param parameters
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity findUniqueResultByNamedQueryAndNamedParams (
	                                                                          String queryName ,
	                                                                          Map < String , ? > parameters )
	                                                                                                         throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:02:20</li>
	 * <li>设计目的：刷新持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @throws PersistentException
	 */
	void flush ( )
	              throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:54:50</li>
	 * <li>设计目的：刷新并清除持久化数据模型管理器</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 */
	void flushAndClear ( ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:17:01</li>
	 * <li>设计目的：获取持久化数据模型的类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	Class < PersistentEntity > getPersistentEneityClass ( ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:11:20</li>
	 * <li>设计目的：根据指定持久化实体类型和标识符获取持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param identifier
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity getReference (
	                                String identifier )
	                                                   throws PersistentException ;
	
	public Boolean isExists(PersistentEntity persistentEntity,String propertyName,Object propertyValue);


	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：上午12:36:26</li>
	 * <li>设计目的：判断对象的属性值在数据持久内是否唯一，在修改对象的情景下，如果属性新修改的值(value)等于属性原来的值(orgValue)
	 * 则不作比较。</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param propertyName
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	boolean isPropertyUnique (
	                           final String propertyName ,
	                           final Object newValue ,
	                           final Object oldValue ) throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:03:03</li>
	 * <li>设计目的：合并持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEntity
	 * @return
	 * @throws PersistentException
	 */
	PersistentEntity merge (
	                         PersistentEntity persistentEntity )
	                                                            throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:03:14</li>
	 * <li>设计目的：持久化指定持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEntity
	 * @throws PersistentException
	 */
	boolean persist (
	                  PersistentEntity persistentEntity )
	                                                     throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:06:16</li>
	 * <li>设计目的：持久化指定持久化数据模型数组</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEntities
	 * @return
	 * @throws PersistentException
	 */
	//Integer persists (
	 //                 PersistentEntity ... persistentEntities )
	 //                                                          throws PersistentException ;
	String [] persist (
	                  PersistentEntity ... persistentEntities )
	                                                           throws PersistentException ;
	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:03:27</li>
	 * <li>设计目的：对持久化模型进行刷新操作</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEntity
	 * @throws PersistentException
	 */
	void refresh (
	               PersistentEntity persistentEntity )
	                                                  throws PersistentException ;
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：级联删除persistentEntity(包括与其存在导航关系的实体对象)<br>
	 * 前提要求:要对实体类,设置cascade属性
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-2-9；时间：下午04:41:57</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param persistentEntity
	 * @throws PersistentException
	 * @return
	 */
	public void cascadeRemove (
            PersistentEntity persistentEntity )
                                               throws PersistentException ;
	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:03:42</li>
	 * <li>设计目的：移除指定持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEntity
	 * @throws PersistentException
	 */
	boolean remove (
	                 PersistentEntity persistentEntity )
	                                                    throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:05:31</li>
	 * <li>设计目的：移除指定持久化数据模型数组中的持久化实体</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param persistentEntities
	 * @return
	 * @throws PersistentException
	 */
	String[] remove (
	                 PersistentEntity ... persistentEntities )
	                                                          throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:04:11</li>
	 * <li>设计目的：移除指定标识符的持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param identifier
	 * @throws PersistentException
	 */
	boolean remove (
	                 String identifier )
	                                    throws PersistentException ;
	
	boolean removeById (
            X id )
                               throws PersistentException ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午11:04:33</li>
	 * <li>设计目的：移除指定标识符数组内的持久化数据模型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param identifiers
	 * @throws PersistentException
	 */
	Integer remove (
	                 String ... identifiers )
	                                         throws PersistentException ;

	String[] merge(PersistentEntity... persistentEntitys)
			throws PersistentException;
	


//	boolean submitPersistentEntities(MyBaseModel... persistentEntities);
//	boolean submitpersistentEntities(PersistentEntity... persistentEntities);

//	boolean submitPersistentEntities(List<MyBaseModel> persistentEntities);
}
