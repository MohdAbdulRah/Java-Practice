public class Main{
    public static void main(String args[]) throws ClassNotFoundException {
        Class.forName("Demo");
    }
}

class Demo{
    static {
        System.out.println("Static Block Added");
    }

    {
        System.out.println("Non Static Bolck Added");
    }
}