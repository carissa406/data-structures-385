package Hashing;

import java.util.*;

public class HashingAssignment {

    public static void main(String args[]) {
        List<List<Integer>> intLists = new LinkedList<>();

        intLists.add(new ArrayList<Integer>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(15, 24, 50, 12, 3, 9)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(78, 65, 24, 13, 9, 3, 12)));
        intLists.add(new ArrayList<Integer>(Arrays.asList(15, 78, 14, 3, 2, 9, 44, 12)));

        List<Integer> intResult = findCommonElements(intLists);

        System.out.println("Common elements of the integer list");
        System.out.println(intResult + "\n");

        List<List<String>> stringLists = new LinkedList<>();

        stringLists.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists.add(new ArrayList<String>(Arrays.asList("g", "b", "e", "j", "u", "z", "h", "d")));
        stringLists.add(new ArrayList<String>(Arrays.asList("y", "p", "b", "d")));

        List<String> stringResult = findCommonElements(stringLists);

        System.out.println("Common elements of the string list");
        System.out.println(stringResult + "\n");
        
        List<List<Integer>> intLists2 = new LinkedList<>();

        intLists2.add(new ArrayList<Integer>(Arrays.asList(3, 4, 8, 12, 15, 7, 13)));
        intLists2.add(new ArrayList<Integer>(Arrays.asList(15, 24, 50, 12, 3, 9)));
        intLists2.add(new ArrayList<Integer>(Arrays.asList(78, 65, 24, 13, 9, 12)));
        intLists2.add(new ArrayList<Integer>(Arrays.asList(15, 78, 14, 3, 2, 9, 44)));

        List<Integer> intResult2 = findCommonElements(intLists2);

        System.out.println("Common elements of the integer list 2");
        System.out.println(intResult2 + "\n");
        
        List<List<String>> stringLists2 = new LinkedList<>();

        stringLists2.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists2.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists2.add(new ArrayList<String>(Arrays.asList("a", "b", "d", "c", "h", "e")));

        List<String> stringResult2 = findCommonElements(stringLists2);

        System.out.println("Common elements of the string list");
        System.out.println(stringResult2);
        
    }

    public static <T> List<T> findCommonElements(List<List<T>> collections) {
    	if(collections.size() == 0) {
    		return new LinkedList<T>();
    	}
    	
    	if(collections.size() == 1) {
    		return collections.get(0);
    	}
    	
    	HashSet<T> commonSet = new HashSet<T>(collections.get(0));
    	
    	for (int i = 1; i < collections.size(); i++) {
    		HashSet<T> currentSet = new HashSet<T>(collections.get(i));
    		Iterator<T> iterator = commonSet.iterator();
    		while(iterator.hasNext()) {
    			if(!currentSet.contains(iterator.next())) {
    				iterator.remove();
    			}
    		}
		}
    	
        return new LinkedList<T>(commonSet);
    }
}
