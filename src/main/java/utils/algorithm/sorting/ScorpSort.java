package utils.algorithm.sorting;

import entity.dto.PostDto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class ScorpSort implements ISortAlgorithm {

    private List<PostDto> merge(List<List<PostDto>> input, int pointer, int index, List<PostDto> response, int lastAddedIndex) {
        PostDto incomingPost = input.get(pointer).get(index);
        List<PostDto> newResponse = new ArrayList<>();
        PostDto lastVal = null;
        if (index != 0) {
            newResponse.addAll(response.subList(0, lastAddedIndex + 1));
            response = response.subList(lastAddedIndex + 1, response.size());
        }
        for (int i = 0; i < response.size(); i++) {
            PostDto curr = response.get(i);
            long currCreatedAt = curr.getCreatedAt();
            long incomingPostCreatedAt = incomingPost.getCreatedAt();
            if (currCreatedAt == incomingPostCreatedAt) {
                if (curr.getId() < incomingPost.getId()) {
                    newResponse.add(curr);
                    lastVal = incomingPost;
                } else {
                    newResponse.add(incomingPost);
                    newResponse.addAll(response.subList(i, response.size()));
                    lastAddedIndex = i;
                    lastVal = null;
                    break;
                }
            } else if (currCreatedAt < incomingPostCreatedAt) {
                newResponse.add(curr);
                lastVal = incomingPost;
            } else {
                newResponse.add(incomingPost);
                newResponse.addAll(response.subList(i, response.size()));
                lastAddedIndex = i;
                lastVal = null;
                break;
            }
        }

        if (Objects.nonNull(lastVal))
            newResponse.add(lastVal);

        index++;
        if (index == input.get(pointer).size()) {
            pointer++;
            index = 0;
        }
        if (pointer == input.size()) {
            return newResponse;
        }
        return merge(input, pointer, index, newResponse, lastAddedIndex);
    }

    @Override
    public LinkedHashSet<PostDto> sort(List<List<PostDto>> input) {
        LinkedHashSet<PostDto> postsDesc = new LinkedHashSet<>();
        List<PostDto> postListAsc = merge(input, 1, 0, new ArrayList<>(input.get(0)), 0);
        for (int i = postListAsc.size() - 1; i >= 0; i--) {
            postsDesc.add(postListAsc.get(i));
        }
        return postsDesc;
    }
}
