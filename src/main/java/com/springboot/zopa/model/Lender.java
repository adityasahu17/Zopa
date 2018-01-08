package com.springboot.zopa.model;

import java.util.Objects;

public class Lender {

	private final String name;
	private final Double rate;
	private final Integer availableAmount;

	public Lender(final String name, final Double rate, final Integer availableAmount) {
		this.name = name;
		this.rate = rate;
		this.availableAmount = availableAmount;
	}

	public String getName() {
		return name;
	}

	public Double getRate() {
		return rate;
	}

	public Integer getAvailableAmount() {
		return availableAmount;
	}

	@Override
	public String toString() {
		return "Lender{" + "name='" + name + '\'' + ", rate=" + rate + ", availableAmount=" + availableAmount + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Lender lender = (Lender) o;
		return Objects.equals(this.name, lender.name) && Objects.equals(rate, lender.rate)
				&& Objects.equals(availableAmount, lender.availableAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, rate, availableAmount);
	}
}