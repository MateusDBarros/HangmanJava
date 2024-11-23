import java.util.ArrayList;
import java.util.Random;
import java.lang.String;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("banana");
        palavras.add("abobora");
        palavras.add("hospital");
        palavras.add("carro");
        palavras.add("computador");

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int index = random.nextInt(5);
        String word = palavras.get(index);
        int len = word.length();
        char[] hidden = new char[len];
        int tries = 6;
        int missing = len;
        ArrayList<Character> wordsTried =  new ArrayList<>();
        boolean found;
        boolean repeated;


        for (int i = 0; i < len; i++) {
            hidden[i] = '_';
        }
        System.out.println("\t---HangMan---");
        System.out.println();
        System.out.printf("A palavra contem %d letras\n", len);
        do {

            if (tries == 0) {
                System.out.println("Numero de tentativas esgotadas");
                System.out.println("Game Over!");
                return;

            }

            System.out.print(hidden);
            System.out.println(" : Tentativas: " +tries);
            System.out.printf("Digite uma letra: ");
            char input = scanner.next().charAt(0);

            repeated = false;
            for (int j = 0; j < wordsTried.size(); j++) {
                if (input == wordsTried.get(j)) {
                    System.out.println("Palavra ja Tentada");
                    repeated = true;
                }
            }

            found = false;
            if (repeated == false) {
                for (int i = 0; i < len; i++) {
                    if (input == word.charAt(i)) {
                        hidden[i] = input;
                        missing--;
                        found = true;
                        wordsTried.add(input);
                    }

                }
            }

            if (found == false) {
                System.out.printf("Desculpe %c não esta na palavra\n", input);
                wordsTried.add(input);
                tries--;
            }



        }while (missing != 0);

        System.out.println("Parabens voce acertou! a palavra era: " +word+ " obrigado por jogar!!");

    }
}