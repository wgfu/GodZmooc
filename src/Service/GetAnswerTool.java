package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GetAnswerTool {
	public String[] getAnswer(String path)
	{
		String []strList=new String[3];
		try{
			File file=new File(path);
			InputStream in=new FileInputStream(file);
			byte []b=new byte[102400000];
			in.read(b);
			 String str=new String(b).trim();
			int start=str.indexOf("选择题");
			int 	middle=str.indexOf("判断题");
			int 	end=str.indexOf("填空题");
				String str1=str.substring(start,middle).trim();
				String str2=str.substring(middle,end).trim();
				String str3=str.substring(end,str.length()-1).trim();
				String []str4=str3.split("</span>");
				String mark[]={"1.","2.","3.","4.","5.","6.","7.","8.","9.","10.","11.","12.","13.","14.","15."};
				String textanswer="";
				int i=0;
				for (String string : str4) {
					if(i<15&&string.contains(mark[i]))
					{
						int j=string.indexOf(mark[i]);
						textanswer+=string.substring(j,string.length()-1)+" ";
						textanswer=textanswer.replace(mark[i],"");
						i++;
					}
				}
				
				String selectanswer="";
				String judgeanswer="";
				int max=str1.length();
				int current=0;
				int k=0;
				while(current<max&&k<20)
				{
					if(str1.substring(current,current+1).equals("A")||str1.substring(current,current+1).equals("B")||
							str1.substring(current,current+1).equals("C")||str1.substring(current,current+1).equals("D"))
					{
						selectanswer+=str1.substring(current,current+1)+" ";
						k++;
					}
					current++;
				}
				
					 max=str2.length();
					 current=0;
					 k=0;
					while(current<max&&k<15)
					{
						if(str2.substring(current,current+1).equals("对")||str2.substring(current,current+1).equals("错"))
						{
							judgeanswer+=str2.substring(current,current+1)+" ";
							k++;
						}
						current++;
					}
			in.close();
			strList[0]=selectanswer;
			strList[1]=judgeanswer;
			strList[2]=textanswer;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return strList;
	}

}
