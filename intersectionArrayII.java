  
class Solution {
    public int[] intersect(int[] a, int[] b) {       
        HashMap<Integer,Integer> map1 = new HashMap<>();
        
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        for(int i=0; i<a.length; i++){											// creating map1
            if(map1.containsKey(a[i]))  map1.put(a[i],map1.get(a[i])+1);
            
            else    map1.put(a[i],1);      
        }
        
        for(int i=0; i<b.length; i++){											// creating map2
            if(map2.containsKey(b[i]))  map2.put(b[i],map2.get(b[i])+1);
            
            else    map2.put(b[i],1);      
        }
        
        ArrayList<pair> arr = new ArrayList<>();					// arraylist to store pairs(data -> freq)
        
        for(int s: map1.keySet()){
            int freq =0;
            if(map2.containsKey(s)){								// matching freq. of data in map1 with map2 
                if(map1.get(s) == map2.get(s)) freq = map1.get(s);	// if both freq are same then freq = freq. of whatever
            }
            else{
                freq = Math.min(map1.get(s),map2.get(s));			// else minimum freq.
            }
            
		arr.add(new pair(s,freq)); // ..............................arr = [s1 -> f, s2->f, s3->f]

        }
        
            int size = 0;	// .......................................size of the ans array
            for(int i=0; i<arr.size(); i++){
                size = size+ arr.get(i).freq;
            }
        
        int[] ans = new int[size];
        
        int o = 0;
        for(int i=0; i<arr.size(); i++){
                int mn = arr.get(i).freq;	//.................pushing values in ans accd to their freq
                while(mn > 0){
                    ans[o] = arr.get(i).data;
                    o++;
                    mn--;
                }
        }

    
        return ans;
        
    }
    public class pair{
    int data;
    int freq;
    pair(int d,int f){
        this.data = d;
        this.freq = f; }
    }
}



******************************************************************************
// 2nd approach
******************************************************************************
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        
        for(int num:nums1)											//  creating map1
            map1.put(num,map1.getOrDefault(num,0)+1);
        for(int num:nums2)											// creataing map2
            map2.put(num,map2.getOrDefault(num,0)+1);
        List<Integer> list=new ArrayList<>(); 						// list  for adding intersected elements
        
        for(int num:map1.keySet())
        {
            int freq= map1.get(num);									// freq of element in map1 accd to the index
            if(map2.getOrDefault(num,0)==freq || (map2.getOrDefault(num,0)>freq)) // finidng limiting freq. of map1 and map2 and adding to list accd to that
            {
                for(int j=0;j<freq;j++)
                {
                    list.add(num);
                }
                
            }
             else if(map2.getOrDefault(num,0)>0 && map2.getOrDefault(num,0)<freq)
            {
                for(int j=0;j<map2.getOrDefault(num,0);j++)
                {
                    list.add(num);
                }
            }
                
        }
		
		
        int[] result =new int[list.size()];
        int i=0;
        for(int num:list)							// transerring element to ans;
		
        {
            result[i++]=num;
        }
            
        return result;
    }
}

