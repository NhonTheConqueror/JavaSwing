package bt2;

public class Sculpture extends ArtObj{
    private String materialFrom;
    private double height,weight; //cao, nang
    private String style;

    public Sculpture(String artist, int year, String title, String description, String materialFrom, double height,
            double weight, String style) {
        super(artist, year, title, description);
        this.materialFrom = materialFrom;
        this.height = height;
        this.weight = weight;
        this.style = style;
    }

    public String getMaterialFrom() {
        return materialFrom;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getStyle() {
        return style;
    }
        

}
