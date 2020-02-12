package pers.qlc.Student_sys.entity;

public class Student {
	private String Username;
	private String Password;
	private String Sname;
	private String Ssex;
	private int Sage;
	private String Sdept;
	private String Sclass;
	private String Grade;
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
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public int getSage() {
		return Sage;
	}
	public void setSage(int sage) {
		Sage = sage;
	}
	public String getSdept() {
		return Sdept;
	}
	public void setSdept(String sdept) {
		Sdept = sdept;
	}
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		Sclass = sclass;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		return "Student [Username=" + Username + ", Password=" + Password + ", Sname=" + Sname + ", Ssex=" + Ssex
				+ ", Sage=" + Sage + ", Sdept=" + Sdept + ", Sclass=" + Sclass + ", Grade=" + Grade + "]";
	}
	
}
