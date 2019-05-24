package pkgUT;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import app.LoanHelper.Loan;

public class LoanTest {

	@Test
	public void LoanTest1() throws ParseException {
		
		double loanAmount = 100000;
		double interestRate = 0.07;
		int term = 20;
		double extraPayment = 100;
		boolean compounds = false; 
		double fV = 0;
		
		
		Loan L = new Loan(loanAmount, interestRate, term, extraPayment, compounds, fV);
		
		
		
	}

}
