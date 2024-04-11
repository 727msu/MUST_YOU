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
              <label class="text-center p-2">当前查询日期</label>
              <el-date-picker
                  class="min-w-[300px]"
                  @change="handleCalendarChange"
                  v-model="currentDate"
                  type="date"
                  format="YYYY-MM-DD"
                  :disabled-date="disabledDate"
                  value-format="YYYY-MM-DD"
                  placeholder="选择日期"
                  size="large"
              />
            </div>
            <div class="w-full overflow-x-hidden">
              <el-card shadow="hover" v-for="item in currentDateOrder" :key="item.id">

                <template #header>
                  <div class="flex justify-between">
                    <span class="text-gray-600 text-sm">{{ currentDate }} {{
                        item.startTime
                      }} - {{ item.endTime }} 活动预约</span>
                    <span>{{ item.organization }}</span>
                    <span class="text-blue-600 cursor-pointer flex items-center">入校预约二维码
                      <el-image class="w-10 h-10" :src="item.qrCode" :preview-src-list="[item.qrCode]">
                      </el-image>
                    </span>
                  </div>
                </template>
                <div class="w-full flex">
                  <span class="p-2" v-for="ac in item.activities" :key="ac.id"><img class="w-20 h-20" :src="ac.images"
                                                                                    @click="router.push({path:'/orderDetail',query:{activityId:ac.id,userId:useStore.userInfo.id,date:currentDate,title:ac.title}})"/></span>
                </div>
                <div class="w-full">
                  <el-text @click="handleClick(item)" type="info" class="cursor-pointer hover:text-blue-600">查看更多
                  </el-text>
                </div>
              </el-card>
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
  <el-dialog
      v-model="dialogVisible"
      title="查看活动详情"
      width="700"
      class="max-h-[700px] overflow-y-auto"
      destroy-on-close
  >
    <el-row v-for="tt in  currentOrderItem.activities"
            @click="router.push({path:'/orderDetail',query:{activityId:tt.id,userId:useStore.userInfo.id,date:currentDate,title:tt.title}})">
      <el-card class="w-full line-clamp-2 text-ellipsis m-2">
        <template #header>
          <div class="flex justify-between">
            <span>{{ tt.title }}</span>
            <span class="text-red-600"> ¥{{ tt.price === 0 ? '免费' : tt.price }}</span>
          </div>
        </template>
        <div class="w-full h-10 line-clamp-2 text-ellipsis">{{ tt.desc }}</div>
        <div class="cursor-pointer">
          <div class="my-5"><img :src="tt.images"/></div>
          <div class="cursor-pointer">
            <el-text type="primary">查看活动二维码</el-text>
          </div>
        </div>
      </el-card>
    </el-row>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogVisible = false">
          Confirm
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup>
import {h, ref, render, shallowRef} from "vue";
import {userStore} from "../store/index.js";
import {useRouter} from "vue-router";
import axios from "axios";
import {ElMessage} from "element-plus";

const useStore = userStore();
const router = useRouter()

const currentDate = ref('2024-06-15')

const dialogVisible = ref(false)

const currentOrderItem = ref({})

const currentDateOrder = ref([])
// @RequestParam(required = false) String username, @RequestParam(required = false) String phone
axios.get(`/api/auth/getUserOrderDetail?date=${currentDate.value}&username=${useStore.userInfo.username}&phone=${useStore.userInfo.phone}`).then(res => {
  if (res.data.code === 200200) {
    ElMessage.info("查询订单成功")
    currentDateOrder.value = res.data.data
    console.log("/auth/getUserOrder", res.data.data)

    currentDateOrder.value.forEach(item => {
      // 使用 Set 来存储已经出现过的 id
      const map = new Map();
      const arr = []
      item.activities.forEach(el => {
        if (!map.has(el.id)) {
          map.set(el.id, true);
          arr.push(el);
          return el;
        }
      })
      return item.activities = arr
    });
    console.log(currentDateOrder.value)

  } else {
    console.log(res.data)
    ElMessage.error("查询订单失败,请先预约")
  }
}).catch(err => {
  console.log(err)
})
const customPrefix = shallowRef({
  render() {
    return h('p', '当前查询的日期为: ')
  },
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
const disabledDate = (time) => {
  return getDateStand(time) < getDateStand(new Date()) || getDateStand(time) !== '2024-06-15';
}
const handleCalendarChange = () => {

}
const handleClick = (orderItem) => {
  dialogVisible.value = true
  currentOrderItem.value = orderItem
}

</script>
<style scoped>

</style>
