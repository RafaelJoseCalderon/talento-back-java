package org.talento.java.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.talento.java.dtos.orders.OrderItemReq;
import org.talento.java.dtos.orders.OrderListRes;
import org.talento.java.dtos.orders.OrderRes;
import org.talento.java.services.OrderService;

import java.util.List;

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

@RestController @RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "allBy/{userId}")
    public ResponseEntity<List<OrderListRes>> getOrders(
        @PathVariable Long userId
    ) {
        var response = this.orderService.getOrders(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "complete-sale/{userId}")
    public ResponseEntity<OrderRes> completeSale(
        @PathVariable Long userId,
        @RequestBody @Valid List<OrderItemReq> items
    ) {
        var response = this.orderService.completeSale(userId, items);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderRes> getById(
        @PathVariable Long id
    ) {
        return ResponseEntity.ok(this.orderService.getById(id));
    }
}
