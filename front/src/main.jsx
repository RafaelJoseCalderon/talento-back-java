import { createRoot } from "react-dom/client";
import { StrictMode } from "react";

import { createBrowserRouter } from "react-router";
import { RouterProvider } from "react-router/dom";
import { routes } from "./routes";

import AuthProvider from "./context/auth_provider";
import CartProvider from "./context/cart_provider";
import Overlay from "./components/overlay";

import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.min.css";

import "./assets/main.css";
import "./assets/pages.css";
import "./assets/components.css";

const router = createBrowserRouter(routes);

/**
 * Recomendación:
 * - CartProvider debe estar siempre **dentro de AuthProvider**,
 *   ya que depende del estado del usuario para inicializar el carrito correctamente.
 *
 * Ejemplo de uso en la app:
 * 
 * <AuthProvider>
 *   <CartProvider>
 *     <App />
 *   </CartProvider>
 * </AuthProvider>
 */
createRoot(document.getElementById("root")).render(
  <StrictMode>
    <AuthProvider>
      <CartProvider>
        <RouterProvider
          router={router}
          fallbackElement={<Overlay message="cargando App ..." />}
        />
      </CartProvider>
    </AuthProvider>
  </StrictMode >,
)
