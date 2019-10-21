package models;
import java.lang.Math;
import java.text.DecimalFormat;
public class Person {
	private double Height;// height in meters, accepted values are between 0.30m and 2.30m 
	private double Weight;// weight in kg, accepted values are between 2kg and 380k 


	// Constructor for weight and height
	public Person(double H, double W){
		this.Height=H;
		this.Weight=W;
	}

	// calculate IMC
	public String CalculateIMC() {
		//check intervals
		if(this.Height>=0.30 && this.Height<=2.30 && this.Weight>=2 && this.Weight<=380) {
			return new DecimalFormat("###.##").format((this.Weight)/(Math.pow(this.Height, 2)));
		}else {
			// if intervals are not respected return a string "bad interval" 
			return "bad value";
		}
	}



}
