package Dao;

import java.util.List;

import javax.annotation.Resource;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class MongoDaoImp implements IMongoDao{
@Resource
private MongoConnectionTool mongoConnectionTool;
	public MongoConnectionTool getMongoConnectionTool() {
	return mongoConnectionTool;
}

public void setMongoConnectionTool(MongoConnectionTool mongoConnectionTool) {
	this.mongoConnectionTool = mongoConnectionTool;
}

	@Override
	public void createCollection(String collectionname) {
		// TODO Auto-generated method stub
		 mongoConnectionTool.getMongoDatabase().createCollection(collectionname);
	}

	@Override
	public MongoCollection<Document> findCollection(String collectionname) {
		// TODO Auto-generated method stub
		return mongoConnectionTool.getMongoDatabase().getCollection(collectionname);
	}

	@Override
	public void insertMany(String collectionname, List<Document> documents) {
		// TODO Auto-generated method stub.
		MongoCollection<Document> collection=mongoConnectionTool.getMongoDatabase().getCollection(collectionname);
		collection.insertMany(documents);
	}

	@Override
	public void updateMany(String collectionname,  Document document, Document document1) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection=mongoConnectionTool.getMongoDatabase().getCollection(collectionname);
		collection.updateMany( document,new Document("$set",document1));
	}

	@Override
	public void delete(String collectionname, Document document, int i) {
		// TODO Auto-generated method stub
		MongoCollection<Document> collection=mongoConnectionTool.getMongoDatabase().getCollection(collectionname);
		if(i==0)
		{
			collection.deleteOne(document);
		}
		else {
			collection.deleteMany(document);
		}
		
	}
	@Override
	public  MongoCursor<Document> findIterable(String collectionname,Document document)
	{
		
		MongoCollection<Document> collection=mongoConnectionTool.getMongoDatabase().getCollection(collectionname);
	
		 FindIterable<Document> findIterable = collection.find(document);  
	
		 MongoCursor<Document> mongoCursor=findIterable.iterator();
		
		return mongoCursor;
	}
	 public int count(String collectionname,Document document)
	 {
		 MongoCollection<Document> collection=mongoConnectionTool.getMongoDatabase().getCollection(collectionname);
		 return (int) collection.count(document);
	 }
}
