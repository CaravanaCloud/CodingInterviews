package caravana;

import java.util.*;

public class IterKeeper{
    static Iterable<Integer> iterOf(Iterator<Integer> iter){
        return new Iterable<Integer>(){
            List<Integer> ms = new ArrayList<Integer>();
            
            public Iterator<Integer> iterator(){
                return new KeepIterator(iter);
            }
            
            class KeepIterator implements Iterator<Integer>{
                Iterator<Integer> it = null;
                int pos = 0;
                
                public KeepIterator(Iterator<Integer> iter){
                    this.it = iter;
                }
                
                @Override
                public synchronized Integer next(){
                    Integer result = null;
                    if (pos < ms.size()){
                        result = (Integer) ms.get(pos);
                    }else {
                        result = this.it.next();
                        ms.add((Integer) result);
                    }
                    pos++;
                    return result;
                }
                
                @Override
                public boolean hasNext(){
                    Boolean result = null;
                    if (pos < ms.size()){
                        result = true;
                    }else {
                        result = this.it.hasNext();
                    }
                    return result;                    
                }
            }    
        };
    }
}