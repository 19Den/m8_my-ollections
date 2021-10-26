public class MyLinkedList {

    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object value) {

        if (!isEmpty()) {
            Node obj = last;
            last = new Node(value, obj, null);
            obj.next = last;
        } else {
            last = new Node(value, null, null);
            first = last;
        }
        size++;

    }

    public void printer() {
        Node result = first;

        for (int i = 0; i < size; i++) {
            System.out.println(result.data);
            result = result.next;
        }
        System.out.println("");
    }

    public void remove(int index) {
        Node result = first;

        for (int i = 0; i < index; i++) {
            if (result == null) {
                System.out.println("Элемент с заданным индексом отсутствует в списке");
                return;
            }
            result = result.next;
        }

        if (result == null) {
            System.out.println("Элемент с заданным индексом отсутствует в списке");
            return;
        }

        if (size == 1) {
            clear();
            return;
        }

        if (result.prev != null) {
            result.prev.next = result.next;
        } else {
            first = result.next;
            first.prev = null;
        }

        if (result.next != null) {
            result.next.prev = result.prev;
        } else {
            last = result.prev;
            last.next = null;
        }
        size--;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }
}
