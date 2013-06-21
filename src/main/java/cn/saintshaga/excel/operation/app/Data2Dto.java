package cn.saintshaga.excel.operation.app;

import cn.saintshaga.excel.operation.library.FieldProperty;

public class Data2Dto {

	@FieldProperty("Name")
	private String name;
	
	@FieldProperty("ID")
	private String id;
	
	@FieldProperty("区域")
	private String area;
	
	@FieldProperty("营业厅类型")
	private String type;
	
	@FieldProperty("合约1")
	private int heyue1;
	
	@FieldProperty("分销1")
	private int fenxiao1;

	@FieldProperty("合约2")
	private int heyue2;
	
	@FieldProperty("分销2")
	private int fenxiao2;

	@FieldProperty("合约3")
	private int heyue3;
	
	@FieldProperty("分销3")
	private int fenxiao3;
	
	private int heyue4;
	private int fenxiao4;
	private int heyue5;
	private int fenxiao5;

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

	public int getHeyue1() {
		return heyue1;
	}

	public void setHeyue1(int heyue1) {
		this.heyue1 = heyue1;
	}

	public int getFenxiao1() {
		return fenxiao1;
	}

	public void setFenxiao1(int fenxiao1) {
		this.fenxiao1 = fenxiao1;
	}

	public int getHeyue2() {
		return heyue2;
	}

	public void setHeyue2(int heyue2) {
		this.heyue2 = heyue2;
	}

	public int getFenxiao2() {
		return fenxiao2;
	}

	public void setFenxiao2(int fenxiao2) {
		this.fenxiao2 = fenxiao2;
	}

	public int getHeyue3() {
		return heyue3;
	}

	public void setHeyue3(int heyue3) {
		this.heyue3 = heyue3;
	}

	public int getFenxiao3() {
		return fenxiao3;
	}

	public void setFenxiao3(int fenxiao3) {
		this.fenxiao3 = fenxiao3;
	}

	public int getHeyue4() {
		return heyue4;
	}

	public void setHeyue4(int heyue4) {
		this.heyue4 = heyue4;
	}

	public int getFenxiao4() {
		return fenxiao4;
	}

	public void setFenxiao4(int fenxiao4) {
		this.fenxiao4 = fenxiao4;
	}

	public int getHeyue5() {
		return heyue5;
	}

	public void setHeyue5(int heyue5) {
		this.heyue5 = heyue5;
	}

	public int getFenxiao5() {
		return fenxiao5;
	}

	public void setFenxiao5(int fenxiao5) {
		this.fenxiao5 = fenxiao5;
	}

	@Override
	public String toString() {
		return "Data2Dto [name=" + name + ", id=" + id + ", area=" + area
				+ ", type=" + type + ", heyue1=" + heyue1 + ", fenxiao1="
				+ fenxiao1 + ", heyue2=" + heyue2 + ", fenxiao2=" + fenxiao2
				+ ", heyue3=" + heyue3 + ", fenxiao3=" + fenxiao3 + "]";
	}
	
	

}
