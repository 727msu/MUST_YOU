<template>
  <div class="h-screen w-full  flex justify-center items-center">
    <div class="w-1/2 xl:w-1/4">
      <div class="bg-white p-8 rounded-lg shadow-lg min-w-full">
        <h1 class="text-center text-2xl mb-6 text-gray-600 font-bold font-sans">注册</h1>
        <div>
          <label class="text-gray-800 font-semibold block my-3 text-md" for="username">Username</label>
          <input class="w-full bg-gray-100 px-4 py-2 rounded-lg focus:outline-none" type="text" name="username"
                 v-model="form.username" id="username" placeholder="username">
        </div>
        <div>
          <label for="default"
                 class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Organization</label>
          <select name="organization" id="default" v-model="form.organization"
                  class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 ">
            <option value="校内人员">校内人员</option>
            <option value="校外人员" selected>校外人员</option>
          </select>
        </div>
        <div>
          <label class="text-gray-800 font-semibold block my-3 text-md" for="password">Password</label>
          <input class="w-full bg-gray-100 px-4 py-2 rounded-lg focus:outline-none" type="password"
                 name="password" v-model="form.password"
                 id="password" placeholder="password">
        </div>
        <div>
          <label class="text-gray-800 font-semibold block my-3 text-md" for="confirm">Confirm password</label>
          <input class="w-full bg-gray-100 px-4 py-2 rounded-lg focus:outline-none" type="password" name="confirm"
                 v-model="form.confirm" id="confirm" placeholder="confirm password">
        </div>
        <button type="submit" @click.prevent="submit"
                class="w-full mt-6 bg-indigo-600 rounded-lg px-4 py-2 text-lg text-white tracking-wide font-semibold font-sans">
          Register && Login
        </button>
      </div>
    </div>

  </div>
</template>


<script setup>


import {ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import {env} from "../../env.js";
import {userStore} from "../store/index.js";
import router from "../router/index.js";

const form = ref({
  username: '',
  password: '',
  organization: ''
})

const useStore = userStore()
const submit = () => {
  const phoneRegex = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$/;
  const passRegex = /^[a-zA-Z0-9]{4,16}$/;

  if (!phoneRegex.test(form.value.username)) {
    ElMessage.error({
      message: "用户名格式不正确"
    })
    return
  }
  if (!passRegex.test(form.value.password)) {
    ElMessage.error({
      message: "密码格式不正确"
    })
    return
  }
  if (form.value.password !== form.value.confirm) {
    ElMessage.error({
      message: "两次密码不一致"
    })
    return
  }
  axios.post(env.BASE_URL + '/register', form.value).then(res => {
    if (res.data.code === 200401) {
      ElMessage.error({
        message: res.data.data
      })
    } else if (res.data.code === 200200) {
      localStorage.setItem('user', res.data.data);
      useStore.updateUserInfo(res.data.data);
      ElMessage.success({
        message: res.data.msg
      })
      router.push('/')
    }
  }).catch(err => {
    console.log(err)
  })
}


</script>
<style scoped>

</style>
