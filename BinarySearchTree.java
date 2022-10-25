import java.util.Scanner;

public class BinarySearchTree {

        class node {
            int data;
            node left;
            node right;

            public node(int x)
            {
                data = x;
                left = null;
                right = null;
            }
        }
        private node root;

        public void insert(int x ) {
            node temp, ptr;
            temp = new node(x);
            temp.left = null;
            temp.right = null;

            if (root == null) {
                root = temp;
            } else {
                ptr = root;
                while (ptr != null) {
                    if (x > ptr.data) {
                        if (ptr.right == null) {
                            ptr.right = temp;
                            break;
                        } else {
                            ptr = ptr.right;
                        }

                    } else if (x < ptr.data) {
                        if (ptr.left == null) {
                            ptr.left = temp;
                            break;
                        } else {
                            ptr = ptr.left;
                        }
                    } else {
                        System.out.println("Repeated values are not allowed");
                        break;
                    }
                }
            }
        }
        public boolean Search (node root , int val )
        {
            if(root!=null) {
                if (root.data == val) {
                    System.out.println(" Value Found ");
                    return true;

                } else if (val > root.data) {

                    return Search(root.right, val);

                } else if (val < root.data) {

                    return Search(root.left, val);
                }
            }
            return false;
        }


        public node deleteNode(node root, int key) {
            if(root == null) {
                return root;
            }
            if(key > root.data){

                root.right = deleteNode(root.right, key);
            }
            else if(key < root.data){

                root.left = deleteNode(root.left, key);
            }
            else{
                if(root.left == null && root.right == null)
                {
                    root = null;
                }
                else if(root.right != null){
                    root.data = successor(root);
                    root.right = deleteNode(root.right, root.data);
                }else{
                    root.data = predecessor(root);
                    root.left = deleteNode(root.left, root.data);
                }
            }
            return root;
        }

        private int successor(node root){
            root = root.right;
            while(root.left != null){
                root = root.left;
            }
            return root.data;
        }

        private int predecessor(node root){
            root = root.left;
            while(root.right != null){
                root = root.right;
            }
            return root.data;
        }

        public void preorder( node n)
        {
            if( n== null)
                return ;
            System.out.print("\t"+n.data);
            preorder(n.left);
            preorder(n.right);


        }
        public void postorder( node n)
        {
            if( n== null)
                return ;

            postorder(n.left);
            postorder(n.right);
            System.out.print("\t"+n.data);

        }
        public void inorder( node n)
        {
            if( n== null)
                return ;
            inorder(n.left);
            System.out.print("\t"+n.data);
            inorder(n.right);

        }public void traverse ()
        {

            System.out.println("\n Preorder Traversal ");
            preorder(root);
            System.out.println("\n Postorder Traversal ");
            postorder(root);
            System.out.println("\n Inorder Traversal ");
            inorder(root);
        }
    public node getRoot(){
        return this.root;
    }
    void Display ()
    {
        System.out.println("Binary Search Tree");
        inorder(root);
    }

    public static void main(String[] args) {
        // write your code here
    BinarySearchTree BST= new BinarySearchTree();
       BST.insert(12);
        BST.insert(15);
        BST.insert(16);
        BST.insert(10);
        BST.insert(20);
        BST.insert(5);
        BST.insert(6);
        BST.Display();
        BST.traverse();
        int x ,y;
        System.out.println(" \n Enter value to search ");
        Scanner sc = new Scanner(System.in);
        x= sc.nextInt();
BST.Search(BST.getRoot(),x);
        System.out.println("Enter value to delete ");
        y= sc.nextInt();
BST.deleteNode(BST.getRoot(),y);
BST.traverse();
    }
}
