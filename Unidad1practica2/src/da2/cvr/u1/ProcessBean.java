package da2.cvr.u1;

import java.io.Serializable;

public class ProcessBean implements Serializable {
	double valuea;
	double valueb;
	
	
	
	public ProcessBean() {
		super();
		this.valuea = valuea;
		this.valueb = valueb;
	}
	
	public double getValuea() {
		return valuea;
	}
	public void setValuea(double valuea) {
		this.valuea = valuea;
	}
	public double getValueb() {
		return valueb;
	}
	public void setValueb(double valueb) {
		this.valueb = valueb;
	}
	
	public double getResult() {
		return ((5*valuea)+(7*valueb)-3)+((3*valueb)-(2*valuea)+9);
	}
	
	
}
