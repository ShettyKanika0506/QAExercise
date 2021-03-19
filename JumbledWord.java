package com.myprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class JumbledWord 
{
	//method to find jumbled words
	public static List<List<String>>groupJumbledWords (String[] strs) 
	{
		List<List<String>> result = new ArrayList<>();
		
		//Initialize the hashmap
		HashMap<String, List<String>> map = new HashMap<>();
		
		//Traverse the input list of string
		for(String s: strs){
		
		//Convert string to character array and lowercase for exact comparison
		char[] chArr = s.toLowerCase().toCharArray();
		
		//Sorting the character array
		Arrays.sort(chArr);
		
		//Create a string from the character array
		String key = new String(chArr);
		
		//Create a key from a sorted string
		//if this key is found add new string element
		if(map.containsKey(key))
		{
		map.get(key).add(s);
		} 
		else 
		{
		List<String> strList = new ArrayList<>();
		strList.add(s);
		map.put(key, strList);
		}
		}
		result.addAll(map.values());
		return result;
	}
//main method
	public static void main(String[] args) 
	{
		String[] myjumbledStr = {"eat", "ate", "tea", "Java", "avja", "apple"};
		List<List<String>> result  = groupJumbledWords(myjumbledStr);
		
		
		result.forEach(t -> System.out.println(t + " "));
		System.out.println("Total number of groups of jumbled words: "+result.size());
		 int indexCount=0;
		for(int r=0;r<result.size();r++)
		{
			indexCount++;
			System.out.println("Group "+indexCount+" has "+result.get(r).size()+" similar words");
		}

	}
}
