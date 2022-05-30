package repository;

import entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    @Query("select l.postId from Likes l where l.userId = :userId")
    List<Long> findPostsByUserId(@Param("userId") Long userId);
}
