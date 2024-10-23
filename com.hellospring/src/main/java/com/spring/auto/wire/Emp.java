package com.spring.auto.wire;

public class Emp {

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("By Setter");
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Address address) {
		System.out.println("By Constructor");
		
		this.address = address;
	}
	

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}

	
//	
}
