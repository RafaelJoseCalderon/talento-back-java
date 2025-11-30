import { useState } from "react";
import { AuthContext } from "./auth_context";
import { usePersistentState } from "../hooks/use_persistent";

const AuthProvider = ({ children }) => {
  const [user, setUser] = usePersistentState("auth-user", {});
  const [isLoggingIn, setIsLoggingIn] = useState(false);

  return (
    <AuthContext.Provider value={{ user, setUser, isLoggingIn, setIsLoggingIn }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthProvider;