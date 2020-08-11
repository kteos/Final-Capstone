<template>
  <div>
        <crops-upload />
        <crops />

  </div>
</template>

<script>
import Crops from '@/components/Crops'
import CropsUpload from '@/components/CropsUpload'
export default {
components: {
        Crops,
        CropsUpload
    }
}
</script>

<style>

</style>