package com.example.historyservice.services;

import com.example.historyservice.entities.HistoryDetailResponse;
import com.example.historyservice.entities.HistoryResponse;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

@Service
public class HistoryService {
    String uri = "mongodb+srv://admin:1234@cluster0.jyc4d.mongodb.net";

    public HistoryResponse find(String email){
        List<Object> data = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("transaction");
            MongoCursor<Document> cursor = collection.find(eq("email", email)).iterator();
            while (cursor.hasNext()) {
                data.add(Arrays.asList(cursor.next()));
            }
            return new HistoryResponse(data);
        }
    }

    public HistoryDetailResponse findDetail(String email, int id){
        try (MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("transaction");
            Document doc = collection.find(and(eq("email", email), eq("id", id))).first();
            return new HistoryDetailResponse(doc);
        }
    }
}
