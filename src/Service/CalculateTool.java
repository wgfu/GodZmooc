package Service;

public class CalculateTool {

    public Double calculate(String []List,String []answerList)
    {
    	
    	double sum=0;
    	for(int i=0;i<List.length;i++)
    	{
    		if(List[i].equals(answerList[i]))
    		{
    			sum+=1;
    		}
    		
    	}
    	return sum;
    }
    public String[] Convert(String str)
    {
    	String []str_List=str.split(" ");
    	return str_List;
    }

}
