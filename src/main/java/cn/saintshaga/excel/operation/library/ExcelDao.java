package cn.saintshaga.excel.operation.library;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelDao {

	protected Workbook book;	
	public ExcelDao(String filename) {
		try {
			book = Workbook.getWorkbook(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T> List<T> getAllDataFromSheet(Class<T> cls, int sheetIndex, int titleLine,int fromLine) throws Exception{
		List<T> allDatas = new ArrayList<T>();
		if(sheetIndex < 1 || sheetIndex > book.getNumberOfSheets()) {
			throw new InvalidParameterException("sheet index out of bound");
		}
		try {
			Sheet sheet = book.getSheet(sheetIndex-1);
			int number = sheet.getRows();
			if(titleLine < 1 || titleLine > number || fromLine < 1 || fromLine > number) {
				throw new InvalidParameterException("line number should be in 1~"+number);
			}
			Field[] fields = cls.getDeclaredFields();
			Map<Field, List<Integer>> colMap = findColumn(sheet, titleLine, fields);
			
			for(int i=fromLine; i<=number; i++) {
				Cell[] cells = sheet.getRow(i-1);
				T t = cls.newInstance();
				for (Field field : fields) {
					if(field.isAnnotationPresent(InputFieldProperty.class)) {
						Class<?> type = field.getType();
						if(!type.isArray()) {
							Cell cell = cells[colMap.get(field).get(0)];
							fillField(t, cell, field);
						} else {
							List<Integer> cols = colMap.get(field);
							fillArray(t,field,cells,cols);
						}
					}
				}
				allDatas.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allDatas;
	}
	
	private <T> void fillArray(T t, Field field, Cell[] cells, List<Integer> cols) throws Exception{
		Class<?> type = field.getType().getComponentType();
		Object[] arrays = (Object[])Array.newInstance(type, cols.size());
		for(int i=0; i<arrays.length; i++) {
			Cell cell = cells[cols.get(i)];
			String content = cell.getContents().trim();
			if(type == Integer.class) {
				if(content.equals("")) {
					arrays[i] = null;
				} else if (cell.getType() == CellType.NUMBER) {
					arrays[i] = Integer.valueOf((int)((NumberCell)cell).getValue());
				} else {
					arrays[i] = Integer.valueOf(content);
				}
			} else if (type == Double.class) {
				if(content.equals("")) {
					arrays[i] = null;
				} else if (cell.getType() == CellType.NUMBER) {
					arrays[i] = Double.valueOf(((NumberCell)cell).getValue());
				} else {
					arrays[i] = Double.valueOf(content);
				}
			} else if (type == String.class) {
				arrays[i] = content;
			} else {
				throw new UnsupportedOperationException("Unsupported array of type " + type.getCanonicalName());
			}
		}
		field.set(t, arrays);
	}
	
//	private <T> void fillArray(T t, Field field, Cell[] cells, List<Integer> cols) throws Exception{
//		Class<?> type = field.getType().getComponentType();
//		if(type == Integer.class) {
//			Integer[] integers = new Integer[cols.size()];
//			for(int i=0; i<integers.length; i++) {
//				Cell cell = cells[cols.get(i)];
//				String content = cell.getContents().trim();
//				if(content.equals("")) {
//					integers[i] = null;
//				} else if (cell.getType() == CellType.NUMBER) {
//					integers[i] = (int)((NumberCell)cell).getValue();
//				} else {
//					integers[i] = Integer.valueOf(content);
//				}
//			}
//			field.set(t, integers);
//		} else if (type == Double.class) {
//			Double[] doubles = new Double[cols.size()];
//			for(int i=0; i<doubles.length; i++) {
//				Cell cell = cells[cols.get(i)];
//				String content = cell.getContents().trim();
//				if(content.equals("")) {
//					doubles[i] = null;
//				} else if (cell.getType() == CellType.NUMBER) {
//					doubles[i] = ((NumberCell)cell).getValue();
//				} else {
//					doubles[i] = Double.valueOf(content);
//				}
//			}
//			field.set(t, doubles);
//		} else if (type == String.class) {
//			String[] strings = new String[cols.size()];
//			for(int i=0; i<strings.length; i++) {
//				strings[i] = cells[cols.get(i)].getContents().trim();
//			}
//			field.set(t, strings);
//		} else {
//			throw new UnsupportedOperationException("Unsupported array of type " + type.getCanonicalName());
//		}
//	}
	
	private <T> void fillField(T t, Cell cell, Field field) throws Exception{
		Class<?> type = field.getType();
		String content = cell.getContents().trim();
		String numberContent = content.equals("")?"0":content;
		if(type == int.class) {
			if(cell.getType() == CellType.NUMBER) {
				field.setInt(t, (int)((NumberCell)cell).getValue());
			} else {
				field.setInt(t, Integer.valueOf(numberContent));
			}
		} else if (type == Integer.class) {
			if(cell.getType() == CellType.NUMBER) {
				field.set(t, Integer.valueOf((int)((NumberCell)cell).getValue()));
			} else if (content.equals("")) {
				field.set(t, null);
			} else{
				field.set(t, Integer.valueOf(content));
			}
		} else if (type == long.class) {
			if(cell.getType() == CellType.NUMBER) {
				field.setLong(t, (long)((NumberCell)cell).getValue());
			} else {
				field.setLong(t, Long.valueOf(numberContent));
			}
		} else if (type == float.class) {
			if(cell.getType() == CellType.NUMBER) {
				field.setFloat(t, (float)((NumberCell)cell).getValue());
			} else {
				field.setFloat(t, Float.valueOf(numberContent));
			}
		} else if (type == double.class) {
			if(cell.getType() == CellType.NUMBER) {
				field.setDouble(t, ((NumberCell)cell).getValue());
			} else {
				field.setDouble(t, Double.valueOf(numberContent));
			}
		} else if (type == Double.class) {
			if(cell.getType() == CellType.NUMBER) {
				field.set(t, Double.valueOf(((NumberCell)cell).getValue()));
			} else if (content.equals("")) {
				field.set(t, null);
			} else {
				field.set(t, Double.valueOf(content));
			}
		} else if (type == boolean.class) {
			if(cell.getType() == CellType.BOOLEAN) {
				field.setBoolean(t, ((BooleanCell)cell).getValue());
			} else {
				field.setBoolean(t, Boolean.valueOf(content));
			}
		} else if (type == String.class) {
			field.set(t, content);
		} else {
			throw new UnsupportedOperationException("Unsupported type to get from excel:" + 
							type.getCanonicalName());
		}
		
	}
	//get column index according to the column name
	private <T> Map<Field, List<Integer>> findColumn(Sheet sheet, int titleLine, Field[] fields) {
		Map<Field, List<Integer>> retMap = new HashMap<Field, List<Integer>>();
		Map<String, List<Integer>> cellMap = new HashMap<String, List<Integer>>();
		Cell[] cells = sheet.getRow(titleLine-1);
		for (int i=0; i<cells.length; i++) {
			String key = cells[i].getContents().trim();
			if(cellMap.containsKey(key)) {
				cellMap.get(key).add(Integer.valueOf(i));
			} else {
				List<Integer> value = new ArrayList<Integer>();
				value.add(Integer.valueOf(i));
				cellMap.put(key, value);
			}
		}
		for (Field field : fields) {
			if(field.isAnnotationPresent(InputFieldProperty.class)) {
				field.setAccessible(true);
				List<Integer> cols = cellMap.get(field.getAnnotation(InputFieldProperty.class).value());
				if(cols == null) {
					throw new RuntimeException("There is no column name called " + 
										field.getAnnotation(InputFieldProperty.class).value() + 
										", in field " + field.getName());
				}
				retMap.put(field, cols);
			}
		}
		return retMap;
		
	}
	
	public void close() {
		if(book != null) {
			book.close();
		}
	}
	
}
