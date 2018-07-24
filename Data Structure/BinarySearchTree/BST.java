public class BST implements BSTInterface {
    private Node root;
    
    public BST() {
        root = null;
    }

    @Override
    public boolean find(int key) {
        if (root == null) {
            return false;
        }

        Node temp = root;
        while (temp != null) {
            if (key < temp.key) {
                temp = temp.left;
            }
            else if (key > temp.key) {
                temp = temp.right;
            }
            else {
                return true;
            }
        }

        return false;
    }

    @Override
    public void insert(int key, double value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node temp = root;
        while (true) {
            if (key < temp.key) {
                if (temp.left == null) {
                    temp.left = new Node(key, value);
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new Node(key, value);
                    return;
                }
                temp = temp.right;
            }
        }
    }
    
    @Override
    public void delete(int key) {
        if (root == null) {
            return;
        }
        Node temp = root;
        Node parent = root;
        boolean isLC = true;
        while (temp.key != key) {
            parent = temp;
            if (temp.key > key) {
                temp = temp.left;
                isLC = true;
            }
            if (temp.key < key) {
                temp = temp.right;
                isLC = false;
            }
            if (temp == null) {
                return;
            }
        }

        if (temp.left == null && temp.right == null) {
            if (temp == root) {
                root = null;
            }
            if (isLC) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }
        if (temp.left == null) {
            if (temp == root) {
                root = root.right;
                return;
            }
            if (isLC) {
                parent.left = temp.right;
            } else {
                parent.right = temp.right;
            }
            return;
        }
        if (temp.right == null) {
            if (temp == root) {
                root = root.left;
                return;
            }
            if (isLC) {
                parent.left = temp.left;
            } else {
                parent.right = temp.left;
            }
            return;
        }
        //Attention !!!
        Node succ = getSucc(temp);
        // if temp == root and root.right = succ may cause loop
        if (succ == root.right) {
            succ.left = root.left;
            root = succ;
            return;
        }

        if (isLC) {
            parent.left = succ;
        } else {
            parent.right = succ;
        }
        succ.left = temp.left;
    }
    
    private Node getSucc(Node current) {
        Node parent = current.right;
        Node succ = current.right;
        while (true) {
            if (succ.left == null) {
                break;
            }
            parent = succ;
            succ = succ.left;
        }
        //Attention!!
        if (succ != current.right) {
            parent.left = succ.right;
            succ.right = current.right;
        }

        return succ;
        
    }

    @Override
    public void traverse() {
        firstOrder(root);
    }

    private void firstOrder(Node temp) {
        if (temp == null) {
            return;
        }
        firstOrder(temp.left);
        System.out.println(temp.key);
        firstOrder(temp.right);
    }

    private static class Node {
        private int key;
        private double value;
        private Node left;
        private Node right;
        
        public Node(int k, double val) {
            key = k;
            value = val;
            left = null;
            right = null;
        }
    }
    
    public static void main(String[] args) {
        BST t = new BST();
        t.insert(0, 1);
        t.insert(1, 1);
        t.insert(2, 1);
        t.insert(-1, 1);
        t.insert(-2, 1);
        t.delete(0);
        t.traverse();
    }
}
