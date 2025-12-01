import { useEffect, useRef } from "react";
import { useAuth } from "./use_auth";
import { useCart } from "./use_cart";
import { useNotification } from "./use_notification";

export function useAddToCart() {
  const { isUser } = useAuth();
  const { items, exist, addItem } = useCart();
  const { info, success } = useNotification();
  const title = useRef(null);

  const handleAddToCart = (product, quantity) => {
    if (!isUser) {
      info("Debes estar registrado para agregar productos al carrito");
      return;
    }

    if (exist(product.id)) {
      info("Este producto ya está en el carrito");
      return;
    }

    title.current = product.title;
    addItem(product, quantity);
  };

  useEffect(() => {
    if (title.current !== null) {
      success(`${title.current} agregado al carrito`);
      title.current = null;
    }
  }, [items]);

  return { addItem: handleAddToCart };
}