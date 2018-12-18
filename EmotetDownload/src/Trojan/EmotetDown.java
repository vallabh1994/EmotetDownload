package Trojan;
import java.util.*;
import java.io.*;

public class EmotetDown {
	
    public static int processData(ArrayList<String> array,ArrayList<String> Outlist){
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
    	int i=0;
    	int count=1;
		try{
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

    	
    	ArrayList<HashMap> ar=new ArrayList<>();
    	
    	for(String Emp:array)
    	{
    		   StringTokenizer st = new StringTokenizer(Emp,", ");
    		   ar.add(new HashMap<String,String>());
			   		if (st.hasMoreElements())
    		   		{
    	    			   String id=st.nextToken();
    	    			   ar.get(i).put("id",id);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String dateadded=st.nextToken();
    		   			ar.get(i).put("dateadded",dateadded);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String time=st.nextToken();
 					   ar.get(i).put("time",time);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    	    			String url=st.nextToken();

  					   ar.get(i).put("url",url);

    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String status=st.nextToken();
   					   ar.get(i).put("status",status);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String MalwareDownload=st.nextToken();
    					   ar.get(i).put("MalwareDownload",MalwareDownload);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String name=st.nextToken();
    		   			ar.get(i).put("name",name);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String version=st.nextToken();
 					   ar.get(i).put("version",version);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String type=st.nextToken();
    		   			ar.get(i).put("type",type);
    		   		}
    		   		if (st.hasMoreElements())
    		   		{
    		   			String abusechurl=st.nextToken();
   					   ar.get(i).put("abusechurl",abusechurl);
    		   		}
    		   		i++;
    	}
    	int len=ar.size();
       	for(i=0;i<len;i++)
    	{
    		String sid=(String) ar.get(i).get("url");
    		//System.out.println(ar.get(i).get("name").toString());
    		if(
    				(
    						ar.get(i).get("name").toString().equals("emotet")||
    		                (ar.get(i).get("MalwareDownload").toString().equals("emotet"))
    		         )
    				)
    		{
    		 System.out.println(sid);
    		 output.println(sid);
    		}
    		/*else if(ar.get(i).get("name").toString().equals("exe"))
    		{
       		 System.out.println(sid);
       		 output.println(sid);
    		}*/
    	}
    	 output.close();
		 
		}catch (Exception e) {
            System.out.println("IO error in input.txt or output.txt");
        }
        return 1;
    }

	public static void main(String[] args) {
		  ArrayList<String> inputData = new ArrayList<String>();
			ArrayList<String> input = new ArrayList<String>();
	        try {
	            Scanner in = new Scanner(new BufferedReader(new FileReader("urlhaus.txt")));
	            while(in.hasNextLine()) {
	                String line = in.nextLine().trim();
	                if (!line.isEmpty()) // Ignore blank lines
	                    inputData.add(line);
	            }
	            processData(inputData, input);
	        } catch (IOException e) {
	            System.out.println("IO error in input.txt or output.txt");
	        }
	}

}
