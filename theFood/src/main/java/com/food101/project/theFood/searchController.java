package com.food101.project.theFood;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import data.Food;
import data.foodRecipe;
import supply.Search;

@Controller
public class searchController {

	@RequestMapping("home")
    public String index(
        @RequestParam(value = "search", required = true) String searchInput,
        Model model
    ) throws InterruptedException, ExecutionException {
		
		
		Search search = new Search();
		List<foodRecipe> list = search.performSearch(searchInput);
	
		
		String[] name = new String[list.size()];
		
		for(int i=0;i<list.size();i++) {
			name[i] =  list.get(i).getDescription();
		}
		
		model.addAttribute("userIds", name);
		
		
		return "home";
    }
	
	
	/*
	private List<foodRecipe> performSearch(String s) throws InterruptedException, ExecutionException {
		
		//List<foodRecipe> l = new ArrayList<foodRecipe>();
		
List<foodRecipe> list = new ArrayList<foodRecipe>();


Firestore db1 = FirestoreClient.getFirestore();
ApiFuture<QuerySnapshot> future = db1.collection("foodRecipe").get();


	List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		
		for (DocumentSnapshot document : documents) {
			  list.add(document.toObject(foodRecipe.class));
			}
		

		String[] inputItems = s.toLowerCase().split(",");
	
		List<String> in = Arrays.asList(inputItems);
		/*
		if(list.size()==0) {
			list.add(new foodRecipe(9)); //("fuck you");
		}
	*	/
		
		for(int i=0;i< list.size();i++) {
			list.get(i).ComparebyIngredient(in);
		}
		
		Collections.sort(list);
		
		return list;
	}
	*/


   

}
