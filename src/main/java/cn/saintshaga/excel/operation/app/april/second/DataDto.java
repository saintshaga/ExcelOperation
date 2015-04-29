package cn.saintshaga.excel.operation.app.april.second;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class DataDto {

	
	@InputFieldProperty("时间")
	@OutputFieldProperty(title="时间", column=1)
	private String time;

	@InputFieldProperty("串号1")
	@OutputFieldProperty(title="串号1", column=2)
	private String serialNumber1;
	
	@InputFieldProperty("终端品牌1")
	@OutputFieldProperty(title="终端品牌1", column=3)
	private String pinpai1;
	
	@InputFieldProperty("终端机型1")
	@OutputFieldProperty(title="终端机型1", column=4)
	private String type1;
	
//	@InputFieldProperty("价格1")
	@OutputFieldProperty(title="价格1", column=5)
	private String price1;
	
	@InputFieldProperty("销售方式1")
	@OutputFieldProperty(title="销售方式1", column=6)
	private String way1;
	
	@InputFieldProperty("营销案1")
	@OutputFieldProperty(title="营销案1", column=7)
	private String an1;
	
	@InputFieldProperty("串号2")
	@OutputFieldProperty(title="串号2", column=8)
	private String serialNumber2;
	
	@InputFieldProperty("终端品牌2")
	@OutputFieldProperty(title="终端品牌2", column=9)
	private String pinpai2;
	
	@InputFieldProperty("终端机型2")
	@OutputFieldProperty(title="终端机型2", column=10)
	private String type2;
	
//	@InputFieldProperty("价格2")
	@OutputFieldProperty(title="价格2", column=11)
	private String price2;
	
	@InputFieldProperty("销售方式2")
	@OutputFieldProperty(title="销售方式2", column=12)
	private String way2;
	
	@InputFieldProperty("营销案2")
	@OutputFieldProperty(title="营销案2", column=13)
	private String an2;
	
//	@InputFieldProperty("数量")
	@OutputFieldProperty(title="数量", column=14)
	private Integer number;
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSerialNumber1() {
		return serialNumber1;
	}

	public void setSerialNumber1(String serialNumber1) {
		this.serialNumber1 = serialNumber1;
	}

	public String getPinpai1() {
		return pinpai1;
	}

	public void setPinpai1(String pinpai1) {
		this.pinpai1 = pinpai1;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getWay1() {
		return way1;
	}

	public void setWay1(String way1) {
		this.way1 = way1;
	}

	public String getAn1() {
		return an1;
	}

	public void setAn1(String an1) {
		this.an1 = an1;
	}

	public String getSerialNumber2() {
		return serialNumber2;
	}

	public void setSerialNumber2(String serialNumber2) {
		this.serialNumber2 = serialNumber2;
	}

	public String getPinpai2() {
		return pinpai2;
	}

	public void setPinpai2(String pinpai2) {
		this.pinpai2 = pinpai2;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getWay2() {
		return way2;
	}

	public void setWay2(String way2) {
		this.way2 = way2;
	}

	public String getAn2() {
		return an2;
	}

	public void setAn2(String an2) {
		this.an2 = an2;
	}

	@Override
	public String toString() {
		return "DataDto [time=" + time + ", serialNumber1=" + serialNumber1
				+ ", pinpai1=" + pinpai1 + ", type1=" + type1 + ", price1="
				+ price1 + ", way1=" + way1 + ", an1=" + an1
				+ ", serialNumber2=" + serialNumber2 + ", pinpai2=" + pinpai2
				+ ", type2=" + type2 + ", price2=" + price2 + ", way2=" + way2
				+ ", an2=" + an2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
//		result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
//		result = prime * result + ((way1 == null) ? 0 : way1.hashCode());
//		result = prime * result + ((way2 == null) ? 0 : way2.hashCode());
		result = prime * result + ((pinpai1 == null) ? 0 : pinpai1.hashCode());
		result = prime * result + ((pinpai2 == null) ? 0 : pinpai2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataDto other = (DataDto) obj;
//		if (an1 == null) {
//			if (other.an1 != null)
//				return false;
//		} else if (!an1.equals(other.an1))
//			return false;
//		if (an2 == null) {
//			if (other.an2 != null)
//				return false;
//		} else if (!an2.equals(other.an2))
//			return false;
//		if (type1 == null) {
//			if (other.type1 != null)
//				return false;
//		} else if (!type1.equals(other.type1))
//			return false;
//		if (type2 == null) {
//			if (other.type2 != null)
//				return false;
//		} else if (!type2.equals(other.type2))
//			return false;
//		if (way1 == null) {
//			if (other.way1 != null)
//				return false;
//		} else if (!way1.equals(other.way1))
//			return false;
//		if (way2 == null) {
//			if (other.way2 != null)
//				return false;
//		} else if (!way2.equals(other.way2))
//			return false;
		if (pinpai1 == null) {
			if (other.pinpai1 != null)
				return false;
		} else if (!pinpai1.equals(other.pinpai1))
			return false;
		if (pinpai2 == null) {
			if (other.pinpai2 != null)
				return false;
		} else if (!pinpai2.equals(other.pinpai2))
			return false;
		return true;
	}
	
	
}
