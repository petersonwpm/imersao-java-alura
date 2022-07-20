

public class Content {
    private final String title;
    private final String urlImage;
    private final Integer rating;
    private final String  year;

    public Content(String title, String urlImage, Integer rating, String year) {
        this.title = title;
        this.urlImage = urlImage; 
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public Integer getRating() {
        return this.rating;
    }

    public String getYear() {
        return this.year;
    }
}
