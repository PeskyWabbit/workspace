package Lab2;

import javax.swing.*;

class ConvertTemps {


	public static float getTemperature(String temperatureName) {

		String temperatureString;
		float temperature;
		
		temperatureString = JOptionPane.showInputDialog("enter " + temperatureName + "value: ");
		temperature = Float.parseFloat(temperatureString);
		return temperature;
	}
	

	public static float convert(boolean celciusToFahrenheitWanted, float temperature){
		float answer;
		
		if(celciusToFahrenheitWanted){
			answer = (9.0f*temperature)/5.0f + 32.0f;
		}
		else{
			answer = 5.0f*(temperature - 32.0f)/9.0f;
		}	
		return answer;
	}
	
	
	public static void main (String[] args){
		String whichConversion = "";
		String output = "";
		float userInputFloat;
		
		whichConversion = JOptionPane.showInputDialog("(A) convert celcius to " + 
						  "fahrenheit or (B) convert fahrenheit to celcius?");
		whichConversion = whichConversion.toUpperCase();
		
		if (whichConversion.equals("A")){
			userInputFloat = getTemperature("Celcius ");
			output = userInputFloat + "degrees in celcius = " + convert(true, userInputFloat) + "degrees fahrenheit";
		}
		else if (whichConversion.equals("B")){
			userInputFloat = getTemperature("Fahrenheit ");
			output = userInputFloat + "degrees in Fahrenheit = " + convert(false, userInputFloat) + "degrees celcius.";
		}	
		
		else{
			output = "Sorry, you were supposed to enter A or B";
		}
		JOptionPane.showMessageDialog(null, output, "temperature conversion", JOptionPane.PLAIN_MESSAGE);
	}
}
	
