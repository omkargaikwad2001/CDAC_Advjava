package entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emp")
@NamedQuery(name = "getempsfromdept", query = "select empno, ename from Emp where deptno = :dno")
public class Emp {
	
	@Id
	@Column(name = "EMPNO")
	Integer empno;

	@Column(name = "ENAME")
	String ename;
	
	@Column(name = "JOB")
	String job;
	
	@Column(name = "MGR")
	Integer mgr;
	
	@Column(name = "HIREDATE")
	Date hiredate;
	
	@Column(name = "SAL")
	Float sal;
	
	@Column(name = "COMM")
	Float comm;
	
	@Column(name = "DEPTNO")
	Integer deptno;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Float sal, Float comm,
			Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	public Float getComm() {
		return comm;
	}

	public void setComm(Float comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

}
