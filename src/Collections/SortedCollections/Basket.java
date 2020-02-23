package Collections.SortedCollections;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(@NotNull StockItem item, int qty) {

        if (qty > 0) {

            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + qty);

            return inBasket;
        } else {

            return 0;
        }
    }

    public Map<StockItem, Integer> Items() {

        return Collections.unmodifiableMap(list);
    }

}
