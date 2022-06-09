package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class MineSweeper {

    private int rowCount;
    private int colCount;
    private int mineCount;
    private char[][] gameBoard;
    private char[][] gameMap;
    private int selectedRow;
    private int selectedCol;
    private int score;

    public MineSweeper(int rowCount,int colCount){
        this.rowCount=rowCount;
        this.colCount=colCount;
        this.mineCount=(rowCount*colCount)/4;
        this.gameBoard=new char[rowCount][colCount];
        this.gameMap=new char[rowCount][colCount];
    }

    private void minePosition(){
        for(int i=0;i<this.mineCount;i++){
            while(true){
                int a=(int)(Math.random() * this.rowCount);
                int b=(int)(Math.random() * this.colCount);
                if(this.gameMap[a][b]!='*'){
                    this.gameMap[a][b]='*';
                    break;
                }
            }
        }

    }

    private void printGameMap(){
        System.out.println("Mayınların Konumu");
        minePosition();
        for(int i=0;i<this.gameMap.length;i++){
            for(int j=0;j<this.gameMap[i].length;j++){
                if(this.gameMap[i][j]!='*'){
                    this.gameMap[i][j]='-';
                    System.out.print(this.gameMap[i][j]+" ");
                }else{
                    System.out.print(this.gameMap[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println("=====================================");
    }

    private void elementsGameBoard(){
        for(int i=0;i< this.gameBoard.length;i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                this.gameBoard[i][j] = '-';
            }
        }
    }

    private void printGameBoard(){
        for(int i=0;i< this.gameBoard.length;i++){
            for(int j=0;j<this.gameBoard[i].length;j++){
                System.out.print(this.gameBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
    private void veriAl() {
        boolean trueSelect = false;
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Bir nokta seçiniz: ");
        System.out.print("Satır giriniz: ");
        this.selectedRow = input.nextInt();
        System.out.print("Sütun giriniz: ");
        this.selectedCol = input.nextInt();
        while (!trueSelect) {
            if (this.selectedRow < 0 || this.selectedRow > this.gameBoard.length - 1 || this.selectedCol < 0 || this.selectedCol > this.gameBoard[0].length) {
                System.out.println("Oyun alanı dışında bir nokta seçtiniz,Tekrar bir nokta seçiniz: ");
                System.out.print("Satır giriniz: ");
                this.selectedRow = input.nextInt() ;
                System.out.print("Sütun giriniz: ");
                this.selectedCol = input.nextInt();
            } else {
                trueSelect = true;
            }
        }
        System.out.println("=====================================");
    }

    private int scoreCalculating(){
        this.score=0;
        if(this.selectedCol+1<=this.gameMap[0].length-1){
            if(this.gameMap[this.selectedRow][this.selectedCol+1]=='*'){
                this.score++;
            }
        }
        if(this.selectedCol-1>=0){
            if(this.gameMap[this.selectedRow][this.selectedCol-1]=='*'){
                this.score++;
            }
        }
        if(this.selectedRow+1<=this.gameMap.length-1){
            if(this.gameMap[this.selectedRow+1][this.selectedCol]=='*'){
                this.score++;
            }
        }
        if(this.selectedRow-1>=0){
            if(this.gameMap[this.selectedRow-1][this.selectedCol]=='*'){
                this.score++;
            }
        }
        if(this.selectedCol-1>=0 && this.selectedRow-1>=0){
            if(this.gameMap[this.selectedRow-1][this.selectedCol-1]=='*') {
                this.score++;
            }
        }
        if(this.selectedCol-1>=0 && this.selectedRow+1<=this.gameMap.length-1){
            if(this.gameMap[this.selectedRow+1][this.selectedCol-1]=='*'){
                this.score++;
            }
        }
        if(this.selectedCol+1<=this.gameMap[0].length-1 && this.selectedRow-1>=0){
            if(this.gameMap[this.selectedRow-1][this.selectedCol+1]=='*'){
                this.score++;
            }
        }
        if(this.selectedCol+1<=this.gameMap[0].length-1 && this.selectedRow+1<=this.gameMap.length-1){
            if(this.gameMap[this.selectedRow+1][this.selectedCol+1]=='*'){
                this.score++;
            }
        }

        return this.score;
    }

    private void changeGameBoard(){
        switch (this.scoreCalculating()){
            case 0:
                this.gameBoard[this.selectedRow][this.selectedCol]='0';
                this.gameMap[this.selectedRow][this.selectedCol]='0';
                break;
            case 1:
                this.gameBoard[this.selectedRow][this.selectedCol]='1';
                this.gameMap[this.selectedRow][this.selectedCol]='1';
                break;
            case 2:
                this.gameBoard[this.selectedRow][this.selectedCol]='2';
                this.gameMap[this.selectedRow][this.selectedCol]='2';
                break;
            case 3:
                this.gameBoard[this.selectedRow][this.selectedCol]='3';
                this.gameMap[this.selectedRow][this.selectedCol]='3';
                break;
            case 4:
                this.gameBoard[this.selectedRow][this.selectedCol]='4';
                this.gameMap[this.selectedRow][this.selectedCol]='4';
                break;
            case 5:
                this.gameBoard[this.selectedRow][this.selectedCol]='5';
                this.gameMap[this.selectedRow][this.selectedCol]='5';
                break;
            case 6:
                this.gameBoard[this.selectedRow][this.selectedCol]='6';
                this.gameMap[this.selectedRow][this.selectedCol]='6';
                break;
            case 7:
                this.gameBoard[this.selectedRow][this.selectedCol]='7';
                this.gameMap[this.selectedRow][this.selectedCol]='7';
                break;
            case 8:
                this.gameBoard[this.selectedRow][this.selectedCol]='8';
                this.gameMap[this.selectedRow][this.selectedCol]='8';
                break;

        }
    }

    private boolean checkContinue(){
        for(int i=0;i< this.gameMap.length;i++){
            for(int j=0;j< this.gameMap[i].length;j++){
                if(this.gameMap[i][j]=='-'){
                    return true;
                }
            }
        }
        return false;
    }

    private void game(){
        this.printGameMap();
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz ! ");
        System.out.println("-----------------------------------");
        this.elementsGameBoard();
        this.printGameBoard();
        while(true){
            this.veriAl();
            if(gameMap[selectedRow][selectedCol]=='*'){
                System.out.println("Mayına bastınız.");
                System.out.println("Game Over !!!");
                break;
            }else{
                this.changeGameBoard();
                this.printGameBoard();
                if(!(this.checkContinue())){
                    System.out.println("Tebrikler...Oyunu Kazandınız !");
                    System.out.println("Game Over !!!!");
                    break;
                }
            }
        }

    }
    public void run() {
        this.game();
    }}

