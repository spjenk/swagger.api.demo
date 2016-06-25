package round.selection;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import round.model.Picks;

public class Selection {

	public boolean SaveTips(Picks picks) {
		
		MongoClient mongoClient = new MongoClient();
		
		MongoDatabase db = mongoClient.getDatabase("tipping");
		MongoCollection<Document> collection = db.getCollection("RoundTips");
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", picks.getId());
		
		if (collection.count(whereQuery) > 0) {
			collection.findOneAndReplace(whereQuery, getDocument(picks));
		} else {
			collection.insertOne(getDocument(picks));
		}				
		
		FindIterable<Document> documents = db.getCollection("RoundTips").find();
		for(Document document : documents) {
			System.out.println(document.toString());
		}		  		
		
		mongoClient.close();
		
		return true;
	}

	private Document getDocument(Picks picks) {
		return new Document("_id", picks.getId()).append("picks", new Document().append("user", picks.getUser())
				.append("round", picks.getRound()).append("selection", picks.getTip()));

	}

}
