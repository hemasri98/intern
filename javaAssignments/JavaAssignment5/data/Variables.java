package hema.assignment.data;

public class Variables {
    int int_variable;
    char char_variable;
    public void printVariables()
    {
        System.out.println("integer: " + int_variable + "\n" + "character: " + char_variable);
    }
    public void printLocalVariables() {
        //int variable_1;
        //char variable_2;
        //System.out.println("integer: " + variable_1 + "\n" + "character: " + variable_2); //Cannot access local variables that are not intialized

    }
}