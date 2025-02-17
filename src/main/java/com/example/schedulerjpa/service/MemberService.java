package com.example.schedulerjpa.service;

import com.example.schedulerjpa.config.PasswordEncoder;
import com.example.schedulerjpa.config.error.ErrorCode;
import com.example.schedulerjpa.config.error.exception.AuthenticationException;
import com.example.schedulerjpa.config.error.exception.base.NotFoundException;
import com.example.schedulerjpa.dto.LoginRequestDto;
import com.example.schedulerjpa.dto.LoginResponseDto;
import com.example.schedulerjpa.dto.MemberResponseDto;
import com.example.schedulerjpa.dto.SignUpResponseDto;
import com.example.schedulerjpa.entity.Member;
import com.example.schedulerjpa.repository.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpResponseDto signUp(String name, String password, String email) {
        String encodedPassword = passwordEncoder.encode(password);
        Member member = new Member(name, encodedPassword, email);
        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getName(), savedMember.getEmail());
    }

    public LoginResponseDto login(LoginRequestDto requestDto, HttpServletRequest request, HttpServletResponse response) {
        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new AuthenticationException(ErrorCode.AUTHENTICATION_FAILURE));

        if (!passwordEncoder.matches(requestDto.getPassword(), member.getPassword())) {
            throw new AuthenticationException(ErrorCode.AUTHENTICATION_FAILURE);
        }

        // 세션 설정
        HttpSession session = request.getSession(true);
        session.setAttribute("memberId", member.getId());

        // 쿠키 설정
        Cookie sessionCookie = new Cookie("SESSION_ID", session.getId());
        sessionCookie.setPath("/");
        sessionCookie.setHttpOnly(true);
        response.addCookie(sessionCookie);

        return new LoginResponseDto(member.getId(), member.getEmail(), "로그인 성공");
    }


    public MemberResponseDto findById (Long id){
            Optional<Member> optionalMember = memberRepository.findById(id);

            if (optionalMember.isEmpty()) {
                throw new NotFoundException(ErrorCode.MEMBER_NOT_FOUND);
            }

            Member findMember = optionalMember.get();

            return new MemberResponseDto(findMember.getName(), findMember.getEmail());
        }

        @Transactional
        public void updatePassword (Long id, String oldPassword, String newPassword){

            Member findMember = memberRepository.findByIdOrElseThrow(id);

            if (!passwordEncoder.matches(oldPassword, findMember.getPassword())) {
                throw new AuthenticationException(ErrorCode.AUTHENTICATION_FAILURE);
            }

            findMember.updatePassword(passwordEncoder.encode(newPassword));

        }

        public void delete (Long id){
            Member findMember = memberRepository.findByIdOrElseThrow(id);

            memberRepository.delete(findMember);
        }
    }
