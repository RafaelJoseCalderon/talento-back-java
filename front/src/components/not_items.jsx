import { Stack } from "react-bootstrap";

const NotItems = () => {
  return (<>
    <Stack style={{ userSelect: "none" }}>
      <div className="display-6 text-center">
        No hay items disponibles
      </div>
    </Stack>
  </>);
};

export default NotItems;