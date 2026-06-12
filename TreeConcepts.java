// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.* ;
class Node{
    int val ; 
    Node left ; 
    Node right  ; 
    
    public Node(int val){
        this.val = val ;
    }
    
    
    public void Inorder(Node root){
        if(root == null){
            return  ;
        }
        Inorder(root.left) ; 
        System.out.print(root.val + " ") ;
        Inorder(root.right) ;
    }
    
    public void PreOrder(Node root){
        if(root == null){
            return  ;
        }
        System.out.print(root.val + " ") ; 
        PreOrder(root.left) ; 
        PreOrder(root.right) ;
    }
    public void PostOrder(Node root){
        if(root == null){
            return  ;
        }
        
        PostOrder(root.left) ;
        PostOrder(root.right) ; 
        System.out.print(root.val + " ") ; 
    }
    
    public void Level(Node root){
        if(root == null){
            return  ;
        }
        Queue<Node> queue = new LinkedList<>() ; 
        queue.offer(root) ; 
        while(!queue.isEmpty()){
            Node curr = queue.poll() ; 
            System.out.print(curr.val + " ") ;
            
            if(curr.left != null){
                queue.offer(curr.left) ; 
            }
            if(curr.right != null){
                queue.offer(curr.right) ; 
            }
        }
    }
}
class Main {
    public static void main(String[] args) {
        Node root = new Node(10) ; 
        
        root.left = new Node(20) ; 
        root.right=  new Node(30) ;
        root.left.left = new Node(40) ; 
        root.left.right=  new Node(50) ;
        root.right.left = new Node(60) ; 
        root.right.right=  new Node(70) ;
        
        root.Inorder(root) ;
        System.out.println() ;
        root.PreOrder(root) ;
         System.out.println() ;
        root.PostOrder(root) ;
        System.out.println() ;
        root.Level(root)  ;
       
        
    }
}
