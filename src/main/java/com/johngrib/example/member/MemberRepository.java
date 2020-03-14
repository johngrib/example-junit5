package com.johngrib.example.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

  /**
   * 방문 카운터를 증가시킨다.
   *
   * @return 업데이트된 레코드의 수
   */
  @Query("update Member m "
          + "set m.visited = m.visited + :plus "
          + "where m.id = :id ")
  @Modifying(clearAutomatically = true, flushAutomatically = true)
  int increaseCount(@Param("id") Long id, @Param("plus") int plus);
}
