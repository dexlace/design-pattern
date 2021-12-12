package com.dexlace;

public class Solution {
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        int n=A.length;
        int [][]f=new int[n+1][m+1];

        for(int i=1;i<m+1;i++){
            f[0][i]=-1;
        }
        // 其实默认了f[i][0]=0;

        int res=0;
        for(int i=1;i<n+1;i++){
            for(int w=1;w<m+1;w++){
                f[i][w]=f[i-1][w];
                if(w>=A[i-1] && f[i][w-A[i-1]]!=-1){
                    // f[i][w]=max{f[i-1][w],f[i][w-A[i-1]]+V[i-1]}
                    f[i][w]=Math.max(f[i][w],f[i][w-A[i-1]]+V[i-1]);
                }

                if(f[i][w]!=-1){
                    res=Math.max(f[i][w],res);
                }
            }
        }
        return res;

    }
}



