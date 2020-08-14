<template>
  <div>
      <button v-on:click.prevent="testEmail">Send notification</button>
  </div>
</template>

<script>
import EmailService from '@/services/EmailService'

export default {
    name: "email-test",
    methods: {
        testEmail(){
            EmailService.sendTestEmail().then((response) => {
                if(response.status == 200){
                    console.log('finally');
                }
            })
        }
    }
}
</script>

<style>

</style>