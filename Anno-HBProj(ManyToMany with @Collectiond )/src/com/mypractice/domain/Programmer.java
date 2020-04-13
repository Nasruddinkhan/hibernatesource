package com.mypractice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="programmers")
public class Programmer {
	@Id
	private int pid;
	private String pname;
	private long salary;
	@ManyToMany(targetEntity = Project.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "programmers_projects", joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "pid") , inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "proid") )
	@CollectionId(columns=@Column(name="prgmr_proj_indx"),
	              type=@Type(type = "int"),
	              generator="gen1"
	             )
	@GenericGenerator(name="gen1",strategy="increment")
	private List<Project> projects = new ArrayList<Project>();

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Programmer [pid=" + pid + ", pname=" + pname + ", salary=" + salary + "]";
	}

}
