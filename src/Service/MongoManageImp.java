package Service;

import java.util.List;

import javax.annotation.Resource;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import Dao.IMongoDao;

public class MongoManageImp implements IMongoManage{
   @Resource
   private IMongoDao iMongoDao;
	public IMongoDao getIMongoDao() {
	return iMongoDao;
}

public void setIMongoDao(IMongoDao iMongoDao) {
	this.iMongoDao = iMongoDao;
}

	@Override
	public void createCollection(String collectionname) {
		// TODO Auto-generated method stub
		iMongoDao.createCollection(collectionname);
	}

	@Override
	public MongoCollection<Document> findCollection(String collectionname) {
		// TODO Auto-generated method stub
		return iMongoDao.findCollection(collectionname);
	}

	@Override
	public void insertMany(String collectionname, List<Document> documents) {
		// TODO Auto-generated method stub
		iMongoDao.insertMany(collectionname, documents);
	}

	@Override
	public void updateMany(String collectionname, Document document, Document document1) {
		// TODO Auto-generated method stub
		iMongoDao.updateMany(collectionname, document, document1);
	}

	@Override
	public void delete(String collectionname, Document document, int i) {
		// TODO Auto-generated method stub
		iMongoDao.delete(collectionname, document, i);
	}
	public  MongoCursor<Document>  findIterable(String collectionname,Document document)
	{
		return iMongoDao.findIterable(collectionname, document);
	}
    public int count(String collectionname,Document document)
    {
    	return iMongoDao.count(collectionname, document);
    }
}
