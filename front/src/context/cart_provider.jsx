import { CartContext } from "./cart_context";
import { usePersistentState } from "../hooks/use_persistent";

const CartProvider = ({ children }) => {
  const [items, setItems] = usePersistentState("cart-items", []);

  return (
    <CartContext.Provider value={{ items, setItems }}>
      {children}
    </CartContext.Provider>
  );
};

export default CartProvider;