package pers.qlc.Student_sys.entity;

public class Course {
	private String Cno;
	private String Cname;
	private String Tno;
	private String Cday;
	private String Ctime;
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getCday() {
		return Cday;
	}
	public void setCday(String cday) {
		Cday = cday;
	}
	public String getCtime() {
		return Ctime;
	}
	public void setCtime(String ctime) {
		Ctime = ctime;
	}
	@Override
	public String toString() {
		return "Course [Cno=" + Cno + ", Cname=" + Cname + ", Tno=" + Tno + ", Cday=" + Cday + ", Ctime=" + Ctime + "]";
	}
	
}	
