import { useEffect, useState } from "react";
import { useAuth } from "../hooks/use_auth";
import { useCart } from "../hooks/use_cart";

import { Container, Navbar, Nav, Badge } from "react-bootstrap";
import { Link, NavLink, useLocation } from "react-router";
import { NotificationContainer } from "../utils/notification";

const Header = () => {
  const { isAuth, isAdmin } = useAuth();
  const { size } = useCart();

  const location = useLocation();
  const [expanded, setExpanded] = useState(false);

  useEffect(() => { setExpanded(false); }, [location.pathname]);

  return (
    <>
      <header className="fixed-top" >
        <Navbar expanded={expanded} expand="lg" className="py-3 shadow">
          <Container>

            <Navbar.Brand as={Link} to="/">
              <img className="logo" src="/logo_black.svg" alt="TP" />
            </Navbar.Brand>

            {!isAdmin &&
              <Nav.Link as={Link} to="/cart" className="button-cart">
                <div className="icons">
                  <i className="bi bi-cart"></i>
                  <Badge>{size}</Badge>
                </div>
              </Nav.Link>
            }

            <Navbar.Toggle onClick={() => setExpanded(!expanded)} aria-controls="main-navbar" />

            <Navbar.Collapse id="main-navbar">

              <Nav className="me-auto">
                <Nav.Link as={NavLink} to="/">
                  <i className="icons d-lg-none bi bi-basket"></i>
                  <span className="mx-2">Productos</span>
                </Nav.Link>

                {!isAdmin &&
                  <>
                    <Nav.Link as={NavLink} to="/about">
                      <i className="icons d-lg-none bi bi-people"></i>
                      <span className="mx-2">Sobre nosotros</span>
                    </Nav.Link>

                    <Nav.Link as={NavLink} to="/contact">
                      <i className="icons d-lg-none bi bi-envelope"></i>
                      <span className="mx-2">Contacto</span>
                    </Nav.Link>
                  </>
                }

                {isAdmin &&
                  <Nav.Link as={NavLink} to="/admin">
                    <i className="icons d-lg-none bi bi-person-gear"></i>
                    <span className="mx-2">Admin</span>
                  </Nav.Link>
                }
              </Nav>

              <Nav className="me-1">
                {isAuth ?
                  <>
                    <Nav.Link as={Link} to="/logout" className="button-user order-2 order-lg-1">
                      <i className="icons bi bi-box-arrow-right"></i>
                      <span className="mx-2 d-block d-lg-none">Cerrar sesión</span>
                    </Nav.Link>
                  </>
                  :
                  <Nav.Link as={Link} to="/login" className="button-user">
                    <i className="icons bi bi-person"></i>
                    <span className="mx-2 d-lg-none">Iniciar sesión</span>
                  </Nav.Link>
                }
                {isAuth && !isAdmin &&
                  <Nav.Link as={Link} to="/cart/history" className="button-user order-1 order-lg-2">
                    <i className="icons bi bi-journal-text"></i>
                    <span className="mx-2 d-block d-lg-none">Historial de compras</span>
                  </Nav.Link>
                }
              </Nav>

            </Navbar.Collapse>
          </Container>
        </Navbar>
        <NotificationContainer />
      </header >
      <div style={{ height: "var(--navbar-space)" }}></div>
    </>
  );
};

export default Header;