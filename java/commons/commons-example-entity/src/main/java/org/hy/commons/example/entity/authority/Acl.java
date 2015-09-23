package org.hy.commons.example.entity.authority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 访问控制列表
 * @author acer
 *
 */
@Entity
@Table(name="t_acl")
public class Acl {
	public static final String PRINCIPALTYPE_ROLE ="role";
	public static final String PRINCIPALTYPE_USER ="user";
	public static final int PERMISSION_NONE = -1;
	public static final int PERMISSION_CREATE = 0;
	public static final int PERMISSION_READ = 1;
	public static final int PERMISSION_UPDATE = 2;
	public static final int PERMISSION_DELETE = 3;
	public static final int PERMISSION_YES = 1;
	public static final int PERMISSION_NO = 0;
	
	private int principalId;
	private int moduleId;
	//private int permission=0;
	/**	  主体类型：Use或Role	 */
	private String principalType;
	private int id;
	private int aclState =0;
	public int getAclState() {
		return aclState;
	}
	public void setAclState(int aclState) {
		this.aclState = aclState;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrincipalType() {
		return principalType;
	}
	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}
	public int getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getPermission(int permission) {
		int permissionValue=1;
		permissionValue = permissionValue << permission;
		 permissionValue &= aclState;
		if(permissionValue !=0){
			return PERMISSION_YES;
		}
		return PERMISSION_NO;
	}
	/**
	 * 
	 * @param permission
	 * @param permissionType 设置正负授权，正：授权；负：取消授权
	 */
	public void setPermission(int permission,boolean permissionType){
		if(permission<0||permission>3){
			throw new RuntimeException(permission+"授权非法！");
		}
		int permissionValue=1;
		permissionValue = permissionValue << permission;
		if(permissionType){
			aclState |= permissionValue;
		}else{
			aclState &= ~permissionValue;
		}
		
		
	}
	
}