package cn.saintshaga.excel.operation.app;

import cn.saintshaga.excel.operation.library.InputFieldProperty;

public class Data1Dto {

	@InputFieldProperty("营业厅名称")
	private String name;
	
	@InputFieldProperty("机构号")
	private String id;
	
	@InputFieldProperty("区域")
	private String area;
	
	@InputFieldProperty("营业厅类型")
	private String type;
	
	@InputFieldProperty("合约")
	private int heyue;
	
	@InputFieldProperty("分销")
	private int fenxiao;

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

	public int getHeyue() {
		return heyue;
	}

	public void setHeyue(int heyue) {
		this.heyue = heyue;
	}

	public int getFenxiao() {
		return fenxiao;
	}

	public void setFenxiao(int fenxiao) {
		this.fenxiao = fenxiao;
	}

	public String toString() {
		return "Data1Dto [name=" + name + ", id=" + id + ", area=" + area
				+ ", type=" + type + ", heyue=" + heyue + ", fenxiao="
				+ fenxiao + "]";
	}
}
