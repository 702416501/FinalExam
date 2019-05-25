package app.controller;

import app.StudentCalc;
import app.LoanHelper.Loan;
import javafx.fxml.FXML; 
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private TextField AdditionalPayment;
	

	@FXML
	private TableColumn<String,Double> PPMT;
	
	@FXML
	private TableColumn<String,Double> IPMT;
	
	@FXML
	private TableColumn<String,Double> Balance;
	
	@FXML
	private TableColumn<String,String> DueDate;
	
	@FXML
	private TableColumn<String,Double> ExtraPayment;
	
	@FXML
	private TableColumn<String,Integer> PaymentID;
	
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		System.out.println("Amount: " + InterestRate.getText());
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		System.out.println("Amount: " + dInterestRate);	
		lblTotalPayemnts.setText("123");
		
		System.out.println("Amount: " + NbrOfYears.getText());
		int dNbrOfYears = Integer.parseInt(NbrOfYears.getText());
		System.out.println("Amount: " + dNbrOfYears);	
		
		System.out.println("Amount: " + AdditionalPayment.getText());
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
		
		Loan(dLoanAmount, dInterestRate, dNbrOfYears, dAdditionalPayment, true, 0);
		
		
	}
}
