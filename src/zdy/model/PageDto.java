package zdy.model;


/**
 * @function 分页bean
 * @author zhangdengyuan
 * @createDate 2014-02-01
 * @lastUpdateDate 2014-02-01
 * @version 1.0
 */
public class PageDto extends TemplateBeen {
	/** 每页显示记录数 */
	private int perPage = 50;
	/** 当前其实记录数 */
	private int startRecord = 0;
	/** 总记录数 */
	private int totalRecord = 0;
	/**
	 * @return the perPage
	 */
	public int getPerPage() {
		return perPage;
	}
	/**
	 * @param perPage
	 *            the perPage to set
	 */
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	/**
	 * @return the startRecord
	 */
	public int getStartRecord() {
		return startRecord;
	}
	/**
	 * @param startRecord
	 *            the startRecord to set
	 */
	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}
	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}
	/**
	 * @param totalRecord
	 *            the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

}
