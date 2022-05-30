package repository;

import entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    @Query("select f.followingId from Follow f where f.followerId = :followerId")
    List<Long> findFollowingByFollowerId(@Param("followerId") Long followerId);
}
