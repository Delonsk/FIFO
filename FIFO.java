package FIFO;

import java.util.Arrays;
import java.util.Scanner;

public class FIFO {
    protected int head;
    protected int tail;
    protected int bufferSize;
    protected String[] buffer;

    protected Scanner sc = new Scanner(System.in);

    public FIFO() {
        head = 0;
        tail = 0;
        bufferSize = isInputCorrect();
        this.buffer = new String[bufferSize];
    }


    public void append(String value){
        if((tail + 1 == head || tail == 0 && head == 0) && buffer[head] != null){

            System.out.println("DATA LOST");
            return;
        }

        buffer[head] = value;
        head = head == bufferSize-1 ? 0 : head+1;
    }

    public void get(){
        if(tail == head && buffer[tail] == null){
            System.out.println("NO DATA");
            return;
        }

        System.out.println(buffer[tail]);
        tail = tail == bufferSize-1 ? 0 : tail+1;
    }

    public void see(){
        int i = tail;

        while(i != head){
            System.out.print(buffer[i] + " ");

            i = i == bufferSize-1 ? 0 : i+1;
        }
    }

    public int isInputCorrect(){
        System.out.println("Zadajte velkost bufferu");
        String text = sc.nextLine();

        if (!text.matches("[0-9]+")) {
            System.out.println("Zadany text nie je spravny");
            System.exit(0);
        }

        return Integer.parseInt(text);
    }

    public int freeCap(){
        int i = tail;
        int free = 0;

        while(i != head){
            free++;
            i = i == buffer.length-1 ? 0 : i+1;
        }

        return free;
    }

    public void clear(){
        head = 0;
        tail = 0;
    }

    @Override
    public String toString() {
        return "FIFO{" +
                "head=" + head +
                ", tail=" + tail +
                ", buffer=" + Arrays.toString(buffer) +
                '}';
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public String[] getBuffer() {
        return buffer;
    }
}
