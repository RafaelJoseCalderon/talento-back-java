import { Link, useLoaderData, useSubmit } from "react-router";
import { Container, Row, Col } from "react-bootstrap";

import ProductListAdmin from "../components/product_list_admin";
import SearchBar from "../components/search_bar";
import Paginator from "../components/paginator";
import Dialog from "../utils/dialog";

const ProductsAdmin = () => {
  const { products, query, pagination } = useLoaderData();
  const submit = useSubmit();

  const remove = (id) => {
    if (id !== null) {
      submit({ id }, { method: 'delete' });
    }
  };

  return (
    <Container className="my-5">
      <h2>Panel de Administración</h2>

      <Row>
        <Col className="d-flex justify-content-end mb-2">
          <Link className="btn btn-primary" to="/admin/create">
            Nuevo
          </Link>
        </Col>
      </Row>

      <Row>
        <Col>
          <Dialog.Provider>
            <Dialog.Wrap>
              <SearchBar query={query} />
              <ProductListAdmin items={products} />
              <Paginator {...pagination} />
            </Dialog.Wrap>

            <Dialog.Modal>
              <Dialog.Title>Confirmar Eliminación</Dialog.Title>
              <Dialog.Body>¿Estás seguro de que quieres eliminar este producto? Esta acción no se puede deshacer.</Dialog.Body>
              <Dialog.Close>Cancelar</Dialog.Close>
              <Dialog.Action variant="danger" onActions={remove}>Eliminar</Dialog.Action>
            </Dialog.Modal>

          </Dialog.Provider>
        </Col>
      </Row>
    </Container>
  );
};

export default ProductsAdmin;