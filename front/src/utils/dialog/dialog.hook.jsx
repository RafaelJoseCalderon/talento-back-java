import { useContext } from "react";
import { DialogContext } from "./dialog.context";

export const useDialog = () => {
  const { open, close } = useContext(DialogContext);

  return { open, close };
};
