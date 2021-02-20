import React from "react";
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



export default BasicTableComponent;