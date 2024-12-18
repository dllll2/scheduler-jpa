package com.example.schedulerjpa.service;

import com.example.schedulerjpa.dto.MemberResponseDto;
import com.example.schedulerjpa.dto.SignUpResponseDto;
import com.example.schedulerjpa.entity.Member;
import com.example.schedulerjpa.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    public LoginResponseDto login(LoginRequestDto requestDto) {
//        return memberRepository.findByEmail(requestDto.getEmail())
//                .filter(member -> member.getPassword().equals(requestDto.getPassword()))
//                .map(member -> new LoginResponseDto(member.getId(), member.getEmail(), "로그인 성공"))
//                .orElse(null);
//    }

    @Transactional
    public SignUpResponseDto signUp(String name, String password, String email) {
        Member member = new Member(name,password,email);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(),savedMember.getName(), savedMember.getEmail());
    }

    public MemberResponseDto findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getName(), findMember.getEmail());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if(!findMember.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatePassword(newPassword);

    }

    public void delete(Long id) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findMember);
    }
}
