package Action;

import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.ITestAndHomeworkDao;
import Entity.User;
import Entity.score;
import Service.CalculateTool;
import Service.GetAnswerTool;
import Service.ITestAndHomeworkManage;

public class CalculateScoreAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ITestAndHomeworkManage iScoreManage;
	public ITestAndHomeworkManage getIScoreManage() {
		return iScoreManage;
	}
	public void setIScoreManage(ITestAndHomeworkManage iScoreManage) {
		this.iScoreManage = iScoreManage;
	}
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
	private Integer testid;
public Integer getTestid() {
		return testid;
	}
	public void setTestid(Integer testid) {
		this.testid = testid;
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
		    double sum=0;
		    sum+=calculateTool.calculate(calculateTool.Convert(getSelect()), calculateTool.Convert(list[0]))*2;
		    sum+=calculateTool.calculate(calculateTool.Convert(getJudge()), calculateTool.Convert(list[1]))*2;
		    sum+=calculateTool.calculate(calculateTool.Convert(getText()), calculateTool.Convert(list[2]))*2;
		    out.println(sum);  
		    out.flush();  
		    out.close();  
		    score score=new score();
		    score.setScore(sum);
		    score.setTestid(getTestid());
		    User user=(User) ActionContext.getContext().getSession().get("user");
		    score.setUserid(user.getUserid());
		    Date date=new Date();
			java.sql.Date date_sql=new java.sql.Date(date.getTime());
			score.setTime(date_sql);
		    iScoreManage.addT(score);
		return NONE;
	}

}
