package cn.saintshaga.excel.operation.app.july.eighteenth;

import java.util.Arrays;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class DataDto {
	
	@InputFieldProperty("营业厅名称")
	@OutputFieldProperty(title="营业厅名称",column=1)
	private String name;
	
	@InputFieldProperty("手机上网套餐发展笔数")
	@OutputFieldProperty(title="手机上网套餐发展笔数",column=2,delta=1)
	private Integer[] number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer[] getNumber() {
		return number;
	}

	public void setNumber(Integer[] number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "DataDto [name=" + name + ", number=" + Arrays.toString(number)
				+ "]";
	}

}
