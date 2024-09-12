package com.wybank.security;

import com.wybank.member.domain.Member;
import com.wybank.member.dto.MemberDTO;
import com.wybank.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("userDetail---------------");
        log.info(username);
        Member member = memberRepository.getWithRoles(username);

        if(member == null) {
            throw new UsernameNotFoundException("Not Found username");
        }

        MemberDTO memberDTO = new MemberDTO(
                member.getUserId(),
                member.getUserName(),
                member.getPw(),
                member.getPhone(),
                member.isSocial(),
                member.isDeleted(),
                member.getMemberRoleList()
                        .stream()
                        .map(memberRole -> memberRole.name()).collect(Collectors.toList()),
                member.getCreatedAt(),
                member.getUpdatedAt(),
                member.getDeletedAt()
        );

        log.info(memberDTO);

        return memberDTO;
    }
}
