import {defineStore} from "pinia"
import {ref} from "vue"

export const userStore = defineStore("userStore", () => {
    const userInfo = ref({
        id: -1,
        username: "",
        organization: "",
        phone: "",
        enabled: false,
    })
    const updateUserInfo = (params) => {
        const data = {...userInfo.value, ...params}
        userInfo.value = data;
        writeLocalStorage(data)
        return data
    }
    const writeLocalStorage = (params) => {
        localStorage.setItem("LOCAL_USER_INFO", JSON.stringify(params))
        localStorage.setItem("USER_TOKEN", params.token)
    }

    return {
        userInfo, updateUserInfo
    }

}, {persist: true})


export const actStore = defineStore("actStore", () => {
    const actInfo = ref([])
    const updateActInfo = (params) => {
        actInfo.value = params
        return params
    }
    return {
        actInfo, updateActInfo
    }
}, {persist: true})
