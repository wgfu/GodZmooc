package Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.ClassInfo;
import Entity.User;
import Service.IClassInfoManage;
import Service.IClassManage;
import Service.WordConvertToHtmlTool;

public class AddClassAction extends ActionSupport{
	/**
	 * 
	 */
	@Resource
	private WordConvertToHtmlTool wordConvertToHtmlTool;
	public WordConvertToHtmlTool getWordConvertToHtmlTool() {
		return wordConvertToHtmlTool;
	}
	public void setWordConvertToHtmlTool(WordConvertToHtmlTool wordConvertToHtmlTool) {
		this.wordConvertToHtmlTool = wordConvertToHtmlTool;
	}
	private static final long serialVersionUID = 1L;
	private ClassInfo classInfo;
	private File file;
	private String type;
	@Resource
	private IClassManage iClassManage;
	
    public IClassManage getIClassManage() {
		return iClassManage;
	}
	public void setIClassManage(IClassManage iClassManage) {
		this.iClassManage = iClassManage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	private String fileFileName;
   private String fileContentType;

	public ClassInfo getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}
	@Resource
	private IClassInfoManage iClassInfoManage;
	public IClassInfoManage getIClassInfoManage()
	{
		return this.iClassInfoManage;
		}
	public void setIClassInfoManage(IClassInfoManage iClassInfoManage)
	{
		this.iClassInfoManage=iClassInfoManage;
		}
	public String execute()throws Exception
	{
		User user=(User) ActionContext.getContext().getSession().get("user");
		Integer classInfoid=(int) (100000*Math.random());
		classInfo.setClassInfoid(classInfoid);
		classInfo.setUserid(user.getUserid());
		Date date=new Date();
	
		java.sql.Date date_sql=new java.sql.Date(date.getTime());
		classInfo.setTime(date_sql);
		classInfo.setClassid(iClassManage.getClassByType(getType()).getClassid());
		 int k=(int) (Math.random()*Math.random()*111111);
	      classInfo.setCommentid(k);
		int i=(int) System.currentTimeMillis();
			String cString=i+"";
		   	  String suffix =getFileFileName().substring(getFileFileName().lastIndexOf("."));
		   	  
		   	  String url="";
		  
		   	if(classInfo.getType().equals("ÎÄ×Ö½ÌÑ§"))
			{
		   	 String realpath=ServletActionContext.getServletContext().getRealPath("/Message/");
		   suffix =".html";
		  	 
			   	 classInfo.setUrl("Message/"+cString+suffix);
			   	 url=realpath;
			   	if(wordConvertToHtmlTool.WordConvertToHtml(file, url,cString+suffix))
			   	{
			   			iClassInfoManage.addClassInfo(classInfo);
			   			return SUCCESS;
			   	}
			   	else{
			   		return "fail";
			   	}
			}
			else
			{
				 String realpath=ServletActionContext.getServletContext().getRealPath("/Video/");
				 url=realpath;
				
				 classInfo.setUrl("Video/"+cString+suffix);
				
		           File target = new File(realpath+cString+suffix);
		        
		           if (target.exists()) {
		               target.delete();
		           }
		           InputStream is = new FileInputStream(file);
		           OutputStream os = new FileOutputStream(target);
		           byte[] buffer = new byte[323840];
		           int length = 0;
		           while ((length = is.read(buffer)) > 0) {
		           	  os.write(buffer, 0, length);
		           }
		           is.close();
		           os.close();
				 iClassInfoManage.addClassInfo(classInfo);
				 return SUCCESS;
			}

	}

}
