import { useNavigation } from "react-router";
import { Spinner } from "react-bootstrap";

export default function PendingOverlay({ className }) {
  const navigation = useNavigation();
  const isPending = navigation.state !== "idle";

  return (
    <div className={`pending__ ${isPending ? "pending__show" : ""}`}>
      <Spinner className="spinner__" animation="border" role="status" />
      <span>...</span>
    </div>
  );
}
