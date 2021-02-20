import './App.css';
import { Navbar, Nav, NavDropdown, Form, FormControl, Button } from 'react-bootstrap';
import Welcome from './pages/Welcome';
import './pages/css/Main.css';


import { useTable } from 'react-table';
import 'bootstrap/dist/css/bootstrap.min.css';

const BasicTableComponent = ({ contacts }) => {
  const columns = [
    { Header: 'S No', accessor: 'customerNumber', }, { Header: 'customerName', accessor: 'customerName', }, { Header: 'PhoneNumber', accessor: 'phoneNumber' },
    { Header: 'AlternatePhoneNumber', accessor: 'alternatePhoneNumber', }, { Header: 'EmailId', accessor: 'emailId', }, { Header: 'DateOfBirth', accessor: 'dateOfBirth' }, { Header: 'Address', accessor: 'address' }
  ];
  const data = contacts;

  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow,
  } = useTable({
    columns,
    data,
  })

  return (

    <table className="table" {...getTableProps()}>
      <thead>
        {headerGroups.map(headerGroup => (
          <tr {...headerGroup.getHeaderGroupProps()}>
            {headerGroup.headers.map(column => (
              <th {...column.getHeaderProps()}>{column.render('Header')}</th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody {...getTableBodyProps()}>
        {rows.map((row, i) => {
          prepareRow(row)
          return (
            <tr {...row.getRowProps}>
              {row.cells.map(cell => {
                return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
              })}
            </tr>
          )
        })}
      </tbody>
    </table>
  )
}

function App() {
  return (
    <div className="App">

      <header>
        <Navbar expand="lg" variant="dark" bg="dark">
          <Navbar.Brand href="#home">Credit Report</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link href="#home">Home</Nav.Link>
              <Nav.Link href="#link">Link</Nav.Link>
              { /*<NavDropdown title="Dropdown" id="basic-nav-dropdown">
                <NavDropdown.Item>Action</NavDropdown.Item>
                <NavDropdown.Item>Another action</NavDropdown.Item>
                <NavDropdown.Item>Something</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
  </NavDropdown> */ }
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </header>
      <Welcome />

    </div>
  );
}

export default App;
