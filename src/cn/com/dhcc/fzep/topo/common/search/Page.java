package cn.com.dhcc.fzep.topo.common.search;

public class Page {
	/**
	 * 当前页数
	 */
	private int curPage = -1;
	/**
	 * 总页数
	 */
	private int totalPage = -1;
	/**
	 * 总记录条数
	 */
	private int totalRecords = -1;
	/**
	 * 每页记录条数
	 */
	private int numPerPage = -1;
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", totalPage=" + totalPage
				+ ", totalRecords=" + totalRecords + ", numPerPage="
				+ numPerPage + "]";
	}
	
}
