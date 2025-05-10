package controller;

import model.PaymentMethod;
import model.Product;
import service.CartService;

public class CartController {
    private CartService cartService = new CartService();

    public void run() {
        Product p1 = new Product(1, "Chinelo Havaianas", 49.90);
        Product p2 = new Product(2, "Chinelo Farm", 59.90);

        cartService.addProductToCart(p1, 2);
        cartService.addProductToCart(p2, 1);

        cartService.showCart();
        cartService.checkout(PaymentMethod.PIX);
    }
}
