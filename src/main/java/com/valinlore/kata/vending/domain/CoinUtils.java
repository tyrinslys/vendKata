package com.valinlore.kata.vending.domain;

import org.apache.commons.lang3.Range;

public class CoinUtils {
	private static final Range<Integer> QUARTER_SIZE_RANGE;
	private static final Range<Integer> DIME_SIZE_RANGE;
	private static final Range<Integer> NICKEL_SIZE_RANGE;

	static {
		{ // setup for quarter
			int perfectQuarterSize = AcceptedCoinTypes.QUARTER.getSizeInMicroMeters();
			int quarterSizeTolerance = AcceptedCoinTypes.QUARTER.getSizeTolerance();
			QUARTER_SIZE_RANGE = Range.between(perfectQuarterSize - quarterSizeTolerance,
					perfectQuarterSize + quarterSizeTolerance);
		}
		{ // setup for dime
			int perfectDimeSize = AcceptedCoinTypes.DIME.getSizeInMicroMeters();
			int dimeSizeTolerance = AcceptedCoinTypes.DIME.getSizeTolerance();
			DIME_SIZE_RANGE = Range.between(perfectDimeSize - dimeSizeTolerance, perfectDimeSize + dimeSizeTolerance);
		}
		{ // setup for nickel
			int perfectNickelSize = AcceptedCoinTypes.NICKEL.getSizeInMicroMeters();
			int nickelSizeTolerance = AcceptedCoinTypes.NICKEL.getSizeTolerance();
			NICKEL_SIZE_RANGE = Range.between(perfectNickelSize - nickelSizeTolerance,
					perfectNickelSize + nickelSizeTolerance);
		}
	}

	public static AcceptedCoinTypes determineCoinType(Coin coin) {
		AcceptedCoinTypes sizeFits = checkSize(coin);
		return sizeFits;
	}

	private static AcceptedCoinTypes checkSize(Coin coin) {
		if (QUARTER_SIZE_RANGE.contains(coin.getSize())) {
			return AcceptedCoinTypes.QUARTER;
		} else if (DIME_SIZE_RANGE.contains(coin.getSize())) {
			return AcceptedCoinTypes.DIME;
		} else if (NICKEL_SIZE_RANGE.contains(coin.getSize())) {
			return AcceptedCoinTypes.NICKEL;
		} else {
			return null;
		}
	}
}
