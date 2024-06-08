public class Usage {
    public static void main(String[] args) {
        // Create a MultiList object with an array size of 3
        MultiList multiList = new MultiList(3);

        // Add arrays of different types to the MultiList
        multiList.add(1, "Hello", 3.14);
        multiList.add(2, "World", 2.71);

        // Print all elements in the MultiList
        System.out.println("Initial MultiList:");
        multiList.printAll();
        
        // Update a specific element
        multiList.update(0, 1, "LinkedIn");
        System.out.println("\nMultiList after updating index 0, subindex 1:");
        multiList.printAll();

        // Add an element at a specific index
        multiList.addAtIndex(1, 3, "Java", 1.61);
        System.out.println("\nMultiList after adding at index 1:");
        multiList.printAll();

        // Retrieve all elements at a specific index
        System.out.println("\nElements at index 1:");
        Object[] elements = multiList.getAll(1);
        for (int i = 0; i < elements.length; i++) {
            System.out.println("Element " + (i + 1) + ": " + elements[i]);
        }

        // Remove an element at a specific index
        multiList.remove(1);
        System.out.println("\nMultiList after removing element at index 1:");
        multiList.printAll();

        // Retrieve a specific element
        Object element = multiList.get(0, 2);
        System.out.println("\nElement at index 0, subindex 2: " + element);
    }
}
