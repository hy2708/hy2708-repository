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
public class GxtComponentMetaNodeModelUtil2 {

	//private static Log logger = LogFactory.getLog(GxtComponentMetaNodeModelUtil2.class);

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
			
			gxtComponentMetaNodeModel.setComponentProperties(null);
		}
		
		return gxtComponentMetaNodeModel;
	}
	
	

	
}//end of class
