import java.util.ArrayList;
import java.util.List;

/*
705. Design HashSet

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 
Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
*/

class MyHashSet {
    List<Integer> list1;

    public MyHashSet() {
        list1 = new ArrayList<>();  
    }
    
    public void add(int key) {
        for(int num: list1){
            if(num == key) return;
        }
        list1.add(key);
    }
    public void remove(int key) {
        //list1.remove(index);
        //list1.remove(Object obj)
        //Therefore had to use Integer.valueOf
        
        // This makes a call to remove(Object) and
         list1.remove(Integer.valueOf(key));
       
    }
    
    public boolean contains(int key) {
        for(int num: list1){
            if(num == key) return true;
        }        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */