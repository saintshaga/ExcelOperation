package cn.saintshaga.excel.operation.utility;

import java.io.File;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public abstract class AbsOut<T> {
	protected WritableWorkbook book;
	
	public AbsOut(String filename) {
		try {
			book = Workbook.createWorkbook(new File(filename));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeSheet(String sheetName, int sheetNum, Map<String, T> source) {
		try {
			WritableSheet sheet = book.createSheet(sheetName, sheetNum);
			int i = writeHeader(sheet);
			for(Map.Entry<String, T> entry : source.entrySet()) {
				writeData(sheet,i,entry.getValue());
				i++;
			}
			book.write();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void writeData(WritableSheet sheet, int lineNum, T t) {
		try {
			Label labelA = new Label(0, 0, "data1");
			Label labelB = new Label(1,0,"data2");
			Label labelC = new Label(2,0,"data3");
			Label labelD = new Label(3,0,"data4");
			Label labelE = new Label(4,0,"data5");
			sheet.addCell(labelA);
			sheet.addCell(labelB);
			sheet.addCell(labelC);
			sheet.addCell(labelD);
			sheet.addCell(labelE);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	protected int writeHeader(WritableSheet sheet){		
		try {
			Label labelA = new Label(0, 0, "title1");
			Label labelB = new Label(1,0,"title2");
			Label labelC = new Label(2,0,"title3");
			Label labelD = new Label(3,0,"title4");
			Label labelE = new Label(4,0,"title5");
			sheet.addCell(labelA);
			sheet.addCell(labelB);
			sheet.addCell(labelC);
			sheet.addCell(labelD);
			sheet.addCell(labelE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public void close() {
		if(book != null) {
			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
