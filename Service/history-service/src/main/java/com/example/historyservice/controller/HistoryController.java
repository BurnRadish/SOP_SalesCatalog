package com.example.historyservice.controller;

import com.example.historyservice.entities.HistoryDetailResponse;
import com.example.historyservice.entities.HistoryResponse;
import com.example.historyservice.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/history")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(final HistoryService historyService){
        this.historyService = historyService;
    }

    @GetMapping(value = "")
    public ResponseEntity<HistoryResponse> history(@RequestHeader(value = "email") String email){
        return ResponseEntity.ok(historyService.find(email));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HistoryDetailResponse> historyDetail(@RequestHeader String email, @PathVariable("id") int id){
        return ResponseEntity.ok(historyService.findDetail(email, id));
    }
}
