import { useContext, useEffect } from "react";
import { CartContext } from "../context/cart_context";
import { useAuth } from "./use_auth";
import { getCartState } from "../services/shoping_cart";

export const useCart = () => {
  const { cartState, setCartState } = useContext(CartContext);
  const { user, isUser } = useAuth();

  const setCart = (data) => {
    const quantity = data?.cart?.quantity;
    if (quantity != null) setCartState(quantity);
  };

  useEffect(() => {
    let isMounted = true;

    const setState = (data) => {
      if (isMounted && data?.quantity) {
        setCartState(data?.quantity ?? 0);
      }
    }

    if (isUser && user?.id) {
      getCartState(user.id)
        .then((data) => { setState(data); })
        .catch(() => { setState(0); });
    } else {
      setCartState(0);
    }

    return () => { isMounted = false };
  }, [user]);

  return {
    setCart,
    size: cartState
  };
};
