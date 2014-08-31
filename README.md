
# 1. About the project
 
The objective of this project was to develop a recommendation engine for restaurants using information from a publicly available dataset about restaurants located in the Phoenix City area. The developed recommendation engine was integrated in an application that  recommends restaurants based on a set of preferences expressed by the user. 
The dataset (in JSON format) was downloaded from the [Yelp](https://www.yelp.com/dataset_challenge) website, and then filtered out and adapted for this project. The filtered dataset contains JSON objects with data about restaurants in the Phoenix City area. Every object contains information about restaurant attributes. 
The recommendation engine uses the Pearson correlation coefficient to calculate similarity between user-specified values of restaurant attributes and restaurants in the dataset. The application recommends 5 restaurants with the highest value for the correlation coefficient. It also displays a map with map markers of the top 5 restaurants. 

Project workflow consisted of the following phases:
-Obtaining a dataset
-Preparing a dataset for the recommendation engine 
-Creating the recommendation engine
+Creating an application

# 2. Dataset

+Attributes for each restaurant taken from the dataset, modified and used in the project are:

+1. Stars – The number of stars represents the evaluation of a restaurant’s quality as perceived by its customers/visitors. The more the stars, the better the quality of the restaurant. Evaluation is done by the “Forbes Travel Guide”.
+- This is an ordinal type of attribute with possible values: 1,2,3,4,5. 

+2.  Good for - Represents the meal(s) that a restaurant offers.
 +- This is a nominal type of attribute with possible values:
+•	dessert
+•	breakfast 
+•	brunch
+•	lunch
+•	dinner 
+•	latenight

It is represented as a vector of boolean values (0 – false, 1 - true). For an example, see below the assignment of values to the Ambience attribute.

+3. Price range – Price range for a meal in a restaurant.
+- This is an ordinal type of attribute with possible values:
+•	1 – less than 8$ per person
+•	2 – between 8$ and 15$ per person
+•	3 – more than 15$ per person

 +4. Category – Category of a restaurant.
+- This is a nominal type of restaurant. Some of the possible values: 
+•	Chinese
+•	American
+•	Mexican
+•	…
+5. Parking – Is there a parking in the vicinity of a restaurant.
+- This is a nominal (binary) type of attribute with possible values:
+•	1 – there is a parking
+•	0 – no parking

+Value 1 is assigned if in the original dataset the restaurant has at least one of the following kinds of parking places: garage, street, lot, valet, validated. Otherwise the assigned value is 0.

+6. Reservations – Is the reservation needed.
+•	1 – reservation is needed
+•	0 – no reservation is needed
+Value 1 is assigned  if the value of the attribute “Takes reservations” in the original dataset is true. Otherwise assigned value is 0.

+7. Ambience – Ambience in restaurant
+- This is a nominal type of attribute with possible values:
+•	romantic
+•	intimate
+•	touristy
+•	hipster
+•	divey
+•	classy
+•	trendy
+•	upscale
+•	casual

+Example of assigning a vector of values to this attribute:

+romantic	intimate	touristy	hipster	divey	classy	trendy	upscale	casual
+ false 	false	    false	    true	  false	false	  false	  false	  false
+   0	      0	        0	        1      	0    	0     	0     	0     	0

+The final value assigned to this attribute is: 0,0,0,1,0,0,0,0,0

+8. Noise level – Level of noise in a restaurant. 
+- This is an ordinal type of attribute with possible values:
+•	1
+•	2
+•	3
+Value 1 is assigned if the value of attribute “Noise level” in the original dataset is quiet, value 2 for average, and value 3 for loud.

+9. Wi-Fi – Is there free wi-fi in the restaurant
+- This is a nominal (binary) type of attribute with possible values:
+•	0
+•	1
+Value 1 is assigned if the value of the attribute “Wi-Fi” in the original dataset is free. Otherwise (i.e., for no value) the assigned value is 0.

+10. Outdoor Seating – Does the restaurant have a garden for guests.
+- This is a nominal (binary) type of attribute with possible values:
+•	0
+•	1
+Value 1 is assigned if the value of the attribute “Outdoor Seating” in the original dataset is true. Otherwise, the assigned value is 0.

+11. Attire – Attire that restaurants demand
+- This is a nominal (binary) type of attribute with possible values:
+•	1
+•	2
+Value 1 is assigned if the value of the attribute “Attire” in the original dataset is casual. Otherwise (i.e., for dressy value) the assigned value is 2.

+12. Longitude – Longitude of a restaurant.
+- This is a numeric type of attribute

+13. Latitude – Latitude of a restaurant.
+- This is a numeric type of attribute

+The following table shows how the attributes are represented as vectors of values for calculating similarty. 
+Stars	Good for	 Price range	Parking	Reservations	Ambience	     Noice level	Wi-Fi	Out. seating	Attire
+  4	 0,0,0,1,0,0	    2        	1       	0   	  0,0,0,1,0,0,0,0,0	   2	         1	     1	        1
+Final vector: 4,0,0,0,1,0,0,2,1,0, 0,0,0,1,0,0,0,0,0,2,1,1,1

+Category attribute is not included because it is used for filtering the dataset, and Longitude and Latitude attributes are used for calculating the distance.

3. The application
The application collects information from users about their preferences when it comes to choosing a restaurant, and the current location of the user (Figure 1). Users click on the Match button and the application finds the best matches using the recommendation engine.
 
Figure 1
The application displays at most five top restaurants, i.e., restaurants with the highest Pearson correlation coefficient, and a map displaying the location of both the recommended restaurants and the user (Figure 2). User can choose where to go based on the recommendations and the distance which is displayed for each recommendation.
 
Figure 2
4. Technical realisation
This application was written in programming language Java, in Eclipse IDE.
json-simple.jar was used for working with .json dataset and objects.
commons-math-2.2.jar was used for calculating the Pearson correlation coefficient, using correlation(double[] xArray,double[] yArray) method of PearsonsCorrelation class.
JmapViewer.jar was used for showing a map with the location of the user and recommended restaurants. 

5. Acknowledgements
This application has been developed as a part of the project assignment for the course Intelligent Systems at the Faculty of Organization Sciences, University of Belgrade, Serbia.
6. Licence

This software is licensed under the MIT License.
The MIT License (MIT)
Copyright (c) 2014 Marko Grujičić – markogrujicic92@gmail.com
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

