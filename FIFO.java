import java.util.Arrays;

public class FIFO {
    protected int head;
    protected int tail;
    protected String[] buffer;
    protected boolean first;

    public FIFO(int bufferSize) {
        head = 0;
        tail = 0;
        first = true;
        this.buffer = new String[bufferSize];
    }


    public void append(String value){
        if((tail + 1 == head || tail == 0 && head == 0) && buffer[head] != null){

            System.out.println("DATA LOST");
            return;
        }

        if (first){
            first = false;
        }

        buffer[head] = value;
        head = head == 9 ? 0 : head+1;
    }

    public void get(){
        if(tail == head && buffer[tail] == null){
            System.out.println("NO DATA");
            return;
        }

        System.out.println(buffer[tail]);
        tail = tail == 9 ? 0 : tail+1;
    }

    public void see(){

        if (first){
            System.out.println("");
        }else{
            if (!first && (head == 0 && tail == 0)){
                System.out.println(Arrays.toString(buffer));
                return;
            }

            int i = tail;

            while(i != head){
                System.out.print(buffer[i] + " ");

                i = i == buffer.length-1 ? 0 : i+1;
            }

        }
    }
}
