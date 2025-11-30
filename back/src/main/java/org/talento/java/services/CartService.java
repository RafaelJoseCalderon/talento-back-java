package org.talento.java.services;

import org.springframework.stereotype.Service;
import org.talento.java.dtos.cart.*;
import org.talento.java.mappers.CartMapper;
import org.talento.java.mappers.ProductMapper;
import org.talento.java.models.*;
import org.talento.java.repositories.CartRepo;
import org.talento.java.repositories.ProductRepo;

import java.util.List;

/*
 * Manejo de excepciones y autenticación
 * Dado que este proyecto tiene fines académicos y no cuenta con un sistema de autenticación implementado, se decidió
 * prescindir de la gestión de excepciones relacionadas con la seguridad o permisos de acceso. En consecuencia,
 * únicamente se han dejado implementados los casos de uso correspondientes al camino feliz, es decir, aquellos
 * escenarios donde todas las operaciones se realizan correctamente sin errores ni restricciones de acceso.
 * */

@Service
public class CartService {
    private final ProductRepo products;
    private final CartRepo carts;

    private final ProductMapper productMapper;
    private final CartMapper cartMapper;

    public CartService(
        ProductRepo products,
        CartRepo carts,
        ProductMapper productMapper,
        CartMapper cartMapper
    ) {
        this.products = products;
        this.carts = carts;
        this.productMapper = productMapper;
        this.cartMapper = cartMapper;
    }

    public CartRes addItem(Long userId, CartReq itemDto) {
        Cart cart = this.carts.computeIfAbsent(userId, id -> new Cart());
        CartItem item = cart.addItem(this.cartMapper.toEntity(itemDto));

        return this.cartMapper.toDto(item, cart.size());
    }

    public CartListRest getItems(Long userId) {
        Cart cart = this.carts.get(userId);

        if (cart != null) {
            List<Long> ids = cart.productsIds();
            List<Product> products = this.products.findAllById(ids);

            List<CartProductRes> items = products.stream().map(product -> {
                var productRes = this.productMapper.toDto(product);
                var quantity = cart.getQuantityBy(product.getId());

                return new CartProductRes(productRes, quantity);
            }).toList();

            return this.cartMapper.toDtoList(items, cart.size());
        }

        return this.cartMapper.toDtoList(List.of(), 0);
    }

    public CartStateRes getState(Long userId) {
        Cart cart = this.carts.get(userId);

        if (cart != null) {
            return new CartStateRes(cart.size());
        }

        return new CartStateRes(0);
    }

    public void deleteCart(Long userId) {
        this.carts.remove(userId);
    }

    public CartDelRes delete(Long userId, Long id) {
        Cart cart = this.carts.get(userId);

        if (cart != null) {
            CartItem item = cart.delete(id);
            CartItemRes itemRes = this.cartMapper.toItemRes(item);
            return new CartDelRes(itemRes, new CartStateRes(cart.size()));
        }

        return new CartDelRes(null, new CartStateRes(0));
    }
}
