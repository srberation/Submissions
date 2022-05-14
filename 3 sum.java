class Solution {
    
    //2 pointer approach
   
    public List<List<Integer>> threeSum(int[] a) { 
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        if (n< 3) return res;
        for(int i = 0; i< n-2; i++){         
            if(i!=0 && a[i] == a[i-1]) continue;   // duplicacy check
            
            int target = 0-a[i];
            List<List<Integer>> subres =  twoSum(i+1,n-1,target,a);  
            
            for( List<Integer> list : subres) {   //adding first ele to list of 2 no. 
                list.add(a[i]);
                res.add(list);
            }
        }
        return res;
    }
    
    public static  List<List<Integer>>  twoSum(int start,int end,int target,int[] a ){    
        List<List<Integer>> res = new ArrayList<>();
        int l = start;
        int r = end;
        while(l < r){
            if(l != start && a[l] == a[l-1]){       // duplicacy check
                l++;
                continue;
            }
            int sum = a[l]+a[r];
            if(sum == target){
                List<Integer> subres = new  ArrayList<>();
                subres.add(a[l]);
                subres.add(a[r]);
                res.add(subres);
                l++;
                r--;
            }else if(sum < target){
                l++;
            }
            else {
                r--;
            }          
        }
        return res;
    }
}