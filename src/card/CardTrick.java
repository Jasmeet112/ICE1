/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Jasmeet Kaur (991728024)
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            magicHand[i] = new Card(); // Create a new Card object
            //c.setValue(insert call to random number generator here)
            magicHand[i].setValue(Card.randomValue());
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            magicHand[i].setSuit(Card.randomSuit()); 
            System.out.println(magicHand[i].getSuit() + " " + magicHand[i].getValue()); 
        }
        
        //insert code to ask the user for Card value and suit, create their card
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userInput = scanner.nextInt();
        System.out.print("Enter a card suit (0=Hearts, 1=Diamonds, 2=Spades, 3=Clubs): ");
        int userSuitIndex = scanner.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];

        Card userCard = new Card();
        userCard.setValue(userInput);
        userCard.setSuit(userSuit);
        
        // and search magicHand here
        boolean match = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                match = true;
                break;
            }
        }
        
        //Then report the result here
        if (match) {
            System.out.println("Awesome! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        // add one luckcard hard code
        Card luckyCard = new Card();
        luckyCard.setValue(12); 
        luckyCard.setSuit("Hearts"); 
        
        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
            luckyFound = true;
            break;
            }
        }

        if (luckyFound) {
            System.out.println("The lucky card (" + luckyCard.getSuit() + " " + luckyCard.getValue() + ") is in the magic hand!");
        } else {
            System.out.println("The lucky card (" + luckyCard.getSuit() + " " + luckyCard.getValue() + ") is not in the magic hand.");
        }
    }
    
}

