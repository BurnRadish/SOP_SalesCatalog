package com.example.historyservice.services;

import com.example.historyservice.entities.HistoryDetailResponse;
import com.example.historyservice.entities.HistoryRequest;
import com.example.historyservice.entities.HistoryResponse;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

@Service
public class HistoryService {
    String uri = "mongodb+srv://admin:1234@cluster0.jyc4d.mongodb.net";

    public HistoryResponse find(HistoryRequest historyRequest){
        List<Object> data = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("History");
            MongoCursor<Document> cursor = collection.find(eq("email", historyRequest.getEmail())).iterator();
            while (cursor.hasNext()) {
                data.add(Arrays.asList(cursor.next()));
            }
            return new HistoryResponse(data);
        }
    }

    public HistoryDetailResponse findDetail(HistoryRequest historyRequest, int id){
        try (MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("History");
            Document doc = collection.find(and(eq("email", historyRequest.getEmail()), eq("orderId", id))).first();
            System.out.println(historyRequest.getEmail());
            System.out.println(id);
            System.out.println(doc);
            return new HistoryDetailResponse(doc);
        }
    }
}
