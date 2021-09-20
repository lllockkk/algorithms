package searching.client;

import searching._01SymbolTable;

public class client {
    public static void main(String[] args) {
        frequencyCounter(args);
    }

    public static void client(String[] arr) {
        _01SymbolTable<String, Integer> st = getSymbolTable(); //todo
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            st.put(arr[i], i);
        }
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }

    public static void frequencyCounter(String[] arr) {
        int len = arr.length;
        _01SymbolTable<String, Integer> st = getSymbolTable();
        String max = "";
        int maxCount = 0;
        for (String s : arr) {
            if (st.contains(s)) {
                int count = st.get(s) + 1;
                if (count > maxCount) {
                    maxCount = count;
                    max = s;
                }
                st.put(s, count);
            } else {
                st.put(s, 1);
            }
        }

        System.out.println(max + " " + maxCount);
    }

    private static _01SymbolTable getSymbolTable() {
        // TODO: 2018/9/8
        return null;
    }
}
