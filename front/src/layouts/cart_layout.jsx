import { Navigate, Outlet } from "react-router";
import { useAuth } from "../hooks/use_auth";

const CartLayOut = () => {
  const { isAuth, isUser } = useAuth();

  if (!isAuth) {
    return (<Navigate to="/login" />);
  }

  if (isAuth && !isUser) {
    return (<Navigate to="/unauthorized" />);
  }

  return (<Outlet />);
};

export default CartLayOut;