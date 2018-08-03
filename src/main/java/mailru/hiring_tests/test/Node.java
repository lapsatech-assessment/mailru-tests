package mailru.hiring_tests.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Node {

  private static int i = 1;
  private static Node[] cache = new Node[100];

  final int id;
  Node parent;
  Node left;
  Node right;

  Node() {
    id = i++;
    cache[id] = this;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "node-" + id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof Node))
      return false;
    Node othr = (Node) obj;
    return othr.id == id;
  }

  public void dump() {
    _dumpLevel(0);
  }

  private void _dumpLevel(int l) {
    for (int i = 0; i < l; i++)
      System.out.print("  ");
    System.out.println(toString());
    if (left != null)
      left._dumpLevel(l + 1);
    if (right != null)
      right._dumpLevel(l + 1);
  }

  void appendLeafs() {
    left = new Node();
    right = new Node();
    left.parent = this;
    right.parent = this;
  }

  Node[] vector() {
    List<Node> list = new ArrayList<>();
    Node b = this;
    do {
      list.add(b);
      b = b.parent;
    } while (b != null);
    Collections.reverse(list);
    return list.toArray(new Node[0]);
  }

  public static Node findCommonAnsestor(Node a, Node b) {
    Node[] vector1 = a.vector();
    Node[] vector2 = b.vector();
    Node res = vector1[0];

    for (int i = 0; i < vector1.length && i < vector2.length; i++) {
      if (vector1[i] != vector2[i])
	break;
      res = vector1[i];
    }
    return res;
  }

  public static Node findCommonAnsestor1(Node a, Node b) {
    Deque<Node> q1 = new LinkedList<>();
    Deque<Node> q2 = new LinkedList<>();
    do {
      q1.push(a);
      a = a.parent;
    } while (a != null);
    do {
      q2.push(b);
      b = b.parent;
    } while (b != null);

    Node res, n1 = null, n2;
    do {
      res = n1;
      n1 = q1.poll();
      n2 = q2.poll();
    } while (n1 != null && n2 != null && n1 == n2);
    return res;
  }

  public static void main(final String[] args) {
    Node n = new Node();
    n.appendLeafs();
    n.left.appendLeafs();
    n.right.appendLeafs();
    n.left.left.appendLeafs();
    n.left.left.left.appendLeafs();
    n.left.right.appendLeafs();
    n.right.left.appendLeafs();
    n.right.right.appendLeafs();
    n.right.right.left.appendLeafs();
    n.dump();

    Node n1 = findCommonAnsestor(cache[6], cache[19]);
    System.out.println();
    System.out.println(n1);

    Node n2 = findCommonAnsestor1(cache[6], cache[19]);
    System.out.println();
    System.out.println(n2);

  }

}