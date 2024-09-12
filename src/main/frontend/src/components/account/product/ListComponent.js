import React, {useEffect, useState} from 'react';
import useCustomMove from "../../../hooks/useCustomMove";
import {getProductList} from "../../../api/accountApi";

const initState = {
    dtoList:[],
    pageNumList:[],
    pageRequestDTO:[],
    prev:false,
    next:false,
    totalCount:0,
    prevPage:0,
    nextPage:0,
    totalPage:0,
    current:0
}

function ListComponent(props) {
    const {page, size} = useCustomMove()
    const [serverData, setServerData] = useState(initState)
    useEffect(() => {
        getProductList(page,size).then(data => {
            console.log(data)
            setServerData(data)
        })

    }, [page, size]);

    return (
        <div className="border-2 border-blue-100 mt-10">
            <div className="flex flex-wrap justify-center mx-auto">
                <table className="min-w-full table-auto border-collapse">
                    <thead>
                    <tr className="bg-blue-100">
                        <th className="px-4 py-2 border">계좌이름</th>
                        <th className="px-4 py-2 border">계좌설명</th>
                        <th className="px-4 py-2 border">계좌상세</th>
                        <th className="px-4 py-2 border">생성일</th>
                        <th className="px-4 py-2 border">제목뺄거임</th>
                        
                    </tr>
                    </thead>
                    <tbody>
                    {serverData.dtoList.map((accountProduct) => (
                        <tr key={accountProduct.accountProductId} className="hover:bg-blue-50">
                            <td className="px-4 py-2 border text-left">[{accountProduct.accountType}] {accountProduct.accountName}원</td>
                            <td className="px-4 py-2 border text-center">{accountProduct.accountMemo}</td>
                            <td className="px-4 py-2 border text-center">{accountProduct.accountDescription}</td>
                            <td className="px-4 py-2 border text-right">{accountProduct.createdAt}</td>
                            <td className="px-4 py-2 border text-right">가입하기</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ListComponent;