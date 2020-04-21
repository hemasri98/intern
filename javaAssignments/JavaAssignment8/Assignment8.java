package com.company;

class MyException1 extends Exception{
    int a;
    MyException1(int b) {
        a = b;
    }
    public String toString(){
        return ("Exception Number =  " + a) ;
    }
}
class MyException2 extends Exception{
    int a;
    MyException2(int b) {
        a = b;
    }
    public String toString(){
        return ("Exception Number =  " + a) ;
    }
}
class MyException3 extends Exception{
    int a;
    MyException3(int b) {
        a = b;
    }
    public String toString(){
        return ("Exception Number =  " + a) ;
    }
}

public class Assignment8 {
    public static void throwAll(int a) throws MyException1, MyException2, MyException3 {
        try {
            if (a == 1)
                throw new MyException1(1);
            else if (a == 2)
                throw new MyException2(2);
            else if (a == 3)
                throw new MyException3(3);
        }
        catch (Exception e) {
            throw e;
        }
    }
    public static void main(String args[]) {
        try{
           throwAll(4);

        }
        catch(MyException1 | MyException2 | MyException3 e ) {
            System.out.println(e);
        }
        finally {
            System.out.println("Finally block is getting executed...");
        }
    }
}
