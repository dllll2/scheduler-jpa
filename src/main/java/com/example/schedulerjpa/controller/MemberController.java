package com.example.schedulerjpa.controller;

import com.example.schedulerjpa.dto.*;
import com.example.schedulerjpa.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(
            @Validated @RequestBody SignUpRequestDto requestDto,
            BindingResult bindingResult){
            log.info("Controller 호출");

        if(bindingResult.hasErrors()){
            log.info("validation errors={}", bindingResult);
            return (ResponseEntity<SignUpResponseDto>) bindingResult.getAllErrors();
        }

        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getName(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );
        return new ResponseEntity<>(signUpResponseDto,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Validated @RequestBody LoginRequestDto requestDto, HttpServletRequest request, HttpServletResponse response,
            BindingResult bindingResult){

        log.info("Controller 호출");

        if(bindingResult.hasErrors()){
            log.info("validation errors={}", bindingResult);
            return (ResponseEntity<LoginResponseDto>) bindingResult.getAllErrors();
        }
        LoginResponseDto loginResponseDto = memberService.login(requestDto, request, response);

        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @Validated @RequestBody UpdatePasswordRequestDto requestDto,
            BindingResult bindingResult
    ){
        log.info("Controller 호출");

        if(bindingResult.hasErrors()){
            log.info("validation errors={}", bindingResult);
            return (ResponseEntity<Void>) bindingResult.getAllErrors();
        }

        memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        memberService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
