package cn.saintshaga.excel.operation.app.november.seventh;

import java.util.Arrays;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class DataDto {
	@InputFieldProperty("营业厅")
	@OutputFieldProperty(title="营业厅",column=1)
	private String name;
	
	@InputFieldProperty("区域")
	@OutputFieldProperty(title="区域",column=2)
	private String area;
	
	@InputFieldProperty("营业部")
	@OutputFieldProperty(title="营业部",column=3)
	private String department;

	@InputFieldProperty("营业厅类型")
	@OutputFieldProperty(title="营业厅类型",column=4)
	private String type;
	
	@InputFieldProperty("营业厅性质")
	@OutputFieldProperty(title="营业厅性质",column=5)
	private String property;
	
	@InputFieldProperty("到厅用户数")
	@OutputFieldProperty(title="到厅用户数",column=6,delta=2)
	private Integer[] numberOfUsers;
	
	@InputFieldProperty("业务量")
	@OutputFieldProperty(title="业务量",column=7,delta=2)
	private Integer[] numberOfBusiness;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Integer[] getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(Integer[] numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public Integer[] getNumberOfBusiness() {
		return numberOfBusiness;
	}

	public void setNumberOfBusiness(Integer[] numberOfBusiness) {
		this.numberOfBusiness = numberOfBusiness;
	}

	@Override
	public String toString() {
		return "DataDto [name=" + name + ", area=" + area + ", department="
				+ department + ", type=" + type + ", property=" + property
				+ ", numberOfUsers=" + Arrays.toString(numberOfUsers)
				+ ", numberOfBusiness=" + Arrays.toString(numberOfBusiness)
				+ "]";
	}
	
}
