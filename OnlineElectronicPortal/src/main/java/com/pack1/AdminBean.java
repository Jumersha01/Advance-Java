package com.pack1;

import java.io.Serializable;

public class AdminBean  implements Serializable{
  private String a_name,a_pwd,a_fname,a_lname,a_mail,_a_addr,a_phone;

  public String getA_name() {
	return a_name;
  }

  public void setA_name(String a_name) {
	this.a_name = a_name;
  }

  public String getA_pwd() {
	return a_pwd;
  }

  public void setA_pwd(String a_pwd) {
	this.a_pwd = a_pwd;
  }

  public String getA_fname() {
	return a_fname;
  }

  public void setA_fname(String a_fname) {
	this.a_fname = a_fname;
  }

  public String getA_lname() {
	return a_lname;
  }

  public void setA_lname(String a_lname) {
	this.a_lname = a_lname;
  }

  public String getA_mail() {
	return a_mail;
  }

  public void setA_mail(String a_mail) {
	this.a_mail = a_mail;
  }

  public String get_a_addr() {
	return _a_addr;
  }

  public void set_a_addr(String _a_addr) {
	this._a_addr = _a_addr;
  }

  public String getA_phone() {
	return a_phone;
  }

  public void setA_phone(String a_phone) {
	this.a_phone = a_phone;
  }
  
}
