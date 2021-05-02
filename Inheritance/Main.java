package Inheritance;

public class Main {
    public static void main(String[] args) {
        //case 1
        Parent obj1 = new Parent();
        System.out.println(obj1.d); // 10
        System.out.println(obj1.d1); // 100
        obj1.fun(); // P fun
        obj1.fun1(); // P fun 1

        //case 2  (Imp)
        Parent obj2 = new Child();
        System.out.println(obj2.d);//10
        System.out.println(obj2.d1); // 100
        System.out.println(((Child)obj2).d2); //200
        System.out.println(((Child)obj2).d); //20

        obj2.fun();
        obj2.fun1();
        ((Child)obj2).fun2();


        // case 3
        // Child obj3 = new Parent() ;

        // case 4
        Child obj4 = new Child();
        System.out.println(obj4.d);
        System.out.println(((Parent) obj4).d);
        System.out.println(obj4.d1);
        System.out.println(obj4.d2);
        obj4.fun();
        ((Parent) obj4).fun();
        obj4.fun1();
        obj4.fun2();
    }

}
