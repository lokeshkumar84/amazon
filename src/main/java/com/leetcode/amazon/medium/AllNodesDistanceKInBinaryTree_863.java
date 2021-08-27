package com.leetcode.amazon.medium;

import java.util.*;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143752/JAVA-Graph-%2B-BFS
class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
}
public class AllNodesDistanceKInBinaryTree_863 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        Map<TreeNode, List<TreeNode>> parentMap = new HashMap<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> list = new ArrayList<>();
            if(root == null || target == null || k < 0){
                return list;
            }

            buildMap(root, null);

            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> set = new HashSet<>();
            queue.offer(target);
            set.add(target);

            while(!queue.isEmpty()){
                int size = queue.size();

                if(k == 0){
                    for(int i=0;i<size;i++){
                        list.add(queue.poll().val);
                    }
                    return list;
                }
                for(int i=0; i<size; i++){

                    TreeNode node = queue.poll();
                    for(TreeNode node1:parentMap.get(node)){
                        if(set.contains(node1)){
                            continue;
                        }
                        queue.offer(node1);
                        set.add(node1);
                    }


                }
                k--;
            }
            return list;
        }

        private void buildMap(TreeNode current, TreeNode parent){
            if(current != null){
                if(!parentMap.containsKey(current)){
                    parentMap.put(current,new ArrayList<TreeNode>());
                }
                if(parent != null){
                    parentMap.get(current).add(parent);
                    parentMap.get(parent).add(current);
                }
                buildMap(current.left, current);
                buildMap(current.right, current);
            }
        }
    }
