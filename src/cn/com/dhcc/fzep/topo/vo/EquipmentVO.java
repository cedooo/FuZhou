package cn.com.dhcc.fzep.topo.vo;

public class EquipmentVO {
	public static final String EQUIP_IMG_CABLE = "";
	public static final String EQUIP_IMG_CARRIER = "";
	public static final String EQUIP_IMG_GPRS = "";
	public static final String EQUIP_IMG_OLT = "";
	public static final String EQUIP_IMG_ONU = "";
	public static final String EQUIP_IMG_3SWITCH = "";
	public static final String EQUIP_IMG_2SWITCH = "";
	private String type = null;
	private String typeName = null;
	private String id = null;
	private String name =  null;
	private String img = null;
	/**
	 * 包含设备其他信息的json数据对象
	 */
	private String jsonData = null;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	@Override
	public String toString() {
		return "AEquipment [type=" + type + ", id=" + id + ", name=" + name
				+ ", img=" + img + ", jsonData=" + jsonData + "]";
	}
	
	
	
	
}
