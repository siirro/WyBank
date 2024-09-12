package com.wybank.member;

import com.wybank.member.domain.Member;
import com.wybank.member.domain.MemberRole;
import com.wybank.member.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Log4j2
@ActiveProfiles("local")
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Test
//    public void testCreateMember() {
//        for(int i=0; i<10; i++) {
//            Member member = Member.builder()
//                    .userId("user"+i)
//                    .pw(passwordEncoder.encode("1111"))
//                    .userName("테스트"+i)
//                    .build();
//            member.addRole(MemberRole.USER);
//            if(i > 6) {
//                member.addRole(MemberRole.MANAGER);
//            }
//            if(i > 8) {
//                member.addRole(MemberRole.ADMIN);
//            }
//            memberRepository.save(member);
//        }//end for
//    }

    @Test
    public void testRead() {
        String userId = "user9";
        Member member = memberRepository.getWithRoles(userId);
        log.info("롤조회"+member);
        log.info("롤조회"+member.getMemberRoleList());
    }
}
