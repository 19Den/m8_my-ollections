public class MyHashMap {
    private class Node {

        private Object key;
        private Object value;
        private MyHashMap.Node next;

        public Node(Object key, Object value, MyHashMap.Node next) {

            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final int numberCelles = 16;
    Node[] table = new Node[numberCelles];
    private int size = 0;

    public MyHashMap() {
        clear();
    }

    private int hashIndex(Object key) {
        return (key == null) ? 0 : (key.hashCode()) % 16;
    }

    public void put(Object key, Object value) {
        int hashValue = hashIndex(key);
        if (table[hashValue] == null) {
            table[hashValue] = new Node(key, value, null);
            size++;
        } else {
            Node p = table[hashValue];
            Node t = null;
            boolean find = false;

            while ((p != null) && (!find)) {
                if (p.key.equals(key)) {
                    p.value = value;
                    find = true;
                }
                t = p;
                p = p.next;
            }
            if (!find) {
                p = new Node(key, value, null);
                t.next = p;
            }
        }
    }

    public void remove(Object key) {
        int hashValue = hashIndex(key);
        if (table[hashValue] == null) {
            System.out.println("Введенный ключ отсутствует");
            return;
        }
        Node p = table[hashValue];
        Node t = null;
        boolean find = false;

        while ((p != null) && (!find)) {
            if (p.key.equals(key)) {
                find = true;
                if (t == null) {
                    table[hashValue] = p.next;
                } else {
                    t.next = p.next;
                }
            }
            t = p;
            p = p.next;
        }
    }

    public void printer() {

        for (int i = 0; i < table.length; i++) {
            System.out.print(i + " - ");
            for (Node node = table[i]; node != null; node = node.next) {
                System.out.print(" k:" + node.key + " v:" + node.value);
            }
            System.out.println("");
        }
    }


    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int hashValue = hashIndex(key);
        for (Node node = table[hashValue]; node != null; node = node.next) {
            return node.value;
        }
        return null;
    }
}

