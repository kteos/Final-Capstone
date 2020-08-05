<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <file-input/>
  </div>
</template>

<script>
import FileInput from '@/components/FileInput'

export default {
  name: "home",
  components: {
    FileInput
  }
};
</script>
