package repository;

import entity.Post;
import entity.dto.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select new entity.dto.PostDetail(p, u, l.id, f.followerId) from Post p " +
            "inner join User u on p.id = u.id " +
            "left join Likes l on p.id = l.postId and :userId = l.userId " +
            "left join Follow f on f.followerId = :userId and f.followingId = u.id " +
            "where p.id in (:ids)")
    List<PostDetail> findPostDetailByPostIds(@Param("ids") List<Long> ids, @Param("userId") int userId);
}
