package com.springboot.zopa.loanCalculator;

import java.util.List;

import com.springboot.zopa.model.Lender;
import com.springboot.zopa.model.Quote;

public interface LoanQuoteCalculator {
	
	Quote getQuote(List<Lender> lenders,Integer loanAmount);
	
}
