package controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {
	
	@DateTimeFormat(pattern="yyyyMMddHH")	
	private Date from;
	@DateTimeFormat(pattern="yyyyMMddHH")
	private Date to;
	//@DateTimeFormat을 사용해 형식을 지정하면 문자열이 입력되어 들어왔을경우 그 문자열을 Date타입으로 변환시켜줌
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
}
