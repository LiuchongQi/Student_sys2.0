package pers.qlc.Student_sys.entity;

public class Teacher {
	private String Username;
	private String Password;
	private String Tname;
	private String Tsex;
	private int Tage;
	private String Tjob;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTsex() {
		return Tsex;
	}
	public void setTsex(String tsex) {
		Tsex = tsex;
	}
	public int getTage() {
		return Tage;
	}
	public void setTage(int tage) {
		Tage = tage;
	}
	public String getTjob() {
		return Tjob;
	}
	public void setTjob(String tjob) {
		Tjob = tjob;
	}
	@Override
	public String toString() {
		return "Teacher [Username=" + Username + ", Password=" + Password + ", Tname=" + Tname + ", Tsex=" + Tsex
				+ ", Tage=" + Tage + ", Tjob=" + Tjob + "]";
	}

}
