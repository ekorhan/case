package utils.algorithm.sorting;

import entity.dto.PostDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class MergeSort implements ISortAlgorithm {
    private void merge(PostDto[] Arr, int start, int mid, int end) {
        PostDto[] temp = new PostDto[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            long iCreatedAt = Arr[i].getCreatedAt();
            long jCreatedAt = Arr[j].getCreatedAt();
            long iId = Arr[i].getId();
            long jId = Arr[j].getId();
            if (iCreatedAt == jCreatedAt) {
                if (iId >= jId) {
                    temp[k] = Arr[i];
                    k += 1;
                    i += 1;
                } else {
                    temp[k] = Arr[j];
                    k += 1;
                    j += 1;
                }
            } else {
                if (iCreatedAt > jCreatedAt) {
                    temp[k] = Arr[i];
                    k += 1;
                    i += 1;
                } else {
                    temp[k] = Arr[j];
                    k += 1;
                    j += 1;
                }
            }
        }

        while (i <= mid) {
            temp[k] = Arr[i];
            k += 1;
            i += 1;
        }

        while (j <= end) {
            temp[k] = Arr[j];
            k += 1;
            j += 1;
        }

        for (i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

    private LinkedHashSet<PostDto> mergeSort(PostDto[] Arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid + 1, end);
            merge(Arr, start, mid, end);
        }

        return new LinkedHashSet<>(Arrays.asList(Arr));
    }

    public LinkedHashSet<PostDto> sort(List<List<PostDto>> arr) {
        PostDto[] Arr = new PostDto[arr.size()];
        List<PostDto> newList = new ArrayList<>();
        for (List<PostDto> a : arr) {
            newList.addAll(a);
        }
        Arr = newList.toArray(Arr);

        return mergeSort(Arr, 0, Arr.length - 1);
    }
}
