package com.mypractice.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	@Id
	private int proid;
	private String proname;
	@ManyToMany(targetEntity = Programmer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projects")
	private Set<Programmer> programmers = new HashSet<Programmer>();

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public Set<Programmer> getProgrammers() {
		return programmers;
	}

	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}

	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname + "]";
	}

}
