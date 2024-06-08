import java.util.HashMap;

/**
 * MultiList is a data structure that can contain multiple elements of different types at each index.
 * Each element at a given index is stored as an array of Objects.
 * This class allows adding, updating, and retrieving elements dynamically.
 */
public class MultiList {
    private HashMap<Integer, Object[]> list;
    private int arraySize;
    private int size;

    /**
     * Constructs a MultiList with a specified size for each array.
     *
     * @param n the size of each array in the MultiList.
     */
    public MultiList(int n) {
        this.list = new HashMap<>();
        this.arraySize = n;
        this.size = 0;
    }

    /**
     * Adds an array of elements to the MultiList.
     *
     * @param data the array of elements to be added.
     * @throws IndexOutOfBoundsException if the length of the array is not equal to arraySize.
     */
    public void add(Object... data) {
        if (data.length == arraySize) {
            list.put(size, data);
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Adds an array of elements at a specified index.
     *
     * @param index the index at which the array should be added.
     * @param data  the array of elements to be added.
     * @throws IndexOutOfBoundsException if the index is out of range or if the length of the array is not equal to arraySize.
     */
    public void addAtIndex(int index, Object... data) {
        if (index <= size && data.length == arraySize) {
            Object[] array = data;
            list.put(size, data);
            for (int i = size; i > index; i--) {
                list.put(i, list.get(i - 1));
            }
            size++;
            list.put(index, array);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Updates all elements at a specified index with a new array of elements.
     *
     * @param index the index to update.
     * @param data  the new array of elements.
     * @throws IndexOutOfBoundsException if the index is out of range or if the length of the array is not equal to arraySize.
     */
    public void updateAll(int index, Object... data) {
        if (index < size && data.length == arraySize) {
            list.put(index, data);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Updates a specific element at a given index and subindex.
     *
     * @param index    the index of the array to update.
     * @param subindex the subindex of the element to update.
     * @param data     the new element to be updated.
     * @throws IndexOutOfBoundsException if the index or subindex is out of range.
     */
    public void update(int index, int subindex, Object data) {
        if (index < size && subindex < arraySize) {
            Object[] array = list.get(index);
            array[subindex] = data;
            list.put(index, array);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the array at a specified index.
     *
     * @param index the index of the array to be removed.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void remove(int index) {
        if (index < size) {
            for (int i = index; i < size; i++) {
                list.put(i, list.get(i + 1));
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Retrieves the array of elements at a specified index.
     *
     * @param index the index of the array to retrieve.
     * @return the array of elements at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Object[] getAll(int index) {
        if (index < size) {
            return list.get(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Retrieves a specific element at a given index and subindex.
     *
     * @param index    the index of the array.
     * @param subindex the subindex of the element to retrieve.
     * @return the element at the specified index and subindex.
     * @throws IndexOutOfBoundsException if the index or subindex is out of range.
     */
    public Object get(int index, int subindex) {
        if (index < size && subindex < arraySize) {
            return list.get(index)[subindex];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Prints all elements in the array at a specified index.
     *
     * @param index the index of the array to print.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void print(int index) {
        if (index < size) {
            Object[] array = list.get(index);
            for (int i = 0; i < array.length; i++) {
                System.out.print("[" + (i + 1) + "] = " + array[i] + " ");
            }
            System.out.println();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Prints all elements in all arrays stored in the MultiList.
     */
    public void printAll() {
        for (int i = 0; i < size; i++) {
            Object[] array = list.get(i);
            for (int j = 0; j < array.length; j++) {
                System.out.print("[" + (j + 1) + "] = " + array[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns the number of arrays stored in the MultiList.
     *
     * @return the size of the MultiList.
     */
    public int size() {
        return size;
    }
}
