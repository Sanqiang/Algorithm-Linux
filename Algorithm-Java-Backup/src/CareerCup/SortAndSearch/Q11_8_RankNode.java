/**
 * Sanqiang Zhao Www.131X.Com Jan 6, 2013
 */
package CareerCup.SortAndSearch;

import javax.xml.crypto.Data;

public class Q11_8_RankNode {

    public class RankNode {

        public int data = 0;
        public int order = 0;
        public RankNode left = null;
        public RankNode right = null;

        public RankNode(int _data, int _order) {
            this.data = _data;
            this.order = _order;
        }

        public void insert(int _data) {
            if (_data < this.data) {
                if (left == null) {
                    left = new RankNode(_data, 0);
                } else {
                    left.insert(_data);
                }
                ++this.order;
            } else if (_data > this.data) {
                if (right == null) {
                    right = new RankNode(_data, 0);
                } else {
                    right.insert(_data);
                }
            }
        }

        public int getOrder(int _data) {
            if (_data == this.data) {
                return this.order;
            }
            if (_data < this.data) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getOrder(_data);
                }
            } else if (_data > this.data) {
                if (right == null) {
                    return -1;
                } else {
                    return 1 + this.order + right.getOrder(_data);
                }
            }
            return -1;
        }

        public int getOrder() {
            int order = this.order;
            RankNode node = this;
            while (node.right != null) {
                order += right.order;
                node = node.right;
            }
            return order;
        }
    }

    public static void main(String[] args) {
    }
}
