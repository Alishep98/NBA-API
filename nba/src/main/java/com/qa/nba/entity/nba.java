package com.qa.nba.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class nba {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Min(0)
	@Max(45)
	private int age;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	
	private int ppg;
	
	@Column
	private int rpg;
	
	@Column
	private int apg;
	
	public nba() {}
	
	public nba(@Min(0) @Max(45) int age, String name, int ppg, int rpg, int apg) {
		super();
		this.age = age;
		this.name = name;
		this.ppg = ppg;
		this.rpg = rpg;
		this.apg=apg;
	}
	
	public nba(long id, @Min(0) @Max(45) int age, String name, int ppg, int rpg, int apg) {
		super();
		this.id=id;
		this.age = age;
		this.name = name;
		this.ppg = ppg;
		this.rpg = rpg;
		this.apg=apg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPpg() {
		return ppg;
	}

	public void setPpg(int ppg) {
		this.ppg = ppg;
	}

	public int getRpg() {
		return rpg;
	}

	public void setRpg(int rpg) {
		this.rpg = rpg;
	}

	public int getApg() {
		return apg;
	}

	public void setApg(int apg) {
		this.apg = apg;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", age=" + age + ", name=" + name + ", ppg=" + ppg + ", rpg=" + rpg + ", apg=" + apg
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, ppg, rpg, apg, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		nba other = (nba) obj;
		return age == other.age && Objects.equals(ppg, other.ppg) && Objects.equals(rpg, other.rpg) && Objects.equals(apg, other.apg)
			 && Objects.equals(name, other.name);
	}
}
