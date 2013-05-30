package cn.saintshaga.ExcelOperation.utility;

import java.util.List;

import jxl.Cell;
import jxl.write.Label;

public class ADto implements JXLDtoIO<ADto> {
	private String id;
	private String name;
	private int a = 1;

	public ADto inputDto(Cell[] cells) {
		ADto dto = new ADto();
		dto.setId(cells[0].getContents().trim());
		dto.setName(cells[1].getContents().trim());
		return dto;
	}

	public List<Label> outputDto(ADto dto) {
		return null;
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

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "ADto [id=" + id + ", name=" + name + ", a=" + a + "]";
	}
	
}
