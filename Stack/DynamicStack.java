package Stack;

public class DynamicStack extends MyStack{

    @Override
    void push(int x) throws Exception {

        if(isFull()){

            //create a new array of double size
            int[] newArray = new int[arr.length*2];

            //copy the content of old array in new array
            for(int i=0;i<arr.length;i++){
                newArray[i]=arr[i];
            }

            //reference  change
            arr = newArray;

        }


        super.push(x);
    }
}
