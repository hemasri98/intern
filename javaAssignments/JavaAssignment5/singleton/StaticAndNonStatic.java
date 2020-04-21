package hema.assignment.singleton;

public class StaticAndNonStatic {
    String string_Var;
    public static StaticAndNonStatic initializeMember(String str) {
       // string_Var = str;    //non-static fields cannot be accessed by static context(intializeMember is a static method and string_var is a non static variable)
        StaticAndNonStatic obj = new StaticAndNonStatic();
        return obj;
    }
    public void print() {
        System.out.println("String:" + string_Var);
    }
}