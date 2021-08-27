package com.leetcode.amazon.medium;

public class MaximumAverageSubtree_1120 {
 class TreeNode {
          int val;
        TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {

        class FindMaxAverage {
            int totalSum;
            int nodeCount;
            double maximumAverage;

            public FindMaxAverage() {

            }

            public FindMaxAverage(int totalSum, int nodeCount, double maximumAverage) {
                this.totalSum = totalSum;
                this.nodeCount = nodeCount;
                this.maximumAverage = maximumAverage;
            }


            public FindMaxAverage getMaxAverageSubtree(TreeNode root) {
                if (root == null) {
                    return new FindMaxAverage(0, 0, 0);
                }

                FindMaxAverage left = getMaxAverageSubtree(root.left);
                FindMaxAverage right = getMaxAverageSubtree(root.right);

                int totalSum = root.val + left.totalSum + right.totalSum;
                int nodeCount = 1 + left.nodeCount + right.nodeCount;
                double maximumAverage = 1.0 * (totalSum) / nodeCount;

                maximumAverage = Math.max(maximumAverage, Math.max(left.maximumAverage, right.maximumAverage));

                return new FindMaxAverage(totalSum, nodeCount, maximumAverage);

            }

        }


        public double maximumAverageSubtree(TreeNode root) {
            FindMaxAverage findMax = new FindMaxAverage();
            return findMax.getMaxAverageSubtree(root).maximumAverage;
        }
    }
    }


    /*
    Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.

A subtree of a tree is any node of that tree plus all its descendants.

The average value of a tree is the sum of its values, divided by the number of nodes.



Example 1:


Input: root = [5,6,1]
Output: 6.00000
Explanation:
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
Example 2:

Input: root = [0,null,1]
Output: 1.00000


Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 105
     */