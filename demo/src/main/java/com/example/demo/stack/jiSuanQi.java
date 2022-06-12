package com.example.demo.stack;

public class jiSuanQi {

    public static void main(String[] args) {
        String text = "7+3*5-2";
        int index = 0;
        String keepNum = "";

        TestStack operStack = new TestStack(10);
        TestStack numStack = new TestStack(10);

        do {
            char ch = text.substring(index, index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){ //如果当前符号大约等于栈顶符号
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int oper = operStack.pop();
                        int newNum = numStack.cal(num1, num2, oper);
                        numStack.push(newNum);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{

                    operStack.push(ch);
                }

            }else{
                //数字需要考虑多位数的情况
                keepNum = keepNum + ch;
                if(index == text.length()-1){
                    numStack.push(Integer.valueOf(keepNum));
                }else if(operStack.isOper(text.substring(index+1, index+2).charAt(0))){
                    numStack.push(Integer.valueOf(keepNum));
                    keepNum = "";
                }
            }
            index++;
        }while (index < text.length());

        int newNum = 0;
        while (true) {

            if(operStack.isEmpty()){
                break;
            }
            int newCh = operStack.pop();
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            newNum = numStack.cal(num1, num2, newCh);
            numStack.push(newNum);
        }

        System.out.println(newNum);

//        numStack.list();
//        operStack.list();
    }



    static class TestStack{
        private int maxSize;
        private int[] stackArr;
        private int top = -1;

        public TestStack(int size){
            this.maxSize = size;
            this.stackArr = new int[maxSize];
        }

        public boolean isFull(){
            int length = this.stackArr.length;
            if(top == length-1){
                return true;
            }
            return false;
        }

        public boolean isEmpty(){
            int length = this.stackArr.length;
            if(top == -1){
                return true;
            }
            return false;
        }

        public void push(int num){
            if(isFull()){
                System.out.println("栈已经满");
            }else{
                top++;
                this.stackArr[top] = num;
            }

        }


        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("栈空，没有数据~");
            }else{
                int value =  this.stackArr[top];
                top--;
                return value;
            }

        }

        public int peek(){
            if(isEmpty()){
                throw new RuntimeException("栈空，没有数据~");
            }else{
                return this.stackArr[top];
            }
        }


        public void list(){

            while(top >= 0){
                System.out.println(this.stackArr[top]+"&&&&");
                top--;
            }
        }


        public boolean isOper(char ch){
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }


        public int priority(int oper) {
            if (oper != 42 && oper != 47) {
                return oper != 43 && oper != 45 ? -1 : 0;
            } else {
                return 1;
            }
        }

        public int cal(int num1, int num2, int oper) {
            int res = 0;
            switch(oper) {
                case 42:
                    res = num1 * num2;
                    break;
                case 43:
                    res = num1 + num2;
                case 44:
                case 46:
                default:
                    break;
                case 45:
                    res = num2 - num1;
                    break;
                case 47:
                    res = num2 / num1;
            }

            return res;
        }
    }

}
