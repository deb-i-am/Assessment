package tasks;

import java.util.HashMap;
import java.util.Map;

public class eventProb {
	private Map<Object, Double> prob;
	
	public eventProb(Map<Object, Double> probabilities)
	{
		this.prob = probabilities;
	}
	
	public Object generateEvent()
	{
		double random = Math.random();
		for(Object outcome:prob.keySet())
		{
			double probability = prob.get(outcome);
			if(random<=probability)
			{
				return outcome;
			}
			random = random - probability;
		}
		return null;
	}

	public static void main(String[] args) {
		Map<Object, Double> probabilities = new HashMap<>();
		probabilities.put("Head", 0.35);
		probabilities.put("Tail", 0.65);
		
		eventProb event = new eventProb(probabilities);
		
		int numOfOccurrences = 1000;
        int headCount = 0;
        int tailCount = 0;
        for(int i=0;i<numOfOccurrences;i++)
        {
        	Object outcome = event.generateEvent();
        	if(outcome.equals("Head"))
        	{
        		headCount++;
        	}
        	else
        		tailCount++;  		
        		
        }
        System.out.println("Head appeared "+headCount+" times and Tail appeared "+tailCount+" times");	
     }

}
