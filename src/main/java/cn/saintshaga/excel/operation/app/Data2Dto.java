package cn.saintshaga.excel.operation.app;

import java.util.Arrays;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class Data2Dto {

	@InputFieldProperty("Name")
	@OutputFieldProperty(title="Name",column=1,delta=0)
	private String name;
	
	@InputFieldProperty("ID")
	@OutputFieldProperty(title="ID",column=2,delta=0)
	private String id;
	
	@InputFieldProperty("区域")
	@OutputFieldProperty(title="区域",column=3,delta=0)
	private String area;
	
	@InputFieldProperty("营业厅类型")
	@OutputFieldProperty(title="营业厅类型",column=4,delta=0)
	private String type;
	
	@InputFieldProperty("合约")
	@OutputFieldProperty(title="合约",column=5,delta=2)
	private Integer[] heyue;
	
	@InputFieldProperty("分销")
	@OutputFieldProperty(title="分销",column=6,delta=2)
	private Integer[] fenxiao;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer[] getHeyue() {
		return heyue;
	}

	public void setHeyue(Integer[] heyue) {
		this.heyue = heyue;
	}

	public Integer[] getFenxiao() {
		return fenxiao;
	}

	public void setFenxiao(Integer[] fenxiao) {
		this.fenxiao = fenxiao;
	}

	@Override
	public String toString() {
		return "Data2Dto [name=" + name + ", id=" + id + ", area=" + area
				+ ", type=" + type + ", heyue=" + Arrays.toString(heyue)
				+ ", fenxiao=" + Arrays.toString(fenxiao) + "]";
	}
	
	

}
