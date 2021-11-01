public class MyQueue {
    private class Node {
        private Object data;
        private MyQueue.Node next;

        public Node(Object data, MyQueue.Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private MyQueue.Node first;
    private MyQueue.Node last;
    private MyQueue.Node finish;
    private int size;

    public MyQueue(int size) {
        first = new MyQueue.Node(null, null);
        MyQueue.Node current = first;

        for (int i = 1; i < size; i++) {
            last = new MyQueue.Node(null, null);
            current.next = last;
            current = last;
        }
        size = 0;
        last = first;
        finish = current;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object value) {
        if (last.next == finish) {
            System.out.println("Конец списка");
            return;
        }
        last.data = value;
        last = last.next;
        size++;
    }

    public void printer() {
        MyQueue.Node result = first;

        for (int i = 0; i < size; i++) {
            if (result != null) {
                System.out.println(result.data);
                result = result.next;
                System.out.println("");
            }
        }
    }

    public void remove(int index) {
        MyQueue.Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        while (current != finish) {
            current.data = current.next.data;
            current = current.next;
        }
        size--;
    }

    public void clear() {
        first = null;
        last = first;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return first.data;
    }

    public Object poll() {
        remove(0);
        return first.data;
    }
}
