package com.example.demo.tree;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        //Ҫ�����������������
        //int arr[] = {4, 6, 8, 5, 9};
        // ����Ҫ��80000�������������
        int[] arr = new int[8];
//        for (int i = 0; i < 8; i++) {
//            arr[i] = i+ (int) (Math.random() * 10); // ����һ��[0, 8000000) ��
//        }
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 7;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 1;
        arr[7] = 8;

//        System.out.println("����ǰ");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("����ǰ��ʱ����=" + date1Str);

        heapSort(arr);

//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("����ǰ��ʱ����=" + date2Str);
        //System.out.println("�����=" + Arrays.toString(arr));
    }

    //��дһ��������ķ���
    public static void heapSort(int arr[]) {
        int temp = 0;

        System.out.println("堆序列化之前数组=" + Arrays.toString(arr));
        //把要排序的数组先构造成一个大顶堆，(arr.length / 2 -1)是去堆中最后一个非叶子节点
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeap(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("堆序列化之后数组=" + Arrays.toString(arr));
		//对已经生成好的大顶堆进行排序
        for(int j = arr.length-1;j >0; j--) {
            //����
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //每次排序过后剩下的数组已经被打乱，不再是一个大顶堆，需要重新进行堆序列化
            adjustHeap(arr, 0, j);
        }

        System.out.println("排序之后数组=" + Arrays.toString(arr));

    }



   //看不懂就debug看一下把，配合着资料
    public  static void adjustHeap(int arr[], int i, int lenght) {

        int temp = arr[i];

        //1. k = i * 2 + 1 先找当前元素的左子树，然后再找右子树，
        for(int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if(k+1 < lenght && arr[k] < arr[k+1]) { //左子树的值是否小于右子树
                k++; //如果小于右子树，则把k指向右子树
            }
            if(arr[k] > temp) {
                arr[i] = arr[k]; //再数组中进行节点交换
                i = k; //把i赋给k
            } else {
                break;//
            }
        }
        //
        arr[i] = temp;//��tempֵ�ŵ��������λ��
    }
}
