import { useLoaderData } from "react-router";

import { Container } from "react-bootstrap";
import SearchBar from "../components/search_bar";
import Paginator from "../components/paginator";
import ProductsList from "../components/product_list";

const Products = ({ title }) => {
  const { products, query, pagination } = useLoaderData();

  return (
    <Container className="w-100 my-4">
      <h1>{title}</h1>

      <SearchBar query={query} />
      <ProductsList products={products} />
      <Paginator {...pagination} />

    </Container>
  );
};

export default Products;