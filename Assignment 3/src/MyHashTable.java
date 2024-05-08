import org.w3c.dom.Node;

import java.security.Provider;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

public class MyHashTable<K,V> {
    LinkedList <Node<K,V>>[] same;
    private int size;
    private static final int Default_same = 35;

    public MyHashTable(){
        this(Default_same);
    }
    //This is a class constructor that initializes an array of buckets = same with a given capacity and creates a new LinkedList for each bucket = same.
    // The size field is set to 0 because the hash table is empty at the beginning.
    public MyHashTable(int sameis){
        same = new LinkedList[sameis];
        for (int i = 0; i < sameis; i++){
            same[i] = new LinkedList<>();
        }
        size = 0;
    }



    private static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //This is a put method that adds a key-value pair to a hash table.
    //It calculates the index of the bucket to store the item, checks whether an item with that key already exists,
    // and either updates the value or adds a new node to the bucket list.
    public void put(K key, V value){
        int i = getIndex(key);
        LinkedList<Node<K,V>> bucket = same[i];
        for(Node<K, V> node: bucket){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        bucket.add(new Node<>(key, value));
        size++;
    }
    // This is a get method that returns the value associated with the specified key.
    // It calculates the cart index to find the item and traverses the cart list to find the item with the matching key.
    public int size(){
        return size;
    }
    public V get(K key){
        int i = getIndex(key);
        LinkedList<Node<K,V>> bucket = same[i];
        for(Node<K, V> node: bucket){
            if(node.key.equals(key)){
                return node.value;
            }
    }
        return null;
    }
    private int getIndex(K key){
        return Math.abs(key.hashCode())% same.length;
    }
    public int getSameSize(int index) {
        if (index < 0 || index >= same.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        return same[index].size();
    }


}
