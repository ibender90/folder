package leet_code;

public class NodeSingleLink {
    NodeSingleLink next;
    int value;
    NodeSingleLink(int x){
        this.value = x;
        next = null;
    }

    @Override
    public String toString() {
        return "NodeSingleLink{" +
                "value=" + value +
                '}';
    }
}
