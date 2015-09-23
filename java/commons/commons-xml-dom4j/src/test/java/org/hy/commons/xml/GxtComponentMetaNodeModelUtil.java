package org.hy.commons.xml;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hy.enterprise.framework.util.lang.UUIDUtil;
import com.hy.mydesktop.client.component.meta.GridColumnConfigModel;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtAppEventType;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentMetaNodeModel;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentMetaNodePorperty;
import com.hy.mydesktop.shared.persistence.domain.gxt.ItemOfAssociateToWindow;
import com.hy.mydesktop.shared.persistence.domain.gxt.constant.MetaDataConstants;
import com.hy.mydesktop.shared.persistence.domain.gxt.constant.ComponentMetaDataConstants;
import com.hy.mydesktop.shared.rpc.meta.GxtToSeamServiceParameter;

/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2012-2-7；时间：下午01:05:50</li>
 * <li>类型名称：GxtComponentMetaNodeModelUtil</li>
 * <li>设计目的：</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class GxtComponentMetaNodeModelUtil {

	private static Log logger = LogFactory.getLog(GxtComponentMetaNodeModelUtil.class);

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-2-7；时间：下午01:06:01</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param gxtComponentMetaNodeModel
	 * @return
	 * @return
	 */
	public static GxtComponentMetaNodeModel reconfigureGxtComponentMetaNodeModelFromJpa(
			GxtComponentMetaNodeModel gxtComponentMetaNodeModel) {
		Set<GxtComponentMetaNodePorperty> set =gxtComponentMetaNodeModel.getComponentProperties();
		if (set!=null) {
			
			for (GxtComponentMetaNodePorperty gxtComponentMetaNodePorperty : set) {
				String propertyName = gxtComponentMetaNodePorperty.getPropertyName();
				String propertyValue = gxtComponentMetaNodePorperty.getPropertyValue();
				gxtComponentMetaNodeModel.set(propertyName, propertyValue);
			}
			
			//gxtComponentMetaNodeModel.setComponentProperties(null);
		}
		
		return gxtComponentMetaNodeModel;
	}
	
	
	public static List<GxtComponentMetaNodeModel> reconfigureGxtComponentMetaNodeModelsFromJpa(
			List<GxtComponentMetaNodeModel> list) {
		List<GxtComponentMetaNodeModel> newList=new LinkedList<GxtComponentMetaNodeModel>();
		
		for (GxtComponentMetaNodeModel gxtComponentMetaNodeModel : list) {
			
			GxtComponentMetaNodeModelUtil.reconfigureGxtComponentMetaNodeModelFromJpa(gxtComponentMetaNodeModel);
			newList.add(gxtComponentMetaNodeModel);
		}
		
		
		return newList;
	}

	
	
	public static GxtComponentMetaNodeModel reConstructGxtComponentMetaNodeModel(
			GxtComponentMetaNodeModel gxtComponentMetaNodeModel) {
		
		if (gxtComponentMetaNodeModel.getChildrenItems()!=null) {
//			if (gxtComponentMetaNodeModel.getItemOfAssociateToWindows()!=null) {
			
			for (ItemOfAssociateToWindow itemOfAssociateToWindow : gxtComponentMetaNodeModel.getChildrenItems()) {
				reConstructItemOfAssociateToWindow(itemOfAssociateToWindow);
			}
		};
		Set<GxtComponentMetaNodePorperty> set =gxtComponentMetaNodeModel.getComponentProperties();
		GxtComponentMetaNodePorperty gxtComponentMetaNodePorperty=null;
		if (set==null) {
			set = new HashSet<GxtComponentMetaNodePorperty>();
		
		}
		
		for (String  baseModelPropertyName: gxtComponentMetaNodeModel.getPropertyNames()) {
			if (isDirectProperty(baseModelPropertyName)){
				;
			}else {
				if (gxtComponentMetaNodeModel.get(baseModelPropertyName)!=null&&(!baseModelPropertyName.equals(null))) {
					gxtComponentMetaNodePorperty=new GxtComponentMetaNodePorperty();
					gxtComponentMetaNodePorperty.setPropertyName(baseModelPropertyName);
					gxtComponentMetaNodePorperty.setPropertyValue(gxtComponentMetaNodeModel.get(baseModelPropertyName).toString());
					gxtComponentMetaNodePorperty.setIdentifier(UUIDUtil.randomUUID());
					
					set.add(gxtComponentMetaNodePorperty);
				}
				
			}
		}
						
		gxtComponentMetaNodeModel.setComponentProperties(set);
		return gxtComponentMetaNodeModel;
	}
	
	
	private static void reConstructItemOfAssociateToWindow(ItemOfAssociateToWindow itemOfAssociateToWindow){
		if (itemOfAssociateToWindow!=null) {
			if (itemOfAssociateToWindow.getIdentifier()==null) {
				
				itemOfAssociateToWindow.setIdentifier(UUIDUtil.randomUUID());
			}
			
			if (itemOfAssociateToWindow.getRegisterEventType()!=null) {
				if (itemOfAssociateToWindow.getRegisterEventType().getIdentifier()==null) {
					
					itemOfAssociateToWindow.getRegisterEventType().setIdentifier(UUIDUtil.randomUUID());
				}
			}
			
	//		itemOfAssociateToWindow.setGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
			if (itemOfAssociateToWindow.getEventStructureMetaModel()!=null) {
				itemOfAssociateToWindow.getEventStructureMetaModel().setIdentifier(UUIDUtil.randomUUID());
				
			}
			
			if (itemOfAssociateToWindow.getGxtToSeamServiceParameter()!=null) {
				
				itemOfAssociateToWindow.getGxtToSeamServiceParameter().setIdentifier(UUIDUtil.randomUUID());
			}
			
			if (itemOfAssociateToWindow.getChildrenItems()!=null) {
				for (ItemOfAssociateToWindow subItem : itemOfAssociateToWindow.getChildrenItems()) {
					reConstructItemOfAssociateToWindow(subItem);
				}
			}
			
			

		}
	}
	
	public static List<GxtComponentMetaNodeModel> reConstructGxtComponentMetaNodeModels(
			List<GxtComponentMetaNodeModel> list) {
		List<GxtComponentMetaNodeModel> newList=new LinkedList<GxtComponentMetaNodeModel>();
		
		for (GxtComponentMetaNodeModel gxtComponentMetaNodeModel : list) {
			
			GxtComponentMetaNodeModelUtil.reConstructGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
			newList.add(gxtComponentMetaNodeModel);
		}
		
		
		return newList;
	}
	
	public static GxtComponentMetaNodeModel[] reConstructGxtComponentMetaNodeModels(
			GxtComponentMetaNodeModel... gxtComponentMetaNodeModels) {
		
		GxtComponentMetaNodeModel[] newList=new GxtComponentMetaNodeModel[gxtComponentMetaNodeModels.length];
		Integer count = new Integer(0);

		for (GxtComponentMetaNodeModel gxtComponentMetaNodeModel : gxtComponentMetaNodeModels) {
			
			GxtComponentMetaNodeModelUtil.reConstructGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
			newList[count++]=gxtComponentMetaNodeModel;
		}
		
		
		return newList;
	}
	
		
	
	
	
	private static boolean isDirectProperty(String baseModelPropertyName) {
		if (MetaDataConstants.ID.equals(baseModelPropertyName)) {
			return true;
		} else if (MetaDataConstants.IDENTIFIER.equals(baseModelPropertyName)) {
			return true;

		} else if (MetaDataConstants.TEXT.equals(baseModelPropertyName)) {
			return true;

		} else if (MetaDataConstants.LEFT_VALUE.equals(baseModelPropertyName)) {
			return true;

		} else if (MetaDataConstants.RIGHT_VALUE.equals(baseModelPropertyName)) {
			return true;

		} else if (MetaDataConstants.COMPONENT_MODEL_TYPE.equals(baseModelPropertyName)) {
			return true;

		} else if (MetaDataConstants.COMPONENT_MODEL_TYPE_INDEX.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.WIDTH.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.HEIGHT.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.TITLE.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.RESIZABLE.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.MAXMIZABLE.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.MINMIZABLE.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.LAYOUT.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.LAYOUT_INDEX.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.CHILDREN_ITEMS.equals(baseModelPropertyName)) {
			return true;

		}  else if (ComponentMetaDataConstants.CHILDREN_ITEMS_TYPE.equals(baseModelPropertyName)) {
			return true;

		} else if (ComponentMetaDataConstants.GRID_COLUMNCONFIG_MODELS.equals(baseModelPropertyName)) {
			return true;

		} else {
			return false;
		}
		
	}


	public static void printGxtComponentMetaNodeModelInfo(GxtComponentMetaNodeModel baseModel) {
		logger.debug(baseModel);
		for (String propertyName : baseModel.getPropertyNames()) {
			logger.debug("GxtComponentMetaNodeModel属性名称:"+propertyName+",属性值:"+baseModel.get(propertyName));
			
			if (ComponentMetaDataConstants.CHILDREN_ITEMS.equals(propertyName)) {
				List<ItemOfAssociateToWindow> set =baseModel.get(propertyName);
				for (ItemOfAssociateToWindow itemOfAssociateToWindow : set) {
					printItemOfAssociateToWindowInf(itemOfAssociateToWindow);
				}
			}
			
			if (ComponentMetaDataConstants.GRID_COLUMNCONFIG_MODELS.equals(propertyName)) {
				List<GridColumnConfigModel> set =baseModel.get(propertyName);
				for (GridColumnConfigModel gridColumnConfigModel : set) {
					for (String subpropertyName : gridColumnConfigModel.getPropertyNames()) {
						logger.debug("    gridColumnConfigModel属性名称:"+subpropertyName+",属性值:"+gridColumnConfigModel.get(subpropertyName));
				
					}
				}
			}																	
						
		}
				
		
	}


	private static void printItemOfAssociateToWindowInf(
			ItemOfAssociateToWindow itemOfAssociateToWindow) {
		//logger.debug("********************************************************");
		for (String subpropertyName : itemOfAssociateToWindow.getPropertyNames()) {
			logger.debug("    ItemOfAssociateToWindow属性名称:"+subpropertyName+",属性值:"+itemOfAssociateToWindow.get(subpropertyName));

			if (MetaDataConstants.GXT_TO_SEAM_SERVICEPARAMETER_MODEL.equals(subpropertyName)) {
				GxtToSeamServiceParameter gxtToSeamServiceParameter =itemOfAssociateToWindow.get(subpropertyName);
				if (gxtToSeamServiceParameter!=null) {
					
					for (String subsubpropertyName : gxtToSeamServiceParameter.getPropertyNames()) {
						logger.debug("         GxtToSeamServiceParameter属性名称:"+subsubpropertyName+",属性值:"+gxtToSeamServiceParameter.get(subsubpropertyName));
						
					}
					//logger.debug("         属性名称:getServiceComponentName()"+",属性值:"+gxtToSeamServiceParameter.getServiceComponentName());
					//logger.debug("         属性名称:getServiceMethodName()"+",属性值:"+gxtToSeamServiceParameter.getServiceMethodName());
					
				}
			}
			
			
			if (MetaDataConstants.APP_EVENT_TYPE.equals(subpropertyName)) {
				GxtAppEventType gxtAppEventType =itemOfAssociateToWindow.get(subpropertyName);
				if (gxtAppEventType!=null) {
					
					for (String subsubpropertyName : gxtAppEventType.getPropertyNames()) {
						logger.debug("         GxtAppEventType属性名称:"+subsubpropertyName+",属性值:"+gxtAppEventType.get(subsubpropertyName));
						
					}						
					
				}
			}
			
			
			if (ComponentMetaDataConstants.CHILDREN_ITEMS.equals(subpropertyName)) {
				List<ItemOfAssociateToWindow> list=itemOfAssociateToWindow.getChildrenItems();
				if (list!=null) {
					
					for (ItemOfAssociateToWindow subItem : list) {
						printItemOfAssociateToWindowInf(itemOfAssociateToWindow);

					}						
					
				}
			}
			
			
			
		}

		
	}
	
	
	
}//end of class
