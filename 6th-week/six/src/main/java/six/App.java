package six;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.printMethod();

        Animal myCat = new Cat();
        Animal.testClassMethod();
        Cat.testClassMethod();
        myCat.testInstanceMethod();

        
        // object of type A 
        A a = new A(); 

        // object of type B 
        B b = new B(); 

        // object of type C 
        C c = new C(); 

        // obtain a reference of type A 
        A ref; 
            
        // ref refers to an A object 
        ref = a; 

        // calling A's version of m1() 
        ref.m1(); 

        // now ref refers to a B object 
        ref = b; 

        // calling B's version of m1() 
        ref.m1(); 

        // now ref refers to a C object 
        ref = c; 

        // calling C's version of m1() 
        ref.m1(); 

        A d = new B();
        System.out.println(d.x);
            
    }
}
