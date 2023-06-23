package taest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    /**
     *
     * @param array
     * @param bucketCap  每个桶的容量
     * @return
     */
    public static List<Integer> sort(List<Integer>  array, int bucketCap){

        if (array == null || array.size() < 2){
            return array;
        }
        int max = array.get(0),min = array.get(0);
        for (Integer integer : array) {
            if (integer < min){
                min = integer;
            }
            if (integer > max){
                max = integer;
            }
        }
        int bucketCount = (max - min) / bucketCap +1;

        List<List<Integer>> bucketArr = new ArrayList<>(bucketCount);
        List<Integer> resultArr = new ArrayList<>();

        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<>());
        }

        for (Integer integer : array) {
            bucketArr.get((integer - min)/bucketCap).add(integer);
        }

        for (int i = 0; i < bucketCount; i++) {
            if (bucketCap == 1){
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }else {
                if (bucketCount == 1)
                    bucketCap --;
                List<Integer> tmp = sort(bucketArr.get(i), bucketCap);
                for (Integer integer : tmp) {
                    resultArr.add(integer);
                }
            }

        }
        return resultArr;
    }
}
