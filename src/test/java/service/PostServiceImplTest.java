package service;

import entity.dto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import utils.algorithm.sorting.MergeSort;
import utils.algorithm.sorting.ScorpSort;

import java.util.*;

class PostServiceImplTest {
    List<List<PostDto>> input = new ArrayList<>();
    PostServiceImpl postServiceImpl;

    @BeforeEach
    void setUp() {
        postServiceImpl = new PostServiceImpl(null, null, null, null, new ScorpSort());
        PostDto p = new PostDto();
        p.setId(1);
        p.setCreatedAt(1);

        PostDto p2 = new PostDto();
        p2.setId(2);
        p2.setCreatedAt(4);

        PostDto p3 = new PostDto();
        p3.setId(3);
        p3.setCreatedAt(9);

        PostDto p4 = new PostDto();
        p4.setId(4);
        p4.setCreatedAt(16);

        PostDto p5 = new PostDto();
        p5.setId(5);
        p5.setCreatedAt(25);

        PostDto p6 = new PostDto();
        p6.setId(6);
        p6.setCreatedAt(64);

        PostDto p7 = new PostDto();
        p7.setId(7);
        p7.setCreatedAt(49);

        PostDto p8 = new PostDto();
        p8.setId(8);
        p8.setCreatedAt(64);

        PostDto p9 = new PostDto();
        p9.setId(9);
        p9.setCreatedAt(81);

        input.add(Arrays.asList(p4, p5, p9));
        input.add(Arrays.asList(p2, p7, p8));
        input.add(Arrays.asList(p, p3, p6));
    }

    @Test
    void mergePosts() {
        postServiceImpl.setSortAlgorithm(new MergeSort());
        LinkedHashSet<PostDto> real = postServiceImpl.mergePosts(input);
        Queue<Integer> actual = new LinkedList<>(Arrays.asList(4, 5, 2, 3, 1));
        Assert.isTrue(real.size() == actual.size(), "Missing Post!");
        for (PostDto p : real) {
            Assert.isTrue(p.getId() == actual.remove(), "Sorting is not correct");
        }
    }

    @Test
    void mergePostsWithNormal() {
        LinkedHashSet<PostDto> real = postServiceImpl.mergePosts(input);
        Queue<Integer> actual = new LinkedList<>(Arrays.asList(9, 8, 6, 7, 5, 4, 3, 2, 1));
        Assert.isTrue(real.size() == actual.size(), "Missing Post!");
        for (PostDto p : real) {
            Assert.isTrue(p.getId() == actual.remove(), "Sorting is not correct");
        }
    }
}