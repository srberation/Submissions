class vpair{
    TreeNode node;
    int step ;
    vpair(TreeNode node, int step){
        this.node = node;
        this.step = step;
    }
}

public class Solution {   
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;  // ans list
        LinkedList<vpair> q = new LinkedList<>();                    // list maintained for tracking nodes accd to level 
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();  // maping of list of elements in each step
        int maxStep = 0, minStep = 0;  // loop chalane ko steps

        if(A==null) return ans;
        
        q.add(new vpair(A,0)); 
         
        while(q.size() != 0){
            int s = q.size();
            while(s-- >0){
                vpair temp = q.poll(); // vpair nikallo Queue se 

                maxStep = Math.max(maxStep, temp.step);
                minStep = Math.min(minStep, temp.step);

                

                map.putIfAbsent(temp.step,new ArrayList<Integer>()); // map me new ArrayList declare krenge
                map.get(temp.step).add(temp.node.val);   // temp ke andr node ko uske horizontal level pe daal do 

                if(temp.node.left != null) q.add(new vpair(temp.node.left, temp.step-1)); 
                if(temp.node.right != null) q.add(new vpair(temp.node.right, temp.step+1));
            }
        }

        

        for(int i = minStep; i<= maxStep; i++)    ans.add(map.get(i));
        


        
        return ans;
    }
}