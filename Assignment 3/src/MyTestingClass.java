import java.util.Random;

public class MyTestingClass {
    public static void main(String[] args){
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(10000);
        // Add random 10000 elements to the hash table

        Random random = new Random();
        for(int i = 0; i < 10000; i++){
            MyTestingClass key = new MyTestingClass(random.nextInt(10000));
            table.put(key,i);

        }


        for ( int i = 0; i < table.same.length; i++){
            System.out.println("Bucket "+ i + " : "+ table.getSameSize(i));
        }
    }

    private int data;
    public MyTestingClass(int data){
        this.data = data;
    }
    // HashCode method that ensures uniform distribution
    public int hashCode(){
        return data;
    }

}
