package cn.saintshaga.excel.operation.base;

import java.util.List;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.FieldProperty;

public class TestDto {
	@FieldProperty("渠道编码")
	private String codeNumber;
	
	@FieldProperty("营业厅名称")
	private String name;
	
	@FieldProperty("营业厅面积")
	private Integer area;
	
	@FieldProperty("台席总数")
	private Integer totalNumber;
	

	@Override
	public String toString() {
		return "TestDto [codeNumber=" + codeNumber + ", name=" + name
				+ ", area=" + area + ", totalNumber=" + totalNumber + "]";
	}


	public static void main(String[] args) throws Exception{
		ExcelDao dao = new ExcelDao("src/test/resources/3月检查结果.xls");
		List<TestDto> allDatas = dao.getAllDataFromSheet(TestDto.class, 1, 2, 4);
		for (TestDto testDto : allDatas) {
			System.out.println(testDto);
		}
		dao.close();
	}

}
