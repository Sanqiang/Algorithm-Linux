/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ScalabilityAndMemoryLimits.Q10_3_4_BitSet;

public class BitSet {

    long[] buffer;

    public BitSet(int _size) {
        if (_size >> 10 == 0) {
            this.buffer = new long[1];
        } else {
            this.buffer = new long[_size >> 10];
        }
    }

    public BitSet(int _size, boolean buffer_size) {
        if (buffer_size) {
            this.buffer = new long[_size];
        } else {
            if (_size >> 10 == 0) {
                this.buffer = new long[1];
            } else {
                this.buffer = new long[_size >> 10];
            }
        }
    }

    public void set(int n) {
        int word_num = n >> 10; //divid by 32
        int bit_num = n & 0x3FF; //mod 32
        buffer[word_num] |= 1 << bit_num;
    }

    public boolean get(int n) {
        int word_num = n >> 10;
        int bit_num = n & 0x3FF;
        return (buffer[word_num] & 1 << bit_num) != 0;
    }

    public static void main(String[] args) {
        BitSet bs = new BitSet(5);
        bs.set(3);
        System.out.println(bs.get(0));
    }
}
