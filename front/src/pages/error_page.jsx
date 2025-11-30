import { useRouteError } from "react-router";

const ErrorPage = () => {
  const error = useRouteError();
  console.error(error);

  return (
    <div style={{ textAlign: "center", marginTop: "100px", marginLeft: "auto", marginRight: "auto" }}>
      <h1>Oops!</h1>
      <p>Lo sentimos, ocurrió un error inesperado.</p>
      <p>
        <i>{error.statusText || error.message}</i>
      </p>
    </div>
  );
}

export default ErrorPage;