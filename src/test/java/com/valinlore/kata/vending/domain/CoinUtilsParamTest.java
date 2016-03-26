package com.valinlore.kata.vending.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.util.IntegerSequence.Range;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoinUtilsParamTest {

	@Parameters(name = "Coin weight {0} and size {1} should be {2}")
	public static Collection<Object[]> setOfValidCoins() {
		List<Object[]> validQuartersTests = Collections.emptyList();
		{ // valid quarters setup
			AcceptedCoinTypes quarter = AcceptedCoinTypes.QUARTER;
			Range quarterWeights = new Range(quarter.getWeightInMilligrams() - quarter.getWeightTolerance(),
					quarter.getWeightInMilligrams() + quarter.getWeightTolerance(), 1);
			Range quarterDiameters = new Range(quarter.getDiameterInMicroMeters() - quarter.getDiameterTolerance(),
					quarter.getDiameterInMicroMeters() + quarter.getDiameterTolerance(), 1);
			int expectedNumberOfTests = quarterDiameters.size() * quarterWeights.size();
			validQuartersTests = createTestCases(quarterWeights, quarterDiameters, quarter, expectedNumberOfTests);
		}
		List<Object[]> validDimeTests = Collections.emptyList();
		{ // valid Dime setup
			AcceptedCoinTypes dime = AcceptedCoinTypes.DIME;
			Range dimeWeights = new Range(dime.getWeightInMilligrams() - dime.getWeightTolerance(),
					dime.getWeightInMilligrams() + dime.getWeightTolerance(), 1);
			Range dimeDiameters = new Range(dime.getDiameterInMicroMeters() - dime.getDiameterTolerance(),
					dime.getDiameterInMicroMeters() + dime.getDiameterTolerance(), 1);
			int expectedNumberOfTests = dimeDiameters.size() * dimeWeights.size();
			validDimeTests = createTestCases(dimeWeights, dimeDiameters, dime, expectedNumberOfTests);
		}

		List<Object[]> validNickelTests = Collections.emptyList();
		{ // valid Nickel setup
			AcceptedCoinTypes nickel = AcceptedCoinTypes.NICKEL;
			Range nickelWeights = new Range(nickel.getWeightInMilligrams() - nickel.getWeightTolerance(),
					nickel.getWeightInMilligrams() + nickel.getWeightTolerance(), 1);
			Range mickelDiameters = new Range(nickel.getDiameterInMicroMeters() - nickel.getDiameterTolerance(),
					nickel.getDiameterInMicroMeters() + nickel.getDiameterTolerance(), 1);
			int expectedNumberOfTests = mickelDiameters.size() * nickelWeights.size();
			validNickelTests = createTestCases(nickelWeights, mickelDiameters, nickel, expectedNumberOfTests);
		}

		List<Object[]> testSet = new ArrayList<>(
				validQuartersTests.size() + validDimeTests.size() + validNickelTests.size());
		testSet.addAll(validQuartersTests);
		testSet.addAll(validDimeTests);
		testSet.addAll(validNickelTests);
		return testSet;
	}

	private static List<Object[]> createTestCases(Iterable<?> listOne, Iterable<?> listTwo, Object expectedResult,
			int expectedSize) {
		List<Object[]> testSets = new ArrayList<>(expectedSize);
		for (Object elementOne : listOne) {
			for (Object elementTwo : listTwo) {
				Object[] testSet = new Object[3];
				testSet[0] = elementOne;
				testSet[1] = elementTwo;
				testSet[2] = expectedResult;
				testSets.add(testSet);
			}
		}
		return testSets;
	}

	@Parameter(0)
	public int weight;
	@Parameter(1)
	public int diameter;
	@Parameter(2)
	public AcceptedCoinTypes expectedResult;

	@Test
	public void testValidateNickel() {
		// given: a coin
		Coin coin = new Coin(weight, diameter);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: check expected result
		assertThat(returnCoin, is(expectedResult));
	}

}
