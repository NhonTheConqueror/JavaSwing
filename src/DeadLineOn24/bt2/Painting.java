package DeadLineOn24.bt2;

import java.awt.Paint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Painting extends ArtObj{
    private String paintType;
    private String style;
    
    public Painting(String artist, int year, String title, String description, String paintType, String style) {
        super(artist, year, title, description);
        this.paintType = paintType;
        this.style = style;
    }

    public Painting(){};

    public static Painting[] crePaintings(int n, boolean useSingleMode){
        Painting[] ans = new Painting[n];
        Scanner scn = new Scanner(System.in);
        // ten tp -> ten artist -> nam -> type -> style - cmt
        if(useSingleMode){
            for(int i=0;i<n;i++){
                Painting temp = new Painting();
                System.out.print("Ten tac pham: ");
                temp.setTitle(scn.nextLine()); System.out.println();
                
                System.out.print("Ten nghe si: ");
                temp.setArtist(scn.nextLine()); System.out.println();

                System.out.print("Nam sang tac: ");
                temp.setYear(scn.nextInt());scn.nextLine();System.out.println();

                System.out.print("Loai son: ");
                temp.setPaintType(scn.nextLine()); System.out.println();
                
                System.out.print("Phong cach: ");
                temp.setStyle(scn.nextLine()); System.out.println();
                
                System.out.print("Mo ta: ");
                temp.setDescription(scn.nextLine()); System.out.println();

                System.out.println("Them thanh cong!.");
                ans[i] = temp;
            }
        }

        else{
            for(int i=0;i<n;i++){
                Painting temp = new Painting();
                System.out.println("Nhap art (ten tp, ten artist, nam, type, style, cmt): ");
                String[] all = scn.nextLine().trim().split(",\\s*");
                String[] list = new String[6];

                for(int k=0; k<6; k++){
                    if(k<all.length){list[k] = all[k];}
                    else{list[k] = "";}
                    System.out.println(list[k]);
                }

                temp.setTitle((list[0].equals(""))?(list[0]):("unknown"));
                temp.setArtist((list[1].equals(""))?(list[1]):("unknown"));
                temp.setYear(Integer.parseInt((list[2].equals(""))?(list[2]):("0")));
                temp.setPaintType((list[3].equals(""))?(list[3]):("unknown"));
                temp.setStyle((list[4].equals(""))?(list[4]):("unknown"));
                temp.setDescription((list[5].equals(""))?(list[5]):(""));
                                
                System.out.println("Them thanh cong!");
                ans[i] = temp;
            }
        }

        return ans;
    }

    public static Painting[] sortPaintingsByTitle(Painting[] list, boolean acs){
       
        Arrays.sort(list, new Comparator<Painting>() {
            @Override
            public int compare(Painting p1, Painting p2){
                if(acs){return p1.getTitle().compareToIgnoreCase(p2.getTitle());}
                return p2.getTitle().compareToIgnoreCase(p1.getTitle());
            }
        } );
        return list;
    }

    public String getPaintType() {
        return paintType;
    }

    public String getStyle() {
        return style;
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public static void main(String[] args) {
        //creat test for sortPaintingsByName at class Painting
        Painting[] paintings = new Painting[3];
        paintings[0] = new Painting("Mona Lisa", 1503, "Leonardo da Vinci", "Oil on poplar panel", "Renaissance", "A portrait of Lisa Gherardini");
        paintings[1] = new Painting("The Starry Night", 1889, "Vincent van Gogh", "Oil on canvas", "Post-Impressionism", "A depiction of the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence");
        paintings[2] = new Painting("The Persistence of Memory", 1931, "Salvador Dalí", "Oil on canvas", "Surrealism", "A painting that features melting clocks in a desert landscape");     

        for (Painting p : paintings) {
            System.out.println(p.getTitle() + " by " + p.getArtist());
        }
        paintings = Painting.sortPaintingsByTitle(paintings, true);
        System.out.println("After sorting:");
        for (Painting p : paintings) {
            System.out.println(p.getTitle() + " by " + p.getArtist());
        }
    }
    
}
