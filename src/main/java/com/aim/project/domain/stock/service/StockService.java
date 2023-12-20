package com.aim.project.domain.stock.service;

import com.aim.project.domain.stock.dto.StockDto;
import com.aim.project.domain.stock.dto.UserLoginDto;
import com.aim.project.domain.stock.dto.UserSignUpDto;
import com.aim.project.domain.stock.entity.Stock;
import com.aim.project.domain.stock.repository.StockRepository;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StockService {
    private final StockRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    public StockService(StockRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public StockDto signUp(UserSignUpDto userDto) {
        userDto.encodePassword(encoder.encode(userDto.getPassword()));

        Stock user = userRepository.signUp(userDto.toEntity());

        StockDto result = StockDto.dtoBuilder().user(user).build();

        return result;
    }

    public StockDto login(UserLoginDto userDto) {
        Stock user = userRepository.login(userDto);

        if (user ==  null) {
            throw new HttpMessageConversionException("회원 정보가 없습니다.");
        }

        if (!encoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new HttpMessageConversionException("비밀번호가 일치하지 않습니다.");
        }

        StockDto result = StockDto.dtoBuilder().user(user).build();

        return result;
    }
}
