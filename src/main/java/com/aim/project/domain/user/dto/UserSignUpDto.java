package com.aim.project.domain.user.dto;

import com.aim.project.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class UserSignUpDto {
    private String username;
    private String password;

    public User toEntity() {
        return User.builder().username(username).password(password).build();
    }

    public void encodePassword(String encodePassword) {
        this.password = encodePassword;
    }

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class Request {
//        private String username;
//        private String password;
//
//        @Builder
//        public Request(String username, String password) {
//            this.username = username;
//            this.password = password;
//        }
//
//        public void encodePassword(String encodePassword) {
//            this.password = encodePassword;
//        }
//
//        public User toEntity() {
//            return User.builder()
//                    .username(username)
//                    .password(password)
//                    .build();
//        }
//    }
//
//    @Getter
//    public static class Response {
//        private long seq;
//
//        @Builder
//        public Response(long seq) {
//            this.seq = seq;
//        }
//    }
}
