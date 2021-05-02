package Queue;

public class DynamicQueue extends MyQueue {

    @Override
    public void enqueue(int item) throws Exception {

        if(isFull()) {

            //create new arr
            int[] na = new int[2 * arr.length];

            //elements copy
            for(int i=0; i<size; i++){

                int idx = (i+front)%arr.length;
                na[i]=arr[idx];
            }

            //ref change and front=0
            arr=na;
            front=0;
        }


        super.enqueue(item);
    }
}
