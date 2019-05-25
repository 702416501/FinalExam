package app.LoanHelper;

import java.text.ParseException;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import org.apache.commons.lang3.time.DateUtils;

public class Loan {
	
	private double LoanAmount;
	private double InterestRate;
	private int Term;
	private double ExtraPayment;
	private boolean Compounds;
	private double FV;
	private String StartDate;
	
	private LinkedList<Payment> LoanPayments = new LinkedList<Payment>();
	
	
	
	public Loan(double loanAmount, double interestRate, 
			int term, double extraPayment, 
			boolean compounds, double fV) throws ParseException {
		super();
		
		StartDate =  "2019-06-01"  ;
		LoanAmount = loanAmount;
		InterestRate = interestRate;
		Term = term;
		ExtraPayment = extraPayment;
		Compounds = compounds;
		FV = fV;
		
		
		int PaymentNbr = 0;
		double dRollingBalance = this.LoanAmount;
		String dRollingDueDate = this.StartDate;
				
		
		
		
		do 
		{
			Payment p = new Payment(++PaymentNbr, dRollingDueDate, dRollingBalance, this);
			this.LoanPayments.add(p); 
			dRollingBalance = p.getBalance();
			dRollingDueDate = addOneMonthApacheCommons(dRollingDueDate);
			
			if (dRollingBalance <= 0)
			{
				this.LoanPayments.getLast().setBalance(0);	
				break;
			}
			
		} while (true);
		
		
		
		
	}
	public double getLoanAmount() {
		return LoanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	public double getTerm() {
		return Term;
	}
	public void setTerm(int term) {
		Term = term;
	}
	public double getExtraPayment() {
		return ExtraPayment;
	}
	public void setExtraPayment(double extraPayment) {
		ExtraPayment = extraPayment;
	}
	public boolean getCompounds() {
		return Compounds;
	}
	public void setCompounds(boolean compounds) {
		Compounds = compounds;
	}
	public double getFV() {
		return FV;
	}
	public void setFV(double fV) {
		FV = fV;
	}
	
	
	private  static String addOneMonthApacheCommons(String date) throws ParseException {

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date incrementedDate = DateUtils.addMonths(sdf.parse(date), 1);
       return sdf.format(incrementedDate);
       }
       
	
}

