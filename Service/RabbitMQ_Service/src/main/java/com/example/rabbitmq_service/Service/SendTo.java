package com.example.rabbitmq_service.Service;

import com.example.rabbitmq_service.entity.transaction;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.json.*;

@Service
public class SendTo {
    private int count = (int) (Math.random()*100000);
    String uri = "mongodb+srv://admin:1234@cluster0.jyc4d.mongodb.net";
    @RabbitListener(queues = "OrderQueues")
    public void result(transaction result){
        JSONObject obj = new JSONObject(result);
        //ArrayList<String> obi = new ArrayList<String>();
        //obi.add(result.getTran().get(0));
        //JSONObject obj = new JSONObject(result.getTran());
        //JsonObject obj = new JsonObject((String) result.getTran().get(0));
        System.out.println(obj.getJSONArray("tran").getJSONObject(0).getString("name"));
        System.out.println(obj.getJSONArray("tran").getJSONObject(0).getInt("amounts"));
        try{
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("transaction");
            collection.insertOne(new Document()
                    .append("tran", result.getTran())//obj.getJSONArray("tran"))
                    .append("address", result.getAddress())//obj.getString("address"))
                    .append("email", result.getEmail())//obj.getString("email"))
                    .append("priceResult", result.getResultprice())
                    .append("id", this.count)
            );
            MongoCollection<Document> collection2 = database.getCollection("Product");
            for(int i=0;i<result.getTran().toArray().length;i++){
                Document col = collection2.find(eq("name", obj.getJSONArray("tran").getJSONObject(i).getString("name"))).first();
                Document query = new Document().append("name",obj.getJSONArray("tran").getJSONObject(i).getString("name"));
                Bson updates = Updates.combine(
                        Updates.set("quantity", col.getInteger("quantity")-obj.getJSONArray("tran").getJSONObject(0).getInt("amounts")));
                UpdateOptions options = new UpdateOptions().upsert(true);
                collection2.updateOne(query, updates, options);
            }
            System.out.println("Success");
        }catch (Exception e){
            throw e;
        }
    }
}
