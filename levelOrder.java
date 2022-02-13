/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class vpair{
    TreeNode root;
    int lvl;
    vpair(TreeNode root, int lvl){
        this.root = root;
        this.lvl = lvl;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<vpair> q = new LinkedList<>();
        vpair temp = null;
        if(root == null) return ans;
        q.offer(new vpair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                temp = q.poll();  
                map.putIfAbsent(temp.lvl, new ArrayList<Integer>());
                map.get(temp.lvl).add(temp.root.val);
                if(temp.root.left != null) q.add(new vpair(temp.root.left, temp.lvl+1)); 
                if(temp.root.right != null) q.add(new vpair(temp.root.right, temp.lvl+1));

                } 
            ans.add(map.get(temp.lvl));
        }
        return ans;  
    }  

}
***************************************************APPROACH 2: w/o map ***************************************************
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = null;
        if(root == null) return ans;
        q.offer(root);
        int lvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                temp = q.poll(); 
					if(ans.size()<= lvl) ans.add(new ArrayList<Integer>());
					ans.get(lvl).add(temp.val);
                //map.putIfAbsent(temp.lvl, new ArrayList<Integer>());
               // map.get(temp.lvl).add(temp.root.val);
                if(temp.left != null) q.add( temp.left); 
                if(temp.right != null) q.add(temp.right);

                } 
            lvl++;
           // ans.add(map.get(temp.lvl));
        }
        return ans;  
    }  

}
***************************************************************************************************************
APPROACH 3:  Recurssion
****************************************************************************************************************
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
    solve(root, 0);  
    return ans;
 
    }  
        
    public void solve(TreeNode root, int lvl){
        
    if (root == null) return ;
    if (ans.size() <= lvl) ans.add(new ArrayList<Integer>());  // ans = [[], [    ], [       ]] -> ans.size == level of tree
    ans.get(lvl).add(root.val);
    solve(root.left, lvl + 1);
    solve(root.right, lvl + 1);
        
    }

}