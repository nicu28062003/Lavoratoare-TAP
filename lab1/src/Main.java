import java.util.Scanner;

class MyClass {
    private String text;

    public MyClass(String text) {
        this.text = text;
    }

    public void displayText() {
        System.out.println("Textul din MyClass: " + text);
    }

    public void modifyText() {
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.reverse();
        text = stringBuilder.toString();
        System.out.println("Textul modificat: " + text);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti un enunt: ");
        String enunt = scanner.nextLine();

        System.out.println("Introduceti lungimea cuvintelor: ");
        int lungimeSpecificata = scanner.nextInt();

        MyClass myObject = new MyClass(enunt);

        myObject.displayText();

        myObject.modifyText();

        String[] cuvinteExtrase = extrageCuvinte(enunt, lungimeSpecificata);

        System.out.println("Cuvintele cu lungimea " + lungimeSpecificata + " care încep cu o consoană:");
        for (String cuvant : cuvinteExtrase) {
            System.out.println(cuvant);
        }
    }

    // Metoda pentru extragerea cuvintelor cu lungimea specificată care încep cu o consoană
    private static String[] extrageCuvinte(String text, int lungime) {
        String[] cuvinte = text.split("\\s+");
        java.util.List<String> cuvinteExtrase = new java.util.ArrayList<>();

        for (String cuvant : cuvinte) {
            if (cuvant.length() == lungime && isConsonant(cuvant.charAt(0))) {
                cuvinteExtrase.add(cuvant);
            }
        }

        return cuvinteExtrase.toArray(new String[0]);
    }

    private static boolean isConsonant(char ch) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(ch) != -1;
    }
}
