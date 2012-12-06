/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewStreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author zhaosanqiang916
 */
public class FindStrings {

    static String[] searchs_array;
    static HashSet<String> S = new HashSet<>();
    final static String error = "INVALID";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_strings = Integer.parseInt(br.readLine()), i;
        for (i = 0; i < num_strings; i++) {
            addSubStrings(br.readLine());
        }
//        for (Iterator<String> it = S.iterator(); it.hasNext();) {
//            String string = it.next();
//            System.out.println(string);
//        }
        searchs_array = S.toArray(new String[S.size()]);
        int num_queries = Integer.parseInt(br.readLine());
        for (i = 0; i < num_queries; i++) {
            query(Integer.parseInt(br.readLine()) - 1);
        }

    }

    private static void query(int i) {
        if (i >= searchs_array.length || i < 0) {
            System.out.println(error);
        } else {
            System.out.println(searchs_array[i]);
        }
    }

    private static void addSubStrings(String str) {
        int i, j, length = str.length();
        for (i = 0; i < length; i++) {
            for (j = i; j < length; j++) {
                S.add(str.substring(i, j + 1));
            }
        }
    }

    public class SuffixTree {
        private SuffixTreeNode root = null;
        public  SuffixTree()
        {
            
        }
    }

    public class SuffixTreeNode {

        public char c;

        public SuffixTreeNode(char c) {
            this.c = c;
        }
    }
}
