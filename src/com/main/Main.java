package com.main;

public class Main {
    public static void main(String[] args) {

        Minesweeper game1 = new Minesweeper(15, 10, false, false);
        game1.setGame(new int[]{0, 0});
        game1.printTab();
    }
}
