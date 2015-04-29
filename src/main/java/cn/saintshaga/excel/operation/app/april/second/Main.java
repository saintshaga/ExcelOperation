package cn.saintshaga.excel.operation.app.april.second;

import java.util.List;

import cn.saintshaga.excel.operation.library.ExcelDao;
import cn.saintshaga.excel.operation.library.ExcelOut;

import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class Main {

	public static void main(String[] args) throws Exception {
		ExcelDao dao = new ExcelDao("/Users/saintshaga/workspace/ruby/src2.xls");
		List<DataDto> allDatas = dao.getAllDataFromSheet(DataDto.class, 1, 1, 2);
		dao.close();
//		dao = new ExcelDao("/Users/saintshaga/workspace/ruby/换机2.xls");
//		allDatas.addAll(dao.getAllDataFromSheet(DataDto.class, 1, 1, 2));
//		dao.close();
		List<DataDto> results = Lists.newArrayList();
		ExcelOut out = new ExcelOut("/Users/saintshaga/workspace/ruby/result2.xls");
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
		Multiset<DataDto> sets = HashMultiset.create(results);
		List<DataDto> results2 = Lists.newArrayList();
		for (DataDto dataDto : sets.elementSet()) {
			dataDto.setNumber(sets.count(dataDto));
			results2.add(dataDto);
		}
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
