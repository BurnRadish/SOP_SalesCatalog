package com.example.personaldataservice.service;

import com.example.personaldataservice.entities.AddNewPersonalRequest;
import com.example.personaldataservice.entities.PersonalResponse;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Service
public class PersonalService {
    String uri = "mongodb+srv://admin:1234@cluster0.jyc4d.mongodb.net";

    public PersonalResponse find(String email){
        List<Object> data = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("role");
            MongoCursor<Document> cursor = collection.find(eq("email", email)).iterator();
            while (cursor.hasNext()) {
                data.add(Arrays.asList(cursor.next()));
            }
            return new PersonalResponse(data);
        }
    }

    public Boolean addNew(AddNewPersonalRequest addNewPersonalRequest){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("role");

            Document query = new Document().append("email",  addNewPersonalRequest.getEmail());
            Bson updates = Updates.combine(
                    Updates.addToSet("address", new Document("name", addNewPersonalRequest.getName()).append("phone", addNewPersonalRequest.getPhone()).append("address", addNewPersonalRequest.getAddress())));
            UpdateOptions options = new UpdateOptions().upsert(true);
            UpdateResult result = collection.updateOne(query, updates, options);
            System.out.println("Modified document count: " + result.getModifiedCount());
            System.out.println(addNewPersonalRequest.getEmail());
            return true;
        }
    }
}
