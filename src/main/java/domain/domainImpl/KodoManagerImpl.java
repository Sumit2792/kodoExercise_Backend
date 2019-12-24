package domain.domainImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import dao.Kodo;
import domain.KodoManager;

@Repository
public class KodoManagerImpl implements KodoManager {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public List<Kodo> getAllKodoDetails() {
		return mongoTemplate.findAll(Kodo.class);
	}
	
	DBCollection kodoCollection = (DBCollection) mongoTemplate.getCollection("kodo");

	@Override
	public DBObject getSearchedDetail(String searchValue) {		
		
		DBObject query = new BasicDBObject("name", searchValue).append("description",
				new BasicDBObject("$gt", searchValue));;
		
		DBObject searchedDoc = kodoCollection.findOne(query);

	
		return searchedDoc;
	}

	@Override
	public List<Kodo> getKodoPagination(int limit, int offset) {
		MongoCollection <Document> collection = (MongoCollection<Document>) mongoTemplate.getCollection("kodo");
		 	
		List<Kodo> data =  KodoManagerImpl.pagination(collection, limit, offset);
		return data;
		
	}
	
	/* collection pagination */
    @SuppressWarnings("unchecked")
	public static List<Kodo> pagination(MongoCollection <Document> collection, int pageNumber, int pageSize) {
    	 Document person = null;
        try {
 
            MongoCursor <Document> cursor = collection.find().skip(pageSize * (pageNumber - 1)).limit(pageSize).iterator();
           
            while (cursor.hasNext()) {
                person = cursor.next();
                System.out.println(person);
            }
            cursor.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		return (List<Kodo>) person;
    }

}
