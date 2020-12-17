import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestList {
    List<List<Double>> list = getList(18000000);


    @Test
    public void checkGetMethodArrayListAndLinkedList()  {
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;


        timesList = leadTimeGetMethod(list, list.get(0).size() / 2, "get");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList get middle = " + timeArrayList);
        System.out.println("TimeLinkedList get middle = " + timeLinkedList);
        assertTrue(timeArrayList < timeLinkedList);

        timesList = leadTimeGetMethod(list, 0, "get");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList get first = " + timeArrayList);
        System.out.println("TimeLinkedList get first = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

        timesList = leadTimeGetMethod(list, list.get(0).size() - 1, "get");

        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList get last = " + timeArrayList);
        System.out.println("TimeLinkedList get last = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

    }




    @Test
    public void checkAddMethodArrayListAndLinkedList() {
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;

        timesList = leadTimeGetMethod(list, list.get(0).size() / 2, "add");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList add middle = " + timeArrayList);
        System.out.println("TimeLinkedList add middle = " + timeLinkedList);
        assertTrue(timeArrayList < timeLinkedList);

        timesList = leadTimeGetMethod(list, 0, "add");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList add first = " + timeArrayList);
        System.out.println("TimeLinkedList add first = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

        timesList = leadTimeGetMethod(list, list.get(0).size() - 1, "add");

        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList add last = " + timeArrayList);
        System.out.println("TimeLinkedList add last = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

    }



    @Test
    public void checkRemoveMethodArrayListAndLinkedList() {
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;

        timesList = leadTimeGetMethod(list, list.get(0).size() / 2, "remove");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList remove middle = " + timeArrayList);
        System.out.println("TimeLinkedList remove middle = " + timeLinkedList);
        assertTrue(timeArrayList < timeLinkedList);

        timesList = leadTimeGetMethod(list, 0, "remove");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList remove first = " + timeArrayList);
        System.out.println("TimeLinkedList remove first = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

        timesList = leadTimeGetMethod(list, list.get(0).size() - 1, "remove");

        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList remove last = " + timeArrayList);
        System.out.println("TimeLinkedList remove last = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

    }



    public List<List<Double>> getList(int range) {
        List<List<Double>> list = new ArrayList<List<Double>>();
        list.add(new ArrayList<Double>());
        list.add(new LinkedList<Double>());
        for (List<Double> doubles : list) {
            for (int index = 0; index < range; index++) {
                doubles.add(Math.random() * range);
            }
        }

        return list;
    }

    public Stack<Long> leadTimeGetMethod(List<List<Double>> list, int index, String method){
        long startTime;
        long finishTime;

        Stack<Long> timesLists = new Stack<Long>();
        for (List<Double> doubles : list) {
            startTime = System.currentTimeMillis();

            if(method.contains("get")) doubles.get(index);
            if(method.contains("add")) doubles.add(index, 5000.);
            if(method.contains("remove")) doubles.remove(index);

            finishTime = System.currentTimeMillis();
            timesLists.add(finishTime - startTime);
        }

        return timesLists;
    }


}