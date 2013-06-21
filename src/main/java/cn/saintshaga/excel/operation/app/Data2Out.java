package cn.saintshaga.excel.operation.app;

import jxl.write.Label;
import jxl.write.WritableSheet;
import cn.saintshaga.excel.operation.utility.AbsOut;

public class Data2Out extends AbsOut<Data2Dto>{

	public Data2Out(String filename) {
		super(filename);
	}

	private String int2str(int i) {
		return i<0?"空":(""+i);
	}
	protected void writeData(WritableSheet sheet, int lineNum, Data2Dto dto) {
		try {
			Label labelA = new Label(0, lineNum, dto.getId());
			Label labelB = new Label(1,lineNum,dto.getName());
			Label labelC = new Label(2,lineNum,dto.getArea());
			Label labelD = new Label(3,lineNum,dto.getType());
			Label labelE = new Label(4,lineNum,int2str(dto.getHeyue1()));
			Label labelF = new Label(5,lineNum,int2str(dto.getFenxiao1()));
			Label labelG = new Label(6,lineNum,int2str(dto.getHeyue1()+dto.getFenxiao1()));

			Label labelH = new Label(7,lineNum,int2str(dto.getHeyue2()));
			Label labelI = new Label(8,lineNum,int2str(dto.getFenxiao2()));
			Label labelJ = new Label(9,lineNum,int2str(dto.getHeyue2()+dto.getFenxiao2()));

			Label labelK = new Label(10,lineNum,int2str(dto.getHeyue3()));
			Label labelL = new Label(11,lineNum,int2str(dto.getFenxiao3()));
			Label labelM = new Label(12,lineNum,int2str(dto.getHeyue3()+dto.getFenxiao3()));
			
			Label labelN = new Label(13,lineNum,int2str(dto.getHeyue4()));
			Label labelO = new Label(14,lineNum,int2str(dto.getFenxiao4()));
			Label labelP = new Label(15,lineNum,int2str(dto.getHeyue4()+dto.getFenxiao4()));
			
			Label labelQ = new Label(16,lineNum,int2str(dto.getHeyue5()));
			Label labelR = new Label(17,lineNum,int2str(dto.getFenxiao5()));
			Label labelS = new Label(18,lineNum,int2str(dto.getHeyue5()+dto.getFenxiao5()));			
			
			
			sheet.addCell(labelA);
			sheet.addCell(labelB);
			sheet.addCell(labelC);
			sheet.addCell(labelD);
			sheet.addCell(labelE);
			sheet.addCell(labelF);
			sheet.addCell(labelG);
			sheet.addCell(labelH);
			sheet.addCell(labelI);
			sheet.addCell(labelJ);
			sheet.addCell(labelK);
			sheet.addCell(labelL);
			sheet.addCell(labelM);
			sheet.addCell(labelN);
			sheet.addCell(labelO);
			sheet.addCell(labelP);
			sheet.addCell(labelQ);
			sheet.addCell(labelR);
			sheet.addCell(labelS);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	protected int writeHeader(WritableSheet sheet){		

		return 2;
	}

}
