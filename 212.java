
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String w:words){
            insert(root,w);
        }
        int m=board.length;
        int n=board[0].length;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        List<String> list=new ArrayList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                expand(board,i,j,list,root,dir);
            }
        }
        return list;
    }
    private void expand(char[][]board,int i,int j,List<String> list, TrieNode root,int[][] dir){
        if(i<0||j<0||i>=board.length|| j>=board[0].length ||board[i][j]=='#'
           || root.children[board[i][j]-'a']==null ){return;}
        root=root.children[board[i][j]-'a'];
        char c=board[i][j];
        if(root.word!=null){
            list.add(root.word);
            root.word=null;
        }
        board[i][j]='#';
        for(int[] d:dir){
            expand(board,i+d[0],j+d[1],list,root,dir);
        }
        board[i][j]=c; 
        
    }
    public void insert(TrieNode root, String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                curr.children[word.charAt(i)-'a']=new TrieNode();
            }
            curr=curr.children[word.charAt(i)-'a'];
        }
        curr.word=word;
    }
    class TrieNode{        
        TrieNode[] children= new TrieNode[26];
        String word;    
    }   
}