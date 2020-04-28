package com.classloader;

/**
 * @author XZQ
 * @date 2020/4/23 18:16
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("C");

//        Object[] strings = arrayList.toArray();
//        for (Object string : strings) {
//            System.out.println(string);
//        }

//        ArrayList<String> arrayList1 = new ArrayList<>(arrayList);

//        int oldCapacity = 10;
//
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        System.out.println(newCapacity);


//        arrayList.forEach(x -> System.out.println(x));


//        Object[] strings = arrayList.toArray();
//        for (Object string : strings) {
//            System.out.println(string);
//        }

//        ArrayList<String> arrayList1 = new ArrayList<>(arrayList);

//        int oldCapacity = 10;

//        String[] elementData = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",};
//        int index = 4;
//        int size = elementData.length;
//        int numMoved = size - index - 1;
//
//        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
//
//        elementData[--size] = null; // clear to let GC do its work
//
//        Arrays.stream(elementData).forEach(x -> System.out.println(x));

        foo();
    }

    public static void foo(){
        try {
            throw new RuntimeException("!!!!!!!!!!!!!!!!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            throw new RuntimeException("222222222222222222");
        }
    }
}
