import { useEffect } from "react";
import { useAuth } from "../hooks/use_auth";
import Overlay from "../components/overlay";

const LogOut = () => {
  const { signOut } = useAuth();
  useEffect(() => { signOut(); }, []);
  return (<Overlay message="Cerrando sesión ..." />);
};

export default LogOut;