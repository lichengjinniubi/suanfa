package com.example.demo.digui;

import java.sql.Array;
import java.util.Arrays;

/**
 * 八皇后问题
 */
public class BaHuangHou {

    int max = 8;
    int[] array;

    public BaHuangHou(){
        array = new int[this.max];
    }

    public static void main(String[] args) {
        BaHuangHou queue8 = new BaHuangHou();
        queue8.check(0);
    }


    private void check(int n){
        if(n == this.max){
            print();
            return;
        }else{
            for(int i = 0; i < this.max; i++){
                //数组里key是第几个皇后，i是每一行的第几个位置，这个地方是个关键，这样存储数据便于判断是否是同一行或者同一条斜线
                this.array[n] = i;
                boolean ret = judge(n);
                //通过打印可以看出来每一个回溯的过程
                System.out.println(n);
                System.out.println(Arrays.toString(this.array));
                System.out.println(ret);
                System.out.println("--------------");
                if(ret){ //满足条件就可以进入下一个皇后的放置过程，如果循环完毕仍旧没有进入下一个皇后的放置，则继续完成上一个皇后的放置循环，直到找到最合适的放置位置
                    this.check(n+1);
                }
            }
        }

    }


    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            //如果当前皇后和之前任意一个皇后的列相同或者在一条斜线上，都不满足条件
            if (this.array[i] == this.array[n] || Math.abs(n - i) == Math.abs(this.array[n] - this.array[i])) {
                return false;
            }
        }

        return true;
    }

    private void print() {

        for(int i = 0; i < this.array.length; ++i) {
            System.out.print(this.array[i] + " ");
        }

        System.out.println();
    }
}
