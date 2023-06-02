package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExpEvaluator {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true) {
				System.out.print("Enter expression(enter 'end' to finish): ");
                String expression = reader.readLine();

                if (expression.equalsIgnoreCase("end")) {
                    break;
                }
			
			
			double result = evaluateExp(expression);
            System.out.println("Expression: " + expression);
            System.out.println("Result: " + result);
			}
        }catch(IOException e)
		{
        	e.printStackTrace();
		}

	}
	
	
	private static double evaluateExp(String exp) throws IOException{
		String apiUrl = "https://api.mathjs.org/v4/?expr=" + exp;
        URL url = new URL(apiUrl);
        
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.readLine();
        
        connection.disconnect();
        
        return Double.parseDouble(response);

	}

}
