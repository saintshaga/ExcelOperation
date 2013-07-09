package cn.saintshaga.excel.operation.app.july.ninth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

public class Main {

	public static void main(String[] args) throws Exception{
		ExcelDao dao = new ExcelDao("5.xls");
		List<DataDto> dtos = dao.getAllDataFromSheet(DataDto.class, 1, 1, 2);
		dao.close();
		Map<String, DataDto> map = new HashMap<String, DataDto>();
		for (DataDto dataDto : dtos) {
			if(!map.containsKey(dataDto.getName())) {
				map.put(dataDto.getName(), dataDto);
			} else {
				dataDto.setTotal(dataDto.getTotal()+map.get(dataDto.getName()).getTotal());
				map.put(dataDto.getName(), dataDto);
			}
		}
		ExcelOut out = new ExcelOut("ans1.xls");
		out.writeSheet(DataDto.class, "sheet1", 1, new ArrayList<DataDto>(map.values()));
		out.close();
	}

}
