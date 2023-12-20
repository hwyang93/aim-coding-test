package com.aim.project.domain.user.dto;

import com.aim.project.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int seq;
    private String username;
    private String password;

    @Builder(builderMethodName = "dtoBuilder")
    public UserDto(User user) {
        this.seq = user.getSeq();
        this.username = user.getUsername();
    }

    public User toEntity() {
        return User.builder().seq(seq).username(username).build();
    }
}
