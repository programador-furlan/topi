<template>
  <div class="container">
    <div class="content">
      <slot />
    </div>
  </div>
</template>
<script>
export default {
  name: "default-layout",
};
</script>
<style lang="scss" scoped>
.container {
  margin: 0 auto;
  padding: 15px;
  .content {
    // box-shadow: 1px 1px 10px 1px black;
  }
}
</style>
