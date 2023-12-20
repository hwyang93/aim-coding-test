package com.aim.project.domain.user.service;

import com.aim.project.domain.user.dto.UserDto;
import com.aim.project.domain.user.dto.UserLoginDto;
import com.aim.project.domain.user.dto.UserSignUpDto;
import com.aim.project.domain.user.entity.User;
import com.aim.project.domain.user.repository.UserRepository;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UserDto signUp(UserSignUpDto userDto) {
        userDto.encodePassword(encoder.encode(userDto.getPassword()));

        User user = userRepository.signUp(userDto.toEntity());

        UserDto result = UserDto.dtoBuilder().user(user).build();

        return result;
    }

    public UserDto login(UserLoginDto userDto) {
        User user = userRepository.login(userDto);

        if (user ==  null) {
            throw new HttpMessageConversionException("회원 정보가 없습니다.");
        }

        if (!encoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new HttpMessageConversionException("비밀번호가 일치하지 않습니다.");
        }

        UserDto result = UserDto.dtoBuilder().user(user).build();

        return result;
    }
}
