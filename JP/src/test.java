import java.util.*;
public class test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		String[] input = new String[] {""};
//		System.out.println(isChain(input));
		char[] input = in.nextLine().toCharArray();
		per(input, 0);
		in.close();
	}
	public static void per(char[] array, int index) {
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			System.out.println(new String(array,0, index + 1));
			per(array, index + 1);
			swap(array, i, index);
		}
		
	}
	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
//	public static void per(String str) {
//		if (str == null || str.length() == 0) {
//			return;
//		}
//		StringBuilder sb = new StringBuilder();
//		dfs1(str, 0, sb);
//	}
//	private static void dfs1(String str, int level, StringBuilder sb) {
//		if (level == str.length() - 1) {
//			sb.append(str.charAt(level));
//			System.out.println(sb.toString());
//			sb.deleteCharAt(sb.length() - 1);
//			return;
//		}
//		sb.append(str.charAt(level));
//		sb.append(" ");
//		dfs1(str, level + 1, sb);
//		sb.deleteCharAt(sb.length() - 1);
//		dfs1(str, level + 1, sb);
//		sb.deleteCharAt(sb.length() - 1);
//	}
//	public static int split(int num) {
//		if (num == 0 || num == 1) {
//			return 1;
//		}
//		int[] M = new int[num + 1];
//		for (int i = 1; i <= num; i++) {
//			M[i] = i;
//			for (int j = 1; j * j <= i; j++) {
//				M[i] = Math.min(M[i], M[i - j * j] + 1);
//			}
// 		}
//		return M[num];
//	}
//	public static boolean isChain(String[] array) {
//		if (array == null || array.length == 0) {
//			return false;
//		}
//		return dfs(array, 0);
//	}
//	private static boolean dfs(String[] input, int index) {
//		if (index == input.length) {
//			String first = input[0];
//			String last = input[input.length - 1];
//			return first.charAt(0) == last.charAt(last.length() - 1);
//		}
//		for (int i = index; i < input.length; i++) {
//			if (index == 0 || isValid(input, index, i)) {
//				swap(input, index, i);
//				if (dfs(input, index + 1)) {
//					return true;
//				}
//				swap(input, index, i);
//			}
//		}
//		return false;
//	}
//	private static boolean isValid(String[] input, int index, int i) {
//		String one = input[index - 1];
//		String two = input[i];
//		return one.charAt(one.length() - 1) == two.charAt(0);
//	}
//	private static void swap(String[] input, int a, int b) {
//		String temp = input[a];
//		input[a] = input[b];
//		input[b] = temp;
//	}
	
}
