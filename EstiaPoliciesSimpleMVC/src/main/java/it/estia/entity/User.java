package it.estia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name ="user",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true, length=8)
	private int id;
	@Column(length = 50)
	private String logincode;
	@Column(length = 8)
	private String loginpassword;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String surname;
	@Column(length = 255)
	private String address;
	@Column(length = 16)
	private String taxcode;
	@Column(name="role")
	private String role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogincode() {
		return logincode;
	}
	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTaxcode() {
		return taxcode;
	}
	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
