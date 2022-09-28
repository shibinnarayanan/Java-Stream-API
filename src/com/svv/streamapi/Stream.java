package com.svv.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream {

//	filter
//	sorted
//	all match
//	any match
//	none match
//	max
//	min 
//	group
//map

	public static void main(String[] args) {

		ArrayList<People> peopleList = getPeople();

		List<People> femaleList = new ArrayList<People>();

		// Filter
		femaleList = peopleList.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());

		System.out.println("Filter female list");
		femaleList.forEach(System.out::println);

		// Sorted
		List<People> sortedList = peopleList.stream().sorted(Comparator.comparing(People::getAge))
				// Sorted reverse
				// List<People> sortedList =
				// peopleList.stream().sorted(Comparator.comparing(People::getAge).reversed())
				.collect(Collectors.toList());

		System.out.println("Sorted list ,age wise");
		sortedList.forEach(System.out::println);

		// all match
		boolean allMatch = peopleList.stream().allMatch(people -> people.getAge() > 40);
		System.out.println("all match result");
		System.out.println(allMatch);
		// any match
		boolean anyMatch = peopleList.stream().anyMatch(p -> p.getAge() > 40);
		System.out.println("any match result");
		System.out.println(anyMatch);
		// max
		peopleList.stream().max(Comparator.comparingInt(People::getAge)).ifPresent(System.out::println);
		// min
		peopleList.stream().min(Comparator.comparingInt(People::getAge)).ifPresent(System.out::println);
		// Group
		Map<Gender, List<People>> groupByGender = peopleList.stream().collect(Collectors.groupingBy(People::getGender));
		
		groupByGender.forEach((gender, people1) -> {
			System.out.println(gender);
			people1.forEach(System.out::println);
			System.out.println();
		});
		
	    Optional<String> oldestFemaleAge = peopleList.stream()
	            .filter(person -> person.getGender().equals(Gender.FEMALE))
	            .max(Comparator.comparing(People::getAge))
	            .map(People::getName);

	        oldestFemaleAge.ifPresent(System.out::println);
	        
	        //Map example
	        List<Integer> number = Arrays.asList(2,3,4,5);
	        List square = number.stream().map(x->x*x).collect(Collectors.toList());
	        
	        square.forEach(System.out::println);

	}

	private static ArrayList<People> getPeople() {
		ArrayList<People> peopleList = new ArrayList<>();

		peopleList.add(new People(34, Gender.MALE, "David"));
		peopleList.add(new People(25, Gender.FEMALE, "Nancy"));
		peopleList.add(new People(16, Gender.MALE, "Anu"));
		peopleList.add(new People(65, Gender.FEMALE, "Leena"));
		peopleList.add(new People(78, Gender.MALE, "Nivin"));
		peopleList.add(new People(55, Gender.FEMALE, "Minu"));

		return peopleList;
	}
}
