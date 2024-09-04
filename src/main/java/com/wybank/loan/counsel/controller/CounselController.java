package com.wybank.loan.counsel.controller;

import com.wybank.controller.AbstractController;
import com.wybank.loan.counsel.dto.CounselDTO;
import com.wybank.loan.counsel.service.CounselService;
import com.wybank.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counsels")
public class CounselController  extends AbstractController {

    private final CounselService counselService;

    @PostMapping
    public ResponseDTO<CounselDTO.Response> create(@RequestBody CounselDTO.Request request){
        return ok(counselService.create(request));
    }

    @GetMapping("/{counselId}")
    public ResponseDTO<CounselDTO.Response> get(@PathVariable("counselId") Long counselId){
        return ok(counselService.get(counselId));
    }

    @PutMapping("/{counselId}")
    public ResponseDTO<CounselDTO.Response> update(@PathVariable("counselId") Long counselId, @RequestBody  CounselDTO.Request request){
        return ok(counselService.update(counselId,request));
    }
}
