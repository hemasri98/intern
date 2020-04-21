package com.company.Assignment7.fourth;


interface Cycle {
    void balance();
}

interface CycleFactory {
    Cycle cycleType();
}

class UniCycle implements Cycle {
    public void balance() {
        System.out.println("balancing unicycle");
    }
}

class BiCycle implements Cycle {
    public void balance() {
        System.out.println("balancing bicycle");
    }
}
class TriCycle implements Cycle {
    public void balance() {
        System.out.println("balancing tricycle");
    }
}



class UniCycleFactory implements CycleFactory {
    public Cycle cycleType() {
        return new UniCycle();
    }
}


class BiCycleFactory implements CycleFactory {
    public Cycle cycleType() {
        return new BiCycle();
    }
}

class TriCycleFactory implements CycleFactory {
    public Cycle cycleType() {
        return new TriCycle();
    }
}


public class FourthClass {
    public static void callFactory(CycleFactory factory) {
        Cycle cycle = factory.cycleType();
        cycle.balance();
    }
    public static void main(String[] args) {
        UniCycle cycle = new UniCycle();
        cycle.balance();
        callFactory(new BiCycleFactory());
        callFactory(new TriCycleFactory());
    }
}
