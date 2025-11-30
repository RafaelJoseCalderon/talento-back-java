import { url_base } from "./config";
import { handleFetch } from "./tools";
import { parseSearchParams } from "./tools";

import { getAllCached } from "./categories";

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

const mapToProduct = (fromProduct) => {
  const item = {};
  let price = fromProduct.get("price");
  let stock = fromProduct.get("stock");
  let image = fromProduct.get("image");

  item.id = fromProduct.get("id");
  item.title = fromProduct.get("title");
  item.description = fromProduct.get("description");
  item.categoryId = fromProduct.get("category");
  item.rating = { rate: 0.0, count: 0 };

  // ------------------------------------
  if (typeof price === 'string') {
    price = price.replace(',', '.').trim();
  }

  const priceNum = parseFloat(price);
  item.price = isNaN(priceNum) ? null : priceNum;

  // ------------------------------------
  if (typeof stock === 'string') {
    stock = stock.replace(',', '.').trim();
  }

  const stockNum = parseFloat(stock);
  item.stock = isNaN(stockNum) ? null : stockNum;

  // ------------------------------------
  if (image) {
    item.image = image;
  }

  return item;
};

const getBy = async ({ request }) => {
  const url = new URL("api/products/all", url_base);
  const { query, page, limit } = parseSearchParams(request);

  if (query) url.searchParams.append("query", query);
  if (page) url.searchParams.append("page", page - 1);
  if (limit) url.searchParams.append("size", limit);

  const response = await handleFetch({
    url: url.toString(),
    options: { method: "GET" }
  });

  return {
    products: response.content,
    query: response.query,
    pagination: {
      page: response.pagination.page + 1,
      limit: response.pagination.size,
      totalPages: response.pagination.totalPages
    }
  };
};

const getById = async ({ params }) => {
  return await handleFetch({
    url: `${url_base}/api/products/${params.id}`,
    options: { method: 'GET' }
  });
};

const getForTheForm = async ({ params }) => {
  const [product, categories] = await Promise.all((params && params?.id)
    ? [getById({ params }), getAllCached()]
    : [null, getAllCached()]
  );

  return { product, categories };
};

const create = async ({ request }) => {
  const productForm = await request.formData();
  const product = mapToProduct(productForm);

  return handleFetch({
    url: `${url_base}/api/products/create`,
    options: {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(product)
    },
    successMessage: "Creado correctamente",
    redirectOnSuccess: "/admin",
  });
};

const update = async ({ request }) => {
  const productForm = await request.formData();
  const product = mapToProduct(productForm);

  return handleFetch({
    url: `${url_base}/api/products/update/${product.id}`,
    options: {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(product)
    },
    successMessage: "Actualizado correctamente",
    redirectOnSuccess: "/admin",
  });
};

const remove = async ({ request }) => {
  const formData = await request.formData();
  const id = formData.get("id");

  return handleFetch({
    url: `${url_base}/api/products/delete/${id}`,
    options: { method: "DELETE" },
    successMessage: "Eliminado correctamente",
  });
};

export {
  getBy,
  getById,
  getForTheForm,
  create,
  update,
  remove,
};