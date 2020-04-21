package com.company.Assignment7.first;

interface IRodent {
    void food();
    void walk();
}

class Rodent implements IRodent{
    Rodent() {
        System.out.println("rodent class");
    }

    public void food() {
        System.out.println("food - rodent");
    }

    public void walk() {
        System.out.println("rodent walks");
    }
}


class Gerbil extends Rodent{
    Gerbil() {
        System.out.println("gerbil class");
    }
    public void food() {
        System.out.println("food - gerbil");
    }
    public void walk() {
        System.out.println("gerbil walks");
    }
}



class Mouse extends Rodent {
    Mouse() {
        System.out.println("mouse class");
    }
    public void food() {
        System.out.println("food - mouse");
    }
    public void walk() {
        System.out.println("mouse walks");
    }
}

class Hamster extends Rodent {
    Hamster() {
        System.out.println("hamster class");
    }
    public void food() {
        System.out.println("food - Hamster");
    }
    public void walk() {
        System.out.println("Hamster walks");
    }
}

public class FirstClass {
    public static void main(String[] args) {
        Rodent rodent[] = new Rodent[3];
        rodent[0] = new Mouse();
        rodent[1] = new Gerbil();
        rodent[2] = new Hamster();
        rodent[0].food();
        rodent[1].food();
        rodent[1].walk();
        rodent[2].food();
    }
}
