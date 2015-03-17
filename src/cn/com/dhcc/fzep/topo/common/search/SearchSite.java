package cn.com.dhcc.fzep.topo.common.search;

import java.util.List;


public class SearchSite {
	/**
	 * 分页信息
	 */
	private Page page = null;
	/**
	 * 搜索关键字
	 */
	private String keyWord = null;    //关键字
	/**
	 * 搜索字段名称
	 */
	private String searchField = null;
	/**
	 * 所在区域名称
	 */
	private String areaName = null;
	/**
	 * 区域Id
	 */
	private int areaId = -1;
	
	private List<Integer> exceptList = null;
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 验证搜索条件是否有效
	 * @return
	 */
	public boolean valid(){
		
		return false;
	}
	
	
	
	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public List<Integer> getExceptList() {
		return exceptList;
	}

	public void setExceptList(List<Integer> exceptList) {
		this.exceptList = exceptList;
	}

	@Override
	public String toString() {
		return "SearchSite [page=" + page + ", keyWord=" + keyWord
				+ ", searchField=" + searchField + ", areaName=" + areaName
				+ "]";
	}
	
}
