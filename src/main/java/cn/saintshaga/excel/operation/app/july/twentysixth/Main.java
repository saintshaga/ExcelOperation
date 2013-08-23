package cn.saintshaga.excel.operation.app.july.twentysixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

public class Main {

	public static void main(String[] args) throws Exception {
		ExcelDao dao = new ExcelDao("SalaryMerge.xls");
		Map<String, DataDto> map = new HashMap<String, DataDto>();
		for(int i=0; i<6; i++) {
			List<DataDto> allDataDtos = dao.getAllDataFromSheet(DataDto.class, i+1, 1, 2);
			for (DataDto dataDto : allDataDtos) {
				DataDto dto = map.get(dataDto.getName());
				if(dto == null) {
					dto =  new DataDto();
					dto.setName(dataDto.getName());
					dto.setArea(dataDto.getArea());
					dto.setType(dataDto.getType());
					dto.setTotal(new String[6]);
				}
				(dto.getTotal())[i] = (dataDto.getTotal())[0];
				map.put(dto.getName(), dto);
			}
		}
		dao.close();
		
		ExcelOut out = new ExcelOut("salaryAns.xls");
		out.writeSheet(DataDto.class, "1-6", 1, new ArrayList<DataDto>(map.values()));
		out.close();

	}

}
