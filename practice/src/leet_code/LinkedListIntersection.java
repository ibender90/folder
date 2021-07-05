package leet_code;

public class LinkedListIntersection {
    public static void main(String[] args) {
        NodeSingleLink node1 = new NodeSingleLink(2);
        NodeSingleLink node2 = new NodeSingleLink(4);
        NodeSingleLink node3 = new NodeSingleLink(5);
        NodeSingleLink node4 = new NodeSingleLink(7);
        NodeSingleLink intersection = new NodeSingleLink(3);
        NodeSingleLink node6 = new NodeSingleLink(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = intersection;
        intersection.next = node6;

        NodeSingleLink nodeA = new NodeSingleLink(0);
        NodeSingleLink nodeR = new NodeSingleLink(8);
        NodeSingleLink node7 = new NodeSingleLink(3);
        NodeSingleLink node8 = new NodeSingleLink(1);

        nodeA.next = nodeR;
        nodeR.next = node7;
        node7.next = node8;

        System.out.println(getIntersection(node1, nodeA));


    }

    public static NodeSingleLink getIntersection(NodeSingleLink headA, NodeSingleLink headB) {
        NodeSingleLink nodeToCompareA = headA;
        while (nodeToCompareA != null) {
            NodeSingleLink nodeToCompareB = headB;
            while (nodeToCompareB != null) { //first to compare all of nodes linked with B with node A
                if (nodeToCompareA == nodeToCompareB) {
                    return nodeToCompareA;
                } else nodeToCompareB = nodeToCompareB.next;
            }
            nodeToCompareA = nodeToCompareA.next;
        }
        return null;
    }
}
