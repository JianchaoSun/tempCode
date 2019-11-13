package data;

import java.util.ArrayList;
import java.util.List;

public class foodRecipe implements Comparable<foodRecipe> {
	
	public List<Meat> meatIngredient;// = new ArrayList<Meat>();
	public List<condiment> conIngredient;//=new ArrayList<condiment>();
	
	private String Description;
	
	private String Name;
	
	public int priority = 0;
	
	
	public foodRecipe() {
		
	}
	
	public foodRecipe(List<Meat> food,List<condiment> co, String descp){
		
		meatIngredient = food;
		
		conIngredient = co;
		
		Description = descp;
	}
	
	public void ComparebyIngredient(List<String> in) {
		if(meatIngredient!=null) {
		for(int i=0;i<meatIngredient.size();i++) {
			if(in.contains(meatIngredient.get(i).getName().toLowerCase())) {
				priority++;
			}
		}
		}
		if(conIngredient!=null){
		for(int i=0;i<conIngredient.size();i++) {
			if(in.contains(conIngredient.get(i).getName().toLowerCase())) {
				priority++;
			}
		}
		}
		
	}
	
	
	
	
	public void ComparebyFood(List<Food> in) {
		if(meatIngredient!=null) {
		for(int i=0;i<meatIngredient.size();i++) {
			if(in.contains(meatIngredient.get(i))) {
				priority++;
			}
		}
		}
		if(conIngredient!=null){
		for(int i=0;i<conIngredient.size();i++) {
			if(in.contains(conIngredient.get(i))) {
				priority++;
			}
		}
		}
		
	}
	
	
	
	
	

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}



	public int compareTo(foodRecipe o) {
		return o.priority - priority;
		
	}

}
