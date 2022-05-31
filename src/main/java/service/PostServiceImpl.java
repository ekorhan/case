package service;

import entity.Post;
import entity.User;
import entity.dto.PostDetail;
import entity.dto.PostDto;
import org.springframework.stereotype.Service;
import repository.FollowRepository;
import repository.LikesRepository;
import repository.PostRepository;
import repository.UserRepository;
import utils.algorithm.sorting.ISortAlgorithm;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final LikesRepository likesRepository;
    private ISortAlgorithm sortAlgorithm;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository,
                           FollowRepository followRepository, LikesRepository likesRepository,
                           ISortAlgorithm sortAlgorithm) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.likesRepository = likesRepository;
        this.sortAlgorithm = sortAlgorithm;
    }

    public void setSortAlgorithm(ISortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public List<PostDetail> getPosts(long userId, List<Long> postIds) {
        List<PostDetail> postDetails = new ArrayList<>();

        List<Post> posts = postRepository.findAllById(postIds);

        List<Long> userIds = posts.stream().map(Post::getUserId).collect(Collectors.toList());
        List<User> users = userRepository.findAllById(userIds);

        Map<Long, User> userMap = new HashMap<>();
        for (User u : users) {
            userMap.put(u.getId(), u);
        }

        List<Long> follows = followRepository.findFollowingByFollowerId(userId);
        List<Long> likes = likesRepository.findPostsByUserId(userId);
        for (Post p : posts) {
            postDetails.add(new PostDetail(p, userMap.get(p.getUserId()), likes.contains(p.getUserId()), follows.contains(p.getUserId())));
        }

        return postDetails;
    }

    public LinkedHashSet<PostDto> mergePosts(List<List<PostDto>> posts) {
        return sortAlgorithm.sort(posts);
    }
}
