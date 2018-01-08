package com.springboot.zopa.LendersQuote;

import java.io.IOException;
import java.util.List;

import com.springboot.zopa.loanCalculator.LoanQuoteCalculator;
import com.springboot.zopa.loanCalculator.LoanQuoteCalculatorImpl;
import com.springboot.zopa.model.Lender;
import com.springboot.zopa.model.Quote;
import com.springboot.zopa.utils.CSVParser;

/**
 * Zopa
 *
 */
public class App {
	
	private static final int MIN_AMOUNT = 1000;
	private static final int MAX_AMOUNT = 15000;
	private static final int AMOUNT_STEP = 100;

	public static void main(String[] args) {
		if (isValidInput(args)) {
			String csvFile = args[0];
			Integer loanAmount = Integer.valueOf(args[1]);
			try {
				List<Lender> lenders = CSVParser.parseCSV(csvFile);
				LoanQuoteCalculator loanQuoteCalculator = new LoanQuoteCalculatorImpl();
				if (isValidLoanAmount(loanAmount)) {
					Quote quote = loanQuoteCalculator.getQuote(lenders, loanAmount);
					if (quote != null) {
						System.out.println("Requested Amount: £" + quote.getAmount());
						System.out.println("Rate: " + quote.getRate() + "%");
						System.out.println("Monthly Payment: £" + quote.getmonthlyRepayment());
						System.out.println("Total Repayment: £" + quote.getTotalRepayment());
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private static boolean isValidInput(final String[] args) {
		if (args[0] == null || "".equals(args[0])) {
			System.out.println("CSV file is required as a input parameter.");
			return false;
		} else if (args[1] == null || "".equals(args[1])) {
			System.out.println("Loan amount is required as a input parameter.");
			return false;
		}
		return true;
	}

	private static boolean isValidLoanAmount(double loanAmount) {
		try {
			Double loan = Double.valueOf(loanAmount);
			if (loan < MIN_AMOUNT || loan > MAX_AMOUNT || loan % AMOUNT_STEP != 0) {
				throw new IllegalArgumentException(
						"Error: Invalid amount [" + loan + "], any 100 between 1000 and 15000");
			}
			return true;
		} catch (NumberFormatException ex) {
			System.out.println("Invalid amount [" + loanAmount + "], any 100 between 1000 and 15000");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

}
