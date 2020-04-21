package hema.assignment.main;
import hema.assignment.data.Variables;
import hema.assignment.singleton.StaticAndNonStatic;



public class Main {
    public static void main(String args[]) {
        Variables testingVariable = new Variables();
        testingVariable.printVariables();
        testingVariable.printLocalVariables();
        StaticAndNonStatic static_Obj = new StaticAndNonStatic();
        static_Obj.print();
    }
}