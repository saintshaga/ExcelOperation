package cn.saintshaga.excel.operation.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;

public class Task1Main {

	public static void main(String[] args) throws Exception {
		ExcelDao dao = new ExcelDao("345月.xls");
//		List<Data1Dto> data3 = dao.getAllDataFromSheet(Data1Dto.class, 1, 1, 2);
		List<Data1Dto> data4 = dao.getAllDataFromSheet(Data1Dto.class, 2, 1, 2);
		List<Data1Dto> data5 = dao.getAllDataFromSheet(Data1Dto.class, 3, 1, 2);
		dao.close();
		ExcelDao dao123 = new ExcelDao("一季度.xls");
		List<Data2Dto> data123 = dao123.getAllDataFromSheet(Data2Dto.class, 1, 1, 3);
		dao123.close();
		Map<String, Data2Dto> allDatas = new HashMap<String, Data2Dto>();
		for (Data2Dto data2Dto : data123) {
			allDatas.put(data2Dto.getId(), data2Dto);
		}
		for (Data1Dto data1Dto : data4) {
			if(allDatas.containsKey(data1Dto.getId())) {
				Data2Dto dto = allDatas.get(data1Dto.getId());
				dto.setHeyue4(data1Dto.getHeyue());
				dto.setFenxiao4(data1Dto.getFenxiao());
			} else {
				Data2Dto dto = new Data2Dto();
				dto.setId(data1Dto.getId());
				dto.setName(data1Dto.getName());
				dto.setArea(data1Dto.getArea());
				dto.setType(data1Dto.getType());
				dto.setHeyue1(-1);
				dto.setFenxiao1(-1);
				dto.setHeyue2(-1);
				dto.setFenxiao2(-1);
				dto.setHeyue3(-1);
				dto.setFenxiao3(-1);
				dto.setHeyue4(data1Dto.getHeyue());
				dto.setFenxiao4(data1Dto.getFenxiao());
				allDatas.put(dto.getId(), dto);
			}
		}

		for (Data1Dto data1Dto : data5) {
			if(allDatas.containsKey(data1Dto.getId())) {
				Data2Dto dto = allDatas.get(data1Dto.getId());
				if(dto.getType().trim().equals("空")) {
					dto.setType(data1Dto.getType());
				}
				dto.setHeyue5(data1Dto.getHeyue());
				dto.setFenxiao5(data1Dto.getFenxiao());
			} else {
				Data2Dto dto = new Data2Dto();
				dto.setId(data1Dto.getId());
				dto.setName(data1Dto.getName());
				dto.setArea(data1Dto.getArea());
				dto.setType(data1Dto.getType());
				dto.setHeyue1(-1);
				dto.setFenxiao1(-1);
				dto.setHeyue2(-1);
				dto.setFenxiao2(-1);
				dto.setHeyue3(-1);
				dto.setFenxiao3(-1);
				dto.setHeyue4(-1);
				dto.setFenxiao4(-1);
				dto.setHeyue5(data1Dto.getHeyue());
				dto.setFenxiao5(data1Dto.getFenxiao());
				allDatas.put(dto.getId(), dto);
			}
		}
		
		Data2Out out = new Data2Out("ans.xls");
		out.writeSheet("sheet1", 0, allDatas);
		out.close();
	}

}
