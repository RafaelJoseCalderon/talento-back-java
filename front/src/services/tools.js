import { redirect } from "react-router";
import { notification } from "../utils/notification";

export const parseSearchParams = (request) => {
  const sparams = new URL(request.url).searchParams;
  return Object.fromEntries(sparams.entries());
};

export const getCurrentUserId = () => {
  const userStrg = localStorage.getItem("auth-user");
  const userAuth = JSON.parse(userStrg);

  if (userAuth?.role !== "user") {
    notification.info("Debes estar registrado para agregar productos al carrito");
    return;
  }

  return Number(userAuth.id);
};

export const handleFetch = async (params) => {
  const { url, options, successMessage, redirectOnSuccess, booleanResponse = false } = params

  try {
    const response = await fetch(url, options);
    const responseJson = await response.json();

    if (response.ok) {
      if (successMessage) {
        notification.success(successMessage);
      }
  
      if (redirectOnSuccess) {
        return redirect(redirectOnSuccess);
      }
  
      if (booleanResponse) {
        return true;
      }

      return responseJson;
    }
  
    if (response.status >= 400 && response.status < 500) {
      notification.danger(
        responseJson.message || `Error en la operación (Error de cliente).`
      );

      if (booleanResponse) {
        return false;
      }

      return responseJson;
    }
  } catch (e) {
    notification.danger("Error al procesar la respuesta del servidor.");
    return;
  }
}