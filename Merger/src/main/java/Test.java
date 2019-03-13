import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {
        ArrayList<String> argNames = new ArrayList<>();
        try {
            for (int i = 0; i < args.length; i++) {
                argNames.add(args[i]);
            }
            Checker check = new Checker();
            check.strScaning(argNames);
        }catch (Exception e) {
            System.out.println("Ошибка в работе программы");
            e.printStackTrace();
        }

    }
}
