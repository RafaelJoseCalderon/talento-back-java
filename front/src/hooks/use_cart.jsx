import { useContext } from "react";
import { CartContext } from "../context/cart_context";

export const useCart = () => {
  const { items, setItems } = useContext(CartContext);

  const addItem = (product, quantity) => {
    setItems((prev) => {
      if (prev.some((item) => item.id === product.id)) {
        return prev;
      } else {
        const cents = Math.round(product.price * 100);
        return [...prev, { ...product, price: cents, quantity }];
      }
    });
  };

  const delItem = (id) => {
    setItems((prev) => prev.filter((item) => item.id !== id));
  };

  const delAll = () => {
    setItems([]);
  };

  const exist = (id) => {
    return items.some(p => p.id === id);
  };

  return {
    items,
    addItem,
    delItem,
    delAll,
    exist
  };
};