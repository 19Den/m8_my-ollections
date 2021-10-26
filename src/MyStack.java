public class MyStack {
    private class Node {
        private Object data;
        private MyStack.Node next;
        private MyStack.Node prev;

        public Node(Object data, MyStack.Node prev, MyStack.Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyStack.Node first;
    private MyStack.Node last;
    private int size;

    public MyStack() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object value) {

        if (!isEmpty()) {
            MyStack.Node obj = last;
            last = new MyStack.Node(value, obj, null);
            obj.next = last;
        } else {
            last = new MyStack.Node(value, null, null);
            first = last;
        }
        size++;
    }

    public void printer() {
        MyStack.Node result = first;
        for (int i = 0; i < size; i++) {
            System.out.println(result.data);
            result = result.next;
        }
        System.out.println("");
    }

    public void remove(int index) {
        MyStack.Node result = first;
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

        MyStack.Node result = last;

        return result.data;
    }

    public Object pop() {
        MyStack.Node result = last;
        remove(size - 1);

        return result.data;
    }
}
