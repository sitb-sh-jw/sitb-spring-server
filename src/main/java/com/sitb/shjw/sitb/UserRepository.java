package com.sitb.shjw.sitb;

import com.sitb.shjw.sitb.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByKakaoId(@Param("kakaoId") Long kakaoId);
}
