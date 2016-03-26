package com.valinlore.kata.vending.domain;

import org.apache.commons.lang3.Range;

public class CoinUtils {
	private static final Range<Integer> QUARTER_SIZE_RANGE;
	private static final Range<Integer> DIME_SIZE_RANGE;
	private static final Range<Integer> NICKEL_SIZE_RANGE;
	private static final Range<Integer> QUARTER_WEIGHT_RANGE;
	private static final Range<Integer> DIME_WEIGHT_RANGE;
	private static final Range<Integer> NICKEL_WEIGHT_RANGE;

	static {
		{ // setup for quarter
			AcceptedCoinTypes quarter = AcceptedCoinTypes.QUARTER;
			int perfectQuarterSize = quarter.getDiameterInMicroMeters();
			int quarterSizeTolerance = quarter.getDiameterTolerance();
			QUARTER_SIZE_RANGE = Range.between(perfectQuarterSize - quarterSizeTolerance,
					perfectQuarterSize + quarterSizeTolerance);

			int perfectQuarterWeight = quarter.getWeightInMilligrams();
			int quarterWeightTolerance = quarter.getWeightTolerance();
			QUARTER_WEIGHT_RANGE = Range.between(perfectQuarterWeight - quarterWeightTolerance,
					perfectQuarterWeight + quarterWeightTolerance);
		}
		{ // setup for dime
			AcceptedCoinTypes dime = AcceptedCoinTypes.DIME;
			int perfectDimeSize = dime.getDiameterInMicroMeters();
			int dimeSizeTolerance = dime.getDiameterTolerance();
			DIME_SIZE_RANGE = Range.between(perfectDimeSize - dimeSizeTolerance, perfectDimeSize + dimeSizeTolerance);

			int perfectDimeWeight = dime.getWeightInMilligrams();
			int dimeWeightTolerance = dime.getWeightTolerance();
			DIME_WEIGHT_RANGE = Range.between(perfectDimeWeight - dimeWeightTolerance,
					perfectDimeWeight + dimeWeightTolerance);
		}
		{ // setup for nickel
			AcceptedCoinTypes nickel = AcceptedCoinTypes.NICKEL;
			int perfectNickelSize = nickel.getDiameterInMicroMeters();
			int nickelSizeTolerance = nickel.getDiameterTolerance();
			NICKEL_SIZE_RANGE = Range.between(perfectNickelSize - nickelSizeTolerance,
					perfectNickelSize + nickelSizeTolerance);

			int perfectNickelWeight = nickel.getWeightInMilligrams();
			int nickelWeightTolerance = nickel.getWeightTolerance();
			NICKEL_WEIGHT_RANGE = Range.between(perfectNickelWeight - nickelWeightTolerance,
					perfectNickelWeight + nickelWeightTolerance);
		}
	}

	public static AcceptedCoinTypes determineCoinType(Coin coin) {
		AcceptedCoinTypes sizeFits = checkSize(coin);
		if (sizeFits == null) {
			return null;
		}

		AcceptedCoinTypes weightFits = checkWeight(coin);
		if (weightFits == null) {
			return null;
		}

		if (sizeFits.equals(weightFits)) {
			return sizeFits;
		} else {
			return null;
		}
	}

	private static AcceptedCoinTypes checkWeight(Coin coin) {
		if (QUARTER_WEIGHT_RANGE.contains(coin.getWeight())) {
			return AcceptedCoinTypes.QUARTER;
		} else if (DIME_WEIGHT_RANGE.contains(coin.getWeight())) {
			return AcceptedCoinTypes.DIME;
		} else if (NICKEL_WEIGHT_RANGE.contains(coin.getWeight())) {
			return AcceptedCoinTypes.NICKEL;
		} else {
			return null;
		}
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
