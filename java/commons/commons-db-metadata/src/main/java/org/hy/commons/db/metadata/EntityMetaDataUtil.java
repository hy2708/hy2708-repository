package org.hy.commons.db.metadata;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.BeanUtil;
import org.hy.commons.lang.ClassUtil;
import org.hy.commons.lang.EntityBeanUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.hy.commons.lang.string.StringUtil;






public class EntityMetaDataUtil {


	@Deprecated
	/**
	 *  请使用 # getPropertiesFromEntity(Class)
	 */
	public static Map<String,Object> getPropertiesFromEntity(Class clazz,Boolean isConnectDatabase){
		return getPropertiesFromEntity(clazz, isConnectDatabase, null);
	}
	
	public static Map<String,Object> getPropertiesFromEntity(Class clazz){
		return getPropertiesFromEntity(clazz, false ,null);
	}
	
	public static Map<String,Object> getPropertiesFromEntity(Class clazz,DataSource dataSource){
		return getPropertiesFromEntity(clazz, true ,dataSource);
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：
	 * <OL>
	 *  <LI/><B>targetProjectName</B>String
		<LI/><B>targetProjectPath</B>String
		targetProjectClassPath</B>
		params.put("entityJavaFileDirPath", entityJavaFileDirPath);
		params.put("entityClassFileDirPath", entityClassFileDirPath);
		params.put("entityJavaFilePath", entityJavaFilePath);
		params.put("entityFullName", entityFullName);
		params.put("entityName", entityName);
		params.put("entity", entity);
		<LI/><B>entityBasePropertyNames</B> List<'String'>
		<LI/><B>entityBasePropertyNamesAndTypes</B> Map<'String,Class'>

		<LI/><B>entityObjetPropertyNames</B> List<'Map'> keys=>(entityName,entityClassName,propertyNames)
		<LI/><B>entityCollectionPropertyNames)</B> List<'String'>
		params.put("entityCollectionPropertyNames", entityCollectionPropertyNames);		
		params.put("entityPropertyNames", entityPropertyNames);
		params.put("stringOfentityPropertyNames", stringOfentityPropertyNames);
		<LI/><B>"tableName"</B> String
     *	<LI><B>TABLE_NAME</B> String => table name
     *	<LI><B>TABLE_TYPE</B> String => table type.  Typical types are "TABLE",
     *			"VIEW",	"SYSTEM TABLE", "GLOBAL TEMPORARY", 
     *			"LOCAL TEMPORARY", "ALIAS", "SYNONYM".
     *	<LI><B>REMARKS</B> String => explanatory comment on the table
     *  <LI><B>TYPE_CAT</B> String => the types catalog (may be <code>null</code>)
     *  <LI><B>TYPE_SCHEM</B> String => the types schema (may be <code>null</code>)
     *  <LI><B>TYPE_NAME</B> String => type name (may be <code>null</code>)
     *  <LI><B>SELF_REFERENCING_COL_NAME</B> String => name of the designated 
     *                  "identifier" column of a typed table (may be <code>null</code>)
     *	<LI><B>REF_GENERATION</B> String => specifies how values in 
     *                  SELF_REFERENCING_COL_NAME are created. Values are
     *                  "SYSTEM", "USER", "DERIVED". (may be <code>null</code>)	
     *  </OL>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-8-23；时间：下午5:43:01</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param clazz
	 * @param isConnectDatabase
	 * @param dataSource
	 * @return
	 */
	public static Map<String,Object> getPropertiesFromEntity(Class clazz,Boolean isConnectDatabase,DataSource dataSource){
		String ENTITY_FULL_NAME ="entityFullName";
		String dirSeparator =ProjectPathUtil.dirSeparator;
		Map params = new HashMap();
		//目标项目名称
		String targetProjectName = ProjectPathUtil.getProjectName(clazz);
		//目标项目路径
		String targetProjectPath = ProjectPathUtil.getProjectPath(clazz);
		//def targetProjectResourcesDirPath = ProjectPathUtil.getProjectResourcesDirPath(clazz);
//		String targetProjectClassPath = ProjectPathUtil.getProjectClassPath(clazz, targetProjectName);
		String targetProjectClassPath = ProjectPathUtil.getProjectClassPath(clazz, targetProjectName);
		//class对应的java所在的文件夹路径
		String javaFileDirOfClass = ProjectPathUtil.getJavaFileDir(clazz);
		//类名称
		String targetClassName = clazz.getName();
		//实体类的完整类名
		String entityFullName = clazz.getName();
		//实体类的类名
		String entityName = clazz.getSimpleName();
		//实体类的变量名称(首字母小写)
		String entity = entityName.substring(0, 1).toLowerCase()+entityName.substring(1);
		//实体类的所有属性名称
		List<String> entityPropertyNames = EntityBeanUtil.getEntityPropertyNames(clazz);
		//实体类的属性，拼装成字符串
		String stringOfentityPropertyNames = StringUtil.toString(entityPropertyNames);
		//实体类的基础属性的名称
		List<String>  entityBasePropertyNames = EntityBeanUtil.getBasePropertyNamesOfEntity(clazz);
		Map<String,Class>  entityBasePropertyNamesAndTypes = EntityBeanUtil.getBasePropertyNamesAndTypesOfEntity(clazz);
		//实体类的对象类型，属性的名称
		List<Class>  _entityObjetPropertyNames = EntityBeanUtil.getObjectPropertyNamesOfEntity(clazz);
		//System.err.println("qqqqqqqqqqq"+_entityObjetPropertyNames.size());
		List<Map<String,Object>> entityObjetPropertyNames = new LinkedList<Map<String,Object>>();
		for (int i = 0; i < _entityObjetPropertyNames.size(); i++) {
			Map<String,Object> map =	new HashMap<String,Object>();
			List<String> subentityPropertyNames = EntityBeanUtil.getEntityPropertyNames(_entityObjetPropertyNames.get(i));
			String subentity = _entityObjetPropertyNames.get(i).getSimpleName().substring(0, 1).toLowerCase()+
				_entityObjetPropertyNames.get(i).getSimpleName().substring(1).toLowerCase();
			map.put("entityName", subentity);
			map.put("entityClassName", _entityObjetPropertyNames.get(i).getName());
			map.put("propertyNames", subentityPropertyNames);
			map.put("stringOfTableColumnNames", "*");
			if (isConnectDatabase) {			
				//DataSource dataSource = new DataSourceUtil().getDataSource();			
				List<String> tableColumnNames= DBMetaDataUtil.getInstance(dataSource).getTableColumnNames("t_"+subentity);
				String stringOfTableColumnNames = StringUtil.toString(tableColumnNames);
				map.put("stringOfTableColumnNames", stringOfTableColumnNames);
			}
			entityObjetPropertyNames.add(map);
		}
		//实体类的集合类型，属性的名称
		List<Class> _entityCollectionPropertyNames = EntityBeanUtil.getCollectionPropertyNamesOfEntity(clazz);
		Map<String,Class> _entityCollectionPropertyNames2 = (Map<String,Class>)EntityBeanUtil.getCollectionPropertyNamesAndTypesOfEntity(clazz);
		List<Map<String,Object>> entityCollectionPropertyNames =new LinkedList<Map<String,Object>>();;
		for (int i = 0; i < _entityCollectionPropertyNames.size(); i++) {
		//for (String propertyName:_entityCollectionPropertyNames2.keySet()) {
			Map<String,Object> map =	new HashMap<String,Object>();
			List<String> subentityPropertyNames = EntityBeanUtil.getEntityPropertyNames(_entityCollectionPropertyNames.get(i));
			String subentity = _entityCollectionPropertyNames.get(i).getSimpleName().substring(0, 1).toLowerCase()+
				_entityCollectionPropertyNames.get(i).getSimpleName().substring(1).toLowerCase();
			map.put("entityName", subentity);
			map.put("propertyName", subentity);					
			for (String string : _entityCollectionPropertyNames2.keySet()) {
				if (string.toLowerCase().startsWith(subentity.toLowerCase())
						&&_entityCollectionPropertyNames2.get(string).equals(_entityCollectionPropertyNames.get(i))
						) {
					map.put("propertyName", string);					
				}
			}
			map.put("entityClassName", _entityCollectionPropertyNames.get(i).getName());
			map.put("propertyNames", subentityPropertyNames);
			map.put("stringOfTableColumnNames", "*");
			if (isConnectDatabase) {			
				//DataSource dataSource = new DataSourceUtil().getDataSource();			
				List<String> tableColumnNames= DBMetaDataUtil.getInstance(dataSource).getTableColumnNames("t_"+subentity);
				String stringOfTableColumnNames = StringUtil.toString(tableColumnNames);
				map.put("stringOfTableColumnNames", stringOfTableColumnNames);
			}
			//map.put("entityRelation", null);
			
			parseEntityRelation(entityName, entity, _entityCollectionPropertyNames.get(i), map);
			
			entityCollectionPropertyNames.add(map);
		}
		
		
		String entityJavaFileDirPath = ProjectPathUtil.getJavaFileDir(clazz);
		String entityClassFileDirPath = ProjectPathUtil.getClassFileDirInProject(clazz);
		
		String entityJavaFilePath = ProjectPathUtil.getJavaFilePath(clazz);
		
		//实体类对应的表名
		String tableName = "t_"+entityName;
		//实体类的属性，拼装成字符串
		String stringOfTableColumnNames = " * ";
		if (isConnectDatabase) {			
			//DataSource dataSource = new DataSourceUtil().getDataSource();			
			List<String> tableColumnNames= DBMetaDataUtil.getInstance(dataSource).getTableColumnNames(tableName);
			stringOfTableColumnNames = StringUtil.toString(tableColumnNames);
		}
				
		String templateDirPath = ProjectPathUtil.getProjectResourcesDirPath()+dirSeparator+"template";
		//def entityTemplateFilePath = templateDirPath+dirSeparator+"Entity.xml";
		//def resultInResultMapTemplateFilePath = templateDirPath+dirSeparator+"ResultInResultMap.xml";
		
		FileUtil.createFile(templateDirPath);
		//def entitiesDir = IoUtil.getJavaFileDir(Cat.class);
		
		params.put("#", "#");
		params.put("targetProjectName", targetProjectName);
		params.put("targetProjectPath", targetProjectPath);
		params.put("targetProjectClassPath", targetProjectClassPath);
		params.put("entityJavaFileDirPath", entityJavaFileDirPath);
		params.put("entityClassFileDirPath", entityClassFileDirPath);
		params.put("entityJavaFilePath", entityJavaFilePath);
		params.put("entityFullName", entityFullName);
		params.put("entityName", entityName);
		params.put("entity", entity);
		params.put("entityBasePropertyNames", entityBasePropertyNames);
		params.put("entityBasePropertyNamesAndTypes", entityBasePropertyNamesAndTypes);
		params.put("_entityObjetPropertyNames", _entityObjetPropertyNames);
		params.put("entityObjetPropertyNames", entityObjetPropertyNames);
		params.put("_entityCollectionPropertyNames", _entityCollectionPropertyNames);
		params.put("entityCollectionPropertyNames", entityCollectionPropertyNames);
		
		params.put("entityPropertyNames", entityPropertyNames);
		params.put("stringOfentityPropertyNames", stringOfentityPropertyNames);
		//params.put("targetProjectResourcesDirPath", targetProjectResourcesDirPath);
		params.put("tableName", tableName);
		params.put("stringOfTableColumnNames", stringOfTableColumnNames);
		params.put("templateDirPath", templateDirPath);
		//params.put("entityTemplateFilePath", entityTemplateFilePath);
		//params.put("resultInResultMapTemplateFilePath", resultInResultMapTemplateFilePath);
		
		//def list = IoUtil.findFiles(projectPath, "Cat.java")
		
		
		return params;
		
	}
	
	
	public static void parseEntityRelation(String entityName,String entity,Class _entityCollectionPropertyName,Map map) {
		String ENTITY_RELATION = "entityRelation";
		String ENTITY_RELATION_ONE_TO_MANY = "oneToMany";
		String ENTITY_RELATION_MANY_TO_MANY = "manyToMany";
		String ENTITY_RELATION_DIRECTION = "entityRelationDirection";
		String ENTITY_RELATION_DIRECTION_SINGLE = "single";
		String ENTITY_RELATION_DIRECTION_DOUBLE = "double";
		try {
			if (BeanUtil.hasProperty(_entityCollectionPropertyName.newInstance(), entity)) {
				Class class1 =ReflectionUtil.getDeclaredMethodReturnType(_entityCollectionPropertyName, "get"+entityName);
				if (ClassUtil.isCollectionDataType(class1)) {						
					map.put(ENTITY_RELATION, ENTITY_RELATION_MANY_TO_MANY);					
				}else {						
					map.put(ENTITY_RELATION, ENTITY_RELATION_ONE_TO_MANY);					
				}
				map.put(ENTITY_RELATION_DIRECTION,  ENTITY_RELATION_DIRECTION_DOUBLE);					
									
			}
			else if (BeanUtil.hasProperty(_entityCollectionPropertyName.newInstance(), entity+"s")) {
				Class class1 =ReflectionUtil.getDeclaredMethodReturnType(_entityCollectionPropertyName, "get"+entityName+"s");
				if (ClassUtil.isCollectionDataType(class1)) {						
					map.put(ENTITY_RELATION, ENTITY_RELATION_MANY_TO_MANY);					
				}else {						
					map.put(ENTITY_RELATION, ENTITY_RELATION_ONE_TO_MANY);					
				}
				map.put(ENTITY_RELATION_DIRECTION,  ENTITY_RELATION_DIRECTION_DOUBLE);									
									
			}else if (BeanUtil.hasProperty(_entityCollectionPropertyName.newInstance(), entity+"es")) {
				Class class1 =ReflectionUtil.getDeclaredMethodReturnType(_entityCollectionPropertyName, "get"+entityName+"es");
				if (ClassUtil.isCollectionDataType(class1)) {						
					map.put(ENTITY_RELATION, ENTITY_RELATION_MANY_TO_MANY);					
				}else {						
					map.put(ENTITY_RELATION, ENTITY_RELATION_ONE_TO_MANY);					
				}
				map.put(ENTITY_RELATION_DIRECTION,  ENTITY_RELATION_DIRECTION_DOUBLE);									
									
			}else {
				
				map.put(ENTITY_RELATION, ENTITY_RELATION_ONE_TO_MANY);					
				map.put(ENTITY_RELATION_DIRECTION,  ENTITY_RELATION_DIRECTION_SINGLE);		
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		//System.err.println("99999999999"+map.get(ENTITY_RELATION));

	}
	
	

}
