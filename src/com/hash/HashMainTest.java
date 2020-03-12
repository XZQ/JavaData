package com.hash;

/**
 * @author XZQ
 * @date 2020/3/12 15:15
 * https://blog.csdn.net/SnailMann/article/details/80435311
 * <p>
 * https://www.cnblogs.com/xiaoxiongcanguan/p/10190861.html
 * <p>
 * https://www.cnblogs.com/ysocean/p/8032656.html
 * <p>
 * https://juejin.im/post/5c9456f25188252d971438a9
 */
public class HashMainTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map2.put(i, "aaa" + i);
        }

//        System.out.println(map2.toString());
//        System.out.println(map2.containsKey(1));
//        System.out.println(map2.containsKey(11));
//        System.out.println(map2.containsValue("bbb"));
//        System.out.println(map2.containsValue("aaa"));
//        System.out.println(map2.size());
//        System.out.println(map2.get(1));
//        System.out.println(map2.get(2));
//        System.out.println(map2.get(3));
//        System.out.println(map2.remove(1));
//        System.out.println(map2.remove(2));
        System.out.println(map2.size());
    }
}
