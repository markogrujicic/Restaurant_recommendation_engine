package logic;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

public class Controler {
	private static Controler controler;
	private static RestaurantsRecommendation recommendation;
	private HashMap<String, double[]> coordinates; 

	private Controler(){
		recommendation= new RestaurantsRecommendation();
		coordinates= new HashMap<String, double[]>();
		insertCoordinates();
	}

	private void insertCoordinates() {
		coordinates.put("Harmon park", new double[]{33.43412,-112.07964});
		coordinates.put("Nuestro park", new double[]{33.43387,-112.06033});
		coordinates.put("Central park", new double[]{33.43863,-112.07191});
		coordinates.put("East Lake park", new double[]{33.44666,-112.04875});
		coordinates.put("Verde park", new double[]{33.45184,-112.06136});
		coordinates.put("Library park", new double[]{33.44765,-112.08686});
		coordinates.put("Civic Space park", new double[]{33.45302,-112.07425});

	}

	public static Controler returnControler(){
		if(controler==null){
			controler= new Controler();
		}
		return controler;
	}

	public static List<JSONObject> returnBestMatchRestaurants(List<Object> matchingRestaurant){
		recommendation.readJSONDataset();
		List<JSONObject> list= recommendation.returnBestMatchRestaurants(matchingRestaurant);
		return list;
	}

	public HashMap<String, double[]> getCoordinates() {
		return coordinates;
	}
}