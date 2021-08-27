package com.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SearchSuggestionsSystem_1268 {

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {

            TreeSet<String> set = new TreeSet<>();
            List<List<String>> result = new ArrayList<>();

            for(int i = 1;i<=searchWord.length();i++){

                for(String product:products){
                    if(product.startsWith(searchWord.substring(0,i))){
                        set.add(product);
                    }
                    if(set.size() > 3) {
                        set.pollLast();
                    }
                }
                result.add(new ArrayList(set));
                set.clear();

            }

            return result;


        }


    /*class Node {
        char c;
        Node[] child;
        boolean isWord;

        Node(char c) {
            this.c = c;
            this.child = new Node[26];
            isWord = false;
        }

    }

    class Trie {
        Node root;
        Trie () {
            root = new Node('0');
        }
        public void add(String word) {



        }

        public List<String> searchWord(String word) {

        }

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie trie = new Trie();
        for(String product:products) {
            trie.add(product);
        }

        List<List<String>> result = new ArrayList<>();

        for(int i=1;i<=searchWord.length();i++){
            List<String> search = searchWord(searchWord.substring(0,i));
            result.add(search);
        }

        return result;
    } */
    }
