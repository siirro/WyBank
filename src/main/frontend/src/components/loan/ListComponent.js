import React, {useEffect, useState} from 'react';
import useCustomMove from "../../hooks/useCustomMove";
import {getList} from "../../api/accountApi";

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
    return (
        // 가장 바깥 div 구분하기 위한 선 넣었음 나중에 빼자.
        <div className="border-2 border-blue-100 mt-10 mx-2">
            <div>나의 대출</div>
            <div className="flex flex-wrap justify-center mx-auto p-6">
                <table className="min-w-full table-auto border-collapse">
                    <thead>
                    <tr className="bg-blue-100">
                        <th className="px-4 py-2 border">대출명</th>
                        <th className="px-4 py-2 border">계좌번호</th>
                        <th className="px-4 py-2 border">만기일</th>
                        <th className="px-4 py-2 border">대출잔액</th>
                        <th className="px-4 py-2 border">업무</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ListComponent;