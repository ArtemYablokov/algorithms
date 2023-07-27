package com.yablokovs.leetcode.array.dp;

import org.junit.jupiter.api.Test;

class PartitionEqualSubsetSum416Test {

    @Test
    void canPartition2() {
        PartitionEqualSubsetSum_416 partitionEqualSubsetSum416 = new PartitionEqualSubsetSum_416();
        partitionEqualSubsetSum416.canPartitionDp1dimMemo(new int[]{2,1,3,1,4,3});

    }
}