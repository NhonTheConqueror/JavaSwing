package DeadLineOn24.bt1;

import java.util.Scanner;

public class Main {

    private static String EndCode(String text, int col){
        String ans = "";
        int len = text.length();
        int row = (len%col>0) ? (int)(len/col)+1 : (int)(len/col);
        Character[][] contents = new Character[row][col];

        int i = 0;

        for(int r = 0; r<row; r++){
            for(int c = 0 ; c<col ; c++){
                if(i>=len){contents[r][c]='-'; continue;}
                if(' ' == (text.charAt(i))){contents[r][c] = '-';}
                else{contents[r][c]=text.charAt(i);}
                i++;
            }
        }

        for(int r = 0; r<col; r++){
            for(int c = 0 ; c<row ; c++){
                ans+= contents[c][r];
            }
        }        
        return ans;
    }

    private static String DeCode(String text, int col){
        String ans = "";
        int len = text.length();
        int row = len/col;

        Character[][] contents = new Character[row][col];
        
        int i = 0;

        for(int r = 0; r<col; r++){
            for(int c = 0; c<row; c++){
                contents[c][r] = ('-' == text.charAt(i)) ? ' ' : text.charAt(i);
                i++;
            }
        }
        
        for(int r = 0; r<row; r++){
            for(int c =0; c<col; c++){
                ans+=contents[r][c];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int col = scanner.nextInt();

        String ec = EndCode(text,col);
        System.out.println(ec);
        String dc = DeCode(ec, col).trim();
        System.err.println(dc);
    }
}
