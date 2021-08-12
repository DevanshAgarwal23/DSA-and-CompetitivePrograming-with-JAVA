package Inheritance;

class HackerEarth {

    public void print() {
        System.out.println("In HE");
    }
}

class Hack extends  HackerEarth {
    public void print(){
        System.out.println("In hack");
    }
}


public class HMain {

    public static void main(String[] args) {
        HackerEarth obj1 = new HackerEarth();
        Hack obj2 =  new Hack();

        ((HackerEarth)obj2).print();

        obj1=obj2;

        obj1.print();
    }
}
