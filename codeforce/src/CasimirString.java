import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class CasimirString {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int cases = Integer.parseInt(reader.readLine());
    	
    	while(cases-- > 0) {
    		
    		String[] firstLine = reader.readLine().split(" ");
    		int n = Integer.parseInt(firstLine[0]);
    		int[] arr1 = convertToIntArray(reader.readLine().split(" "));
    		int[] arr2 = convertToIntArray(reader.readLine().split(" "));
    		
    		Map<Integer, Integer> map = new HashMap<>();
    		int prefix[] = new int[2*n+1];
    		Arrays.fill(prefix, Integer.MAX_VALUE);
    		
    		for(int i=0;i<arr1.length;i++) {
    			map.put(arr1[i], i);
    			prefix[arr2[i]] = i;
    		}
    		
    		for(int i=prefix.length-2;i>=0;i--) {
    			prefix[i] = Math.min(prefix[i], prefix[i+1]);
    		}
    		
    		int ans = Integer.MAX_VALUE;
    		for(int i=1;i<2*n;i+=2) {
    			ans = Math.min(ans, map.get(i) + prefix[i+1]);
    		}
    		
    		printNumber(ans);
    		
    		//out.append(ans + "\n");
    		
    	}
    	
    	out.flush();
	
	}
	
	public static int[] convertToIntArray(String[] str) {
	    return Stream.of(str).mapToInt(Integer::parseInt).toArray();
	}
	
	public static void printYes() throws IOException {
		out.append("YES" + "\n");
	}
	
	public static void printNo() throws IOException {
		out.append("NO" + "\n");
	}
	
	public static void printNumber(int num) throws IOException {
		out.append(num + "\n");
	}

}
