<template>
  <div class="client-layout">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'ClientLayout'
}
</script>

<style lang="scss" scoped>
.client-layout {
  min-height: 100vh;
}
</style> 