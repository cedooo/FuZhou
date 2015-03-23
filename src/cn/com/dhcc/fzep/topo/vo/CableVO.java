package cn.com.dhcc.fzep.topo.vo;

import java.util.List;

import cn.com.dhcc.fzep.topo.pojo.Cable;
import cn.com.dhcc.fzep.topo.pojo.FiberCoreNumber;

public class CableVO extends Cable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7361519715451482193L;
	private List<FiberCoreNumber> listFibeCoreNumber ;
	
	public List<FiberCoreNumber> getListFibeCoreNumber() {
		return listFibeCoreNumber;
	}
	public void setListFibeCoreNumber(List<FiberCoreNumber> listFibeCoreNumber) {
		this.listFibeCoreNumber = listFibeCoreNumber;
	}

	public CableVO(){
		
	}
	public CableVO(Cable cable){
		this.setBizType(cable.getBizType());
		this.setCableEndId(cable.getCableEndId());
		this.setCableId(cable.getCableId());
		this.setCableLength(cable.getCableLength());
		this.setCableName(cable.getCableName());
		this.setCableStartId(cable.getCableStartId());
		this.setCableType(cable.getCableType());
		this.setConstructionUnitId(cable.getConstructionUnitId());
		this.setDelFlg(cable.getDelFlg());
		this.setDescp(cable.getDescp());
		this.setFiberId(cable.getFiberId());
		this.setIsMainRoad(cable.getIsMainRoad());
		this.setLayingType(cable.getLayingType());
		this.setRunTime(cable.getRunTime());
	}
	@Override
	public String toString() {
		return "CableVO [listFibeCoreNumber=" + listFibeCoreNumber + "]";
	}
	
}
