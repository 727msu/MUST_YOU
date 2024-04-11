<template>
  <div class="max-w-[80%] mx-auto">
    <div class="mx-auto  h-2"></div>
    <div class="mx-auto  h-2"></div>

    <div class="mx-auto  min-h-screen max-w-[80%] bg-white">
      <div class="flex flex-col justify-center px-6">
        <div class="p-10 flex justify-center" v-for="i in content.images" :key="i">
          <img :src="'/'+i" alt="">
        </div>
        <p class="text-2xl font-semibold indent-2 leading-normal text-gray-700">
          &nbsp;&nbsp;&nbsp;&nbsp;{{ content.desc }}</p>
      </div>
      <div class="mx-auto h-5"></div>
      <div class="flex p-10 justify-center text-4xl text-center items-center">
        <button @click="handleCick" class="mx-10 border  rounded-2xl hover:bg-blue-700 border-gray-600 p-5 bg-blue-500">
          <span class="text-white">购买</span>
        </button>
        <span class="text-red-600 mx-10">{{ content.price === 0 ? '免费' : "¥" + content.price }}</span>
      </div>
    </div>

    <div class="mx-auto h-5"></div>
    <div class="mx-auto max-w-[80%] bg-white">
      <div class="mx-auto w-full max-w-screen-xl">
        <!--                <div class="grid grid-cols-2 gap-8 px-4 py-6 lg:py-8 md:grid-cols-4">-->
        <!--                    <div>-->
        <!--                        <h2 class="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Company</h2>-->
        <!--                        <ul class="text-gray-500 dark:text-gray-400 font-medium">-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class=" hover:underline">About</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Careers</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Brand Center</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Blog</a>-->
        <!--                            </li>-->
        <!--                        </ul>-->
        <!--                    </div>-->
        <!--                    <div>-->
        <!--                        <h2 class="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Help center</h2>-->
        <!--                        <ul class="text-gray-500 dark:text-gray-400 font-medium">-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Discord Server</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Twitter</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Facebook</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Contact Us</a>-->
        <!--                            </li>-->
        <!--                        </ul>-->
        <!--                    </div>-->
        <!--                    <div>-->
        <!--                        <h2 class="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Legal</h2>-->
        <!--                        <ul class="text-gray-500 dark:text-gray-400 font-medium">-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Privacy Policy</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Licensing</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Terms &amp; Conditions</a>-->
        <!--                            </li>-->
        <!--                        </ul>-->
        <!--                    </div>-->
        <!--                    <div>-->
        <!--                        <h2 class="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">Download</h2>-->
        <!--                        <ul class="text-gray-500 dark:text-gray-400 font-medium">-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">iOS</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Android</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">Windows</a>-->
        <!--                            </li>-->
        <!--                            <li class="mb-4">-->
        <!--                                <a href="#" class="hover:underline">MacOS</a>-->
        <!--                            </li>-->
        <!--                        </ul>-->
        <!--                    </div>-->
        <!--                </div>-->
        <div class="px-4 py-6 bg-gray-100  md:flex md:items-center md:justify-between">
                    <span class="text-sm text-gray-500  sm:text-center">© 2024 <a
                        href="#">校园日预约购票系统</a></span>
        </div>
      </div>
    </div>
  </div>


</template>
<script setup>
import {h, ref} from 'vue'
import axios from "axios";
import {useRoute} from "vue-router";
import CardHomeComp from "@/views/CardHomeComp.vue";

const content = ref({})
const route = useRoute()
console.log(route.params.activity_id)
import {userStore} from "../store/index.js";
import {useRouter} from "vue-router";
import {ElMessage, ElMessageBox} from "element-plus";

const date = ref('2024-06-15')

const useStore = userStore();
axios.get(`/api/crud/activity/${Number(route.params.activity_id)}`).then(res => {
  const _ = res.data;

  console.log(content.value)
  content.value = _[0]
}).catch(err => {
  console.log(err)
})
const getDateStand = (date) => {
  // 获取当前日期
  const currentDate = new Date(date);

// 获取年、月、日
  const year = currentDate.getFullYear();
  const month = String(currentDate.getMonth() + 1).padStart(2, '0'); // 月份从 0 开始，因此要加 1
  const day = String(currentDate.getDate()).padStart(2, '0');

// 拼接成 yyyy-mm-dd 格式
  return `${year}-${month}-${day}`;
}
//@PathVariable Long userid, @RequestParam Long activityId, @RequestParam LocalDate date,
const handleCick = () => {
  axios.post(`/api/auth/activity/${useStore.userInfo.id}?activityId=${Number(route.params.activity_id)}&date=${date.value}`, {
    activityId: route.params.activity_id,
    currentDate: new Date().toLocaleDateString()
  }).then(res => {
    if (res.data.code === 200200) {
      ElMessageBox.alert('预约成功', '提示', {
        type: 'text',
        message: h('div', {
          class: 'flex justify-center p-4',
        }, [
          h('img', {
            src: res.data.data.imageBase64,
            alt: '预约成功'
          })
        ],)
      });
      ElMessage.success("预约成功")

    } else if (res.data.code === 200401) {
      ElMessage.error(res.data.data);
    } else {
      console.log("预约活动错误" + res.data)
    }
  }).catch(err => {
    console.log(err)
  })
}
</script>
