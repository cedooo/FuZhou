package test.cn.com.dhcc.fzep.topo.service;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dhcc.fzep.topo.pojo.Schema;
import cn.com.dhcc.fzep.topo.service.SchemaManageService;
import cn.com.dhcc.fzep.topo.service.impl.SchemaManageServiceImpl;

public class SchemaTreeServiceTest {
	private SchemaManageService srv = new SchemaManageServiceImpl();
	@Test
	public void testGetSchemaBriefInfoByAreaId() {
		String areId = "2";
		Schema schema = srv.getSchemaBriefInfoByAreaId(areId );
		assertEquals(schema!=null, true);
		System.out.println(schema);
	}

}
