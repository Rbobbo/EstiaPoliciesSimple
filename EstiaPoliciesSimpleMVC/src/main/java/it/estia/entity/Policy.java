package it.estia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="policy", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Policy
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true, length=8)
	private int id;
	private int pasengernumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datestart;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datefinish;
	private String city;
	@Column(name="userid", nullable=false)
	private int userid;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPasengernumber() {
		return pasengernumber;
	}
	public void setPasengernumber(int pasengernumber) {
		this.pasengernumber = pasengernumber;
	}
	public Date getDatestart() {
		return datestart;
	}
	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}
	public Date getDatefinish() {
		return datefinish;
	}
	public void setDatefinish(Date datefinish) {
		this.datefinish = datefinish;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
