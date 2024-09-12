import React, {useEffect, useState} from 'react';
import useCustomMove from "../../hooks/useCustomMove";
import {getAccountList} from "../../api/accountApi";

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
        getAccountList(page,size).then(data => {
            console.log(data)
            setServerData(data)
        })
    }, [page, size]);

    return (
        // 가장 바깥 div 구분하기 위한 선 넣었음 나중에 빼자.
        <div className="border-2 border-blue-100 mt-10 mx-2">
            <div>계좌목록</div>
            <div className="flex flex-wrap justify-center mx-auto p-6">
                <table className="min-w-full table-auto border-collapse">
                    <thead>
                    <tr className="bg-blue-100">
                        <th className="px-4 py-2 border">계좌이름</th>
                        <th className="px-4 py-2 border">계좌번호</th>
                        <th className="px-4 py-2 border">계좌잔액</th>
                        <th className="px-4 py-2 border">생성일</th>
                    </tr>
                    </thead>
                    <tbody>
                    {serverData.dtoList.map((account) => (
                        <tr key={account.accountId} className="hover:bg-blue-50">
                            <td className="px-4 py-2 border text-center">{account.accountId}</td>
                            <td className="px-4 py-2 border text-center">{account.accountNumber}</td>
                            <td className="px-4 py-2 border text-right">{account.balance}원</td>
                            <td className="px-4 py-2 border text-right">{account.createdAt}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ListComponent;