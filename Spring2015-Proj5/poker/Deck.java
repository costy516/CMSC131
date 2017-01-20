package poker;
import java.util.*;
public class Deck {

	private Card[] cards;
	private int cardNum;

	public Deck() {
		cardNum = 0;
		
		cards = new Card[45];
		for(int suit = 0; suit <= 4; suit++)
		{
			for(int value = 1; value <= 9; value++)
			{
				cards [cardNum] = new Card (value, suit);
				cardNum++;
			}
		}
		//throw new RuntimeException("Not yet implemented.");
	}

	public Deck(Deck other) {
		cards = new Card [other.cards.length];
		int valueIn, suitIn;
		for (int cardNum = 0; cardNum < other.cards.length; cardNum++)
		{
			valueIn = other.getCardAt(cardNum).getValue();
			suitIn = other.getCardAt(cardNum).getSuit();
			cards [cardNum] = new Card (valueIn, suitIn);
		}
		//throw new RuntimeException("Not yet implemented.");
	}

	public Card getCardAt(int position) {
		return cards[position];
		//throw new RuntimeException("Not yet implemented.");
	}

	public int getNumCards() {
		return cards.length;
		//throw new RuntimeException("Not yet implemented.");
	}


	public Card[] deal(int numCards) {
		Card [] hand = new Card[numCards];
		Card [] newDeck = new Card[cards.length-numCards];
		int indexHand = 0, indexNewDeck = 0;
		
		for (int placeNewCards = 0; placeNewCards < cards.length; placeNewCards++)
		{
			if(placeNewCards <= (numCards-1))
			{
				hand[indexHand] = cards[placeNewCards];
				indexHand++;
			}
			else
			{
				newDeck[indexNewDeck] = cards[placeNewCards];
				indexNewDeck++;
			}
		}
		cards = newDeck;
		return hand;
		//throw new RuntimeException("Not yet implemented.");
	}
 
	public void cut(int position) {
		Card [] cut = new Card[position];
		Card [] bottomDeck = new Card[cards.length-position];
		int indexCut = 0, indexBottomDeck = 0;
		
		//Separate
		for (int placeNewCards = 0; placeNewCards < cards.length; placeNewCards++)
		{
			if(placeNewCards < position)
			{
				cut[indexCut] = cards[placeNewCards];
				indexCut++;
			}
			else
			{
				bottomDeck[indexBottomDeck] = cards[placeNewCards];
				indexBottomDeck++;
			}
		}
		indexCut = 0;
		indexBottomDeck = 0;
		//reIntegrate
		for (int placeNewCards = 0; placeNewCards < cards.length; placeNewCards++)
		{
			if(placeNewCards > (cards.length-position-1))
			{
				cards[placeNewCards] = cut[indexCut];
				indexCut++;
			}
			else
			{
				cards[placeNewCards] = bottomDeck[indexBottomDeck] ;
				indexBottomDeck++;
			}
		}
		//throw new RuntimeException("Not yet implemented.");
	}
	
	
	
	public void shuffle() {
		//If there are not at least 3 cards, don't do anything.
		if (cards.length <= 3)
		{
			return;
		}
		//If there are at least 3 cards...
		/*
		 * The easiest thing is likely to create a new array into which 
		 * the cards will be shuffled.
		 * 
		 * Work out the following four values for each of the three possible
		 * scenarios of dividing the size of the deck by 3 (remainder: 0,1,2).
		 *   - the size of the smallest (top) sub-deck you'll need
		 *   - the size of the other two (middle, bottom) sub-decks you'll need
		 *   - the "breakpoint" where the middle sub-deck starts
		 *   - the "breakpoint" where the bottom sub-deck starts
		 *   
		 * Once you have those things determined, start to assemble the
		 *   shuffled order into the new array.  This should be done in two
		 *   phases; interleaving cards from all three sub-decks until the top
		 *   one is empty, and then interleaving the last few cards from the
		 *   middle and bottom sub-decks after that.  
		 *   
		 * At the very end, you can have the cards field point to the newly
		 *   created array.
		 *   
		 *   
		 * Think of some simple scenarios first, to work through the idea.
		 * Some good starter decks to try to shuffle would be:
		 *    1,2,3,4,5,6,7,8,9 which would shuffle into 7,4,1,8,5,2,9,6,3
		 *    2,3,4,5,6,7,8,9 which would shuffle into 7,4,2,8,5,3,9,6
		 *    3,4,5,6,7,8,9 which would shuffle into 7,4,3,8,5,9,6
		 * I wouldn't start writing any code until the above examples make
		 *   sense given the rules of how to shuffle.
		 */
		else
		{
			Card [][] shuffling = new Card [3][(cards.length%3==0)?(cards.length/3):((cards.length/3)+1)];
			Card [] newCards = new Card[cards.length];
			int origDeck = 0;
			int maxOfIndStack = cards.length/3 +1;
			int populateNewDeck = 0;
			//store deck in groups of 3
			for(int stackNum = 0; stackNum<= 2; stackNum++)
			{
				if(cards.length%3 == 0)
				{
					maxOfIndStack = cards.length/3;
				}
				else if(cards.length%3 == 1)
				{
					if(stackNum == 2)
					{
						maxOfIndStack = cards.length/3+1;
					}
					else
					{
						maxOfIndStack = cards.length/3;
					}
				}
				else if (cards.length%3 == 2)
				{
					if(stackNum >= 1)
					{
						maxOfIndStack = cards.length/3+1;
					}
					else
					{
						maxOfIndStack = cards.length/3;
					}
				}
				for(int indexOfStack = 0; indexOfStack < maxOfIndStack && cards[indexOfStack] != null; indexOfStack++)
				{
					shuffling[stackNum][indexOfStack] = cards[origDeck];
					origDeck++;
				}
			}
			//end store deck in groups of 3
			
			//put deck back together
			for(int indexOfStack = 0; indexOfStack < ((cards.length%3==0)?(cards.length/3):((cards.length/3)+1)); indexOfStack++)
			{
				for(int stackNum = 2; stackNum >= 0;  stackNum--)
				{
					if(shuffling[stackNum][indexOfStack] == null)
					{
						
					}
					else
					{
						newCards[populateNewDeck] = shuffling[stackNum][indexOfStack];
						populateNewDeck++;
					}
				}
			}
			//end put back together
			cards = newCards;
		}
	}
	

}
