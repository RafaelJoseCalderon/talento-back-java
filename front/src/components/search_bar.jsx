import { Form, InputGroup, Spinner } from "react-bootstrap";
import { useNavigation, useSubmit } from "react-router";

const SearchBar = ({ query }) => {
  const { state } = useNavigation();
  const submit = useSubmit();

  const onChange = ({ currentTarget: { form, value } }) => {
    const trimmed = value.trim();
    submit(trimmed ? form : null, { replace: query !== null });
  };

  return (
    <Form role="search" className="search my-2">
      <InputGroup>
        <InputGroup.Text>
          {state === "loading"
            ? <Spinner as="span" animation="border" />
            : <i className="bi bi-search"></i>
          }
        </InputGroup.Text>
        <Form.Control
          name="query"
          type="search"
          placeholder="Buscar"
          defaultValue={query}
          onChange={onChange}
        />
      </InputGroup>
    </Form>
  );
};

export default SearchBar;