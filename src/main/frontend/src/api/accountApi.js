import axios from "axios";

export const API_SERVER_HOST = 'http://localhost:8080'
const prefix = `${API_SERVER_HOST}/api/account`

export const getAccountOne = async (accountId) => {
    const res = await axios.get(`${prefix}/info/${accountId}`)
    return res.data
}

export const getAccountList = async (pageParam) => {
    const {page, size} = pageParam
    const res = await axios.get(`${prefix}/list`, {params:{...pageParam}})
    // const res = await axios.get(`${prefix}/list`, {params:{page,size}})
    return res.data
}

export const getProductList = async (pageParam) => {
    const {page, size} = pageParam
    const res = await axios.get(`${prefix}/product`, {params:{...pageParam}})
    return res.data
}