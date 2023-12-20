package com.aim.project.domain.stock.controller;

import com.aim.project.domain.stock.dto.StockDto;
import com.aim.project.domain.stock.dto.UserLoginDto;
import com.aim.project.domain.stock.dto.UserSignUpDto;
import com.aim.project.domain.stock.service.StockService;
import com.aim.project.global.config.ResponseResult;
import com.aim.project.global.config.ResponseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@Tag(name = "Stock", description = "Stock API")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseResult<StockDto> signUp(@RequestBody UserSignUpDto userDto) {
        System.out.println(userDto);
        return new ResponseService().getResponseResult(stockService.signUp(userDto));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult<StockDto> login(@RequestBody UserLoginDto userDto) {
        return new ResponseService().getResponseResult(stockService.login(userDto));
    }
}
