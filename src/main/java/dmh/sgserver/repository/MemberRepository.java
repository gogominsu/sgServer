package dmh.sgserver.repository;

import dmh.sgserver.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(String user_id);
    Optional<Member> findByName(String user_name);
    Optional<Member> findByUserNumber(Long user_number);
    List<Member> findAll();
}
