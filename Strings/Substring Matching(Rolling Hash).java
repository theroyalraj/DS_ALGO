import java.io.*;
import java.util.*;
public class Main
{
	static class RollingHash
	{
	    long[] hash,pow;
	    long P, MOD;
	    int N;

	    RollingHash(char str[])
	    {
	        this.N=str.length;
	        this.P=31;
	        this.MOD=(int)1e9+9;
	        hash=new long[N+1];
	        pow=new long[N+1];
	        init(str);
	    }
	    
	    
	    void init(char str[])
	    {
	        pow[0]=1;
	        for(int i=N-1;i>=0;i--)
	        {
	            hash[i]=((hash[i+1]*P)%MOD+(str[i]-'a'+1))%MOD;
	            pow[N-i]=(pow[N-i-1]*P)%MOD;
	        }
	        pow[N]=(pow[N-1]*P)%MOD;
	    }
	    
	    
	   
	    long getHash(int l, int r)
	    {
	        return (MOD-(hash[r+1]*pow[r-l+1])%MOD+hash[l])%MOD;   
	    }
	}
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	    int i,N;

	    int T=Integer.parseInt(br.readLine().trim());
	    

	    while(T-->0)
	    {
	        char str[]=br.readLine().trim().toCharArray();
	        RollingHash rhash=new RollingHash(str); //compute rolling-hash

	        int count=0; N=str.length;
	        for(i=2;i<=N-2;i+=2)
	        {
	            int l1=0,r1=i/2-1; 
	            int l2=r1+1,r2=i-1; 
	            int l3=i,r3=(i+N)/2-1; 
	            int l4=r3+1,r4=N-1; 

	            boolean C1=rhash.getHash(l1,r1)==rhash.getHash(l2,r2);
	            boolean C2=rhash.getHash(l3,r3)==rhash.getHash(l4,r4);

	            if(C1&&C2) count++;
	        }
	        System.out.println(count);
	    }
	    
	}
}