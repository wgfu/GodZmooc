package Dao;




import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;

public class MongoConnectionTool { 
	private String url;
	private static MongoClient mongoClient;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	private Integer postid;
	private String databaseName;
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public MongoDatabase getMongoDatabase()
	{
	
			System.out.println("getMongo.start");
		if(mongoClient==null)
		{
			System.out.println("CreateMongoClient");
			System.out.println("url:"+getUrl()+"..postid:"+getPostid());
			mongoClient=new MongoClient(getUrl(),getPostid());
			System.out.println("CreateMongoClient.done");
		}
		
		System.out.println("databasename:"+getDatabaseName());
		return mongoClient.getDatabase(getDatabaseName());
	}
}

