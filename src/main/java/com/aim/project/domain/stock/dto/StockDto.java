package com.aim.project.domain.stock.dto;

import com.aim.project.domain.stock.entity.Stock;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {
    private int seq;
    private String username;
    private String password;

    @Builder(builderMethodName = "dtoBuilder")
    public StockDto(Stock user) {
        this.seq = user.getSeq();
        this.username = user.getUsername();
    }

    public Stock toEntity() {
        return Stock.builder().seq(seq).username(username).build();
    }
}
