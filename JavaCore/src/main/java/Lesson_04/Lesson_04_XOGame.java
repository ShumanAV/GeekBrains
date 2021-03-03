package Lesson_04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson_04_XOGame {
    //версия 1.0.0

    public static final int SIZE = 4;           //размер игрового поля, можно ставить любое число
    public static final int DOTS_TO_WIN = SIZE;    //кол-во фишек для выигрыша, по умолчанию равно размеру поля, оптимальное значение
    public static final int MIN_X = DOTS_TO_WIN - 1;          //мин число фишек игрока, когда аи начинает их блокировать, по умолчанию равно кол-ву фишек для выигрыша - 1
    public static final int MIN_O = DOTS_TO_WIN - 1;          //мин кол-во фишек аи, когда аи начинает достраивать линию для победы
    public static char[][] gameField = new char[SIZE][SIZE];    //игровое поле
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static int[][] arrAiTurns = new int[SIZE * 3][3];  //массив для возможных ходов аи
    public static int numberAiTurns = 0;        //кол-во возможных ходов аи

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {    //заполним массив точками
            for (int j = 0; j < SIZE; j++) {
                gameField[i][j] = DOT_EMPTY;
            }
        }

        System.out.println("Добро пожаловать в игру крестики-нолики");
        while (true) {
            printMassive();
            playerTurn();
            if (checkEndGame()) {
                break;
            }
            aiTurn();
            if (checkEndGame()) {
                break;
            }
        }

    }

    private static void printMassive(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j < gameField.length - 1) {
                    System.out.printf("%3s", gameField[i][j]);
                } else {
                    System.out.printf("%3s\n", gameField[i][j]);
                }
            }
        }
    }

    private static void playerTurn(){
        Scanner sc = new Scanner(System.in);
        int lineNumber = 0, columnNumber = 0;
        while (true) {
            System.out.print("ваш ход, введите координаты пустого поля, для этого, введите номер строки:");
            lineNumber = sc.nextInt() - 1;
            System.out.print("введите номер столбца:");
            columnNumber = sc.nextInt() - 1;
            if (lineNumber <= gameField.length && columnNumber <= gameField.length && gameField[lineNumber][columnNumber] == DOT_EMPTY) {
                changeMassive(lineNumber, columnNumber, DOT_X);
                break;
            }
        }
    }

    private static void aiTurn(){
        Random random = new Random();
        checkMin_XO(DOT_O, MIN_O);
        if (numberAiTurns > 0) {
            choiceLineColumn(random.nextInt(numberAiTurns));
        } else {
            checkMin_XO(DOT_X, MIN_X);
            if (numberAiTurns > 0) {
                choiceLineColumn(random.nextInt(numberAiTurns));
            } else {
                while (true) {
                    int lineNumber = 0, columnNumber = 0;
                    lineNumber = random.nextInt(SIZE);
                    columnNumber = random.nextInt(SIZE);
                    if (gameField[lineNumber][columnNumber] == DOT_EMPTY) {
                        changeMassive(lineNumber, columnNumber, DOT_O);
                        break;
                    }
                }
            }
        }
    }

    private static void choiceLineColumn(int rndLine){
        int lineNumber = 0, columnNumber = 0;
        lineNumber = arrAiTurns[rndLine][1];
        columnNumber = arrAiTurns[rndLine][2];
        changeMassive(lineNumber, columnNumber, DOT_O);
        numberAiTurns = 0;
        resetArrAiTurns();
    }

    private static void changeMassive(int i, int j, char symbol){
        gameField[i][j] = symbol;
    }

    private static boolean checkEndGame(){
        if (checkWin(DOT_X)) {
            return true;
        }
        if (checkWin(DOT_O)) {
            return true;
        }
        if (checkDraw(DOT_EMPTY)) {
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol){

        int numberXO;
        boolean endGame = false;
        for (int i = 0; i < SIZE; i++) {  //проверяем строки
            numberXO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (gameField[i][j] == symbol){
                    numberXO += 1;
                }
            }
            endGame = checkWhoWin(numberXO, DOTS_TO_WIN, symbol);
            if (endGame) {
                break;
            }
        }

        if (endGame == false) { //проверяем колонки
            for (int i = 0; i < SIZE; i++) {
                numberXO = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (gameField[j][i] == symbol) {
                        numberXO += 1;
                    }
                }
                endGame = checkWhoWin(numberXO, DOTS_TO_WIN, symbol);
                if (endGame) {
                    break;
                }
            }
        }

        if (endGame == false) { //проверяем левую диагональ
            numberXO = 0;
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][i] == symbol) {
                    numberXO += 1;
                }
            }
            endGame = checkWhoWin(numberXO, DOTS_TO_WIN, symbol);
        }

        if (endGame == false) { //проверяем правую диагональ
            numberXO = 0;
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][gameField.length - i - 1] == symbol) {
                    numberXO += 1;
                }
            }
            endGame = checkWhoWin(numberXO, DOTS_TO_WIN, symbol);
        }
        return endGame;
    }

    private static boolean checkDraw(char symbol){  //проверяем есть ли хотя бы одна точка,т.е. на ничью
        int numberXO = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameField[i][j] == symbol) {
                    numberXO += 1;
                }
            }
        }
        return checkWhoWin(numberXO, 0, symbol);
    }

    private static boolean checkWhoWin(int numberXO, int numberXONeed, char symbol) {
        if (numberXO == numberXONeed){
            printMassive();
            if (symbol == DOT_X) {
                System.out.println("Поздравляем, вы победили!");
            } else if (symbol == DOT_O){
                System.out.println("Победил исскуственный интеллект!");
            } else
                System.out.println("Ничья, победила дружба!");
            return true;
        }
        return false;
    }

    private static void checkMin_XO(char symbol, int min_xo){

        int numberXO;
        int modeSearch = 1;     //1 - строки, 2 - столбцы, 3 - левая диагональ, 4 - правая диагональ
        for (int i = 0; i < SIZE; i++) {        //проверяем строки
            numberXO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (gameField[i][j] == symbol){
                    numberXO += 1;
                }
                if (numberXO == min_xo) {
                    choiceAiTurns(i, modeSearch);
                    break;
                }
            }
        }

        modeSearch = 2;
        for (int i = 0; i < SIZE; i++) {    //проверяем колонки
            numberXO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (gameField[j][i] == symbol) {
                    numberXO += 1;
                }
                if (numberXO == min_xo) {
                    choiceAiTurns(i, modeSearch);
                    break;
                }
            }
        }


        modeSearch = 3;
        numberXO = 0;
        for (int i = 0; i < SIZE; i++) {    //проверяем левую диагональ
            if (gameField[i][i] == symbol) {
                numberXO += 1;
            }
            if (numberXO == min_xo) {
                choiceAiTurns(i, modeSearch);
                break;
            }
        }


        modeSearch = 4;
        numberXO = 0;
        for (int i = 0; i < SIZE; i++) {    //проверяем правую диагональ
            if (gameField[i][gameField.length - i - 1] == symbol) {
                numberXO += 1;
            }
            if (numberXO == min_xo) {
                choiceAiTurns(i, modeSearch);
                break;
            }
        }

    }

    private static void choiceAiTurns(int i, int modeSearch){
        switch (modeSearch){
            case 1:     //строки
                for (int j = 0; j < SIZE; j++) {
                    if (gameField[i][j] == DOT_EMPTY) {
                        writeArrAiTurns(i, j);
                        numberAiTurns += 1;
                    }
                }
                break;
            case 2:     //столбцы
                for (int j = 0; j < SIZE; j++) {
                    if (gameField[j][i] == DOT_EMPTY) {
                        writeArrAiTurns(j, i);
                        numberAiTurns += 1;
                    }
                }
                break;
            case 3:     //левая диагональ
                for (int j = 0; j < SIZE; j++) {
                    if (gameField[j][j] == DOT_EMPTY) {
                        writeArrAiTurns(j, j);
                        numberAiTurns += 1;
                    }
                }
                break;
            case 4:     //правая диагональ
                for (int j = 0; j < SIZE; j++) {
                    if (gameField[j][gameField.length - j - 1] == DOT_EMPTY) {
                        writeArrAiTurns(j, gameField.length - j - 1);
                        numberAiTurns += 1;
                    }
                }
                break;
        }

    }

    private static void writeArrAiTurns(int i, int j){
        for (int z = 0; z < arrAiTurns.length; z++) {
            if (arrAiTurns[z][0] == 0){
                arrAiTurns[z][0] = 1;
                arrAiTurns[z][1] = i;
                arrAiTurns[z][2] = j;
                break;
            }
        }
    }

    private static void resetArrAiTurns(){      //обнуляем массив перед записью ходов
        for (int i = 0; i < arrAiTurns.length; i++) {
            arrAiTurns[i][0] = 0;
            arrAiTurns[i][1] = 0;
            arrAiTurns[i][2] = 0;
        }
    }

}
