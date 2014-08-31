package logic;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.stat.correlation.PearsonsCorrelation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dll.DoubleLinkedList;
import dll.MemberDoubleLinkedList;

public class RestaurantsRecommendation {
	private JSONArray jsonDataset;
	private DoubleLinkedList doubleLinkedListRestorants;

	public RestaurantsRecommendation(){
		jsonDataset= new JSONArray();
		doubleLinkedListRestorants= new DoubleLinkedList();
	}

	public void readJSONDataset(){
		JSONParser jsonParser = new JSONParser();
		try {		
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(new FileInputStream("DatasetFinal.json")));
			jsonDataset=(JSONArray) jsonObject.get("businesses");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<JSONObject> returnBestMatchRestaurants(List<Object> matchingRestaurant){
		double indikator=0;
		if(doubleLinkedListRestorants.getFirstMember()!=null){
			doubleLinkedListRestorants= new DoubleLinkedList();
		}
		List<JSONObject> list= new ArrayList<JSONObject>();
		JSONObject bestRestaurant= new JSONObject();
		double matchArray[]= new double[25];
		double foundArray[]= new double[25];

		String category=matchingRestaurant.get(10).toString();
		JSONArray jsonDataCategory=foundRestaurants(category);

		for (int i = 0; i < jsonDataCategory.size(); i++) {
			JSONObject object = (JSONObject) jsonDataCategory.get(i);

			double starsM= Double.parseDouble(matchingRestaurant.get(0).toString());
			matchArray[0]= starsM;
			double starsF= Double.parseDouble(object.get("stars").toString());
			foundArray[0]= starsF;

			double priceRangeM= Double.parseDouble(matchingRestaurant.get(1).toString());
			matchArray[1]= priceRangeM;
			JSONObject helpObject=(JSONObject) object.get("attributes");
			double priceRangeF= Double.parseDouble(helpObject.get("Price Range").toString());
			foundArray[1]= priceRangeF;

			double noiseLevelM= Double.parseDouble(matchingRestaurant.get(2).toString());
			matchArray[2]= noiseLevelM;
			JSONObject helpObject1=(JSONObject) object.get("attributes");
			double noiseLevelF= assignNoiseLevel(helpObject1);
			foundArray[2]= noiseLevelF;

			double parkingM= Double.parseDouble(matchingRestaurant.get(3).toString());
			matchArray[3]= parkingM;
			double parkingF=0;
			if(parkingM==1.0){
				JSONObject helpObject2=(JSONObject) object.get("attributes");
				parkingF=assignParking(helpObject2);
			}
			foundArray[3]= parkingF;

			double reservationsM= Double.parseDouble(matchingRestaurant.get(4).toString());
			matchArray[4]= reservationsM;
			JSONObject helpObject3=(JSONObject) object.get("attributes");
			double reservationsF=assignReservations(helpObject3);
			foundArray[4]= reservationsF;

			double wifiM= Double.parseDouble(matchingRestaurant.get(5).toString());
			matchArray[5]= wifiM;
			double wifiF=0;
			if(wifiM==1.0){
				JSONObject helpObject4=(JSONObject) object.get("attributes");
				wifiF=assignWiFI(helpObject4);
			}
			foundArray[5]= wifiF;

			double outdoorSeatingM= Double.parseDouble(matchingRestaurant.get(6).toString());
			matchArray[6]= outdoorSeatingM;
			double outdoorSeatingF=0;
			if(outdoorSeatingM==1.0){
				JSONObject helpObject5=(JSONObject) object.get("attributes");
				outdoorSeatingF=assignOudoorSeating(helpObject5);
			}
			foundArray[6]= outdoorSeatingF;

			double attireM= Double.parseDouble(matchingRestaurant.get(7).toString());
			matchArray[7]= attireM;
			JSONObject helpObject6=(JSONObject) object.get("attributes");
			double attireF= assignAttire(helpObject6);
			foundArray[7]= attireF;


			int[] goodForM=(int[]) matchingRestaurant.get(8);
			for (int j = 0; j < goodForM.length; j++) {
				matchArray[8+j]=goodForM[j];
			}
			JSONObject helpObject8=(JSONObject) object.get("attributes");
			int[] goodForF=assignGoodFor(helpObject8);
			for (int k = 0; k < goodForF.length; k++) {
				foundArray[8+k]=goodForF[k];
			}

			int[] ambienceM=(int[]) matchingRestaurant.get(9);
			for (int j = 0; j < ambienceM.length; j++) {
				matchArray[14+j]=ambienceM[j];
			}
			JSONObject helpObject9=(JSONObject) object.get("attributes");
			int[] ambienceF=assignAmbience(helpObject9);
			for (int k = 0; k < ambienceF.length; k++) {
				foundArray[14+k]=ambienceF[k];
			}

			System.out.println(object.get("name"));
			System.out.println(matchArray[0]+","+matchArray[1]+","+matchArray[2]+","+matchArray[3]+","+matchArray[4]+","+matchArray[5]+","+matchArray[6]+","+matchArray[7]+","+matchArray[8]+"->"+foundArray[0]+","+foundArray[1]+","+foundArray[2]+","+foundArray[3]+","+foundArray[4]+","+foundArray[5]+","+foundArray[6]+","+foundArray[7]+","+foundArray[8]);

			PearsonsCorrelation p= new PearsonsCorrelation();
			double coefficient=p.correlation(matchArray, foundArray);
			doubleLinkedListRestorants.insertMember(object, coefficient);

			System.out.println(coefficient);

			if(coefficient>indikator){
				bestRestaurant=object;
				indikator=coefficient;			
			}				
		}

		System.out.println(bestRestaurant.get("name").toString());
		System.out.println(indikator);

		List<MemberDoubleLinkedList> listMember= doubleLinkedListRestorants.getBestFive();
		for (MemberDoubleLinkedList memberDoubleLinkedCyclicList : listMember) {
			list.add((JSONObject)memberDoubleLinkedCyclicList.getObject());
		}
		return list;
	}


	private JSONArray foundRestaurants(String category) {
		JSONArray returnArray=new JSONArray();
		for (int i = 0; i < jsonDataset.size(); i++) {
			JSONObject object=(JSONObject) jsonDataset.get(i);
			JSONArray categories= (JSONArray) object.get("categories");
			if(categories.contains(category)){
				returnArray.add(object);
			}
		}
		return returnArray;
	}

	private int[] assignAmbience(JSONObject helpObjectAmbience) {
		int[] returnArray= new int[9];
		JSONObject ambience=(JSONObject) helpObjectAmbience.get("Ambience");

		if(ambience.get("hipster").toString().equals("true")){
			returnArray[0]=1;
		}
		if(ambience.get("classy").toString().equals("true")){
			returnArray[1]=1;
		}
		if(ambience.get("touristy").toString().equals("true")){
			returnArray[2]=1;
		}
		if(ambience.get("divey").toString().equals("true")){
			returnArray[3]=1;
		}
		if(ambience.get("intimate").toString().equals("true")){
			returnArray[4]=1;
		}
		if(ambience.get("casual").toString().equals("true")){
			returnArray[5]=1;
		}
		if(ambience.get("romantic").toString().equals("true")){
			returnArray[6]=1;
		}
		if(ambience.get("trendy").toString().equals("true")){
			returnArray[7]=1;
		}
		if(ambience.get("upscale").toString().equals("true")){
			returnArray[8]=1;
		}
		return returnArray;

	}

	private int[] assignGoodFor(JSONObject helpObjectGoodFor) {
		int[] returnArray= new int[6];
		JSONObject goodFor=(JSONObject) helpObjectGoodFor.get("Good For");

		if(goodFor.get("breakfast").toString().equals("true")){
			returnArray[2]=1;
		}
		if(goodFor.get("brunch").toString().equals("true")){
			returnArray[4]=1;
		}
		if(goodFor.get("lunch").toString().equals("true")){
			returnArray[3]=1;
		}
		if(goodFor.get("dessert").toString().equals("true")){
			returnArray[5]=1;
		}
		if(goodFor.get("dinner").toString().equals("true")){
			returnArray[0]=1;
		}
		if(goodFor.get("latenight").toString().equals("true")){
			returnArray[1]=1;
		}
		return returnArray;
	}

	private double assignAttire(JSONObject helpObjectAttire) {
		String attire=helpObjectAttire.get("Attire").toString();
		if(attire.equals("casual")){
			return 0.5;
		}
		return 1.5;
	}

	private double assignOudoorSeating(JSONObject helpObjectOutSeating) {
		String outdoorSeating=helpObjectOutSeating.get("Outdoor Seating").toString();
		if(outdoorSeating.equals("true")){
			return 1;
		}
		return 0;
	}

	private double assignWiFI(JSONObject helpObjectWiFi) {
		String wifiJSON= helpObjectWiFi.get("Wi-Fi").toString();
		if(wifiJSON.equals("free")){
			return 1;
		}
		return 0;
	}

	private double assignReservations(JSONObject helpObjectReservations) {
		String reservations=helpObjectReservations.get("Takes Reservations").toString();
		if(reservations.equals("true")){
			return 1;
		}
		return 0;
	}

	private double assignParking(JSONObject helpObjectParking) {
		JSONObject parkingJSON=(JSONObject) helpObjectParking.get("Parking");
		String garage=parkingJSON.get("garage").toString();
		String street=parkingJSON.get("street").toString();
		String lot=parkingJSON.get("lot").toString();
		String valet=parkingJSON.get("valet").toString();
		String validated=parkingJSON.get("validated").toString();
		if(garage.equals("true")||street.equals("true")||lot.equals("true")||valet.equals("true")||validated.equals("true")){
			return 1.0;
		}
		return 0.0;
	}

	private double assignNoiseLevel(JSONObject helpObjectNoise) {
		String noise= helpObjectNoise.get("Noise Level").toString();
		double noiselevel=1;
		if(noise.equals("quiet")){
			noiselevel=1;
		}
		if(noise.equals("average")){
			noiselevel=2;
		}
		if(noise.equals("loud")){
			noiselevel=3;
		}
		return noiselevel;
	}

}
