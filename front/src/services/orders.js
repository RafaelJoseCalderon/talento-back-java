import { url_base } from "./config";
import { handleFetch, getCurrentUserId } from "./tools";

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

const buy = async () => {
  const id = getCurrentUserId();
  if (!id) return;

  return await handleFetch({
    url: `${url_base}/api/orders/complete-sale/${id}`,
    options: {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
    },
    booleanResponse: false,
  });
}

const getHistory = async () => {
  const id = getCurrentUserId();
  if (!id) return;

  return await handleFetch({
    url: `${url_base}/api/orders/allBy/${id}`,
    options: { method: "GET" }
  });
}

const getOrder = async ({ params }) => {
  const id = getCurrentUserId();
  if (!id) return;

  return await handleFetch({
    url: `${url_base}/api/orders/${params.id}`,
    options: { method: 'GET' }
  });
}

export {
  getHistory,
  getOrder,
  buy,
};