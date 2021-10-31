package dmh.sgserver.repository;

import dmh.sgserver.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

//unit test 를 위해 메모리에 회원정보를 저장합니다.
public class testLocalMemberRepository implements MemberRepository {
    private static Map<Long, Member> data = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Member save(Member member) {
        member.setUser_number(sequence.incrementAndGet());
        data.put(member.getUser_number(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String user_id) {
        return data.values().stream().filter(member -> member.getUser_id().equals(user_id)).findAny();
    }

    @Override
    public Optional<Member> findByName(String user_name) {
        return data.values().stream().filter(member -> member.getUser_name().equals(user_name)).findAny();
    }

    @Override
    public Optional<Member> findByUserNumber(Long user_number) {
        return Optional.ofNullable(data.get(user_number));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(data.values());
    }
}
