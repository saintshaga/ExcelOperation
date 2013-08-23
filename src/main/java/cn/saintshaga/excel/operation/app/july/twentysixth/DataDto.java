package cn.saintshaga.excel.operation.app.july.twentysixth;

import java.util.Arrays;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class DataDto {
	@InputFieldProperty("营业厅名称")
	@OutputFieldProperty(title="营业厅名称",column=1)
	private String name;
	
	@InputFieldProperty("区域")
	@OutputFieldProperty(title="区域",column=2)
	private String area;
	
	@InputFieldProperty("营业厅类型")
	@OutputFieldProperty(title="营业厅类型",column=3)
	private String type;
	
	@InputFieldProperty("总计")
	@OutputFieldProperty(title="总计",column=4,delta=1)
	private String[] total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String[] getTotal() {
		return total;
	}

	public void setTotal(String[] total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DataDto [name=" + name + ", area=" + area + ", type=" + type
				+ ", total=" + Arrays.toString(total) + "]";
	}
	
	

}
