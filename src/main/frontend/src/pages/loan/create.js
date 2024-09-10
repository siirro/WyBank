import React from 'react';
import Form from 'react-bootstrap/Form';
import LoanApplicationListComponent from "../../components/loan/LoanApplicationListComponent";
import CounselListComponent from "../../components/loan/CounselListComponent";
function Create(props) {
    return (
        <div className={"p-4 w-full bg-white"}>
            <CounselListComponent/>
        </div>
    );
}

export default Create;