package com.springboot.zopa.utils;

public class RoundOff {

	public double roundOffDouble(double value) {
		double roundValue = Math.round(value * 100) / 100D;
		return roundValue;
	}

}
