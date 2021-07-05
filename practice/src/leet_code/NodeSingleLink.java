package leet_code;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeSingleLink that = (NodeSingleLink) o;
        return value == that.value && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }
}
