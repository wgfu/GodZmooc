package Dao;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
public interface IMongoDao {
	public void createCollection(String collectionname);//when collectionname==null,get all collections
	public  MongoCollection<Document>  findCollection(String collectionname);
	public  MongoCursor<Document>  findIterable(String collectionname,Document document);
	public void insertMany(String collectionname,List<Document> documents);
    public void updateMany(String collectionname,Document document,Document document1);
    public void delete(String collectionname,Document document,int i);//i=0,delete one;i=1,delete Many
    public int count(String collectionname,Document document);
}
