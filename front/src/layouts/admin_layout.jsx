import { Navigate, Outlet } from "react-router";
import { useAuth } from "../hooks/use_auth";

const AminLayOut = () => {
  const { isAuth, isAdmin } = useAuth();

  if (!isAuth) {
    return (<Navigate to="/login" />);
  }

  if (isAuth && !isAdmin) {
    return (<Navigate to="/unauthorized" />);
  }

  return (<Outlet />);
};

export default AminLayOut;