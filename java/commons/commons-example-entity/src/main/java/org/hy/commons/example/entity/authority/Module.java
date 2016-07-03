package org.hy.commons.example.entity.authority;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author acer
 *
 */
@Entity
@Table(name="t_Module")
public class Module {
	
	@Override
	public String toString() {
		return "Module [children=" + children + ", description=" + description
				+ ", id=" + id + ", name=" + name + ", parent=" + parent
				+ ", sn=" + sn + ", url=" + url + ", orderNo=" + orderNo + "]";
	}
	private List<Module> children;
	private String  description;
	private int id;
	private String   name ;
	private Module parent;
	private String sn;
	private String url;
	private int orderNo;
	
	public List<Module> matchChildrenModules(List<Module> modules){
		List<Module> list = this.getChildren();
		list.retainAll(modules);
		return list;
	}
	
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(mappedBy="parent")
	public List<Module> getChildren() {
		return children;
	}
	
	public String getDescription() {
		return description;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@Column(unique=true)
	public String getName() {
		return name;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pid")
	public Module getParent() {
		return parent;
	}
	@Column(unique=true)
	public String getSn() {
		return sn;
	}
	public void setChildren(List<Module> children) {
		this.children = children;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setId(int id) {
		this.id = id;
	} 
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Module parent) {
		this.parent = parent;
	};
	public void setSn(String sn) {
		this.sn = sn;
	}
}
