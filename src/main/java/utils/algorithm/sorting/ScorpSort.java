package utils.algorithm.sorting;

import entity.dto.PostDto;

import java.util.*;

public class ScorpSort implements ISortAlgorithm {
    @Override
    public LinkedHashSet<PostDto> sort(List<List<PostDto>> input) {
        LinkedList<PostDto> response = new LinkedList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int counter = 0;
        //finding N(N is the sum of size of elements in input)
        for (int inputIndex = 0; inputIndex < input.size(); inputIndex++) {
            indexMap.put(inputIndex, 0);
            for (PostDto ignored : input.get(inputIndex)) {
                counter++;
            }
        }
        //--

        int willBeAddedPostIndex = 0;
        //This will loop N times.
        while (willBeAddedPostIndex < counter) {
            long minDate = Integer.MAX_VALUE;
            long minId = Integer.MAX_VALUE;
            PostDto willBeAddedPost = null;
            //Main list index
            int _inputIndex = 0;
            for (int inputIndex = 0; inputIndex < input.size(); inputIndex++) {
                List<PostDto> currentList = input.get(inputIndex);
                if (currentList.size() == indexMap.get(inputIndex)) {
                    continue;
                }

                PostDto currentPost = currentList.get(indexMap.get(inputIndex));
                long createdDate = currentPost.getCreatedAt();
                long currentId = currentPost.getId();
                if (createdDate == minDate) {
                    if (currentId < minId) {
                        minId = currentId;
                        _inputIndex = inputIndex;
                        willBeAddedPost = currentPost;
                    }
                } else if (createdDate < minDate) {
                    minDate = createdDate;
                    _inputIndex = inputIndex;
                    willBeAddedPost = currentPost;
                }
            }
            indexMap.put(_inputIndex, indexMap.get(_inputIndex) + 1);
            //Push method adds element to first of the list. So it sorts desc.
            response.push(willBeAddedPost);
            willBeAddedPostIndex++;
        }

        //The Set guarantees each element will be unique
        return new LinkedHashSet<>(response);
    }
}
