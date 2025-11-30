import { Outlet } from "react-router"

import Header from "./components/header";
import Footer from "./components/footer";
import PendingOverlay from "./components/pending_overlay";

function App() {
  return (
    <>
      <Header />
      <main className="pending-container__">
        <PendingOverlay />
        <Outlet />
      </main>
      <Footer />
    </>
  )
}

export default App
