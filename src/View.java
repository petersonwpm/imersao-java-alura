public class View {
    public static void show(Content content) {
        System.out.println("\n \uD83D\uDCFC");
        System.out.println("\u001b[1mTitulo:\u001b[m " + content.getTitle());
        System.out.println("\u001b[1mAno:\u001b[m " + content.getYear());

        Integer rating = content.getRating();

        String stars = "\u2B50".repeat(rating);

        System.out.print(String.join(" ", stars, rating.toString()));

    }

    public static void menu() {
        System.out.println("\n\n### \uD83D\uDCFA MENU \uD83D\uDCFA ####\n");
        System.err.println("0 - Sair");
        System.out.println("1 - Listar os melhores filmes");
        System.out.println("2 - Listar as melhores series");
        System.out.println("3 - Gerar figurinhas");
        System.err.print("\nQual a sua escolha?: ");
    }
}
