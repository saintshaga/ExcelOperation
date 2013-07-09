package cn.saintshaga.excel.operation.app.july.ninth;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class DataDto {
	@InputFieldProperty("归属")
	@OutputFieldProperty(title="归属",column=1,delta=0)
	private String belong;

	@InputFieldProperty("片区")
	@OutputFieldProperty(title="片区",column=2,delta=0)
	private String area;

	@InputFieldProperty("营业厅")
	@OutputFieldProperty(title="营业厅",column=3,delta=0)
	private String name;

	@InputFieldProperty("营业厅类型")
	@OutputFieldProperty(title="营业厅类型",column=4,delta=0)
	private String type;

	@InputFieldProperty("总计")
	@OutputFieldProperty(title="总计",column=5,delta=0)
	private Integer total;

	
	public String getBelong() {
		return belong;
	}


	public void setBelong(String belong) {
		this.belong = belong;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public String toString() {
		return "DataDto [belong=" + belong + ", area=" + area + ", name="
				+ name + ", type=" + type + ", total=" + total + "]";
	}
}
