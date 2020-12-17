package ClassStudy;


public class App 
{
    public String param1 = "hello public";
    public static String param2 = "hello public static";
    private static String param3 = "hello private static";
    private String name;

    public App(String name) {
        this.name = name;
    }

    public String normal() {
        return "normal" + this.name;
    }

    public static String staticNormal() {
        return "static normal";
    }
    
    // public static String returnParam1() {
    //     return this.param1;
    // }

    public static String returnParam2() {
        return param2;
    }

    public static String returnParam3() {
        return param3;
    }

    public static void main(String[] args) {
        App app = new App("app name");
        System.out.println(app.normal());
        System.out.println(staticNormal());
    }
}
