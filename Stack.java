import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    List<T> list = new ArrayList<>();

    public void push(T e){
        list.add(e);
    }

    public T pop(){
        return list.remove(0);
    }
    
    public Boolean isEmpty(){
        return list.isEmpty();
    }
}
