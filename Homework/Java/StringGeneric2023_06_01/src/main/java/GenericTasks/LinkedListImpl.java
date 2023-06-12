package GenericTasks;

// TODO: Создайте параметризированный класс "LinkedList", представляющий связный список элементов.
//  Реализуйте методы "add", "remove" и "contains" для добавления элемента в список,
//  удаления элемента из списка и проверки, содержится ли элемент в списке соответственно.
public class LinkedListImpl<E> {
    public static void main(String[] args) {
        LinkedListImpl<Integer> l = new LinkedListImpl<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.printData();
        l.remove(2);
        l.remove(2);
        System.out.println(l.contains(2));
        System.out.println(l.contains(3));
        l.printData();
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }

        if (index == size) {
            add(data);
            return;
        }
        Node<E> res = findByIndex(index);

        res.prev.next = newNode;
        newNode.prev = res.prev;

        res.prev = newNode;
        newNode.next = res;

        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> res = findByIndex(index);

        if (index == 0) {
            head = head.next;
            head.prev = null;
            res.next = null;
            size--;
            return res.data;
        }

        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            res.prev = null;
            size--;
            return res.data;
        }
        res.prev.next = res.next;
        res.next.prev = res.prev;

        res.prev = null;
        res.next = null;
        size--;
        return res.data;
    }

    public boolean contains(E data) {
        Node<E> res = head;

        for (int i = 0; i < size; i++) {
            if (res.data.equals(data)) {
                return true;
            }
            res = res.next;
        }
        return false;
    }

    public void printData() {
        if (head == null) {
            System.out.println("LinkedList is empty.");
        } else {
            Node<E> currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }

    private Node<E> findByIndex(int index) {
        Node<E> res = head;

        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }


    private static class Node<E> {
        Node<E> prev;
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
