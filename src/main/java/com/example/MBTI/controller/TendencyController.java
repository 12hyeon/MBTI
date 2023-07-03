package com.example.MBTI.controller;

import com.example.MBTI.dto.TendencyDto;
import com.example.MBTI.service.TendencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/mbti")
@RestController
@ResponseBody
@RequiredArgsConstructor
public class TendencyController {

    private final TendencyService tendencyService;

    @GetMapping("/{type}")
    public Object getMbti(@PathVariable("type") String type) {
        System.out.println("type = " + type);
        return tendencyService.findOne(type);
    }

    @PostMapping()
    public Object saveMbti(@RequestBody TendencyDto dto) {
        return tendencyService.save(dto);
    }

    @GetMapping("/all")
    public Object getAll() {
        return tendencyService.findAll();
    }
}
