package org.talento.java.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.talento.java.dtos.cart.*;
import org.talento.java.responses.ResponseDelete;
import org.talento.java.services.CartService;

/*
* En circunstancias normales, no se debería pasar el ID del usuario por query parameters (o parámetros de consulta).
* La identidad del usuario se gestiona a través del token (o sesión). El ID se obtendrá desde el lugar que corresponda,
* ya sea:
*   1 - La base de datos de sesiones (en la autenticación tradicional).
*   2 - El propio token (como en el caso de JWT - JSON Web Token).
*
* En cualquiera de estos casos, la capa de seguridad se encarga de este proceso y lo inyecta directamente en el
* controlador, a menudo utilizando la anotación @AuthenticationPrincipal.
* */

@RestController @RequestMapping("api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "add/{userId}")
    public ResponseEntity<CartRes> addItem(
        @PathVariable Long userId,
        @RequestBody @Valid CartReq productCart
    ) {
        var response = this.cartService.addItem(userId, productCart);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "items/{userId}")
    public ResponseEntity<CartListRest> getItems(
        @PathVariable Long userId
    ) {
        var response = this.cartService.getItems(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "state/{userId}")
    public ResponseEntity<CartStateRes> getState(
        @PathVariable Long userId
    ) {
        var response = this.cartService.getState(userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "delete/{userId}")
    public ResponseEntity<ResponseDelete> deleteCart(
        @PathVariable Long userId,
        HttpServletRequest request
    ) {
        this.cartService.deleteCart(userId);
        return ResponseDelete.of(request, "Cart disposed correctly");
    }

    @DeleteMapping(value = "delete/{userId}/{id}")
    public ResponseEntity<CartDelRes> delete(
        @PathVariable Long userId,
        @PathVariable Long id,
        HttpServletRequest request
    ) {
        var response = this.cartService.delete(userId, id);
        return ResponseEntity.ok(response);
    }
}
