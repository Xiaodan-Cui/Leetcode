/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(isP(p,q)) return p;
        if(isP(q,p)) return q;
        Node pp=p.parent;
        if(p==pp.left){
            if(pp==q || isP(pp.right,q)) return pp;
        }
        else{
            if(pp==q || isP(pp.left,q)) return pp;
        }
       
            return lowestCommonAncestor(pp, q);
        
    }
    private boolean isP(Node p,Node q){
        if(p==null) return false;
        if(p==q) return true;
        return isP(p.left,q) || isP(p.right,q);
    }
}