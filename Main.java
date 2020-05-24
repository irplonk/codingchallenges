public class Main {

	public static void main(String[] args) {
		TestRunner testRunner = new TestRunner();
		testRunner.main();
	}
	
	public static boolean betterHasPairWithSum(int[] nums, int sum) {
	    Set complements = new HashSet<Integer>();
	    for (int i = 0; i < nums.length; i++) {
	      if (complements.contains(nums[i])) {
	        return true;
	      }
	      complements.add(sum - nums[i]);
	    }
	    return false;
  	}

  	public static String reverseString(String str) {
	    if (str == null) {
	      return null;
	    }
	    String[] splitString = str.split("");
	    String newString = new String();
	    for (int i = 0; i < splitString.length; i++) {
	      newString = splitString[i] + newString;
	    }
	    return newString;
	  }

	  public static int[] mergeSortedArrays(int[] array1, int[] array2) {
	    if (array1 == null || array1.length == 0) {
	      return array2;
	    } else if (array2 == null || array2.length == 0) {
	      return array1;
	    }

	    int[] mergedArray = new int[array1.length + array2.length];
	    int index1 = 0;
	    int index2 = 0;

	    while (index1 < array1.length && index2 < array2.length) {
	      if (array1[index1] <= array2[index2]) {
	        mergedArray[index1 + index2] = array1[index1++];
	      } else {
	        mergedArray[index1 + index2] = array2[index2++];
	      }
	    }

	    while (index1 < array1.length) {
	      mergedArray[index1 + index2] = array1[index1++];
	    }
	    while (index2 < array2.length) {
	      mergedArray[index1 + index2] = array2[index2++];
	    }
	    
	    return mergedArray;
	  }
}