package org.hmily.datastructure.list;

public class ListTestDemo {


    public static void main(String[] args) {
        // 测试 ArrayList
        testArrayList();
    }

    private static void testArrayList() {
        ArrayList arrayList = new ArrayList();
        for (int i=0;i<52;i++){
            arrayList.add(i);
        }
        System.out.println("ArrayList Size 为：" + arrayList.size());



    }


}
