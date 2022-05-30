package utils.algorithm.sorting;

import entity.dto.PostDto;

import java.util.LinkedHashSet;
import java.util.List;

public interface ISortAlgorithm {
    LinkedHashSet<PostDto> sort(List<List<PostDto>> input);
}
