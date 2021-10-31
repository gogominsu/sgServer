package dmh.sgserver.repository;

import dmh.sgserver.domain.Member;

import java.util.List;
import java.util.Optional;

public class testDBMemberRepository implements MemberRepository{
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(String user_id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String user_name) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByUserNumber(Long user_number) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
