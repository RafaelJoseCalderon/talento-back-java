import { url_base } from "./config";
import { handleFetch, getCurrentUserId } from "./tools";

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

const buy = async ({ request }) => {
  const id = getCurrentUserId();
  const itemsRequest = await request.json()
  const items = itemsRequest.map(item => {
     return {productId: item.id, quantity: item.quantity}
  });

  if (!id) return;

  return await handleFetch({
    url: `${url_base}/api/orders/complete-sale/${id}`,
    options: {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(items),
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
  buy,
  getHistory,
  getOrder,
};