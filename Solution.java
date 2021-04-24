package NoRepeats;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String firstname = "firstname" + i;
            String lastname = "lastname" + i;
            map.put(firstname, lastname);
        }

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();

        }
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> duplicate = new HashMap<>(map);

        Iterator<Map.Entry<String, String>> it = duplicate.entrySet().iterator();   // Получаем итератор для множества пар отображения

        while (it.hasNext()) {   // Цикл будет работать, пока не достигнут последний элемент множества
            Map.Entry<String, String> pair = it.next();   // Получаем очередную пару
            String name = pair.getValue();

            it.remove();   // Удаляем текущую пару из отображения

            if (duplicate.containsValue(name)) {
                removeItemFromMapByValue(map, name);
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
