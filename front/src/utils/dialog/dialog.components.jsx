import React, { useRef, useState, useContext } from "react";
import { Modal, Button } from "react-bootstrap";
import { DialogContext } from "./dialog.context";

export const DialogTitle = ({ children }) => (
  <Modal.Header closeButton>
    <Modal.Title>{children}</Modal.Title>
  </Modal.Header>
);

export const DialogBody = ({ children }) => (
  <Modal.Body>{children}</Modal.Body>
);

export const DialogCloseBase = ({ variant = "secondary", close, children }) => {
  return (
    <Button variant={variant} onClick={close}>
      {children}
    </Button>
  );
};

export const DialogClose = ({ variant = "secondary", children }) => {
  const { close } = useContext(DialogContext);

  return (
    <Button variant={variant} onClick={close}>
      {children}
    </Button>
  );
};

export const DialogAction = ({ variant = "primary", onActions, children }) => {
  const { close, args } = useContext(DialogContext);

  const handleClick = () => {
    onActions?.(args);
    close();
  };

  return (
    <Button variant={variant} onClick={handleClick}>
      {children}
    </Button>
  );
};

export const DialogModalBase = ({ show, close, children }) => {
  let title, body, close_, actions = [];

  React.Children.forEach(children, child => {
    if (!React.isValidElement(child)) return;
    else if (child.type === DialogTitle) title = child;
    else if (child.type === DialogBody) body = child;
    else if (child.type === DialogClose) close_ = child;
    else if (child.type === DialogCloseBase) close_ = child;
    else if (child.type === DialogAction) actions.push(child);
  });

  return (
    <Modal show={show} onHide={close}>
      {title}
      {body}
      <Modal.Footer>
        <>{close_}</>
        {actions && actions.length > 0 && actions.map((a, i) =>
          <React.Fragment key={i}>{a}</React.Fragment>
        )}
      </Modal.Footer>
    </Modal>
  );
};

export const DialogModal = ({ children }) => {
  const { show, close } = useContext(DialogContext);

  return (
    <DialogModalBase show={show} close={close}>
      {children}
    </DialogModalBase>
  );
};

export const DialogWrap = ({ children }) => <>{children}</>;

export const DialogProvider = ({ children }) => {
  const [show, setShow] = useState(false);
  const args = useRef();

  const open = (attrs) => {
    args.current = attrs;
    setShow(true);
  };

  const close = () => {
    args.current = null;
    setShow(false);
  };

  return (
    <DialogContext.Provider value={{ show, open, close, args: args.current }}>
      {children}
    </DialogContext.Provider>
  );
};
