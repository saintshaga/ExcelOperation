package cn.saintshaga.excel.operation.app.april;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

import com.google.common.base.Strings;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

public class Main {

	public static void main(String[] args) throws Exception {
		int numberInPlaceThresh = 150;
		int numberOfTypeThresh = 25;
		ExcelDao dao = new ExcelDao("/Users/saintshaga/workspace/ruby/1.xls");
		List<DataDto> allDatas = dao.getAllDataFromSheet(DataDto.class, 1, 1, 2);
		System.out.println(allDatas.size());
		dao.close();
		Table<String, String, List<DataDto>> table = HashBasedTable.create();
		for(DataDto dto : allDatas) {
			if(Strings.isNullOrEmpty(dto.getPlace()) || Strings.isNullOrEmpty(dto.getPinpai())) {
				continue;
			}
			if(!table.contains(dto.getPlace(), dto.getPinpai())) {
				table.put(dto.getPlace(), dto.getPinpai(), new ArrayList<DataDto>());
			}
			table.get(dto.getPlace(), dto.getPinpai()).add(dto);
		}
		List<DataDto> results = Lists.newArrayList();
		int numberOfPlaces = 0;
		for(String place : table.rowKeySet()) {
			Map<String, List<DataDto>> allInPlace = table.row(place);
			int numberInPlace = 0;
			for(String pinpai : allInPlace.keySet()) {
				numberInPlace += allInPlace.get(pinpai).size();
			}
			if(numberInPlace >= numberInPlaceThresh) {
				numberOfPlaces++;
				for(String pinpai : allInPlace.keySet()) {
					if(allInPlace.get(pinpai).size() >= numberOfTypeThresh) {
						results.addAll(allInPlace.get(pinpai));
					}
				}
			}
		}
		System.out.println("覆盖的乡镇数:" + numberOfPlaces);
		System.out.println("总共选中的条目数:" + results.size());
		ExcelOut out = new ExcelOut("/Users/saintshaga/workspace/ruby/out.xls");
		out.writeSheet(DataDto.class, "result", 1, results);
		out.close();
		System.out.println("end");

		for(int i=100; i<300; i+=10) {
			for(int j=10; j<50; j++) {
				
			}
		}
	}
	private String filter(Table<String, String, List<DataDto>> table, int placeThresh, int typeThresh) {
		int numberOfPlaces = 0;
		int total = 0;
		for(String place : table.rowKeySet()) {
			Map<String, List<DataDto>> allInPlace = table.row(place);
			int numberInPlace = 0;
			for(String pinpai : allInPlace.keySet()) {
				numberInPlace += allInPlace.get(pinpai).size();
			}
			if(numberInPlace >= placeThresh) {
				numberOfPlaces++;
				for(String pinpai : allInPlace.keySet()) {
					if(allInPlace.get(pinpai).size() >= typeThresh) {
						total += allInPlace.get(pinpai).size();
					}
				}
			}
		}
		return "" + numberOfPlaces + "," + total;
	}
}
