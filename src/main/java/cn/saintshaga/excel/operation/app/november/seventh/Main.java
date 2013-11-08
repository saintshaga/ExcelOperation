package cn.saintshaga.excel.operation.app.november.seventh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

public class Main {

	public static void main(String[] args) throws Exception{
		ExcelDao dao = new ExcelDao("2013ywl.xls");
		int numberOfSheets = 10;
		Map<String, DataDto> map = new HashMap<String, DataDto>();
		for(int i=1; i<=numberOfSheets; i++) {
			List<DataDto> list = dao.getAllDataFromSheet(
					DataDto.class, i, 1, 2);
			for (DataDto dataDto : list) {
				if(!map.containsKey(dataDto.getName())) {
					DataDto dto = new DataDto();
					dto.setArea(dataDto.getArea());
					dto.setDepartment(dataDto.getDepartment());
					dto.setName(dataDto.getName());
					dto.setProperty(dataDto.getProperty());
					dto.setType(dataDto.getType());
					dto.setNumberOfBusiness(new Integer[numberOfSheets]);
					dto.setNumberOfUsers(new Integer[numberOfSheets]);
					map.put(dataDto.getName(), dto);
				}
				DataDto dto = map.get(dataDto.getName());
				(dto.getNumberOfUsers())[i-1] = (dataDto.getNumberOfUsers())[0];
				(dto.getNumberOfBusiness())[i-1] = (dataDto.getNumberOfBusiness())[0];
			}
		}
		dao.close();
		ExcelOut out = new ExcelOut("2013ywl-Ans.xls");
		out.writeSheet(DataDto.class, "1-10", 1, new ArrayList<DataDto>(map.values()));
		out.close();
		System.out.println("end");

	}

}
