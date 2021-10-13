package org.ayupov.raiffeisentask.controllers;


import org.ayupov.raiffeisentask.dto.SockDto;
import org.ayupov.raiffeisentask.models.Sock;
import org.ayupov.raiffeisentask.services.SockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socks")
public class SockController {

    @Autowired
    private SockService sockService;

    @GetMapping
    public ResponseEntity<List<Sock>> getSocks(@RequestParam("color") String color,
                                        @RequestParam("operation") String operation,
                                        @RequestParam("cottonPart") String cottonPart) {
        List<Sock> result = sockService.getSocksByParam(SockDto.builder().color(color)
                        .cottonPart(Byte.parseByte(cottonPart))
                        .build(),
                operation);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/income")
    public ResponseEntity<SockDto> incomeSocks (@RequestBody SockDto sockDto) {
        return ResponseEntity.ok(sockService.addSocks(sockDto));
    }

    @PostMapping("/outcome")
    public ResponseEntity<SockDto> outcomeSocks(@RequestBody SockDto sockDto) {
        return ResponseEntity.ok(sockService.takeSocks(sockDto));
    }
}
