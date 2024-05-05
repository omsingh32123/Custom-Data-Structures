/**
 * AdvancedList is a custom data structure similar to ArrayList but implemented using a HashMap for efficiency.
 * It supports dynamic resizing and provides efficient insertion, deletion, and retrieval operations.
 *
 * AdvancedList improves upon the traditional ArrayList by leveraging a HashMap internally,
 * which allows for faster element access and manipulation, especially in scenarios involving
 * frequent insertions and deletions.
 */
import java.util.*;
public class AdvancedList {

    private HashMap<Integer, Integer> map;
    private int size;

    /**
     * Constructs an empty AdvancedList.
     */
    public AdvancedList() {
        map = new HashMap<>();
        size = 0;
    }

    /**
     * Constructs an AdvancedList initialized with the elements from the given array.
     * @param array the array whose elements are to be added to the AdvancedList
     */
    public AdvancedList(int[] array) {
        map = new HashMap<>();
        for (size = 0; size < array.length; size++) {
            map.put(size, array[size]);
        }
    }

    /**
     * Constructs a copy of the specified AdvancedList.
     * @param advancedList the AdvancedList to be copied
     */
    public AdvancedList(AdvancedList advancedList) {
        this.size = advancedList.size;
        this.map = new HashMap<>(advancedList.map);
    }

    /**
     * Returns the number of elements in the AdvancedList.
     * @return the number of elements in the AdvancedList
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of the AdvancedList.
     * @param data the element to be added
     */
    public void add(int data) {
        map.put(size, data);
        size++;
    }

    /**
     * Adds all elements from the specified array to the end of the AdvancedList.
     * @param array the array containing elements to be added
     */
    public void addAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            map.put(size + i, array[i]);
        }
        size += array.length;
    }

    /**
     * Removes the element at the specified index from the AdvancedList.
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            map.put(i, map.get(i + 1));
        }
        map.remove(size - 1);
        size--;
    }

    /**
     * Removes all occurrences of the specified element from the AdvancedList.
     * @param data the element to be removed
     */
    public void removeElement(int data) {
        for (int i = 0; i < size; i++) {
            if (map.get(i) == data) {
                remove(i);
                i--; // Adjust index after removal
            }
        }
    }

    /**
     * Removes all occurrences of elements in the specified array from the AdvancedList.
     * @param array the array containing elements to be removed
     */
    public void removeAllElement(int[] array) {
        for (int element : array) {
            removeElement(element);
        }
    }

    /**
     * Retrieves the element at the specified index from the AdvancedList.
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
        return map.get(index);
    }

    /**
     * Replaces the element at the specified index with the specified data.
     * @param index the index of the element to be replaced
     * @param data the new data to be set at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void set(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
        map.put(index, data);
    }

    /**
     * Checks if the AdvancedList contains the specified element.
     * @param data the element to be checked for presence
     * @return true if the AdvancedList contains the element, otherwise false
     */
    public boolean contains(int data) {
        return map.containsValue(data);
    }

    /**
     * Returns the index of the first occurrence of the specified element in the AdvancedList.
     * @param data the element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(int data) {
        for (int i = 0; i < size; i++) {
            if (map.get(i) == data) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes all elements from the AdvancedList, making it empty.
     */
    public void clear() {
        size = 0;
        map.clear();
    }

    /**
     * Creates and returns a copy of this AdvancedList.
     * @return a copy of this AdvancedList
     */
    public AdvancedList clone() {
        return new AdvancedList(this);
    }

    /**
     * Prints all elements of the AdvancedList.
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(map.get(i));
        }
    }
}
