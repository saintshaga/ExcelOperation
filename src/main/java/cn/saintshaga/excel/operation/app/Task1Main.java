package cn.saintshaga.excel.operation.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

public class Task1Main {

	public static void main(String[] args) throws Exception {
		ExcelDao dao = new ExcelDao("2013zd.xls");
		List<Data2Dto> list = dao.getAllDataFromSheet(Data2Dto.class, 1, 1, 3);
		Map<String, Data2Dto> map = new HashMap<String, Data2Dto>();
		for (Data2Dto data2Dto : list) {
			Integer[] expand1 = new Integer[9];
			System.arraycopy(data2Dto.getFenxiao(), 0, expand1, 0, data2Dto.getFenxiao().length);
			data2Dto.setFenxiao(expand1);

			Integer[] expand2 = new Integer[9];
			System.arraycopy(data2Dto.getHeyue(), 0, expand2, 0, data2Dto.getHeyue().length);
			data2Dto.setHeyue(expand2);

			Integer[] expand3 = new Integer[9];
			System.arraycopy(data2Dto.getTotal(), 0, expand3, 0, data2Dto.getTotal().length);
			data2Dto.setTotal(expand3);

			map.put(data2Dto.getId(), data2Dto);
		}
		for(int i=2; i<=4; i++) {
			List<Data2Dto> allDtos = dao.getAllDataFromSheet(Data2Dto.class, i, 1, 2);
			for (Data2Dto data2Dto : allDtos) {
				if(!map.containsKey(data2Dto.getId())) {
					Data2Dto dto = new Data2Dto();
					dto.setId(data2Dto.getId());
					dto.setName(data2Dto.getName());
					dto.setFenxiao(new Integer[9]);
					dto.setHeyue(new Integer[9]);
					dto.setTotal(new Integer[9]);
					map.put(data2Dto.getId(), dto);
				}
				Data2Dto dto = map.get(data2Dto.getId());
				(dto.getFenxiao())[i+4] = (data2Dto.getFenxiao())[0];
				(dto.getHeyue())[i+4] = (data2Dto.getHeyue())[0];
				(dto.getTotal())[i+4] = (data2Dto.getTotal())[0];
			}
		}
		dao.close();
		ExcelOut out = new ExcelOut("2013zd-Ans.xls");
		out.writeSheet(Data2Dto.class, "1-9", 1, new ArrayList<Data2Dto>(map.values()));
		out.close();
//		Map<String, Data2Dto> allDatas = new HashMap<String, Data2Dto>();
//		for (Data2Dto data2Dto : data123) {
//			allDatas.put(data2Dto.getId(), data2Dto);
//		}
//		for (Data1Dto data1Dto : data4) {
//			if(allDatas.containsKey(data1Dto.getId())) {
//				Data2Dto dto = allDatas.get(data1Dto.getId());
//				dto.setHeyue4(data1Dto.getHeyue());
//				dto.setFenxiao4(data1Dto.getFenxiao());
//			} else {
//				Data2Dto dto = new Data2Dto();
//				dto.setId(data1Dto.getId());
//				dto.setName(data1Dto.getName());
//				dto.setArea(data1Dto.getArea());
//				dto.setType(data1Dto.getType());
//				dto.setHeyue1(-1);
//				dto.setFenxiao1(-1);
//				dto.setHeyue2(-1);
//				dto.setFenxiao2(-1);
//				dto.setHeyue3(-1);
//				dto.setFenxiao3(-1);
//				dto.setHeyue4(data1Dto.getHeyue());
//				dto.setFenxiao4(data1Dto.getFenxiao());
//				allDatas.put(dto.getId(), dto);
//			}
//		}
//
//		for (Data1Dto data1Dto : data5) {
//			if(allDatas.containsKey(data1Dto.getId())) {
//				Data2Dto dto = allDatas.get(data1Dto.getId());
//				if(dto.getType().trim().equals("空")) {
//					dto.setType(data1Dto.getType());
//				}
//				dto.setHeyue5(data1Dto.getHeyue());
//				dto.setFenxiao5(data1Dto.getFenxiao());
//			} else {
//				Data2Dto dto = new Data2Dto();
//				dto.setId(data1Dto.getId());
//				dto.setName(data1Dto.getName());
//				dto.setArea(data1Dto.getArea());
//				dto.setType(data1Dto.getType());
//				dto.setHeyue1(-1);
//				dto.setFenxiao1(-1);
//				dto.setHeyue2(-1);
//				dto.setFenxiao2(-1);
//				dto.setHeyue3(-1);
//				dto.setFenxiao3(-1);
//				dto.setHeyue4(-1);
//				dto.setFenxiao4(-1);
//				dto.setHeyue5(data1Dto.getHeyue());
//				dto.setFenxiao5(data1Dto.getFenxiao());
//				allDatas.put(dto.getId(), dto);
//			}
//		}
//		
//		Data2Out out = new Data2Out("ans.xls");
//		out.writeSheet("sheet1", 0, allDatas);
//		out.close();
	}

}
