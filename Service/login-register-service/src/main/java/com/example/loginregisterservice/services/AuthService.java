package com.example.loginregisterservice.services;

import com.example.loginregisterservice.entities.RegisterResponse;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.loginregisterservice.entities.AuthRequest;
import com.example.loginregisterservice.entities.AuthResponse;
import com.example.loginregisterservice.entities.User;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AuthService {
    private final JwtUtil jwt;
    String uri = "mongodb+srv://admin:1234@cluster0.jyc4d.mongodb.net";
//    String uri = "mongodb://localhost:27017";

    @Autowired
    public AuthService(final JwtUtil jwt){this.jwt = jwt;}

    public AuthResponse logIn(AuthRequest authRequest){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("role");
            Document doc = collection.find(eq("email", authRequest.getEmail())).first();

            if(authRequest.getEmail().equals(doc.getString("email")) && authRequest.getPassword().equals(doc.getString("password"))){
                User user = User.builder()
                        .id(doc.getObjectId("id"))
                        .email(doc.getString("email"))
                        .password(doc.getString("password"))
                        .role(doc.getString("role"))
                        .build();
                String accessToken = jwt.generate(user, "ACCESS");

                return new AuthResponse(accessToken, doc.getString("email"), doc.getString("role"));
            }
            return null;
        } catch (Exception e){
            throw e;
        }
    }

    public RegisterResponse register(AuthRequest authRequest){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("role");
            Document doc = collection.find(eq("email", authRequest.getEmail())).first();
            if(doc == null){
                InsertOneResult result = collection.insertOne(new Document()
                        .append("id", new ObjectId())
                        .append("email", authRequest.getEmail())
                        .append("wallet", 0)
                        .append("role", "member")
                        .append("address", new ArrayList<>())
                        .append("password", authRequest.getPassword()));
                System.out.println("Success! Inserted document id: " + result.getInsertedId());
                return new RegisterResponse(true);
            }
            return new RegisterResponse(false);
        } catch (Exception e){
            throw e;
        }
    }
}
