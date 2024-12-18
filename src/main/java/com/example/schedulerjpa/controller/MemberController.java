package com.example.schedulerjpa.controller;

import com.example.schedulerjpa.dto.MemberResponseDto;
import com.example.schedulerjpa.dto.SignUpRequestDto;
import com.example.schedulerjpa.dto.SignUpResponseDto;
import com.example.schedulerjpa.dto.UpdatePasswordRequestDto;
import com.example.schedulerjpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){

        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getName(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ){

        memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        memberService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}