import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex3_ConcatERemove {

    public static void main(String... args) {

        String retorno; 
        Scanner sc = new Scanner(System.in);

        System.out.print("string inicial: ");
        String entradaInicial = sc.nextLine();

        System.out.print("string desejada: ");
        String entradaDesejada = sc.nextLine();

        System.out.print("numero de operacoes: ");
        Integer operacoes = sc.nextInt();

        retorno = concatERemove(entradaInicial, entradaDesejada, operacoes);
        System.out.println("retorno = " + retorno);

    }

    public static String concatERemove(String s, String t, int k) {
        if (s.length() >= 1 && s.length() <= 100 &&
            t.length() >= 1 && t.length() <= 100 &&
            k >= 1 && k <= 100) {

            if (!Pattern.matches("[a-z]+", s)) {
                return "não";
            }
            if (!Pattern.matches("[a-z]+", t)) {
                return "não";
            }
            int passo = 0;
            StringBuilder data = new StringBuilder(s);
            int index = 0;
            for (char c : t.toCharArray()) {
                if (s.charAt(index) != c) {
                    data.replace(passo, passo + 1, String.valueOf(c));
                    passo++;
                }
                if (passo > k) {
                    return "não";
                }
                index++;
            }
            if (data.length() > t.length()) {
                int removes = data.length() - t.length();
                passo += removes;
                if (passo > k) {
                    return "não";
                }
            }
            return "sim";
        }
        return "não";
    }
}