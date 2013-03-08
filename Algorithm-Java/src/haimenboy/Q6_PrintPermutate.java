/**
 * Sanqiang Zhao Www.131X.Com Jan 23, 2013
 */
package haimenboy;

public class Q6_PrintPermutate {

    void print(char[] list, int cur) {
        if (cur == list.length - 1) {
            System.out.println(new String(list));
            return;
        }
        print(list, cur + 1);
        for (int i = cur + 1; i < list.length; i++) {
            swap(list, i, cur);
            print(list, cur + 1);
            swap(list, cur, i);
        }
    }

    void swap(char[] list, int i, int j) {
        char temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        String text = "123";
        new Q6_PrintPermutate().print(text.toCharArray(), 0);
        //PrintPermutation(text.toCharArray(), 0);
    }

    //Sample
    public static void PrintPermutation(char[] inputs, int currentFocus) {
        //before start, check if currentFocus comes to the last char
        if (currentFocus == inputs.length - 1) {
            System.out.println(new String(inputs));
            return;
        }

        //now firstly keep the current char order in the array and proceed to next
        PrintPermutation(inputs, currentFocus + 1);

        //now need swap each next char with currentFocus
        for (int i = currentFocus + 1; i < inputs.length; i++) {
            //swap the char pair of position (currentFocus, i)
            //in order to remove the duplicates, the key is to check if the two char unequal before swapping!
            boolean ifAppear = false;
            for (int j = 0; j < i; j++) {
                if (inputs[j] == inputs[i]) {
                    ifAppear = true;
                    break;
                }
            }

            if (ifAppear) {
                continue;
            }
            Swap(inputs, currentFocus, i);
            PrintPermutation(inputs, currentFocus + 1);
            Swap(inputs, currentFocus, i);
        }
    }

    private static void Swap(char[] inputs, int a, int b) {
        char temp = inputs[a];
        inputs[a] = inputs[b];
        inputs[b] = temp;
    }
}
