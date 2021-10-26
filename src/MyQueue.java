public class MyQueue {
    private class Node {
        private Object data;
        private MyQueue.Node next;
        private MyQueue.Node prev;

        public Node(Object data, MyQueue.Node prev, MyQueue.Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyQueue.Node first;
    private MyQueue.Node last;
    private int size;

    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object value) {

        if (!isEmpty()) {
            MyQueue.Node obj = last;
            last = new MyQueue.Node(value, obj, null);
            obj.next = last;
        } else {
            last = new MyQueue.Node(value, null, null);
            first = last;
        }
        size++;
    }

    public void printer() {
        MyQueue.Node result = first;

        for (int i = 0; i < size; i++) {
            System.out.println(result.data);
            result = result.next;
        }
        System.out.println("");
    }

    public void remove(int index) {
        MyQueue.Node result = first;

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

    public int size() {                         //возвращает размер коллекции
        return size;
    }

    public Object peek() {

        MyQueue.Node result = first;

        return result.data;
    }

    public Object poll() {
        MyQueue.Node result = first;
        remove(0);
        return result.data;
    }
}
