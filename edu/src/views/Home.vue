<template>
  <div class="mx-auto">
    <div class="flex flex-col justify-center">
      <div class="flex justify-center">
        <div class="max-w-[80%] mx-auto">
          <nav class="min-w-full bg-white border-gray-200 shadow shadow-blue-500 shadow-lg">
            <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
              <a class="flex items-center space-x-3 rtl:space-x-reverse">
                <span class="self-center text-2xl font-semibold whitespace-nowrap">&nbsp;</span>
              </a>
              <div v-if="loginBtn" class="flex md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
                <button type="button" id="LoginBtn" @click="router.push('/login')"
                        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center">
                  Get Login
                </button>
                <button data-collapse-toggle="navbar-cta" type="button"
                        class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200"
                        aria-controls="navbar-cta" aria-expanded="false">
                  <span class="sr-only">Open main menu</span>
                  <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                       viewBox="0 0 17 14">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M1 1h15M1 7h15M1 13h15"/>
                  </svg>
                </button>
              </div>
              <div class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-cta">
                <ul class="flex flex-col font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white ">
                  <li>
                    <a href="#" id="Home-tab" ref="Home-tab-Ref" @click="triggerBtn(1)"
                       class="block py-2 px-3 md:p-0   rounded "
                       :class="triggerBtnNum=== 1 ? 'text-white bg-blue-700 md:bg-transparent md:text-blue-700' : 'text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700'"
                       aria-current="page">首页</a>
                  </li>
                  <li>
                    <a href="#" id="appointment-tab" ref="sub-tab-Ref" @click="triggerBtn(2)"
                       :class="triggerBtnNum=== 2 ? 'text-white bg-blue-700 md:bg-transparent md:text-blue-700' : 'text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700'"
                       class="block py-2 px-3 md:p-0 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 ">预约校园开放日</a>
                  </li>
                  <li>
                    <a href="#" ref="activities-tab-Ref" @click="triggerBtn(3)"
                       :class="triggerBtnNum=== 3 ? 'text-white bg-blue-700 md:bg-transparent md:text-blue-700' : 'text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700'"
                       class="block py-2 px-3 md:p-0 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700">浏览活动</a>
                  </li>
                  <li>
                    <a href="#" ref="geography-tab-Ref" @click="triggerBtn(4)"
                       :class="triggerBtnNum=== 4 ? 'text-white bg-blue-700 md:bg-transparent md:text-blue-700' : 'text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700'"
                       class="block py-2 px-3 md:p-0 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700">校园地图</a>
                  </li>
                  <li>
                    <a href="#" ref="order-tab-Ref" @click="triggerBtn(5)"
                       :class="triggerBtnNum=== 5 ? 'text-white bg-blue-700 md:bg-transparent md:text-blue-700' : 'text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700'"
                       class="block py-2 px-3 md:p-0 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700">查看订单</a>
                  </li>
                </ul>
                <!--            <ul class="flex flex-wrap text-sm font-medium text-center text-gray-500">-->
                <!--                <li class="me-2">-->
                <!--                    <a href="#" aria-current="page" class="inline-block p-4 text-blue-600 bg-gray-100 rounded-t-lg active dark:bg-gray-800 dark:text-blue-500">Profile</a>-->
                <!--                </li>-->
                <!--                <li class="me-2">-->
                <!--                    <a href="#" class="inline-block p-4 rounded-t-lg hover:text-gray-600 hover:bg-gray-50 dark:hover:bg-gray-800 dark:hover:text-gray-300">Dashboard</a>-->
                <!--                </li>-->
                <!--                <li class="me-2">-->
                <!--                    <a href="#" class="inline-block p-4 rounded-t-lg hover:text-gray-600 hover:bg-gray-50 dark:hover:bg-gray-800 dark:hover:text-gray-300">Settings</a>-->
                <!--                </li>-->
                <!--                <li class="me-2">-->
                <!--                    <a href="#" class="inline-block p-4 rounded-t-lg hover:text-gray-600 hover:bg-gray-50 dark:hover:bg-gray-800 dark:hover:text-gray-300">Contacts</a>-->
                <!--                </li>-->
                <!--                <li>-->
                <!--                    <a class="inline-block p-4 text-gray-400 rounded-t-lg cursor-not-allowed dark:text-gray-500">Disabled</a>-->
                <!--                </li>-->
                <!--            </ul>-->
              </div>
            </div>
          </nav>
        </div>

      </div>
      <div class="flex justify-center">
        <router-view/>
      </div>
    </div>
  </div>
</template>
<script setup>
import {useRouter} from "vue-router";
import {userStore} from "../store/index.js";
import {computed, ref} from "vue";

const useStore = userStore();
const router = useRouter()

const loginBtn = computed(() => useStore.userInfo.id === -1)

const triggerBtnNum = ref(1)

const triggerBtn = (num) => {
  triggerBtnNum.value = num
  if (num === 1) {
    router.push('/')
  } else if (num === 2) {
    router.push('/booking')
  } else if (num === 3) {
    router.push('/browse')
  } else if (num === 4) {
    router.push('/geography')
  } else if (num === 5) {
    router.push('/order')
  }
}

</script>
