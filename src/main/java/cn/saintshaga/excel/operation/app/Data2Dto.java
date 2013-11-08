package cn.saintshaga.excel.operation.app;

import java.util.Arrays;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class Data2Dto {

	@InputFieldProperty("营业厅名称")
	@OutputFieldProperty(title="Name",column=1)
	private String name;
	
	@InputFieldProperty("机构号")
	@OutputFieldProperty(title="ID",column=2)
	private String id;
		
	@InputFieldProperty("合约")
	@OutputFieldProperty(title="合约",column=3,delta=3)
	private Integer[] heyue;
	
	@InputFieldProperty("分销")
	@OutputFieldProperty(title="分销",column=4,delta=3)
	private Integer[] fenxiao;
	
	@InputFieldProperty("终端销量")
	@OutputFieldProperty(title="终端销量",column=5,delta=3)
	private Integer[] total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer[] getHeyue() {
		return heyue;
	}

	public void setHeyue(Integer[] heyue) {
		this.heyue = heyue;
	}

	public Integer[] getFenxiao() {
		return fenxiao;
	}

	public void setFenxiao(Integer[] fenxiao) {
		this.fenxiao = fenxiao;
	}

	public Integer[] getTotal() {
		return total;
	}

	public void setTotal(Integer[] total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Data2Dto [name=" + name + ", id=" + id + ", heyue="
				+ Arrays.toString(heyue) + ", fenxiao="
				+ Arrays.toString(fenxiao) + ", total="
				+ Arrays.toString(total) + "]";
	}


}
