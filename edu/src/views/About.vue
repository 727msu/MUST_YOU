<template>
  <div class="mx-auto max-w-[80%] bg-white">
    <div class="flex flex-col justify-center py-6 px-6">
        <span
            class="w-fit text-4xl font-sans leading-relaxed text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400">校园开放日</span>
    </div>
    <div class="flex flex-col justify-center py-6 px-6">
      <div class="relative flex min-h-screen flex-col justify-center overflow-hidden bg-gray- py-6 sm:py-12">
        <div class="mx-auto max-w-screen-xl px-4 w-full">
          <h2 class="mb-4 text-center text-gray-500 font-bold text-md">(&nbsp;须先预约入校，方可预约活动，否则预约活动视为无效&nbsp;)</h2>
          <div class="grid w-full sm:grid-cols-2 md:grid-cols-2 xl:grid-cols-4  gap-3">
            <CardHomeComp/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import CardHomeComp from "../views/CardHomeComp.vue";
</script>
