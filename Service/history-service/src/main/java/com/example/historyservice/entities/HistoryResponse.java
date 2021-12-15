package com.example.historyservice.entities;

import com.mongodb.client.MongoCursor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HistoryResponse {
    private List<Object> history;
}
