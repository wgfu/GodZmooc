package Action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Service.CalculateTool;
import Service.GetAnswerTool;

public class CalculateScoreAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CalculateTool calculateTool;
	@Resource
	private GetAnswerTool getAnswerTool;
   public CalculateTool getCalculateTool() {
		return calculateTool;
	}
	public void setCalculateTool(CalculateTool calculateTool) {
		this.calculateTool = calculateTool;
	}
	public GetAnswerTool getGetAnswerTool() {
		return getAnswerTool;
	}
	public void setGetAnswerTool(GetAnswerTool getAnswerTool) {
		this.getAnswerTool = getAnswerTool;
	}
private String select;
   public String getSelect() {
	return select;
}
public void setSelect(String select) {
	this.select = select;
}
public String getJudge() {
	return judge;
}
public void setJudge(String judge) {
	this.judge = judge;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
private String judge;
private String answerurl;
   public String getAnswerurl() {
	return answerurl;
}
public void setAnswerurl(String answerurl) {
	this.answerurl = answerurl;
}
private String text;
	public String execute ()throws Exception
	{

		 HttpServletResponse response=ServletActionContext.getResponse();  
		    response.setContentType("text/html;charset=GBK");
		    String realpath=ServletActionContext.getServletContext().getRealPath("");
		String []list=getAnswerTool.getAnswer(realpath+getAnswerurl());
		    PrintWriter out = response.getWriter(); 
		    double sum=100;
		    sum+=calculateTool.calculate(calculateTool.Convert(getSelect()), calculateTool.Convert(list[0]))*2;
		    sum+=calculateTool.calculate(calculateTool.Convert(getJudge()), calculateTool.Convert(list[1]))*2;
		    sum+=calculateTool.calculate(calculateTool.Convert(getText()), calculateTool.Convert(list[2]))*2;
		    out.println(sum);  
		    out.flush();  
		    out.close();  
		return NONE;
	}

}
