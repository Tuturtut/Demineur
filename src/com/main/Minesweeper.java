package com.main;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {

    int mineNumber;
    int mineCounter;

    int fieldSize;
    int maxMineNumber;

    char[][] tab;
    char grass = '0';
    char mine = '*';
    private final boolean hideMine;
    private final boolean hideNumber;


    public Minesweeper(int mineNumber, int fieldSize, boolean hideMine, boolean hideNumber) {
        this.mineNumber = mineNumber;
        this.hideNumber = hideNumber;
        this.mineCounter = 0;
        this.fieldSize = fieldSize;
        this.maxMineNumber = (int) Math.pow(fieldSize, 1.8);
        if(mineNumber > maxMineNumber) this.mineNumber = this.maxMineNumber;


        this.tab = new char[fieldSize][fieldSize];

        this.hideMine = hideMine;

    }

    public char[][] getTab() {
        return tab;
    }

    public void fillTab(char val){
        for (char[] tab: this.getTab()) {
            Arrays.fill(tab, val);
        }
    }

    public void setGame(int[]cord){
        this.fillTab(grass);
        this.setMineRandomly(cord);
        this.mineNumberCounter(this.getTab());
    }
    public void setMineRandomly(int[]baseCoordinate){
        Random rn = new Random();

        while (mineCounter < mineNumber){
            int x = rn.nextInt(fieldSize);
            int y = rn.nextInt(fieldSize);
            int[] cord = {x, y};

                if (checkIfMine(cord) && !Arrays.equals(cord, baseCoordinate)) {

                    setMine(cord, mine);
                    mineCounter += 1;

            }
        }
    }

    public void mineNumberCounter(char[][]tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] != mine) {
                    int mineCounter = 0;

                    int[] cord = {i, j};

                    try {
                        if (tab[i - 1][j - 1] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                        if (tab[i - 1][j] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                    if (tab[i - 1][j + 1] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                        if (tab[i][j - 1] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                        if (tab[i][j + 1] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                        if (tab[i + 1][j - 1] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                        if (tab[i + 1][j] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    try {
                        if (tab[i + 1][j + 1] == mine) mineCounter++;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}

                    Number number = new Number(hideNumber, mineCounter);
                    setMine(cord, number.getCharVal());

                }
            }
        }
    }

    public boolean checkIfMine(int[]cord){
        return this.tab[cord[0]][cord[1]] == grass;
    }


    public void setMine(int[]cord, char val){
        this.getTab()[cord[0]][cord[1]] = val;
    }

    public void printTab(){
        for (int i = 0; i < getTab().length; i++) {
            for (int j = 0; j < getTab()[i].length; j++) {
                if(getTab()[i][j] == mine && hideMine) System.out.print(grass + "  ");
                else if(getTab()[i][j] != mine && getTab()[i][j] != grass && hideNumber){
                    System.out.print(grass + "  ");
                }

                else{System.out.print(getTab()[i][j] + "  ");}
            }
            System.out.println();
        }
        System.out.println();
    }
}
