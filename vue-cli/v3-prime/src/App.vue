<template>
  <div>
    <Toast />
    <MegaMenu :model="items" orientation="vertical" style="height: 97vh;" />
    <!-- <MegaMenu :model="hoItems" /> -->
  </div>
</template>

<script>
import menuItems from '@/data/menu'

export default {
  data() {
    return {
      items : menuItems,
      hoItems : menuItems
    }
  },
  created() {
  },
  methods: {
    buttonClick() {
      this.$toast.add({severity:'success', summary: 'Success Message', detail:'Order submitted', life: 3000})
    }
  }
}
</script>

<style>
</style>
