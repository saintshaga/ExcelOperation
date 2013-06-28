package cn.saintshaga.excel.operation.library;

import java.io.File;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelOut {

	protected WritableWorkbook book;
	
	public ExcelOut(String filename) throws Exception{
		book = Workbook.createWorkbook(new File(filename));
	}
	
	public <T> void writeSheet(Class<T> cls, String sheetName, int sheetNum, List<T> datas) throws Exception {
		if(sheetNum < 1) {
			throw new InvalidParameterException("sheet numnber should be larger than 0.");
		}
		WritableSheet sheet = book.createSheet(sheetName, sheetNum-1);
		Field[] fields = cls.getDeclaredFields();
		int i = writeHeader(fields,sheet);
		for (T t : datas) {
			writeLine(t,i,fields,sheet);
			i++;
		}
		book.write();
	}
	
	private <T> void writeLine(T t, int lineNumber, Field[] fields, WritableSheet sheet) throws Exception {
		for (Field field : fields) {
			if (field.isAnnotationPresent(OutputFieldProperty.class)) {
				field.setAccessible(true);
				OutputFieldProperty property = field.getAnnotation(OutputFieldProperty.class);
				if(!field.getType().isArray()) {
					Label label = new Label(property.column()-1,lineNumber,field.get(t).toString());
					sheet.addCell(label);
				} else {
					Object[] arrays = (Object[])field.get(t);
					for(int i=0; i<arrays.length; i++) {
						int column = (property.column()-1) + i*property.delta();
						Label label = new Label(column, lineNumber, arrays[i].toString());
						sheet.addCell(label);
					}
				}
			}
		}
	}
	
	private <T> int writeHeader(Field[] fields, WritableSheet sheet) throws Exception{
		for (Field field : fields) {
			if(field.isAnnotationPresent(OutputFieldProperty.class)) {
				field.setAccessible(true);
				OutputFieldProperty property = field.getAnnotation(OutputFieldProperty.class);
				if(!field.getType().isArray()) {
					Label label = new Label(property.column()-1, 0, property.title());
					sheet.addCell(label);
				} else {
					Label label = new Label(property.column()-1, 0, property.title());
					sheet.addCell(label);
				}
			}
		}
		return 1;
	}
	
	public void close() throws Exception{
		if(book != null) {
			book.close();
		}
	}
}
