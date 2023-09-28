import java.util.*;

//Martha Rdz
public class Deck {
    public static void main(String[] args) {

        //Creamos las cartas
        Card card = new Card();
        int palo = card.palo.length;
        int valor = card.valor.length;
        int color = card.color.length;

        //Inicio del deck
        ArrayList<String> deck = new ArrayList<String>();
        for (int i = 0; i<valor; i++){
            for (int j= 0; j<palo; j++){
                if (j==0||j==2){
                    //crea cartas negras
                    deck.add(card.palo[j]+", Negro, "+card.valor[i]);
                } else {
                    //crea cartas rojas
                    deck.add(card.palo[j] + ", Rojo, " + card.valor[i]);
                }
            }
        }

        //Menú de opciones
        Scanner teclado = new Scanner(System.in);

        String op = "";

        for(;;) {
            System.out.println("Bienvenido a poker");
            System.out.println("Selecciona la opción que deseas realizar");
            System.out.println("1.Shuffle");
            System.out.println("2.Head");
            System.out.println("3.Pick");
            System.out.println("4.Hand");
            System.out.println("5.Salir");
            op = teclado.nextLine();

            switch (op) {
                case "1":
                    shuffle(deck);
                    break;
                case "2":
                    head(deck);
                    break;
                case "3":
                    pick(deck);
                    break;
                case "4":
                    hand(deck);
                    break;
                case "5":
                    System.out.println("Gracias por jugar");
                    System.exit(0);
                    break;
            }
        }
    }

    public static class Card{
        ArrayList<String> deck = new ArrayList<String>();
        String[] palo = {"Trebol", "Diamantes", "Picas", "Corazon"};
        String[] valor = {"2","3","4","5","6","7","8","9","10","A","J","Q","K"};
        String[] color = {"Rojo", "Negro"};
    }

    //Método para mezclar las cartas
    public static void shuffle(ArrayList deck){
        ArrayList<String> values = deck;
        Collections.shuffle(values);
        System.out.println("Se mezcló el Deck");
    }

    //Método para ver la carta de encima del deck
    public static void head (ArrayList deck){
        System.out.println(deck.get(0));
        deck.remove(0);
        System.out.println("Quedan "+deck.size()+" cartas en el Deck");
    }

    //Método para escoger una carta al azar
    public static void pick (ArrayList deck){
        Random aleatorio = new Random();
        System.out.println(deck.get(aleatorio.nextInt(deck.size())));
        deck.remove(aleatorio.nextInt(deck.size()));
        System.out.println("Quedan "+deck.size()+" cartas en el Deck");
    }

    //Método para ver las cartas de la "mano"
    public static void hand (ArrayList deck){
        for (int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i = 0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("Quedan "+deck.size()+" cartas en el Deck");
    }
}