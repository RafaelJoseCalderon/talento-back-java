import { url_base } from "./config";
import { handleFetch, getCurrentUserId } from "./tools";

import { notification } from "../utils/notification";
import { buy } from "./orders";

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

const getCartState = async (id) => {
  return await handleFetch({
    url: `${url_base}/api/cart/state/${id}`,
    options: { method: "GET" }
  });
};

const getCart = async () => {
  const id = getCurrentUserId();

  if (!id) return;

  return await handleFetch({
    url: `${url_base}/api/cart/items/${id}`,
    options: { method: "GET" }
  });
};

const actionsCart = async ({ request }) => {
  const id = getCurrentUserId();
  const data = await request.json();

  if (!id) return;

  try {
    if (data?.action === "add") {
      const { productId, quantity } = data;

      return await handleFetch({
        url: `${url_base}/api/cart/add/${id}`,
        options: {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ productId, quantity })
        },
        successMessage: "Producto agregado"
      });
    }

    if (data?.action === "buy") {
      return await buy();
    }

    if (data?.action === "delete") {
      const productId = data.id;

      return handleFetch({
        url: `${url_base}/api/cart/delete/${id}/${productId}`,
        options: { method: "DELETE" },
      });
    }
  } catch (error) {
    notification.danger(`Error al parsear el JSON de auth-user:", ${error}`);
    return;
  }

  throw new Response("Método no soportado", { status: 405 })
};

export {
  getCartState,
  getCart,
  actionsCart
};