package loadingdata.ashish.myapplication;

import java.io.Serializable;

public class AtomPayment implements Serializable {


	
	private String name = "";

	public AtomPayment() {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpinner() {
		return spinner;
	}

	public void setSpinner(String spinner) {
		this.spinner = spinner;
	}

	private String address="";
	private String spinner="";




	public AtomPayment(String s, String s1, String s2) {
		this.name=s;
		this.address=s1;
		this.spinner=s2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}