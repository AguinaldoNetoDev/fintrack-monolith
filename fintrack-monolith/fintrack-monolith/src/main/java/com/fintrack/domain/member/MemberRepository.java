package com.fintrack.domain.member;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {

    Member save(Member member);
    void deleteById(UUID memberId);
    Optional<Member> findById(UUID uuid);
    List<Member> findAllByUserId(UUID userId);

}
