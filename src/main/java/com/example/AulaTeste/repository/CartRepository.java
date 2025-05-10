package repository;

import java.util.ArrayList;
import java.util.List;
import model.CartItem;

public class CartRepository {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(CartItem item) {
        cartItems.add(item);
    }

    public List<CartItem> getItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }

    public double getTotal() {
        return cartItems.stream().mapToDouble(CartItem::getTotal).sum();
    }
}
