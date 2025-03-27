public class MyQueue<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public MyQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        E item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    public E start() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}