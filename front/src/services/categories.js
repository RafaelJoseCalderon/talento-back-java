import { url_base } from "./config";
import { handleFetch } from "./tools";

let cachedCategories = null;
let lastCategoriesFetchTime = 0;
const CACHE_DURATION_MS = 5 * 60 * 1000; // 5 minutos

const getAll = async () => {
  return await handleFetch({
    url: `${url_base}/api/categories/all`,
    options: { method: 'GET' },
  });
};

const getAllCached = async () => {
  const now = Date.now();

  if (!cachedCategories || now - lastCategoriesFetchTime > CACHE_DURATION_MS) {
    cachedCategories = await getAll();
    lastCategoriesFetchTime = now;
  }

  return cachedCategories;
};

export {
  getAll,
  getAllCached
};