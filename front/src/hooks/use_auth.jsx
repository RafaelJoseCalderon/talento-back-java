import { useContext } from "react";
import { useNavigate } from "react-router";
import { AuthContext } from "../context/auth_context";

export const useAuth = () => {
  const { user, setUser } = useContext(AuthContext);
  const navigate = useNavigate();

  const signIn = async (user) => {
    setUser(user);

    if (user?.role === "admin") {
      navigate("/admin", { replace: true });
      return;
    }

    if (user?.role === "user") {
      navigate("/", { replace: true });
      return;
    }
  };

  const signOut = async () => {
    setUser({});
    navigate("/", { replace: true });
  };

  const isAuth = user && Object.keys(user).length > 0;
  const isAdmin = isAuth && user?.role === "admin";
  const isUser = isAuth && user?.role === "user";

  return {
    user,

    signIn,
    signOut,

    isAuth,
    isAdmin,
    isUser,
  };
};