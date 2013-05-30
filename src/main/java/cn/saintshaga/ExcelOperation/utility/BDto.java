package cn.saintshaga.ExcelOperation.utility;

import java.util.List;

import jxl.Cell;
import jxl.write.Label;

public class BDto implements JXLDtoIO<BDto> {
	private String department;
	private String name;
	private int b = 1;

	public BDto inputDto(Cell[] cells) {
		BDto dto = new BDto();
		dto.setDepartment(cells[0].getContents().trim());
		dto.setName(cells[2].getContents().trim());
		return dto;
	}

	public List<Label> outputDto(BDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "BDto [department=" + department + ", name=" + name + ", b=" + b
				+ "]";
	}

}
