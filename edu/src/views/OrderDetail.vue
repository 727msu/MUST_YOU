<template>
  <div class="max-w-[80%] mx-auto">
    <div class="mx-auto  h-2"></div>
    <div class="mx-auto max-w-[80%] bg-white">

    </div>
    <div class="mx-auto  h-2"></div>

    <div class="mx-auto max-w-[80%] bg-white">
      <div class="flex flex-col justify-center px-6">
        <span
            class="w-fit text-4xl font-sans leading-relaxed text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400">查看用户订单</span>
      </div>
      <div class="flex flex-col justify-center px-6">
        <div class="flex min-h-screen justify-center overflow-hidden py-6 sm:py-12">
          <div class="mx-auto max-w-screen-xl px-4 w-full">
            <h2 class="mb-4 text-center text-gray-500 font-bold text-md"></h2>
            <div class="flex w-full justify-start py-2 px-6">
            </div>
            <div class="w-full flex flex-col justify-center">
              <div class="text-5xl flex text-gray-600 justify-center">
                {{ route.query.title }} <span class="text-xl  text-gray-400 flex items-baseline m-3"> 活动二维码</span>
              </div>
              <div class="text-4xl m-10 flex text-gray-600 justify-center">
                <el-image class="min-w-[400px] min-h-[400px]"
                          min-scale="1"
                          max-scale="10"
                          :preview-src-list="orderDetail.qrcode?[orderDetail.qrcode]:[]" :src="orderDetail.qrcode"
                          alt="活动二维码"></el-image>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="mx-auto max-w-[80%] bg-white">
      <div class="flex justify-center py-6 px-6">
        <img class="w-full min-h-10" src="/images2.png" alt="">
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
import {ref, onMounted} from 'vue'
import {useRoute, useRouter} from "vue-router";
import axios from "axios";

const router = useRouter()
const route = useRoute();


const orderDetail = ref({});
axios.get(`/api/auth/getActivityQRCode?date=${route.query.date}&activityId=${route.query.activityId}&usersId=${route.query.userId}`).then(res => {
  if (res.data.code === 200200) {
    orderDetail.value = res.data.data
    console.log("/api/auth/getActivityQRCode", orderDetail.value)

  }
}).catch(err => {
  console.log(err)
})


</script>


