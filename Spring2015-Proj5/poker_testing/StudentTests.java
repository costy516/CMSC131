package poker_testing;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.PokerHandEvaluator;

public class StudentTests {

	@Test
	public void testExampleTest_SinglePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		assertFalse(PokerHandEvaluator.hasPair(testHand));
	}
	
	@Test
	public void testRainbow()
	{
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,0);
		testHand[2] = new Card(3,4);
		testHand[3] = new Card(4,3);
		testHand[4] = new Card(5,2);
		assertTrue(PokerHandEvaluator.hasRainbow(testHand));
	}
	
	@Test
	public void testTwoPair()
	{
		Card [] testHand1 = new Card [5];
		Card [] testHand2 = new Card [5];
		
		testHand1[0] = new Card (4,2);
		testHand1[1] = new Card (4,1);
		testHand1[2] = new Card (1,2);
		testHand1[3] = new Card (4,3);
		testHand1[4] = new Card (4,4);
		
		testHand2[0] = new Card (2,2);
		testHand2[1] = new Card (2,1);
		testHand2[2] = new Card (1,2);
		testHand2[3] = new Card (9,2);
		testHand2[4] = new Card (9,1);
		
		assertFalse(PokerHandEvaluator.hasTwoPair(testHand1));
		assertTrue(PokerHandEvaluator.hasTwoPair(testHand2));
		
	}
	
	@Test
	public void testThreeOfAKind()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (7,1);
		testHand[1] = new Card (5,0);
		testHand[2] = new Card (5,3);
		testHand[3] = new Card (2,2);
		testHand[4] = new Card (5,2);
		
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testHand));
	}
	
	@Test
	public void testFourOfAKind()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (7,1);
		testHand[1] = new Card (5,0);
		testHand[2] = new Card (5,3);
		testHand[3] = new Card (5,1);
		testHand[4] = new Card (5,2);
		
		assertTrue (PokerHandEvaluator.hasFourOfAKind(testHand));
		 
	}
	
	@Test
	public void testStraight()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (4,1);
		testHand[1] = new Card (3,0);
		testHand[2] = new Card (5,3);
		testHand[3] = new Card (7,1);
		testHand[4] = new Card (6,2);
		
		assertTrue (PokerHandEvaluator.hasStraight(testHand));
	}
	
	@Test
	public void testFlush()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (2,1);
		testHand[1] = new Card (4,1);
		testHand[2] = new Card (5,1);
		testHand[3] = new Card (7,1);
		testHand[4] = new Card (6,1);
		
		assertTrue (PokerHandEvaluator.hasFlush(testHand));
	}
	
	@Test
	public void testFullHouse()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (5,1);
		testHand[1] = new Card (4,2);
		testHand[2] = new Card (5,4);
		testHand[3] = new Card (4,1);
		testHand[4] = new Card (5,0);
		
		assertTrue (PokerHandEvaluator.hasFullHouse(testHand));
	}
	
	@Test
	public void testStraightRainbow()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (5,1);
		testHand[1] = new Card (4,2);
		testHand[2] = new Card (6,4);
		testHand[3] = new Card (2,3);
		testHand[4] = new Card (3,0);
		
		assertTrue (PokerHandEvaluator.hasStraightRainbow(testHand));
	}
	
	@Test
	public void testStraightFlush()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (5,1);
		testHand[1] = new Card (4,1);
		testHand[2] = new Card (6,1);
		testHand[3] = new Card (2,1);
		testHand[4] = new Card (3,1);
		
		assertTrue (PokerHandEvaluator.hasStraightFlush(testHand));
	}
	
	@Test
	public void testFiveOfAKind()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (5,1);
		testHand[1] = new Card (5,2);
		testHand[2] = new Card (5,4);
		testHand[3] = new Card (5,3);
		testHand[4] = new Card (5,0);
		
		assertTrue (PokerHandEvaluator.hasFiveOfAKind(testHand));
	}
	
	@Test
	public void testPutCardsInOrder()
	{
		Card [] testHand = new Card [5];
		
		testHand[0] = new Card (5,1);
		testHand[1] = new Card (5,2);
		testHand[2] = new Card (4,4);
		testHand[3] = new Card (1,3);
		testHand[4] = new Card (2,0);
		
		Card [] evaluated = PokerHandEvaluator.putCardsInOrder(testHand);
		
		assertTrue(evaluated[0].getValue() == 1);
	}
	//You will add many other tests here for pair and the other hands
	
	@Test
	public void testCut()
	{
		Deck testDeck = new Deck();
		testDeck.cut(4);
		Card[] testCards = testDeck.deal(8);
		
		
		assertTrue(testCards[0].equals(new Card(5,0)));
	}
	
	
	@Test
	public void testExampleTest_SmallShuffle1() {
		Deck testDeck = new Deck();
		
		testDeck.deal(45-8); //get rid off all but 8 cards
		testDeck.shuffle();  //shuffle the remaining cards
		Card[] testCards = testDeck.deal(8); //deal the remaining 8 cards to me
		//This should give me 2, 3,    4, 5, 6,    7, 8, 9 of Stars
		
		
		//Now check the actual cards against what I expect...
		int[] shouldBe = { 7,4,2,8,5,3,9,6 };
		for (int i=0; i<8; i++) {
			assertEquals(shouldBe[i], testCards[i].getValue());
			assertEquals(4, testCards[i].getSuit());
		}
	}
	
	public void testExampleTest_SmallShuffle2() {
		Deck testDeck = new Deck();
		
		testDeck.deal(45-9); //get rid off all but 8 cards
		testDeck.shuffle();  //shuffle the remaining cards
		Card[] testCards = testDeck.deal(7); //deal the remaining 8 cards to me
		//This should give me 2, 3,    4, 5, 6,    7, 8, 9 of Stars
		
		
		//Now check the actual cards against what I expect...
		int[] shouldBe = { 4,2,8,5,3,9,6 };
		for (int i=0; i<8; i++) {
			assertEquals(shouldBe[i], testCards[i].getValue());
			assertEquals(4, testCards[i].getSuit());
		}
	}
	
	public void testExampleTest_SmallShuffle3() {
		Deck testDeck = new Deck();
		
		testDeck.deal(45-10); //get rid off all but 8 cards
		testDeck.shuffle();  //shuffle the remaining cards
		Card[] testCards = testDeck.deal(6); //deal the remaining 8 cards to me
		//This should give me 2, 3,    4, 5, 6,    7, 8, 9 of Stars
		
		
		//Now check the actual cards against what I expect...
		int[] shouldBe = { 2,8,5,3,9,6 };
		for (int i=0; i<8; i++) {
			assertEquals(shouldBe[i], testCards[i].getValue());
			assertEquals(4, testCards[i].getSuit());
		}
	}

}
