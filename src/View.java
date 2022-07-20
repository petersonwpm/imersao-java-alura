import java.util.Map;

public class View {
    public static void show(Map<String, String> item) {
        System.out.println("\n \uD83D\uDCFC");
        System.out.println("\u001b[1mTitulo:\u001b[m " + item.get("title"));
        System.out.println("\u001b[1mAno:\u001b[m " + item.get("year"));

        String rating = item.get("imDbRating");

        String stars = "\u2B50".repeat((int) Float.parseFloat(rating));

        System.out.print(String.join(" ", stars, rating));

    }

    public static void menu() {
        System.out.println("\n\n### \uD83D\uDCFA MENU \uD83D\uDCFA ####\n");
        System.err.println("0 - Sair");
        System.out.println("1 - Listar os melhores filmes");
        System.out.println("2 - Listar as melhores series\n");
        System.err.print("Qual a sua escolha?: ");
    }
}
