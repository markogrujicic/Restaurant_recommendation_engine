package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import org.json.simple.JSONObject;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

import logic.Controler;

public class PhoenixRestaurantsControler {
	static FoundedRestaurants foundedRestaurants;

	public static void matchRestaurants(JComboBox cmb_Stars,
			JComboBox cmb_PriceRange, JComboBox cmb_Reservations,
			JComboBox cmb_Parking, JComboBox cmb_WiFi,
			JComboBox cmb_NoiseLevel, JComboBox cmb_Attire,
			JComboBox cmb_OutdoorSeating, JComboBox cmb_Category, JComboBox cmb_GoodFor, JComboBox cmb_Ambience, JComboBox cmb_Position) {
		List<Object> list= new ArrayList<Object>();
		int stars = assignStars(cmb_Stars.getSelectedItem().toString());
		int priceRange = assignPriceRange(cmb_PriceRange.getSelectedItem().toString());
		list.add(0, stars);
		list.add(1,priceRange);

		int noiseLevel = assignNoiseLevel(cmb_NoiseLevel.getSelectedItem().toString());
		list.add(2,noiseLevel);

		int parking = assignParking(cmb_Parking.getSelectedItem().toString());
		list.add(3, parking);

		int reservations = assignReservations(cmb_Reservations.getSelectedItem().toString());
		list.add(4, reservations);

		int wifi = assignWiFi(cmb_WiFi.getSelectedItem().toString());
		list.add(5, wifi);

		int outdoorSeating = assignOutSeating(cmb_OutdoorSeating.getSelectedItem().toString());
		list.add(6, outdoorSeating);

		double attire = assignAttire(cmb_Attire.getSelectedItem().toString());
		list.add(7, attire);

		String goodFor=cmb_GoodFor.getSelectedItem().toString();
		int[] arrayGoodFor = new int[6];
		assignGoodFor(arrayGoodFor, goodFor);
		list.add(8, arrayGoodFor);

		String ambience=cmb_Ambience.getSelectedItem().toString();
		int[] arrayAmbience = new int [9];
		assignAmbience(arrayAmbience,ambience);
		list.add(9,arrayAmbience);

		String category=cmb_Category.getSelectedItem().toString();
		list.add(10, category);

		List<JSONObject> listRespone=Controler.returnControler().returnBestMatchRestaurants(list);

		foundedRestaurants= new FoundedRestaurants();
		foundedRestaurants.setModal(true);
		try{
			showFoundedRestaurants(listRespone,cmb_Position,foundedRestaurants);
		}catch (Exception e) {
		}
		foundedRestaurants.setVisible(true);
	}

	private static int assignPriceRange(String priceRange) {
		int value=1;
		if(priceRange.equals("$")){
			value=1;
		} 
		if(priceRange.equals("$$")){
			value=2;
		} else{
			value=3;
		}
		return value;
	}

	private static int assignStars(String stars) {
		int value=1;
		if(stars.equals("*")){
			value=1;
		}
		if(stars.equals("**")){
			value=2;
		}	if(stars.equals("***")){
			value=3;
		}	if(stars.equals("****")){
			value=4;
		}	if(stars.equals("*****")){
			value=5;
		}
		return value;
	}

	private static void showFoundedRestaurants(List<JSONObject> listRespone,
			JComboBox cmb_Position,FoundedRestaurants foundedRestaurants) {

		JSONObject firstRestaurant=listRespone.get(0);
		arrangeFirstPanel(firstRestaurant,foundedRestaurants,cmb_Position);

		if(listRespone.size()>1){
			JSONObject secondRestaurant=listRespone.get(1);
			arrangeSecondPanel(secondRestaurant,foundedRestaurants,cmb_Position);
		}
		else{
			foundedRestaurants.getPanelSecond().setVisible(false);
		}

		if(listRespone.size()>2){
			JSONObject thirdRestaurant=listRespone.get(2);
			arrangeThirdPanel(thirdRestaurant,foundedRestaurants,cmb_Position);
		}
		else{
			foundedRestaurants.getPanelThird().setVisible(false);
		}

		if(listRespone.size()>3){
			JSONObject fourthRestaurant=listRespone.get(3);
			arrangeFourthPanel(fourthRestaurant,foundedRestaurants,cmb_Position);
		}
		else{
			foundedRestaurants.getPanelFourth().setVisible(false);
		}

		if(listRespone.size()>4){
			JSONObject fifthRestaurant=listRespone.get(4);
			arrangeFifthPanel(fifthRestaurant,foundedRestaurants,cmb_Position);
		}
		else{
			foundedRestaurants.getPanelFifth().setVisible(false);
		}

		addMap(listRespone,foundedRestaurants,cmb_Position);

	}

	private static void addMap(List<JSONObject> listResponse,
			FoundedRestaurants foundedRestaurants,JComboBox cmb_position) {
		try{
			final JMapViewer map = new JMapViewer();
			JLabel helpLabel =
					new JLabel("move= right mouse,\n "
							+ "zoom= mouse wheel");
			helpLabel.setForeground(Color.BLUE);
			foundedRestaurants.getHelpPanel().add(helpLabel);
			List<MapMarker> mapMarkerList= new ArrayList<MapMarker>();
			map.setDisplayToFitMapMarkers();
			for (int i = 0; i < listResponse.size(); i++) {
				Color color= new Color(230, 0, 255);
				MapMarkerDot marker= new MapMarkerDot(color,Double.parseDouble(listResponse.get(i).get("latitude").toString()),Double.parseDouble(listResponse.get(i).get("longitude").toString()));
				marker.setName(listResponse.get(i).get("name").toString());
				marker.setVisible(true);
				mapMarkerList.add(marker);
			}
			double latitude=Controler.returnControler().getCoordinates().get(cmb_position.getSelectedItem().toString())[0];
			double longitude=Controler.returnControler().getCoordinates().get(cmb_position.getSelectedItem().toString())[1];
			MapMarkerDot markerPosition=new MapMarkerDot(latitude,longitude);
			markerPosition.setName("You are here");
			markerPosition.setVisible(true);
			mapMarkerList.add(markerPosition);
			map.setMapMarkerList(mapMarkerList);
			map.setMapMarkerVisible(true);
			map.setTileSource(new OsmTileSource.Mapnik());
			map.setZoomContolsVisible(true);
			map.setDisplayPositionByLatLon(latitude,longitude, 11);
			foundedRestaurants.getPanelMap().add(map);
			foundedRestaurants.getPanelMap().setVisible(true);
		}catch (Exception e) {
		}
	}

	private static void arrangeFifthPanel(JSONObject fifthRestaurant, FoundedRestaurants foundedRestaurants, JComboBox cmb_Position) {
		String position=cmb_Position.getSelectedItem().toString();
		double result=calculate(position,fifthRestaurant);

		foundedRestaurants.getLbl_DistanceKilometer5().setText(result+" Km");
		foundedRestaurants.getLbl_RestaurantName5().setText(fifthRestaurant.get("name").toString());
		setAddress(fifthRestaurant);
		foundedRestaurants.getLbl_Street5().setText(setAddress(fifthRestaurant));

		double stars=Double.parseDouble(fifthRestaurant.get("stars").toString());
		ImageIcon image=assignImage(stars);
		foundedRestaurants.getLbl_StarsRating5().setText("");
		foundedRestaurants.getLbl_StarsRating5().setIcon(image);

	}

	private static void arrangeFourthPanel(JSONObject fourthRestaurant, FoundedRestaurants foundedRestaurants, JComboBox cmb_Position) {
		String position=cmb_Position.getSelectedItem().toString();
		double result=calculate(position,fourthRestaurant);

		foundedRestaurants.getLbl_DistanceKilometer4().setText(result+" Km");
		foundedRestaurants.getLbl_RestaurantName4().setText(fourthRestaurant.get("name").toString());
		foundedRestaurants.getLbl_Street4().setText(setAddress(fourthRestaurant));

		double stars=Double.parseDouble(fourthRestaurant.get("stars").toString());
		ImageIcon image=assignImage(stars);
		foundedRestaurants.getLbl_StarsRating4().setIcon(image);
		foundedRestaurants.getLbl_StarsRating4().setText("");
		foundedRestaurants.getLbl_StarsRating4().repaint();

	}

	private static void arrangeThirdPanel(JSONObject thirdRestaurant, FoundedRestaurants foundedRestaurants, JComboBox cmb_Position) {
		String position=cmb_Position.getSelectedItem().toString();
		double result=calculate(position,thirdRestaurant);

		foundedRestaurants.getLbl_DistanceKilometer3().setText(result+" Km");
		foundedRestaurants.getLbl_RestaurantName3().setText(thirdRestaurant.get("name").toString());
		foundedRestaurants.getLbl_Street3().setText(setAddress(thirdRestaurant));

		double stars=Double.parseDouble(thirdRestaurant.get("stars").toString());
		ImageIcon image=assignImage(stars);
		foundedRestaurants.getLbl_StarsRating3().setText("");
		foundedRestaurants.getLbl_StarsRating3().setIcon(image);

	}

	private static void arrangeSecondPanel(JSONObject secondRestaurant, FoundedRestaurants foundedRestaurants, JComboBox cmb_Position) {
		String position=cmb_Position.getSelectedItem().toString();
		double result=calculate(position,secondRestaurant);

		foundedRestaurants.getLbl_DistanceKilometer2().setText(result+" Km");
		foundedRestaurants.getLbl_RestaurantName2().setText(secondRestaurant.get("name").toString());
		foundedRestaurants.getLbl_Street2().setText(setAddress(secondRestaurant));

		double stars=Double.parseDouble(secondRestaurant.get("stars").toString());
		ImageIcon image=assignImage(stars);
		foundedRestaurants.getLbl_StarsRating2().setText("");
		foundedRestaurants.getLbl_StarsRating2().setIcon(image);

	}

	private static void arrangeFirstPanel(JSONObject firstRestaurant, FoundedRestaurants foundedRestaurants,JComboBox cmb_Position) {
		String position=cmb_Position.getSelectedItem().toString();
		double result=calculate(position,firstRestaurant);

		foundedRestaurants.getLblDistancemeter().setText(result+" Km");
		foundedRestaurants.getLbl_RestaurantName1().setText(firstRestaurant.get("name").toString());
		foundedRestaurants.getLbl_Street1().setText(setAddress(firstRestaurant));

		double stars=Double.parseDouble(firstRestaurant.get("stars").toString());
		ImageIcon image=assignImage(stars);
		foundedRestaurants.getLbl_StarsRating1().setText("");
		foundedRestaurants.getLbl_StarsRating1().setIcon(image);
	}	

	private static ImageIcon assignImage(double stars) {
		ImageIcon image=new ImageIcon();
		if(stars==3){
			image=new ImageIcon("images/3 star.png");
		} if(stars==3.5){
			image=new ImageIcon("images/3,5 star.png");
		}
		if(stars==4){
			image=new ImageIcon("images/4 star.png");
		}
		if(stars==4.5){
			image=new ImageIcon("images/4,5 star.png");
		}
		if(stars==5){
			image=new ImageIcon("images/5 star.png");
		}
		return image;
	}

	private static String setAddress(JSONObject restaurant) {
		String address=restaurant.get("full_address").toString();
		String newAddress=address.substring(0, address.indexOf(","));
		return newAddress;

	}

	private static double calculate(String position, JSONObject restaurant) {
		double latitudeM=Controler.returnControler().getCoordinates().get(position)[0];
		double longitudeM=Controler.returnControler().getCoordinates().get(position)[1];
		double latitudeF=Double.parseDouble(restaurant.get("latitude").toString());
		double longitudeF=Double.parseDouble(restaurant.get("longitude").toString());
		double distance=distanceCalculate(latitudeM, longitudeM, latitudeF, longitudeF);
		distance = distance*100;
		distance = (double)((int) distance);
		distance = distance /100;
		return distance;
	}

	private static void assignAmbience(int[] arrayAmbience, String ambience) {
		if(ambience.equalsIgnoreCase("hipster")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==0){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("classy")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==1){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("touristy")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==2){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("divey")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==3){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("intimate")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==4){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("casual")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==5){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("romantic")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==6){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("trendy")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==7){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}
		if(ambience.equalsIgnoreCase("upscale")){
			for (int i = 0; i < arrayAmbience.length; i++) {
				if(i==8){
					arrayAmbience[i]=1;
				} else{
					arrayAmbience[i]=0;
				}
			}
		}


	}

	private static void assignGoodFor(int[] array, String goodFor) {
		if(goodFor.equalsIgnoreCase("breakfast")){
			for (int i = 0; i < array.length; i++) {
				if(i==2){
					array[i]=1;
				} else{
					array[i]=0;
				}
			}
		}
		if(goodFor.equalsIgnoreCase("brunch")){
			for (int i = 0; i < array.length; i++) {
				if(i==4){
					array[i]=1;
				} else{
					array[i]=0;
				}
			}
		}
		if(goodFor.equalsIgnoreCase("lunch")){
			for (int i = 0; i < array.length; i++) {
				if(i==3){
					array[i]=1;
				} else{
					array[i]=0;
				}
			}
		}
		if(goodFor.equalsIgnoreCase("dessert")){
			for (int i = 0; i < array.length; i++) {
				if(i==5){
					array[i]=1;
				} else{
					array[i]=0;
				}
			}
		}
		if(goodFor.equalsIgnoreCase("dinner")){
			for (int i = 0; i < array.length; i++) {
				if(i==0){
					array[i]=1;
				} else{
					array[i]=0;
				}
			}
		}
		if(goodFor.equalsIgnoreCase("latenight")){
			for (int i = 0; i < array.length; i++) {
				if(i==1){
					array[i]=1;
				} else{
					array[i]=0;
				}
			}
		}

	}

	private static double assignAttire(String attire) {
		if(attire.equals("Casual")){
			return 0.5;
		}
		return 1.5;
	}

	private static int assignOutSeating(String outSeating) {
		if(outSeating.equals("Yes")){
			return 1;
		}
		return 0;
	}

	private static int assignWiFi(String wifi) {
		if(wifi.equals("Free")){
			return 1;
		}
		return 0;
	}

	private static int assignReservations(String reservations) {
		if(reservations.equals("Needed")){
			return 1;
		}
		return 0;
	}

	private static int assignParking(String parking) {
		if(parking.equals("Available")){
			return 1;
		}
		return 0;
	}

	private static int assignNoiseLevel(String noise){
		int noiselevel=1;
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
	private static double distanceCalculate(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;		
		dist = dist * 1.609344;
		return (dist);
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
