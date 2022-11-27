// // import static org.junit.Assert.*;
// // import org.junit.*;
// // import java.util.*;

// import static org.junit.Assert.*;
// import org.junit.*;
// import java.util.ArrayList;
// import java.util.List;

// class CheckString implements StringChecker {
//     @Override
//     public boolean checkString(String s) {
//         if(s.charAt(0) == 'a') {
//             return true;
//         }
//         return false;
//     }
// }

// public class TestListExamples {
//   // @Test(timeout = 100)
//   // public void testTimeout() {
//   //   while(true) {}
//   // }
//   // Write your grading tests here!


//   @Test
//     public void testFilerMethod1(){
//         //StringChecker sChecker1 = new StringChecker2();
//         List<String> input1 = new ArrayList<>();
//         input1.add("plated");
//         input1.add("edward");
//         input1.add("hands");
//         input1.add("fasted");
//         input1.add("places");
//         List<String> output2 = new ArrayList<>();
//         output2.add("plated");
//         output2.add("edward");
//         output2.add("fasted");
//         StringChecker sChecker1 = new StringChecker2();
//         List<String> filteredList = ListExamples.filter(input1, sChecker1);
//         assertArrayEquals(output2,filteredList);
//     }

//     @Test
//     public void testMergeMethod1(){
//       List<String> listToMerge1 = new ArrayList<String>();
//       List<String> listToMerge2 = new ArrayList<String>();
//       listToMerge1.add("ape");
//       listToMerge1.add("zebra");
//       listToMerge1.add("crocodile");
//       listToMerge1.add("walrus");
//       listToMerge2.add("elephant");
//       listToMerge2.add("bird");
//       listToMerge2.add("spider");
//       List<String> mergedList = ListExamples.merge(listToMerge1, listToMerge1);
//       String[] expectedOutcome = {"ape","bird","crocodile","elephant","spider","walrus","zebra"};
//       assertArrayEquals(expectedOutcome, mergedList.toArray());
//   }
//     }




// //}


import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

class CheckString implements StringChecker {
    @Override
    public boolean checkString(String s) {
        if(s.charAt(0) == 'a') {
            return true;
        }
        return false;
    }
}

public class TestListExamples {
  @Test
    public void checkFilter() {
        CheckString c = new CheckString();
        List<String> list = new ArrayList<>();
        list.add("apple"); list.add("banana"); list.add("apricot");
        List<String> list2 = new ArrayList<>();
        list2.add("apple"); list2.add("apricot");
        assertEquals(ListExamples.filter(list,c), list2);
    }

    @Test
    public void checkMerge() {
        List<String> list1 = new ArrayList<>();
        list1.add("apple"); list1.add("banana"); list1.add("duplex");
        List<String> list2 = new ArrayList<>();
        list2.add("cucumber"); list2.add("ergonomics"); list2.add("france");
        List<String> list3 = new ArrayList<>();
        list3.add("apple"); list3.add("banana"); list3.add("cucumber"); list3.add("duplex");
        list3.add("ergonomics"); list3.add("france");
        assertEquals(ListExamples.merge(list1, list2), list3);
    }
}