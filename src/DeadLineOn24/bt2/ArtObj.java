package DeadLineOn24.bt2;

public abstract class ArtObj{
    protected String artist;
    protected int year;
    protected String title;
    protected String description;

    public ArtObj(String artist, int year, String title, String description) {
        this.artist = artist;
        this.year = year;
        this.title = title;
        this.description = description;
    }

    public ArtObj(){};

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
