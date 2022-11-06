package FIFO;

import java.util.Arrays;
import java.util.Scanner;

public class FIFO {
    protected int head;
    protected int tail;
    protected int bufferSize;
    protected String[] buffer;
    protected int headCount;
    protected int tailCount;

    protected Scanner sc = new Scanner(System.in);

    public FIFO() {
        head = 0;
        tail = 0;

        headCount = 0;
        tailCount = 0;

        bufferSize = isInputCorrect();
        this.buffer = new String[bufferSize];
    }


    public void append(String value){
        if(headCount - tailCount == bufferSize){

            System.out.println("DATA LOST");
            return;
        }

        buffer[head] = value;
        head = head == bufferSize-1 ? 0 : head+1;
        headCount++;

        System.out.println("Head: " + head);
        System.out.println("Tail: " + tail);
        System.out.println("HeadCount: " + headCount);
        System.out.println("TailCount: " + tailCount);

        System.out.println(Arrays.toString(buffer));
    }

    public void get(){
        if(headCount - tailCount == 0){
            System.out.println("NO DATA");
            return;
        }

        System.out.println(buffer[tail]);
        tail = tail == bufferSize-1 ? 0 : tail+1;
        tailCount++;

        System.out.println("Head: " + head);
        System.out.println("Tail: " + tail);
        System.out.println("HeadCount: " + headCount);
        System.out.println("TailCount: " + tailCount);

        System.out.println(Arrays.toString(buffer));
    }

    public void see(){

        if (headCount - tailCount == bufferSize){
            System.out.println(Arrays.toString(buffer) );
        }else{
            int i = tail;

            while(i != head){
                System.out.print(buffer[i] + " ");

                i = i == bufferSize-1 ? 0 : i+1;
            }
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
                ", bufferSize=" + bufferSize +
                ", buffer=" + Arrays.toString(buffer) +
                ", headCount=" + headCount +
                ", tailCount=" + tailCount +
                ", sc=" + sc +
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
