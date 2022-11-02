package FIFO;

import java.util.Arrays;

public class FIFO {
    protected int head;
    protected int tail;
    protected String[] buffer;

    public FIFO(int bufferSize) {
        head = 0;
        tail = 0;
        this.buffer = new String[bufferSize];
    }


    public void put(String value){
        if(tail + 1 == head && buffer[head] != null){
            System.out.println("DATA LOST");
            return;
        }

        buffer[head] = value;
        head = head == 9 ? 0 : head+1;
    }

    public void take(){
        if(tail == head && buffer[tail] == null){
            System.out.println("NO DATA");
            return;
        }

        System.out.println(buffer[tail]);
        tail = tail == 9 ? 0 : tail+1;
    }

    public void display(){
        int i = tail;

        while(i != head){
            System.out.print(buffer[i] + " ");

            i = i == buffer.length-1 ? 0 : i+1;
        }
    }
}
