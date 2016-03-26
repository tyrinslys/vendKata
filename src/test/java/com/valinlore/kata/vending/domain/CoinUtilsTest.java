package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CoinUtilsTest {
	@Test
	public void testValidateQuarter() {
		// given: a perfect quarter
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.QUARTER);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: quarter should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.QUARTER));
	}

	@Test
	public void testValidateDime() {
		// given: a perfect dime
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.DIME);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: dime should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.DIME));
	}

	@Test
	public void testValidateNickel() {
		// given: a perfect nickel
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.NICKEL);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: nickel should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.NICKEL));
	}

	@Test
	public void testThatCoinQuarterSizeButNotWeightReturnsNull() {
		// given: a coin just over weight of a quarter.
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.QUARTER,
				AcceptedCoinTypes.QUARTER.getWeightTolerance() + 1, 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testThatCoinDimeSizeButNotWeightReturnsNull() {
		// given: a coin just over weight of a dime.
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.DIME,
				AcceptedCoinTypes.DIME.getWeightTolerance() + 1, 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testThatCoinNickelSizeButNotWeightReturnsNull() {
		// given: a coin just over weight of a nickel.
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.NICKEL,
				AcceptedCoinTypes.NICKEL.getWeightTolerance() + 1, 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testThatCoinQuarterWeightButNotSizeReturnsNull() {
		// given: a coin just over size of a quarter.
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.QUARTER, 0,
				AcceptedCoinTypes.QUARTER.getSizeTolerance() + 1);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}
	@Test
	public void testThatCoinDimeWeightButNotSizeReturnsNull() {
		// given: a coin just over size of a dime.
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.DIME, 0,
				AcceptedCoinTypes.DIME.getSizeTolerance() + 1);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}
	@Test
	public void testThatCoinNickelWeightButNotSizeReturnsNull() {
		// given: a coin just over size of a nickel.
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.NICKEL, 0,
				AcceptedCoinTypes.NICKEL.getSizeTolerance() + 1);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}
}
