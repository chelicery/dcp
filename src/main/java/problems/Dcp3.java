package problems;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/*
Given the root to a binary tree, implement serialize(root),
which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

 */
@Setter
@Getter
@EqualsAndHashCode
public class Dcp3 {
    private List<Node> nodes = new LinkedList<>() ;

    @EqualsAndHashCode
    public static class Node {

        private final String val;
        private Node left;
        private Node right;

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node left) {
            this(val);
            this.left = left;
        }

        public Node(String val, Node left, Node right) {
            this(val, left);
            this.right=  right;
        }

    }

    public String serialize(Node node){
        if(node == null) return "#";

        return "" + node.val + "," + serialize(node.left) + "," + serialize(node.right);
    }



    public Node deserialize(String serializedNode){
        List<String> values = new ArrayList<>(List.of(serializedNode.split(",")));
        return resolveNodes(values);
    }

    private Node resolveNodes(List<String> values){
        String val = values.remove(0);

        if(val.equals("#")) return null;

        Node node = new Node(val);
        node.left = resolveNodes(values);
        node.right = resolveNodes(values);

        return node;
    }
}