package Searching;

import java.util.*;

public class AggressiveCows {

    public static int aggressiveCow(int[] arr, int noc){
        int n = arr.length;
        Arrays.sort(arr);


        int lo = 0;
        int hi = arr[n-1] - arr[0];
        int ans = 0;
        
        while(lo<=hi){
            
            int mid = lo + (hi-lo)/2;
            
            if(isPossible(arr,noc,mid)){
                ans = mid;
                lo=mid+1;
            }else {
                hi = mid-1;
            }
        }
        
        return ans;
    }
    
    private static boolean  isPossible(int[] arr, int noc,int mid){
        int cowPlaced = 1;
        int pos = arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]-pos >= mid){
                cowPlaced++;
                pos = arr[i];
                
                if(cowPlaced == noc)
                    return true;
            }
        }

        return false;
    }
}
