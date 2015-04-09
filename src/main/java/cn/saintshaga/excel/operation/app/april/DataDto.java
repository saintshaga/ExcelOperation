package cn.saintshaga.excel.operation.app.april;

import cn.saintshaga.excel.operation.library.InputFieldProperty;
import cn.saintshaga.excel.operation.library.OutputFieldProperty;

public class DataDto {

	@InputFieldProperty("IMEI")
	@OutputFieldProperty(title="IMEI",column=1)
	private String imei;

	@InputFieldProperty("品牌")
	@OutputFieldProperty(title="品牌",column=2)
	private String pinpai;

	@InputFieldProperty("型号")
	@OutputFieldProperty(title="型号",column=3)
	private String xinhao;

	@InputFieldProperty("制式")
	@OutputFieldProperty(title="制式",column=4)
	private String zhishi;

	@InputFieldProperty("最近使用的号码")
	@OutputFieldProperty(title="最近使用的号码",column=5)
	private String number;

	@InputFieldProperty("通话区域")
	@OutputFieldProperty(title="通话区域",column=6)
	private String area;

	@InputFieldProperty("通话乡镇")
	@OutputFieldProperty(title="通话乡镇",column=7)
	private String place;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}

	public String getXinhao() {
		return xinhao;
	}

	public void setXinhao(String xinhao) {
		this.xinhao = xinhao;
	}

	public String getZhishi() {
		return zhishi;
	}

	public void setZhishi(String zhishi) {
		this.zhishi = zhishi;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "DataDto [imei=" + imei + ", pinpai=" + pinpai + ", xinhao="
				+ xinhao + ", zhishi=" + zhishi + ", number=" + number
				+ ", area=" + area + ", place=" + place + "]";
	}
}
