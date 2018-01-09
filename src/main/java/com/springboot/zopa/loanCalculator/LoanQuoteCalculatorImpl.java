package com.springboot.zopa.loanCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

import com.springboot.zopa.model.Lender;
import com.springboot.zopa.model.Quote;
import com.springboot.zopa.utils.RoundOff;

public class LoanQuoteCalculatorImpl implements LoanQuoteCalculator {

	private static final Integer LOAN_TERMS = 36;

	public Quote getQuote(List<Lender> lenders, Integer loanAmount) {

		Lender lender = getMinRateLender(lenders);
		double rate = lender.getRate();
		double monthlyRepayment = calculateRepayment(rate, loanAmount);
		double totalRepayment = monthlyRepayment * LOAN_TERMS;
		RoundOff roundOff = new RoundOff();
		return new Quote(Integer.valueOf(loanAmount), rate * 100, roundOff.roundOffDouble(monthlyRepayment),
				roundOff.roundOffDouble(totalRepayment));
	}

/*
 *  Comparator to find the Minimum Rate of interest from the list of Lenders
 * 
 */
	private Lender getMinRateLender(List<Lender> lenders) {

		lenders.sort(new Comparator<Lender>() {

			public int compare(Lender o1, Lender o2) {

				return o1.getRate().compareTo(o2.getRate());
			}
		});

		Lender lender = lenders.get(0);
		return lender;
	}

  /*
   *  Simple Repayment formula
   * 
   */	
	private Double calculateRepayment(Double rate, Integer loanAmount) {
		double monthlyRate = rate / 12;
		double repayment = loanAmount
				* (monthlyRate * Math.pow(1 + monthlyRate, LOAN_TERMS) / (Math.pow(1 + monthlyRate, LOAN_TERMS) - 1));
		return repayment;
	}

}
