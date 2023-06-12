package GenericTasks;
import java.util.ArrayList;
import java.util.List;

// TODO: Создайте параметризированный класс "Stack", представляющий стек элементов.
//  Реализуйте методы "push", "pop" и "isEmpty" для добавления элемента в стек,
//  извлечения элемента из стека и проверки, пуст ли стек соответственно.
public class StackImpl<E> {
    private List<E> stack;

    public StackImpl() {
        this.stack = new ArrayList<>();
    }

    public void push(E e) {
        stack.add(e);
    }

    public E pop() {
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
