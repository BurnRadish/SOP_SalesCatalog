package com.example.historyservice.controller;

import com.example.historyservice.entities.HistoryDetailResponse;
import com.example.historyservice.entities.HistoryRequest;
import com.example.historyservice.entities.HistoryResponse;
import com.example.historyservice.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/history")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(final HistoryService historyService){
        this.historyService = historyService;
    }

    @PostMapping(value = "")
    public ResponseEntity<HistoryResponse> history(@RequestBody HistoryRequest request){
        return ResponseEntity.ok(historyService.find(request));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<HistoryDetailResponse> historyDetail(@RequestBody HistoryRequest request, @PathVariable("id") int id){
        return ResponseEntity.ok(historyService.findDetail(request, id));
    }
}
