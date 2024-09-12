import React from 'react';
import ListComponent from "../../components/account/product/ListComponent";

function Product(props) {
    return (
        <div className={"p-4 w-full bg-white"}>

            <div>상품리스트</div>
            <ListComponent/>
        </div>
    );
}

export default Product;