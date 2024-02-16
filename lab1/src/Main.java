import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class MyClass {
    private String text;

    public MyClass(String text) {
        this.text = text;
    }

    public void modifyAndDisplayText() {
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
        scanner.nextLine(); // Consumăm linia rămasă pentru a evita erori de citire.

        MyClass myObject = new MyClass(enunt);

        myObject.modifyAndDisplayText();

        Map<String, Integer> cuvinteExtrase = extrageCuvinteSiNumara(enunt, lungimeSpecificata);

        System.out.println("Cuvintele cu lungimea " + lungimeSpecificata + " care încep cu o consoană (si numărul de aparitii):");
        cuvinteExtrase.forEach((cuvant, aparitii) -> System.out.println(cuvant + " - " + aparitii + " ori"));
    }

    private static Map<String, Integer> extrageCuvinteSiNumara(String text, int lungime) {
        String[] cuvinte = text.split("\\s+");
        Map<String, Integer> cuvinteExtrase = new HashMap<>();

        for (String cuvant : cuvinte) {
            if (cuvant.length() == lungime && isConsonant(cuvant.charAt(0))) {
                cuvinteExtrase.put(cuvant, cuvinteExtrase.getOrDefault(cuvant, 0) + 1);
            }
        }

        return cuvinteExtrase;
    }

    private static boolean isConsonant(char ch) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(ch) != -1;
    }
}
