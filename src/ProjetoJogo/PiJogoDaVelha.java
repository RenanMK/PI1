package ProjetoJogo;

/*
1.Mostrar o tabuleiro e instruções aos jogadores  FEITO.
2.Pedir ao PLAYER 1 a entrada dos dados "Palavra  "  FEITO;
3.Pedir a confirmação ao PLAYER 1 se ele esta certo da palavra desejada.
4.Usario 2 tera 5 chances.
 */
import java.util.Arrays;
import java.util.Scanner;

public class PiJogoDaVelha {

    static Scanner leitor = new Scanner(System.in);

    public static void tabuleiro() {
        System.out.println("\n**** PROJETO INTEGRADOR ****");

        System.out.println("\n****JOGO DA FORCA ****");

        System.out.println("\n*****INTRUÇÕES:*****\n");
        System.out.println("Esse jogo e para ser jogado de duas pessoas do seguinte modo: a primeira pessoa\n");
        System.out.println("Player 1 entrará com a palavra desejada, após inserir a\npalavra confirmar se esta correta e o jogo se iniciará");
        System.out.println("Player 2 terá 5 tentativas para acertar a palavra inserida pelo Player 1.\n");

        System.out.println("    -----¬                          ");
        System.out.println("    |   _|_                         ");
        System.out.println("    |    |                          ");
        System.out.println("    |                               ");
        System.out.println("    |                               ");
        System.out.println("    |                               ");
        System.out.println("    |                               ");
        System.out.println("    |                               ");
        System.out.println("    |                               ");
        System.out.println("____|_______________________________");

    }

    public static void bonecoErro(int tentativa) {
        if (tentativa == 1) {
            System.out.println("    -----¬                          ");
            System.out.println("    |   _|_                         ");
            System.out.println("    |    |                          ");
            System.out.println("    |    O                          ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("____|_______________________________");
        } else if (tentativa == 2) {
            System.out.println("    -----¬                          ");
            System.out.println("    |   _|_                         ");
            System.out.println("    |    |                          ");
            System.out.println("    |    O                          ");
            System.out.println("    |    |                          ");
            System.out.println("    |    |                          ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("____|_______________________________");
        } else if (tentativa == 3) {
            System.out.println("    -----¬                          ");
            System.out.println("    |   _|_                         ");
            System.out.println("    |    |                          ");
            System.out.println("    |    O                          ");
            System.out.println("    |    |\\                        ");
            System.out.println("    |    | \\                       ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("____|_______________________________");
        } else if (tentativa == 4) {
            System.out.println("    -----¬                          ");
            System.out.println("    |   _|_                         ");
            System.out.println("    |    |                          ");
            System.out.println("    |    O                          ");
            System.out.println("    |   /|\\                        ");
            System.out.println("    |  / | \\                       ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("    |                               ");
            System.out.println("____|_______________________________");
        }else if (tentativa == 5) {
            System.out.println("    -----¬                          ");
            System.out.println("    |   _|_                         ");
            System.out.println("    |    |                          ");
            System.out.println("    |    O                          ");
            System.out.println("    |   /|\\                        ");
            System.out.println("    |  / | \\                       ");
            System.out.println("    |     \\                        ");
            System.out.println("    |      \\                       ");
            System.out.println("    |                               ");
            System.out.println("____|_______________________________");
        }else if (tentativa == 6) {
            System.out.println("    -----¬                          ");
            System.out.println("    |   _|_                         ");
            System.out.println("    |    |                          ");
            System.out.println("    |    O                          ");
            System.out.println("    |   /|\\                        ");
            System.out.println("    |  / | \\                       ");
            System.out.println("    |   / \\                        ");
            System.out.println("    |  /   \\                       ");
            System.out.println("    |  -----                        ");
            System.out.println("____|__|_|_|________________________");
        }
    }

    public static String iniciarFrase() {

        System.out.print("Coloque uma frase para o jogo começar: ");

        return leitor.nextLine();
    }

    public static boolean compararLetra(String frase, String letra, char[] fraseBranco) {
        //Função de comparação da letra
        boolean t = false;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.contains(letra)) {
                //Acertou
                int index = frase.indexOf(letra);
                fraseBranco[index] = letra.charAt(0);
                t = true;

            }
            if (!frase.contains(letra)) {
                //Errou
                t = false;
            }
        }
        return t;
    }

    public static char[] fraseBranco(String frase) {
        char[] fraseBranco = new char[frase.length()];
        for (int i = 0; i < fraseBranco.length; i++) {
            fraseBranco[i] = '_';
        }
        return fraseBranco;
    }

    public static void main(String args[]) {

        tabuleiro();

        String frase = iniciarFrase();

        char[] fraseBranco = fraseBranco(frase);

        for (int i = 0; i < fraseBranco.length; i++) {
            System.out.print(" " + fraseBranco[i]);
        }
        System.out.println();

        int tentativa = 0;

        while (tentativa <= 6) {
            System.out.println();
            String letra = leitor.next();
            boolean t = compararLetra(frase, letra, fraseBranco);
            if (t) {
                for (int i = 0; i < fraseBranco.length; i++) {
                    System.out.print(" " + fraseBranco[i]);
                }
            } else {
                tentativa++;
                bonecoErro(tentativa);
            }

            for (int i = 0; i < fraseBranco.length; i++) {
                if (String.copyValueOf(fraseBranco).equalsIgnoreCase(frase)) {
                    tentativa = 7;
                }
            }

        }

    }

}
