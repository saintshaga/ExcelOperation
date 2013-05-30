package cn.saintshaga.ExcelOperation.utility;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelDao<T extends JXLDtoIO<T>> {

	protected Workbook book;
	protected Sheet sheet;
	protected int sheetNum;
	
	public ExcelDao(String filename) {
		try {
			book = Workbook.getWorkbook(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<T> getAllDataFromSheet(T t, int sheetIndex, int fromLine) {
		List<T> allDatas = new ArrayList<T>();
		if(sheetIndex<0 || sheetIndex>=book.getNumberOfSheets()) {
			throw new InvalidParameterException("sheet index out of bound");
		}
		try {
			sheet = book.getSheet(sheetIndex);
			int number = sheet.getRows();
			for(int i=fromLine; i<=number; i++) {
				T tmpT = t.inputDto(sheet.getRow(i-1));
				if(tmpT != null) {
					allDatas.add(tmpT);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allDatas;
	}
	
	public void close() {
		if(book != null) {
			book.close();
		}
	}
	
}
