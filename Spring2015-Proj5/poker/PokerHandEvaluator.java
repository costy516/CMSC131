package poker;

public class PokerHandEvaluator {
	

	//You might want to write some private helper methods...
	
	
	
	
	public static boolean hasPair(Card[] cards) {
		int startInt= 1;
		for(int check1 = 0; check1 < cards.length-1; check1++)
		{
			for(int check2 = startInt; check2 < cards.length; check2++)
			{
				if (cards[check1].getValue() == cards[check2].getValue())
				{
					return true;
				}
			}
			startInt++;
		}
		return false;
		//throw new RuntimeException("Not yet implemented.");
	}
	

	public static boolean hasRainbow(Card[] cards) {
		int startInt= 1;
		for(int check1 = 0; check1 < cards.length-1; check1++)
		{
			for(int check2 = startInt; check2 < cards.length; check2++)
			{
				if (cards[check1].getSuit() == cards[check2].getSuit())
				{
					return false;
				}
			}
			startInt++;
		}
		return true;
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasTwoPair(Card[] cards) {
		boolean firstPair = false, secondPair = false;
		int firstPairInt = -1;
		int startInt= 1;
		for(int check1 = 0; check1 < cards.length-1; check1++)
		{
			for(int check2 = startInt; check2 < cards.length; check2++)
			{
				if (cards[check1].getValue() == cards[check2].getValue() && cards[check1].getValue() != firstPairInt  && firstPair)
				{
					secondPair = true;
				}
				else if (cards[check1].getValue() == cards[check2].getValue())
				{
					firstPairInt = cards[check1].getValue();
					firstPair = true;
				}
			}
			startInt++;
		}
		return (firstPair && secondPair);
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasThreeOfAKind(Card[] cards) {
		Card[] hand = putCardsInOrder(cards);
		int startInt= 1;
		for(int check1 = 0; check1 < hand.length-1; check1++)
		{
			for(int check2 = startInt; check2 < hand.length; check2++)
			{
				if (hand[check1].getValue() == hand[check2].getValue())
				{
					for (int check3 = check2 + 1; check3 < hand.length; check3++)
					{
						if (hand[check1].getValue() == hand[check3].getValue())
						{
							return true;
						}
					}
				}
			}
			startInt++;
		}
		return false;
		//throw new RuntimeException("Not yet implemented.");
	}
	

	public static boolean hasStraight(Card [] cards) {		
		Card [] hand = putCardsInOrder(cards);
		for (int check = 1; check <= 4; check++)
		{
			if(hand[0].getValue() != (hand[check].getValue()-check))
			{
				return false;
			}
		}
		return true;
		//throw new RuntimeException("Not yet implemented.");
	}
	
	
	
	
	public static boolean hasFlush(Card[] cards) {
		for (int check = 1; check <= 4; check++)
		{
			if(cards[0].getSuit() != cards[check].getSuit())
			{
				return false;
			}
		}
		return true;
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasFullHouse(Card[] cards) {
		Card [] hand = putCardsInOrder(cards);
		if(hand[0].getValue() == hand[1].getValue() && hand[3].getValue() == hand[4].getValue())
		{
			if(hand[0].getValue() == hand[2].getValue() || hand[4].getValue() == hand[2].getValue())
			{
				return true;
			}
		}
		return false;
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasFourOfAKind(Card[] cards) {
		Card [] hand = putCardsInOrder(cards);
		if ((hand[0].getValue() == hand[3].getValue()) || (hand[1].getValue() == hand[4].getValue()))
		{
			return true;
		}
		return false;
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasStraightRainbow(Card[] cards) {
		boolean hasStraight = hasStraight(cards);
		boolean hasRainbow = hasRainbow(cards);
		if (hasStraight && hasRainbow)
		{
			return true;
		}
		else
		{
			return false;
		}
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasStraightFlush(Card[] cards) {
		boolean hasStraight = hasStraight(cards);
		boolean hasFlush = hasFlush(cards);
		if (hasStraight && hasFlush)
		{
			return true;
		}
		else
		{
			return false;
		}
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static boolean hasFiveOfAKind(Card[] cards) {
		for(int check = 1; check<= 4; check++)
		{
			if(cards[0].getValue() != cards[check].getValue())
			{
			 return false;	
			}
		}
			
		return true;
		//throw new RuntimeException("Not yet implemented.");
	}
	
	public static Card[] putCardsInOrder (Card[] cards)
	{
		Card temp;
		int check2Start = 1;
		for(int check1 = 0; check1 < cards.length -1; check1++)
		{
			for(int check2 = check2Start; check2 < cards.length; check2++)
			{
				if(cards[check1].getValue() > cards[check2].getValue())
				{
					temp = cards[check2];
					cards[check2] = cards[check1];
					cards[check1] = temp;
				}
			}
			check2Start++;
		}
		return cards;
	}
	
}

