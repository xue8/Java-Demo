
public class test {
    public test(){
        System.out.println("5");
    }

    {
        System.out.println("3");
    }
    static {
        System.out.println("2");
    }
    public static void main(String[] args) {

        aa();
    }

    public static void aa(){
        System.out.println("4");
    }
}
