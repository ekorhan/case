package service;

import entity.dto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;

class PostServiceImplTest {
    List<List<PostDto>> input = new ArrayList<>();
    PostServiceImpl postServiceImpl;

    @BeforeEach
    void setUp() {
        postServiceImpl = new PostServiceImpl(null, null, null, null);
        PostDto p = new PostDto();
        p.setId(1);
        p.setCreatedAt(1);

        PostDto p2 = new PostDto();
        p2.setId(2);
        p2.setCreatedAt(4);

        PostDto p3 = new PostDto();
        p3.setId(3);
        p3.setCreatedAt(1);

        PostDto p4 = new PostDto();
        p4.setId(4);
        p4.setCreatedAt(25);

        PostDto p5 = new PostDto();
        p5.setId(5);
        p5.setCreatedAt(16);

        input.add(Collections.singletonList(p));
        input.add(Arrays.asList(p, p2, p5));
        input.add(Arrays.asList(p3, p4, p5));
    }

    @Test
    void mergePosts() {
        LinkedHashSet<PostDto> real = postServiceImpl.mergePosts(input);
        Queue<Integer> actual = new LinkedList<>(Arrays.asList(4, 5, 2, 3, 1));
        Assert.isTrue(real.size() == actual.size(), "Missing Post!");
        for (PostDto p : real) {
            Assert.isTrue(p.getId() == actual.remove(), "Sorting is not correct");
        }
    }
}