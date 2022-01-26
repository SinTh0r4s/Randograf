package com.sinthoras.randograf;

import static com.sinthoras.randograf.Random.drawRandomFromCollection;

import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.CardJoker;
import com.sinthoras.randograf.cards.CardMonster;
import com.sinthoras.randograf.cards.CardRuin;
import com.sinthoras.randograf.cards.CardTwoColors;
import com.sinthoras.randograf.cards.CardTwoStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

    private final List<Card> availableCards = new ArrayList<>();
    private final List<Card> drawnCards = new ArrayList<>();
    private int elapsedTime = 0;

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
                        new CardTwoStructures(BlockColors.VILLAGE),
                        new CardTwoStructures(BlockColors.FOREST),
                        new CardTwoStructures(BlockColors.RIVER),
                        new CardTwoStructures(BlockColors.FIELD),
                        new CardTwoColors(BlockColors.VILLAGE, BlockColors.FOREST),
                        new CardTwoColors(BlockColors.VILLAGE, BlockColors.RIVER),
                        new CardTwoColors(BlockColors.VILLAGE, BlockColors.FIELD),
                        new CardTwoColors(BlockColors.FOREST, BlockColors.RIVER),
                        new CardTwoColors(BlockColors.FOREST, BlockColors.FIELD),
                        new CardTwoColors(BlockColors.RIVER, BlockColors.FIELD)
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
        final Card drawnCard = drawRandomFromCollection(availableCards);
        availableCards.remove(drawnCard);
        drawnCards.add(drawnCard);
        return drawnCard;
    }
}
