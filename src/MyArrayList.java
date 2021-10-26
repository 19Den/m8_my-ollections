public class MyArrayList {
    private Object[] data = new Object[0];

    public void printer() {
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public void add(Object value) {
        Object[] temporary = new Object[data.length + 1];
        System.arraycopy(data, 0, temporary, 0, data.length);
        temporary[temporary.length - 1] = value;
        data = temporary.clone();
    }

    public void remove(int index) {
        Object[] temporary = new Object[data.length - 1];
        System.arraycopy(data, 0, temporary, 0, index);
        System.arraycopy(data, index + 1, temporary, index, data.length - index - 1);
        data = temporary.clone();
    }

    public void clear() {           //очищает коллекцию
        data = null;
    }

    public int size() {
        return data.length;
    }

    public Object get(int index) {
        try {
            return data[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс выходит за пределы массива");
            return null;
        }
    }
}
