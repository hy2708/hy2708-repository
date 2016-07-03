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
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentControllerMetaModel;
import com.hy.mydesktop.shared.persistence.domain.gxt.GxtComponentControllerMetaNodeModel;
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
 * <li>设计日期：2012-2-11；时间：上午10:50:53</li>
 * <li>类型名称：ComponentControllerMetaModelUtil</li>
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
public class ComponentControllerMetaModelUtil {

	private static Log logger = LogFactory.getLog(ComponentControllerMetaModelUtil.class);

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
	public static GxtComponentControllerMetaModel reconfigureGxtComponentControllerMetaModelFromJpa(
			GxtComponentControllerMetaModel gxtComponentControllerMetaModel) {
		
			List<GxtComponentControllerMetaNodeModel> gxtComponentControllerMetaNodeModels = gxtComponentControllerMetaModel.getList();
			if (gxtComponentControllerMetaNodeModels!=null) {
				for (GxtComponentControllerMetaNodeModel gxtComponentControllerMetaNodeModel : gxtComponentControllerMetaNodeModels) {
					GxtComponentMetaNodeModel gxtComponentMetaNodeModel =gxtComponentControllerMetaNodeModel.getGxtComponentMetaNodeModel();

					if (gxtComponentMetaNodeModel!=null) {
						
						gxtComponentMetaNodeModel = GxtComponentMetaNodeModelUtil.reconfigureGxtComponentMetaNodeModelFromJpa(gxtComponentMetaNodeModel);
						gxtComponentControllerMetaNodeModel.setGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
					}

				}
				//gxtComponentControllerMetaModel.setList(gxtComponentControllerMetaNodeModels);

			}
		return gxtComponentControllerMetaModel;
	}
	
	
	public static List<GxtComponentControllerMetaModel> reconfigureGxtComponentControllerMetaModelsFromJpa(
			List<GxtComponentControllerMetaModel> controllerMetaModels) {
		
		List<GxtComponentControllerMetaModel> list = new  LinkedList<GxtComponentControllerMetaModel>();
		if (controllerMetaModels!=null) {
			for (GxtComponentControllerMetaModel gxtComponentControllerMetaModel : controllerMetaModels) {
				
				list.add(reconfigureGxtComponentControllerMetaModelFromJpa(gxtComponentControllerMetaModel));
			}
		}
	
		return list;
	
	}

	
	
	public static GxtComponentControllerMetaModel reConstructGxtComponentControllerMetaModel(
			GxtComponentControllerMetaModel gxtComponentControllerMetaModel) {
		
		if (gxtComponentControllerMetaModel.getList()!=null) {
			
			for (GxtComponentControllerMetaNodeModel controllerMetaNodeModel : gxtComponentControllerMetaModel.getList()) {
				if (controllerMetaNodeModel.getIdentifier()==null) {
					
					controllerMetaNodeModel.setIdentifier(UUIDUtil.randomUUID());
				}
				Set<GxtAppEventType> set=controllerMetaNodeModel.getRegisterEventTypes();
				if (set!=null) {					
					for (GxtAppEventType gxtAppEventType : set) {
						if (gxtAppEventType.getIdentifier()==null) {
							gxtAppEventType.setIdentifier(UUIDUtil.randomUUID());
						}
					}
				}
				GxtComponentMetaNodeModel gxtComponentMetaNodeModel =controllerMetaNodeModel.getGxtComponentMetaNodeModel();
				if (gxtComponentMetaNodeModel==null) {
					logger.warn("gxtComponentControllerMetaNodeModel【"+controllerMetaNodeModel.getId()+"】，没有GxtComponentMetaNodeModel!");
				} else {

					if (gxtComponentMetaNodeModel.getIdentifier()==null) {
						gxtComponentMetaNodeModel.setIdentifier(UUIDUtil.randomUUID());
					}
					GxtComponentMetaNodeModelUtil.reConstructGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
				}
				
			}
		};
		
		return gxtComponentControllerMetaModel;
	}
	
		
	
	/*public static List<GxtComponentMetaNodeModel> reConstructGxtComponentMetaNodeModels(
			List<GxtComponentMetaNodeModel> list) {
		List<GxtComponentMetaNodeModel> newList=new LinkedList<GxtComponentMetaNodeModel>();
		
		for (GxtComponentMetaNodeModel gxtComponentMetaNodeModel : list) {
			
			ComponentControllerMetaModelUtil.reConstructGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
			newList.add(gxtComponentMetaNodeModel);
		}
		
		
		return newList;
	}
	
	public static GxtComponentMetaNodeModel[] reConstructGxtComponentMetaNodeModels(
			GxtComponentMetaNodeModel... gxtComponentMetaNodeModels) {
		
		GxtComponentMetaNodeModel[] newList=new GxtComponentMetaNodeModel[gxtComponentMetaNodeModels.length];
		Integer count = new Integer(0);

		for (GxtComponentMetaNodeModel gxtComponentMetaNodeModel : gxtComponentMetaNodeModels) {
			
			ComponentControllerMetaModelUtil.reConstructGxtComponentMetaNodeModel(gxtComponentMetaNodeModel);
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

		} else if (ComponentMetaDataConstants.GRID_COLUMNCONFIG_MODELS.equals(baseModelPropertyName)) {
			return true;

		} else {
			return false;
		}
		
	}

*/
	public static void printGxtComponentControllerMetaModelInfo(GxtComponentControllerMetaModel baseModel) {
		logger.debug(baseModel);
		logger.debug("GxtComponentControllerMetaModel【identifier="+baseModel.getIdentifier()+"】");
		logger.debug("GxtComponentControllerMetaModel【id="+baseModel.getId()+"】");
		for (GxtComponentControllerMetaNodeModel gxtComponentControllerMetaNodeModel : baseModel.getList()) {
			printGxtComponentControllerMetaNodeModelInfo(gxtComponentControllerMetaNodeModel);
		}
		
				
		
	}
	
	private static void printGxtComponentControllerMetaNodeModelInfo(GxtComponentControllerMetaNodeModel baseModel) {
		logger.debug(baseModel);
		for (String propertyName : baseModel.getPropertyNames()) {
			logger.debug("GxtComponentControllerMetaNodeModel属性名称:"+propertyName+",属性值:"+baseModel.get(propertyName));
			if (MetaDataConstants.GXT_COMPONENT__METANODEMODEL.equals(propertyName)) {
				GxtComponentMetaNodeModel gxtComponentMetaNodeModel=(GxtComponentMetaNodeModel)baseModel.get(propertyName);
				if (gxtComponentMetaNodeModel!=null) {
					
					GxtComponentMetaNodeModelUtil.printGxtComponentMetaNodeModelInfo(gxtComponentMetaNodeModel);
				}
			}
														
						
		}
				
		
	}
	
}//end of class
