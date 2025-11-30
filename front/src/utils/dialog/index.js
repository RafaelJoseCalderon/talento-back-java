import "./dialog.style.css";

import {
  DialogTitle,
  DialogBody,
  DialogClose,
  DialogAction,
  DialogModal,
  DialogWrap,
  DialogProvider,

  DialogCloseBase,
  DialogModalBase,
} from "./dialog.components";

const Dialog = {
  Title: DialogTitle,
  Body: DialogBody,
  Close: DialogClose,
  Action: DialogAction,
  Modal: DialogModal,
  Wrap: DialogWrap,
  Provider: DialogProvider,

  CloseBase: DialogCloseBase,
  ModalBase: DialogModalBase,
};

export { useDialog } from "./dialog.hook";
export default Dialog;
