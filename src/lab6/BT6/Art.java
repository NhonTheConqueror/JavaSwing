package lab6.BT6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Art {
    private String name;
    private int createdYear;
    private String typeArt;
    private String style;
    private String au;

    /* */
    public Art(String name, int createdYear, String typeArt, String style, String au) {
        this.name = name;
        this.createdYear = createdYear;
        this.typeArt = typeArt;
        this.style = style;
        this.au = au;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreatedYear() {
		return createdYear;
	}

	public void setCreatedYear(int createdYear) {
		this.createdYear = createdYear;
	}

	public String getAu() {
		return au;
	}

	public void setAu(String au) {
		this.au = au;
	}

    public static ArrayList<Art> sortByName(ArrayList<Art> arr){
    		arr.sort(
    			new Comparator<Art>() {
				@Override
				public int compare(Art o1, Art o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			}
    		);
    		return arr;
    }

    public static Art[] sortByAu(Art[] arr) {
    		Arrays.sort(arr, new Comparator<Art>() {
    			public int compare(Art x, Art y) {
    				return x.getAu().compareTo(y.getAu());
    			}
		});
    		return arr;
    }
}
