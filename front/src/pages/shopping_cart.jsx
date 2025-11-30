import { useState } from "react";
import { useLoaderData } from "react-router";
import { useAsyncSubmit } from "../hooks/use_async_submit";
import { useCart } from "../hooks/use_cart";

import { Container, Row, Col } from "react-bootstrap";

import CartList from "../components/cart_list";
import SummaryCart from "../components/cart_summary";

import NotItems from "../components/not_items";
import Dialog from "../utils/dialog";

const ShopingCart = () => {
  const [show, setShow] = useState(false);
  const { items } = useLoaderData();
  const { submit } = useAsyncSubmit();
  const { setCart } = useCart();

  const delItem = (id) => {
    submit(
      { id, action: "delete" },
      { method: "delete", encType: "application/json" }
    ).then(r => setCart(r));
  }

  const buy = () => {
    submit(
      {action: "buy"},
      { method: "post", encType: "application/json" }
    ).then(r => {
      setCart(r)
      setTimeout(() => { setShow(true); }, 500);
    });
  };

  const closeModal = () => {
    setShow(false);
  }

  return (
    <>
      <Container className="my-5">
        <h2 className="mb-4">Carrito de Compras</h2>

        <Row className="mt-2">
          <Col md={8} className="cart-container">
            {(!items || items?.length === 0) ? <NotItems /> :
              <CartList items={items} remove={delItem} />
            }
          </Col>
          <Col md={4}>
            <SummaryCart items={items} buy={buy} />
          </Col>
        </Row>
      </Container>

      <Dialog.ModalBase show={show} close={closeModal}>
        <Dialog.Title>Compra realizada</Dialog.Title>
        <Dialog.Body>Gracias, vuelva pronto</Dialog.Body>
        <Dialog.CloseBase close={closeModal}>Cerrar</Dialog.CloseBase>
      </Dialog.ModalBase>
    </>
  );
};

export default ShopingCart;