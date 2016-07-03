package org.hy.commons.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import com.extjs.gxt.ui.client.core.El;
import com.hy.mydesktop.client.component.meta.GridColumnConfigModel;
import com.hy.mydesktop.client.component.type.ComponentControllerEnum;
import com.hy.mydesktop.client.component.type.ComponentTypeEnum;
import com.hy.mydesktop.shared.business.DeaktopInitService;
import com.hy.mydesktop.shared.business.PositionTypeServices;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtAppEventType;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentControllerMetaModel;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentControllerMetaNodeModel;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentMetaNodeModel;
import com.hy.mydesktop.shared.persistence.domain.gxt.ItemOfAssociateToWindow;
import com.hy.mydesktop.shared.persistence.domain.gxt.constant.ComponentMetaDataConstants;
import com.hy.mydesktop.shared.persistence.domain.gxt.constant.MetaDataConstants;
import com.hy.mydesktop.shared.rpc.meta.GxtToSeamServiceParameter;

public class InitGxtSystemDatas222  {
	private static Log logger = LogFactory.getLog(InitGxtSystemDatas222.class);
	private String file;
	
	public GxtComponentControllerMetaModel createGxtComponentControllerMetaModelTemplateFile(GxtComponentControllerMetaModel gxtComponentControllerMetaModel) throws IOException {
		Document xmlDocument = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xxx");
		xmlDocument.setRootElement(root);
		//ComponentControllerEnum.DESKTOP_CONTROLLOR_MODEL.name()
		Element controllerMetaModel = root.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METAMODEL);
		Element controllerMetaNodeModels = controllerMetaModel.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL_LIST);
		Element controllerMetaNodeModel = controllerMetaNodeModels.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL)
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE,ComponentControllerEnum.DESKTOP_CONTROLLOR_MODEL.name())
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE_INDEX,Integer.toString(ComponentControllerEnum.DESKTOP_CONTROLLOR_MODEL.ordinal()))
				.addAttribute(MetaDataConstants.LEFT_VALUE, "1")
				.addAttribute(MetaDataConstants.RIGHT_VALUE, "4")
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_METANODEMODEL_ID, "desktopController");
		Element registerEventTypes = controllerMetaNodeModel.addElement(MetaDataConstants.APP_EVENT_TYPES);
		Element registerEventType = registerEventTypes.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0002");
		Element registerEventType2 = registerEventTypes.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0003");
		Element registerEventType3 = registerEventTypes.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0005");
		
		Element controllerMetaNodeModel2 = controllerMetaNodeModels.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL)
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE,ComponentControllerEnum.SHORTCUT_CONTROLLER_MODEL.name())
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE_INDEX,Integer.toString(ComponentControllerEnum.SHORTCUT_CONTROLLER_MODEL.ordinal()))
				.addAttribute(MetaDataConstants.LEFT_VALUE, "2")
				.addAttribute(MetaDataConstants.RIGHT_VALUE, "3")
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_METANODEMODEL_ID, "shortcutController01");
		Element registerEventTypes2 = controllerMetaNodeModel2.addElement(MetaDataConstants.APP_EVENT_TYPES);
		Element registerEventType_2 = registerEventTypes2.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0002");
		Element registerEventType2_2 = registerEventTypes2.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0003");
		Element registerEventType3_2 = registerEventTypes2.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0005");
		
		Element shortcutGxtComponentMetaNodeModel = controllerMetaNodeModel2.addElement(MetaDataConstants.GXT_COMPONENT__METANODEMODEL)
				.addAttribute(MetaDataConstants.COMPONENT_MODEL_TYPE,ComponentTypeEnum.SHORTCUT_MODEL.name())
				.addAttribute(MetaDataConstants.COMPONENT_MODEL_TYPE_INDEX,Integer.toString(ComponentTypeEnum.SHORTCUT_MODEL.ordinal()))
				;
		//Element shortcutComponentMetaNodeModel = 

		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("gxtMetaModel222.xml"),new OutputFormat("   ", true));
		xmlWriter.write(xmlDocument);
		XMLWriter consoleXmlWriter = new XMLWriter(new OutputFormat("   ", true));
		consoleXmlWriter.write(xmlDocument);
		return null;
	}
	
	
	
	public GxtComponentControllerMetaModel createGxtComponentControllerMetaModelTemplateFile() throws IOException {
		Document xmlDocument = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xxx");
		xmlDocument.setRootElement(root);
		//ComponentControllerEnum.DESKTOP_CONTROLLOR_MODEL.name()
		Element controllerMetaModel = root.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METAMODEL);
		Element controllerMetaNodeModels = controllerMetaModel.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL_LIST);
		Element controllerMetaNodeModel = controllerMetaNodeModels.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL)
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE,ComponentControllerEnum.DESKTOP_CONTROLLOR_MODEL.name())
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE_INDEX,Integer.toString(ComponentControllerEnum.DESKTOP_CONTROLLOR_MODEL.ordinal()))
				.addAttribute(MetaDataConstants.LEFT_VALUE, "1")
				.addAttribute(MetaDataConstants.RIGHT_VALUE, "4")
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_METANODEMODEL_ID, "desktopController");
		Element registerEventTypes = controllerMetaNodeModel.addElement(MetaDataConstants.APP_EVENT_TYPES);
		Element registerEventType = registerEventTypes.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0002");
		Element registerEventType2 = registerEventTypes.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0003");
		Element registerEventType3 = registerEventTypes.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0005");
		
		Element controllerMetaNodeModel2 = controllerMetaNodeModels.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL)
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE,ComponentControllerEnum.SHORTCUT_CONTROLLER_MODEL.name())
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE_INDEX,Integer.toString(ComponentControllerEnum.SHORTCUT_CONTROLLER_MODEL.ordinal()))
				.addAttribute(MetaDataConstants.LEFT_VALUE, "2")
				.addAttribute(MetaDataConstants.RIGHT_VALUE, "3")
				.addAttribute(MetaDataConstants.COMPONENT_CONTROLLER_METANODEMODEL_ID, "shortcutController01");
		Element registerEventTypes2 = controllerMetaNodeModel2.addElement(MetaDataConstants.APP_EVENT_TYPES);
		Element registerEventType_2 = registerEventTypes2.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0002");
		Element registerEventType2_2 = registerEventTypes2.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0003");
		Element registerEventType3_2 = registerEventTypes2.addElement(MetaDataConstants.APP_EVENT_TYPE).addAttribute(MetaDataConstants.APP_EVENT_TYPE_ID, "0005");
		
		Element shortcutGxtComponentMetaNodeModel = controllerMetaNodeModel2.addElement(MetaDataConstants.GXT_COMPONENT__METANODEMODEL)
				.addAttribute(MetaDataConstants.COMPONENT_MODEL_TYPE,ComponentTypeEnum.SHORTCUT_MODEL.name())
				.addAttribute(MetaDataConstants.COMPONENT_MODEL_TYPE_INDEX,Integer.toString(ComponentTypeEnum.SHORTCUT_MODEL.ordinal()))
				;
		//Element shortcutComponentMetaNodeModel = 

		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("gxtMetaModel222.xml"),new OutputFormat("   ", true));
		xmlWriter.write(xmlDocument);
		XMLWriter consoleXmlWriter = new XMLWriter(new OutputFormat("   ", true));
		consoleXmlWriter.write(xmlDocument);
		return null;
	}
	
	public List<GxtComponentControllerMetaModel> initGxtComponentControllerMetaModel() throws DocumentException {
		SAXReader reader = new SAXReader();
		//从项目，根目录，读取，名为xxx的xml文件
		String documentName= "gxtMetaModel.xml";
		Document xmlDocument = reader.read(documentName);
		logger.info("从项目，根目录，读取，名为"+documentName+"xxx的xml文件");
		Element root = xmlDocument.getRootElement();
//		Element controllerMetaModel = root.element(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METAMODEL);
		List<Element> controllerMetaModelElems = root.elements(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METAMODEL);
		GxtComponentControllerMetaModel gxtComponentControllerMetaModel = new GxtComponentControllerMetaModel();
		List<GxtComponentControllerMetaModel> gxtComponentControllerMetaModels = new LinkedList<GxtComponentControllerMetaModel>();
		for (Element controllerMetaModelElem : controllerMetaModelElems) {
		logger.info("创建一个List<GxtComponentControllerMetaModel>，即gxtComponentControllerMetaModels");
			if (controllerMetaModelElem!=null) {
				if (controllerMetaModelElem.attribute(MetaDataConstants.COMPONENT_CONTROLLER_METAMODEL_ID)!=null) {
					gxtComponentControllerMetaModel.setControllerMetaModelId(controllerMetaModelElem.attribute(MetaDataConstants.COMPONENT_CONTROLLER_METAMODEL_ID).getText());
				}
				logger.debug("gxtComponentControllerMetaModels，添加了gxtComponentControllerMetaModel(id="+gxtComponentControllerMetaModel.getControllerMetaModelId()+").");
				List<Element> controllerNMList = controllerMetaModelElem.element(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL_LIST)
					.elements(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL);
				for (Iterator iterator = controllerNMList.iterator(); iterator.hasNext();) {
					Element controllerElement = (Element) iterator.next();
					GxtComponentControllerMetaNodeModel controllerMetaNodeModel = new GxtComponentControllerMetaNodeModel();
					//controllerMetaNodeModel设置左值
					controllerMetaNodeModel.setLeftValue(
							Integer.parseInt(controllerElement.attribute(MetaDataConstants.LEFT_VALUE).getText()));
					//controllerMetaNodeModel.setComponentControllerEnum(
					//controllerElement.attribute(MetaDataConstants.COMPONENT_MODEL_TYPE).getText());
					controllerMetaNodeModel.setComponentControllerEnumIndex(
							Integer.parseInt(controllerElement.attribute(MetaDataConstants.COMPONENT_CONTROLLER_MODEL_TYPE_INDEX).getText()));
					//controllerMetaNodeModel设置右值
					controllerMetaNodeModel.setRightValue(
							Integer.parseInt(controllerElement.attribute(MetaDataConstants.RIGHT_VALUE).getText()));
					controllerMetaNodeModel.setControllerMetaNodeModelId(
							controllerElement.attribute(MetaDataConstants.COMPONENT_CONTROLLER_ID).getText());
					List<Element> registerEventTypeElements= controllerElement.element(MetaDataConstants.REGISTER_EVENT_TYPES).elements(MetaDataConstants.REGISTER_EVENT_TYPE);
					Set<GxtAppEventType> gxtAppEventTypes = new HashSet<GxtAppEventType>();
					for (Element element : registerEventTypeElements) {
						gxtAppEventTypes.add(new GxtAppEventType(element.attribute(MetaDataConstants.APP_EVENT_TYPE_ID).getText()));
					}
					controllerMetaNodeModel.setRegisterEventTypes(gxtAppEventTypes);
					
					Element componentElement = controllerElement.element(MetaDataConstants.GXT_COMPONENT__METANODEMODEL);
					if (componentElement==null) {
						logger.warn("gxtComponentControllerMetaNodeModel(MetaNodeModelId="+controllerMetaNodeModel.getControllerMetaNodeModelId()+"),"
								+"对应的ComponentMetaNodeModel为空！");
					}else {
						GxtComponentMetaNodeModel shortcutComponentMetaNodeModel = new GxtComponentMetaNodeModel();
						//componentElement.attribute(MetaDataConstants.COMPONENT_MODEL_TYPE);
						//shortcutComponentMetaNodeModel.setComponentTypeEnum(null);
						shortcutComponentMetaNodeModel.setComponentTypeEnumIndex(
								Integer.parseInt(componentElement.attribute(MetaDataConstants.COMPONENT_MODEL_TYPE_INDEX).getText()));
						//controllerMetaNodeModel设置componentMetaNodeModel
						controllerMetaNodeModel.setGxtComponentMetaNodeModel(shortcutComponentMetaNodeModel);
						System.err.println(controllerMetaNodeModel.getGxtComponentMetaNodeModel());
						logger.debug("gxtComponentControllerMetaNodeModel(MetaNodeModelId="+controllerMetaNodeModel.getControllerMetaNodeModelId()+"),"
								+"添加了ComponentMetaNodeModel(index="+controllerMetaNodeModel.getComponentControllerEnumIndex()+").");
					}
					gxtComponentControllerMetaModel.add(controllerMetaNodeModel);
					
					logger.debug("gxtComponentControllerMetaModel 添加了一个 gxtComponentControllerMetaNodeModel,其controllerMetaNodeModelId 是"
							+controllerMetaNodeModel.getControllerMetaNodeModelId());
				}
			}else {
				logger.warn("<gxtComponentControllerMetaModel> 为空！");
			}
			
			gxtComponentControllerMetaModels.add(gxtComponentControllerMetaModel);
			logger.info("添加了一个 gxtComponentControllerMetaModel,其List<gxtComponentControllerMetaNodeModel> 是"
					+gxtComponentControllerMetaModel.getList());
		}
		
		
		return  gxtComponentControllerMetaModels;
	}
	
	public static void main(String[] agrs) throws IOException, DocumentException {
//		GxtComponentControllerMetaModel controllerMetaModel = new PositonTypeServices().createDynamicWindowController();
		GxtComponentControllerMetaModel controllerMetaModel = new DeaktopInitService().createDynamicDesktopController3();

		new InitGxtSystemDatas222().printGxtComponentControllerMetaModelInfo(controllerMetaModel);
			//new InitGxtSystemDatas().initGxtComponentControllerMetaModel();
	}

	public static void printGxtComponentControllerMetaModelInfo(GxtComponentControllerMetaModel gxtComponentControllerMetaModel) throws IOException {
		logger.debug(gxtComponentControllerMetaModel);
		Document xmlDocument = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xxx");
		xmlDocument.setRootElement(root);
		//gxtComponentControllerMetaModel
		Element controllerMetaModel = root.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METAMODEL);
		//gxtComponentControllerMetaNodeModelList
		Element controllerMetaNodeModels = controllerMetaModel.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL_LIST);
		for (GxtComponentControllerMetaNodeModel gxtComponentControllerMetaNodeModel : gxtComponentControllerMetaModel.getList()) {
			printGxtComponentControllerMetaNodeModelInfo(controllerMetaNodeModels,gxtComponentControllerMetaNodeModel);
		}
			
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("gxtMetaModel222.xml"),new OutputFormat("     ", true));
		xmlWriter.write(xmlDocument);
		XMLWriter consoleXmlWriter = new XMLWriter(new OutputFormat("   ", true));
		consoleXmlWriter.write(xmlDocument);
	}
	
	
	private static void printGxtComponentControllerMetaNodeModelInfo(Element controllerMetaNodeModels,
			GxtComponentControllerMetaNodeModel gxtComponentControllerMetaNodeModel) {				
			
		logger.debug(gxtComponentControllerMetaNodeModel);
		Element controllerMetaNodeModelElem = controllerMetaNodeModels.addElement(MetaDataConstants.GXT_COMPONENT_CONTROLLER_METANODEMODEL);
		for (String propertyName : gxtComponentControllerMetaNodeModel.getPropertyNames()) {
			if (gxtComponentControllerMetaNodeModel.get(propertyName)!=null) {
				logger.debug("属性名称:"+propertyName+",属性值:"+gxtComponentControllerMetaNodeModel.get(propertyName));
				if (MetaDataConstants.GXT_COMPONENT__METANODEMODEL.equals(propertyName)) {
					GxtComponentMetaNodeModel gxtComponentMetaNodeModel=(GxtComponentMetaNodeModel)gxtComponentControllerMetaNodeModel.get(propertyName);
					if (gxtComponentMetaNodeModel!=null) {
						Element gxtComponentMetaNodeModelElem = controllerMetaNodeModelElem.addElement(MetaDataConstants.GXT_COMPONENT__METANODEMODEL);

						printGxtComponentMetaNodeModelInfo( gxtComponentMetaNodeModelElem,gxtComponentMetaNodeModel);
					}
				}else {
					controllerMetaNodeModelElem.addAttribute(propertyName, gxtComponentControllerMetaNodeModel.get(propertyName).toString());

				}
			}																	
						
		}
				
		
	}
	
	
	
	private static void printGxtComponentMetaNodeModelInfo(Element gxtComponentMetaNodeModelElem,GxtComponentMetaNodeModel gxtComponentMetaNodeModel) {
		logger.debug(gxtComponentMetaNodeModel);
		for (String propertyName : gxtComponentMetaNodeModel.getPropertyNames()) {
			if (gxtComponentMetaNodeModel.get(propertyName)!=null) {
				logger.debug("属性名称:"+propertyName+",属性值:"+gxtComponentMetaNodeModel.get(propertyName));
				//childrenItems
				if (ComponentMetaDataConstants.CHILDREN_ITEMS.equals(propertyName)) {
					if (gxtComponentMetaNodeModel.get(propertyName)!=null) {
						Element childrenItemsElem = gxtComponentMetaNodeModelElem.addElement(ComponentMetaDataConstants.CHILDREN_ITEMS);

						List<ItemOfAssociateToWindow> set =gxtComponentMetaNodeModel.get(propertyName);
						for (ItemOfAssociateToWindow itemOfAssociateToWindow : set) {
							logger.debug("********************************************************");
							Element itemOfAssociateToWindowElem = childrenItemsElem.addElement(ComponentMetaDataConstants.ITEM_OF_ASSOCIATETOWINDOW);

							printItemOfAssociateToWindowInfo(itemOfAssociateToWindowElem,itemOfAssociateToWindow);							
						}
					}
					
				}
				
				else if (ComponentMetaDataConstants.GRID_COLUMNCONFIG_MODELS.equals(propertyName)) {
					Element gridColumnConfigModelsElem = gxtComponentMetaNodeModelElem.addElement(ComponentMetaDataConstants.GRID_COLUMNCONFIG_MODELS);
					List<GridColumnConfigModel> set =gxtComponentMetaNodeModel.get(propertyName);
					for (GridColumnConfigModel gridColumnConfigModel : set) {
						Element gridColumnConfigModelElem = gridColumnConfigModelsElem.addElement(ComponentMetaDataConstants.GRID_COLUMNCONFIG_MODEL);

						for (String subpropertyName : gridColumnConfigModel.getPropertyNames()) {
							logger.debug("    gridColumnConfigModel属性名称:"+subpropertyName+",属性值:"+gridColumnConfigModel.get(subpropertyName));
							gridColumnConfigModelElem.addAttribute(subpropertyName, gridColumnConfigModel.get(subpropertyName).toString());

						}
					}
				}	
				else {
					gxtComponentMetaNodeModelElem.addAttribute(propertyName,gxtComponentMetaNodeModel.get(propertyName).toString());

				}
			}
			
						
		}
				
		
	}



	private static void printItemOfAssociateToWindowInfo(Element itemOfAssociateToWindowElem,
			ItemOfAssociateToWindow itemOfAssociateToWindow) {
		if (itemOfAssociateToWindow!=null) {
			
			for (String subpropertyName : itemOfAssociateToWindow.getPropertyNames()) {
				if (itemOfAssociateToWindow.get(subpropertyName)!=null) {
					logger.debug("    ItemOfAssociateToWindow属性名称:"+subpropertyName+",属性值:"+itemOfAssociateToWindow.get(subpropertyName));

					if (MetaDataConstants.GXT_TO_SEAM_SERVICEPARAMETER_MODEL.equals(subpropertyName)) {
						GxtToSeamServiceParameter gxtToSeamServiceParameter =itemOfAssociateToWindow.get(subpropertyName);
						if (gxtToSeamServiceParameter!=null) {
							Element gxtToSeamServiceParameterElem = itemOfAssociateToWindowElem.addElement(MetaDataConstants.GXT_TO_SEAM_SERVICEPARAMETER_MODEL);
							for (String subsubpropertyName : gxtToSeamServiceParameter.getPropertyNames()) {
								if (gxtToSeamServiceParameter.get(subsubpropertyName)!=null) {
									logger.debug("         GxtToSeamServiceParameter属性名称:"+subsubpropertyName+",属性值:"+gxtToSeamServiceParameter.get(subsubpropertyName));
									gxtToSeamServiceParameterElem.addAttribute(subsubpropertyName, gxtToSeamServiceParameter.get(subsubpropertyName).toString());
								}
								
							}
							
						}
					}					
					else if (MetaDataConstants.APP_EVENT_TYPE.equals(subpropertyName)) {
						GxtAppEventType gxtAppEventType =itemOfAssociateToWindow.get(subpropertyName);
						if (gxtAppEventType!=null) {	
							Element gxtAppEventTypeElem = itemOfAssociateToWindowElem.addElement(MetaDataConstants.APP_EVENT_TYPE);
							for (String subsubpropertyName : gxtAppEventType.getPropertyNames()) {
								if (gxtAppEventType.get(subsubpropertyName)!=null) {
									logger.debug("         GxtAppEventType属性名称:"+subsubpropertyName+",属性值:"+gxtAppEventType.get(subsubpropertyName));
									gxtAppEventTypeElem.addAttribute(subsubpropertyName, gxtAppEventType.get(subsubpropertyName).toString());
									
								}

							}						
							
						}
					}
					else if (ComponentMetaDataConstants.CHILDREN_ITEMS.equals(subpropertyName)) {
						List<ItemOfAssociateToWindow> list=itemOfAssociateToWindow.getChildrenItems();

						if (list!=null) {
							Element subchildrenItemsElem = itemOfAssociateToWindowElem.addElement(ComponentMetaDataConstants.CHILDREN_ITEMS);
							for (ItemOfAssociateToWindow subItem : list) {
								Element subitemElem = subchildrenItemsElem.addElement(ComponentMetaDataConstants.ITEM_OF_ASSOCIATETOWINDOW);

								printItemOfAssociateToWindowInfo(subitemElem,subItem);

							}						
							
													
							
						}
					}
					else {
						itemOfAssociateToWindowElem.addAttribute(subpropertyName, itemOfAssociateToWindow.get(subpropertyName).toString());
					}
				}
				
				
			}
		}
		
	}
	


	
	
	/*public void addOrUpdateInitDatas(String xmlFilePath){
		try {
			String filePath = null;
			if(xmlFilePath == null || xmlFilePath.trim().equals("")){
				filePath = file;
			}else{
				filePath = xmlFilePath;
			}

			//DOM4J使用示例
			Document document = new SAXReader().read(
				Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)
			);
			
			importModules( document.selectNodes("//Modules/Module") ,null);
			importRoleAndAcl(document.selectNodes("//Roles/Role"));
			importOrgAndPerson(document.selectNodes("//Organizations/Org"),null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("初始化数据生成有误！");
		}
	}

	
	//导入模块信息
	protected void importModules(List modules,Module parent){
		
		for (Iterator iter = modules.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Module module = new Module();
			module.setName(element.attributeValue("name"));
			module.setSn(element.attributeValue("sn"));
			module.setUrl(element.attributeValue("url"));
			module.setOrderNo(Integer.parseInt(element.attributeValue("orderNo")));
			module.setParent(parent);
			getHibernateTemplate().save(module);
			logger.info("导入模块【"+module.getName()+"】");
			importModules( element.selectNodes("Module") , module);
		}
	}
	
	protected void importRoleAndAcl(List roles){
		for (Iterator iter = roles.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Role role = new Role();
			role.setName(element.attributeValue("name"));
			getHibernateTemplate().save(role);
			
			//给角色授权
			List acls = element.selectNodes("Acl");
			for (Iterator iterator = acls.iterator(); iterator.hasNext();) {
				Element aclElem = (Element) iterator.next();
				Integer moduleId = 
					(Integer)getSession()
					.createQuery("select m.id from Module m where m.name = ?")
					.setParameter(0, aclElem.attributeValue("module"))
					.uniqueResult();
				ACL acl = new ACL();
				acl.setPrincipalType(ACL.TYPE_ROLE);
				acl.setPrincipalId(role.getId());
				acl.setModuleId(moduleId);
				if("true".equals(aclElem.attributeValue("C"))){
					acl.setPermission(Permission.CREATE, true);
				}
				if("true".equals(aclElem.attributeValue("R"))){
					acl.setPermission(Permission.READ, true);
				}
				if("true".equals(aclElem.attributeValue("U"))){
					acl.setPermission(Permission.UPDATE, true);
				}
				if("true".equals(aclElem.attributeValue("D"))){
					acl.setPermission(Permission.DELETE, true);
				}
				getHibernateTemplate().save(acl);
			}
		}
	}
	
	protected void importOrgAndPerson(List orgs,Organization parent){
		for (Iterator iter = orgs.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Organization org = new Organization();
			org.setName(element.attributeValue("name"));
			orgManager.addOrg(org, parent == null?0:parent.getId());
			
			//查找机构下的人员信息，并初始化
			List persons = element.selectNodes("Person");
			for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
				Element personElem = (Element) iterator.next();
				Person person = new Person();
				person.setName(personElem.attributeValue("name"));
				person.setOrg(org);
				getHibernateTemplate().save(person);
				
				//给人员分配登陆帐号
				User user = new User();
				user.setUsername(personElem.attributeValue("username"));
				user.setPassword(personElem.attributeValue("password"));
				user.setPerson(person);
				getHibernateTemplate().save(user);
				
				//给用户分配角色
				String roles = personElem.attributeValue("roles");
				String[] roleNames = roles.split(",");
				for(int i=0; i<roleNames.length; i++){
					int roleId = 
						(Integer)getSession()
						.createQuery("select r.id from Role r where r.name = ?")
						.setParameter(0, roleNames[i])
						.uniqueResult();
					userManager.addOrUpdateUserRole(user.getId(), roleId, i+1);
				}
			}
			
			//初始化此机构下的子机构信息
			importOrgAndPerson( element.selectNodes("Org") , org);
		}
	}
	
	
	public void setFile(String file) {
		this.file = file;
	}


	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}*/

}
