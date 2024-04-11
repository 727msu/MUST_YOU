<template>
  <div class="max-w-[80%] mx-auto">
    <div class="mx-auto  h-2"></div>
    <div class="mx-auto max-w-[80%] bg-white">
      <div class="flex justify-center py-6 px-6">
        <img class="w-full min-h-10" src="/images2.png" alt="">
      </div>
    </div>
    <div class="mx-auto  h-2"></div>

    <div class="mx-auto max-w-[80%] bg-white">
      <div class="flex flex-col justify-center px-6">
        <span
            class="w-fit text-4xl font-sans leading-relaxed text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400">预约入校</span>
      </div>
      <div class="flex flex-col justify-center px-6">
        <div class="flex min-h-screen justify-center overflow-hidden py-6 sm:py-12">
          <div class="mx-auto max-w-screen-xl px-4 w-full">
            <div class="grid w-full gap-3">
              <div class="w-full">
                <div class="p-4  bg-white rounded-lg border shadow-md sm:p-8 ">
                  <div class="flex justify-between items-center mb-4">
                    <h3 class="text-xl font-bold leading-none text-gray-900 ">{{ date }} 预约入校</h3>
                  </div>
                  <div class="flow-root">
                    <ul role="list" class="divide-y divide-gray-200 ">
                      <li class="py-3 sm:py-4 hover:bg-gray-200 px-2" v-for="item in timeSlotNumber" :key="item"
                          :class="item === timeSlotNumber.length?'timeSlotNumber':''"
                          @click="handleOpen(item)"
                      >
                        <div class="flex items-center space-x-4 cursor-pointer">
                          <div class="flex-shrink-0">
                            <img
                                v-if="item.value<1000&& (date==='2024-06-15')"
                                class="w-8 h-8 rounded-full"
                                :src="OK" alt="Neil image">
                            <img v-else class="w-8 h-8 rounded-full"
                                 :src="NotOK" alt="Neil image">
                          </div>
                          <div class="flex-1 min-w-0">
                            <p class="text-sm font-medium text-gray-900 truncate ">
                              {{ item.label }}
                            </p>
                            <p v-if="item.value<1000&& (date==='2024-06-15')" class="text-sm text-gray-300 truncate ">
                              点我立即预约
                            </p>
                            <p v-else class="text-sm text-gray-300 truncate ">
                              预约未开启哦
                            </p>
                          </div>
                          <div class="inline-flex items-center text-base font-semibold text-gray-900 ">
                            {{ item.value }} / 1000
                          </div>

                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="h-5"></div>
            <div class="">
              <div class="text-gray-700">选择其他的日期</div>
              <el-date-picker
                  @change="handleCalendarChange"
                  v-model="date"
                  type="date"
                  format="YYYY-MM-DD"
                  :disabled-date="disabledDate"
                  value-format="YYYY-MM-DD"
                  placeholder="选择日期"
                  size="large"
              />
            </div>
          </div>
        </div>
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
      title="提示框"
      width="500"
  >
    <span>确定预约  {{ date }}日  {{ currentTimeSlot }}段</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="handleBooking">
          Confirm
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup>
import OK from '../assets/notOK.svg';
import NotOK from '../assets/ok.svg';
import {h, ref} from "vue";
import axios from "axios";
import {ElMessage, ElMessageBox} from 'element-plus'
import {userStore} from "../store/index.js";

const dialogVisible = ref(false)

const timeSlotNumber = ref([])
const useStore = userStore()
const date = ref("2024-06-15")
const currentTimeSlot = ref("");

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
axios.get(`/api/auth/getGroup?date=2024-06-15`).then((res) => {
  if (res.data.code === 200200) {
    const __ = res.data.data;
    const arr = new Array(6).fill(0);

    const arr2 = []

    for (let i = 0; i < 5; i++) {
      if (__[i].timeSlot === undefined || __[i].timeSlot === null || !__[i]) {
        arr[i] = 0;
        continue;
      }
      arr[__[i].timeSlot] = __[i].number;
    }
    console.log(arr)
    for (let i = 1; i <= 5; i++) {
      if (i === 1) {
        arr2.push({
          label: "10:00-11:30",
          value: arr[i]
        })
      } else if (i === 2) {
        arr2.push({
          label: "11:30-13:00",
          value: arr[i]
        })
      } else if (i === 3) {
        arr2.push({
          label: "13:00-14:30",
          value: arr[i]
        })
      } else if (i === 4) {
        arr2.push({
          label: "14:30-16:00",
          value: arr[i]
        })
      } else if (i === 5) {
        arr2.push({
          label: "16:00-17:30",
          value: arr[i]
        })
      }
    }

    timeSlotNumber.value = arr2;
  }
})

const init = () => {
  console.log("init 被执行")
  axios.get(`/api/auth/getGroup?date=2024-06-15`).then((res) => {
    if (res.data.code === 200200) {
      const __ = res.data.data;
      const arr = new Array(6).fill(0);

      const arr2 = []

      for (let i = 0; i < 5; i++) {
        if (__[i].timeSlot === undefined || __[i].timeSlot === null || !__[i]) {
          arr[i] = 0;
          continue;
        }
        arr[__[i].timeSlot] = __[i].number;
      }
      console.log(arr)
      for (let i = 1; i <= 5; i++) {
        if (i === 1) {
          arr2.push({
            label: "10:00-11:30",
            value: arr[i]
          })
        } else if (i === 2) {
          arr2.push({
            label: "11:30-13:00",
            value: arr[i]
          })
        } else if (i === 3) {
          arr2.push({
            label: "13:00-14:30",
            value: arr[i]
          })
        } else if (i === 4) {
          arr2.push({
            label: "14:30-16:00",
            value: arr[i]
          })
        } else if (i === 5) {
          arr2.push({
            label: "16:00-17:30",
            value: arr[i]
          })
        }
      }

      timeSlotNumber.value = arr2;
    }
  })
}
const handleOpen = (item) => {
  if (item.value >= 1000) {
    ElMessageBox.alert('预约已满', '提示', {
      confirmButtonText: '确定',
      type: 'warning'
    });
    return;
  }
  currentTimeSlot.value = item.label;
  dialogVisible.value = true;
}

const handleBooking = () => {
  const [starTime, endTime] = currentTimeSlot.value.split('-')
  axios.post(`/api/auth/booking/${useStore.userInfo.id}?starTime=${starTime}&endTime=${endTime}&date=${date.value}`, {
    date: date.value,
    timeSlot: currentTimeSlot.value
  }).then((res) => {
    if (res.data.code === 200200) {

      //{
      //   "msg": "成功预约",
      //       "code": 200200,
      //       "data": {
      //     "imageBase64": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANwAAADcAQAAAAAzIfIsAAABkUlEQVR4Xu2WW5KDUAhE2QH73yU7YDiNqdGk8tl+zEiZ6OVoFTaPa/R3q3j3nOyB/UDZA/sPwoqIrqqojDqWdtigHl8BWPphyZHV2VmK7BbIkd17cROcWBohmpDugPhzMjyxSIuPrBig0vxrH9VngLLIrPmhxGFWOBGMP1iQcswOG4cyneJN5t1wnKN3UlhKwvGIE6ptgz7KCW3Ot8BZEotaiOpatxMi/MSiacEp3rPigKHOTf1LeD+c2iKORn4Jv71khU3bMhsFVgY3JKAgzSM8SbgIb4K9Mz9o3Z0cfjivnppPk2jcQmaI4mokhTZhHc9YIcLrpP7dqNwwcCabK4KwugGig2ZFMS0UnRsid6uom1I7qBXyymzlnLbaTiLYIG20jcSMjMvAsEGNRI1i8i2vHa7zdU32zVBX+wE6+Z67+lzUHqiPFQJhxTfMRXgT5JgpwU0qbJxuqHcvFkzI65ByQlpIG3u9KswPd0DRxRLCDuETDlEFm6vK2wxVYM12t5/Aly7zwC/2wH6g7IH9j+APtSFK7uOGGvEAAAAASUVORK5CYII="
      //   }
      // }
      // h('img', {
      //   src: res.data.data.imageBase64,
      //   alt: '预约成功'
      // }
      ElMessageBox.alert('预约成功', '提示', {
        type: 'success',
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
      init()
    } else {
      ElMessageBox.alert('预约失败', '提示', {
        type: 'error'
      });
    }
  })
}

const disabledDate = (time) => {
  return getDateStand(time) < getDateStand(new Date()) || getDateStand(time) !== '2024-06-15';
}

const handleCalendarChange = () => {
  console.log(date.value)
}
</script>
