package cn.com.dhcc.fzep.topo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zdy.dao.DBManager;

import cn.com.dhcc.fzep.topo.pojo.SchemaTreeNode;

public class SchemaTreeNodeDao {
	
	/**
	 * 得到所有‘根’节点
	 * @return
	 */
	public List<SchemaTreeNode> getRootNode(){
		List<SchemaTreeNode> list = new  ArrayList<SchemaTreeNode>();
		DBManager db = new DBManager();
		try {
			db.openConnection();
			ResultSet results = db.executeQuery("select * from t_schema_tree_node where dt_del_time is null  order by vc_tree_node_type limit 1000");
			while(results.next()){
				String n_schema_tree_node_id = results.getString("n_schema_tree_node_id");
				String vc_tree_node_name = results.getString("vc_tree_node_name");
				String vc_tree_node_type = results.getString("vc_tree_node_type");
				String n_tree_parent_node = results.getString("n_tree_parent_node");
				String n_tree_level = results.getString("n_tree_level");
				String vc_schema_type_alias = results.getString("vc_schema_type_alias");
				
				SchemaTreeNode schemaTreeNode = new SchemaTreeNode();
				schemaTreeNode.setId(n_schema_tree_node_id);
				schemaTreeNode.setName(vc_tree_node_name);
				schemaTreeNode.setParentNode(n_tree_parent_node);
				schemaTreeNode.setTreeLevel(n_tree_level);
				schemaTreeNode.setType(vc_schema_type_alias);
				
				if(SchemaTreeNode.TREE_NO_LEAF.equals(vc_tree_node_type)){
					schemaTreeNode.setChildren(new ArrayList<SchemaTreeNode>());
				}
				
				list.add(schemaTreeNode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}
}
