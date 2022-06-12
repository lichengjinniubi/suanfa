package com.example.demo.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转换成后缀表达式并且进行计算
 */
public class jiSuanQiV2 {

    public static void main(String[] args) {
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List<String> list = jsSuanQiOperate.formatList(expression);
        List<String> resultList = jsSuanQiOperate.toHouZhuiBiaoDaShi(list);
        System.out.println(resultList);
    }


    static class jsSuanQiOperate{


        public static List<String> toHouZhuiBiaoDaShi(List<String> list){
            Stack<String> s1 = new Stack<>();
            List<String> ls = new ArrayList<>();
            jiSuanQi.TestStack testStack = new jiSuanQi.TestStack(10);

            for(String val : list){
                //如果是数字直接加入结果集合
                if(val.matches("\\d+")){ //如果是数字，直接入栈
                    ls.add((String)val);
                }else if(val.equals("(")){  //左括号也直接入栈
                    s1.push(val);
                }else if(val.equals(")")){ //右括号则把栈顶元素分别弹出知道发现左括号为止
                    while(true){
                        String item = s1.pop();
                        if(item.equals("(")){
                            break;
                        }
                        ls.add((String)item);
                    }
                }else{
                    if(s1.size() > 0 && testStack.priority(val.charAt(0)) <= testStack.priority(s1.peek().charAt(0))){
                        ls.add((String)s1.pop());
                    }
                    s1.push(val);
                }
                //如果
            }

            while(s1.size() != 0){
                ls.add((String)s1.pop());
            }

            return ls;
        }
        //把中缀表达式转换成后缀表达式
        public static List<String> formatList(String expression){
            String[] split = expression.split(" ");
            List<String> list = new ArrayList<>();
            for(String ele: split) {
                list.add(ele);
            }
            return list;
        }
    }


}
