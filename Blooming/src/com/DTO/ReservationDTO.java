package com.DTO;

public class ReservationDTO {

	
	private int res_num;
	private String nickname;
	private String res_date;
	private String consultant;
	private String pro_email;
	
	
	public ReservationDTO() {
		super();
	}
	
	public ReservationDTO(int res_num, String nickname, String res_date, String consultant, String pro_email) {
		super();
		this.res_num = res_num;
		this.nickname = nickname;
		this.res_date = res_date;
		this.consultant = consultant;
		this.pro_email = pro_email;
	}

	
	public String getPro_email() {
		return pro_email;
	}

	public void setPro_email(String pro_email) {
		this.pro_email = pro_email;
	}

	public int getRes_num() {
		return res_num;
	}

	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}
	
	
	
}
