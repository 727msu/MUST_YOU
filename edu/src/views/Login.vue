<template>
  <div class="max-w-screen max-h-screen h-screen flex justify-center items-center">
    <div
        class="flex min-h-full w-1/6 md:w-1/4 xl:w-full text-sm sm:text-base   flex-col justify-center px-6 py-12 lg:px-8 bg-gray-100 rounded rounded-[2rem] ">
      <div class="sm:mx-auto sm:w-full sm:max-w-sm">
        <h2 class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Sign in to your
          account</h2>
      </div>

      <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <div class="space-y-6">
          <div>
            <label for="username" class="block text-sm font-medium leading-6 text-gray-900">Phone</label>
            <div class="mt-2 flex">
                          <span
                              class="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border rounded-e-0 border-gray-300 border-e-0 rounded-s-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
                            <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true"
                                 xmlns="http://www.w3.org/2000/svg"
                                 fill="currentColor" viewBox="0 0 20 20">
                                <path
                                    d="M10 0a10 10 0 1 0 10 10A10.011 10.011 0 0 0 10 0Zm0 5a3 3 0 1 1 0 6 3 3 0 0 1 0-6Zm0 13a8.949 8.949 0 0 1-4.951-1.488A3.987 3.987 0 0 1 9 13h2a3.987 3.987 0 0 1 3.951 3.512A8.949 8.949 0 0 1 10 18Z"/>
                            </svg>
                          </span>
              <input id="username" name="username" type="text" autocomplete="false" required v-model="form.username"
                     class="rounded-none rounded-e-lg bg-gray-50 border text-gray-900 focus:ring-blue-500 focus:border-blue-500 block flex-1 min-w-0 w-full text-sm border-gray-300 p-2.5">
            </div>
          </div>

          <div>
            <div class="flex items-center justify-between">
              <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
              <div class="text-sm">
                <a href="#" class="font-semibold text-indigo-600 hover:text-indigo-500">Forgot password?</a>
              </div>
            </div>
            <div class="mt-2 flex">
                        <span
                            class="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border rounded-e-0 border-gray-300 border-e-0 rounded-s-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
                            <svg t="1712217000140" class="w-4 h-4 text-gray-500 dark:text-gray-400"
                                 viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4248"
                                 width="128" height="128"><path
                                d="M868.935 1008.63H155.067c-40.657 0-72.291-31.631-72.291-67.773V443.863c0-36.144 31.631-67.773 72.291-67.773h713.868c40.657 0 72.291 31.631 72.291 67.773v496.994c0 36.144-31.631 67.773-72.291 67.773zM512 543.259c-58.732 0-108.432 45.187-108.432 99.402 0 36.144 22.586 67.773 54.218 85.849v94.887c0 27.108 22.586 49.696 54.218 49.696s54.218-22.586 54.218-49.696V728.51c31.631-18.071 54.218-49.696 54.218-85.849 0-54.218-49.696-99.402-108.432-99.402z m0-429.228c-117.471 0-216.867 90.356-216.867 198.797H186.701c0-162.655 144.582-298.202 320.79-298.202s320.79 135.546 320.79 298.202H719.849c9.041-112.951-90.356-198.797-207.836-198.797z m0 0z"
                                p-id="4249" fill="#8a8a8a"></path></svg>
                          </span>
              <input id="password" name="password" type="password" autocomplete="current-password" required
                     v-model="form.password"
                     class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
            </div>
          </div>

          <div>
            <button type="submit" @click="submit"
                    class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
              Sign in
            </button>
          </div>
        </div>

        <p class="mt-10 text-center text-sm text-gray-500">
          Not a Account?
          <a @click.prevent="router.push('/register')"
             class="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">register</a>
        </p>
      </div>
    </div>
  </div>
</template>


<script setup>
import {useRouter} from 'vue-router'
import axios from "axios";
import {userStore} from "../store/index.js";
import {env} from "../../env.js";
import {ref} from "vue";
import {ElMessage} from "element-plus";

const useStore = userStore()
const router = useRouter()
const form = ref({
  username: '',
  password: ''
})
const submit = () => {
  axios.post(`/api/auth/login?username=${form.value.username}&password=${form.value.password}`, form.value).then(res => {
    if (res.data.code === 200200) {
      localStorage.setItem('user', res.data.data);
      useStore.updateUserInfo(res.data.data);
      ElMessage.success({
        message: res.data.msg
      })
      router.push('/')
    } else {
      ElMessage.error({
        message: res.data.data
      })
    }
  }).catch(err => {
    console.log(err)
  })
}
</script>
<style scoped>

</style>
