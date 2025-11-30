import { Link } from "react-router";
import { useDialog } from "../utils/dialog";
import { Card, Button } from "react-bootstrap";

import NotItems from "./not_items";
import SafeImage from "./safe_image";

const ProductListAdmin = ({ items }) => {
  const { open } = useDialog();

  return (<>
    {items && items.length > 0 ?
      items.map(item => (
        <Card key={item.id} className="admin-card">
          <Card.Img as={SafeImage} variant="top" image={item?.image} />

          <Card.Body>
            <Card.Text>{item.title}</Card.Text>
            <Card.Text>${item.price}</Card.Text>
          </Card.Body>

          <div className="buttons">
            <Link className="btn btn-info m-0 p-0" to={`/admin/details/${item.id}`}>
              <i className="bi bi-info-circle"></i>
            </Link>

            <Link className="btn btn-success m-0 p-0" to={`/admin/edit/${item.id}`}>
              <i className="bi bi-pencil"></i>
            </Link>

            <Button variant="danger" onClick={() => open(item.id)}>
              <i className="bi bi-trash"></i>
            </Button>
          </div>
        </Card>
      )) :
      <NotItems />
    }
  </>);
};

export default ProductListAdmin;