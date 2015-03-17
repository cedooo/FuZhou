package cn.com.dhcc.fzep.topo.pojo;

public class Schema {
	
	private String schemaId = null;
	private String schemaName = null;
	private String schemaAddTime = null;
	private String schemaData = null;
	private String schemaArgs = null;
	private String schemaDelTime = null;
	private String schemaType = null;
	private String schemaNote = null;
	private String areaId = null;
	private String siteId = null;
	private String isDefault = null;
	
	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getSchemaAddTime() {
		return schemaAddTime;
	}

	public void setSchemaAddTime(String schemaAddTime) {
		this.schemaAddTime = schemaAddTime;
	}

	public String getSchemaData() {
		return schemaData;
	}

	public void setSchemaData(String schemaData) {
		this.schemaData = schemaData;
	}

	public String getSchemaDelTime() {
		return schemaDelTime;
	}

	public void setSchemaDelTime(String schemaDelTime) {
		this.schemaDelTime = schemaDelTime;
	}

	public String getSchemaType() {
		return schemaType;
	}

	public void setSchemaType(String schemaType) {
		this.schemaType = schemaType;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getSchemaArgs() {
		return schemaArgs;
	}

	public void setSchemaArgs(String schemaArgs) {
		this.schemaArgs = schemaArgs;
	}

	public String getSchemaNote() {
		return schemaNote;
	}

	public void setSchemaNote(String schemaNote) {
		this.schemaNote = schemaNote;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "Schema [schemaId=" + schemaId + ", schemaName=" + schemaName
				+ ", schemaAddTime=" + schemaAddTime + ", schemaData="
				+ schemaData + ", schemaArgs=" + schemaArgs
				+ ", schemaDelTime=" + schemaDelTime + ", schemaType="
				+ schemaType + ", schemaNote=" + schemaNote + ", areaId="
				+ areaId + ", siteId=" + siteId + ", isDefault=" + isDefault
				+ "]";
	}



}
