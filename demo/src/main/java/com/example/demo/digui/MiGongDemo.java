package com.example.demo.digui;

/**
 * 迷宫问题
 */
public class MiGongDemo {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        int i;
        int j;
        for(i = 0; i < 7; ++i) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for(i = 0; i < 8; ++i) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        setWayV2(map, 1, 1);

        for(i = 0; i < 8; ++i) {
            for(j = 0; j < 7; ++j) {
                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }


    }


    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){ //已经走到了最后
            return true;
        }else if(map[i][j] == 0){ //还没走过
            map[i][j] = 2; //先假定这个位置是可以走通的
            //按照下->右->上->左方式来走，走不通则直接回溯
            if(setWay(map, i+1, j)){
                return true;
            }else if(setWay(map, i, j+1)){
                return true;
            }else if(setWay(map, i-1, j)){
                return true;
            }else if(setWay(map, i, j-1)){
                return true;
            }else{ //哪都走不通，直接设置为此点不通
                map[i][j] = 3;
                return false;
            }

        } else{
            return false;
        }
    }




    public static boolean setWayV2(int[][] map, int i, int j){
        if(map[6][5] == 2){ //已经走到了最后
            return true;
        }else if(map[i][j] == 0){ //还没走过
            map[i][j] = 2; //先假定这个位置是可以走通的
            //按照下->右->上->左方式来走，走不通则直接回溯
            if(setWayV2(map, i-1, j)){
                return true;
            }else if(setWayV2(map, i, j+1)){
                return true;
            }else if(setWayV2(map, i+1, j)){
                return true;
            }else if(setWayV2(map, i, j-1)){
                return true;
            }else{ //哪都走不通，直接设置为此点不通
                map[i][j] = 3;
                return false;
            }

        } else{
            return false;
        }
    }

}
