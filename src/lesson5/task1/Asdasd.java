package lesson5.task1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Asdasd {
    public static Map<String, Set<String>> handsShake(Map<String,Set<String>> friends){
        Map<String, Set<String>> newMap = new HashMap<>();
        for(Map.Entry<String,Set<String>> pair : friends.entrySet()){
            Set<String> result = new HashSet<>(pair.getValue());
            Set<String> toFind = new HashSet<>();
            Set<String> cheked = new HashSet<>();
            cheked.add(pair.getKey());
            toFind.addAll(pair.getValue());
            while(!toFind.isEmpty()){
                Set<String> newToFind = new HashSet<>();
                for(String p : toFind){
                    if(!cheked.contains(p)){
                        result.add(p);
                        cheked.add(p);
                        for(String q : friends.get(p)){
                            if(!cheked.contains(q))
                                newToFind.add(q);
                        }
                    }
                }
                toFind = newToFind;
            }
            newMap.put(pair.getKey(), result);
        }
        return newMap;
    }
}

