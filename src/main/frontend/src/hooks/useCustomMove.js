import {createSearchParams, useNavigate, useSearchParams} from "react-router-dom";

const getNum = (param, defaultValue) => {
    if(!param){
        return defaultValue
    }
    return parseInt(param)
}

const useCustomMove = () => {
    const navigate = useNavigate()
    const [queryParams] = useSearchParams()

    const page = getNum(queryParams.get('page'), 1)
    const size = getNum(queryParams.get('size'), 10)
    const queryDefalut = createSearchParams({page,size}).toString()

    const moveToList = (pageParam) => {

        let queryStr = ""
        if(pageParam) {
            const pageNum = getNum(pageParam.page, 1)
            const sizeNum = getNum(pageParam.size, 10)

            queryStr = createSearchParams({page:pageNum, size:sizeNum}).toString()
        }else {
            queryStr = queryDefalut
        }

        navigate({pathname:`../list`, search:queryStr})
    }

    const moveToUpdateMemo = (id) => {
        navigate({pathname:`../update/memo`, search:queryDefalut})
    }

    const moveToUpdatePw = (id) => {
        navigate({pathname:`../update/pw`, search:queryDefalut})
    }

    return {moveToList, moveToUpdateMemo, page, size}
}

export default useCustomMove