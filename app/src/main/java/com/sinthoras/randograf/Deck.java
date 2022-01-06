package com.sinthoras.randograf;

import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.CardJoker;
import com.sinthoras.randograf.cards.CardMonster;
import com.sinthoras.randograf.cards.CardRuin;
import com.sinthoras.randograf.cards.CardVariableColor;
import com.sinthoras.randograf.cards.CardVariableStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck {

    private final List<Card> availableCards = new ArrayList<>();
    private final List<Card> drawnCards = new ArrayList<>();
    private int elapsedTime = 0;

    private final Random random = new Random();

    public Deck() {

    }

    public void prepareSeason() {
        List<Card> persistentMonsters = getAvailableMonsters();
        reset();
        addDefaultCards();
        addSeasonalMonster();
        availableCards.addAll(persistentMonsters);
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    private void reset() {
        availableCards.clear();
        drawnCards.clear();
        elapsedTime = 0;
    }

    private void addDefaultCards() {
        availableCards.addAll(
                Arrays.asList(
                        new CardRuin(),
                        new CardRuin(),
                        new CardJoker(),
                        new CardVariableStructure(Colors.VILLAGE),
                        new CardVariableStructure(Colors.FOREST),
                        new CardVariableStructure(Colors.RIVER),
                        new CardVariableStructure(Colors.FIELD),
                        new CardVariableColor(Colors.VILLAGE, Colors.FOREST),
                        new CardVariableColor(Colors.VILLAGE, Colors.RIVER),
                        new CardVariableColor(Colors.VILLAGE, Colors.FIELD),
                        new CardVariableColor(Colors.FOREST, Colors.RIVER),
                        new CardVariableColor(Colors.FOREST, Colors.FIELD),
                        new CardVariableColor(Colors.RIVER, Colors.FIELD)
                )
        );
    }

    private void addSeasonalMonster() {
        availableCards.add(new CardMonster());
    }

    private List<Card> getAvailableMonsters() {
        return availableCards.stream().filter(card -> card instanceof CardMonster).collect(Collectors.toList());
    }

    public Card drawCard() {
        final Card drawnCard = drawCardUntilNotRuin();
        addElapsedTime(drawnCard.getDuration());
        return drawnCard;
    }

    private void addElapsedTime(int duration) {
        elapsedTime += duration;
    }

    private Card drawCardUntilNotRuin() {
        Card drawnCard = drawRandomAvailableCard();
        while(drawnCard instanceof CardRuin) {
            drawnCard = drawRandomAvailableCard();
            drawnCard.notifyPriorRuin();
        }
        return drawnCard;
    }

    private Card drawRandomAvailableCard() {
        final Card drawnCard = selectRandomAvailableCard();
        availableCards.remove(drawnCard);
        drawnCards.add(drawnCard);
        return drawnCard;
    }

    private Card selectRandomAvailableCard() {
        return availableCards.get(random.nextInt(availableCards.size()));
    }
}


