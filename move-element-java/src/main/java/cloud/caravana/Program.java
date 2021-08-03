package cloud.caravana;

import java.util.*;

public class Program {
  // CPU O(N) MEM O(1)
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    var size = array.size();
    var removed = 0;
    for (var i=0; i + removed < size; ){
      var x = array.get(i);
      boolean moveEl = x.equals(toMove);
      if (moveEl){
        array.remove(i);
        array.add(x);
        removed++;
      }else {
        i++;
      }
      //System.out.println(i +" " + x + " " + moveEl + " " + array.toString());
    }
    return array;
  }

  public static void main(String[] args) {
    var array = new ArrayList<>(Arrays.asList(new Integer[]{2, 1, 2, 2, 2, 3, 4, 2}));
    var toMove = 2;
    var result = moveElementToEnd(array, toMove);
    System.out.println(result);
  }
}
