package com.company.Assignment7.fifth;


class OuterClass_1 {
    class InnerClass_1 {
        InnerClass_1(String str) {
            System.out.println("Innerclass constructor with parameter " + str);
        }
    }
}
class OuterClass_2 extends OuterClass_1{
    class InnerClass_2  extends OuterClass_1.InnerClass_1{
        InnerClass_2(String str) {
            super(str);
        }
    }
}

public class FifthClass {
    public static void main(String[] args) {
        OuterClass_2 outclass1 = new OuterClass_2();
        OuterClass_2.InnerClass_2 in = outclass1.new InnerClass_2("string");
    }
}

