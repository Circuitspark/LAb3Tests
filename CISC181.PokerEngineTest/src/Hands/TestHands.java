package Hands;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;

public class TestHands {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void TestnatRoyalFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be nrf:",
				eHandStrength.NaturalRoyalFlush.getHandStrength(),
				h.getHandStrength());

	}

	@Test
	public final void TestjokerRoyalFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestjokerRoyalFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be rf:",
				eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.NINE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush2() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush1joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraightFlush2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Sf:",
				eHandStrength.StraightFlush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFiveofakind() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 5oaK:",
				eHandStrength.FiveOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFourofaKind() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4oaK:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFourofaKind1Joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4oaK:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFourofaKind2Joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 4oaK:",
				eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFullhouse() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be FH:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFullhousejoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be FH:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFullhouse2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be FH:",
				eHandStrength.FullHouse.getHandStrength(), h.getHandStrength());
	}

	@Test
	public final void TestFlush() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Fl:", eHandStrength.Flush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFlushjoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Fl:", eHandStrength.Flush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestFlush2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Fl:", eHandStrength.Flush.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraight() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be St:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraightjoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be St:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestStraight2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be St:", eHandStrength.Straight.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeofaKind() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 3oaK:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeofaKindjoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 3oaK:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void TestThreeofaKind2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 3oaK:",
				eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testtwopair() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 2p:",
				eHandStrength.TwoPair.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testtwopairjoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 2p:",
				eHandStrength.TwoPair.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testtwopair2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be 2p:",
				eHandStrength.TwoPair.getHandStrength(),
				h.getHandStrength());
	}
	
	@Test
	public final void Testpair() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be p:",
				eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testpairjoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be p:",
				eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testpair2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be p:",
				eHandStrength.Pair.getHandStrength(),
				h.getHandStrength());
	}
	
	@Test
	public final void Testhigh() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be Hi:",
				eHandStrength.HighCard.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testhighjoker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FOUR));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SEVEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be hi:",
				eHandStrength.HighCard.getHandStrength(),
				h.getHandStrength());
	}

	@Test
	public final void Testhigh2joker() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.WILD, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.THREE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);

		assertEquals("Should be hi:",
				eHandStrength.HighCard.getHandStrength(),
				h.getHandStrength());
	}
	

}
