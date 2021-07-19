import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public List<Integer> grayCode(int n) {
		List<Integer> results = new ArrayList<>();
		int num = 1 << n;
		
		Queue<Integer> q
            = new LinkedList<>();
			
		for(int i = 1; i < num; i++)
			q.add(i);
		
		results.add(0);
		
		while (!q.isEmpty()) {
			int currentNum = results.get(results.size() - 1);
			int item = q.poll();
			System.out.println(item);
			if (Solution.check(Solution.toBinaryString(currentNum, n), Solution.toBinaryString(item, n))) {
				results.add(item);
			} else {
				q.add(item);
			}
		}
		
        return results;
    }
	
	public static String toBinaryString(int input, int num2) {
		String result = Integer.toBinaryString(input);
		return String.format("%" + num2 + "s", result).replaceAll(" ", "0");
	}
	
	public static boolean check(String num1, String num2) {
		if (num1.length() != num2.length())
			return false;
		
		int differ = 0;
		for(int i = 0; i < num1.length(); i++)
			if (num1.charAt(i) != num2.charAt(i))
				differ++;
		if (differ != 1)
			return false;
		
		return true;
	}
}