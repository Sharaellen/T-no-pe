package service;

import model.CartItem;
import model.PaymentMethod;
import model.Product;
import repository.CartRepository;

public class CartService {
    private CartRepository repository = new CartRepository();

    public void addProductToCart(Product product, int quantity) {
        repository.addItem(new CartItem(product, quantity));
    }

    public void showCart() {
        for (CartItem item : repository.getItems()) {
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() +
                " = R$" + item.getTotal());
        }
        System.out.println("Total: R$" + repository.getTotal());
    }

    public void checkout(PaymentMethod method) {
        System.out.println("Finalizando com " + method);
        switch (method) {
            case PIX:
                System.out.println("Chave Pix: 123e4567-e89b-12d3-a456-426614174000");
                break;
            case DEBITO:
                System.out.println("Pagamento via cartão de débito aprovado.");
                break;
            case CREDITO:
                System.out.println("Pagamento via cartão de crédito aprovado.");
                break;
            case BOLETO:
                System.out.println("Gerando boleto bancário...");
                System.out.println("Linha digitável: 34191.79001 01043.510047 91020.150008 7 12345678901234");
                break;
        }
        repository.clearCart();
    }
}
