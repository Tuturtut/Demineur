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

    public int getFieldSize() {
        return fieldSize;
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

                    setVal(cord, mine);
                    mineCounter += 1;

            }
        }
    }

    // pos:
    // 1 2 3
    // 4   6
    // 7 8 9
    public int[] getNextCord(int[] cord, int pos){
        switch (pos) {
            case 1 -> {
                cord[0] -= 1;
                cord[1] -= 1;
            }
            case 2 -> cord[0] -= 1;
            case 3 -> {
                cord[0] -= 1;
                cord[1] += 1;
            }
            case 4 -> cord[1] -= 1;
            case 5 -> cord[1] += 1;

            case 6 -> {
                cord[0] += 1;
                cord[1] -= 1;
            }
            case 7 -> cord[0] += 1;
            case 8 -> {
                cord[0] += 1;
                cord[1] += 1;
            }
        }
        cord = checkOutsideCord(cord, getFieldSize());
        return cord;
    }

    public int[] checkOutsideCord(int[] cord, int fieldSize){
        if (cord[0] < 0) cord[0] = 0;
        if (cord[1] < 0) cord[1] = 0;
        if (cord[0] > fieldSize) cord[0] = 0;
        if (cord[1] > fieldSize) cord[1] = 0;
        return cord;
    }

    // TODO: 09/12/2021 Gerer la decouverte des cases en fonction d'une coordonée
    public void caseUnveil(int [] cord){

    }

    public int mineCounter(int[] cord){
        System.out.println(Arrays.toString(cord));

        if (getTab()[cord[0]][cord[1]] != mine) {
            int[] lastCord = cord.clone();
            char val;
            mineCounter = 0;
            for (int i = 0; i < 9; i++) {
                val = getCase(getNextCord(cord, i));
                if (val == mine) {
                    mineCounter += 1;
                }
                cord = lastCord.clone();
            }
            return mineCounter;
        }
        return -1;
    }

    // TODO: 09/12/2021 Resolve Index error with Array
    public void mineNumberCounter(char[][]tab){
        int[] cord;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                cord = new int[]{i, j};
                System.out.println(Arrays.toString(cord));
                int mineNumber = mineCounter(new int[]{i, j});

                if (mineNumber != -1) {

                    Number number = new Number(hideNumber, mineNumber);
                    setVal(cord, number.getCharVal());
                }
            }
        }
    }

    public boolean checkIfMine(int[]cord){
        return this.tab[cord[0]][cord[1]] == grass;
    }

    public char getCase(int[] cord){
        return getTab()[cord[0]][cord[1]];
    }

    public void setVal(int[]cord, char val){
        this.getTab()[cord[0]][cord[1]] = val;
    }

    public void printTab(){
        String str = "_";
        System.out.println(" " + str.repeat(getTab().length * 3) );

        for (int i = 0; i < getTab().length; i++) {

            System.out.print("|");

            for (int j = 0; j < getTab()[i].length; j++) {
                if(getTab()[i][j] == mine && hideMine) System.out.print(grass + "  ");
                else if(getTab()[i][j] != mine && getTab()[i][j] != grass && hideNumber){
                    System.out.print(grass + "  ");
                }

                else{System.out.print(getTab()[i][j] + "  ");}
            }
            System.out.println("|");
        }
        str = "-";
        System.out.println(" " + str.repeat(getTab().length * 3) );
    }
}
