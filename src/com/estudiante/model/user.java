package com.estudiante.model;

public class user {
	private int id;
	private double n1, n2, n3, n4;
	private String nombre;
	
	
	public int getid() {
		return id;
	}
	public void setid(int userid) {
		this.id = userid;
	}
	public double getn1() {
		return n1;
	}
	public void setn1(double n1) {
		this.n1 = n1;
	}
	public double getn2() {
		return n2;
	}
	public void setn2(double n2) {
		this.n2 = n2;
	}
	public double getn3() {
		return n3;
	}
	public void setn3(double n3) {
		this.n3 = n3;
	}
	public double getn4() {
		return n4;
	}
	public void setn4(double n4) {
		this.n4 = n4;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
public String toString() {
return "User [id=" + id + ", nombre=" + nombre + ", n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
		}
}
