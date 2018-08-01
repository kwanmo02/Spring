package kr.or.ddit.member.model;

public class MemberVo {
	
	private int mem_no;
	private String mem_id;
	private String pass;
	private String name;
	private String addr1;
	private String addr2;
	private String zipcd;
	private String pic;
	private String picpath;
	private String reg_dt;
	private int call_cnt;
	private String picname;
	
	
	
	
	public MemberVo() {
		
	}
	
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public int getCall_cnt() {
		return call_cnt;
	}
	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	
	@Override
	public String toString() {
		return "MemberVo [mem_no=" + mem_no + ", mem_id=" + mem_id + ", pass="
				+ pass + ", name=" + name + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", zipcd=" + zipcd + ", pic=" + pic + ", picpath="
				+ picpath + ", reg_dt=" + reg_dt + ", call_cnt=" + call_cnt
				+ ", picname=" + picname + "]";
	}
	
	

	public boolean validateUser(String memId, String pass){
		if(this.getMem_id().equals(memId) && this.getPass().equals(pass))
			return true;
		else
			return false;
	}
	
	
	
	
	public MemberVo(int mem_no, String mem_id, String pass, String name,
			String addr1, String addr2, String zipcd, String pic,
			String picpath, String reg_dt, int call_cnt, String picname) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.pass = pass;
		this.name = name;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcd = zipcd;
		this.pic = pic;
		this.picpath = picpath;
		this.reg_dt = reg_dt;
		this.call_cnt = call_cnt;
		this.picname = picname;
	}
	
	
	
	
	
}
