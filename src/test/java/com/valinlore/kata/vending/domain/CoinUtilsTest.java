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
		// given: a perfect quarter
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.DIME);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: quarter should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.DIME));
	}
	@Test
	public void testValidateNickel() {
		// given: a perfect quarter
		Coin coin = VendingMachineTest.createCoin(AcceptedCoinTypes.NICKEL);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: quarter should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.NICKEL));
	}
}
