package Collections.SortedCollections;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {

        this.list = new LinkedHashMap<>();
    }

    public int addStock(@NotNull StockItem item) {

        // checkear si tenemos cantidades del item a agregar

        StockItem inStock = list.getOrDefault(item.getName(), item);

        // checkear si hay stocks de este item, ajustar la cantidad

        if (inStock != item) {

            item.adjustStock(inStock.getQuantityStock());
        }

        list.put(item.getName(), item);
        return item.getQuantityStock();
    }

    public int sellStock(String item, int qty) {

        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (inStock.getQuantityStock() >= qty) && (qty > 0)) {

            inStock.adjustStock(-qty);
            return qty;
        }

        return  0;
    }

    public StockItem get(String key) {

        return list.get(key);
    }

    public Map<String, StockItem> Items() {

        return Collections.unmodifiableMap(list);
    }
}
