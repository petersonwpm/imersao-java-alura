import java.util.Map;



public class View {
    public static void show(Map<String, String> item) {
        System.out.println("\n");
        System.out.println("Titulo: " + item.get("title"));
        System.out.println("Ano: " + item.get("year"));
        System.out.println(item.get("imDbRating"));
        Integer rating = Math.round(Float.parseFloat(item.get("imDbRating")));

        for (int i = 0; i < rating ; i++) {
            System.out.print("\u2B50");    
        }       
    }
}
