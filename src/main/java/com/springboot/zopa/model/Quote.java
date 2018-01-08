package com.springboot.zopa.model;

public class Quote {

	private Integer requestedAmount;
	private Double rate;
	private Double monthlyRepayment;
	private Double totalRepayment;

	public Quote(final Integer requestedAmount, final Double rate, final Double monthlyRepayment,
			final Double totalRepayment) {
		this.requestedAmount = requestedAmount;
		this.rate = rate;
		this.monthlyRepayment = monthlyRepayment;
		this.totalRepayment = totalRepayment;
	}

	public Integer getAmount() {
		return requestedAmount;
	}

	public Double getRate() {
		return rate;
	}

	public Double getmonthlyRepayment() {
		return monthlyRepayment;
	}

	public Double getTotalRepayment() {
		return totalRepayment;
	}

	@Override
	public String toString() {
		return "Loan{" + "amount=" + requestedAmount + ", rate=" + rate + ", repayment=" + monthlyRepayment
				+ ", totalRepayment=" + totalRepayment + '}';
	}

}
