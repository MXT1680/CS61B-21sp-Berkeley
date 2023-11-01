package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  public static void main(String[] args) {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> K = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 3);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              K.addLast(randVal);

              //System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              if(L.size()==0){
                  continue;
              }
              int RemoveLastL = L.removeLast();
              int RemoveLastK = K.removeLast();
              Assert.assertEquals(RemoveLastK,RemoveLastL);
              //System.out.println("RemoveLast: " + RemoveLastL);
          }else if(operationNumber ==2){
              if(L.size()==0){
                  continue;
              }
              int LastL =L.getLast();
              int LastK =K.getLast();
              Assert.assertEquals(LastK,LastL);
              //System.out.println("GetLast: " + LastL);

          }

      }
  }


}
