package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CoinUtilsTest {
	@Test
	public void testValidateQuarter() {
		// given: a perfect quarter
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: quarter should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.QUARTER));
	}

	@Test
	public void testValidateDime() {
		// given: a perfect dime
		Coin coin = createCoin(AcceptedCoinTypes.DIME);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: dime should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.DIME));
	}

	@Test
	public void testValidateNickel() {
		// given: a perfect nickel
		Coin coin = createCoin(AcceptedCoinTypes.NICKEL);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: nickel should be the type returned
		assertThat(returnCoin, is(AcceptedCoinTypes.NICKEL));
	}

	@Test
	public void testCoinNotMatched_quarterOverWeight() {
		// given: a coin just over weight of a quarter.
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER,
				AcceptedCoinTypes.QUARTER.getWeightTolerance() + 1, 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_quarterUnderWeight() {
		// given: a coin just over weight of a quarter.
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER,
				-(AcceptedCoinTypes.QUARTER.getWeightTolerance() + 1), 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_quarterOverSized() {
		// given: a coin just over size of a quarter.
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER, 0,
				AcceptedCoinTypes.QUARTER.getDiameterTolerance() + 1);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_quarterUnderSized() {
		// given: a coin just over size of a quarter.
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER, 0,
				-(AcceptedCoinTypes.QUARTER.getDiameterTolerance() + 1));
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_dimeOverWeight() {
		// given: a coin just over weight of a dime.
		Coin coin = createCoin(AcceptedCoinTypes.DIME,
				AcceptedCoinTypes.DIME.getWeightTolerance() + 1, 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_dimeUnderWeight() {
		// given: a coin just over weight of a dime.
		Coin coin = createCoin(AcceptedCoinTypes.DIME,
				-(AcceptedCoinTypes.DIME.getWeightTolerance() + 1), 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_dimeOverSized() {
		// given: a coin just over size of a dime.
		Coin coin = createCoin(AcceptedCoinTypes.DIME, 0,
				AcceptedCoinTypes.DIME.getDiameterTolerance() + 1);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_dimeUnderSized() {
		// given: a coin just over size of a dime.
		Coin coin = createCoin(AcceptedCoinTypes.DIME, 0,
				-(AcceptedCoinTypes.DIME.getDiameterTolerance() + 1));
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_nickelOverWeight() {
		// given: a coin just over weight of a nickel.
		Coin coin = createCoin(AcceptedCoinTypes.NICKEL,
				AcceptedCoinTypes.NICKEL.getWeightTolerance() + 1, 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_nickelUnderWeight() {
		// given: a coin just over weight of a nickel.
		Coin coin = createCoin(AcceptedCoinTypes.NICKEL,
				-(AcceptedCoinTypes.NICKEL.getWeightTolerance() + 1), 0);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_nickelOverSized() {
		// given: a coin just over size of a nickel.
		Coin coin = createCoin(AcceptedCoinTypes.NICKEL, 0,
				AcceptedCoinTypes.NICKEL.getDiameterTolerance() + 1);
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}

	@Test
	public void testCoinNotMatched_nickelUnderSized() {
		// given: a coin just over size of a nickel.
		Coin coin = createCoin(AcceptedCoinTypes.NICKEL, 0,
				-(AcceptedCoinTypes.NICKEL.getDiameterTolerance() + 1));
		// when: validate coin
		AcceptedCoinTypes returnCoin = CoinUtils.determineCoinType(coin);
		// then: null should be returned
		assertThat(returnCoin, nullValue());
	}
}
