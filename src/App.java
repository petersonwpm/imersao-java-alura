import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("### MENU ####");
        System.err.println("0 - Sair");
        System.out.println("1 - Listar os melhores filmes");
        System.out.println("2 - Listar as melhores series");
        System.err.print("Qual a sua escolha?: ");

        Scanner scanner = new Scanner(System.in);

        int opt = scanner.nextInt();

        scanner.close();

        switch (opt) {
            case 0:
                // end
                break;
            
            case 1:
                Api.getMovies();
            
            case 2:
                Api.getSeries();
        
            default:
                break;
        }
    }  
}