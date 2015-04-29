package cn.saintshaga.excel.operation.app.april.second;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;

public class Main {

	private static void setMap(Map<String, String> pinPaiMap, Map<String, String> typeMap) throws Exception {
		ExcelDao dao1 = new ExcelDao("/Users/saintshaga/workspace/ruby/map1.xls");
		List<DataDto> map1Datas = dao1.getAllDataFromSheet(DataDto.class, 1, 1, 2);
		dao1.close();
		ExcelDao dao2 = new ExcelDao("/Users/saintshaga/workspace/ruby/map2.xls");
		List<DataDto> map2Datas = dao2.getAllDataFromSheet(DataDto.class, 1, 1, 2);
		dao2.close();
		Map<String, DataDto> map1 = Maps.newHashMap();
		for(DataDto dto : map1Datas) {
			map1.put(dto.getSerialNumber1(), dto);
		}
		for(DataDto dto2 : map2Datas) {
			DataDto dto1 = map1.get(dto2.getSerialNumber1());
			if(dto1 == null) {
				System.out.println("Can not found in map1.xls:" + dto2);
				continue;
			}
			if(!dto1.getPinpai1().equals(dto2.getPinpai1())) {
				pinPaiMap.put(dto1.getPinpai1(), dto2.getPinpai1());
			}
			if(!dto1.getPinpai2().equals(dto2.getPinpai2())) {
				pinPaiMap.put(dto1.getPinpai2(), dto2.getPinpai2());
			}
			if(!dto1.getType1().equals(dto2.getType1())) {
				typeMap.put(dto1.getType1(), dto2.getType1());
			}
			if(!dto1.getType2().equals(dto2.getType2())) {
				typeMap.put(dto1.getType2(), dto2.getType2());
			}
		}
		writeMap2File("pinPaiMap.txt", pinPaiMap);
		writeMap2File("typeMap.txt", typeMap);
	}
	
	private static void writeMap2File(String fileName, Map<String, String> map) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/saintshaga/workspace/ruby/" + fileName)));
		for(Map.Entry<String, String> entry : map.entrySet()) {
			writer.write(entry.getKey() + "----" + entry.getValue());
			writer.newLine();
		}
		writer.close();
	}
	public static void main(String[] args) throws Exception {
		Map<String, String> pinPaiMap = Maps.newHashMap();
		Map<String, String> typeMap = Maps.newHashMap();
		setMap(pinPaiMap, typeMap);
		
		ExcelDao dao = new ExcelDao("/Users/saintshaga/workspace/ruby/src2.xls");
		List<DataDto> allDatas = dao.getAllDataFromSheet(DataDto.class, 1, 1, 2);
		dao.close();
//		dao = new ExcelDao("/Users/saintshaga/workspace/ruby/换机2.xls");
//		allDatas.addAll(dao.getAllDataFromSheet(DataDto.class, 1, 1, 2));
//		dao.close();
		List<DataDto> results = Lists.newArrayList();
		for(DataDto dto : allDatas) {
			if(!dto.getSerialNumber1().trim().equals(dto.getSerialNumber2().trim())) {
				dto.setType1(dto.getType1().replaceAll(" ", "").toUpperCase());
				dto.setType2(dto.getType2().replaceAll(" ", "").toUpperCase());
				if(Strings.isNullOrEmpty(dto.getType1()) || Strings.isNullOrEmpty(dto.getType2())) {
					continue;
				}
				dto.setType1(handleType(dto.getType1()));
				dto.setType2(handleType(dto.getType2()));
				results.add(dto);
			}
		}
		for(DataDto dto : results) {
			if(pinPaiMap.containsKey(dto.getPinpai1())) {
				dto.setPinpai1(pinPaiMap.get(dto.getPinpai1()));
			}
			if(pinPaiMap.containsKey(dto.getPinpai2())) {
				dto.setPinpai2(pinPaiMap.get(dto.getPinpai2()));
			}
			if(typeMap.containsKey(dto.getType1())) {
				dto.setType1(typeMap.get(dto.getType1()));
			}
			if(typeMap.containsKey(dto.getType2())) {
				dto.setType2(typeMap.get(dto.getType2()));
			}
		}
		ExcelOut tempOut = new ExcelOut("/Users/saintshaga/workspace/ruby/src2Handled.xls");
		tempOut.writeSheet(DataDto.class, "终端品牌和型号标准化版本", 1, results);
		tempOut.close();
		Multiset<DataDto> sets = HashMultiset.create(results);
		List<DataDto> results2 = Lists.newArrayList();
		for (DataDto dataDto : sets.elementSet()) {
			dataDto.setNumber(sets.count(dataDto));
			results2.add(dataDto);
		}
		ExcelOut out = new ExcelOut("/Users/saintshaga/workspace/ruby/src2result-品牌.xls");
		out.writeSheet(DataDto.class, "sheet1", 1, results2);
		out.close();
		System.out.println("the end");
	}

	private static String handleType(String type) {
		if(type == null) {
			return null;
		}
		String result = type.replaceAll(" ", "").toUpperCase();
		if(Strings.isNullOrEmpty(result)) {
			return result;
		}
		//delete -GK -ZB
		if(result.endsWith("-GK") || result.endsWith("-ZB")) {
			result = result.substring(0, result.length()-3);
		}
		//delete content inside of () and （）
		result = deleteInside(result, "(", ")");
		result = deleteInside(result, "（", "）");
		result = deleteInside(result, "[", "]");
//		int leftIndex = result.indexOf("(");
//		int rightIndex = result.indexOf(")");
//		if(leftIndex > 0 && rightIndex > 0) {
//			result = result.substring(0, leftIndex) + result.substring(rightIndex+1);
//		}
//		leftIndex = result.indexOf("（");
//		rightIndex = result.indexOf("）");
//		if(leftIndex > 0 && rightIndex > 0) {
//			result = result.substring(0, leftIndex) + result.substring(rightIndex+1);
//		}
		
		result = result.replaceAll("IPHONE", "");
		
		return result;
	}
	
	private static String deleteInside(String string, String left, String right) {
		if(Strings.isNullOrEmpty(string)) {
			return string;
		}
		int leftIndex = string.indexOf(left);
		int rightIndex = string.indexOf(right);
		if(leftIndex > 0 && rightIndex > 0) {
			string = string.substring(0, leftIndex) + string.substring(rightIndex+1);
		}
		return string;
	}
}
