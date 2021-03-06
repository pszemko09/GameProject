package com.game;

/**
 * Klasa przechowująca dane gracza
 */
public class Player {
    public String name;
    public int points = 0;
    public int numberOfLives;

    /**
     * Metoda ustawiająca nazwę gracza
     * @param name Nazwa gracza
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Metoda ustawiająca liczbę żyć gracza
     * @param gameCode Pobrany od użytkownika kod gry
     */
    public void setNumberOfLives(String gameCode){

        if(gameCode.equals("1111"))
            this.numberOfLives = 10;
        else
            this.numberOfLives = 5;
    }

    /**
     * Metoda zwracająca nazwę gracza
     * @return Nazwa gracza
     */
    public String getName() {
        return name;
    }
}
