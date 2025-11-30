import { useState } from "react";
import { Button, Form, InputGroup, Stack } from "react-bootstrap";
import { useSearchParams } from "react-router";

const Paginator = ({ page, limit, totalPages }) => {
  const [searchParams, setSearchParams] = useSearchParams();
  const [goToPage, setGoToPage] = useState(page);

  const onGoTo = ({ page, limit }) => {
    searchParams.delete("page");
    searchParams.delete("limit");

    if (page !== 1 || limit !== 5) {
      searchParams.append("page", page);
      searchParams.append("limit", limit);
    }

    setSearchParams(searchParams, { replace: true });
  };

  const onPrev = () => {
    onGoTo({ page: page - 1, limit });
  };

  const onNext = () => {
    onGoTo({ page: page + 1, limit });
  };

  const onLimit = ({ target: { value } }) => {
    onGoTo({ page: 1, limit: value });
  };

  const handleGoTo = ({ target: { value } }) => {
    if (!/^\d*$/.test(value)) return;

    const numeric = Number(value);
    if (numeric > 0 && numeric <= totalPages) {
      setGoToPage(numeric);
    }
  };

  return (
    <Stack className="paginator flex-sm-row" gap={3}>

      <InputGroup className="region">
        <InputGroup.Text>Limite</InputGroup.Text>
        <Form.Select value={limit} onChange={onLimit}> reseta la pagina
          <option value="5">5</option>
          <option value="10">10</option>
          <option value="25">25</option>
          <option value="50">50</option>
        </Form.Select>
      </InputGroup>

      <InputGroup className="region mx-auto">
        <Button
          variant="outline-secondary"
          onClick={onPrev}
          disabled={page === 1}
        >{"<"}
        </Button>

        <Form.Control as="label" className="text-center no-select">
          {page}/{totalPages}
        </Form.Control>

        <Button
          variant="outline-secondary"
          onClick={onNext}
          disabled={page === totalPages}
        >{">"}
        </Button>
      </InputGroup>

      <InputGroup className="region">
        <InputGroup.Text>Ir a</InputGroup.Text>
        <Form.Control
          type="text"
          inputMode="numeric"
          pattern="\d*"
          value={goToPage ?? 1}
          onChange={handleGoTo}
        />
        <Button
          variant="outline-secondary"
          onClick={() => { onGoTo({ page: goToPage, limit }); }}
        >{">"}
        </Button>
      </InputGroup>
    </Stack>
  );
};

export default Paginator;