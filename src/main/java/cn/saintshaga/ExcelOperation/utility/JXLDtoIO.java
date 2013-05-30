package cn.saintshaga.ExcelOperation.utility;

import java.util.List;

import jxl.Cell;
import jxl.write.Label;

public interface JXLDtoIO<T> {
	public T inputDto(Cell[] cells);
	public List<Label> outputDto(T t);
}
