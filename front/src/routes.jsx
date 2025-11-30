import App from "./App";

// public pages
import Products from "./pages/products";
import Product from "./pages/product";
import About from "./pages/about";
import Contact from "./pages/contact";
import Login from "./pages/login";
import Logout from "./pages/logout";
import NotFound from "./pages/not_found";
import ErrorPage from "./pages/error_page";

// private pages
import ShopingCart from "./pages/shopping_cart";
import History from "./pages/history";
import OrderDetail from "./pages/order_detail";
import ProductsAdmin from "./pages/products_admin";
import ProductAdmin from "./pages/product_admin";

// layouts
import CartLayOut from "./layouts/cart_layout";
import AdminLayOut from "./layouts/admin_layout";

// HydrateFallback ???
import Overlay from "./components/overlay";

// services
import { login } from "./services/users";
import { getHistory, getOrder } from "./services/orders";
import * as product from "./services/product";
import * as shoping from "./services/shoping_cart";

export const routes = [{
  path: "/",
  element: <App />,
  errorElement: <ErrorPage />,
  HydrateFallback: () => <Overlay message="cargando App ..." />,
  children: [
    {
      index: true,
      element: <Products title="Productos" />,
      loader: product.getBy,
      action: shoping.actionsCart,
    }, {
      path: "product/:id",
      element: <Product />,
      loader: product.getById,
      action: shoping.actionsCart,
    }, {
      path: "about",
      element: <About />,
    }, {
      path: "contact",
      element: <Contact />,
    }, {
      path: "login",
      element: <Login />,
      errorElement: <ErrorPage />,
      action: login,
    }, {
      path: "logout",
      element: <Logout />,
      errorElement: <ErrorPage />,
    }, {
      path: "*",
      element: <NotFound />,
    }, {
      path: "cart",
      element: <CartLayOut />,
      children: [{
        index: true,
        element: <ShopingCart />,
        errorElement: <ErrorPage />,
        loader: shoping.getCart,
        action: shoping.actionsCart,
      }, {
        path: "history",
        element: <History />,
        loader: getHistory,
      }, {
        path: "details/:id",
        element: <OrderDetail />,
        loader: getOrder,
      }],
    }, {
      path: "admin",
      element: <AdminLayOut />,
      children: [{
        index: true,
        element: <ProductsAdmin />,
        errorElement: <ErrorPage />,
        loader: product.getBy,
        action: product.remove,
      }, {
        path: "create",
        element: <ProductAdmin mode="create" title="Crear" />,
        errorElement: <ErrorPage />,
        loader: product.getForTheForm,
        action: product.create,
      }, {
        path: "details/:id",
        element: <ProductAdmin mode="view" title="Detalle" />,
        loader: product.getForTheForm,
      }, {
        path: "edit/:id",
        element: <ProductAdmin mode="update" title="Editar" />,
        errorElement: <ErrorPage />,
        loader: product.getForTheForm,
        action: product.update,
      }]
    }
  ]
}];