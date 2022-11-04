package FIFO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        FIFO fifo = new FIFO();
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new FileReader("karaoke.txt"));

        String line = br.readLine();

        while(line != null){
            int random = rd.nextInt(2);

            String in = sc.nextLine();

            if (in.equals("")) {
                if (random == 1) {
                    System.out.println("PUT");
                    fifo.append(line);

                    line = br.readLine();
                } else {
                    System.out.println("TAKE");
                    fifo.get();
                }

            }else{
               fifo.see();
            }
        }

    }
}
