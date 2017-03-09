package Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Entity.ClassInfo;
import Entity.Homework;
import Entity.Test;
import Service.IClassInfoManage;
import Service.ITestAndHomeworkManage;
import Service.WordConvertToHtmlTool;

public class TestAndHomeworkAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private WordConvertToHtmlTool wordConvertToHtmlTool;
	public WordConvertToHtmlTool getWordConvertToHtmlTool() {
		return wordConvertToHtmlTool;
	}
	public void setWordConvertToHtmlTool(WordConvertToHtmlTool wordConvertToHtmlTool) {
		this.wordConvertToHtmlTool = wordConvertToHtmlTool;
	}
	
	@Resource
	private IClassInfoManage iClassInfoManage;
	
	public IClassInfoManage getIClassInfoManage() {
		return iClassInfoManage;
	}
	public void setIClassInfoManage(IClassInfoManage iClassInfoManage) {
		this.iClassInfoManage = iClassInfoManage;
	}

	private int classInfoid;
	public int getClassInfoid() {
		return classInfoid;
	}
	public void setClassInfoid(int classInfoid) {
		this.classInfoid = classInfoid;
	}

	private int homeworkid;
	public int getHomeworkid() {
		return homeworkid;
	}
	public void setHomeworkid(int homeworkid) {
		this.homeworkid = homeworkid;
	}
	
	private Test test;
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}

	private File file;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	private File answerfile;
	public File getAnswerfile() {
		return answerfile;
	}
	public void setAnswerfile(File answerfile) {
		this.answerfile = answerfile;
	}
	
	private Homework homework;
	public Homework getHomework() {
		return homework;
	}
	public void setHomework(Homework homework) {
		this.homework = homework;
	}
	
	private String fileFileName;
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	private String fileContentType;
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	private String answerfileFileName;
	 public String getAnswerfileFileName() {
			return answerfileFileName;
		}
		public void setAnswerfileFileName(String answerfileFileName) {
			this.answerfileFileName = answerfileFileName;
		}

    private String answerfileContentType;
    public String getAnswerfileContentType() {
    	return answerfileContentType;
    }
    public void setAnswerfileContentType(String answerfileContentType) {
    	this.answerfileContentType = answerfileContentType;
    } 
    
	private int testid;
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	
	@Resource
	private ITestAndHomeworkManage iTestManage;
	@Resource
	private ITestAndHomeworkManage iHomeworkManage;
	public ITestAndHomeworkManage getITestManage() {
		return iTestManage;
	}
	public void setITestManage(ITestAndHomeworkManage iTestManage) {
		this.iTestManage = iTestManage;
	}
	public ITestAndHomeworkManage getIHomeworkManage() {
		return iHomeworkManage;
	}
	public void setIHomeworkManage(ITestAndHomeworkManage iHomeworkManage) {
		this.iHomeworkManage = iHomeworkManage;
	}
	
public String findHomeworkAction ()throws Exception
{
	ActionContext.getContext().getSession().remove("homeWorkMessage");
	Homework homework=new Homework();
	homework.setHomeworkid(getHomeworkid());
	homework=(Homework) iHomeworkManage.getRuslt(homework);
	ActionContext.getContext().getSession().put("homeWorkMessage", homework);
	return SUCCESS;
	}

public String findTestAction ()throws Exception
{
	ActionContext.getContext().getSession().remove("testMessage");
	Test test=new Test();
     test.setTestid(getTestid());
	test=iTestManage.getRuslt(test);
	ActionContext.getContext().getSession().put("testMessage", test);
	return SUCCESS;
	}

public String addHomeworkAction()throws Exception
{
	Integer homeworkid=(int) System.currentTimeMillis();
	homework.setHomeworkid(homeworkid);
	 String url=ServletActionContext.getServletContext().getRealPath("/Homework/");
	 String i=(int) System.currentTimeMillis()+"";
	 if(wordConvertToHtmlTool.WordConvertToHtml(file, url, i+".html"))
	 { homework.setUrl("Homework/"+i+".html");
	 }
	 
	 if(wordConvertToHtmlTool.WordConvertToHtml(answerfile, url, "answer"+i+".html"))
	 {homework.setAnswerurl("Homework/"+"answer"+i+".html");
	 }
     iHomeworkManage.addT(homework);
     ClassInfo classInfo=new ClassInfo();
     classInfo.setClassInfoid(getClassInfoid());
     classInfo=(ClassInfo) iClassInfoManage.getClassInfoDefault(classInfo).get(0);
     classInfo.setHomeworkid(homeworkid);
     iClassInfoManage.updateClassInfo(classInfo);
	return SUCCESS;

	}
public String addTestAction()throws Exception
{
	Integer testid=(int) System.currentTimeMillis();
	test.setTestid(testid);
	String url=ServletActionContext.getServletContext().getRealPath("/Test/");
	 String i=(int) System.currentTimeMillis()+"";
	 if(wordConvertToHtmlTool.WordConvertToHtml(file, url, i+".html"))
	 { 
		 test.setUrl("Test/"+i+".html");
	 }
	 
	 if(wordConvertToHtmlTool.WordConvertToHtml(answerfile, url, "answer"+i+".html"))
	 {
		 test.setAnswerurl("Test/"+"answer"+i+".html");
	 }
	 iTestManage.addT(test);
	 ClassInfo classInfo=new ClassInfo();
     classInfo.setClassInfoid(getClassInfoid());
     classInfo=(ClassInfo) iClassInfoManage.getClassInfoDefault(classInfo).get(0);
     classInfo.setTestid(testid);
     iClassInfoManage.updateClassInfo(classInfo);
	return SUCCESS;

	}
}

