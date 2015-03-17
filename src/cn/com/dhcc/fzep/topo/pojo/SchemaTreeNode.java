package cn.com.dhcc.fzep.topo.pojo;

import java.util.List;

public class SchemaTreeNode {
	public static final String TREE_LEAF = "0";
	public static final String TREE_NO_LEAF = "1";
	
	private String name = null;
	private String type = null;
	private String id = null;
	private String treeLevel = null;
	private String parentNode = null;
	private List<SchemaTreeNode> children = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<SchemaTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<SchemaTreeNode> children) {
		this.children = children;
	}
	public String getTreeLevel() {
		return treeLevel;
	}
	public void setTreeLevel(String treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getParentNode() {
		return parentNode;
	}
	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}


}
