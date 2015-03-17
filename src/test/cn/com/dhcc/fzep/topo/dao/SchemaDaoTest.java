package test.cn.com.dhcc.fzep.topo.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.dao.SchemaDao;
import cn.com.dhcc.fzep.topo.pojo.Schema;

public class SchemaDaoTest {
	private SchemaDao schemaDao = new SchemaDao();
	
	//@Test
	public void testInsertSchema() {
		Schema schema = new Schema();
		schema.setSchemaAddTime("2014-11-27 15:57:53");
		schema.setSchemaData("tests");
		boolean res = schemaDao.insertSchema(schema);
		assertEquals(res, true);
	}
	@Test
	public void testGetSchema() {
		String schemaID = "1";
		Schema schema = schemaDao.getSchema(schemaID);
		System.out.println(schema);
		assertEquals(schema!=null, true);
	}
}
