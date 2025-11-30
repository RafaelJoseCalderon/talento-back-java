import { CartContext } from "./cart_context";
import { useState } from "react";

const CartProvider = ({ children }) => {
  const [cartState, setCartState] = useState(0);

  return (
    <CartContext.Provider value={{ cartState, setCartState }}>
      {children}
    </CartContext.Provider>
  );
};

export default CartProvider;