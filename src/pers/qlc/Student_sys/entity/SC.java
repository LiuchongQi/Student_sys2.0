package pers.qlc.Student_sys.entity;

public class SC {
	private String Sno;
	private String Cno;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	@Override
	public String toString() {
		return "SC [Sno=" + Sno + ", Cno=" + Cno + "]";
	}
	
}
