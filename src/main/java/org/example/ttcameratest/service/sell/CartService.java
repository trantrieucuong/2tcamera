package org.example.ttcameratest.service.sell;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.sell.Cart;
import org.example.ttcameratest.repos.sell.CartRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepos cartRepos;
    public List<Cart> getCartList() {
        return cartRepos.findAll();
    }
    public Cart getCartById(int id) {
        return cartRepos.findById(id).orElse(null);
    }
    public Cart addCart(Cart cart) {
        return cartRepos.save(cart);
    }
    public void removeCart(int id) {
        cartRepos.deleteById(id);

    }
    public Cart updateCart(Cart cart) {
        return cartRepos.save(cart);
    }
}
