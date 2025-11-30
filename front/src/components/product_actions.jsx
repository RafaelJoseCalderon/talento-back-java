import { useState } from "react";
import { useNotification } from "../hooks/use_notification";

import { ButtonGroup, Button } from "react-bootstrap";
import QuantitySelector from "./quantity_selector";

const ProductActions = ({ product, moreDetails, addToCart }) => {
  const [quantity, setQuantity] = useState(1);
  const { info } = useNotification();

  const add = () => {
    if (quantity < product.stock) {
      addToCart(product, quantity);
      setQuantity(1);
    } else {
      info("No hay stock suficiente");
    }
  }

  const details = () => {
    moreDetails(product)
  }

  return (
    <>
      <ButtonGroup>
        <Button className="w-50" onClick={details} variant="primary">Más detalles</Button>
        <Button className="w-50" onClick={add} variant="success">Agregar</Button>
      </ButtonGroup>

      <QuantitySelector value={quantity} onChange={setQuantity} />
    </>
  );
}

export default ProductActions;