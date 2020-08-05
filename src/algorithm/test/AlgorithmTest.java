package algorithm.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AlgorithmTest {
    @Test
    public void testcase1(){
        int a = solution1("apple","pear");
        assertThat(a, is(equalTo(3)));

        int b = solution1("rather","harder");
        assertThat(b, is(equalTo(2)));

        int c = solution1("lemon","melon");
        assertThat(c, is(equalTo(0)));
    }

    private int solution1(String a, String b) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i = 0; i < a.length(); i++){
            c1[a.charAt(i) - 'a']++;
        }

        for(int i = 0; i < b.length(); i++){
            c2[b.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(c1[i] - c2[i]);
        }

        return count;
    }
}
