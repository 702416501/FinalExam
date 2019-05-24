package app.LoanHelper;

import java.util.Date;

import org.apache.poi.ss.formula.functions.Finance;

public class Payment {
	
	private int PaymentID;
	private String DueDate;
	private double IPMT;
	private double PPMT;
	private double TotalPrinciple;
	private Loan L;
	private double Balance;
	private double AdditionalPayment;
	
	
	public Payment(int paymentID, String dueDate, double balance, Loan l) {
		super();
		this.L = l;
		PaymentID = paymentID;
		DueDate = dueDate;
		IPMT  = balance * (L.getInterestRate() / 12);
		PPMT = Math.abs(getPPMT());
		TotalPrinciple = PPMT + L.getExtraPayment();
		Balance = balance - TotalPrinciple;	
	}

	
	
	//get ppmt 
	
	public int getPaymentID() {
		return PaymentID;
	}



	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}



	public String getDueDate() {
		return DueDate;
	}



	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}



	public double getIPMT() {
		return IPMT;
	}



	public void setIPMT(double iPMT) {
		IPMT = iPMT;
	}



	public double getTotalPrinciple() {
		return TotalPrinciple;
	}



	public void setTotalPrinciple(double totalPrinciple) {
		TotalPrinciple = totalPrinciple;
	}



	public Loan getL() {
		return L;
	}



	public void setL(Loan l) {
		L = l;
	}



	public double getBalance() {
		return Balance;
	}



	public void setBalance(double balance) {
		Balance = balance;
	}



	public double getAdditionalPayment() {
		return AdditionalPayment;
	}



	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}



	public void setPPMT(double pPMT) { 
		PPMT = pPMT;
	}



	public double getPPMT() {
		return Finance.ppmt(this.L.getInterestRate()/12, this.PaymentID, (int) (this.L.getTerm()*12), this.L.getLoanAmount());
	}




	

	
}
