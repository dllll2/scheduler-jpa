//package com.example.schedulerjpa.controller;
//
//import com.example.schedulerjpa.dto.LoginRequestDto;
//import com.example.schedulerjpa.dto.LoginResponseDto;
//import com.example.schedulerjpa.service.MemberService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final MemberService memberService;
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
//                                                  HttpServletRequest request) {
//        LoginResponseDto responseDto = memberService.login(loginRequestDto);
//
//        if (responseDto == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        // 세션 저장
//        HttpSession session = request.getSession();
//        session.setAttribute("memberId", responseDto.getMemberId());
//
//        return ResponseEntity.ok(responseDto);
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        return ResponseEntity.ok("로그아웃 성공");
//    }
//}
